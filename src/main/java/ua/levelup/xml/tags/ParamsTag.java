package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("params")
public class ParamsTag extends AbstractTag{
    public ParamsTag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    @Override
    public void print(StringBuilder builder) {
        builder.append("(");
        printChildren(builder);
        builder.append(")");
    }
}
