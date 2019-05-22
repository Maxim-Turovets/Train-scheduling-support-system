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


    public  int getIndexStation(String name)
    {
        int indexStation=0;
        try
        {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select  station_id from Station\n" +
                    "where station_name ='"+name+"'");

            indexStation = resultSet.getInt("station_id");
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getIndexStation");

        }
        return  indexStation;
    }

    public ArrayList<Integer> getPossibleWay(int indexStation)
    {
        ArrayList<Integer> localList = new ArrayList<>();

        try
        {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT second_station_id from Crossing\n" +
                    "where first_station_id ="+indexStation);

            while(resultSet.next())
            {
                localList.add(resultSet.getInt(1));
            }
            statement.close();
            return localList;


        } catch (SQLException e) {
            System.out.println("Trouble getIndexCrossing");
        }



        return null;
    }

    public String getNameStation(int indexStation)
    {
        String nameStation=new String();
        try
        {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select  station_name from Station\n" +
                    "where station_id ="+indexStation);

            nameStation = resultSet.getString(1);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Trouble getNameStation");

        }
        return  nameStation;
    }

    public ArrayList<Integer> getCrossIndex(int indexFirstStation , int indexSecondStation)
    {
        ArrayList<Integer> indexList = new ArrayList<>();
        int indexCross=0;
        try
        {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select  crossing_id from Crossing\n" +
                    "where first_station_id="+indexFirstStation+" And second_station_id="+indexSecondStation);


            while(resultSet.next())
            {
                indexList.add(resultSet.getInt(1));
            }
            statement.close();
            return indexList;

        } catch (SQLException e) {
            System.out.println("Trouble getIndexCrossing");

        }
        return  null;

    }



}
