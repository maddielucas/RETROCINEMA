package com.mvc.controller;
import java.util.Collections;

import java.util.Enumeration;
import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loadMovieInfo extends HttpServlet {
    public loadMovieInfo() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        Enumeration paramNames = request.getParameterNames();
        String title = "";
        String showTimeHTML = "";

        while(paramNames.hasMoreElements()){
            //System.out.println((String)paramNames.nextElement());
            String paramName = (String)paramNames.nextElement();
            title = paramName;
        }

        Movie movie = new Movie();
        movie.retrieveMovieDataUsingTitle(title);
        Showings showTimes = new Showings();
        ArrayList<Showings> showingsList = showTimes.retrieveShowingsForMovie(title);
        for(Showings s : showingsList){
            showTimeHTML = "<option name=\"" + s.getShowtime() + "\">" + s.getShowtime() + "</option>";
        }


        String poster = movie.getTrailerPicLink();
        String cast = movie.getCast();
        String producer = movie.getProducer();
        String duration = String.valueOf(movie.getDuration());


        request.setAttribute("title", title);
        request.setAttribute("poster", poster);
        request.setAttribute("cast", cast);
        request.setAttribute("producer", producer);
        request.setAttribute("duration", duration);
        request.setAttribute("showTimeHTML", showTimeHTML);


        RequestDispatcher rd = request.getRequestDispatcher("moviePage.jsp");
        rd.forward(request,response);
    }
}