/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.Step;

import DBUtil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author My PC
 */
public class StepDAO {
    
    private static final String INSERT_STEP="INSERT INTO Step (recipeID,stepNumber,instructions) Values(?,?,?)";
     private static final String GET_STEPS_BY_RECIPEID = "SELECT * FROM [Step] WHERE recipeID = ?";
    private static final String UPDATE_STEP = "UPDATE [Step] SET instructions = ? WHERE recipeID = ? AND stepNumber = ? ";

    public List<StepDTO> getStepsByRecipeID(int recipeID) throws SQLException {
        List<StepDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ptm = conn.prepareStatement(GET_STEPS_BY_RECIPEID);
            ptm.setInt(1, recipeID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                int stepID = rs.getInt("stepID");
                String stepNumber = rs.getString("stepNumber");
                String instructions = rs.getString("instructions");
                list.add(new StepDTO(stepID, recipeID, stepNumber, instructions));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public boolean updateStep(StepDTO updateStep) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if(conn!=null) {
                ptm = conn.prepareStatement(UPDATE_STEP);
                ptm.setString(1, updateStep.getInstructions());
                ptm.setInt(2, updateStep.getRecipeID());
                ptm.setString(3, updateStep.getStepNumber());
                checkUpdate = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkUpdate;
    }
    
   public boolean insertStep(StepDTO step) throws SQLException, ClassNotFoundException {
       boolean check = false;
       Connection con = null;
       PreparedStatement ptm = null;
       try{
           con=DBUtil.getConnection();
           if(con != null){
               ptm=con.prepareStatement(INSERT_STEP);
               int recipeID =  step.getRecipeID();
               String stepNumber = step.getStepNumber();
               String instructions = step.getInstructions();
               ptm.setInt(1, step.getRecipeID());
               ptm.setString(2, step.getStepNumber());
               ptm.setString(3, step.getInstructions());
               check = ptm.executeUpdate()>0?true:false;   
           }
           
       }finally{
           if(ptm != null) ptm.close();
           if(con != null) con.close();
       }    
       return check;    
   }
    
 public List<StepDTO> getStepORecipe(int recipeID) throws SQLException, ClassNotFoundException {
        List<StepDTO> list = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Step where recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while(rs.next()) {
            StepDTO step = new StepDTO();
            step.setStepID(rs.getInt("stepID"));
            step.setRecipeID(rs.getInt("recipeID"));
            step.setStepNumber(rs.getString("stepNumber"));
            step.setInstructions(rs.getString("instructions"));
            list.add(step);
        }
        con.close();
        return list;
    }
 public void addStep(StepDTO step) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("insert Step values (?, ?, ?)");
        stm.setInt(1, step.getRecipeID());
        stm.setString(2, step.getStepNumber());
        stm.setString(3, step.getInstructions());
        stm.executeUpdate();
        con.close();
    }
    
//    public void updateStep(StepDTO step) throws SQLException, ClassNotFoundException {
//        Connection con = DBUtil.getConnection();
//        PreparedStatement stm = con.prepareStatement("update Step set instructions = ? where recipeID = ? and stepNumber = ?");
//        stm.setString(1, step.getInstructions());
//        stm.setInt(2, step.getRecipeID());
//        stm.setString(3, step.getStepNumber());
//        stm.executeUpdate();
//        con.close();
//    }
    
    public StepDTO getOneStep(int stepID) throws SQLException, ClassNotFoundException {
        StepDTO step = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Step where stepID = ?");
        ResultSet rs = stm.executeQuery();
        while(rs.next()) {
            step = new StepDTO();
            step.setRecipeID(rs.getInt("stepID"));
            step.setRecipeID(rs.getInt("recipeID"));
            step.setStepNumber(rs.getString("stepNumber"));
            step.setInstructions(rs.getString("instructions"));
        }
        con.close();
        return step;
    }
    
    public void updateRemoveStep(int stepID, int recipeID) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("delete Step where stepID = ? and recipeID = ?");
        stm.setInt(1, stepID);
        stm.setInt(2, recipeID);
        stm.executeUpdate();
        con.close();
    }
 
}