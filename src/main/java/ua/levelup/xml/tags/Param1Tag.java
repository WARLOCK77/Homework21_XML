package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

//<param1 name1="par1" type1="int" name2="par2" type2="double"/>
@TagElement("param1")
public class Param1Tag extends AbstractTag{
    public Param1Tag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    @Override
    public void print(StringBuilder builder) {
        builder.append(getAttr("type1")).append(" ")
                .append(getAttr("name1")).append(", ")
                .append(getAttr("type2")).append(" ")
                .append(getAttr("name2"));

    }
}
