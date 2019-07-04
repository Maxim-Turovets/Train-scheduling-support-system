package servise;

import model.dao.daointerfaces.DAoCrossing;
import model.dao.daointerfaces.DAoRoute;
import model.dao.daointerfaces.DAoSchedule;
import model.dao.daointerfaces.DAoStation;
import model.dao.imp.CrossingTableInfo;
import model.dao.imp.RouteTableInfo;
import model.dao.imp.ScheduleTableInfo;
import model.dao.imp.StationTableInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class SaveDataServise {

    private  HttpServletRequest request ;

    public SaveDataServise(HttpServletRequest request) {
        this.request = request;
    }

    private void save() {
        DAoStation dAoStation = new StationTableInfo();
        DAoCrossing dAoCrossing = new CrossingTableInfo();
        DAoRoute dAoRoute = new RouteTableInfo();

        ArrayList<String> stationList = (ArrayList<String>) request.getSession().getAttribute("stationList");
        ArrayList<Integer> timeList = (ArrayList<Integer>) request.getSession().getAttribute("timeList");
        int size = stationList.size();

        int lastIndex = dAoStation.getLastIndex() + 1;
        dAoStation.setLastIndex(lastIndex);
        for (int i = 0; i < stationList.size() - 1; i++) {
            int indexCrossing = dAoCrossing.getCrossIndexInteger(stationList.get(i), stationList.get(i + 1));
            dAoRoute.insertRoute(dAoStation.getLastIndex(), indexCrossing, timeList.get(i), timeList.get(i + 1), i);
        }


    }

    private void addInSchedule() {
        DAoStation dAoStation = new StationTableInfo();
        DAoSchedule dAoSchedule = new ScheduleTableInfo();

        ArrayList<String> stationList = (ArrayList<String>) request.getSession().getAttribute("stationList");
        ArrayList<Integer> timeList = (ArrayList<Integer>) request.getSession().getAttribute("timeList");
        int lastIndex = dAoStation.getLastIndex();
        int size = stationList.size();

        for (int i = 0; i < stationList.size(); i++) {
            dAoSchedule.addRouteInSchedule(stationList.get(i), timeList.get(i), lastIndex, i);
        }

        dAoStation.setLastIndex(lastIndex);
    }

    private void nullValue() {
        request.getSession().setAttribute("stationList", null);
        request.getSession().setAttribute("timeList", null);
        request.getSession().setAttribute("startStation", null);
        request.getSession().setAttribute("startTime", null);
        request.getSession().setAttribute("currentStation", null);
        request.getSession().setAttribute("currentTime", null);
        request.setAttribute("nextStation", null);
    }

    public  void  saveDate(){
        save();
        addInSchedule();
        nullValue();
    }

    public  void  getRequest(){
        nullValue();
    }
}
