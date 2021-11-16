package com.glasiem.parsers;

import com.glasiem.articles.Article;

import java.io.File;
import java.util.List;

public class SAXStrategy implements Strategy{
    @Override
    public List<Article> strategyParse(File xmlFile, String search) {
        System.out.println("SAX");
        SAX sax = new SAX();
        return sax.parseSAX(xmlFile,search);
    }
}
