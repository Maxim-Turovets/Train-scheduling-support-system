package model.dao.daointerfaces;

import java.util.ArrayList;

public interface DAoCrossing {
    ArrayList<Integer> getCrossIndex(int indexFirstStation, int indexSecondStation);
    ArrayList<Integer> getCrossIndex(String nameFirstStation, String nameSecondStation);
    ArrayList<Integer> getCrossIndex(String nameFirstStation);
    int getCrossIndexInteger(String nameFirstStation, String nameSecondStation);
    int getTimeCrossing(String nameFirstStation, String nameSecondStation);
    ArrayList<String> getDoubleNameCrossing(int indexCrossing);
}
