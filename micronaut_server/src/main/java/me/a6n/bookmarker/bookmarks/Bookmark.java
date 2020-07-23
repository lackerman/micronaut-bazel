package me.a6n.bookmarker.bookmarks;

import lombok.Builder;
import lombok.Data;
import java.net.URL;

@Data
@Builder
public class Bookmark {
    private final String id;
    private final URL url;
    private final String title;
    private final String description;
}
