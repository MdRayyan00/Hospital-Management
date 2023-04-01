package patientqueue;

import model.Patient;

/**
 *
 * Interface to perform queueing operation in regard to hospital management
 *
 */

public interface PatientQueue {
    void addPatient(Patient patient);

    Patient findMaxPriorityPatient();

    void deletePatientById(String id);

    Patient findPatientById(String id);

    void displayAll();
}
