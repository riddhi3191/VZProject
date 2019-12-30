package com.riddhi.cloud.salesorder.Controller;


import com.riddhi.cloud.salesorder.Service.OrderLineItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-line-item")
public class OrderLineItemController {

    private OrderLineItemService orderLineItemService;

}
