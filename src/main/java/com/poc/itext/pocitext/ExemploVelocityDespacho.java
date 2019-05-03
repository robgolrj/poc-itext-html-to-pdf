package com.poc.itext.pocitext;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.*;
import java.util.Properties;

public class ExemploVelocityDespacho {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("input.encoding", "UTF-8");
        properties.setProperty("output.encoding", "UTF-8");
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        VelocityEngine velocityEngine = new VelocityEngine(properties);

        //velocity.init(ClassLoader.getSystemResource("velocity.properties").getFile());

        VelocityContext context = new VelocityContext();

        String body = "<p>Primeiro paragrafo</p><ol><li>primeiro item<ol><li>sub item</li><li>segundo sub item</li></ol></li><li>seungo item</li></ol><p>&nbsp;</p><p>segundo pagrafago</p><ol><li>primeiro item seungo paragrafo</li><li>segundo item seundog grafato</li></ol><p>&nbsp;</p><p>ultimo pargrafo</p><ul><li>item lista desordenada</li><li>segundo item listadesordenada</li></ul>";

        context.put("body", body);


        Writer writer = new StringWriter();

        velocityEngine.mergeTemplate("templates/template_despacho.vm", "UTF-8", context, writer);


        //Template template = velocity.getTemplate("hello-velocity.vm");
        //template.merge(context, writer);

        new ExemploVelocityDespacho().convertendoDespachoExamplo(writer.toString());

    }


    public void convertendoDespachoExamplo(String html) throws IOException {
        /** The Base URI of the HTML page. */
        String BASEURI = "src/main/resources/templates/";
        /** The path to the source HTML file. */
        String SRC = String.format("%smodelo_despacho.htm", BASEURI);
        /** The target folder for the result. */
        String TARGET = "target/results/ch01/";
        /** The path to the resulting PDF file. */
        String DEST = String.format("%stest-04.pdf", TARGET);

        // LicenseKey.loadLicenseFile(System.getenv("ITEXT7_LICENSEKEY") + "/itextkey-html2pdf_typography.xml");
        File file = new File(TARGET);
        file.mkdirs();
        createPdf(BASEURI, SRC, DEST, html);
    }

    public void createPdf(String baseUri, String src, String dest, String html) throws IOException {
        ConverterProperties properties = new ConverterProperties();
        properties.setBaseUri(baseUri);
        HtmlConverter.convertToPdf(html, new FileOutputStream(dest), properties);
    }


}
