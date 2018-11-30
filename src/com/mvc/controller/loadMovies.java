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

public class loadMovies extends HttpServlet {
    public loadMovies() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        Movie movie = new Movie();
        ArrayList<Movie> movies = movie.retrieveMoviesBasedOnStatus(1);
        ArrayList<String> movieHTML = new ArrayList<>();
        int i = 0;
        String HTML;
        String allContent = "";

        for(Movie m : movies){
            HTML =  "<form action=\"loadMovieInfo\" method=\"post\">" +
                        "<div class=\"item\" id=\"movie" + i + "\">" +
                        "<img class=\"moviePoster\" src=\"" + m.getTrailerPicLink() + "\">" +
                            "<div class=\"movieTitleLink\">" +
                                "<input type=\"hidden\" value=\"" + m.getTitle() + "\">" + m.getTitle() +
                                "<br>" +
                                "<button  class=\"selectMovieButton\" type=\"submit\" name=\"" + m.getTitle() + "\" action=\"loadMovieInfo\">Select</button>" +
                            "</div>" +
                        "</div>" +
                    "</form>";
            movieHTML.add(HTML);
            i++;
        }

        for(String H : movieHTML){
            allContent += H;
        }

        request.setAttribute("HTML", allContent);

        //Movie movie1 = movies.get(0);
        //request.setAttribute("movie1", movie1);
/*        Movie movie2 = movies.get(1);
        Movie movie3 = movies.get(2);
        Movie movie4 = movies.get(3);
        Movie movie5 = movies.get(4);



        request.setAttribute("movie2", movie2);
        request.setAttribute("movie3", movie3);
        request.setAttribute("movie4", movie4);
        request.setAttribute("movie5", movie5);
*/

        RequestDispatcher rd = request.getRequestDispatcher("Browse.jsp");
        rd.forward(request,response);
        }


}
