package patientqueue;

import model.Patient;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class PatientPriorityQueueImpl implements PatientQueue {
    private final PriorityQueue<Patient> queue =
            new PriorityQueue<>((p1, p2) -> {
                List<String> priorities = Arrays.asList("Not Specified", "Low", "Medium", "High", "Urgent");
                int p1Priority = priorities.indexOf(p1.getPriority());
                int p2Priority = priorities.indexOf(p2.getPriority());

                if (p2Priority - p1Priority != 0) {
                    return p2Priority - p1Priority;
                }

                return (int) (p2.getTime().toEpochMilli() - p1.getTime().toEpochMilli());
            });


    /**
     * Method to add patient in the Priority Queue
     *
     * @param patient Patient information
     */
    @Override
    public void addPatient(Patient patient) {
        queue.add(patient);
    }

    /**
     * Method to find patient with the highest priority
     *
     * @return Patient
     */
    @Override
    public Patient findMaxPriorityPatient() {
        return null;
    }

    /**
     * Delete a patient by ID
     *
     * @param id Unique ID of a patient.
     */
    @Override
    public void deletePatientById(int id) {
        ListIterator<Patient> iterator = (ListIterator<Patient>) queue.iterator();
        while (iterator.hasNext()) {
            Patient next = iterator.next();
            if (next.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

    /**
     * Find details of a patient using a unique id.
     *
     * @param id Unique ID of a patient.
     */
    @Override
    public Patient findPatientById(int id) {
        for (Patient patient: queue) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Display the list of all patient in the system
     */
    @Override
    public void displayAll() {
        for (Patient nextPatient : queue) {
            System.out.println(nextPatient);
        }
    }

}
