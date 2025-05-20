<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="Ejemplos.Index" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link href="bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>
            Suma
        </h1>
        Ingrese Operandos:
        <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        +
        <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
        <hr />
        <asp:Button ID="Button1" runat="server" Text="Button" OnClick="Button1_Click" />
        <h4>
            Resultado:</h4>
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
    </div>
    </form>
</body>
</html>
