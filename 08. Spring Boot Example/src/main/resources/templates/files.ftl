<!doctype html>
<html lang="en">
<head>
    <title>Загрузка файла</title>
</head>
<body>
<div>
    <form method="post" enctype="multipart/form-data" action="/files">
        <div>
            <label for="file">Выберите файл</label>
            <input type="file" id="file" name="file">
        </div>
        <div>
            <input type="submit">Отправить</input>
        </div>
    </form>
</div>

<img src="/photo/spring.jpg"/>
</body>
</html>