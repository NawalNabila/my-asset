package com.nabilla.myasset.service;

import com.nabilla.myasset.model.Asset;
import com.opencsv.exceptions.CsvException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AssetService {

    public void saveCSVData(MultipartFile file) throws IOException, CsvException;
    public List<Asset> getAllAssets();
}
