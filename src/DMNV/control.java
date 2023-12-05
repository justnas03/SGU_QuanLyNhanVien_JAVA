package DMNV;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class control {
	static database db;
	public static class TableListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if (!e.getValueIsAdjusting()) {
				
                int selectedRow = GUI.getTable().getSelectedRow();
                int selectedColumn = GUI.getTable().getSelectedColumn();
                if (selectedRow != -1 && selectedColumn != -1) {
                    String value = (String) GUI.getTable().getValueAt(selectedRow, selectedColumn);
                    
                    String hoten = (String) GUI.getTable().getValueAt(selectedRow, 1);
                    GUI.getHoTenTF().setText(hoten);
                    
                    String ngaysinh = (String) GUI.getTable().getValueAt(selectedRow, 2);
                    GUI.getNgaysinhTF().setText(ngaysinh);
                    
                    String diachi = (String) GUI.getTable().getValueAt(selectedRow, 3);
                    GUI.getDiaChiTF().setText(diachi);
                    
                    String sdt = (String) GUI.getTable().getValueAt(selectedRow, 4);
                    GUI.getDienThoaiTF().setText(sdt);       	
                }
			}
		}
	}
	public static class ButtonListener implements ActionListener{
		
		public void clear() {
			GUI.getHoTenTF().setText("");
			GUI.getDienThoaiTF().setText("");
			GUI.getDiaChiTF().setText("");
			GUI.getNgaysinhTF().setText("");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == GUI.getCancelButton()) {
				clear();
			} else if (e.getSource() == GUI.getExitButton()) {
				System.exit(0);
			} else if (e.getSource() == GUI.getAddButton()) {
				String hoten = GUI.getHoTenTF().getText();
				String sdt = GUI.getDienThoaiTF().getText();
				String ngay_sinh = GUI.getNgaysinhTF().getText();
				String bangcap = (String) GUI.getBangcapCB().getSelectedItem();
				String dia_chi = GUI.getDiaChiTF().getText();
				
				new Nhanvien(hoten,ngay_sinh,dia_chi,sdt,bangcap);
				
				try {
					database.Insert(Nhanvien.getHo_ten(), Nhanvien.getNgay_sinh(), Nhanvien.getDia_chi(), Nhanvien.getSdt(), Nhanvien.getBangcap());
					Frame frame = new Frame("Success!");
					JOptionPane.showMessageDialog(frame, "Sucessfully Added!","Success",JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				database.printTable();
				clear();
			} else if (e.getSource() == GUI.getDelButton()) {
				int selectedRow = GUI.getTable().getSelectedRow();
                String id_String = (String) GUI.getTable().getValueAt(selectedRow, 0);
				try {
					database.DeleteData(id_String);
					Frame frame = new Frame("Success!");
					JOptionPane.showMessageDialog(frame, "Sucessfully Deleted!","Success",JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				database.printTable();
				clear();
			} else if (e.getSource() == GUI.getSaveButton()) {
				Frame frame = new Frame("Success!");
				JOptionPane.showMessageDialog(frame, "Sucessfully Saved!","Success",JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
				
			} else if (e.getSource() == GUI.getEditButton()) {
				
				String hoten = GUI.getHoTenTF().getText();
				String sdt = GUI.getDienThoaiTF().getText();
				String ngaysinh = GUI.getNgaysinhTF().getText();
				String bangcap = (String) GUI.getBangcapCB().getSelectedItem();
				String diachi = GUI.getDiaChiTF().getText();
				
				int selectedRow = GUI.getTable().getSelectedRow();
                String id_String = (String) GUI.getTable().getValueAt(selectedRow, 0);

				try {
					database.edit(id_String,hoten,ngaysinh,diachi,sdt,bangcap);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				database.printTable();
			}
			
		}
		
	}
	
}
