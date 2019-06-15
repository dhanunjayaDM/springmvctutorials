package com.jwt.dao;

import java.util.List;

import com.jwt.model.CreditCard;

public interface CreditcardDAO {
	List<CreditCard> getAll(Integer personId);
	List<CreditCard> getAll();
	CreditCard get( Integer id );
	void add(Integer personId, CreditCard creditCard);
	void delete(Integer id);
	void edit(CreditCard creditCard);

}
