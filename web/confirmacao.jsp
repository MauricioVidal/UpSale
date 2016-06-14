<html>
    <head>
        <script src="script/script.js" charset=UTF-8></script>
    </head>
    <body>
        <%
            out.print("<script>window.onload = Confirmacao('" + (String) session.getAttribute("redirect")+"');</script>");
            session.removeAttribute("redirect");
        %>
    </body>
</html>