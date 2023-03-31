package patientqueue;

import model.Patient;

import java.util.Comparator;
import java.util.Stack;

public class PatientStackImpl implements PatientQueue {
    /**
     * @param patient
     */

    Stack<Patient> stack = new Stack<>();

    @Override
    public void addPatient(Patient patient) {
        stack.add(patient);
        stack.sort(Comparator.comparingInt(Patient::getPriority));
    }

    /**
     * @return
     */
    @Override
    public Patient findMaxPriorityPatient() {
        return null;
    }

    /**
     * Delete a patient by ID
     *
     * @param id Unique ID of a patient.
     */
    @Override
    public void deletePatientById(int id) {

    }

    /**
     * @param id
     */
    @Override
    public void findPatientById(int id) {

    }

    /**
     *
     */
    @Override
    public void displayAll() {

    }
}
