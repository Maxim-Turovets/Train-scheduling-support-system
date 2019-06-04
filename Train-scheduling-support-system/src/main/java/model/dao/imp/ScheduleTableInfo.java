package model.dao.imp;

import model.dao.connection.BaseConnection;
import model.dao.daointerfaces.DAoSchedule;
import model.dao.daointerfaces.DAoStation;
import model.dao.daointerfaces.DAoTrain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScheduleTableInfo implements DAoSchedule {
    @Override
    public void addRouteInSchedule(String stationName, int time, int roteId, int number) {
        BaseConnection baseConnection = null;
        Connection connection = null;
        Statement statement = null;

        try {
            baseConnection = BaseConnection.getInstance();
            connection = baseConnection.connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement = connection.createStatement();
            statement.execute("insert  into Schedule (station_name,time,route_id,number)values ('" + stationName + "'," + time + "," + roteId + "," + number + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Integer> getDistinctRouteSchedule() {
        BaseConnection baseConnection = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Integer> indexList = new ArrayList<>();
        try {
            baseConnection = BaseConnection.getInstance();
            connection = baseConnection.connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT  DISTINCT route_id FROM Schedule");

            while (resultSet.next()) {
                indexList.add(resultSet.getInt(1));
            }
            statement.close();

            return indexList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }

    @Override
    public int getCountRoute() {
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

        int index = 0;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT COUNT (DISTINCT route_id) FROM Schedule");

            index = resultSet.getInt(1);
            statement.close();
            return index;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  -1;
    }

    @Override
    public ArrayList<String> getStationSchedule(int routeId) {
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

        ArrayList<String> indexList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT station_name FROM Schedule where  route_id ="+ routeId);

            while (resultSet.next()) {
                indexList.add(resultSet.getString(1));
            }
            statement.close();

            return indexList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }

    @Override
    public ArrayList<Integer> getTimeSchedule(int routeId) {
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

        ArrayList<Integer> indexList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT time FROM Schedule where  route_id ="+ routeId);

            while (resultSet.next()) {
                indexList.add(resultSet.getInt(1));
            }
            statement.close();

            return indexList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }

    @Override
    public void setTrainInSchedule(int trainId) {
        DAoStation db = new StationTableInfo();
        BaseConnection baseConnection = null;
        Connection connection = null;
        Statement statement = null;

        try {
            baseConnection = BaseConnection.getInstance();
            connection = baseConnection.connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
            statement.execute("\n" +
                    " UPDATE  Schedule " +
                    " set train_id =" +trainId+" "+
                    " Where route_id ="+db.getLastIndex());
            statement.close();

            statement.execute("\n" +
                    " UPDATE  Train " +
                    " set available=false "+
                    " Where rowid ="+trainId);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble setTrainInSchedule");

        }
    }

    @Override
    public String getNameTrainInSchedule(int routeId) {
        BaseConnection baseConnection = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        DAoTrain db = new TrainTableInfo();
        try {
            baseConnection = BaseConnection.getInstance();
            connection = baseConnection.connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int  indexTrain = 0;
        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("Select  train_id from Schedule where route_id =" + routeId);

            indexTrain = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getNameStation");

        }
        return db.getNameTrain(indexTrain);
    }
}
