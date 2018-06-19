package com.inc.dayary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.dayary.domain.Diary;
import com.inc.dayary.repository.DiaryDao;

@Service
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	private DiaryDao diaryDao;
	
	@Override
	public List<Diary> list() {
		List<Diary> diaryList = diaryDao.list();
		return diaryList;
	}

	@Override
	public void add(Diary diary) {
		diaryDao.add(diary);
	}
	
	

}
