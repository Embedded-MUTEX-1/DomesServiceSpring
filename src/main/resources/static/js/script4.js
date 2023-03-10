let formDataOject = {
    trier : "",
    prixMin : "",
    prixMax : "",
    ageMin : "",
    ageMax : "",
    filtrer : "Chats"
};

let url = 'http://192.168.1.53:8080/DomesServices/TrierFiltrer';
let btnTrier = document.getElementsByClassName('btn-filtrerTrier')[0];
let submitFiltrerTrier = document.getElementsByClassName('submit2')[0];
let articleTemplate = document.getElementsByClassName('template')[0];
let list = (document.getElementsByClassName('listArticle'))[0];

let divCategorie = document.getElementById('categorie');

function displayArticle(url, formDataOject)
{
    list.innerHTML = '';

    fetch(url, {
          method: 'POST', // or 'PUT'
          headers: {
                    'Content-Type': 'application/json',
                   },
          body: JSON.stringify(formDataOject)})
          .then((response) => response.json())
          .then((datas) => {
            for(const articleData of datas.list)
            {
                let articleT = articleTemplate.cloneNode(true);
                (articleT.children)[0].setAttribute('id', articleData.ref.toString());
                let row = ((articleT.children)[0].children)[0];
                let div1 = (row.children)[0];
                let div2 = (row.children)[1];

                let img = (div1.children)[0];
                img.setAttribute('src', 'img/Photo Alvin.png');

                let span = ((div2.children)[0].children)[0];
                span.textContent(articleData.price.toString())

                let p = (div2.children)[1];
                p.textContent(articleData.description);
                list.append(articleT);
            }
            console.log('Success:', data);})
          .catch((error) => {
            console.error('Error:', error);});
}

if(divCategorie.getAttribute('class') != null || divCategorie.getAttribute('class') != '')
{
    formDataOject.filtrer = divCategorie.getAttribute('class');
    displayArticle(url, formDataOject);
}

if(btnTrier != null)
{
    btnTrier.addEventListener('select', function(e){
        displayArticle(url, formDataOject);
        console.log("Trier");
    });
}
if(submitFiltrerTrier != null)
{
    submitFiltrerTrier.addEventListener('click', function(e){
        e.preventDefault();
        e.stopPropagation();
        displayArticle(url, formDataOject);
        console.log("Filtrer");
    });
}