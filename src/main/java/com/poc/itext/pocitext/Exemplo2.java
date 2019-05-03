package com.poc.itext.pocitext;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exemplo2 {
    /** The Base URI of the HTML page. */
    public static final String BASEURI = "src/main/resources/";
    /** The HTML-string that we are going to convert to PDF. */
    public static final String HTML = "<h1>Test com logo</h1><p>Hello World</p><img height=\"100\" width=\"200\"src=\"logo.png\">";
    /** The target folder for the result. */
    public static final String TARGET = "target/results/ch01/";
    /** The path to the resulting PDF file. */
    public static final String DEST = String.format("%stest-02.pdf", TARGET);

    /**
     * The main method of this example.
     *
     * @param args no arguments are needed to run this example.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {
        //LicenseKey.loadLicenseFile(System.getenv("ITEXT7_LICENSEKEY") + "/itextkey-html2pdf_typography.xml");
        File file = new File(TARGET);
        file.mkdirs();
        new Exemplo2().createPdf(BASEURI, HTML, DEST);
    }

    /**
     * Creates the PDF file.
     *
     * @param baseUri the base URI
     * @param html the HTML as a String
     * @param dest the path to the resulting PDF
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void createPdf(String baseUri, String html, String dest) throws IOException {
        ConverterProperties properties = new ConverterProperties();
        properties.setBaseUri(baseUri);
        HtmlConverter.convertToPdf(html, new FileOutputStream(dest), properties);
    }
}
