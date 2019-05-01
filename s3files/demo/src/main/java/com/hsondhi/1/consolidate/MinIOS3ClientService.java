package com.hsondhi.consolidate;

import java.nio.file.Path;

public interface MinIOS3ClientService {
	public void uploadFileToS3Bucket(Path targetLocalFile, String toolName,String fileNameForS3);
	public void deleteFileFromS3Bucket(String filename);

}
