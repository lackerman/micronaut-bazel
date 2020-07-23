package me.a6n.bookmarker.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import me.a6n.bookmarker.bookmarks.Bookmark;
import me.a6n.bookmarker.bookmarks.BookmarkService;

import javax.inject.Inject;
import java.util.List;

@Controller("/bookmarks")
public class BookmarksController {

    private final BookmarkService service;

    @Inject
    public BookmarksController(BookmarkService service) {
        this.service = service;
    }

    @Get
    public List<Bookmark> all() {
        return service.getAll();
    }
}
