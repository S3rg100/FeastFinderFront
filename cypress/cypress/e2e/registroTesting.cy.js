describe('Registro de Usuario', () => {
  it('Registrar un nuevo usuario', () => {
      cy.visit('http://127.0.0.1:5500/registro.html');
      cy.get('#nombre').type('NombreUsuario');
      cy.get('#apellido').type('ApellidoUsuario');
      cy.get('#correoElectronico').type('correo10@example.com');
      cy.get('#nombredecuenta').type('usuarioNuevo8');
      cy.get('#contrasena').type('contraseña127');
      cy.get('#registroForm').submit();

      // Esperar a que se complete la respuesta del servidor
      cy.wait(2000); 
      // Esperar a que se redirija a la página de inicio de sesión
      cy.url().should('include', '/inicioS.html');

  });
});
