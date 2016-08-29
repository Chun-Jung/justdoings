package com.justdoings.keyword.model;

import java.util.List;

public interface KeywordDao {

	void insert(Keyword keyword);
	
	void delete(Keyword keyword);
	
	List<Keyword> getAllBy(String word);
}
