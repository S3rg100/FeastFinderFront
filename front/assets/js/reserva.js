document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("formularioReserva");
  form.addEventListener("submit", guardarReserva);
});

async function fetchRestauranteIdPorNombre(nombreRestaurante) {
  const url = `http://localhost:8080/restaurante/detalles/${encodeURIComponent(
    nombreRestaurante
  )}`;
  const authToken = localStorage.getItem("authToken"); // Asegúrate de reemplazar esto con tu token de autenticación real

  try {
        const response = await fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                Authorization: `Bearer ${authToken}`,
            },
        });
        console.log(response.status);
        if (!response.ok) {
            throw new Error("Network response was not ok");
        }
        const data = await response.json();
        console.log("Restaurante recibido:", data);
        console.log("id recibido:", data.id);
        return data.id;
    } catch (error) {
        console.error("Error al obtener detalles del restaurante:", error);
    }
}

function actualizarRestaurantes() {
  const ciudadSeleccionada = document.getElementById("ciudades").value;
  const restaurantesSelect = document.getElementById("restaurantes");

  // Clears the previous options
  restaurantesSelect.innerHTML = "";

  if (ciudadSeleccionada === "Bogota") {
    agregarRestaurante("Cantina la 15", 2);
    agregarRestaurante("Todo es color di Rosa", 10);
    agregarRestaurante("Pizzardi Artigianale", 8);
  } else if (ciudadSeleccionada === "Medellin") {
    agregarRestaurante("Kampanas Cocinas del Mundo",4 );
    agregarRestaurante("Maximo Marea Mediterraneo", 6);
    agregarRestaurante("La Pampa Parrilla Envigado", 7);
  } else if (ciudadSeleccionada === "Cartagena") {
    agregarRestaurante("Inkanto Prime", 3);
    agregarRestaurante("Lucena Rooftop", 5);
    agregarRestaurante("San Nicolas Restaurante", 9);
  } else {
    // If no city is selected, display a default message
    const option = document.createElement("option");
    option.text = "Selecciona una ciudad primero...";
    restaurantesSelect.appendChild(option);
  }
}

function agregarRestaurante(nombreRestaurante, index) {
  const restaurantesSelect = document.getElementById("restaurantes");
  const option = document.createElement("option");
  option.text = nombreRestaurante;
  option.value = index;
  restaurantesSelect.appendChild(option);
}

function guardarReserva(event) {
  event.preventDefault();
  const url = "http://localhost:8080/reserva";
  const authToken = localStorage.getItem("authToken");

  // Obtener el nombre del restaurante seleccionado
  const nombreRestaurante =
    document.getElementById("restaurantes").selectedOptions[0].text;
  console.log("Nombre del restaurante seleccionado:", nombreRestaurante);

  // Llama a la función para obtener el ID del restaurante por su nombre
  fetchRestauranteIdPorNombre(nombreRestaurante)
    .then((restauranteId) => {
      console.log("ID del Restaurante obtenido:", restauranteId);

      const datosReserva = {
        usuarioID: localStorage.getItem("usuarioId"),
        restauranteID: document.getElementById("restaurantes").value,
        fecha: document.getElementById("fecha").value,
        hora: document.getElementById("hora").value,
        estado: "C",
        descripcion: document.getElementById("recomendacion").value,
      };

      console.log("Datos de la reserva:", datosReserva);

      if (
        datosReserva.usuarioID &&
        restauranteId &&
        datosReserva.fecha &&
        datosReserva.hora &&
        datosReserva.descripcion
      ) {
        

        fetch(url, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${authToken}`,
          },
          body: JSON.stringify(datosReserva),
        })
          .then((response) => {
            if (!response.ok) {
              throw new Error("Network response was not ok.");
            }
            return response.json();
          })
          .then((data) => {
            console.log("Success:", data);
            alert("Reserva realizada con éxito");
            window.location.href = "misReservas.html";
          })
          .catch((error) => {
            console.error("Error:", error);
            alert("Error al realizar la reserva");
          });
      } else {
        alert("Por favor, completa todos los campos necesarios.");
      }
    })
    .catch((error) => {
      console.error("Error al obtener el ID del restaurante:", error);
      alert("Error al obtener información del restaurante");
    });
}
