/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ItemVenda;

/**
 *
 * @author luiz_
 */
public class ItensVendaDAO {
     //Conexão com o banco
    private final Connection conexao;

    public ItensVendaDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    // Método que cadastra itens
    public void cadastraItem(ItemVenda obj){
         try {
            String sql = "INSERT INTO tb_itensvendas (venda_id, produto_id, qtd, subtotal) VALUES (?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());
                                
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro: " + erro);
         }
    }
    
}
