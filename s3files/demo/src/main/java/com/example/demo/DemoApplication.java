package com.example.demo;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harsh.sondhi.s3client.MinIOS3ClientService;

//@SpringBootApplication
public class DemoApplication {
	
   
    
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		  
	}


//	@Override
//	public void run(String... args) throws Exception {
//		Path targetLocalFile = Paths.get("C:\\\\Users\\\\harsh\\\\AppData\\\\Local\\\\Temp\\\\anytool.jpg");
//		minIOS3ClientService.uploadFileToS3Bucket(targetLocalFile, "ccsnetwork", "harshOne");
//		
//	}

}
