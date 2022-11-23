package com.ems.EmployeeManagementService.repositories.search;

import com.ems.EmployeeManagementService.entites.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;


public interface EmployeeRepositorySearch extends ElasticsearchRepository<Employee,Long>, EmployeeSearchRepositoryInternal{

}

interface EmployeeSearchRepositoryInternal {
    Page<Employee> search(String query, Pageable pageable);

    List<Employee> search(String query);
}



class EmployeeSearchRepositoryInternalImpl implements EmployeeSearchRepositoryInternal {

    private final ElasticsearchRestTemplate elasticsearchTemplate;

    EmployeeSearchRepositoryInternalImpl(ElasticsearchRestTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }


    @Override
    public Page<Employee> search(String query, Pageable pageable) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryStringQuery(query));
        nativeSearchQuery.setPageable(pageable);
        nativeSearchQuery.setTrackTotalHits(true);
        nativeSearchQuery.setTrackTotalHitsUpTo(Integer.MAX_VALUE);
        SearchHits<Employee> searchHits = elasticsearchTemplate.search(nativeSearchQuery, Employee.class);

        List<Employee> hits = searchHits
                .map(SearchHit::getContent)
                .stream()
                .collect(Collectors.toList());

        return new PageImpl<>(hits, pageable, searchHits.getTotalHits());

    }

    @Override
    public List<Employee> search(String query) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryStringQuery(query));
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        nativeSearchQuery.setPageable(pageable);
        nativeSearchQuery.setTrackTotalHits(true);
        nativeSearchQuery.setTrackTotalHitsUpTo(Integer.MAX_VALUE);
        SearchHits<Employee> searchHits = elasticsearchTemplate.search(nativeSearchQuery, Employee.class);

        return searchHits
                .map(SearchHit::getContent)
                .stream()
                .collect(Collectors.toList());
    }

}
