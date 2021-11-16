package com.glasiem.parsers;

import com.glasiem.articles.Article;

import java.io.File;
import java.util.List;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Article> executeStrategy(File xmlFile, String search)
    {
        return strategy.strategyParse(xmlFile,search);
    }
}
