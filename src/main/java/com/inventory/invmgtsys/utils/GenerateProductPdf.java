package com.inventory.invmgtsys.utils;

import com.inventory.invmgtsys.dto.ProductDto;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

public class GenerateProductPdf {

    public static ByteArrayInputStream createProductPdf(List<ProductDto> products){
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {


            PdfWriter.getInstance(document, out);
            document.open();

            // Add Text to PDF file ->
            Font font = FontFactory
                    .getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph("Product Table", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);


            PdfPTable table = new PdfPTable(5);
            // Add PDF Table Header ->
            Stream.of("ID", "Product Name", "Added Date","Image Name","status")
                    .forEach(headerTitle ->
                    {
                        PdfPCell header = new PdfPCell();
                        Font headFont = FontFactory.
                                getFont(FontFactory.HELVETICA_BOLD);
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, headFont));
                        table.addCell(header);
                    });
            //add row

            for (ProductDto productDto : products) {
                addTableRow(table,productDto.getProductId().toString());
                addTableRow(table,productDto.getProductName());
                addTableRow(table,productDto.getAddedDate());
                addTableRow(table,productDto.getImage());
                addTableRow(table,productDto.getStatus().toString());
            }

            document.add(table);

            document.close();




        }catch (Exception e){

        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    static void addTableRow(PdfPTable table,String data){
        PdfPCell idCell = new PdfPCell(new Phrase(data));
        idCell.setPaddingLeft(4);
        idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(idCell);

    }
}
