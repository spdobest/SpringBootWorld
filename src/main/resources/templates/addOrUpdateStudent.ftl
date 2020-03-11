<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Form example with Java, Spring Boot, FreeMarker</title>
        <link href="/css/studentStyle.css" rel="stylesheet">
    </head>
    <body>
        <h2>Handling Form Submission example with Java, Spring Boot, FreeMarker</h2>
        <#if student?? >
        Your submitted data<br>
        First name: ${student.studentName}<br>
        Last name: ${student.studentEmail}<br>
        <#else>
        <form action="/addOrUpdateStudent" method="post">
            Name:<br>
            <input type="text" name="studentName">
            <br><br>
            Email Id:<br>
            <input type="text" name="studentEmail">
            <br><br>
            AGE :<br>
            <input type="text" name="studentAge">
            <br><br>
            <input type="submit" value="Submit">
        </form>
        </#if>
        <script src="/js/student.js"></script>
    </body>
</html>