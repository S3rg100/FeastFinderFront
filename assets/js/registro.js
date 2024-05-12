document
  .getElementById("registroForm")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // Prevenir el comportamiento por defecto del formulario

    // Crear un objeto con los datos del usuario
    const usuarioRegistrado = {
      nombre: document.getElementById("nombre").value,
      apellido: document.getElementById("apellido").value,
      correoElectronico: document.getElementById("correoElectronico").value,
      nombredecuenta: document.getElementById("nombredecuenta").value,
      contrasena: document.getElementById("contrasena").value,
    };

    console.log(usuarioRegistrado);

    const opciones = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
       
      },
      body: JSON.stringify(usuarioRegistrado),
    };

    const url = "http://localhost:8080/auth/register";

    fetch(url, opciones)
      .then((response) => {
        console.log(response); 
        return response.json(); 
      })
      .then((data) => {
        console.log("Respuesta del servidor:", data); 
        localStorage.setItem('authToken', data.token); 
        window.location.href = './restaurantesList.html'; 
      })
      .catch((error) => {
        console.error("Error al enviar los datos:", error);
      });
  });
