package com.dao;

import com.beans.EmployeeType;
import com.beans.Reimbursement;
import com.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementJDBC implements ReimbursementDao {

    //CONNECT TO SERVER
    ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    public ReimbursementJDBC(){

    }
    public ReimbursementJDBC(ConnectionUtil util){
        this.connectionUtil = util;

    }


//    @Override
//    public int approveReimbursement(int app_id) {
//        return 0;
//    }
//
//    @Override
//    public List<Reimbursement> seePastReimbursements(int emp_id) {
//        return null;
//    }
//
//    @Override
//    public List<Reimbursement> seeAllReimbursements(int benco_id) {
//        return null;
//    }
//
//    @Override
//    public List<Reimbursement> seeAllSupervisedReimbursements(int super_id) {
//        return null;
//    }
//
//    @Override
//    public List<Reimbursement> seeAllDepartmentReimbursements(int dh_id) {
//        return null;
//    }

    @Override
    public int saveReimbursement(Reimbursement re) {
        try(Connection conn = connectionUtil.getConnection()) {
            String query = "INSERT INTO reimbursements (app_id, emp_id, award) VALUES (?,?,?) RETURNING reimbursement_id";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, re.getApplication_id());
            ps.setInt(2, re.getEmployee_id());
            ps.setDouble(3, re.getAmount_awarded());

            ResultSet results = ps.executeQuery();
            if(results.next()){
                int reimb_id = results.getInt("reimbursement_id");
                re.setReimbursement_id(reimb_id);
                return reimb_id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return -1;
    }

    @Override
    public Reimbursement getReimbursement(int reimb_id) {
        try(Connection conn = connectionUtil.getConnection()) {

            String query = "SELECT * FROM reimbursements WHERE reimbursement_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, reimb_id);
            ResultSet result = ps.executeQuery();

            if(result.next()){
               int app_id = result.getInt("app_id");
               int emp_id = result.getInt("emp_id");
               double award = result.getDouble("award");
               Reimbursement reimbursement = new Reimbursement(reimb_id, app_id, emp_id, award);
               reimbursement.setTestingVar("tested");
               return reimbursement;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateReimbursement(int reimb_id, Reimbursement re) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "UPDATE reimbursements SET app_id = ?, emp_id = ?, award = ? WHERE reimbursement_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, re.getApplication_id());
            ps.setInt(2, re.getEmployee_id());
            ps.setDouble(3, re.getAmount_awarded());

            int rows = ps.executeUpdate();
            return rows;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void deleteReimbursement(int reimb_id) {

    }
}
