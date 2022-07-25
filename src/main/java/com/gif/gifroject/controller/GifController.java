package com.gif.gifroject.controller;

import com.gif.gifroject.model.Gif;
import com.gif.gifroject.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gif")
public class GifController {

    @Autowired
    private QueryService service;

    @GetMapping("/{gifsearch}")
    public List<String> getGif(@PathVariable String gifsearch)
    {
        List<Gif> gifs = service.getGif(gifsearch);
        List<String> listurl = new ArrayList<String>();

        for (Gif giffy : gifs) {
            listurl.add(giffy.getUrl());
        }
        return listurl;
    }
}
