// Calificacion
var contador;

function calificar(item) {
  console.log(item);
  contador = item.id[0];
  let nombre = item.id.substring(1);
  for (let i = 0; i < 5; i++) {
    if (i < contador) {
      document.getElementById((i + 1) + nombre).style.color = "orange";
    } else {
      document.getElementById((i + 1) + nombre).style.color = "black";
    }
  }
}

function mensaje(nombre) {
  Swal.fire({
    icon: 'success',
    title: 'Comentario enviado',
    showConfirmButton: false,
    timer: 10000
  })
}

//boton up
$(document).ready(function () {

  $('.ir-arriba').click(function () {
    $('body, html').animate({
      scrollTop: '0px'
    }, 300);
  });

  $(window).scroll(function () {
    if ($(this).scrollTop() > 0) {
      $('.ir-arriba').slideDown(300);
    } else {
      $('.ir-arriba').slideUp(300);
    }
  });

});

// funciones de boton agregar

function agregar(string, index) {
  //  console.log(event)
  let nextIndex = index + 1;
  let row = document.getElementById(string + nextIndex);
  if (string == "ingrediente") {
    let botA = document.getElementById('botonAI' + index);
    if (botA != null) {
      botA.classList.add("no-mostrar");
    }
  }
  if (string == "paso") {
    let botB = document.getElementById('botonAP' + index);
    if (botB != null) {
      botB.classList.add("no-mostrar");
    }
  }
  if (row != null) {
    row.classList.remove("no-mostrar");
    row.classList.add("mostrar1");

  }
}

function eliminar(string, index) {
  let row = document.getElementById(string + index);
  let lowIndex = index - 1;
  // config para la vista de los botones
  if (string == "ingrediente") {
    let botA = document.getElementById('botonAI' + lowIndex);
    console.log("aca estoy arriba");
    botA.classList.remove("no-mostrar")
    console.log("que onda porque no anda esta bosta??" + lowIndex);
  }
  if (string == "paso") {
    let botB = document.getElementById('botonAP' + lowIndex);
    if (botB != null) {
      botB.classList.remove("no-mostrar");
    }
  }
  if (string == "ingrediente") {
    if (index != 0) {
      let nombre = document.getElementById('nombre' + index);
      let cantidad = document.getElementById('cantidad' + index);
      nombre.value = '';
      cantidad.value = '';
      if (row != null) {
        row.classList.add("no-mostrar");
        row.classList.remove("mostrar1");
      }
    }
  }
  if (string == "paso") {
    if (index != 0) {
      let texto = document.getElementById('procedimiento' + index);
      texto.value = '';
      if (row != null) {
        row.classList.add("no-mostrar")
        row.classList.remove("mostrar1")
      }
    }
  }
}
// funcion boton regresar
function goBack() {
  window.history.back();
}

//Funcion hecha por Lucas
function check_text(input) {
  if (input.validity.patternMismatch) {
    input.setCustomValidity("Nombre de usuario no puede ser null");
  } else {
    input.setCustomValidity("");
  }
}


var images = $(".image");

$(images).on("error", function(event) {
    $(event.target).attr("src", "https://image-placeholder.com/images/actual-size/200x200.png");
});