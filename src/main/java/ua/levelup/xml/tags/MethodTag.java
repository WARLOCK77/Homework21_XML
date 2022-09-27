package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("method")
public class MethodTag extends AbstractTag{
    public MethodTag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    //<method name ="main" access_modifier="public" type="static" return_type="void">
    @Override
    public void print(StringBuilder builder) {

        builder.append(getAttr("access_modifier"))
                .append(" ")
                .append(getAttr("type"))
                .append(" ")
                .append(getAttr("return_type"))
                .append(" ")
                .append(getAttr("name"));

        printChildren(builder);

    }
}
