package geektime.spring.data.mybatisdemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
//@MapperScan("geektime.spring.data.mybatisdemo.mapper")
public class MybatisDemoApplication implements ApplicationRunner {
//    @Autowired
//    private CoffeeMapper coffeeMapper;
    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    /*    Coffee coffee = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        int count = coffeeMapper.save(coffee);
        log.info("Save {} Coffee: {}", count, coffee);

        Coffee coffee2 = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 25.0))
                .build();
        int count2 = coffeeMapper.save(coffee2);
        log.info("Save {} Coffee: {}", count2, coffee2);

        log.info("Find Coffee: {}", coffeeMapper.findById(coffee.getId()));
        log.info("Find Coffee: {}", coffeeMapper.findById(coffee2 .getId()));*/
    }
}
