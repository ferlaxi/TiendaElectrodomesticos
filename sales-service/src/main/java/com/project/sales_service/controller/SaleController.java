package com.project.sales_service.controller;

import com.project.sales_service.dto.SaleDTO;
import com.project.sales_service.model.Sale;
import com.project.sales_service.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @PostMapping("/create")
    ResponseEntity<String> createSale (@RequestBody Sale sale) {
        saleService.createSale(sale);
        return new ResponseEntity<>("Sale Created", HttpStatus.CREATED);
    }

    @GetMapping("/get")
    ResponseEntity<List<SaleDTO>> getSales () {
        return new ResponseEntity<>(saleService.getSales(), HttpStatus.OK);
    }

    @PutMapping("/edit/{saleId}")
    ResponseEntity<String> editSale (@PathVariable Long saleId,
                                     @RequestBody Sale editedSale) {
        saleService.editSale(saleId, editedSale);
        return new ResponseEntity<>("Sale Edited", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{saleId}")
    ResponseEntity<String> deleteSale (@PathVariable Long saleId) {
        saleService.deleteSale(saleId);
        return new ResponseEntity<>("Sale Deleted", HttpStatus.OK);
    }

    @GetMapping("/get/{saleId}")
    ResponseEntity<SaleDTO> getSale (@PathVariable Long saleId) {
        return new ResponseEntity<>(saleService.getSale(saleId), HttpStatus.OK);
    }

}
