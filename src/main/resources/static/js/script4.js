let url = '/api/articles';
let btnTrier = document.getElementsByClassName('btn-filtrerTrier')[0];
let submitFiltrerTrier = document.getElementsByClassName('submit2')[0];
let articleTemplate = document.getElementsByClassName('template')[0];
let list = (document.getElementsByClassName('listArticle'))[0];

let divCategorie = document.getElementById('categorie');

function displayArticle(url, trier, prixMin, prixMax, ageMin, ageMax, filtrer)
{
    list.innerHTML = '';

    let urlApi = url + `?trier=${trier}&prixMin=${prixMin}&prixMax=${prixMax}&ageMin=${ageMin}&ageMax=${ageMax}&filtrer=${filtrer}`

    fetch(urlApi)
          .then((response) => response.json())
          .then((listData) => {
            for(const articleData of listData)
            {
                let articleT = articleTemplate.cloneNode(true); //Copie du template
                let row = ((articleT.children)[0].children)[0];
                let div1 = (row.children)[0];
                let div2 = (row.children)[1];

                let a = (div1.children)[0];
                a.href = '/Animal?id=' + articleData.ref.toString();

                let img = (a.children)[0];
                img.setAttribute('src', articleData.imgUrl.toString());

                let h2 = (div2.children)[0];
                h2.textContent = articleData.name.toString() + ' ' + articleData.price.toString() + '€';

                //let span = (h2.children)[0];
                //span.textContent = articleData.price.toString();

                articleT.classList.remove('template');

                let p = (div2.children)[1];
                p.textContent = articleData.description.toString();
                list.append(articleT);
            }})
          .catch((error) => {
            console.error('Error:', error);});
}

if(divCategorie != null && divCategorie.textContent != '')
{
     displayArticle(url, 0, 0, 5000, 0, 20, divCategorie.textContent);
}

// if(btnTrier != null)
// {
//     btnTrier.addEventListener('select', function(e){
//         displayArticle(url, formDataOject);
//         console.log("Trier");
//     });
// }
if(submitFiltrerTrier != null)
{
    submitFiltrerTrier.addEventListener('click', function(e){
        e.preventDefault();
        e.stopPropagation();

        const data = new FormData(document.getElementById("formArticle"));

        displayArticle(url, data.get("trier"), data.get("prixMin"), data.get("prixMax"), data.get("ageMin"), data.get("ageMax"), data.get("filtrer"));
        console.log("Filtrer");
    });
}