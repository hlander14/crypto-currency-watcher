package by.myself.crypto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoApplication {
	static final Logger logger = LoggerFactory.getLogger(CryptoApplication.class);

	public static void main(String[] args) {
		logger.info("Before Starting application");
		SpringApplication.run(CryptoApplication.class, args);
		logger.debug("Starting my application in debug with {} arguments", args.length);
		logger.info("Starting my application with {} arguments.", args.length);
	}
}
