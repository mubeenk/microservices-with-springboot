package demo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.context.config.annotation.EnableContextResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.util.FileCopyUtils;

@SpringBootApplication
@EnableContextResourceLoader
public class LivelessonsCloudS3Application {

	@Value("${livelessons.s3.bucket}")
	private String bucket;

	@Autowired
	private final ResourceLoader resourceLoader;

	public LivelessonsCloudS3Application(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@PostConstruct
	public void resourceAccess() throws IOException {
		String location = "s3://" + this.bucket + "/file.txt";
		Resource writeableResource = this.resourceLoader.getResource(location);
		FileCopyUtils.copy("Hello World!",
				new OutputStreamWriter(((WritableResource)writeableResource).getOutputStream()));

		Resource resource = this.resourceLoader.getResource(location);
		System.out.println(FileCopyUtils
				.copyToString(new InputStreamReader(resource.getInputStream())));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LivelessonsCloudS3Application.class, args);
	}

}
