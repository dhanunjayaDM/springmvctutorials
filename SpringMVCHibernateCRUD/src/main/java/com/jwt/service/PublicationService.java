package com.jwt.service;

import java.util.List;

import com.jwt.model.Publication;

public interface PublicationService {
	void addPublication(Publication publication);
	List<Publication> getPublications();
	Publication getPublication(int pubId);
	void deletePublication(int pubId);

}
