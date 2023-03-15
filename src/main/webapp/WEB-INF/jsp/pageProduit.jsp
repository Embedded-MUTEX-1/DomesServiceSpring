<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/style5.css">
    <title>Produit</title>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg  fixed-top">
                    <div class="container-fluid">
                      <a class="navbar-brand" href="#"><img src="/img/logo.png" alt="Logo DomesService"></a>
                      <c:choose>
        	              <c:when test="${empty client}" >
        	              	<p class="navbar-brand m-auto connexion"><a class="navbar-brand connexion" href="Connexion">Se connecter</a></p>
        	              </c:when>
        	              <c:when test="${!empty client}" >
        	              	<p class="navbar-brand m-auto connexion"><c:out value="${client.nom}" /></p>
        	              </c:when>
                      </c:choose>
                      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                      </button>
                      <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                          <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/Accueil">Accueil</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link" href="/AideCompte">Aide</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link" href="/AideCompte">Compte</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link" href="/Panier">Panier</a>
                          </li>
                        </ul>
                        <form class="d-flex">
                          <input class="form-control" type="search" placeholder="Recherche" aria-label="Search">
                          <button class="btn" type="submit"><img src="/img/btn recherche.png" alt="Bouton recherche"></button>
                        </form>
                      </div>
                    </div>
        </nav>
    </header>

    <div id="separator">

    </div>

    <main>
      <div id="div-main">
        <div class="container-fluid article">
          <div class="row ">
            <div class="col-12">
              <h1 id="name"><c:out value="${article.name}" /></h1>
            </div>
          </div>

          <div class="row">
            <div class="col-12 col-lg-6 text-center">
              <img src="${article.imgUrl}" alt="Photo article" id="photo-article">
            </div>

            <div class="col-12 col-lg-6 content-desc">
              <div id="article-desc" class="text-start">
                <h2 class="text-center">Description :</h2>
                <p><c:out value="${article.description}" /></p>
                <p>
                  Race : <span id="race"><c:out value="${race.race}" /></span><br>
                  Age : <span id="age"><c:out value="${article.age}" /></span>ans
                </p>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-12">
              <div  class="text-center">
                <button>Ajouter au panier pour <span id="price"><c:out value="${article.price}" /></span>€ <img src="/img/icone panier.png" alt="Icone panier" id="Icone-panier"></button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg">
                    <a href="">CGV</a>
                </div>
                <div class="col-lg">
                    <a href="">CGU</a>
                </div>
                <div class="col-lg">
                    <a href="">Qui sommes nous ?</a>
                </div>
                <div class="col-lg">
                    <a href="">Mentions légales</a>
                </div>
                <div class=" col col-lg">
                    <a href=""><img src="https://cdn-icons-png.flaticon.com/128/174/174848.png" alt="Logo Facebook - Freepik - flaticon"></a>
                </div>
                <div class="col col-lg">
                    <a href=""><img src="https://cdn-icons-png.flaticon.com/128/3670/3670147.png" alt="Logo Youtube -  Md Tanvirul Haque - flaticon"></a>
                </div>
                <div class="col col-lg">
                    <a href=""><img src="https://cdn-icons-png.flaticon.com/128/145/145807.png" alt="Logo Linkedin - Freepik - flaticon"></a>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>