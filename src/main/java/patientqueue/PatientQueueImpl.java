package patientqueue;

import model.Patient;

import java.util.*;

public class PatientQueueImpl implements PatientQueue {

    Queue<Patient> queue = new LinkedList<>();

    /**
     * Method to add patient in the queue
     * @param patient Patient information
     */

    @Override
    public void addPatient(Patient patient) {
        queue.add(patient);
        queue.sort(Comparator.comparingInt(Patient::getPriority));
    }

    /**
     * Method to find patient with the highest priority
     * @return Patient
     */
    @Override
    public Patient findMaxPriorityPatient() {
        return queue.peek();
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
        for (Patient patient: queue) {
            System.out.println(patient);
        }
    }
}
