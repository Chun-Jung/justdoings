package com.justdoings.keyword.model;

import java.util.List;

public interface KeywordService {
	
	void insert(String word);

	void delete(Keyword keyword);

	List<Keyword> getAllBy(String word);
}
