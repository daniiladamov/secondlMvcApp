<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>#[[$Title$]]#</title>
</head>
<body>
<h1>BUYCELL</h1><hr>
<h4>Information about product</h4>

<#list images as image>
    <img src="/images/${image.id}" height="60px"/><br><br>

</#list>
<b>Product title</b>${product.title}<br>
<b>Price</b>${product.price}<br>
<b>Description</b>${product.description}<br>
<b>City</b>${product.city}<br>
<b>Author</b>${product.author}<br>
<hr>

<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Delete the product">
</form>
</body>
</html>