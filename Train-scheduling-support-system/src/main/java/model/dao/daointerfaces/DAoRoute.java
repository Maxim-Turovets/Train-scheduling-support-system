package model.dao.daointerfaces;

import java.util.ArrayList;

public interface DAoRoute {
    int getStartCrossingTime(int indexCrossing);
    ArrayList<Integer> getStartCrossingTimeArray(int indexCrossing);
    int getRouteId(int indexCrossing);
    int getEndCrossingTime(int indexCrossing);
    ArrayList<Integer> getEndCrossingTimeArray(int indexCrossing);
    void insertRoute(int routeId, int indexCrossing, int startTime, int endTime, int numberRoute);
    ArrayList<Integer> getCrossingInStation(ArrayList<Integer> list);
    void deleteRoute(int index);
}
