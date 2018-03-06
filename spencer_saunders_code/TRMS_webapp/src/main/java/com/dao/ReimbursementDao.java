package com.dao;

import com.beans.Reimbursement;

import java.util.List;

public interface ReimbursementDao {

    public int saveReimbursement(Reimbursement re);

    public Reimbursement getReimbursement(int reimb_id);

    public int updateReimbursement(int reimb_id, Reimbursement re);

    public void deleteReimbursement(int reimb_id);


}
