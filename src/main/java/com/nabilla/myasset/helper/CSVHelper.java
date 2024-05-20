package com.nabilla.myasset.helper;

import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

//    public static List<Asset> readCSVData(InputStream in) {
//        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
//             CSVParser csvParser = new CSVParser(fileReader,
//                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
//
//            List<Asset> assets = new ArrayList<Asset>();
//
//            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//
//            LocalDateTime createdDate = LocalDateTime.now();
//
//            for (CSVRecord csvRecord : csvRecords) {
//                Asset asset = new Asset(
//                        csvRecord.get("customerName"),
//                        csvRecord.get("customerAddress"),
//                        csvRecord.get("assetCategory"),
//                        csvRecord.get("currency"),
//                        Float.parseFloat(csvRecord.get("grossInterest")),
//                        Float.parseFloat(csvRecord.get("tax")),
//                        Float.parseFloat(csvRecord.get("yearEndBalance")),
//                        LocalDate.parse(csvRecord.get("period")),
//                        createdDate,
//                        createdDate
//                );
//                assets.add(asset);
//            }
//
//            return assets;
//        } catch (IOException e) {
//            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
//        }
//    }

}
