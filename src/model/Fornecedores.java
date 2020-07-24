/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author luiz_
 */
public class Fornecedores extends Clientes {
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
    //sobreescrever o método
    @Override
    public String toString(){
        return this.getNome();// Seleciona a opção da coluna que será puxada da tabela
    }
    
}
