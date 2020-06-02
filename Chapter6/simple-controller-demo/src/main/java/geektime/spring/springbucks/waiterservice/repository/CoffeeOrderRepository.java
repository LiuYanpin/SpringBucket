package geektime.spring.springbucks.waiterservice.repository;


import geektime.spring.springbucks.waiterservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
