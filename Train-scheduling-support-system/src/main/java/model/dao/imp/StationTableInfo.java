package model.dao.imp;

import model.dao.connection.BaseConnection;
import model.dao.daointerfaces.DAoStation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StationTableInfo implements DAoStation {


    @Override
    public int getIndexStation(String name) {
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


        int indexStation = 0;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select  station_id from Station\n" +
                    "where station_name ='" + name + "'");

            indexStation = resultSet.getInt("station_id");

        } catch (SQLException e) {
            System.out.println("Trouble getIndexStation");
        } finally {
            try {
                statement.close();
                connection.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return indexStation;
    }

    @Override
    public ArrayList<Integer> getPossibleWay(int indexStation) {
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

        ArrayList<Integer> localList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT second_station_id from Crossing\n" +
                    "where first_station_id =" + indexStation);

            while (resultSet.next()) {
                localList.add(resultSet.getInt(1));
            }
            statement.close();
            return localList;


        } catch (SQLException e) {
            System.out.println("Trouble getIndexCrossing");
        }


        return null;
    }

    @Override
    public String getNameStation(int indexStation) {
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
        String nameStation = new String();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select  station_name from Station\n" +
                    "where station_id =" + indexStation);

            nameStation = resultSet.getString(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getNameStation");

        }
        return nameStation;
    }

    @Override
    public ArrayList<String> getArrayNameStation(ArrayList<Integer> list) {
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
        ArrayList<String> arrayNameList = new ArrayList<>();
        try {
            for (int i = 0; i < list.size(); i++) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("Select  station_name from Station\n" +
                        "where station_id =" + list.get(i));

                arrayNameList.add(resultSet.getString(1));
                statement.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayNameList;
    }

    @Override
    public int getLastIndex() {
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

        int indexStation = 0;
        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("select last_index from LastIndex");

            indexStation = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getLastIndex");

        }
        return indexStation;
    }

    @Override
    public void setLastIndex(int index) {
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
            statement.execute("update  LastIndex set last_index =" + index + "  where  ROWID=1");
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getLastIndex");

        }
    }
}
