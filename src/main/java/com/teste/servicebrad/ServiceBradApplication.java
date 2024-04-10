package com.teste.servicebrad;

//import com.teste.servicebrad.managers.BradescoPaymentServiceOriginalnew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.teste.servicebrad.*","br.com.araujo.hubpagamento.*"})
public class ServiceBradApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBradApplication.class, args);
	}
//	@Autowired
//	public BradescoPaymentServiceOriginalnew client;


}
