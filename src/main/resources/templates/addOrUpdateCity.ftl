<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Form example with Java, Spring Boot, FreeMarker</title>
        <link href="/css/studentStyle.css" rel="stylesheet">
    </head>
    <body>
        <h2>Add or Update City</h2>
        <#if city?? >
        Your submitted data<br>
        City Name: ${city.name}<br>
        City Population: ${city.population}<br>
        <#else>
        <form action="/addOrUpdateCity" method="post">
            Name:<br>
            <input type="text" name="name">
            <br><br>
            Population :<br>
            <input type="text" name="population"><br><br><br><br>

            <input type="submit" value="Submit">
        </form>
        </#if>
        <script src="/js/student.js"></script>
    </body>
</html>