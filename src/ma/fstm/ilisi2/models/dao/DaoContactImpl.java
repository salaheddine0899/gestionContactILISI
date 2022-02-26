package ma.fstm.ilisi2.models.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.xdevapi.PreparableStatement;

import ma.fstm.ilisi2.models.bo.*;

public class DaoContactImpl implements IDaoContact{
	@Override
	public boolean add(Contact contact) {
		// TODO Auto-generated method stub
		Connection connection=ConnectionDb.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("insert into contacts(firstName,lastName,phone) values(?,?,?)");
			ps.setString(1, contact.getFirstName());
			ps.setString(2, contact.getLastName());
			ps.setString(3, contact.getPhone());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		Connection connection=ConnectionDb.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("delete from contacts where id=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Contact contact) {
		// TODO Auto-generated method stub
		Connection connection=ConnectionDb.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("update contacts set firstName=?"+
		", lastName=? ,phone=? where id=?");
			ps.setString(1, contact.getFirstName());
			ps.setString(2, contact.getLastName());
			ps.setString(3, contact.getPhone());
			ps.setLong(4, contact.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Contact findByID(Long id) {
		// TODO Auto-generated method stub
		Connection connection=ConnectionDb.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from contacts"+
			" where id=?");
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String firstName=rs.getString("firstName");
				String lastName=rs.getString("lastName");
				String phone=rs.getString("phone");
				Contact contact=new Contact(firstName,lastName,phone);
				contact.setId(id);
				return contact;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	public Collection<Contact> getCollectionFromPreparedStatement(PreparedStatement ps) throws SQLException{
		ResultSet rs=ps.executeQuery();
		Collection<Contact> contacts=new ArrayList<>();
		while(rs.next()) {
			Long id=rs.getLong("id");
			String firstName=rs.getString("firstName");
			String lastName=rs.getString("lastName");
			String phone=rs.getString("phone");
			Contact contact=new Contact(firstName,lastName,phone);
			contact.setId(id);
			contacts.add(contact);
		}
		return contacts;
	}

	@Override
	public Collection<Contact> getAll() {
		Connection connection=ConnectionDb.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from contacts");
			return this.getCollectionFromPreparedStatement(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<Contact> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		Connection connection=ConnectionDb.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from contacts where firstName like?"+
			" or lastName like ? or phone like ?");
			ps.setString(1, "%"+keyword+"%");
			ps.setString(2, "%"+keyword+"%");
			ps.setString(3, "%"+keyword+"%");
			return getCollectionFromPreparedStatement(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
