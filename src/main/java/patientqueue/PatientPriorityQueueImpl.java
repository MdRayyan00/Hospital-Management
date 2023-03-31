package patientqueue;

import model.Patient;

import java.util.PriorityQueue;

public class PatientPriorityQueueImpl implements PatientPriorityQueue {

    private final PriorityQueue<Patient> queue =
            new PriorityQueue<>((p1, p2) -> p2.getPriority() - p1.getPriority());

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

    }

    @Override
    public void findPatientById(int id) {

    }

    @Override
    public void displayAll() {

    }

}
