describe('Prueba de inicio de sesión', () => {
    beforeEach(() => {
      cy.visit("http://127.0.0.1:5500/inicioS.html");
    });
  
    it('Iniciar sesión con credenciales válidas', () => {
    
      cy.get('#username').type('DavidO');
      cy.get('#password').type('prueba123');
      cy.get('#loginForm').submit();
  
      cy.url().should('include', '/clientes.html');

    });

    it('Iniciar sesión con credenciales incorrectas', () => {
    
      cy.get('#username').type('Sofia483');
      cy.get('#password').type('prueba183');
      cy.get('#loginForm').submit();
      
      cy.get('body').then(($body) => {
        if ($body.find('.mensaje-error').length > 0) {
            throw new Error('Acceso denegado. Verifique sus credenciales.');
        }
    });
    });
    

  });