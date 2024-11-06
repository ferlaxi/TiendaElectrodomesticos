package com.project.sales_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private Long saleId;
    private LocalDate saleDate;
    private CartDTO cartSale;

}
