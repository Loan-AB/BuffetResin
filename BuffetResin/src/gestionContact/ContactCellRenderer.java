package gestionContact;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

	//pour les images (pas bien compris pkoi)
		@SuppressWarnings("serial")
		class ContactCellRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object>
		{
		 
		  @Override
		  public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		     Contact entry = (Contact) value;
		 
		     setText(value.toString());
		     setIcon(entry.getPhoto());
		  
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


