package patientqueue;

import model.Patient;

import java.util.ListIterator;
import java.util.PriorityQueue;

public class PatientPriorityQueueImpl implements PatientQueue {

    private final PriorityQueue<Patient> queue =
            new PriorityQueue<>((p1, p2) -> {
                return p2.getPriority() - p1.getPriority();
            });

    /**
     * Method to add patient in the Priority Queue
     * @param patient Patient information
     */
    @Override
    public void addPatient(Patient patient) {
        queue.add(patient);
    }

    /**
     * Method to find patient with the highest priority
     * @return Patient
     */
    @Override
    public Patient findMaxPriorityPatient() {
        return null;
    }

    /**
     * Delete a patient by ID
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
     * @param id Unique ID of a patient.
     */
    @Override
    public void findPatientById(int id) {

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
