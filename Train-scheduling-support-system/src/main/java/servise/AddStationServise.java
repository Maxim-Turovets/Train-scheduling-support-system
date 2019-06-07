package servise;

import model.dao.daointerfaces.DAoCrossing;
import model.dao.daointerfaces.DAoRoute;
import model.dao.imp.CrossingTableInfo;
import model.dao.imp.RouteTableInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class AddStationServise {

    private HttpServletRequest request;

    private String startStation;
    private String startTime;
    private String nextStation;

    public AddStationServise(HttpServletRequest request) {
        this.request = request;
        this.startStation = request.getParameter("startStation");
        this.startTime = request.getParameter("startTime");
        this.nextStation = request.getParameter("nextStation");
        addStation();
    }

    private void addStation() {
        if (request.getSession().getAttribute("startStation") == null) {
            request.getSession().setAttribute("startStation", startStation);
            request.getSession().setAttribute("startTime", startTime);
            request.setAttribute("nextStation", startStation);
        } else {
            request.setAttribute("nextStation", nextStation);
        }


        if (request.getSession().getAttribute("stationList") == null) {
            ArrayList<Integer> timeList = new ArrayList<>();
            ArrayList<String> stationList = new ArrayList<>();

            timeList.add(Integer.parseInt(startTime));
            stationList.add((String) request.getAttribute("nextStation"));

            request.getSession().setAttribute("stationList", stationList);
            request.getSession().setAttribute("timeList", timeList);
        } else {
            // add new Station
            ArrayList<String> stationList = (ArrayList<String>) request.getSession().getAttribute("stationList");
            stationList.add((String) request.getAttribute("nextStation"));
            request.getSession().setAttribute("stationList", stationList);


            DAoCrossing d = new CrossingTableInfo();


            // add new Time Station
            ArrayList<Integer> timeList = (ArrayList<Integer>) request.getSession().getAttribute("timeList");
            int deprecatedTime = timeList.get(timeList.size() - 1);
            int currentTime = (Integer) d.getTimeCrossing(stationList.get(stationList.size() - 2), stationList.get(stationList.size() - 1));
            int newTime = deprecatedTime + currentTime;

            String lastStation = stationList.get(stationList.size() - 1);
            String preLastStation = stationList.get(stationList.size() - 2);
            int crossId = d.getCrossIndexInteger(lastStation, preLastStation);


            if (route(crossId, deprecatedTime, newTime)) {
                timeList.add(newTime);
                request.getSession().setAttribute("timeList", timeList);
            } else {
                stationList.remove(stationList.size() - 1);
                request.getSession().setAttribute("stationList", stationList);
            }

        }
    }

    private boolean route(Integer indexCrossing, int startTime, int endTime) {
        DAoRoute dAoRoute = new RouteTableInfo();

        int routeStartTime = dAoRoute.getStartCrossingTime(indexCrossing);
        int routeEndTime = dAoRoute.getEndCrossingTime(indexCrossing);

        if ((startTime >= routeStartTime && startTime <= routeEndTime) || (endTime >= routeStartTime && endTime <= routeEndTime)) {
            return false;
        }

        return true;
    }

}
