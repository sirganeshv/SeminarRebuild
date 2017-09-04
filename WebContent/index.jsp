<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Seminar hall booking (first form)</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="node_modules/normalize.css/normalize.css">

    <!-- Material Design Components -->
    <link rel="stylesheet" href="node_modules/material-components-web/dist/material-components-web.css">

    <!-- jQuery UI styles -->
    <link rel="stylesheet" href="node_modules/jquery-ui/themes/base/core.css">
    <link rel="stylesheet" href="node_modules/jquery-ui/themes/base/theme.css">
    <link rel="stylesheet" href="node_modules/jquery-ui/themes/base/datepicker.css">

    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/first-form.css">
  </head>

  <body>
    <!--[if lt IE 8]>
      <p>You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

    <header class="header-container">
        <img src="img/logo.jpg" alt="College logo">
        <h1>Seminar hall booking</h1>
    </header>

    <div class="main-container">
      <div class="form-container">
        <form action="display" method="get">
          <div class="form-item">
            <div class="form-item-label">Date</div>
            <div class="form-item-input">
              <div class="mdc-textfield">
                <input id="booking-date" type="text" class="mdc-textfield__input" name="booking-date" required placeholder="Choose a date" autocomplete="off">
              </div>
            </div>
          </div>

          <div class="form-item">
            <div class="form-item-label">Hall</div>
            <div class="form-item-input">
              <select class="mdc-select" name="hall" required>
                <option value="" selected>Choose a hall</option>
                <option value="cse">CSE</option>
                <option value="mech">Mech</option>
              </select>
            </div>
          </div>

          <div class="form-item">
            <div class="form-item-input">
              <button class="mdc-button mdc-button--raised mdc-button--primary" type="submit">
                Next
              </button>
            </div>
          </div>
        </form>
      </div> <!-- form-container -->
    </div> <!-- main-container -->

    <script type="text/javascript" src="node_modules/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="node_modules/jquery-ui/ui/widgets/datepicker.js"></script>
    <script type="text/javascript">
    <%Calendar current = Calendar.getInstance();%>
    const currServerYear = <%=current.get(Calendar.YEAR) %>;
    const currServerMonth = <%=current.get(Calendar.MONTH)%>;  
    const currServerDay = <%=current.get(Calendar.DATE)%>;
    const currServerDate = new Date(currServerYear, currServerMonth, currServerDay);
    // JS wraps the date for us
    const maxDate = new Date(currServerYear, currServerMonth, currServerDay + 6);
    $(function(){
      $( "#booking-date" ).datepicker({ minDate: currServerDate, maxDate: maxDate ,dateFormat: "dd-M-yy"});
    });
    </script>
<!--
    Material design components JS
    <script src="node_modules/material-components-web/dist/material-components-web.js"></script>
    <script>
      /*mdc.autoInit()*/
    </script>
-->
  </body>
</html>
