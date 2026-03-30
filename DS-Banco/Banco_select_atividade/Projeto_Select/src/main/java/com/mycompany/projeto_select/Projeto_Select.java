/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_select;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Projeto_Select {

    public static void main(String[] args) {
        try {
            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM territorio";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Cidade: " + rs.getString("cidade"));
                System.out.println("Região: " + rs.getString("regiao"));
                System.out.println("-----");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}