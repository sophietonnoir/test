
window.onload=function()
{
    load.script("resources/js/respo_eleve.js");
};
var $rows = $("tr").has("td");
$("#eleveSearch").keyup(function() {
        var val = $.trim(this.value);
        var word1="";
        var word2="";
        if (val === "")
            $rows.show();

        else if((val).indexOf(" ")==-1){
            word1=val;
            $rows.hide();
            $rows.has("td:contains(" + word1 + ")").show();
        }
        else if((val).indexOf(" ")!=-1) {
            word2=$.trim(val.substring(val.indexOf(" "),val.length));
            $rows.hide();
            $("tr:contains("+word1+")").has("td:contains("+word2+")").show();
        }

    }
);
//Checkbox pour filtrer les étudiants selon le parcours du respo
var a=$("#checkByParc").click(function(){
    if (this.checked){
        var parcours=this.value;//On récupère le parcours du respo
        var etudiants =$("tr").has(".hide:not(:contains("+parcours+"))");//Etudiants qui ne font pas partis du parcours
        etudiants.hide();//On les cache
    }
})


//liste déroulante pour filtrer les étudiants selon les promotions
var a=$("#promo").click(function(){
    console.log(this.value)
    var $rows = $("tr").has("td");
    $rows.hide()
    var parcours=this.value;//On récupère le parcours du respo
    var etudiants =$("tr").has(".hide:contains("+parcours+")");//Etudiants qui ne font pas partis du parcours
    etudiants.show();//On les cache

})

