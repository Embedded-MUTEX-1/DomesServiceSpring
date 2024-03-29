<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/style7.css">
    <title>Compte et aide</title>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg  fixed-top">
                    <div class="container-fluid">
                      <a class="navbar-brand" href="#"><img src="/img/logo.png" alt="Logo DomesService"></a>
                      <c:choose>
        	              <c:when test="${empty client.nom}" >
        	              	<p class="navbar-brand m-auto connexion"><a class="navbar-brand connexion" href="Connexion">Se connecter</a></p>
        	              </c:when>
        	              <c:when test="${!empty client.nom}" >
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
      <div class="container-fluid">
        <div class="row">
          <div class="col-12 col-lg-6">
            <div class="bouton">
              <!-- Button trigger modal -->
                <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#commande">
                  Mes commandes
                </button>

                <!-- Modal -->
                <div class="modal fade" id="commande" tabindex="-1" aria-labelledby="commandeModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Mes commandes</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                      </div>
                      <div class="modal-body">
                        ...
                      </div>
                    </div>
                  </div>
                </div>
            </div>
            <div class="bouton">
              <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#adresse">
                Mon adresse
              </button>

              <!-- Modal -->
              <div class="modal fade" id="adresse" tabindex="-1" aria-labelledby="adresseModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h1 class="modal-title fs-5" id="exampleModalLabel">Mon adresse</h1>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                      <form:form action="/ModifierAdresse" modelAttribute="client">
                        <div class="mb-3">
                          <label for="adresseNom" class="form-label">Nom Adresse</label>
                          <form:input cssClass="form-control" id="adresseNom" path="adresse.addrName" />
                        </div>
                        <div class="mb-3">
                           <label for="adresse" class="form-label">Adresse</label>
                           <form:input cssClass="form-control" id="adresse" path="adresse.address" />
                        </div>
                        <div class="mb-3">
                          <label for="code_postale" class="form-label">Code postale</label>
                          <form:input cssClass="form-control" id="code_postale" path="adresse.postalCode" />
                        </div>
                        <div class="mb-3">
                          <label for="ville" class="form-label">Ville</label>
                          <form:input cssClass="form-control" id="ville" path="adresse.city" />
                        </div>
                        <div class="mb-3">
                          <label for="code_postale" class="form-label">Pays</label>
                          <form:input cssClass="form-control" id="code_postale" path="adresse.country" />
                        </div>
                        <button type="submit" class="btn">Modifier</button>
                      </form:form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-12 col-lg-6">
            <div class="bouton">
              <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#profile">
                Mon profile
              </button>

              <!-- Modal -->
              <div class="modal fade" id="profile" tabindex="-1" aria-labelledby="profileModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h1 class="modal-title fs-5" id="exampleModalLabel">Mon profile</h1>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                      <form:form action="/ModifierCompte" modelAttribute="client">
                        <div class="mb-3">
                          <label for="mail" class="form-label">Email</label>
                          <form:input cssClass="form-control" id="email" path="email" />
                        </div>
                        <div class="mb-3">
                          <label for="nom" class="form-label">Nom</label>
                          <form:input cssClass="form-control" id="nom" path="nom" />
                        </div>
                        <div class="mb-3">
                          <label for="prenom" class="form-label">Prenom</label>
                          <form:input cssClass="form-control" id="prenom" path="prenom" />
                        </div>
                        <div class="mb-3">
                          <label for="telephone" class="form-label">Télephone</label>
                          <form:input cssClass="form-control" id="telephone" path="telephone" />
                        </div>
                        <button type="submit" class="btn">Modifier</button>
                      </form:form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="bouton">
              <button type="button" id="bt-connexion" class="btn" onclick="window.location.href='/SeDeconnecter';">
                Se deconnecter
              </button>
            </div>
            <div class="bouton">
              <button type="button" id="bt-supprimer" class="btn" onclick="window.location.href='/SupprimerCompte'">
                Supprimer son compte
              </button>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12 col-lg-6 mb-3">
            <div>
              <h3 id="faq">
                Foire aux questions
              </h3>
            </div>
            <div class="overflow-scroll">
              <div class="content">
                <div class="align">
                <h6>Question : Blablabla ?</h6>
                <p>
                  Réponse :<br />
                  Blabla c'est inintéressant
                </p>
                </div>
              </div>

              <div class="content">
                <div class="align">
                <h6>Question : Blablabla ?</h6>
                <p>
                  Réponse :<br />
                  Blabla c'est inintéressant
                </p>
                </div>
              </div>
            </div>
          </div>

          <div class="col-12 col-lg-6 div-contact">
            <div class="map">
              <img src="/img/map.png" alt="Carte DomesService">
            </div>
            <div class="title-contact">
              <h3>Contact :</h3>
            </div>
            <div class="contact">
              <img src="/img/Contact.png" alt="Icone mail">
              <img src="/img/Phone.png" alt="Icone téléphone">
              <img src="/img/Position.png" alt="Icone adresse">
            </div>
          </div>
        </div>

        <!-- Modal -->
        <!-- 
        <div class="modal fade" id="MonAdresseModalCenter" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                ...
              </div>
            </div>
          </div>
        </div>-->

        <!-- Modal -->
        <!-- 
        <div class="modal fade" id="MonProfileModalCenter" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                ...
              </div>
            </div>
          </div>
        </div>  -->
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