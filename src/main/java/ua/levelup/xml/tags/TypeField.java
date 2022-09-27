package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("type")
public class TypeField extends AbstractTag{
    public TypeField(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    //<type name = "Configuration" access_modifier="public">
    @Override
    public void print(StringBuilder builder) {
        builder.append(getAttr("access_modifier"))
                .append(" ")
                .append("class ")
                .append(getAttr("name"))
                .append(" {\n");
        printChildren(builder);

        builder.append("\n}");
    }
}
