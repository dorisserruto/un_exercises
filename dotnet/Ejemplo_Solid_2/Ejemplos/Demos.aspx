<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Demos.aspx.cs" Inherits="Ejemplos.Demos" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    
    <link href="normalize.css" rel="stylesheet" type="text/css" />
    <link href="bootstrap.min.css" rel="stylesheet" type="text/css" />

    <style>
        body
        {
            background-image: url('bg_body.png');
            background-repeat: repeat;
        }
        
        button
        {
            background-image: url('bg_boton.png');
            background-repeat: repeat-x;
            position: relative;
            vertical-align: top;
            height: 48px;
            width: 200px;
            padding: 0;
            font-size: 18px;
            color: steelblue;
            text-align: center;
            text-shadow: 0 1px 2px rgba(0, 0, 0, 0.25);
            border: 0;
            cursor: pointer;
        }
        
        .logo:hover img
        {
            -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=60)";
            filter: alpha(opacity=60);
            opacity: 0.6;
        }
       
    </style>
</head>
<body>
    <form id="form1" runat="server">
    
    <hr/>
    <h1>Ejemplos</h1>
    <h3>
        Boton con imagen de background</h3>
    <p>
        <button id="BotonPrueba" class="boton-css">
            Presioname!</button>
    </p>
    <hr/>
    <h3>
        Propiedad hover de css</h3>
    <p>
        <a class="logo" href="#">
            <img src="tata-logo.png" border="0" alt="Logo" />
        </a>
    </p>
    </form>
</body>
</html>
