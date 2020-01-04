package pl.altkom.DAO;

import pl.altkom.web.CarBean;

import javax.sql.DataSource;

public interface CarInfoDAO {
    public void saveCarInfo(CarBean car, DataSource dataSource);
    public CarBean findCarById(int id, DataSource dataSource);
}
