package com.glasiem.htmloutput;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HTMLOutput {
    public void convert(){
        try {
            TransformerFactory tFactory=TransformerFactory.newInstance();

            Source xslDoc=new StreamSource("pattern.xsl");
            Source xmlDoc=new StreamSource("temp.xml");

            String outputFileName="Info.html";

            OutputStream htmlFile=new FileOutputStream(outputFileName);
            Transformer transform=tFactory.newTransformer(xslDoc);
            transform.transform(xmlDoc, new StreamResult(htmlFile));
        }
        catch(Exception ex){
            System.out.println("ERROR");
        }
    }
}
