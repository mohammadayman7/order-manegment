package com.example.demo.Services;


import com.example.demo.Entity.ProductOrder;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface ProduceOrderService {

    ProductOrder create(@NotNull(message = "The products for order cannot be null.") @Valid ProductOrder orderProduct);
}
