package model.dao.daointerfaces;

import java.util.ArrayList;

public interface DAoSchedule {
    void addRouteInSchedule(String stationName, int time, int roteId, int number);
    ArrayList<Integer> getDistinctRouteSchedule();
    int getCountRoute();
    ArrayList<String> getStationSchedule(int routeId);
    ArrayList<Integer> getTimeSchedule(int routeId);
    void setTrainInSchedule(int trainId);
    String getNameTrainInSchedule(int routeId);
}
