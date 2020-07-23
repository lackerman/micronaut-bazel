package me.a6n.bookmarker.bookmarks;

import javax.inject.Inject;
import java.util.List;

public class BookmarkService {
    private final BookmarkRepository repository;

    @Inject
    public BookmarkService(BookmarkRepository repository) {
        this.repository = repository;
    }

    public List<Bookmark> getAll() {
        return repository.all();
    }
}
