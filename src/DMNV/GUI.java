package DMNV;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
	private static JLabel tieudeLB,thongtinchitietLB, hoTenLB, ngaySinhLB, diaChiLB, dienThoaiLB, bangCapLB;
	private static JTextField hoTenTF, diaChiTF, dienThoaiTF,ngaysinhTF;
	private static JButton addButton, editButton, delButton, saveButton, cancelButton, exitButton;
	private static JPanel panel, inputPanel,tablePanel;
	private static JComboBox ngaysinhCB, bangcapCB;
	private static JTable table;
	private static database db;
	private static control control;
	private static DefaultTableModel model;
	private String[] bangcap = {"Tiến sĩ","Thạc sĩ","Cử nhân","Giáo sư"};
	public GUI() {
		setTitle("formNhanVien");
		setPreferredSize(new Dimension(800,400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(new GridLayout());
		
		
		//Set Look and Feel
		try {	  
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch (Exception e) {
		    System.out.println("Look and Feel is not set!");
		}
		
		//Connect Database
		try {
			db = new database();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		buildInputPanel();
		
		add(panel);
		pack();
		setVisible(true);
	}
	
	private void buildInputPanel() {
		//setup input panel
		inputPanel = new JPanel(new GridLayout(0,2,20,10));
		//create Label
		tieudeLB = new JLabel("DANH MỤC NHÂN VIÊN");
		thongtinchitietLB = new JLabel(" Thông tin chi tiết");
		hoTenLB = new JLabel("  Họ tên:");
		ngaySinhLB = new JLabel("  Ngày sinh (YYYY-MM-DD):");
		diaChiLB = new JLabel("  Địa chỉ:");
		dienThoaiLB = new JLabel("  Điện Thoại:");
		bangCapLB = new JLabel("  Bằng cấp:");
		//create Text Field
		hoTenTF = new JTextField(10);
		ngaysinhCB = new JComboBox(bangcap);
		ngaysinhTF = new JTextField(10);
		diaChiTF = new JTextField(10);
		dienThoaiTF = new JTextField(10);
		bangcapCB = new JComboBox(bangcap);
		//create Buttons
		addButton = new JButton("Thêm");
		delButton = new JButton("Xóa");
		editButton = new JButton("Sửa");
		saveButton = new JButton("Lưu");
		cancelButton = new JButton("Hủy");
		exitButton = new JButton("Thoát");
		
		//Adding components to inputPanel
		inputPanel.add(tieudeLB);
		inputPanel.add(thongtinchitietLB);
		inputPanel.add(hoTenLB);
		inputPanel.add(hoTenTF);
		inputPanel.add(dienThoaiLB);
		inputPanel.add(dienThoaiTF);
		inputPanel.add(ngaySinhLB);
		inputPanel.add(ngaysinhTF);
		inputPanel.add(bangCapLB);
		inputPanel.add(bangcapCB);
		inputPanel.add(diaChiLB);
		inputPanel.add(diaChiTF);
		inputPanel.add(addButton);
		inputPanel.add(delButton);
		inputPanel.add(editButton);
		inputPanel.add(saveButton);
		inputPanel.add(cancelButton);
		inputPanel.add(exitButton);		
		//Event Listener
				addButton.addActionListener(new control.ButtonListener());
				editButton.addActionListener(new control.ButtonListener());;
				delButton.addActionListener(new control.ButtonListener());
				saveButton.addActionListener(new control.ButtonListener());
				cancelButton.addActionListener(new control.ButtonListener());
				exitButton.addActionListener(new control.ButtonListener());
				bangcapCB.addActionListener(new control.ButtonListener());
		
		//setting JTable
				model = new DefaultTableModel();
				table = new JTable(model);
				JScrollPane TBscrollpane = new JScrollPane(table);
		        // Add columns to the table
		        model.addColumn("Mã Nhân Viên");
		        model.addColumn("Họ Tên");
		        model.addColumn("Ngày sinh");
		        model.addColumn("Địa chỉ");
		        model.addColumn("Điện thoại");
		        model.addColumn("Bằng cấp");
		       //Getting Data from database and display it to table
				database.displayTableData();
				
		//setting tablePanel
		        tablePanel = new JPanel(new BorderLayout());
		        tablePanel.add(TBscrollpane);
		        GUI.getTable().getSelectionModel().addListSelectionListener(new control.TableListener());
		        
		//adding inputPanel to panel
				panel.add(inputPanel);
				panel.add(tablePanel);	
	}

	
	//Get/Set
	public static JLabel getThongtinchitietLB() {
		return thongtinchitietLB;
	}
	
	
	
	public static JTextField getNgaysinhTF() {
		return ngaysinhTF;
	}

	public static void setNgaysinhTF(JTextField ngaysinhTF) {
		GUI.ngaysinhTF = ngaysinhTF;
	}

	public String[] getBangcap() {
		return bangcap;
	}

	public void setBangcap(String[] bangcap) {
		this.bangcap = bangcap;
	}

	public static JLabel getTieudeLB() {
		return tieudeLB;
	}

	public static void setTieudeLB(JLabel tieudeLB) {
		GUI.tieudeLB = tieudeLB;
	}

	public static JTextField getDienThoaiTF() {
		return dienThoaiTF;
	}

	public static void setDienThoaiTF(JTextField dienThoaiTF) {
		GUI.dienThoaiTF = dienThoaiTF;
	}

	public static JPanel getInputPanel() {
		return inputPanel;
	}

	public static void setInputPanel(JPanel inputPanel) {
		GUI.inputPanel = inputPanel;
	}

	

	public static JComboBox getNgaysinhCB() {
		return ngaysinhCB;
	}

	public static void setNgaysinhCB(JComboBox ngaysinhCB) {
		GUI.ngaysinhCB = ngaysinhCB;
	}

	public static JComboBox getBangcapCB() {
		return bangcapCB;
	}

	public static void setBangcapCB(JComboBox bangcapCB) {
		GUI.bangcapCB = bangcapCB;
	}

	public static void setThongtinchitietLB(JLabel thongtinchitietLB) {
		GUI.thongtinchitietLB = thongtinchitietLB;
	}

	public static JLabel getHoTenLB() {
		return hoTenLB;
	}

	public static void setHoTenLB(JLabel hoTenLB) {
		GUI.hoTenLB = hoTenLB;
	}

	public static JLabel getNgaySinhLB() {
		return ngaySinhLB;
	}

	public static void setNgaySinhLB(JLabel ngaySinhLB) {
		GUI.ngaySinhLB = ngaySinhLB;
	}

	public static JLabel getDiaChiLB() {
		return diaChiLB;
	}

	public static void setDiaChiLB(JLabel diaChiLB) {
		GUI.diaChiLB = diaChiLB;
	}

	public static JLabel getDienThoaiLB() {
		return dienThoaiLB;
	}

	public static void setDienThoaiLB(JLabel dienThoaiLB) {
		GUI.dienThoaiLB = dienThoaiLB;
	}

	public static JLabel getBangCapLB() {
		return bangCapLB;
	}

	public static void setBangCapLB(JLabel bangCapLB) {
		GUI.bangCapLB = bangCapLB;
	}

	public static JTextField getHoTenTF() {
		return hoTenTF;
	}

	public static void setHoTenTF(JTextField hoTenTF) {
		GUI.hoTenTF = hoTenTF;
	}

	public static JTextField getDiaChiTF() {
		return diaChiTF;
	}

	public static void setDiaChiTF(JTextField diaChiTF) {
		GUI.diaChiTF = diaChiTF;
	}

	public static JButton getAddButton() {
		return addButton;
	}

	public static void setAddButton(JButton addButton) {
		GUI.addButton = addButton;
	}

	public static JButton getEditButton() {
		return editButton;
	}

	public static void setEditButton(JButton editButton) {
		GUI.editButton = editButton;
	}

	public static JButton getDelButton() {
		return delButton;
	}

	public static void setDelButton(JButton delButton) {
		GUI.delButton = delButton;
	}

	public static JButton getSaveButton() {
		return saveButton;
	}

	public static void setSaveButton(JButton saveButton) {
		GUI.saveButton = saveButton;
	}

	public static JButton getCancelButton() {
		return cancelButton;
	}

	public static void setCancelButton(JButton cancelButton) {
		GUI.cancelButton = cancelButton;
	}

	public static JButton getExitButton() {
		return exitButton;
	}

	public static void setExitButton(JButton exitButton) {
		GUI.exitButton = exitButton;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		GUI.panel = panel;
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		GUI.table = table;
	}

	public static DefaultTableModel getModel() {
		return model;
	}

	public static void setModel(DefaultTableModel model) {
		GUI.model = model;
	}
	

}
