package br.com.upsale.bd;

import static br.com.upsale.bd.DAO.connectionFactory;
import br.com.upsale.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendaDAO implements DAO<Venda>{
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @Override
    public List<Venda> getLista() throws Exception {
        List lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "venda");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Venda v = new Venda();
            v.setId(rs.getLong("id"));
            v.setData(rs.getDate("data_venda"));
            lista.add(v);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    @Override
    public boolean atualizar(Venda o) throws Exception {
        String sql = String.format(connectionFactory.getSQLUpdate(), "venda","data_venda = ?", "data_venda = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, sdf.format(o.getData()));
        ps.setString(2, sdf.format(o.getData()));
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean inserir(Venda o) throws Exception {
        if (atualizar(o)) {
            return true;
        }
        String sql = String.format(connectionFactory.getSQLInsert(), "venda", "data_venda", "?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, sdf.format(o.getData()));
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean remover(Venda o) throws Exception {
        String sql = String.format(connectionFactory.getSQLDelete(), "venda", "id = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }
    
    public Long getDateId(Date date) throws Exception {
        String sql = String.format(connectionFactory.getSQLSelect(), 
                "venda WHERE data_venda= (SELECT MAX(data_venda) FROM venda)");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Long id = 0L;
        if (rs.next()) {
            id = rs.getLong("id");
        }
        rs.close();
        stmt.close();
        con.close();
        return id;
    }
    
}
