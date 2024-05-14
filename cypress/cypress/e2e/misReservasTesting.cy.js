describe('Pruebas de inicio de sesión y reservas', () => {
    it('Inicia sesión y verifica las reservas', () => {
        cy.visit('http://127.0.0.1:5500/inicioS.html'); 
        
        cy.get('#username').type('DavidO');
        cy.get('#password').type('prueba123');
        cy.get('#loginForm').submit();
    
        cy.url().should('include', '/clientes.html');
  
        // Busca el enlace "Ver Reservas" y hace clic en él
        cy.get('#verReservas').click();

        // Verifica que se muestren las reservas después de hacer clic en "Ver Reservas"
        cy.get('#detallesReservas').should('not.be.empty');
    });
});