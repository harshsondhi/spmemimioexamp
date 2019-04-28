package com.example.demo.harsh;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.MinioException;
import io.minio.errors.NoResponseException;

public class S3Client {
	public static void main(String[] args) {
		
		String accessKey = "AKIAIOSFODNN7EXAMPLE";
		String secretKey = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
		// "MINIO_ACCESS_KEY=AKIAIOSFODNN7EXAMPLE" -e
		// "MINIO_SECRET_KEY=wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY"
		// http://192.168.99.111:9000/minio/harshsondhi4262019/
		try {
			MinioClient minioClient = new MinioClient("http://192.168.99.111:9000", accessKey, secretKey);
			boolean isExist = minioClient.bucketExists("harshsondhi4262019");
			if (isExist) {
				System.out.println("Bucket already exists.");
			} else {
				minioClient.makeBucket("harshsondhi4262019");
			}
			minioClient.listBuckets().forEach(b -> System.out.println(b.name()));
			//================
			  URL url = new URL(
			          "http://www.cutestpaw.com/wp-content/uploads/2015/11/My-Cute-Baby-Cat.jpg");
			      Path tempFile = Files.createTempFile("cat1", ".jpg");
			      try (InputStream in = url.openStream()) {
			        Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
			      }
			      minioClient.putObject("harshsondhi4262019", "cat1.jpg", tempFile.toString());
			      //Files.delete(tempFile);

			//================
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
