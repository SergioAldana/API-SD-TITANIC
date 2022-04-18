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
    static String[] HEADERs = {"Id", "Pclass", "Survived", "Name", "Sex", "Age",
            "Sibsp", "Parch", "Ticket", "Fare", "Cabin", "Embarked", "Boat", "Body", "Home_dest"};

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
                        Long.parseLong(csvRecord.get("Id")),
                        Long.parseLong(csvRecord.get("Pclass")),
                        Long.parseLong(csvRecord.get("Survived")),
                        csvRecord.get("Name"),
                        csvRecord.get("Sex"),
                        Double.parseDouble(csvRecord.get("Age")),
                        Long.parseLong(csvRecord.get("Sibsp")),
                        Long.parseLong(csvRecord.get("Parch")),
                        Long.parseLong(csvRecord.get("Ticket")),
                        Double.parseDouble(csvRecord.get("Fare")),
                        csvRecord.get("Cabin"),
                        csvRecord.get("Embarked"),
                        csvRecord.get("Boat"),
                        csvRecord.get("Body"),
                        csvRecord.get("Home_dest")
                );
                pasajeros.add(pasajero);

            }
            return pasajeros;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
