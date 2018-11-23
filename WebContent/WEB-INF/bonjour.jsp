<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
    <c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }">
        <p>Vous êtes ${ sessionScope.prenom } ${ sessionScope.nom } !</p>
    </c:if>
        <c:if test="${ !empty mail && !empty mail }">
    <c:out value="${ mail}"></c:out>
        </c:if>
        
        <c:if test="${ !empty password && !empty password }">
    <c:out value="${ password}"></c:out>
        </c:if>
    
    <form method="post" action="bonjour">
        <p>
            <label for="nom">Nom : </label>
            <input type="text" name="nom" id="nom" />
        </p>
        <p>
            <label for="prenom">Prénom : </label>
            <input type="text" name="prenom" id="prenom" />
        </p>
        <p>
            <label for="prenom">Mail : </label>
            <input type="text" name="mail" id="mail" />
        </p>
        <p>
            <label for="prenom">Mot de passe : </label>
            <input type="password" name="password" id="password" />
        </p>
        
        <input type="submit" />
    </form>
    
</body>
</html>