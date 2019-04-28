package com.harsh.sondhi.s3client;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import io.minio.MinioClient;

@Component
public class MinIOS3ClientServiceImpl  implements MinIOS3ClientService {
	private Logger logger = LoggerFactory.getLogger(MinIOS3ClientServiceImpl.class);
	
	@Autowired
	private MinioClient minioClient;
	
	@Value("${s3.bucketName}")
	private String  bucketName;

	@Async
	public void uploadFileToS3Bucket(Path targetLocalFile,String toolName,String fileNameForS3) {
		try {
			//==============================
			boolean isExist = minioClient.bucketExists(bucketName);
			if (isExist) {
   				System.out.println("Bucket already exists.");
   			} else {
   				minioClient.makeBucket(bucketName);
   			}
			minioClient.listBuckets().forEach(b -> System.out.println(b.name()));
			//=============================
			Path tempFile = Files.createTempFile(toolName, ".jpg");
			
			try (InputStream in = Files.newInputStream(targetLocalFile)) {
			        Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
			 }
			 minioClient.putObject(bucketName,fileNameForS3,tempFile.toString());
			 Files.delete(tempFile);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
	}

	
	public void deleteFileFromS3Bucket(String filename) {
		// TODO Auto-generated method stub
		
	}


	

}
