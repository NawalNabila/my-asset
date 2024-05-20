package com.nabilla.myasset.service.impl;

import com.nabilla.myasset.model.Asset;
import com.nabilla.myasset.model.User;
import com.nabilla.myasset.repository.AssetRepository;
import com.nabilla.myasset.service.AssetService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    AssetRepository repo;

    @Override
    public void saveCSVData(MultipartFile file) throws IOException, CsvException {
        String FILE_PATH = "/Users/hanryvernando/Myb/";
        CSVReader reader = new CSVReader(new FileReader(FILE_PATH + file.getOriginalFilename()));

        List<String[]> rows = reader.readAll();

        List<Asset> assets = new ArrayList<>();

        LocalDateTime createdDate = LocalDateTime.now();

        for (String[] row : rows) {
            System.out.println(row[0] + "," + row[1] + "," + row[2] + "," + row[3]);

            Asset ast = new Asset(
                        row[0],
                        row[1],
                        row[2],
                        row[3],
                        Float.parseFloat(row[4]),
                        Float.parseFloat(row[5]),
                        Float.parseFloat(row[6])
                );
//            ast.setCustomerName(row[0]);
//            ast.setCustomerAddress(row[1]);
//            ast.setAssetCategory(row[2]);
//            ast.setCurrency(row[3]);
//            ast.setGrossInterest(Float.parseFloat(row[4]));
//            ast.setTax(Float.parseFloat(row[5]));
//            ast.setYearEndBalance(Float.parseFloat(row[6]));
//            ast.setPeriod(LocalDate.parse(row[7]));
//            ast.setCreatedDate(createdDate);
//            ast.setUpdatedDate(createdDate);

            assets.add(ast);
        }
        repo.saveAll(assets);
        System.out.println("Berhasil Add ke Database");
    }

    @Override
    public List<Asset> getAllAssets() {
        return repo.findAll();
    }
}
