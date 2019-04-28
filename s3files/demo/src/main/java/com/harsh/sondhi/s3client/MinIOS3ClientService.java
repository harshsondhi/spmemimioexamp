package com.harsh.sondhi.s3client;

import java.nio.file.Path;

public interface MinIOS3ClientService {
	public void uploadFileToS3Bucket(Path targetLocalFile, String toolName,String fileNameForS3);
	public void deleteFileFromS3Bucket(String filename);

}
