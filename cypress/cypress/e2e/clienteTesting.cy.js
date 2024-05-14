describe('Prueba de inicio de sesión', () => {
    beforeEach(() => {
      cy.visit("http://127.0.0.1:5500/inicioS.html");
    });
  
    it('Iniciar sesión con credenciales válidas', () => {
    
      cy.get('#username').type('Lau06');
      cy.get('#password').type('123456');
      cy.get('#loginForm').submit();
  
      cy.url().should('include', '/clientes.html');
      cy.get("#hacerReserva").click();
      cy.url().should('include', '/reserva.html');
      cy.get("#volver").click();
      cy.url().should('include', '/clientes.html');
      cy.get("#verReservas").click({timeout: 15000});
      cy.url().should('include', '/misReservas.html');
      cy.get("#salirMisreservas").click();
      cy.url().should('include', '/clientes.html');
      cy.get("#ayudaCliente").click();
      cy.url().should('include', '/pqr.html');

    });

});