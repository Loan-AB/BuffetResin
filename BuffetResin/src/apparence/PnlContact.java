package apparence;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import gestionContact.*;

public class PnlContact  extends PnlCentre {

	MonLabel lblTitre;
	MonBouton btnModifier;
	MonBouton btnCreer;
	JList lstContact;
	
	ArrayList<Contact> lContact;
	
	
	public PnlContact(String nom) {
		super(nom);
		// Contact -- Modifier -- Créer
		// Liste des contacts
			//Image + nom de la personne
		btnModifier = new MonBouton("Modifier", true);
		btnCreer = new MonBouton("Créer", true);
		lblTitre = new MonLabel();
		
		lblTitre.setText("Contact");
		lContact = new ArrayList<Contact>();
		lContact.add(new Contact("Baffet", "Lian", "0 666 666 666" , "457 458 74 12", "asd@asd.asd", new ImageIcon("C:\\Users\\loanb\\Downloads\\bg.jpg")));
		lContact.add(new Contact("Beffet", "Lean", "0 666 666 666" , "457 458 74 12", "asd@asd.asd", new ImageIcon("C:\\Users\\loanb\\Downloads\\bg.jpg")));
		lContact.add(new Contact("Buffet", "Loan", "0 666 666 666" , "457 458 74 12", "asd@asd.asd", new ImageIcon("C:\\Users\\loanb\\Downloads\\bg.jpg")));
		lContact.add(new Contact("Biffet", "Luan", "0 666 666 666" , "457 458 74 12", "asd@asd.asd", new ImageIcon("C:\\Users\\loanb\\Downloads\\bg.jpg")));
		
		add(lblTitre);
		add(btnCreer);
		add(btnModifier);
		
		//liste
		
		DefaultListModel lm = new DefaultListModel();

		for (Contact contact : lContact) {
			lm.addElement(contact);
		}
			
		//les élément de la liste
		lstContact = new JList<>(lm);
		lstContact.setCellRenderer(new ContactCellRenderer());
		lstContact.setModel(lm);

		lstContact.setSelectedIndex(0); //pour ne pas avoir d'erreur de ne pas avoir selectionner
		
		
		
		
		JScrollPane scrollPane= new JScrollPane(lstContact); 
		scrollPane.setPreferredSize(new Dimension(460,600));
		
		
		add(scrollPane);
	}
	
	class ContactCellRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object>
	{
	 
	  @Override
	  public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	     Contact entry = (Contact) value;
	 
	     setText(value.toString());
	     setIcon(entry.getImageIcon());
	  
	     if (isSelected) {
	        setBackground(list.getSelectionBackground());
	        setForeground(list.getSelectionForeground());
	     }
	     else {
	        setBackground(list.getBackground());
	        setForeground(list.getForeground());
	     }
	 
	     setEnabled(list.isEnabled());
	     setFont(list.getFont());
	     setOpaque(true);
	 
	     return this;
	  }
	}
	
}
