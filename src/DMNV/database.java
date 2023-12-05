package DMNV;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.ResultSetMetaData;


public class database {
	
	public static final String DB_URL = "jdbc:derby:nhanvienDB";
	
	//Connection and Statement
	public static Connection conn = null;
	public static Statement stm = null;
    
	public database() throws SQLException {
		createConnection();
	}
	
	public static Statement getStatement() {
        return stm;
	}
    public static Connection getConnection() {
        return conn;
    }
    
	public static Connection createConnection() throws SQLException{
		//Create Connection
		conn = DriverManager.getConnection(DB_URL);
		stm = conn.createStatement();
		System.out.println("Connection to nhanvienDB is created.");	
		return conn;
    }
	
	public static void Insert(String ho_ten, String ngaysinh, String dia_chi,String sdt,String bang_cap) throws SQLException{
        stm.executeUpdate("insert into nhanvien values(default,'"+ho_ten+"','"+ngaysinh+"','"+dia_chi+"','"+sdt+"','"+bang_cap+"')");
    }
	
    public static void DropTable(String tablename) throws SQLException{
    	stm.executeUpdate("DROP TABLE " + tablename);
    }
    
    public static void DeleteData(String dieukien) throws SQLException{
        getStatement().executeUpdate("DELETE FROM nhanvien WHERE MA_NHANVIEN=" + dieukien+"");
    }
    
    public static void edit(String ma_nhanvien, String ho_ten, String ngaysinh, String dia_chi,String sdt,String bangcap) throws SQLException {
    	getStatement().executeUpdate("UPDATE nhanvien SET HO_TEN='"+ho_ten+"',NGAY_SINH='"+ngaysinh+"',DIA_CHI='"+dia_chi+"',SO_DIEN_THOAI='"+sdt+"',BANG_CAP='"+bangcap+"' where  MA_NHANVIEN=" + ma_nhanvien);
    }
    
    public static ResultSet Select(String selection, String tablename, String dieukien) throws SQLException {
    	ResultSet result = stm.executeQuery("SELECT "+ selection +" FROM "+ tablename + "WHERE " + dieukien);
        return result;
    }
    
    
    public static ResultSet Query(String statement) {
    	ResultSet RS = null;
		try {
			RS = database.getStatement().executeQuery(statement);
		} catch (SQLException e) {
			e.printStackTrace();  	
		}
		return RS;
    }
    
    
    public static void printTable() { //for delete-add-edit buttons
		//remove all table data elements
		GUI.getModel().getDataVector().removeAllElements();
		GUI.getModel().fireTableDataChanged();
		ResultSet RS = database.Query("select * from nhanvien");
		//print table
		try {
            while (RS.next()) {
                String[] rows = new String[6];
                rows[0] = RS.getString("MA_NHANVIEN");
                rows[1] = RS.getString("HO_TEN");
                rows[2] = RS.getString("NGAY_SINH");
                rows[3] = RS.getString("DIA_CHI");
                rows[4] = RS.getString("SO_DIEN_THOAI");
                rows[5] = RS.getString("BANG_CAP");
                GUI.getModel().addRow(rows);
            }
        } catch (SQLException e1) {
        	e1.printStackTrace();
        }
	}
    
    public static void displayTableData() { //for GUI table
    	try {
        	ResultSet RS = database.Query("select * from nhanvien");
 			while (RS.next()){
 				String S[] = {RS.getString("MA_NHANVIEN"),RS.getString("HO_TEN"),RS.getString("NGAY_SINH"),RS.getString("DIA_CHI"),RS.getString("SO_DIEN_THOAI"), RS.getString("BANG_CAP")};
 				GUI.getModel().addRow(S);
 			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    
	

	
}
