package com.justdoings.keyword.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("keywordService")
public class KeywordServiceImpl implements KeywordService {

	@Autowired
	KeywordDao keywordDao;

	@Override
	@Transactional
	public void save(String word) {
		Keyword keyword = new Keyword();
		keyword.setWord(word);
		keywordDao.save(keyword);
	}

	@Override
	@Transactional
	public void delete(KeywordId keywordId) {
		keywordDao.delete(keywordId);
	}
	
	@Override
	@Transactional
	public void delete(Keyword keyword) {
		keywordDao.delete(keyword);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Keyword> findByWord(String word) {
		return keywordDao.findByWord(word);
	}

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		KeywordService service = (KeywordService) context.getBean("keywordService");
		
		for(int i=0; i<3; i++){
			service.save("AngularJS 2");
			Thread.sleep(1);
		}

		List<Keyword> result = service.findByWord("AngularJS 2");
		for(Keyword keyword : result){
			System.out.println("word: " + keyword.getWord() + ", ts: " + keyword.getQueryTs());
			service.delete(keyword);
		}
	}

}
