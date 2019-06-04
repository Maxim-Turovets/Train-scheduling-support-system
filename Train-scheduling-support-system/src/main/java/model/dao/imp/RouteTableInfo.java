package model.dao.imp;

import model.dao.connection.BaseConnection;
import model.dao.daointerfaces.DAoRoute;
import model.dao.daointerfaces.DAoSchedule;
import model.dao.daointerfaces.DAoTrain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RouteTableInfo implements DAoRoute {
    @Override
    public int getStartCrossingTime(int indexCrossing) {
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

        int startTime = 0;

        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("SELECT crossing_time_start from Route where crossing_id=" + indexCrossing);

            startTime = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getStartCrossingTime");

        }
        return startTime;
    }

    @Override
    public ArrayList<Integer> getStartCrossingTimeArray(int indexCrossing) {
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
             resultSet = statement.executeQuery("SELECT crossing_time_start from Route where crossing_id=" + indexCrossing);

            while (resultSet.next()) {
                localList.add(resultSet.getInt(1));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getStartCrossingTime");

        }
        return localList;
    }

    @Override
    public int getRouteId(int indexCrossing) {
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

        int routeId = 0;
        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("Select  route_id from Route\n" +
                    "where crossing_id =" + indexCrossing);

            routeId = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getRouteId");

        }
        return routeId;
    }

    @Override
    public int getEndCrossingTime(int indexCrossing) {
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

        int endTime = 0;

        try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery("SELECT crossing_time_end from Route where crossing_id=" + indexCrossing);

            endTime = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getEndCrossingTime");

        }
        return endTime;
    }

    @Override
    public ArrayList<Integer> getEndCrossingTimeArray(int indexCrossing) {
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
             resultSet = statement.executeQuery("SELECT crossing_time_end from Route where crossing_id=" + indexCrossing);

            while (resultSet.next()) {
                localList.add(resultSet.getInt(1));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getStartCrossingTime");

        }
        return localList;
    }

    @Override
    public void insertRoute(int routeId, int indexCrossing, int startTime, int endTime, int numberRoute) {
        Statement statement = null;
        Connection connection = null;
        try {
            statement = connection.createStatement();
            statement.execute("INSERT  into Route (route_id, crossing_id, crossing_time_start, crossing_time_end, crossing_number)\n" +
                    "values  (" + routeId + "," + indexCrossing + "," + startTime + "," + endTime + "," + numberRoute + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Integer> getCrossingInStation(ArrayList<Integer> list) {
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
            for (int i = 1; i < list.size() + 1; i++) {
                 statement = connection.createStatement();
                 resultSet = statement.executeQuery("Select  crossing_id from Route " +
                        "where crossing_id=" + list.get(i - 1));

                try {
                    resultSet.getInt(1);
                } catch (Exception e) {
                    resultSet = null;
                }
                if (resultSet != null) {
                    indexList.add(resultSet.getInt(1));
                }

            }
            return indexList;

        } catch (SQLException e) {
            System.out.println("Trouble getIndexCrossing");

        }
        return null;
    }

    @Override
    public void deleteRoute(int index) {
        BaseConnection baseConnection = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        DAoTrain db = new TrainTableInfo();
        DAoSchedule dbsch = new ScheduleTableInfo();

        try {
            baseConnection = BaseConnection.getInstance();
            connection = baseConnection.connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int trainId = db.getIndexTrain(dbsch.getNameTrainInSchedule(index));
        try {
            statement = connection.createStatement();
            statement.execute("DELETE FROM Route WHERE route_id="+index);
            statement.close();

            statement = connection.createStatement();
            statement.execute("DELETE FROM Schedule WHERE route_id="+index);
            statement.close();


            statement.execute("\n" +
                    " UPDATE  Train " +
                    " set available=true"+
                    " Where rowid ="+trainId);
            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
