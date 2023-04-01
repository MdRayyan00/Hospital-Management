package patientqueue;

import model.Patient;

import java.util.*;

public class PatientQueueImpl implements PatientQueue {

    Queue<Patient> queue = new LinkedList<>();

    /**
     * Method to add patient in the queue
     *
     * @param patient Patient information
     */

    @Override
    public void addPatient(Patient patient) {
        queue.add(patient);
        ((LinkedList) queue).sort((p1, p2) -> {
            List<String> priorities = Arrays.asList("Low", "Medium", "High", "Urgent");
            int p1Priority = priorities.indexOf(((Patient) (p1)).getPriority());
            int p2Priority = priorities.indexOf(((Patient) p2).getPriority());

            if (p2Priority - p1Priority != 0) {
                return p2Priority - p1Priority;
            }

            long t2 = ((Patient) p2).getTime().toEpochMilli();
            long t1 = ((Patient) (p1)).getTime().toEpochMilli();

            return (int) (t2 - t1);
        });
    }

    /**
     * Method to find patient with the highest priority
     *
     * @return Patient
     */
    @Override
    public Patient findMaxPriorityPatient() {
        return queue.poll();
    }

    /**
     * Delete a patient by ID
     *
     * @param id Unique ID of a patient.
     */
    @Override
    public void deletePatientById(String id) {
        ListIterator<Patient> iterator = (ListIterator<Patient>) queue.iterator();
        while (iterator.hasNext()) {
            Patient next = iterator.next();
            if (next.getId().equals(id)) {
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
    public Patient findPatientById(String id) {
        for (Patient patient : queue) {
            if (patient.getId().equals(id)) {
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
        for (Patient patient : queue) {
            //System.out.println(patient);
        }
    }
}
