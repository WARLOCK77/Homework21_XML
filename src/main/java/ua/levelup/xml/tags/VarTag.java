package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("var")
public class VarTag extends AbstractTag{
    public VarTag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    @Override
    public void print(StringBuilder builder) {
        builder.append(getAttr("type"))
                .append(" ")
                .append(getAttr("name"))
                .append("=")
                .append(getAttr("value")).append(";\n");

    }
}
