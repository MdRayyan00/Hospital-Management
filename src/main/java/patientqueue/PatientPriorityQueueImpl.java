package patientqueue;

import model.Patient;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class PatientPriorityQueueImpl implements PatientPriorityQueue {

    private final PriorityQueue<Patient> queue;

    //Max Heap
    public PatientPriorityQueueImpl() {
        queue = new PriorityQueue<>((p1, p2) -> p2.getPriority() - p1.getPriority());
    }


    @Override
    public void insert(Patient patient) {
        queue.offer(patient);
    }

    @Override
    public Patient findMin() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        PriorityQueue<Patient> reverseQueue = new PriorityQueue<>(Comparator.comparing(Patient::getPriority));
        reverseQueue.addAll(queue);
        return reverseQueue.peek();
    }

    @Override
    public Patient findMax() {
        return queue.peek();
    }

    @Override
    public Patient findPatientById(int id) {
        return null;
    }

    @Override
    public void deletePatient(int id) {

    }
}
