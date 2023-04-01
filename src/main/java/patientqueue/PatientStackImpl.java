package patientqueue;

import model.Patient;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.Stack;

public class PatientStackImpl implements PatientQueue {

    Stack<Patient> stack = new Stack<>();

    /**
     * Method to add patient in the stack
     * @param patient Patient information
     */

    @Override
    public void addPatient(Patient patient) {
        stack.add(patient);
        stack.sort(Comparator.comparingInt(Patient::getPriority));
    }

    /**
     * Method to find patient with the highest priority
     * @return Patient
     */
    @Override
    public Patient findMaxPriorityPatient() {
        return stack.pop();
    }

    /**
     * Delete a patient by ID
     * @param id Unique ID of a patient.
     */
    @Override
    public void deletePatientById(int id) {
        ListIterator<Patient> iterator = (ListIterator<Patient>) stack.iterator();
        while (iterator.hasNext()) {
            Patient next = iterator.next();
            if (next.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

    /**
     * Find details of a patient using a unique id.
     * @param id Unique ID of a patient.
     */
    @Override
    public void findPatientById(int id) {

    }

    /**
     * Display the list of all patient in the system
     */
    @Override
    public void displayAll() {
        for (Patient patient: stack) {
            System.out.println(patient);
        }
    }
}
