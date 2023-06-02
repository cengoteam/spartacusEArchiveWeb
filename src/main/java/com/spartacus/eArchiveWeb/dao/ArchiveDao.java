package com.spartacus.eArchiveWeb.dao;


import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArchiveDao {
    private final JdbcTemplate jdbcTemplate;
    public ArchiveDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getInvoice() {
        List<String> invoiceUUIDS = new ArrayList<>();
        String query = "SELECT DISTINCT UUID FROM s_t_earsiv_fatura WHERE NVL(ONAY_CH,'N')='O' AND NVL(KONUM,'N')='D'";
        jdbcTemplate.query(query, rs->{
            invoiceUUIDS.add(rs.getString("UUID"));
        });
        return invoiceUUIDS;
    }

    @Transactional
    public void setEnd(String status, int statusCode, String uuid) {
        String updateQuery = "UPDATE s_t_earsiv_fatura SET KONUM=?, DURUM_KOD=? WHERE UPPER(UUID)=UPPER(?)";
        String insertProcedure = "call EARSIVFATURA.XML_INSERT(?)";
        jdbcTemplate.update(updateQuery, status, statusCode, uuid);
        jdbcTemplate.update(insertProcedure, uuid);
    }


    public void setHalt(String status, String message, int errorCode, String uuid) {
        String updateQuery = "UPDATE s_t_earsiv_fatura SET KONUM=?, DURUM_ACIKLAMA=?, DURUM_KOD=? WHERE UPPER(UUID)=UPPER(?)";
        jdbcTemplate.update(updateQuery, status, message, errorCode, uuid);
    }
}
