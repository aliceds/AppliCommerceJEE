package accesauxdonnees;

import javax.sql.DataSource;
import org.mariadb.jdbc.MariaDbDataSource;

/**
 *
 * @author Lea
 */
public class SourceMariaDB {
    
    public static DataSource getSource() throws Exception {
        MariaDbDataSource ds = new MariaDbDataSource();
        ds.setPortNumber(Integer.parseInt("3306"));
        ds.setDatabaseName("p1519286");
        ds.setServerName("iutdoua-web.univ-lyon1.fr");
        ds.setUserName("p1519286");
        ds.setUser("p1519286");
        ds.setPassword("255553");
        return ds;
    }
}
