package gl.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MyRestClientApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(MyRestClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyRestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(2000);
		//2 sec timeout, default = 10s
		//((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(2000);
		try {
			ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/people/search/findByLastName?name=" + "Baggins", String.class);

			log.info(response.toString());
		}
		catch (Exception ex)
		{
			log.error("EXCEPTION:",ex.toString());
		}
	/*try {
		MyPersonDetails myPerson =
				//restTemplate.getForObject("http://localhost:8080/people/search/findByLastName?name=" + "Baggins",MyPersonDetails.class);
				restTemplate.getForObject("http://localhost:8080/people/search/findByLastName?name={lastName}", MyPersonDetails.class, "Baggins");
		//assertThat(response.getStatusCode(), is(HttpStatus.OK));
		log.info(myPerson.toString());
		if(null == myPerson)
		{
			log.info("query did not work...");
		}
	}catch (Exception e)
	{
		log.info("EXCEPTION:",e.toString());
	}*/

	}
}
