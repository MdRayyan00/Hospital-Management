package patientqueue;

import model.Patient;

import java.util.*;

public class PatientPriorityQueueImpl implements PatientQueue {
    private final PriorityQueue<Patient> queue =
            new PriorityQueue<>((p1, p2) -> {
                List<String> priorities = Arrays.asList("Low", "Medium", "High", "Urgent");
                int p1Priority = priorities.indexOf(p1.getPriority());
                int p2Priority = priorities.indexOf(p2.getPriority());

                if (p2Priority - p1Priority != 0) {
                    return p2Priority - p1Priority;
                }

                long t2 = p2.getTime().toEpochMilli();
                long t1 = p1.getTime().toEpochMilli();

                return (int) (t2 - t1);
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
            if (Objects.equals(next.getId(), id)) {
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
            if (Objects.equals(patient.getId(), id)) {
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
            // avoiding print as the input size is quite big and important messages of time capture are ignored.
            //System.out.println(nextPatient);
        }
    }

}
