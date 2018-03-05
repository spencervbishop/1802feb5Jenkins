package com.ex.data.impl;

import com.ex.connector.H2Connector;
import com.ex.data.ConnectionUtils.H2DataConnector;
import com.ex.data.dao.ListDao;
import com.ex.domain.ListItem;
import com.ex.domain.TodoList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListDaoImpl implements ListDao {
    @Override
    public Collection<TodoList> getAll() {
        Connection conn = null;

        try {
            conn = H2DataConnector.connector().openConnection();
            String sql = "SELECT l.id AS l_id, l.title AS l_title, li.id AS li_id, li.val AS li_val, li.complete AS li_complete, li.list_id AS li_fk_l_id FROM LIST AS l JOIN LIST_ITEM AS li ON l.id = li.list_id ORDER BY l.id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<TodoList> list = new ArrayList<>(0);
            List<ListItem> listItems = new ArrayList<>(0);

            TodoList tdl = new TodoList();
            while (rs.next()) {
                if(tdl.getId() != rs.getInt("l_id")) {
                    if(tdl.getTitle() == null) {
                        tdl.setId(rs.getInt("l_id"));
                        tdl.setTitle(rs.getString("l_title"));
                    } else {
                        tdl.setItems(listItems);
                        list.add(tdl);
                        tdl = new TodoList();
                        listItems = new ArrayList<>(0);
                        tdl.setId(rs.getInt("l_id"));
                        tdl.setTitle(rs.getString("l_title"));
                    }
                }
                ListItem item = new ListItem();
                item.setId(rs.getInt("li_id"));
                item.setValue(rs.getString("li_val"));
                item.setComplete(rs.getBoolean("li_complete"));
                listItems.add(item);
            }

            //once more for the last list
            tdl.setItems(listItems);
            list.add(tdl);

            rs.close();

            return list;
        } catch (SQLException e)

        {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public TodoList getOne(int id) {
        Connection conn = null;

        try {
            conn = H2DataConnector.connector().openConnection();
            String sql = "SELECT l.id AS l_id, l.title AS l_title, li.id AS li_id, li.val AS li_val, li.complete AS li_complete, li.list_id AS li_fk_l_id FROM LIST AS l JOIN LIST_ITEM AS li ON l.id = li.list_id WHERE l.id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            TodoList tdl = new TodoList();
            List<ListItem> listItems = new ArrayList<>(0);
            while (rs.next()) {
                if(tdl.getTitle() == null) {
                    tdl.setId(rs.getInt("l_id"));
                    tdl.setTitle(rs.getString("l_title"));
                }

                ListItem item = new ListItem();
                item.setId(rs.getInt("li_id"));
                item.setValue(rs.getString("li_val"));
                item.setComplete(rs.getBoolean("li_complete"));
                listItems.add(item);
            }

            tdl.setItems(listItems);

            rs.close();

            return tdl;
        } catch (SQLException e)

        {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public int updateList(TodoList list) {
      Connection conn = null;
      int retVal = 0;

      try {
          conn = H2DataConnector.connector().openConnection();
          String updateSQL = "UPDATE LIST SET title = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(updateSQL);
          ps.setString(1, list.getTitle());
          ps.setInt(2, list.getId());
          retVal = ps.executeUpdate();

          System.out.println("Update list " + list.getId());

          String insertSql = "INSERT INTO LIST_ITEM (VAL, LIST_ID, COMPLETE) VALUES (?,?,?)";
          ps = conn.prepareStatement(insertSql);

          for(ListItem item : list.getItems()) {
              if(item.getId() == 0) {
                  ps.setString(1, item.getValue());
                  ps.setInt(2, list.getId());
                  ps.setBoolean(3, item.isComplete());
                  boolean flag = true;
                  ps.execute();

                  if(flag == false) {
                      throw new SQLException("SQL update execption");
                  }else {
                      retVal += 1;
                  }
              }
          }
          conn.commit();
          return retVal;

      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          if(conn != null) {
              try {
                  conn.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
      }
      return retVal;
    }
}
