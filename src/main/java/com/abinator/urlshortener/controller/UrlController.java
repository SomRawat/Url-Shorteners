package com.abinator.urlshortener.controller;

import com.abinator.urlshortener.entry.Url;
import com.abinator.urlshortener.services.manager.UrlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/urlShortener")
public class UrlController {

    @Autowired
    private UrlManager urlManager;

    @PostMapping("/{url}")
    public ResponseEntity<Url> shortenUrl(@PathVariable String url) {
        Url shortUrlEntry = urlManager.shortenUrl(url);
        return ResponseEntity.ok(shortUrlEntry);
    }

    @GetMapping("/{key}")
    public ResponseEntity<String> getUrl(@PathVariable String key) {
        String url = urlManager.getUrlByKey(key);
        if (url != null) {
            return ResponseEntity.ok(url);
        }
        return ResponseEntity.notFound().build();
    }
}
