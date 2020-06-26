package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csv {

    public static List<String[]> get(String filename) {
        List<String[]> data = new ArrayList<String[]>();
        String testRow;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((testRow = br.readLine()) != null) {
                String[] line = testRow.split(",");
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException io) {
            System.out.println("Cannot read file");
        }
        return data;
    }
}
