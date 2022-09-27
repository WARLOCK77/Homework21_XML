package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("param")
public class ParamTag extends AbstractTag{
    public ParamTag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    //<param name="args" type="String" isArray="T"/>
    @Override
    public void print(StringBuilder builder) {

        builder.append(getAttr("type"));
        if(getAttr("isArray").equals("T")) {
            builder.append("[]");
        }

        builder.append(" ").append(getAttr("name"));

    }
}
