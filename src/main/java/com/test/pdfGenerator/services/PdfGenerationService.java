package com.test.pdfGenerator.services;

import com.itextpdf.text.DocumentException;
import com.test.pdfGenerator.models.Bill;

import java.io.IOException;

public interface PdfGenerationService {

    byte[] generatePdf(Bill bill) throws IOException, DocumentException;

}

