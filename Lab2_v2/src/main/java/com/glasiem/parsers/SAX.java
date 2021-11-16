package com.glasiem.parsers;

import com.glasiem.articles.Article;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SAX {
    private static List<Article> articles = new ArrayList<>();
    private static List<Article> articlesFiltered = new ArrayList<>();

    public List<Article> parseSAX(File xmlFile, String search){
        try{
            articles.clear();
            articlesFiltered.clear();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            AdvancedXMLHandler handler = new AdvancedXMLHandler();
            parser.parse(xmlFile, handler);

            for (Article article : articles) {
                if(articleContains(article,search))
                    articlesFiltered.add(article);
            }

        }
        catch (Exception ex){
            System.out.println("ERROR");
        }
        return articlesFiltered;
    }

    private static class AdvancedXMLHandler extends DefaultHandler {
        private String title, annotation, author, location, review, lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("title"))
                    title = information;
                if (lastElementName.equals("annotation"))
                    annotation = information;
                if (lastElementName.equals("author"))
                    author = information;
                if (lastElementName.equals("location"))
                    location = information;
                if (lastElementName.equals("review"))
                    review = information;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ( (title != null && !title.isEmpty()) &&
                    (annotation != null && !annotation.isEmpty()) &&
                    (author != null && !author.isEmpty()) &&
                    (location != null && !location.isEmpty()) &&
                    (review != null && !review.isEmpty())) {
                articles.add(new Article(title, annotation, author, location, review));
                title = null;
                annotation = null;
                author = null;
                location = null;
                review = null;
            }
        }
    }

    private boolean articleContains(Article article, String search){
        return ((article.getTitle().contains(search)) ||
                (article.getAnnotation().contains(search)) ||
                (article.getAuthor().contains(search)) ||
                (article.getLocation().contains(search)) ||
                (article.getReview().contains(search)));
    }
}
