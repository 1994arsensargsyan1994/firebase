package com.example.firebaseproject.cotnroller;


import com.example.firebaseproject.model.Patient;
import com.example.firebaseproject.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class PatientController {


    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/getPatientDetails")
    public Patient getPatient(@RequestParam String name) throws ExecutionException, InterruptedException {
        return patientService.getPatientDetails(name);
    }

    @PostMapping("/savePatientDetails")
    public String createPatient(@RequestBody Patient patient) throws ExecutionException, InterruptedException {

        String s = patient.toString();
        System.out.println(s);
        return patientService.savePatientDetails(patient);
    }

    @PutMapping("/updatePatientDetails")
    public String updatePatient(@RequestBody Patient patient) throws ExecutionException, InterruptedException {
        return patientService.updatePatientDetails(patient);
    }

    @DeleteMapping("/deletePatient")
    public String delete(@RequestParam String name){
        return  patientService.deletePatient(name);
    }
}
