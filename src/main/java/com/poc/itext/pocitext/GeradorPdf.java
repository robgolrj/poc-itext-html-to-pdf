package com.poc.itext.pocitext;

import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GeradorPdf {
    public static final String TARGET = "target/results/";


    public static void main(String[] args) throws IOException {
        File file = new File(TARGET);
        file.mkdirs();

        for (int i = 1; i <= 100; i++) {
            String numero = "000" + i;
            numero = numero.substring(numero.length()-3, numero.length());
            String html = "<title>Documento Teste "+ numero + "</title>" +
                    "<p>" +
                    "   <center>" +
                    "       <p>" +
                    "           <font face=\"verdana\" size=\"16\">" +
                    "               </br>Documento Teste "+ numero + "</br>" +
                    "           </font>" +
                    "       </p>" +
                    "   </center>" +
                    "       <p style='text-align:justify;'>" +
                    "           Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus malesuada enim semper tortor varius volutpat. Curabitur nisi odio, efficitur quis iaculis non, blandit a tortor. Donec efficitur sodales tellus, ut interdum purus aliquam ut. Mauris consequat eu sapien sagittis vestibulum. Morbi neque sem, elementum eget posuere sit amet, rutrum id tellus. Donec convallis pellentesque metus quis suscipit. Fusce non tincidunt odio. Aliquam commodo finibus ex vel eleifend. Aliquam pretium, purus ut finibus iaculis, ligula turpis ullamcorper elit, et egestas sapien tellus quis dui. Ut fringilla dolor eget consequat ullamcorper. In hac habitasse platea dictumst. Duis non tempus elit, sit amet scelerisque eros. Proin commodo augue lacus, a semper nisi suscipit nec.\n" +
                    "       </p>" +
                    "       <p style='text-align:justify;'>" +
                    "           Nunc viverra lectus at diam pulvinar rutrum. Sed dolor leo, tempus a leo vitae, vehicula rutrum augue. Vivamus ut est dui. Mauris quis ultricies elit. Mauris scelerisque dapibus arcu, non aliquet velit pretium in. Aenean quis porttitor lacus. In est ex, lobortis in sem viverra, fringilla mollis libero. Etiam lectus ex, pellentesque id massa eget, cursus dapibus ante. Nunc sit amet nisi et ipsum blandit rhoncus. Phasellus lacinia sem vitae tempus mattis. Curabitur maximus accumsan ex, in scelerisque tellus interdum quis. Ut in orci pretium, imperdiet massa quis, accumsan arcu. Aliquam in varius risus, eget hendrerit magna. Duis sagittis ac lorem eget ornare. Nulla facilisi.\n" +
                    "       </p>" +
                    "       <p style='text-align:justify;'>" +
                    "           Quisque vestibulum auctor lectus, eu volutpat risus maximus at. Mauris malesuada ligula lectus, nec tincidunt magna pellentesque dapibus. Aenean quis varius nisi. In vel augue sed augue auctor imperdiet. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris risus magna, faucibus quis convallis at, lobortis nec nisl. In rhoncus sapien vitae lorem faucibus laoreet." +
                    "       </p>" +
                    "</p>";

            new GeradorPdf().createPdf(html, String.format("%sDocumento "+ numero +".pdf", TARGET));
        }

    }

    public void createPdf(String html, String dest) throws IOException {
        HtmlConverter.convertToPdf(html, new FileOutputStream(dest));
    }
}
