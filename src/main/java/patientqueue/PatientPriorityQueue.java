package patientqueue;

import model.Patient;


public interface PatientPriorityQueue {

    //Add patient
    void insert(Patient patient);

    //Find Min Priority Patient
    Patient findMin();

    //Find Max Priority Patient
    Patient findMax();

    Patient findPatientById(int id);

    //Delete patient
    void deletePatient(int id);
}
