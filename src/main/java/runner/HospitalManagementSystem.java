package runner;

import model.Patient;
import patientqueue.PatientPriorityQueueImpl;
import patientqueue.PatientQueue;
import util.ExcelUtil;

import java.io.IOException;
import java.util.List;

public class HospitalManagementSystem {
    public static void main(String[] args) throws IOException {
        PatientQueue patientQueue = new PatientPriorityQueueImpl();

        List<Patient> patients = new ExcelUtil().getFromExcel();
        for (Patient patient : patients) {
            patientQueue.addPatient(patient);
        }

       // patientQueue.displayAll();

        Patient maxPriorityPatient = patientQueue.findMaxPriorityPatient();
        while (maxPriorityPatient != null) {
            System.out.println(maxPriorityPatient);
            maxPriorityPatient = patientQueue.findMaxPriorityPatient();
        }

    }
}
