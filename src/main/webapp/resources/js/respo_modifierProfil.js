var inputs = document.querySelectorAll('input[list]');
for (var i = 0; i < inputs.length; i++) {
    // Quand la value de l'input change
    inputs[i].addEventListener('change', function() {
        var optionFound = false,
            datalist = this.list;
        // Détermine si les valeurs entrées sont disponibles dans la datalist.
        for (var j = 0; j < datalist.options.length; j++) {
            if (this.value == datalist.options[j].value) {
                optionFound = true;
                break;
            }
        }
        // utilisation de la fonction setCustomValidity 
        // afin d'afficher un feedback à l'utilisateur si la valeur entrée n'existe dans la datalist
        if (optionFound) {
            this.setCustomValidity('');
        } else {
            this.setCustomValidity('Selectionner un parcours disponible.');
        }
    });
}