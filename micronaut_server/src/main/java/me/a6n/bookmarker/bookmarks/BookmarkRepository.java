package me.a6n.bookmarker.bookmarks;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Singleton
public class BookmarkRepository {
    private final Map<String, Bookmark> bookmarks;

    @Inject
    public BookmarkRepository() {
        this.bookmarks = new ConcurrentHashMap<>();
        try {
            bookmarks.put("hello", Bookmark.builder()
                    .id("1234")
                    .url(new URL("http://localhost"))
                    .title("Welcome to bookmarker")
                    .description("Blah blah blah")
                    .build());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public List<Bookmark> all() {
        return bookmarks.values().stream()
                .map(b -> Bookmark.builder()
                        .id(b.getId())
                        .description(b.getDescription())
                        .title(b.getTitle())
                        .url(b.getUrl())
                        .build())
                .collect(Collectors.toList());
    }
}
