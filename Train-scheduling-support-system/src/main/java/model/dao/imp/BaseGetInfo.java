package model.dao.imp;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseGetInfo {

    private Connection connection;
    private BaseConnection baseConnection;

    public BaseGetInfo() {
        try {
            this.baseConnection = BaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.connection = baseConnection.connection;
    }


    public int getIndexStation(String name) {
        int indexStation = 0;
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select  station_id from Station\n" +
                    "where station_name ='" + name + "'");

            indexStation = resultSet.getInt("station_id");
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getIndexStation");

        }
        return indexStation;
    }

    public ArrayList<Integer> getPossibleWay(int indexStation) {
        ArrayList<Integer> localList = new ArrayList<>();

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT second_station_id from Crossing\n" +
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

    public String getNameStation(int indexStation) {
        String nameStation = new String();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select  station_name from Station\n" +
                    "where station_id =" + indexStation);

            nameStation = resultSet.getString(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getNameStation");

        }
        return nameStation;
    }

    public ArrayList<String> getArrayNameStation(ArrayList<Integer> list) {
        ArrayList<String> arrayNameList = new ArrayList<>();
        try {
            for (int i = 0; i < list.size(); i++) {
                Statement statement = this.connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select  station_name from Station\n" +
                        "where station_id =" + list.get(i));

                arrayNameList.add(resultSet.getString(1));
                statement.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayNameList;
    }

    public ArrayList<Integer> getCrossIndex(int indexFirstStation, int indexSecondStation) {
        ArrayList<Integer> indexList = new ArrayList<>();
        int indexCross = 0;
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select  crossing_id from Crossing\n" +
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

    public ArrayList<Integer> getCrossIndex(String nameFirstStation, String nameSecondStation) {
        ArrayList<Integer> indexList = new ArrayList<>();
        int indexCross = 0;
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select  crossing_id from Crossing\n" +
                    "where first_station_id=" + getIndexStation(nameFirstStation) + " And second_station_id=" + getIndexStation(nameSecondStation));


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

    public ArrayList<Integer> getCrossIndex(String nameFirstStation) {
        ArrayList<Integer> indexList = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select  crossing_id from Crossing\n" +
                    "where first_station_id=" + getIndexStation(nameFirstStation));


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

    public int getCrossIndexInteger(String nameFirstStation, String nameSecondStation) {

        int indexCross = 0;
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select  crossing_id from Crossing\n" +
                    "where first_station_id=" + getIndexStation(nameFirstStation) + " And second_station_id=" + getIndexStation(nameSecondStation));


            indexCross = resultSet.getInt(1);


            return indexCross;

        } catch (SQLException e) {
            System.out.println("Trouble getIndexCrossing");

        }
        return 0;

    }

    public int getTimeCrossing(String nameFirstStation, String nameSecondStation) {
        int travelTime = 0;
        int indexFirstStation = getIndexStation(nameFirstStation);
        int indexSecondStation = getIndexStation(nameSecondStation);
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT travel_time from Crossing where first_station_id=" + indexFirstStation + " AND   second_station_id=" + indexSecondStation);

            travelTime = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getTimeCrossing");

        }
        return travelTime;
    }

    public int getStartCrossingTime(int indexCrossing) {
        int startTime = 0;

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT crossing_time_start from Route where crossing_id=" + indexCrossing);

            startTime = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getStartCrossingTime");

        }
        return startTime;
    }

    public ArrayList<Integer> getStartCrossingTimeArray(int indexCrossing) {

        ArrayList<Integer> localList = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT crossing_time_start from Route where crossing_id=" + indexCrossing);

            while (resultSet.next()) {
                localList.add(resultSet.getInt(1));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getStartCrossingTime");

        }
        return localList;
    }


    public int getEndCrossingTime(int indexCrossing) {
        int endTime = 0;

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT crossing_time_end from Route where crossing_id=" + indexCrossing);

            endTime = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getEndCrossingTime");

        }
        return endTime;
    }

    public ArrayList<Integer> getEndCrossingTimeArray(int indexCrossing) {

        ArrayList<Integer> localList = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT crossing_time_end from Route where crossing_id=" + indexCrossing);

            while (resultSet.next()) {
                localList.add(resultSet.getInt(1));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getStartCrossingTime");

        }
        return localList;
    }

    public void insertRoute(int routeId, int indexCrossing, int startTime, int endTime, int numberRoute) {

        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            statement.execute("INSERT  into Route (route_id, crossing_id, crossing_time_start, crossing_time_end, crossing_number)\n" +
                    "values  (" + routeId + "," + indexCrossing + "," + startTime + "," + endTime + "," + numberRoute + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<String> getDoubleNameCrossing(int indexCrossing) {
        ArrayList<String> doubleName = new ArrayList<>();
        int firstStation = 0;
        int secondStation = 0;
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT first_station_id from Crossing where crossing_id=" + indexCrossing);
            firstStation = resultSet.getInt(1);
            statement.close();

            statement = this.connection.createStatement();
            ResultSet resultSet2 = statement.executeQuery("SELECT second_station_id from Crossing where crossing_id=" + indexCrossing);
            secondStation = resultSet2.getInt(1);
            statement.close();


            doubleName.add(getNameStation(firstStation));
            doubleName.add(getNameStation(secondStation));


        } catch (SQLException e) {
            System.out.println("Trouble getEndCrossingTime");

        }
        return doubleName;
    }

    public ArrayList<Integer> getCrossingInStation(ArrayList<Integer> list) {
        ArrayList<Integer> indexList = new ArrayList<>();

        try {
            for (int i = 1; i < list.size() + 1; i++) {
                Statement statement = this.connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select  crossing_id from Route " +
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


    public int getLastIndex() {
        int indexStation = 0;
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select last_index from LastIndex");

            indexStation = resultSet.getInt(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getLastIndex");

        }
        return indexStation;
    }

    public void setLastIndex(int index) {
        try {
            Statement statement = this.connection.createStatement();
            statement.execute("update  LastIndex set last_index =" + index + "  where  ROWID=1");
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getLastIndex");

        }
    }

    //// SCHELUDE
    public void addRouteInSchedule(String stationName, int time, int roteId, int number) {

        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            statement.execute("insert  into Schedule (station_name,time,route_id,number)values ('" + stationName + "'," + time + "," + roteId + "," + number + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getDistinctRouteSchedule() {
        ArrayList<Integer> indexList = new ArrayList<>();


        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
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

    public int getCountRoute() {
        int index = 0;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT COUNT (DISTINCT route_id) FROM Schedule");

            index = resultSet.getInt(1);
            statement.close();
            return index;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  -1;
    }

    public ArrayList<String> getStationSchedule(int routeId) {
        ArrayList<String> indexList = new ArrayList<>();


        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
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

    public ArrayList<Integer> getTimeSchedule(int routeId) {
        ArrayList<Integer> indexList = new ArrayList<>();


        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
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


    public void deleteRoute(int index){
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            statement.execute("DELETE FROM Route WHERE route_id="+index);
            statement.close();

            statement = this.connection.createStatement();
            statement.execute("DELETE FROM Schedule WHERE route_id="+index);
            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
