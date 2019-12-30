package com.riddhi.cloud.salesorder.Service;


import com.riddhi.cloud.salesorder.Model.Item;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

//@FeignClient(name="item", url="localhost:9000")
@FeignClient(name="item-service")       // you do not need the url while using the Ribbon load balancing
//@FeignClient(name="zuul-api-gateway-server")    // to make requests go through the ZUUL API GATEWAY
@RibbonClient(name = "item-service")
public interface ItemProxy {

    @GetMapping("/api/items/{name}")
    public Item findItemByName(@PathVariable("name") String name);

//    @PostMapping("items/add")
//    public  Item addNewItem(@Valid @ModelAttribute("items") Item item, BindingResult result);

}
