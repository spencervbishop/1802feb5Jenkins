package com.services;

import com.beans.Reimbursement;
import com.dao.ReimbursementJDBC;
import com.util.ConnectionUtil;

public class ReimbursementService {
    ReimbursementJDBC dao;

    public ReimbursementService(ConnectionUtil cu){
        dao = new ReimbursementJDBC(cu);
    }

    public ReimbursementService(){
        dao = new ReimbursementJDBC();
    }

    public Reimbursement getReimbursement(int reimb_id){
        Reimbursement reimbursement = dao.getReimbursement(reimb_id);
        reimbursement.setTestingVar("service tested");
        return reimbursement;
    }

    public int saveReimbursement(Reimbursement reimb){
        int id = dao.saveReimbursement(reimb);
        return id;
    }

    public int updateReimbursementInfo(int reimb_id, Reimbursement reimb){
        int rows = dao.updateReimbursement(reimb_id, reimb);
        return rows;
    }

    public void deleteReimbursement(){

    }
}
