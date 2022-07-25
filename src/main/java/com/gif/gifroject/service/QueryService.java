package com.gif.gifroject.service;

import com.gif.gifroject.model.Gif;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryService {

    @Autowired
    ElasticsearchRestTemplate elasticsearchTemplate;

    public List<Gif> getGif(String gif) {
        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.wildcardQuery("tags",gif+"*"))
                .build();

        SearchHits<Gif> output =
                elasticsearchTemplate.search(searchQuery, Gif.class, IndexCoordinates.of("gifindex"));

        return output.get().map(SearchHit::getContent).collect(Collectors.toList());
    }
}
