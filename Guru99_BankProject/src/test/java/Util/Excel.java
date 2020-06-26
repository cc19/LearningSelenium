package Util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Excel {

    public static String[][] get(String filename)
    {
        String[][] data = null;
        File file = new File(filename);

        try{
            //Reading excel workbook and worksheet
            FileInputStream xfile= new FileInputStream(file);
            HSSFWorkbook xlwb = new HSSFWorkbook(xfile);
            HSSFSheet xlsh = xlwb.getSheetAt(0);

            //Get the number of rows and columns
            int numRows = xlsh.getLastRowNum() +1;
            int numCols = xlsh.getRow(0).getLastCellNum() - 1;

            //Create a datatable with rows and cols num
            data = new String[numRows][numCols];

            //For each row, create a HSSFRow and iterate through the columns
            //For each column, create a HSSFCell to grab the value at the specified cell (i,j)
            for (int i=0; i< numRows; i++) {
                HSSFRow hrow = xlsh.getRow(i);
                for (int j=0; j<numCols;j++) {
                    HSSFCell hcell = hrow.getCell(j);
                    data[i][j] = hcell.toString();
                }
            }
        } catch(IOException io) {
            System.out.println("Error in file handling" + io.toString());
        }
        return data;
    }
}
