<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>#[[$Title$]]#</title>
</head>
<body>
<h1>BUYandCELL</h1><hr>
<h4>All products</h4>
<form action="/" method="get">
    Search by title: <input type="text" name="title"/><br>
    <input type="submit" value="search"/>
    </form>


<#list products as product>
<div>
    <p><b>${product.title}</b> ${product.price} $| <a href="/product/${product.id}">Click for more information</a></p>

</div>
    <#else>
    <h3>Product isin't find</h3>
</#list>
<hr>
<h3>Create new product</h3>
<form action="product/create" method="post" enctype="multipart/form-data"><br>
    Title <input type="text" name="title"/><br>
    Description <input type="text" name="description"/><br>
    Price <input type="number" name="price"/><br>
    City <input type="text" name="city"/><br>
    Author <input type="text" name="author"/><br>
    First photo <input type="file" name="file1"><br>
    Second photo <input type="file" name="file2"><br>
    Third photo <input type="file" name="file3"><br>
<input type="submit" value="Add the product">

</form>
</body>
</html>