package com.ranjit.paginationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranjit.paginationapp.model.BookDetails;
import com.ranjit.paginationapp.model.CountSetter;
import com.ranjit.paginationapp.repo.service.BookDetailService;

@RestController
@RequestMapping("/paginationapp")
public class RequestHandler {

	@Autowired
	private BookDetailService service;

	@Autowired
	private CountSetter setterObject;

	@GetMapping("/getData")
	public List<BookDetails> fetchDetails() {
		List<BookDetails> bookDetails = service.findPagedResultBySomethingElseId(setterObject.getStart(),
				setterObject.getStart() + 10);
		setterObject.setStart(setterObject.getStart() + 10);
		return bookDetails;
	}

	@GetMapping("/insertData")
	public void insetData(BookDetails details) {
		service.save(details);
	}

	@GetMapping("/getDescription")
	public void getDescription(@PathVariable("id") int startvalue) {
		service.description(startvalue);

	}

}
