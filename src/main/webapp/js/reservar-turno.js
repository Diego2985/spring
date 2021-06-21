function cambiarPrecio() {
    var  selectedValue= $("#servicios").val();
    alert(selectedValue);
}

function cambiarPrecio2() {
    var selectBox = document.getElementById("servicios");
    var precio = document.getElementById("precio");

    precio.nodeValue = selectBox.options[selectBox.selectedIndex].value;
}