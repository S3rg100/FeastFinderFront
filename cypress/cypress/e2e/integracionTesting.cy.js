describe('Pruebas de integración', () => {
    it('Iniciar sesión y realizar reserva', () => {
      cy.visit('http://127.0.0.1:5500/inicioS.html'); 
      cy.get('#username').type('DavidO');
      cy.get('#password').type('prueba123');
      cy.get('#loginForm').submit();
  
      cy.url().should('include', '/clientes.html');
  
      cy.get('#hacerReserva').click();
      cy.url().should('include', '/reserva.html');
  
      // Realizar operaciones en la página de reserva
      cy.get('#ciudades').select('Bogota');
      cy.get('#restaurantes').select('Cantina la 15');
      cy.get('#fecha').type('2024-05-15');
      cy.get('#hora').type('18:00');
      cy.get('#recomendacion').type('Sin pimientos');
  
      cy.get('#enviar').click();
      cy.contains('Reserva realizada con éxito');
  
      cy.get('#verReservas').click();
      cy.url().should('include', '/misReservas.html');
  
      // Verificar que la reserva creada esté presente en la página de Mis Reservas
      cy.contains('.reserva', 'Cantina la 15');
    });
  
  });