/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdvendas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
               
        }catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
}
