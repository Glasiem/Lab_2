package com.glasiem.xmlupdate;

import com.glasiem.articles.Article;

import java.io.*;
import java.util.List;

public class XMLUpdate {
    private FileOutputStream out = null;

    public void updateXML(List<Article> articles){
        try {
            out = new FileOutputStream("temp.xml");
            BufferedWriter bo = new BufferedWriter(new OutputStreamWriter(out));
            bo.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            bo.newLine();
            bo.write("<?xml-stylesheet type=\"\" ?>");
            bo.newLine();
            bo.write("<articles type=\"root\">");
            bo.newLine();
            for (int i = 0; i < articles.size(); i++) {
                bo.write("<article id=\"" + i + "\">");
                bo.newLine();
                bo.write("<title>" + articles.get(i).getTitle() + "</title>");
                bo.newLine();
                bo.write("<annotation>" + articles.get(i).getAnnotation() + "</annotation>");
                bo.newLine();
                bo.write("<author>" + articles.get(i).getAuthor() + "</author>");
                bo.newLine();
                bo.write("<location>" + articles.get(i).getLocation() + "</location>");
                bo.newLine();
                bo.write("<review>" + articles.get(i).getReview() + "</review>");
                bo.newLine();
                bo.write("</article>");
                bo.newLine();
            }
            bo.write("</articles>");
            bo.close();
        } catch (Exception ex) {
            System.out.println("ERROR");
        }
    }
}
