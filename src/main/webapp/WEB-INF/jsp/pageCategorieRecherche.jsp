<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/style4.css">
    <title>CatÃ©gorie et recherche</title>
</head>
<body>
	<p class="hidden"><c:out value="${categorie}" /></p>
    <header>
        <nav class="navbar navbar-expand-lg  fixed-top">
            <div class="container-fluid">
              <a class="navbar-brand" href="#"><img src="/img/logo.png" alt="Logo DomesService"></a>
              <c:choose>  
	              <c:when test="${empty client}" >
	              	<p class="navbar-brand m-auto connexion"><a class="navbar-brand" href="Connexion">Se connecter</a></p>
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

  <!--permet au javascript de detecter la 
      catÃ©gorie ou la race de l'animal
      lors du chargement de la page -->
    <div id="categoryRace" class="Chiens"></div> 

    <div id="separator">

    </div>

    <main>
        <div class="trier-filtrer">
          <form action="/DomesService/TrierFilter" method="post" class="formTrierFiltrer">
            
            <select class="form-select btn-filtrerTrier" name="trier">
              <option value="0" selected>Trier</option>
              <option value="1">Prix croissant</option>
              <option value="2">Prix dÃ©croissant</option>
              <option value="3">Age croissant</option>
              <option value="3">Age decroissant</option>
            </select>

            <!-- Button trigger modal -->
            <button type="button" class="btn btn-filtrerTrier" data-bs-toggle="modal" data-bs-target="#FiltrerModal">
              Filtrer
            </button>

            <!-- Modal -->
            <div class="modal fade" id="FiltrerModal" tabindex="-1" aria-labelledby="FiltrerModal" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                  <div class="modal-header">
                    <h1 class="modal-title fs-5">Filtrer</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <div>
                      <input type="number" name="prixMin" id="prixMin" class="form-control form-filtrer" placeholder="Prix min">
                      <input type="number" name="prixMax" id="prixMax" class="form-control form-filtrer" placeholder="Prix max">
                    </div>

                    <div>
                      <input type="number" name="ageMin" id="ageMin" class="form-control form-filtrer" placeholder="Age min">
                      <input type="number" name="ageMax" id="ageMax" class="form-control form-filtrer" placeholder="Age max">
                    </div>

                    <select class="form-select" name="filtrer" size="5" aria-label="Default select example" id="categorie_race">
                      <option value="None" selected>Category/Race</option>
                      <!-- Ã  remplir avec du javascript
                      <optgroup label="CatÃ©gorie">
                        <option value="Chiens">Chiens</option>
                        <option value="Chats">Chats</option>
                        <option value="Oiseaux">Oiseaux</option>
                        <option value="Poissons">Poissons</option>
                        <option value="Reptiles">Reptiles</option>
                      </optgroup>
                      
                      <optgroup label="Chiens">
                        <option value="Chihuahua">Chihuahua</option>
                        <option value="Jack Russell">Jack Russell</option>
                        <option value="Caniche">Caniche</option>
                      </optgroup>

                      <optgroup label="Chats">
                        <option value="Chartreux">Chartreux</option>
                        <option value="American curl">American curl</option>
                        <option value="NorvÃ©gien">NorvÃ©gien</option>
                      </optgroup>

                      <optgroup label="Oiseaux">
                        <option value="Alexandrine">Alexandrine</option>
                        <option value="Kakariki">Kakariki</option>
                        <option value="Lori">Lori</option>
                      </optgroup>

                      <optgroup label="Poissons">
                        <option value="Guppy">guppy</option>
                        <option value="Platy">platy</option>
                        <option value="NÃ©on bleu">nÃ©on bleu</option>
                      </optgroup>

                      <optgroup label="Reptiles">
                        <option value="Tortue des steppes">Tortue des steppes</option>
                        <option value="Gecko">Gecko</option>
                        <option value="CamÃ©lÃ©on">CamÃ©lÃ©on</option>
                      </optgroup>-->
                    </select>
                  </div>
                </div>
              </div>
            </div>

            <div>
              <button type="submit" class="btn submit submit2
              ">Appliquer</button>
            </div>
          </form>
        </div>

        <div class="listArticle container-fluid">
          <div class="row template">
            <div class="article container-fluid" id="12345">
              <div class="row">
                <div class="col-6 text-center">
                  <img src="/img/Photo Alvin.png" alt="Photo article" id="photo-article">
                </div>
                <div class="col-6 article-desc">
                  <h2 id="titre-article">Alvin <span id="price-article">1000</span>â¬</h2>
                  <p>Description : je suis trop minion aaaaaaaaaaaaaaaaa
                    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                    aaaaaaaaaa
                    aaaaa</p>
                </div>
              </div>
            </div>
          </div>
        </div>
    </main>

    <div id="separator-bottom">

    </div>

    <footer class="fixed-bottom">
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
    <script src="/js/script4.js"></script>
</body>
</html>