function toggleDetail(label,id) {
         var detailElement = document.getElementById("detail-" + label+"-"+id);
        if (detailElement.style.display === "none") {
            detailElement.style.display = "flex";
        } else {
            detailElement.style.display = "none";
        }
    }
   