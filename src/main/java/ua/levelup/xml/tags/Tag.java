package ua.levelup.xml.tags;

import java.util.List;

public interface Tag {
    void print(StringBuilder builder);

    Tag getParent();

    List<Tag> getChildren();
}
