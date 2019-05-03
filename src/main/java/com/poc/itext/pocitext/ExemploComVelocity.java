package com.poc.itext.pocitext;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

public class ExemploComVelocity {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("input.encoding", "UTF-8");
        properties.setProperty("output.encoding", "UTF-8");
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        VelocityEngine velocityEngine = new VelocityEngine(properties);

        //velocity.init(ClassLoader.getSystemResource("velocity.properties").getFile());

        VelocityContext context = new VelocityContext();
        context.put("name", "Fulano");
        context.put("lista", new String[]{"Tomate","Cebola", "Macarrão", "Arroz", "Feijão"});


        Writer writer = new StringWriter();

        velocityEngine.mergeTemplate("hello-velocity.vm", "UTF-8", context, writer);

        //Template template = velocity.getTemplate("hello-velocity.vm");
        //template.merge(context, writer);

        System.out.println(writer);

    }
}
