package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.sun.rowset.internal.Row;
import model.Patient;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.net.URL;
import java.util.*;

public class ExcelUtil {
    private static List<Patient> patientList;

    public List<Patient> getFromExcel() throws IOException {
        try {
            if (patientList != null) {
                return patientList;
            }

            patientList = new ArrayList<>();
            URL resource = this.getClass().getClassLoader().getResource("Patient-Info.xlsx");
            new File(resource.toURI());
            FileInputStream file = new FileInputStream(new File(resource.toURI()));
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Patient transaction = new Patient();
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                transaction.setTransactionId(cellIterator.next().getStringCellValue());
                transaction.setAccountNumber(cellIterator.next().getStringCellValue());
                transaction.setDate(cellIterator.next().getDateCellValue());
                Cell cell = cellIterator.next();
                if (cell.getCellType() == CellType.STRING) {
                    transaction.setTransactionDetails(cell.getStringCellValue());
                } else {
                    transaction.setTransactionDetails(cell.getNumericCellValue() + "");
                }

                transaction.setWithdrawalAmount(cellIterator.next().getNumericCellValue());
                transaction.setDepositAmount(cellIterator.next().getNumericCellValue());
                transaction.setBalance(cellIterator.next().getNumericCellValue());
                transaction.setStatus(cellIterator.next().getStringCellValue());

                patientList.add(transaction);
            }
            file.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return patientList;
    }
}
