package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractTag implements Tag {

    protected final String qname;
    protected final Tag parent;
    protected final List<Tag> children = new ArrayList<>();
    protected final Map<String, String> attributesMap = new HashMap<>();

    public AbstractTag(Tag parent, String qname, Attributes attributes) {

        this.parent = parent;
        this.qname = qname;

        for(int i=0; i<attributes.getLength(); i++) {
            attributesMap.put(attributes.getQName(i), attributes.getValue(i));
        }
    }

    public List<Tag> getChildren() {
        return children;
    }

    public Tag getParent() {
        return parent;
    }

    protected void printChildren(StringBuilder builder) {
        getChildren().forEach(el -> el.print(builder));
    }

    protected String getAttr(String name) {
        return this.attributesMap.get(name);
    }
}
