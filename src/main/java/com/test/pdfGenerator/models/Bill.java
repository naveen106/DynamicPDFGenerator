package com.test.pdfGenerator.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private String seller;
    private String sellerGstIn;
    private String sellerAddress;
    private String buyer;
    private String  buyerGstIn;
    private String buyerAddress;

    private List<Item> items;

}
