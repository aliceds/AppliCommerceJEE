/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesauxdonnees;

import javax.sql.DataSource;
import org.mariadb.jdbc.MariaDbDataSource;

/**
 *
 * @author Alain
 */
public class SourceMariaDB {
    
    public static DataSource getSource() throws Exception {
        // création d'un objet Properties à parir du fichier 
        
//        Properties props = new Properties();
//        FileInputStream fichier = new FileInputStream("/connexion.properties");
//        props.load(fichier);
//        MariaDbDataSource ds = new MariaDbDataSource();
//        ds.setPortNumber(Integer.parseInt(props.getProperty("port")));
//        ds.setDatabaseName(props.getProperty("service"));
//        ds.setServerName(props.getProperty("serveur"));
//        ds.setUser(props.getProperty("user"));
//        ds.setUserName(props.getProperty("userName"));
//        ds.setPassword(props.getProperty("pwd"));
//        return ds;

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
