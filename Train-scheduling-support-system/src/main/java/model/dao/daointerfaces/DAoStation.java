package model.dao.daointerfaces;

import java.util.ArrayList;

public interface DAoStation {

    int getIndexStation(String name);

    ArrayList<Integer> getPossibleWay(int indexStation);

    String getNameStation(int indexStation);

    ArrayList<String> getArrayNameStation(ArrayList<Integer> list);

    int getLastIndex();
    void setLastIndex(int index);
}
