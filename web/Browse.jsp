<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="movieStyle.css">
    <link rel="stylesheet" type="text/css" href="browseStyle.css">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <title>Browse Movies</title>
</head>
<body>
<!-Link map for header-->
<map name="header-links">
    <area target="" alt="browse" title="browse" href="loadMovies" coords="227,204,347,237" shape="rect">
    <area target="" alt="account" title="account" href="Authentication"  coords="353,203,473,237" shape="rect">
    <area target="" alt="home" title="home" href="index.jsp" coords="154,79,532,168" shape="rect">
</map>

    <div id="wrapper">
        <div class="header">
            <div id="header-img"><img usemap="#header-links" src="Images/retroheader3.png"/></div>
        </div>

        <div class="content">
            <div id="search">
                <input type="text">
                <button>search</button>
                </input>
                Filter:
                <select>
                    <option>Movie Title</option>
                    <option>Now Showing</option>
                    <option></option>
                </select>
            </div>
            <!-Movie list(vertical)-->
                <div class="row">
                    ${HTML}
                </div>
        </div>

    </div>


</body>
</html>