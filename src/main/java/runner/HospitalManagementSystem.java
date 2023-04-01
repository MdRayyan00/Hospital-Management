package runner;

import model.Patient;
import patientqueue.PatientPriorityQueueImpl;
import patientqueue.PatientQueue;
import patientqueue.PatientQueueImpl;
import util.ExcelUtil;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

/**
 * Main class to implement priority queue using heaps.
 * Perform various actions on the information of patients using the patient ID, date and time.
 */
public class HospitalManagementSystem {
    public static void main(String[] args) throws IOException {
        int[] countSizes = new int[]{5000, 30000, 116000};

        for (int countSize : countSizes) {
            PatientQueue patientPriorityQueue = new PatientPriorityQueueImpl();
            PatientQueue patientListQueue = new PatientQueueImpl();
            List<Patient> patients = new ExcelUtil().getFromExcel();

            System.out.println("Hospital management workflow for " + countSize + " input size using priority queue.");
            hospitalManagementWorkflow(countSize, patientPriorityQueue, patients);

            System.out.println("Hospital management workflow for " + countSize + " input size using linked list as queue.");
            hospitalManagementWorkflow(countSize, patientListQueue, patients);

            System.out.println("-----------------------------");
        }
    }

    /**
     * Method to find and delete patient information from queue
     *
     * @param patientQueue Patient information
     */


    private static void findAndDeletePatient(PatientQueue patientQueue) {
        Instant startTime = Instant.now();
        patientQueue.findPatientById("PatientID 1");
        patientQueue.deletePatientById("PatientID 1");
        Instant endTime = Instant.now();

        System.out.println("Total Time to find and delete " + (endTime.toEpochMilli() - startTime.toEpochMilli()) + "ms");

    }

    /**
     * Method defining the hospital management workflow
     *
     * @param countSize Data break-points
     * @param patientQueue Patients in Queue
     * @param patients
     */

    private static void hospitalManagementWorkflow(int countSize, PatientQueue patientQueue, List<Patient> patients) {
        addPatients(countSize, patientQueue, patients);

        displayAllPatients(patientQueue);

        findAndDeletePatient(patientQueue);

        treatAllPatientByPriority(patientQueue);
    }

    /**
     * Treating patients by the order of highest priority
     *
     * @param patientQueue patients in queue
     */
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

    /**
     * Method to display all patients in the queue and calculate time taken
     *
     * @param patientQueue patients in queue
     */
    private static void displayAllPatients(PatientQueue patientQueue) {
        Instant startTime = Instant.now();
        patientQueue.displayAll();
        Instant endTime = Instant.now();

        System.out.println("Total Time to display all patients " + (endTime.toEpochMilli() - startTime.toEpochMilli()) + "ms");
    }

    /**
     * Method to add patients in the queue and calculate the time taken
     *
     * @param countSize
     * @param patientQueue patients in queue
     * @param patients
     */


    private static void addPatients(int countSize, PatientQueue patientQueue, List<Patient> patients) {
        Instant startTime = Instant.now();
        for (int i = 0; i < countSize; i++) {
            patientQueue.addPatient(patients.get(i));
        }
        Instant endTime = Instant.now();

        System.out.println("Total Time taken to insert " + countSize + " " + (endTime.toEpochMilli() - startTime.toEpochMilli()) + "ms");
    }


}