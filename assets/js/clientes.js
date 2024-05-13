function cargarInformacionUsuario(nombreDeCuenta) {
    const url = `http://localhost:8080/usuario/detalles/${nombreDeCuenta}`;
    const authToken = localStorage.getItem('authToken');
    if (!authToken) {
        console.error('Authentication token is missing.');
        return;
    }

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

    document.getElementById("hacerReserva").addEventListener("click", function () {
        window.location.href = "reserva.html"; 
    });

    document.getElementById("verReservas").addEventListener("click", function () {
        window.location.href = "misReservas.html"; 
    });

    document.getElementById("ayuda").addEventListener("click", function () {
        window.location.href = "ayuda.html";
    });

    document.getElementById("salir").addEventListener("click", function () {
        window.location.href = "index.html"; 
    });
});