import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;


public class OpenCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "src/main/resources/users.csv";

    public static void main(String[] args) throws IOException {
            try (
                    Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                    ) {
                     CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                             .withType(CSVUser.class)
                             .withIgnoreLeadingWhiteSpace(true)
                             .build();
                     Iterator csvUserIterator = csvToBean.iterator();

                    while (csvUserIterator.hasNext()) {
                        CSVUser csvUser = (CSVUser) csvUserIterator.next();
                        System.out.println("Name : " + csvUser.getName());
                        System.out.println("Email : " + csvUser.getEmail());
                        System.out.println("Phone : " + csvUser.getPhoneNo());
                        System.out.println("Country : " + csvUser.getCountry());
                        System.out.println("==========================");

                    }
            }
        }
    }

