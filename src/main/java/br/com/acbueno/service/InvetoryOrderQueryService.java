package br.com.acbueno.service;

import br.com.acbueno.dto.OrderDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface InvetoryOrderQueryService  {

    OrderDTO getInventoryOrderByPurchase(Long id);

    OrderDTO getAllInvetoryOrderByPurchase();


}
