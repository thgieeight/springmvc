package com.inventory.invmgtsys.utils;
import com.inventory.invmgtsys.dto.CategoryDto;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.stream.Stream;
import java.util.List;

public class GenerateCategoryPdf {

    public static ByteArrayInputStream createCategoryPdf(List<CategoryDto> categories){
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {


            PdfWriter.getInstance(document, out);
            document.open();

            // Add Text to PDF file ->
            Font font = FontFactory
                    .getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph("Category Table", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);


            PdfPTable table = new PdfPTable(5);
            // Add PDF Table Header ->
            Stream.of("ID", "Category Name", "Added Date","Image Name","status")
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

            for (CategoryDto categoryDto : categories) {
                addTableRow(table,categoryDto.getCategoryId().toString());
                addTableRow(table,categoryDto.getCategoryName());
                addTableRow(table,categoryDto.getAddedDate());
                addTableRow(table,categoryDto.getImage());
                addTableRow(table,categoryDto.getStatus().toString());
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