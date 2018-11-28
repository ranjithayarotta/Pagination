package com.ranjit.paginationapp.repo.service;

import java.util.List;

import com.ranjit.paginationapp.model.BookDetails;

public interface BookDetailService {
	List<BookDetails> findPagedResultBySomethingElseId( int offset, int limit);

	 String description(int id);

	void save(BookDetails bookDetatils);
}
