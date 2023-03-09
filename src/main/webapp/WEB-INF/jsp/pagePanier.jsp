<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/style6.css">
    <title>Panier</title>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg  fixed-top">
            <div class="container-fluid">
              <a class="navbar-brand" href="#"><img src="/img/logo.png" alt="Logo DomesService"></a>
              <p class="navbar-brand m-auto"><!-- a remplir automatiquement --></p>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/DomesServices/pageAccueil.html">Accueil</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/DomesServices/pageAideCompte.html">Aide</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/DomesServices/pageAideCompte.html">Compte</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/DomesServices/pagePanier.html">Panier</a>
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
      <div class="listArticle container-fluid">
        <div class="row">
          <div class="article container-fluid" id="12345">
            <div class="row">
              <div class="col-4 text-end">
                <img src="/img/Photo Alvin.png" alt="Photo article" id="photo-article">
              </div>
              <div class="col-4 article-desc">
                <h2 id="titre-article">Alvin <span id="price-article">1000</span>€</h2>
                <p>Description : je suis trop minion aaaaaaaaaaaaaaaaa
                  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                  aaaaaaaaaa
                  aaaaa</p>
              </div>
              <div class="col-4 article-btn">
                <button id="btn-supprimer"><img src="/img/supprimer-article.png" alt="Bouton supprimer"></button>
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="article container-fluid" id="12345">
            <div class="row">
              <div class="col-4 text-end">
                <img src="/img/Photo Alvin.png" alt="Photo article" id="photo-article">
              </div>
              <div class="col-4 article-desc">
                <h2 id="titre-article">Alvin <span id="price-article">1000</span>€</h2>
                <p>Description : je suis trop minion aaaaaaaaaaaaaaaaa
                  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                  aaaaaaaaaa
                  aaaaa</p>
              </div>
              <div class="col-4 article-btn">
                <button id="btn-supprimer"><img src="/img/supprimer-article.png" alt="Bouton supprimer"></button>
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="article container-fluid" id="12345">
            <div class="row">
              <div class="col-4 text-end">
                <img src="/img/Photo Alvin.png" alt="Photo article" id="photo-article">
              </div>
              <div class="col-4 article-desc">
                <h2 id="titre-article">Alvin <span id="price-article">1000</span>€</h2>
                <p>Description : je suis trop minion aaaaaaaaaaaaaaaaa
                  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                  aaaaaaaaaa
                  aaaaa</p>
              </div>
              <div class="col-4 article-btn">
                <button id="btn-supprimer"><img src="/img/supprimer-article.png" alt="Bouton supprimer"></button>
              </div>
            </div>
          </div>
        </div>

        <button id="btn-payer">Payer <span id="price">100</span>€</button>
      </div>
    </main>

    <div id="separator-bottom">

    </div>

    <footer class="fixed-bottom">
        <div class="container-fluid">
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