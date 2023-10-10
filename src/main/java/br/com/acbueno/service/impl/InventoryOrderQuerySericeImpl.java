package br.com.acbueno.service.impl;

import java.util.ArrayList;
import java.util.List;
import br.com.acbueno.dto.OrderDTO;
import br.com.acbueno.dto.OrderProductDTO;
import br.com.acbueno.respository.ProductRepository;
import br.com.acbueno.service.InvetoryOrderQueryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InventoryOrderQuerySericeImpl implements InvetoryOrderQueryService {

    @Inject
    private ProductRepository productRepository;

    @Override
    public OrderDTO getInventoryOrderByPurchase(Long id) {
        Double total = 0.0;
        OrderDTO orderDTO = new OrderDTO();
        List<OrderProductDTO> listOrderDTO = new ArrayList<>();
        writeInventoryByPurchase(id, total, orderDTO, listOrderDTO);

        return orderDTO;
    }

    @Override
    public OrderDTO getAllInvetoryOrderByPurchase() {
        Double total = 0.0;
        OrderDTO orderDTO = new OrderDTO();
        List<OrderProductDTO> listOrderDTO = new ArrayList<>();
        writeInventoryByPurchase(total, orderDTO, listOrderDTO);

        return orderDTO;
    }

    private void writeInventoryByPurchase(Long id, Double total, OrderDTO orderDTO, List<OrderProductDTO> listOrderDTO) {
        productRepository.findAllProduct().forEach(p -> {
            OrderProductDTO orderProductDTO = new OrderProductDTO();
            if (p.getPurchase().getId().equals(id)) {
                orderProductDTO.setBrandName(p.getBrandName());
                orderProductDTO.setDescription(p.getDescription());
                orderProductDTO.setAmount(p.getAmount());
                orderProductDTO.setPrice(p.getPrice());
                listOrderDTO.add(orderProductDTO);
            }
        });

        for (OrderProductDTO item : listOrderDTO) {
            total += item.getPrice() * item.getAmount();
        }
        orderDTO.setTotalPrice(total);
        orderDTO.setOrderProductDTO(listOrderDTO);
    }

    private void writeInventoryByPurchase(Double total, OrderDTO orderDTO, List<OrderProductDTO> listOrderDTO) {
        productRepository.findAllProduct().forEach(p -> {
            OrderProductDTO orderProductDTO = new OrderProductDTO();
            orderProductDTO.setBrandName(p.getBrandName());
            orderProductDTO.setDescription(p.getDescription());
            orderProductDTO.setAmount(p.getAmount());
            orderProductDTO.setPrice(p.getPrice());
            listOrderDTO.add(orderProductDTO);
        });

        for (OrderProductDTO item : listOrderDTO) {
            total += item.getPrice() * item.getAmount();
        }

        orderDTO.setTotalPrice(total);
        orderDTO.setOrderProductDTO(listOrderDTO);
    }

}
