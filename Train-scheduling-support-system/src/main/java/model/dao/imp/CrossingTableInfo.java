package model.dao.imp;

import model.dao.connection.BaseConnection;
import model.dao.daointerfaces.DAoCrossing;
import model.dao.daointerfaces.DAoStation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CrossingTableInfo implements DAoCrossing {

    @Override
    public ArrayList<Integer> getCrossIndex(int indexFirstStation, int indexSecondStation) {
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
        int indexCross = 0;
        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("Select  crossing_id from Crossing\n" +
                    "where first_station_id=" + indexFirstStation + " And second_station_id=" + indexSecondStation);


            while (resultSet.next()) {
                indexList.add(resultSet.getInt(1));
            }
            statement.close();
            return indexList;

        } catch (SQLException e) {
            System.out.println("Trouble getIndexCrossing");

        }
        return null;
    }

    @Override
    public ArrayList<Integer> getCrossIndex(String nameFirstStation, String nameSecondStation) {
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

        DAoStation db = new StationTableInfo();
        ArrayList<Integer> indexList = new ArrayList<>();
        int indexCross = 0;
        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("Select  crossing_id from Crossing\n" +
                    "where first_station_id=" + db.getIndexStation(nameFirstStation) + " And second_station_id=" + db.getIndexStation(nameSecondStation));


            while (resultSet.next()) {
                indexList.add(resultSet.getInt(1));
            }
            statement.close();
            return indexList;

        } catch (SQLException e) {
            System.out.println("Trouble getIndexCrossing");

        }
        return null;
    }

    @Override
    public ArrayList<Integer> getCrossIndex(String nameFirstStation) {
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

        DAoStation db = new StationTableInfo();
        ArrayList<Integer> indexList = new ArrayList<>();
        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("Select  crossing_id from Crossing\n" +
                    "where first_station_id=" + db.getIndexStation(nameFirstStation));


            while (resultSet.next()) {
                indexList.add(resultSet.getInt(1));
            }
            statement.close();
            return indexList;

        } catch (SQLException e) {
            System.out.println("Trouble getIndexCrossing");

        }
        return null;
    }

    @Override
    public int getCrossIndexInteger(String nameFirstStation, String nameSecondStation) {
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
        DAoStation db = new StationTableInfo();
        int indexCross = 0;
        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("Select  crossing_id from Crossing\n" +
                    "where first_station_id=" + db.getIndexStation(nameFirstStation) + " And second_station_id=" + db.getIndexStation(nameSecondStation));


            indexCross = resultSet.getInt(1);


            return indexCross;

        } catch (SQLException e) {
            System.out.println("Trouble getIndexCrossing");

        }
        return 0;
    }

    @Override
    public int getTimeCrossing(String nameFirstStation, String nameSecondStation) {
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

        DAoStation db = new StationTableInfo();
        int travelTime = 0;
        int indexFirstStation = db.getIndexStation(nameFirstStation);
        int indexSecondStation = db.getIndexStation(nameSecondStation);
        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("SELECT travel_time from Crossing where first_station_id=" + indexFirstStation + " AND   second_station_id=" + indexSecondStation);

            travelTime = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getTimeCrossing");

        }
        return travelTime;
    }

    @Override
    public ArrayList<String> getDoubleNameCrossing(int indexCrossing) {
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

        DAoStation db = new StationTableInfo();
        ArrayList<String> doubleName = new ArrayList<>();
        int firstStation = 0;
        int secondStation = 0;
        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("SELECT first_station_id from Crossing where crossing_id=" + indexCrossing);
            firstStation = resultSet.getInt(1);
            statement.close();

            statement = connection.createStatement();
            ResultSet resultSet2 = statement.executeQuery("SELECT second_station_id from Crossing where crossing_id=" + indexCrossing);
            secondStation = resultSet2.getInt(1);
            statement.close();


            doubleName.add(db.getNameStation(firstStation));
            doubleName.add(db.getNameStation(secondStation));


        } catch (SQLException e) {
            System.out.println("Trouble getEndCrossingTime");

        }
        return doubleName;
    }


}
