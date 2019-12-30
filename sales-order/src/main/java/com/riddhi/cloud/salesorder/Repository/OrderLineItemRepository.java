package com.riddhi.cloud.salesorder.Repository;

import com.riddhi.cloud.salesorder.Model.OrderLineItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineItemRepository extends CrudRepository<OrderLineItem, Long> {

    List<OrderLineItem> findAll();

    OrderLineItem findByItemNameAndOrderId(String name, Long orderId);

}
