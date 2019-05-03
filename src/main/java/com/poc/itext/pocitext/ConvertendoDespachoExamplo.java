package com.poc.itext.pocitext;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertendoDespachoExamplo {
    /** The Base URI of the HTML page. */
    public static final String BASEURI = "src/main/resources/templates/";
    /** The path to the source HTML file. */
    public static final String SRC = String.format("%smodelo_despacho.htm", BASEURI);
    /** The target folder for the result. */
    public static final String TARGET = "target/results/ch01/";
    /** The path to the resulting PDF file. */
    public static final String DEST = String.format("%stest-04.pdf", TARGET);

    /**
     * The main method of this example.
     *
     * @param args no arguments are needed to run this example.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {
       // LicenseKey.loadLicenseFile(System.getenv("ITEXT7_LICENSEKEY") + "/itextkey-html2pdf_typography.xml");
        File file = new File(TARGET);
        file.mkdirs();
        new ConvertendoDespachoExamplo().createPdf(BASEURI, SRC, DEST);
    }

    /**
     * Creates the PDF file.
     *
     * @param baseUri the base URI
     * @param src the path to the source HTML file
     * @param dest the path to the resulting PDF
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void createPdf(String baseUri, String src, String dest) throws IOException {
        ConverterProperties properties = new ConverterProperties();
        properties.setBaseUri(baseUri);
        HtmlConverter.convertToPdf(new FileInputStream(src), new FileOutputStream(dest), properties);
    }
}
