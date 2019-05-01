package com.hsondhi.consolidate;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestRestController {
	@Autowired
	MinIOS3ClientService minIOS3ClientService;
	
	@RequestMapping("/greeting")
	public String testMe() {
		Path targetLocalFile = Paths.get("C:\\\\Users\\\\harsh\\\\AppData\\\\Local\\\\Temp\\\\anytool.jpg");
		minIOS3ClientService.uploadFileToS3Bucket(targetLocalFile, "ccsnetwork", "somedir/harshFour.jpg");
		return "Harsh Tested";
	}

}
