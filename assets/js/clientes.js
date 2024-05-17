function cargarInformacionUsuario(nombreDeCuenta) {
    const url = `http://localhost:8080/usuario/detalles/${nombreDeCuenta}`;
    const authToken = localStorage.getItem('authToken');
    if (!authToken) {
        console.error('Authentication token is missing.');
        return;
    }
    console.log(authToken);
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${authToken}`
        }
    })  
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to fetch user details.');
        }
        return response.json();
    })
    .then(usuario => {
        console.log('Usuario:', usuario);
        localStorage.setItem('usuarioId', usuario.id);
        localStorage.setItem('usuarioNombre', usuario.nombre);
        localStorage.setItem('usuarioApellido', usuario.apellido);
        localStorage.setItem('usuarioCorreoElectronico', usuario.correoElectronico);
        console.log("Este es el id del usuario guardado: " + localStorage.getItem('usuarioId'))
    })
    .catch(error => console.error('Error:', error));
}

document.addEventListener("DOMContentLoaded", function () {
    const nombreDeCuenta = localStorage.getItem('nombredecuenta');
    cargarInformacionUsuario(nombreDeCuenta);

    const hacerReservaBtn = document.getElementById("hacerReserva");
    const verReservasBtn = document.getElementById("verReservas");
    const ayudaBtn = document.getElementById("ayuda");
    const salirBtn = document.getElementById("salir");

    if (hacerReservaBtn) {
        hacerReservaBtn.addEventListener("click", function () {
            window.location.href = "reserva.html"; 
        });
    } else {
        console.error("El botón 'hacerReserva' no existe en el DOM.");
    }

    if (verReservasBtn) {
        verReservasBtn.addEventListener("click", function () {
            window.location.href = "misReservas.html"; 
        });
    } else {
        console.error("El botón 'verReservas' no existe en el DOM.");
    }

    if (ayudaBtn) {
        ayudaBtn.addEventListener("click", function () {
            window.location.href = "ayuda.html";
        });
    } else {
        console.error("El botón 'ayuda' no existe en el DOM.");
    }

    if (salirBtn) {
        salirBtn.addEventListener("click", function () {
            window.location.href = "index.html"; 
        });
    } else {
        console.error("El botón 'salir' no existe en el DOM.");
    }
});