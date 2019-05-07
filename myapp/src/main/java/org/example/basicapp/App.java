package org.example.basicapp;

import java.io.File;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	String filename = "C:\\MongoDB\\README";
        System.out.println( "Hello World!" );
        String clientRegion = "*** Client region ***";
        String bucketName = "*** Bucket name ***";
        
        String awsAccessKey = "AKIAY6RLWCGYM6UTEZN7";
        String awsSecretKey = "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";
        AWSCredentials awsCredentials = 
            new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion("us-east-1")
                .build();
        
        List<Bucket> abucketlist = s3Client.listBuckets();
        for(Bucket b:abucketlist) {
        	System.out.println(   "BUCKET NAME====" + b.getName());
        	
        }
        System.out.println("BUCKET S ARE====  " + abucketlist.size());
        String bucketname =  "harshsondhi05062019";
        s3Client.putObject(bucketname, "Document/helloone.txt", new File(filename));
        System.out.println("BUCKET S ARE====saved  " );
        
    }
}
