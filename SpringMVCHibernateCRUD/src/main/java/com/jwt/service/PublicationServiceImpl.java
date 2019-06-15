package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.PublicationDao;
import com.jwt.model.Publication;
@Service
public class PublicationServiceImpl implements PublicationService {
	
	@Autowired
	private PublicationDao publicationDao;
	
	public void setPublicationDao(PublicationDao publicationDao) {
		this.publicationDao = publicationDao;
	}

	@Override
	@Transactional
	public void addPublication(Publication publication) {
		publicationDao.addPublication(publication);

	}

	@Override
	@Transactional
	public List<Publication> getPublications() {
		// TODO Auto-generated method stub
		return publicationDao.getPublications();
	}

	@Override
	@Transactional
	public Publication getPublication(int pubId) {
		// TODO Auto-generated method stub
		return publicationDao.getPublication(pubId);
	}

	@Override
	@Transactional
	public void deletePublication(int pubId) {
		publicationDao.deletePublication(pubId);

	}

}
