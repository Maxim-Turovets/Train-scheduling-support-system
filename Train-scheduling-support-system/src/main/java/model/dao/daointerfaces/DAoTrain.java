package model.dao.daointerfaces;

import java.util.ArrayList;

public interface DAoTrain {
    ArrayList<String> getAvailableTrain();
    String getNameTrain(int indexTrain);
    int getIndexTrain(String nameTrain);
}
