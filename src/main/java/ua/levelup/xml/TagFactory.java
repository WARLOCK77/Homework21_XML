package ua.levelup.xml;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.xml.sax.Attributes;
import ua.levelup.xml.tags.Tag;
import ua.levelup.xml.tags.TagElement;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TagFactory {

    private static Map<String, Class<? extends Tag>> tagClassesMap = new HashMap<>();

    static {
        initTagsClasses();
    }

    private static void initTagsClasses() {
        Reflections reflections = new Reflections("ua.levelup.xml.tags", Scanners.SubTypes);
        Set<Class<? extends Tag>> subTypesOf = reflections.getSubTypesOf(Tag.class);
        for(Class<? extends Tag> type : subTypesOf) {
            for(TagElement tagElement : type.getDeclaredAnnotationsByType(TagElement.class)){
                tagClassesMap.put(tagElement.value(), type);
            }
        }
    }

    public static Tag createTagElement(Tag currentElement, String qname, Attributes attributes) {
        Class<? extends Tag> tag = tagClassesMap.get(qname);
        if(tag == null) {
            throw new IllegalStateException("Couldn't find element with name " + qname);
        }
        //Tag parent, String qname, Attributes attributes
        try {
            Constructor<? extends Tag> declaredConstructor = tag.getDeclaredConstructor(Tag.class, String.class, Attributes.class);
            return declaredConstructor.newInstance(currentElement, qname, attributes);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
