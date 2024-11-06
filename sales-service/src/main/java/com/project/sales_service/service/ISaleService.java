package com.project.sales_service.service;

import com.project.sales_service.dto.SaleDTO;
import com.project.sales_service.model.Sale;

import java.util.List;

public interface ISaleService {
    public void createSale(Sale sale);
    public List<SaleDTO> getSales();
    public void editSale(Long saleId, Sale editedSale);
    public void deleteSale(Long saleId);
    public SaleDTO getSale(Long saleId);
}
