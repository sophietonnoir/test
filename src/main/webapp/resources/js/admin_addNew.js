
window.onload=function()
{
    load.script("resources/js/admin_addNew.js");
};
$("button").click(function(){
    var response="Oups il semblerait que n'avez pas s\351l\351ctionnez de fichier !";
    if ($("#addParcours").val()!=""){
        response="Votre fichier a bien \351t\351 ajout\351";
    }
    alert(response);
});