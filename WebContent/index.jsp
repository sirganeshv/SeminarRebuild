<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Seminar hall booking (first form)</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="node_modules/normalize.css/normalize.css">

    <!-- Material Design Components -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
    <link rel="stylesheet" href="node_modules/material-components-web/dist/material-components-web.css">

    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/first-form.css">
  </head>

  <body class="mdc-typography">
    <!--[if lt IE 8]>
      <p>You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

    <header class="mdc-elevation--z2 header-container">
        <img src="img/logo.jpg" alt="College logo">
        <h1 class="mdc-typography--display1">Seminar hall booking</h1>
    </header>

    <div class="mdc-elevation--z4 main-container">
      <div class="form-container">
        <form action="display" method="get">
          <div class="form-item">
            <div class="form-item-label">Date</div>
            <div class="form-item-input">
              <div class="mdc-textfield">
                <input type="text" id="booking-date" name="booking-date" class="mdc-textfield__input" placeholder="Choose a date">
              </div>
            </div>
          </div>

          <div class="form-item">
            <div class="form-item-label">Hall</div>
            <div class="form-item-input">
              <select id="hall" name ="hall" class="mdc-select">
                <option value="" default selected>Choose a hall</option>
                <option value="cse">cse</option>
                <option value="mech">mech</option>
              </select>
            </div>
          </div>

          <div class="form-item form-item-final">
            <div class="form-item-input">
              <button class="mdc-button mdc-button--raised mdc-button--primary" type="submit">
                Next
              </button>
            </div>
          </div>
        </form>
      </div> <!-- form-container -->
    </div> <!-- main-container -->
<!--
    Material design components JS
    <script src="node_modules/material-components-web/dist/material-components-web.js"></script>
    <script>
      /*mdc.autoInit()*/
    </script>
-->
  </body>
</html>