package com.glasiem.parsers;

import com.glasiem.articles.Article;

import java.io.File;
import java.util.List;

public interface Strategy {
    public List<Article> strategyParse(File xmlFile, String search);
}
