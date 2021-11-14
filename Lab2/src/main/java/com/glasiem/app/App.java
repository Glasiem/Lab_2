package com.glasiem.app;

import com.glasiem.articles.Article;
import com.glasiem.htmloutput.HTMLOutput;
import com.glasiem.parsers.Context;
import com.glasiem.parsers.DOMStrategy;
import com.glasiem.parsers.SAXStrategy;
import com.glasiem.xmlupdate.XMLUpdate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class App extends JFrame {
    JButton proceed;
    JLabel pathLabel;
    JLabel searchLabel;
    JTextField filePath;
    JTextField search;
    JRadioButton dombutton;
    JRadioButton saxbutton;




    public App(){
        dombutton = new JRadioButton("DOM", true);
        saxbutton = new JRadioButton("SAX", false);
        ButtonGroup group = new ButtonGroup();
        group.add(dombutton);
        group.add(saxbutton);
        pathLabel = new JLabel("Enter XML file path");
        filePath = new JTextField("");
        searchLabel = new JLabel("Enter keyword");
        search = new JTextField("");
        proceed = new JButton("Proceed");
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Context context;
                if (dombutton.isSelected()){
                     context = new Context(new DOMStrategy());
                }
                else{
                    context = new Context(new SAXStrategy());
                }
                List<Article> articles = context.executeStrategy(new File(filePath.getText()),search.getText());
                for (Article article:articles)
                    System.out.println(article.getTitle());
                XMLUpdate updater = new XMLUpdate();
                updater.updateXML(articles);
                HTMLOutput toHTML = new HTMLOutput();
                toHTML.convert();
                articles.clear();
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(pathLabel);
        contents.add(filePath);
        contents.add(searchLabel);
        contents.add(search);
        contents.add(dombutton);
        contents.add(saxbutton);
        contents.add(proceed);
        setContentPane(contents);
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
