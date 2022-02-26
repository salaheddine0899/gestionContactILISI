package ma.fstm.ilisi2.models.dao;

import java.sql.Connection;
import java.util.Collection;

import ma.fstm.ilisi2.models.bo.Contact;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=ConnectionDb.getConnection();
		DaoContactImpl dc=new DaoContactImpl();
		Collection<Contact> contacts=dc.getAll();
		Contact contact=dc.findByID(Long.valueOf(1));
		System.out.println(contact);
		/*for(Contact c:contacts) {
			System.out.println(c);
		}*/
	}

}
