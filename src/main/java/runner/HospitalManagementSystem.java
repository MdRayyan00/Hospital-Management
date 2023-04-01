package runner;

import model.Patient;
import patientqueue.PatientPriorityQueueImpl;
import patientqueue.PatientQueue;
import util.ExcelUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HospitalManagementSystem {
    public static void main(String[] args) throws IOException {
        PatientQueue patientQueue = new PatientPriorityQueueImpl();

        List<Patient> patients = new ExcelUtil().getFromExcel();
        for (Patient patient : patients) {
            patientQueue.addPatient(patient);
        }

        patientQueue.displayAll();
        System.out.println("------------------------------------");
        List<String> ids = Arrays.asList("PatientID 1", "PatientID 9", "PatientID 20", "PatientID 80", "PatientID 100",
                "PatientID 300", "PatientID 400", "PatientID 5000", "PatientID 100000", "116507");

        for (String id: ids) {
            Patient patient = patientQueue.findPatientById(id);
            System.out.println(patient);
            patientQueue.deletePatientById(id);
        }
        System.out.println("------------------------------------");

        Patient maxPriorityPatient = patientQueue.findMaxPriorityPatient();
        while (maxPriorityPatient != null) {
            System.out.println(maxPriorityPatient);
            maxPriorityPatient = patientQueue.findMaxPriorityPatient();
        }


    }
}
