package ua.levelup.xml.tags;

import org.xml.sax.Attributes;

@TagElement("package")
public class PackageTag extends AbstractTag{
    public PackageTag(Tag parent, String qname, Attributes attributes) {
        super(parent, qname, attributes);
    }

    @Override
    public void print(StringBuilder builder) {
        builder.append("package ").append(getAttr("name")).append(";\n");
    }
}
