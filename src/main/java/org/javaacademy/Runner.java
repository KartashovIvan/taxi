package org.javaacademy;

import org.javaacademy.taxi.company.TaxiCompany;
import org.javaacademy.taxi.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.javaacademy.taxi.time.TimesDay.*;

@SpringBootApplication
public class Runner {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Runner.class, args);
		TaxiCompany tc = context.getBean(TaxiCompany.class);
		Client clientOne = new Client("Кандикюля");
		Client clientTwo = new Client("Строитель");
		Client clientThree = new Client("Березовая роща");
		Client clientFour = new Client("Ломоносов");

		tc.takeOrder(clientOne, DAY);
		tc.takeOrder(clientTwo, DAY);
		tc.takeOrder(clientThree, NIGHT);
		tc.takeOrder(clientFour, NIGHT);
		context.close();
	}
}
