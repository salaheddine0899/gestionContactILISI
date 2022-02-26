package ma.fstm.ilisi2.models.dao;

import java.util.Collection;

import ma.fstm.ilisi2.models.bo.Contact;

public interface IDaoContact {
	boolean add(Contact contact);
	boolean delete(Long id);
	boolean update(Contact contact);
	Contact findByID(Long id);
	Collection<Contact> getAll();
	Collection<Contact> findByKeyword(String keyword);
}
