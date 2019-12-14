package pl.altkom.web;


import javax.sql.DataSource;
import java.util.List;

public interface ClientDataDAO {
	
	public void saveClientData(Client client,DataSource ds) throws Exception;
	public List readClientsData(String dataSource) throws Exception;
}
