package com.example.firebaseproject.service;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FBInitialize {
    @PostConstruct
    public  void initialize(){
        try {
            FileInputStream serviceAccount = new FileInputStream
                    ("/home/arsen/Desktop/firebase/treeproject-9de9e-firebase-adminsdk-5lmy5-9e07fa41a8.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://chatapp-e6e15.firebaseio.com").build();
            FirebaseApp.initializeApp(options);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
