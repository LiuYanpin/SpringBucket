package geektime.spring.mongodemo;

import com.mongodb.client.result.UpdateResult;
import geektime.spring.mongodemo.converter.MoneyReadConverter;
import geektime.spring.mongodemo.model.Coffee;
import geektime.spring.mongodemo.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
@EnableMongoRepositories
public class MongoDemoApplication implements ApplicationRunner {
	@Autowired
	private CoffeeRepository coffeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}

	@Bean
	public MongoCustomConversions mongoCustomConversions() {
		return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Coffee espresso = Coffee.builder()
				.name("espresso")
				.price(Money.of(CurrencyUnit.of("CNY"), 20.0))
				.createTime(new Date())
				.updateTime(new Date())
				.build();
		Coffee latte = Coffee.builder()
				.name("latte")
				.price(Money.of(CurrencyUnit.of("CNY"), 30.0))
				.createTime(new Date())
				.updateTime(new Date())
				.build();

		coffeeRepository.insert(Arrays.asList(espresso, latte));
		coffeeRepository.findAll(Sort.by("name")).forEach(c -> log.info("Saved Coffee {}", c));

		Thread.sleep(2000);
		latte.setPrice(Money.of(CurrencyUnit.of("CNY"), 50.0));
		latte.setUpdateTime(new Date());
		coffeeRepository.save(latte);
		coffeeRepository.findByName("latte").forEach(c -> log.info("Coffee {}", c));
		coffeeRepository.deleteAll();

	}
}
