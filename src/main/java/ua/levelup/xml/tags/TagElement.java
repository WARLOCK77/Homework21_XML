package ua.levelup.xml.tags;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(TagElements.class)
public @interface TagElement {
    String value();
}
