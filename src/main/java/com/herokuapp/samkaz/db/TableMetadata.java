package com.herokuapp.samkaz.db;

import com.herokuapp.samkaz.bean.Entity;
import com.herokuapp.samkaz.bean.Column;
import com.herokuapp.samkaz.utils.DataTypeDictionaryUtils;
import com.herokuapp.samkaz.utils.TextUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableMetadata {

    public List<Entity> getTableMetadata() {
        ResultSet resultSetColumns = null;
        ResultSet resultSetTables = null;
        List<Entity> result = new ArrayList<>();
        try {

            Connection connection = DBManagement.getInstance().getConnection();
            DatabaseMetaData dbmd = connection.getMetaData();

            String[] types = {"TABLE"};
            if (dbmd != null) {
                resultSetTables = dbmd.getTables(connection.getCatalog(), null, "%", types);
                while (resultSetTables.next()) {
                    String tableName = resultSetTables.getString("TABLE_NAME");
                    String tableFormatedName = TextUtils.formatName(tableName);
                    System.out.println("Table:" + tableName + " => "+ tableFormatedName);

                    Entity entity = new Entity();
                    entity.setName(tableFormatedName);

                    resultSetColumns = dbmd.getColumns(connection.getCatalog(), null, tableName, "%");
                    List<Column> columns = new ArrayList<>();
                    while (resultSetColumns.next()) {
                        Column col = new Column();
                        col.setName(TextUtils.formatName(resultSetColumns.getString("COLUMN_NAME")));
                        col.setPropertyName(TextUtils.formatPrivatePropertyName(resultSetColumns.getString("COLUMN_NAME")));
                        col.setDataType(DataTypeDictionaryUtils.convertMysqlDataType2Java(resultSetColumns.getString("TYPE_NAME")));
                        columns.add(col);
                    }
                    entity.setColumns(columns);
                    entity.setPropertyName(TextUtils.formatPrivatePropertyName(tableName));
                    result.add(entity);
                }
                System.out.println ("Total: " + result.size() + " tables.");
            }
        } catch (Exception ex) {
            System.out.println("Error while get Metadata");
        } finally {
            try {
                if (resultSetColumns != null) {
                    resultSetColumns.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error while close resultSetColumns");
            }
            try {
                if (resultSetTables != null) {
                    resultSetTables.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error while closing tables");
            }
        }
        return result;
    }
}
