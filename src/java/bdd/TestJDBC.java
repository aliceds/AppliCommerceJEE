/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author Alice
 */
public class TestJDBC {
    // liste qui contient tous les résultats
    private List<String> messages = new ArrayList<String>();
    
    public List<String> executerTests(HttpServletRequest request) {
       
        return messages;
    }
}
