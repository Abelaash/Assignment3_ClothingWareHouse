package com.cpan252.assignment3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.cpan252.assignment3.model.Item;
import com.cpan252.assignment3.repository.ClothesRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class WareHouseControll {

	public static void main(String[] args) {
		SpringApplication.run(WareHouseControll.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ClothesRepository repository) {
		return args -> {
			repository.save(Item.builder()
					.name("Textured Jersey Dress")
					.brand("Zara")
					.year_of_creation(2022)
					.price(new BigDecimal(128.5)).build());

			repository.save(Item.builder()
					.name("Oversized Rib-knit Sweater")
					.brand("H&M")
					.year_of_creation(2022)
					.price(new BigDecimal(68.45)).build());

			repository.save(Item.builder()
					.name("Shiny Pants")
					.brand("Zara")
					.year_of_creation(2019)
					.price(new BigDecimal(80.05)).build());

			repository.save(Item.builder()
					.name("Twill Cargo Pants")
					.brand("UNIQULO")
					.year_of_creation(2013)
					.price(new BigDecimal(89.45)).build());

			repository.save(Item.builder()
					.name("Oversized Crinkled Blouse")
					.brand("UNIQULO")
					.year_of_creation(2011)
					.price(new BigDecimal(78.65)).build());

			repository.save(Item.builder()
					.name("Oversized Turtleneck Sweater")
					.brand("UNIQULO")
					.year_of_creation(2022)
					.price(new BigDecimal(57.35)).build());

			repository.save(Item.builder()
					.name("Pointed-collar Shirt")
					.brand("ZARA")
					.year_of_creation(2008)
					.price(new BigDecimal(38.45)).build());

			repository.save(Item.builder()
					.name("Rib-knit Mock Turtleneck Sweater")
					.brand("H&M")
					.year_of_creation(2022)
					.price(new BigDecimal(75.78)).build());

			repository.save(Item.builder()
					.name("Trench Coat")
					.brand("H&M")
					.year_of_creation(2020)
					.price(new BigDecimal(250.98)).build());

		};
	}
}