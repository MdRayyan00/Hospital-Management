package patientqueue;

import model.Patient;

public interface PatientQueue {
    void addPatient(Patient patient);

    Patient findMaxPriorityPatient();

    /**
     * Delete a patient by ID
     * @param id Unique ID of a patient.
     */
    void deletePatientById(int id);

    void findPatientById(int id);

    void displayAll();
}
