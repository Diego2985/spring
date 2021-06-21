function cambiarPrecio() {
    $('input[path="serviciosSeleccionados"]').change(function() {
        if ($(this).is(':checked')) {
            console.log("Checkbox is checked..")
        } else {
            console.log("Checkbox is not checked..")
        }
        alert("checked")
    });
    // let checked = $('input[id="servicios"]').is(':checked')
    // console.log("Checkbox is not checked..")
    // alert(checked)
}

function cambiarPrecio2() {
    var selectBox = document.getElementById("servicios");
    var precio = document.getElementById("precio");

    precio.nodeValue = selectBox.options[selectBox.selectedIndex].value;
}