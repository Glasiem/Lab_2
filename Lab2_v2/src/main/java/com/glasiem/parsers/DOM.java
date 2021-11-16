package com.glasiem.parsers;

import com.glasiem.articles.Article;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DOM {
    private static List<Article> articles = new ArrayList<>();

    public List<Article> parseDOM(File xmlFile, String search) {
        try{
            articles.clear();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            NodeList articleElements = document.getDocumentElement().getElementsByTagName("article");
            for (int i = 0; i < articleElements.getLength(); i++) {
                Node article = articleElements.item(i);
                NamedNodeMap attributes = article.getAttributes();
                if (article.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) article;
                    if (articleContains(element, search)) {
                        articles.add(new Article(element.getElementsByTagName("title").item(0).getTextContent(),
                                element.getElementsByTagName("annotation").item(0).getTextContent(),
                                element.getElementsByTagName("author").item(0).getTextContent(),
                                element.getElementsByTagName("location").item(0).getTextContent(),
                                element.getElementsByTagName("review").item(0).getTextContent()));
                    }
                }
            }

        }
        catch (Exception ex){
            System.out.println("ERROR");
        }
        return articles;
    }

    private boolean articleContains(Element element, String search){
        return ((element.getElementsByTagName("title").item(0).getTextContent().contains(search)) ||
        (element.getElementsByTagName("annotation").item(0).getTextContent().contains(search)) ||
        (element.getElementsByTagName("author").item(0).getTextContent().contains(search)) ||
        (element.getElementsByTagName("location").item(0).getTextContent().contains(search)) ||
        (element.getElementsByTagName("review").item(0).getTextContent().contains(search)));
    }
}
