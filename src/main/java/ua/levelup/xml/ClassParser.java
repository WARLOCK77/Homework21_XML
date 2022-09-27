package ua.levelup.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.levelup.xml.tags.Tag;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

public class ClassParser extends DefaultHandler {

    Tag currentElement;
    Tag root;

    public static void main(String[] args) {
        new ClassParser().parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("type.xml"));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        pushTagElement(qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        popTagElement();
    }

    @Override
    public void endDocument() {
        StringBuilder builder = new StringBuilder();
        root.print(builder);

        System.out.println(builder);
    }

    private void pushTagElement(String qName, Attributes attributes) {
        Tag tag = TagFactory.createTagElement(currentElement, qName, attributes);
        if (currentElement == null) {
            root = currentElement = tag;
        } else {
            currentElement.getChildren().add(tag);
            currentElement = tag;
        }
    }

    private void popTagElement() {
        if (currentElement == null) {
            throw new IllegalStateException("Current Element is null");
        }

        currentElement = currentElement.getParent();
    }

    private void parse(InputStream inputStream) {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = parserFactory.newSAXParser();
            parser.parse(inputStream, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
