package com.test.pdfGenerator.controllers;

import com.itextpdf.text.DocumentException;
import com.test.pdfGenerator.models.Bill;
import com.test.pdfGenerator.services.PdfGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pdf")
public class PdfController {
    @Autowired
    private PdfGenerationService pdfGenerationService;


    @PostMapping("/generate")
    public ResponseEntity<byte[]> generatePdf(@RequestBody Bill invoiceData)
            throws IOException, DocumentException {

        byte[] pdfBytes = pdfGenerationService.generatePdf(invoiceData);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "invoice.pdf");

        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
