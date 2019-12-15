package pl.altkom.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ClientDataDAOImpl implements ClientDataDAO {

	public void saveClientData(Client cl, DataSource ds) throws Exception {

        Connection con = null;

        try {
	        con = ds.getConnection();
	        
	        PreparedStatement pstmt = con.prepareStatement(
	        "INSERT INTO klient(id,imie,nazwisko,region,wiek,mezczyzna) values (?,?,?,?,?,?)");
	
	        int m = (cl.getSex().equals("mezczyzna") ? 1 : 0);
	        pstmt.setInt(1, generateId());
	        pstmt.setString(2, cl.getFirstName());
	        pstmt.setString(3, cl.getLastName());
	        pstmt.setString(4, cl.getRegion());
	        pstmt.setInt(5, cl.getAge());
	        pstmt.setInt(6, m);
	        
	        pstmt.executeUpdate();
	        pstmt.close();
        } finally {
        	if (con != null) {
        		con.close();
        	}
        }
	}
	
	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}


	public List readClientsData(String dataSource) throws Exception {

		Connection conn = null;
		List clients = new ArrayList();

		try {
			InitialContext initCtx = new InitialContext();
			Context context = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) context.lookup(dataSource);
			conn = ds.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT id, imie, nazwisko, region, wiek, mezczyzna FROM klient");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Client cl = new Client();
				cl.setId(rs.getInt(1));
				cl.setFirstName((rs.getString(2)));
				cl.setLastName(rs.getString(3));
				cl.setRegion(rs.getString(4));
				cl.setAge(rs.getInt(5));
				cl.setSex(rs.getInt(6)==1 ? "mezczyzna" : "kobieta");
				clients.add(cl);
			}

			rs.close();
			pstmt.close();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return clients;
	}

	@Override
	public void removeClient(String fName, String lName, DataSource ds) throws Exception {
		Connection con = null;
		try {
			con = ds.getConnection();
			con.createStatement().
					executeUpdate("delete from klient where imie = '" + fName + "' and nazwisko = '" + lName+"';");
		}finally {
			if(con!=null)
				con.close();
		}
	}
	@Override
	public void removeClient(int id, DataSource ds) throws Exception {
		Connection con = null;
		try {
			con = ds.getConnection();
			con.createStatement().
					executeUpdate("delete from klient where id = " + id +";");
		}finally {
			if(con!=null)
				con.close();
		}
	}

	@Override
	public void editClient(Client c, DataSource ds) throws Exception {
		int plec = c.getSex().equals("mezczyzna") ? 0 : 1;
		Connection con = null;
		try {
			con = ds.getConnection();
			con.createStatement().
					executeUpdate("update klient set imie = '" + c.getFirstName()+"', nazwisko = '"+
							c.getLastName()+"', region = '" + c.getRegion() + "' , wiek = "+c.getAge()+" , " +
							"mezczyzna = "+ plec +" where id = " + c.getId()+";");
		}finally {
			if(con!=null)
				con.close();
		}
	}
}
