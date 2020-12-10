package loja.conf;

import org.springframework.context.annotation.Bean;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AmazonConfiguration {

	@Bean
	private AmazonS3 s3Ninja() {
		
		BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAIOSFODNN7EXAMPLE", "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY"); 
		AmazonS3 s3 = AmazonS3ClientBuilder.standard()
						.withCredentials(new AWSStaticCredentialsProvider(credentials))
						.withChunkedEncodingDisabled(true)
						.withPathStyleAccessEnabled(true)
						.withEndpointConfiguration(new EndpointConfiguration("http://localhost:9444/s3", "us-west-2"))
						.build();
		
		return s3;
	}
}
