package patientqueue;

import model.Patient;

public interface PatientPriorityQueue {
    void addPatient(Patient patient);

    Patient findMaxPriorityPatient();

    void deletePatientById(int id);

    void findPatientById(int id);

    void displayAll();
}
