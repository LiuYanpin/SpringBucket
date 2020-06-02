package geektime.spring.springbucks.waiterservice.controller.request;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class NewOrderRequest {
    private String customer;

    private List<String> items;
}
