package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("statement")
@TagElement("xml")
public class EmptyTag extends AbstractTag{
    public EmptyTag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    @Override
    public void print(StringBuilder builder) {
        printChildren(builder);
    }
}
