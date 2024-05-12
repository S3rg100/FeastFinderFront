document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evita el envío predeterminado del formulario

    const url = "http://localhost:8080/auth/login";
    const datosusuario = {
        nombredecuenta: document.getElementById("username").value,
        contrasena: document.getElementById("password").value
    };
     
    console.log(datosusuario);

    const opciones = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datosusuario),
    };

    fetch(url, opciones)
    .then(response => {
        if (!response.ok) {
            if (response.status === 403) {
                throw new Error('Acceso denegado. Verifique sus credenciales.');
            } else {
                throw new Error('Problema al comunicarse con el servidor, código de estado: ' + response.status);
            }
        }
        return response.json();
    })
    .then(data => {
        if (data.token) {
            console.log("Respuesta del servidor:", data);
            localStorage.setItem('authToken', data.token);
            window.location.href = './restaurantesList.html';
        } else {
            throw new Error('No se recibió el token esperado.');
        }
    })
    .catch(error => {
        console.error("Error al enviar los datos:", error);
        alert(error.message); // Muestra un mensaje de error
    });
});