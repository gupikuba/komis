package pl.altkom.DAO;


import pl.altkom.web.Client;

import javax.sql.DataSource;
import java.util.List;

public interface ClientDataDAO {
	
	public void saveClientData(Client client, DataSource ds) throws Exception;
	public List readClientsData(String dataSource) throws Exception;
	public void removeClient(String fName, String lName, DataSource ds)throws Exception;
	public void removeClient(int id, DataSource ds)throws Exception;
	public void editClient(Client c, DataSource ds)throws Exception;
}
