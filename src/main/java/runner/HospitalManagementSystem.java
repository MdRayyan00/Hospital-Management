package runner;

import model.Patient;
import patientqueue.PatientPriorityQueueImpl;
import patientqueue.PatientQueue;
import patientqueue.PatientQueueImpl;
import util.ExcelUtil;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class HospitalManagementSystem {
    public static void main(String[] args) throws IOException {
        int[] countSizes = new int[]{5000, 30000, 116000};

        for (int countSize : countSizes) {
            PatientQueue patientPriorityQueue = new PatientPriorityQueueImpl();
            PatientQueue patientListQueue = new PatientQueueImpl();
            List<Patient> patients = new ExcelUtil().getFromExcel();

            System.out.println("Hospital management workflow for " + countSize + " input size using priority queue.");
            hostpitalManagementWorkflow(countSize, patientPriorityQueue, patients);

            System.out.println("Hospital management workflow for " + countSize + " input size using linked list as queue.");
            hostpitalManagementWorkflow(countSize, patientListQueue, patients);

            System.out.println("-----------------------------");
        }
    }

    private static void hostpitalManagementWorkflow(int countSize, PatientQueue patientQueue, List<Patient> patients) {
        addPatients(countSize, patientQueue, patients);

        displayAllPatients(patientQueue);

        treatAllPatientByPriority(patientQueue);
    }

    private static void treatAllPatientByPriority(PatientQueue patientQueue) {
        Instant startTime = Instant.now();

        Patient maxPriorityPatient = patientQueue.findMaxPriorityPatient();
        while (maxPriorityPatient != null) {
            //System.out.println(maxPriorityPatient);
            maxPriorityPatient = patientQueue.findMaxPriorityPatient();
        }

        Instant endTime = Instant.now();

        System.out.println("Total Time to treat all patients " + (endTime.toEpochMilli() - startTime.toEpochMilli()) + "ms");
    }

    private static void displayAllPatients(PatientQueue patientQueue) {
        Instant startTime = Instant.now();
        patientQueue.displayAll();
        Instant endTime = Instant.now();

        System.out.println("Total Time to display all patients " + (endTime.toEpochMilli() - startTime.toEpochMilli()) + "ms");
    }

    private static void addPatients(int countSize, PatientQueue patientQueue, List<Patient> patients) {
        Instant startTime = Instant.now();
        for (int i = 0; i < countSize; i++) {
            patientQueue.addPatient(patients.get(i));
        }
        Instant endTime = Instant.now();

        System.out.println("Total Time taken to insert " + countSize + " " + (endTime.toEpochMilli() - startTime.toEpochMilli()) + "ms");
    }


}