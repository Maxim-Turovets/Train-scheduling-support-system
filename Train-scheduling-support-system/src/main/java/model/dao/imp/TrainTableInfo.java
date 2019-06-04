package model.dao.imp;

import model.dao.connection.BaseConnection;
import model.dao.daointerfaces.DAoTrain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrainTableInfo implements DAoTrain {

    @Override
    public ArrayList<String> getAvailableTrain() {
        BaseConnection baseConnection = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            baseConnection = BaseConnection.getInstance();
            connection = baseConnection.connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<String> trainList = new ArrayList<>();


        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT  name From Train WHere available = true");

            while (resultSet.next()) {
                trainList.add(resultSet.getString(1));
            }
            statement.close();

            return trainList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }

    @Override
    public String getNameTrain(int indexTrain) {
        BaseConnection baseConnection = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            baseConnection = BaseConnection.getInstance();
            connection = baseConnection.connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String nameTrain = new String();
        try {
            statement = connection.createStatement();
             resultSet = statement.executeQuery("Select  name from Train where rowid =" + indexTrain);

            nameTrain = resultSet.getString(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getNameStation");

        }
        return nameTrain;
    }

    @Override
    public int getIndexTrain(String nameTrain) {
        BaseConnection baseConnection = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            baseConnection = BaseConnection.getInstance();
            connection = baseConnection.connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int indexTrain =0;
        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("Select  rowid from Train where name ='" + nameTrain+"'");

            indexTrain = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getNameStation");

        }
        return indexTrain;
    }
}
