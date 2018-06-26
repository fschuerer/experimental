<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Rezepte</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="submit" method="post">
            <input type="text" name="name" placeholder="Name" />
            <br />
            <select name="zeitpunkt">
                <c:forEach items="${zeitpunkte}" var="entry">
                    <option value="${entry}">${entry}</option> 
                </c:forEach>
            </select>
            <br />
          <!--  <form action="form" method="POST"> -->
          <select name="all" id="all">
                <c:forEach items="${nmManager.all}" var="entry">
                        <option value="${entry}">${entry.name}</option>
                    </c:forEach>
          </select>    
               <!-- <input type="search" id="nm" name="nm" list="nahrungsmittelliste" />
                <datalist id="nahrungsmittelliste">
                    <c:forEach items="${nmManager.all}" var="entry">
                        <option value="${entry}">${entry.name}</option>
                    </c:forEach>
                </datalist> 
               -->
                <input type="number" name="menge" id="menge" placeholder="Menge" />    
                <button type="button" id="add">Hinzufügen</button>
           <!-- </form> -->
            <br/>
            <select id="id" name="nm" multiple>
            </select>
            <br/>
            <input type="submit" />
        </form>
        <script>
            document.getElementById("add").onclick = function () {
                var text = document.getElementById("all").value;
                console.log(text);
                var select = document.getElementById("id");
                var option = document.createElement("option");
                option.value = text;
                select.appendChild(option);
                //var textnode = document.createTextNode(text);
                //node.appendChild(textnode);
                //document.getElementById("zutaten").appendChild(node);
            };
        </script>-->
    </body>
</html>
