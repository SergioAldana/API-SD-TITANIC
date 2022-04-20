package co.edu.utadeo.api_sd_titanic.helper;

import co.edu.utadeo.api_sd_titanic.modelEntity.Pasajero;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HelperCSV {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Id", "Name", "Pclass", "Sex", "Age",
            "Siblings_SpousesAboard", "Parents_ChildrenAboard", "Fare", "Survived"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Pasajero> csvToPassengers(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Pasajero> pasajeros = new ArrayList<Pasajero>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Pasajero pasajero = new Pasajero(
                        csvRecord.get("Name"),
                        Long.parseLong(csvRecord.get("Pclass")),
                        csvRecord.get("Sex"),
                        Double.parseDouble(csvRecord.get("Age")),
                        Long.parseLong(csvRecord.get("Siblings_SpousesAboard")),
                        Long.parseLong(csvRecord.get("Parents_ChildrenAboard")),
                        Double.parseDouble(csvRecord.get("Fare")),
                        Long.parseLong(csvRecord.get("Survived"))
                );
                pasajeros.add(pasajero);

            }
            return pasajeros;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
