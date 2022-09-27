package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("body")
public class BodyTag extends AbstractTag{
    public BodyTag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    @Override
    public void print(StringBuilder builder) {

        builder.append("{\n");
        printChildren(builder);
        builder.append("\n}\n");
    }
}
