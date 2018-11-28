package com.ranjit.paginationapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ranjit.paginationapp.model.BookDetails;

@Repository
public interface BookRepo extends PagingAndSortingRepository<BookDetails, Integer> {

}
