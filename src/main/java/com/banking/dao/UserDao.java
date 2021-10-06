package com.banking.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.banking.models.User;
import com.banking.util.ConnectionManager;



public class UserDao implements Dao<User, Integer>{

    @Override
    public List<User> findAll() {

        List<User> users = new ArrayList<User>();

        try{
            Connection conn = ConnectionManager.getConnection();

            String  sql = "SELECT * FROM BK_USERS";

            Statement cs = conn.prepareStatement(sql);


            ResultSet rs = (ResultSet) cs.executeQuery(sql);

            while(rs.next()) {

                User temp = new User();
                temp.setId(rs.getInt("USER_ID"));
                temp.setFirstName(rs.getString(2));
                temp.setLastName(rs.getString(3));
                temp.setUsername(rs.getString(4));
                temp.setPassword(rs.getString(5));
                users.add(temp);

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return users;

    }

    @Override
    public User findById(Integer id) {

        User user = null;

        try{
            Connection conn = ConnectionManager.getConnection();

            String sql = "SELECT * FROM BK_USERS WHERE USER_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,  id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                user = new User();
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setUsername(rs.getString(4));
                user.setPassword(rs.getString(5));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return user;
    }

    @Override
    public User save(User obj) {

        try {
            Connection conn = ConnectionManager.getConnection();



            String sql = "INSERT INTO BK_USERS (USER_ID, FIRSTNAME, LASTNAME, USERNAME, USER_PASSWORD)"
                    + " VALUES(?, ?, ?, ?,?)";



            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getFirstName());
            ps.setString(3, obj.getLastName());
            ps.setString(4, obj.getUsername());
            ps.setString(5, obj.getPassword());


            int numRows;
            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();

        }

        return obj;

    }

    @Override
    public User update(User obj) {

        try {
            Connection conn = ConnectionManager.getConnection();
            String sql = "UPDATE BK_USERS SET FIRSTNAME = ?, LASTNAME = ?, USERNAME = ?, USER_PASSWORD = ? WHERE USER_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,  obj.getFirstName());
            ps.setString(2, obj.getLastName());
            ps.setString(3,  obj.getUsername());
            ps.setString(4, obj.getPassword());
            ps.setInt(5, obj.getId());
            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    @Override
    public void delete(User obj) {
        // TODO Auto-generated method stub

    }

}
