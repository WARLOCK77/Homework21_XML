package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("systemprint")
public class SystemprintTag extends AbstractTag{
    public SystemprintTag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    @Override
    public void print(StringBuilder builder) {

        builder.append("System.out.println(\"")
                .append(getAttr("arg"))
                .append("\");");
    }
}
