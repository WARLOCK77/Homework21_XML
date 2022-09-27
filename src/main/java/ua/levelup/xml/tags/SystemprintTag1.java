package ua.levelup.xml.tags;

import org.xml.sax.Attributes;
@TagElement("systemprint1")
public class SystemprintTag1 extends AbstractTag{
    public SystemprintTag1(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    @Override
    public void print(StringBuilder builder) {
        builder.append("System.out.println(")
                .append(getAttr("arg"))
                .append(");\n");
    }
}
