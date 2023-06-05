package com.test.pdfGenerator.services.Impl;

import com.itextpdf.text.DocumentException;

import com.test.pdfGenerator.models.Bill;
import com.test.pdfGenerator.services.PdfGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfGenerationServiceImpl implements PdfGenerationService {

    private TemplateEngine templateEngine;

    @Autowired
    public void PdfGenerationService() {
        initializeTemplateEngine();
    }

    private void initializeTemplateEngine() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    @Override
    public byte[] generatePdf(Bill bill)
            throws IOException, DocumentException {
        Context context = new Context();
        context.setVariable("data", bill);

        String htmlContent = templateEngine.process("invoice", context);

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {

            throw new RuntimeException("Something went wrong - \n"+e.getStackTrace(), e);
        }

    }
}
