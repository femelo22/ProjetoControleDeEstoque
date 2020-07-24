/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import model.Vendas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Clientes;
/**
 *
 * @author luiz_
 */
public class VendasDAO {
    
    
    
    //Conexão com o banco
    private final Connection conexao;

    public VendasDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    // Método cadastrar venda
    public void cadastrarVenda(Vendas obj){            
        try {
            String sql = "INSERT INTO tb_vendas (id ,cliente_id, data_venda, total_venda, observacoes) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.setInt(2,obj.getCliente().getId());
            stmt.setString(3,obj.getData_venda());
            stmt.setDouble(4,obj.getTotal_venda());
            stmt.setString(5,obj.getObs());
            
                      
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro: " + erro);
         }
    }
    
    // Método retorna ultima venda
    public int retornaUltimaVenda(){
        try {
            int idVenda = 0;
            
            String sql = "SELECT max(id) id FROM tb_vendas";
            PreparedStatement ps = conexao.prepareStatement(sql);           
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Vendas p = new Vendas();
                
                p.setId(rs.getInt("id"));
                
                idVenda = p.getId();
            }
            return idVenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método filtrar vendas por data
    public List<Vendas> listarVendasPorPeriodo(LocalDate data_inicio, LocalDate data_fim) {
        try {

            List<Vendas> lista = new ArrayList<>();

            String sql = "SELECT v.id, date_format(v.data_venda,'%d/%m/%Y') as data_formatada ,c.nome,v.total_venda, v.observacoes FROM tb_vendas AS v "
                    + " INNER JOIN tb_clientes AS c ON (v.cliente_id = c.id) WHERE v.data_venda BETWEEN ? AND ?;";
            
            PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
            stmt.setString(1,data_inicio.toString());
            stmt.setString(2,data_fim.toString());
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendas obj = new Vendas();
                Clientes c = new Clientes();
                
                obj.setId(rs.getInt("v.id"));
                obj.setData_venda(rs.getString("data_formatada"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                obj.setObs(rs.getString("v.observacoes"));
                
                obj.setCliente(c);
                
                lista.add(obj);
                
            }
            return lista;
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
    
    public double retornaTotalVendaPorData(LocalDate data_venda){
        try {
            double totalvenda = 0;
            String sql = "SELECT sum(total_venda) as total FROM tb_vendas WHERE data_venda=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, data_venda.toString());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                totalvenda = rs.getDouble("total");
            }
            return totalvenda;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
