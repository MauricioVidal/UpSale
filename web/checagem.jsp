<html>
    <head>
        <script src="script/script1.js" charset=UTF-8></script>
    </head>
    <body>
        <%
            out.print("<script>window.onload = Confirmacao(\"" 
                    + (String) session.getAttribute("redirect")
                    + "\",\""
                    + (String) session.getAttribute("msg")
                    + "\");</script>");
            session.removeAttribute("redirect");
            session.removeAttribute("msg");
        %>
    </body>
</html>