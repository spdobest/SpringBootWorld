<!DOCTYPE html>
<html>
    <head>
        <title>`Student List`</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h2>List of Students</h2>

        <table>
            <tr>
                <th>studentId</th>
                <th>studentName</th>
                <th>studentAge</th>
                <th>studentEmail</th>
            </tr>

            <#list students as student>
                <tr>
                    <td>${student.studentId}</td>
                    <td>${student.studentName}</td>
                    <td>${student.studentAge}</td>
                    <td>${student.studentEmail}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>