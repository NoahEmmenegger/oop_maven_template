package ch.hslu.SW12;

import ch.hslu.SW12.TemperaturVerlauf.Temperatur;
import ch.hslu.SW12.TemperaturVerlauf.TemperaturVerlauf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSV {
    private static final Logger LOG = LoggerFactory.getLogger(StreamTest.class);

    public static void main(String[] args) {
        readFromCSV("src/main/java/ch/hslu/SW12/netatmo-export-202301-202304.csv");
    }

    public static void readFromCSV(final String file) {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] values = line.split(";");
                LocalDateTime timestamp =
                        LocalDateTime.parse(values[1],
                                DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
                LOG.info(timestamp.toString());

                temperaturVerlauf.add(Temperatur.createFromKelvin(Float.parseFloat(values[3])));
                line = bufferedReader.readLine();
            }
            LOG.info(temperaturVerlauf.toString());
        } catch (IOException e) {
            LOG.error("Error reading from file", e);
        }
    }
}
