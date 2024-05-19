describe('Pruebas de inicio de sesión y reservas', () => {
    it('Inicia sesión y verifica las reservas', () => {
        cy.visit('http://127.0.0.1:5500/inicioS.html'); 
        
        cy.get('#username').type('DavidO');
        cy.get('#password').type('prueba123');
        cy.get('#loginForm').submit();
    
        cy.url().should('include', '/clientes.html');
        
        cy.wait(4000); 
        cy.get('#verReservas').click();
        
        cy.get('#detallesReservas').should('not.be.empty');
    });
});