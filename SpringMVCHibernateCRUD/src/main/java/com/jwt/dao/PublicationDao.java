package com.jwt.dao;

import java.util.List;

import com.jwt.model.Publication;

public interface PublicationDao 
{
	void addPublication(Publication publication);
	List<Publication> getPublications();
	Publication getPublication(int pubId);
	void deletePublication(int pubId);

}
