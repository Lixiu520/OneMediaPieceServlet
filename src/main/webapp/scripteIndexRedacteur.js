function toggleDetail(label,id) {
         var detailElement = document.getElementById("detail-" + label+"-"+id);
        if (detailElement.style.display === "none") {
            detailElement.style.display = "flex";
        } else {
            detailElement.style.display = "none";
        }
    }
const compte = document.getElementById("user");
const compteEtTypeCompte = document.getElementById("monArt");
const connection = document.getElementById("connection");
let connectionContenu = "";

//var compteS = "${CompteS.compte}";

function connecter() {
    if( "${CompteS.compte}" != null) { 
        connectionContenu = `
            <li class="containerRow connection">
                <img src="img/parametre.png" alt="parametre">
                <p id="user">${CompteS.pseudo}</p>
            </li>
            <li><a href="http://localhost:8080/OneMediaPieceServlet/Deconnection"><img class="logout" src="img/logout.png" alt="deconnection"></a></li>
            <li><img src="img/notice.png" alt="menu"></li>
            <li><img src="img/menu.png" alt="menu"></li>
        `;
    } else {
        connectionContenu = `
            <li class="containerRow connection">
                <a href="http://localhost:8080/OneMediaPieceServlet/Connection" class="containerRow">Sign In
                    <img src="img/flechDroite.png" alt="flechright">
                </a>
            </li>
            <li><img src="img/notice.png" alt="menu"></li>
            <li><img src="img/menu.png" alt="menu"></li>
        `;
    }
    connection.innerHTML+=connectionContenu;
}
connecter();