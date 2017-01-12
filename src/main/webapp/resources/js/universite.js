window.onload=function()
{
    load.script("resources/js/universite.js");
};
var $rows = $("tr");
$("#search").keyup(function() {
    var val = $.trim(this.value);
    if (val === "")
        $rows.show();
        
    else {
        $rows.hide();
        $rows.has("h3:contains(" + val + ")").show();
    }
});


//à ameliorer pour qu'il marche pour les accents et Majuscules