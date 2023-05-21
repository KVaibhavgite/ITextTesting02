package com.example.itexttesting02;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            Toast.makeText(this,"click.",Toast.LENGTH_LONG).show();
            createPDF();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


    private void createPDF()throws  FileNotFoundException {
        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath,"Invoice3Pdf.pdf");
        OutputStream outputStream = new FileOutputStream(file);

        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        DeviceRgb green = new DeviceRgb(51,204,51);
        DeviceRgb xray= new DeviceRgb(192,192,192);

        float columnWidth[] = {140,140,140,140};
        Table table = new Table(columnWidth);

        Drawable d = getDrawable(R.drawable.logo);
        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte [] bytes = stream.toByteArray();
        ImageData imageData = ImageDataFactory.create(bytes);
        Image image = new Image(imageData);
        image.setWidth(100f);

        //table--01
        table.addCell(new Cell(3,1).add(image)).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell(1,2).add(new Paragraph("Invoice").setFontSize(26f).setFontColor(green))).setBorder(Border.NO_BORDER);
        //table.addCell(new Cell().add(new Paragraph("")));

        //table--02
       // table.addCell(new Cell().add(new Paragraph("")));
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph("Invoice no. :"))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph("9767240176"))).setBorder(Border.NO_BORDER);

        //table--03
       // table.addCell(new Cell().add(new Paragraph("")));
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph("Invoice date :"))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph("12-04-2023"))).setBorder(Border.NO_BORDER);

        //table--04
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph("Account No. :"))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph("2536 3264 7891"))).setBorder(Border.NO_BORDER);

        //table--05
        table.addCell(new Cell().add(new Paragraph("\n"))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);

        //table--06
        table.addCell(new Cell().add(new Paragraph("To"))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);

        //table--07
        table.addCell(new Cell().add(new Paragraph("Krishna Yadav"))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph("Payment Method :").setBold())).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);

        //table--08
        table.addCell(new Cell().add(new Paragraph("16 Yeshoda wila west"))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell(1,2).add(new Paragraph("Paypal : payments@Easypay.in"))).setBorder(Border.NO_BORDER);
        //table.addCell(new Cell().add(new Paragraph("")));

        //table--09
        table.addCell(new Cell().add(new Paragraph("Mathura,UP"))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table.addCell(new Cell(1,2).add(new Paragraph("Card Payment : we accept visa,mastercard,RuPay."))).setBorder(Border.NO_BORDER);
       // table.addCell(new Cell().add(new Paragraph("")));




        float columnWidth1[] = {62,162,112,112,112};
        Table table1 =new Table(columnWidth1);

        //table1--01
        table1.addCell(new Cell().add(new Paragraph("Sr. No."))).setFontColor(ColorConstants.WHITE).setBackgroundColor(green);
        table1.addCell(new Cell().add(new Paragraph("ITEM DESCRIPTION"))).setFontColor(ColorConstants.WHITE).setBackgroundColor(green);
        table1.addCell(new Cell().add(new Paragraph("RATE"))).setFontColor(ColorConstants.WHITE).setBackgroundColor(green);
        table1.addCell(new Cell().add(new Paragraph("QTY"))).setFontColor(ColorConstants.WHITE).setBackgroundColor(green);
        table1.addCell(new Cell().add(new Paragraph("PRICE"))).setFontColor(ColorConstants.WHITE).setBackgroundColor(green);

        //table1--02
        table1.addCell(new Cell().add(new Paragraph("1."))).setBackgroundColor(xray).setFontColor(ColorConstants.BLACK);
        table1.addCell(new Cell().add(new Paragraph("WHITE RICES"))).setBackgroundColor(xray).setFontColor(ColorConstants.BLACK);
        table1.addCell(new Cell().add(new Paragraph("100"))).setBackgroundColor(xray).setFontColor(ColorConstants.BLACK);
        table1.addCell(new Cell().add(new Paragraph("10KG"))).setBackgroundColor(xray).setFontColor(ColorConstants.BLACK);
        table1.addCell(new Cell().add(new Paragraph("1000"))).setBackgroundColor(xray).setFontColor(ColorConstants.BLACK);

        //table1--03
        table1.addCell(new Cell().add(new Paragraph("2."))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("MARIGOLD SEEDS"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("50"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("2KG"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("100"))).setBackgroundColor(xray);

        //table1--04
        table1.addCell(new Cell().add(new Paragraph("3."))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("FERTILIZER"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("300"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("1"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("300"))).setBackgroundColor(xray);

        //table1--05
        table1.addCell(new Cell().add(new Paragraph("4."))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("TOOL"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("150"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("2"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("300"))).setBackgroundColor(xray);

        //table1--06
        table1.addCell(new Cell().add(new Paragraph("5."))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("CACTUS PLANT"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("400"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("1"))).setBackgroundColor(xray);
        table1.addCell(new Cell().add(new Paragraph("400"))).setBackgroundColor(xray);

        //table1--07
        table1.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table1.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table1.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table1.addCell(new Cell().add(new Paragraph("Sub-Total"))).setBackgroundColor(green);
        table1.addCell(new Cell().add(new Paragraph("2100"))).setBackgroundColor(green);


        //table1--08
        table1.addCell(new Cell(1,2).add(new Paragraph("Terms & Conditions :").setBold())).setBorder(Border.NO_BORDER);
       // table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table1.addCell(new Cell().add(new Paragraph("GST (12%)"))).setBackgroundColor(green);
        table1.addCell(new Cell().add(new Paragraph("252"))).setBackgroundColor(green);

        //table1--09
        table1.addCell(new Cell(1,2).add(new Paragraph("Goods sold are not be returnable and exchangeable."))).setBorder(Border.NO_BORDER);
        //table1.addCell(new Cell().add(new Paragraph("")));
        table1.addCell(new Cell().add(new Paragraph(""))).setBorder(Border.NO_BORDER);
        table1.addCell(new Cell().add(new Paragraph("Grand Total").setBold().setFontSize(16))).setBackgroundColor(green);
        table1.addCell(new Cell().add(new Paragraph("2352").setFontSize(16).setBold())).setBackgroundColor(green);

        float columnWidth2[] = {50,250,260};
        Table table2 = new Table(columnWidth2);

        Drawable d2 = getDrawable(R.drawable.contact);
        Bitmap bitmap2 = ((BitmapDrawable)d2).getBitmap();
        ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
        bitmap2.compress(Bitmap.CompressFormat.PNG,100,stream2);
        byte [] bytes2 = stream2.toByteArray();
        ImageData imageData2 = ImageDataFactory.create(bytes2);
        Image image2 = new Image(imageData2);
        image2.setHeight(120);

         Drawable d3 = getDrawable(R.drawable.thankyou);
        Bitmap bitmap3 = ((BitmapDrawable)d3).getBitmap();
        ByteArrayOutputStream stream3 = new ByteArrayOutputStream();
        bitmap3.compress(Bitmap.CompressFormat.PNG,100,stream3);
        byte [] bytes3 = stream3.toByteArray();
        ImageData imageData3 = ImageDataFactory.create(bytes3);
        Image image3 = new Image(imageData3);
        image3.setHeight(120);
        image3.setHorizontalAlignment(HorizontalAlignment.RIGHT);

        table2.addCell(new Cell(3,1).add(image2)).setBorder(Border.NO_BORDER);
        table2.addCell(new Cell().add(new Paragraph("customercare@EasyPay.com\nmyemail@EasyPay.in"))).setBorder(Border.NO_BORDER);
        table2.addCell(new Cell(3,1).add(image3)).setBorder(Border.NO_BORDER);
        table2.addCell(new Cell().add(new Paragraph("+91-9767240176\n+91-9676240176"))).setBorder(Border.NO_BORDER);
        table2.addCell(new Cell().add(new Paragraph("#420/F ChorWali Dukan,\nGealier, India "))).setBorder(Border.NO_BORDER);


        document.add(table);
        document.add(new Paragraph("\n"));
        document.add(table1);
        document.add(new Paragraph("\n\n\n\n\n(Authorised Signatory)\n\n\n")).setTextAlignment(TextAlignment.RIGHT);
        document.add(table2);

        document.close();
        Toast.makeText(this,"invoice pdf create.",Toast.LENGTH_LONG).show();
    }
}