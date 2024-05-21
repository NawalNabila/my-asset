package com.nabilla.myasset.service.impl;

import com.nabilla.myasset.model.Asset;
import com.nabilla.myasset.repository.AssetRepository;
import com.nabilla.myasset.service.AssetService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    AssetRepository repo;

    @Override
    @Transactional (rollbackOn = SQLException.class)
    public void save(MultipartFile file) throws IOException, CsvException {
        String FILE_PATH = "/Users/hanryvernando/Myb/";
        CSVReader reader = new CSVReader(new FileReader(FILE_PATH + file.getOriginalFilename()));

        List<String[]> rows = reader.readAll();

        List<Asset> assets = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        for (String[] row : rows) {
            Date period = null;
            try {
                period = formatter.parse(row[7]);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            Asset ast = new Asset(
                        row[0],
                        row[1],
                        row[2],
                        row[3],
                        Float.parseFloat(row[4]),
                        Float.parseFloat(row[5]),
                        Float.parseFloat(row[6]),
                        period
                );

            assets.add(ast);
        }
        repo.saveAll(assets);
    }

    @Override
    public List<Asset> getList() {
        return repo.findAll();
    }
}
