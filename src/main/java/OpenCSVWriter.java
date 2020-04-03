import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {
    private static final String CSV_FILE_PATH = "src/main/resources/users.csv";

    public static void main(String[] args) throws IOException {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_FILE_PATH))) {
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            List<CSVUser> csvUserLists = new ArrayList<>();
            csvUserLists.add(new CSVUser("Elon Musk", "ElawnMuskmelon@rocketmail.com", "+91 912121212", "USA"));
            csvUserLists.add(new CSVUser("Jeff Bezos", "Jeff Bezos@gmai.com", "+91 7812727272", "United States"));
            beanToCsv.write(csvUserLists);
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
