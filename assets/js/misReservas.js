document.addEventListener('DOMContentLoaded', function() {
    const nombredecuenta = localStorage.getItem('nombredecuenta');
    const usuarioID = localStorage.getItem('usuarioId'); 
    const urlReservas = `http://localhost:8080/reserva/usuario/${usuarioID}`;
    const urlRestaurantes = `http://localhost:8080/restaurante`;
    const authToken = localStorage.getItem('authToken');
    
    console.log("nombre de la cuenta" + nombredecuenta);
    console.log(authToken);

    if (!authToken) {
        console.error('No authentication token available. User might not be logged in.');
        document.getElementById('detallesReservas').innerHTML = '<p>Please log in to view reservations.</p>';
        return;
    }

    // Primero obtener las reservas
    fetch(urlReservas, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${authToken}`
        }
    })
    .then(response => response.json())
    .then(async reservas => {
        // Una vez tenemos las reservas, obtenemos los detalles de los restaurantes
        const response = await fetch(urlRestaurantes, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${authToken}`
            }
        });
        const restaurantesData = await response.json();
        const restaurantes = {};
        restaurantesData.forEach(restaurante => {
            restaurantes[restaurante.id] = restaurante;
        });
        // Combinar las reservas con los datos de los restaurantes
        const detallesReservas = reservas.map(reserva => {
            const restaurante_1 = restaurantes[reserva.restauranteID];
            return `
                <div class="reserva">
                    <p class="reserva-id">Reserva ID: ${reserva.id}</p>
                    <p class="reserva-restaurante">Restaurante: ${restaurante_1 ? restaurante_1.nombre : 'No disponible'}</p>
                    <p class="reserva-fecha">Fecha: ${reserva.fecha}</p>
                    <p class="reserva-hora">Hora: ${reserva.hora}</p>
                    <p class="reserva-estado">Estado: ${reserva.estado}</p>
                    <p class="reserva-descripcion">Descripción: ${reserva.descripcion}</p>
                </div>`;
        }).join('');
        document.getElementById('detallesReservas').innerHTML = detallesReservas;
        return reservas;
    })
    .catch(error => {
        console.error('Error fetching data:', error);
        document.getElementById('detallesReservas').innerHTML = '<p>Failed to load data.</p>';
    });
});