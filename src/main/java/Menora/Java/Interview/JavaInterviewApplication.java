package Menora.Java.Interview;

import Menora.Java.Interview.services.EventsService;
import Menora.Java.Interview.threads.ReadXmlFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;

@SpringBootApplication
public class JavaInterviewApplication implements CommandLineRunner{

	@Value("${xmlPath}")
	private String xmlPath ;

	@Autowired
	private EventsService eventsService;

	public static void main(String[] args) {
		SpringApplication.run(JavaInterviewApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(new ReadXmlFile(xmlPath,eventsService),0,60, TimeUnit.MINUTES);
	}
}
