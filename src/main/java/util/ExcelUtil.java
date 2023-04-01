package util;

import model.Patient;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {
    private static List<Patient> patientList;

    /**
     * Reading patient dataset from excel file.
     */
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
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Patient patient = new Patient();
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                patient.setId(cellIterator.next().getStringCellValue());
                patient.setName(cellIterator.next().getStringCellValue());
                patient.setPriority(cellIterator.next().getStringCellValue());
                Date date = cellIterator.next().getDateCellValue();
                patient.setTime(date.toInstant());
                patientList.add(patient);
            }
            file.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return patientList;
    }
}
