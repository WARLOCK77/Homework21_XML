package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("field")
public class FieldTag extends AbstractTag{
    public FieldTag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    //<field name = "id" access_modifier="private static" type="long" />
    @Override
    public void print(StringBuilder builder) {
        builder.append(getAttr("access_modifier"))
                .append(" ")
                .append(getAttr("type"))
                .append(" ")
                .append(getAttr("name"));
        if(getAttr("value")!=null){
            builder.append("=").append(getAttr("value"))
                    .append(";\n");
        }
        else builder.append(";\n");
    }
}
