package com.ranjit.paginationapp.repo.service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ranjit.paginationapp.PaginationApp;
import com.ranjit.paginationapp.model.BookDetails;
import com.ranjit.paginationapp.repository.BookRepo;

@Service
public class BookDetatilServiceImpl implements BookDetailService {
	private static final Logger LOGGER = LogManager.getLogger(BookDetatilServiceImpl.class);

	@Autowired
	private BookRepo repo;

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<BookDetails> findPagedResultBySomethingElseId(int offset, int limit) {
		List<BookDetails> detais = new ArrayList<>();
		List<Object[]> resultList = null;
		try {
			String query = "select  m.title as title , m.author as author from BookDetails as m";

			Session session = em.unwrap(Session.class);
			@SuppressWarnings("unchecked")

			Query queryData = session.createQuery(query);
			queryData.setFirstResult(offset);
			queryData.setMaxResults(limit);
			resultList = queryData.getResultList();
			resultList.stream().forEach((record) -> {
				BookDetails book = new BookDetails();
				book.setAuthor((String) record[0]);
				book.setTitle((String) record[1]);
				book.setPrice((String) record[3]);
				byte[] getImageInBytes = (byte[]) record[4];
				book.setImage(getImageInBytes);
				detais.add(book);
			});
			return detais;

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return detais;
	}

	@Override
	public void save(BookDetails bookDetatils) {
		try {
			repo.save(bookDetatils);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public String description(int id) {
		return repo.findById(id).get().getDescription();
	}

}
