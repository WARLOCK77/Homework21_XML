package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("return")
public class ReturnTag extends AbstractTag{
    public ReturnTag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    @Override
    public void print(StringBuilder builder) {
        builder.append("return")
                .append(" ")
                .append(getAttr("action"))
                .append(";");

    }
}
