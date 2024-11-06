package com.project.sales_service.service;

import com.project.sales_service.dto.CartDTO;
import com.project.sales_service.dto.SaleDTO;
import com.project.sales_service.model.Sale;
import com.project.sales_service.repository.CartAPI;
import com.project.sales_service.repository.ISaleRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private ISaleRepository saleRepo;

    @Autowired
    private CartAPI cartAPI;

    @Override
    public void createSale(Sale sale) {
        saleRepo.save(sale);
    }

    @Override
    @CircuitBreaker(name = "carts-service", fallbackMethod = "fallbackGetSales")
    @Retry(name = "carts-service")
    public List<SaleDTO> getSales() {

        List<Sale> salesList = saleRepo.findAll();
        List<CartDTO> cartsList = cartAPI.getCarts();

        List<SaleDTO> saleList = new ArrayList<SaleDTO>();

        for (Sale sale : salesList) {
            SaleDTO saleDTO = new SaleDTO();
            for (CartDTO cart : cartsList) {
                if (sale.getCartSaleId().equals(cart.getCartId())) {
                    saleDTO.setSaleId(sale.getSaleId());
                    saleDTO.setSaleDate(sale.getSaleDate());
                    saleDTO.setCartSale(cart);
                    saleList.add(saleDTO);
                }
            }
        }

        return saleList;
    }

    public List<SaleDTO> fallbackGetSales (Throwable throwable) {
        return null;
    }

    @Override
    public void editSale(Long saleId, Sale editedSale) {
        Sale sale = saleRepo.findById(saleId).orElse(null);

        sale.setSaleDate(editedSale.getSaleDate());
        sale.setCartSaleId(editedSale.getCartSaleId());

        saleRepo.save(sale);
    }

    @Override
    public void deleteSale(Long saleId) {
        saleRepo.deleteById(saleId);
    }

    @Override
    @CircuitBreaker(name = "carts-service", fallbackMethod = "fallbackGetSale")
    @Retry(name = "carts-service")
    public SaleDTO getSale(Long saleId) {
        Sale sale = saleRepo.findById(saleId).orElse(null);
        CartDTO cartDTO = cartAPI.getCartById(sale.getCartSaleId());

        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setSaleId(sale.getSaleId());
        saleDTO.setSaleDate(sale.getSaleDate());
        saleDTO.setCartSale(cartDTO);

        return saleDTO;
    }

    public SaleDTO fallbackGetSale (Throwable throwable) {
        return new SaleDTO(9999999L, null, null);
    }
}
