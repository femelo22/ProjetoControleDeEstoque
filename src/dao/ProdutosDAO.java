/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import model.Produtos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Fornecedores;

public class ProdutosDAO {

    private final Connection conexao;

    public ProdutosDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // Método cadastrar Produtos
    public void cadastrarProduto(Produtos obj) {
        try {
            String sql = "INSERT INTO tb_produtos (descricao, preco, qtd_estoque,for_id) VALUES (?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());

            stmt.setInt(4, obj.getFornecedor().getId()); // Pegar a informação do objeto fornecedor com um getId para pegar o id do fornecedor

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    // Listar Produtos
    public List<Produtos> listarProdutos() {
        try {

            List<Produtos> lista = new ArrayList<>();

            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome FROM tb_produtos as p INNER JOIN tb_fornecedores as f on (p.for_id = f.id)";
            
            PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));// pega o dado nome do fornecedor
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

    }

    
    // Alterar Produto
    public void alterarProduto(Produtos obj){
        try {
            String sql = "UPDATE tb_produtos SET descricao=?, preco=?, qtd_estoque=? ,for_id=? WHERE id=?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());

            stmt.setInt(4, obj.getFornecedor().getId()); // Pegar a informação do objeto fornecedor com um getId para pegar o id do fornecedor

            stmt.setInt(5,obj.getId());
            
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto alterado!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    public void excluirProduto(Produtos obj){
        try {
            String sql = "DELETE FROM tb_produtos WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1,obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Produto exluido!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro: " + erro);
        }
    }
    
      public List<Produtos> listarPorNome(String nome) {
        try {

            List<Produtos> lista = new ArrayList<>();

            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome FROM tb_produtos as p "
                    + " INNER JOIN tb_fornecedores as f on (p.for_id = f.id) WHERE p.descricao LIKE ?";
            
            PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));// pega o dado nome do fornecedor
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

      }
      
      
      // BUSCA PRODUTO POR NOME
      public Produtos ConsultarPorNome(String nome) {
        try {        

            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome FROM tb_produtos as p "
                    + " INNER JOIN tb_fornecedores as f on (p.for_id = f.id) WHERE p.descricao LIKE ?";
            
            PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();
            if(rs.next()) {               
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));// pega o dado nome do fornecedor
                
                obj.setFornecedor(f);                             
            }
            return obj;
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

      }
      
      // BUSCA PRODUTO POR CÓDIGO
      public Produtos buscarPorCodigo(int id) {
        try {        

            String sql = "SELECT * from tb_produtos WHERE id = ?";
            
            PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
           
            if(rs.next()) {               
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));                                                                               
            }
            return obj;
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

      }
      
      // Método que da BAIXA NO ESTOQUE
      public void baixaEstoque(int id, int qtdNova){
        try {        

            String sql = "UPDATE tb_produtos SET qtd_estoque=? WHERE id=?";
            
            PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
            
            stmt.setInt(1, qtdNova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
                  
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
      }
      
      // Método que retorna a quantidade atual do ESTOQUE
      public int retornaEstoqueAtual(int id){
          try {
              int qtd_estoque = 0;
              String sql = "SELECT qtd_estoque from tb_produtos WHERE id = ?";
               
              PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
              stmt.setInt(1, id);
              
              ResultSet rs = stmt.executeQuery();
              
            if(rs.next()) {               
                Produtos p = new Produtos();
                
                qtd_estoque = (rs.getInt("qtd_estoque"));
            }
              return qtd_estoque;
                                
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
      
      // Método ADD AO ESTOQUE
      public void adicionarEstoque(int id, int qtdNova){
        try {        

            String sql = "UPDATE tb_produtos SET qtd_estoque=? WHERE id=?";
            
            PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
            
            stmt.setInt(1, qtdNova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
                  
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
      }
      

}
