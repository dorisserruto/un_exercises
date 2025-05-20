<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Demos2.aspx.cs" Inherits="Ejemplos.Demos2" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Demos </title>
    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="docs.min.css" rel="stylesheet">
    <style>
        .content-wrapper
        {
            background-color: #2F9DD8;
            margin: 0 auto;
            width: 100%;
            height: 70px;
        }
        
        img.pelicula
        {
            width: 40px;
            height: 40px;
            background: url(iconos.png) -38px -33px;
        }
        img.antena
        {
            width: 40px;
            height: 33px;
            background: url(iconos.png) -150px -150px;
        }
    </style>
    
    <script type="text/javascript">
        function Validar_Click(boton) 
        {
            var texto = document.getElementById('TextoParaValidar');
            if (texto.value.length <= 0) 
            {
                alert('Ingresar valor');
                return false;
            }
        }
    </script>

</head>
<body>
    <form runat="server">
    <div class="content-wrapper">
        <br />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="tcs.png" />
        <br />
    </div>
    <br />
    <div class="container bs-docs-container">
        <div class="row">
            <div class="col-md-9" role="main">
                <div class="bs-docs-section">
                    <h3 id="overview-doctype">
                        Sprites</h3>
                    <p>
                        Pelicula:<img class="pelicula" src="img_trans.png">
                        <br />
                        Antena:
                        <img class="antena" src="img_trans.png">
                    </p>
                    <div class="highlight">
                        <pre><code class="css">
                             img.pelicula { width: 40px; height: 40px; background: url(iconos.png)
                            -38px -33px; } img.antena { width: 40px; height: 33px; background: url(iconos.png)
                            -150px -150px; } 
                        </code></pre>
                    </div>
                    <h3 id="overview-mobile">
                        Validar en Cliente</h3>
                    <p>
                        <asp:TextBox ID="TextoParaValidar" runat="server"></asp:TextBox>
                        <asp:Button ID="Button1" runat="server" Text="Validar" OnClientClick="Validar_Click(this)"/>
                        </p>
                </div>
            </div>
        </div>
    </div>


    </form>
</body>
</html>
