package patientqueue;

import model.Patient;

public interface PatientQueue {
    void addPatient(Patient patient);

    Patient findMaxPriorityPatient();

    void deletePatientById(String id);

    Patient findPatientById(String id);

    void displayAll();
}
