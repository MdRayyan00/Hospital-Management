package runner;

import model.Patient;
import patientqueue.PatientPriorityQueueImpl;
import patientqueue.PatientQueue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class HospitalManagementSystem {
    public static void main(String[] args) {

        PatientQueue priorityQueue = new PatientPriorityQueueImpl();

        Patient pranjal = new Patient("Pranjal", "Low", 12, Instant.now());
        Patient rishabh = new Patient("Rishabh", "High", 13, Instant.now().minus(1, ChronoUnit.HOURS));
        Patient raayan = new Patient("Rayyan", "Low", 14, Instant.now().plus(1, ChronoUnit.HOURS));

        priorityQueue.addPatient(pranjal);
        priorityQueue.addPatient(rishabh);
        priorityQueue.addPatient(raayan);

        priorityQueue.displayAll();
    }
}
