package controller;

import model.dao.daointerfaces.DAoCrossing;
import model.dao.daointerfaces.DAoRoute;
import model.dao.daointerfaces.DAoSchedule;
import model.dao.daointerfaces.DAoStation;
import model.dao.imp.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "ServletAddRoute")
public class ServletAddRoute extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("save") == null)
        {
            String startStation = request.getParameter("startStation");
            String startTime = request.getParameter("startTime");
            String nextStation = request.getParameter("nextStation");


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

                System.out.println(route(crossId, deprecatedTime, newTime));

                if (route(crossId, deprecatedTime, newTime)) {
                    timeList.add(newTime);
                    request.getSession().setAttribute("timeList", timeList);
                } else {
                    stationList.remove(stationList.size() - 1);
                    request.getSession().setAttribute("stationList", stationList);
                }


            }


            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/addRouteJsp");
            dispatcher.forward(request, response);
        }
        else
            {
            save(request);
            addInSchedule(request);

            nullValue(request);

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/addTrainJsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        nullValue(request);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/startStationJsp");
        dispatcher.forward(request, response);
    }


    private void printParametr(HttpServletRequest request) {
        Enumeration e = request.getParameterNames();
        while (e.hasMoreElements()) {
            Object obj = e.nextElement();
            String fieldName = (String) obj;
            String fieldValue = request.getParameter(fieldName);
            System.out.println(fieldName + " : " + fieldValue + "\n");
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


    private void save(HttpServletRequest request) {
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

    private void addInSchedule(HttpServletRequest request) {
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

    private void nullValue(HttpServletRequest request) {
        request.getSession().setAttribute("stationList", null);
        request.getSession().setAttribute("timeList", null);
        request.getSession().setAttribute("startStation", null);
        request.getSession().setAttribute("startTime", null);
        request.getSession().setAttribute("currentStation", null);
        request.getSession().setAttribute("currentTime", null);
        request.setAttribute("nextStation", null);
    }
}
