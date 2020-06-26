
import org.apache.poi.util.SystemOutLogger;

import java.util.List;

public class DataReaders {

    public static void main(String[] args) {
        readExcel();
    }

    public static void readCSV()
    {
        String filename = "/home/cc1/Documents/github/cc19/LearningSelenium/original.csv";
        List<String[]> records = Util.csv.get(filename);
        for (String[] record:records) {
            for (String field:record)
            {
                System.out.println(field);
            }
        }
    }

    public static void readExcel() {
        String filename = "/home/cc1/Documents/github/cc19/LearningSelenium/original.xls";
        String[][] data = Util.Excel.get(filename);

        for (String[] record:data)
        {
            System.out.println(record[0]);
            System.out.println(record[1]);
            System.out.println(record[2]);
        }
    }
}
