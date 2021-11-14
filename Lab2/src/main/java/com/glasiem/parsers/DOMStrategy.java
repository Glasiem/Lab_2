package com.glasiem.parsers;

import com.glasiem.articles.Article;

import java.io.File;
import java.util.List;

public class DOMStrategy implements Strategy{
    @Override
    public List<Article> strategyParse(File xmlFile, String search) {
        System.out.println("DOM");
        DOM dom = new DOM();
        return dom.parseDOM(xmlFile,search);
    }
}
