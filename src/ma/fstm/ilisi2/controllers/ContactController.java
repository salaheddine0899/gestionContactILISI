package ma.fstm.ilisi2.controllers;

import java.util.*;

import ma.fstm.ilisi2.models.bo.Contact;
import ma.fstm.ilisi2.models.dao.*;
import ma.fstm.ilisi2.views.*;
public class ContactController {
	IDaoContact myContact;
	
	
	public ContactController() {
		myContact=new DaoContactImpl();
	}
	
	public Boolean deleteContact(Long id) {
		return myContact.delete(id);
	}
	
	public Collection<Contact> searchByKeyword(String keyword){
		return myContact.findByKeyword(keyword);
	}
	
	public void updateContact(Long id,String firstName,String lastName,String phone) {
		Contact contact=new Contact(firstName, lastName, phone);
		contact.setId(id);
		myContact.update(contact);
		WelcomePage welcomeContact=new WelcomePage();
		
		welcomeContact.getMsg().setText("the update has been done");
		welcomeContact.setVisible(true);
	}
	
	public void updatePage(Long id) {
		Contact contact= myContact.findByID(id);
		UpdatePage updatePage=new UpdatePage(contact);
		updatePage.setVisible(true);
	}

	public void addContactPage() {
		FrameContact fContact=new FrameContact();
		fContact.setVisible(true);
	}
	
	public boolean addContact(String firstName,String lastName,String phone) {
		if(phone.length()>0){
			Contact contact=new Contact(firstName, lastName, phone);
			myContact.add(contact);
			WelcomePage welcomeContact=new WelcomePage();
			
			welcomeContact.getMsg().setText("Welcome Mr/Mrs "+lastName+" "+firstName);
			welcomeContact.setVisible(true);
			return true;
		}
		return false;
	}
	
	public Collection<Contact> getAllContacts(){
		return myContact.getAll();
	}
	
	public void listContactPage(){
		ListContactPage listContactPage=new ListContactPage();
		listContactPage.setVisible(true);
	}
	
	public void backHome() {
		HomePage home=new HomePage();
		home.setVisible(true);
	}
}
