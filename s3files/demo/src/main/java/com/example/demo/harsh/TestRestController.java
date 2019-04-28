package com.example.demo.harsh;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.sondhi.s3client.MinIOS3ClientService;

@RestController
public class TestRestController {
//	@Autowired
//	MinIOS3ClientServiceImpl minIOS3ClientService;
	
	@RequestMapping("/greeting")
	public String testMe() {
		Path targetLocalFile = Paths.get("C:\\\\Users\\\\harsh\\\\AppData\\\\Local\\\\Temp\\\\anytool.jpg");
		//minIOS3ClientService.uploadFileToS3Bucket(targetLocalFile, "ccsnetwork", "harshOne");
		return "Harsh Tested";
	}

}
