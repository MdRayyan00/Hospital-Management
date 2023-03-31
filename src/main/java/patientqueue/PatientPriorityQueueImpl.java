package patientqueue;

import model.Patient;

import java.util.ListIterator;
import java.util.PriorityQueue;

public class PatientPriorityQueueImpl implements PatientQueue {

    private final PriorityQueue<Patient> queue =
            new PriorityQueue<>((p1, p2) -> {
                return p2.getPriority() - p1.getPriority();
            });

    @Override
    public void addPatient(Patient patient) {
        queue.add(patient);
    }

    @Override
    public Patient findMaxPriorityPatient() {
        return null;
    }

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

    @Override
    public void findPatientById(int id) {

    }

    @Override
    public void displayAll() {
        for (Patient nextPatient : queue) {
            System.out.println(nextPatient);
        }
    }

}
