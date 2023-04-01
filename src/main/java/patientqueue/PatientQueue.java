package patientqueue;

import model.Patient;

public interface PatientQueue {
    void addPatient(Patient patient);

    Patient findMaxPriorityPatient();

    void deletePatientById(int id);

    Patient findPatientById(int id);

    void displayAll();
}
