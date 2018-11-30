<!DOCTYPE html>
<html lang="en" href="style.css" href="//fonts.googleapis.com/css?family=Play">
<head>
    <link href="style.css" rel="stylesheet" type="text/css" media="all">
    <link href="accountPageStyle.css" rel="stylesheet" type="text/css" media="all">
    <meta charset="UTF-8">
    <title>Cinema</title>
</head>

<body>
<!-Link map for header-->
<map name="header-links">
    <area target="" alt="browse" title="browse" href="Browse.jsp" coords="227,204,347,237" shape="rect">
    <area target="" alt="account" title="account" href="Authentication"  coords="353,203,473,237" shape="rect">
    <area target="" alt="home" title="home" href="index.jsp" coords="154,79,532,168" shape="rect">
</map>

<div id="wrapper">
    <div class="header">
        <div id="header-img"><img usemap="#header-links" src="Images/retroheader3.png"/></div>
    </div>

    <div class="content content-text">
        <div class="contentBox">
            <div id="signupwrapper">
                <form action="PaymentServlet" method="post">
                    <p>Card Type
                        <select>
                            <option value="MasterCard">MasterCard</option>
                            <option value="Visa">Visa</option>
                            <option value="AmericanExpress">American Express</option>
                        </select>
                    </p>

                    <p>Address:
                        <script></script>
                    <p>Street
                        <input type="text" name="street" required/>
                    </p>
                    <p>City
                        <input type="text" name="city" required/>
                    </p>
                    <p>State
                        <input type="text" name="state" required/>
                    </p>
                    <p>Zip code
                        <input type="text" name="zipcode" required/>
                    </p>
                    </p>
                    <p>
                        Promocode
                        <input type="text" name="promoDiscount">
                    </p>
                    <p style="font-size: 10pt; color: indianred">All fields require input</p>
                    <p>
                        <input type="submit" value="pay">
                    </p>
                </form>
            </div>
        </div>
    </div>

    <div id="footer">

    </div>
</div>
</body>
</html>