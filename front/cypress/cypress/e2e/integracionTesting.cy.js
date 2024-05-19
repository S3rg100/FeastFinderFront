describe("Pruebas de integración", () => {
  it("Iniciar sesión y realizar reserva", () => {
    cy.visit("http://127.0.0.1:5500/inicioS.html");
    cy.get("#username").type("DavidO");
    cy.get("#password").type("prueba123");
    cy.get("#loginForm").submit();

    cy.url().should("include", "/clientes.html");

    cy.get("#hacerReserva").click();
    cy.url().should("include", "/reserva.html");

    cy.get("#ciudades").select(2).should('have.value', 'Medellin');
    cy.wait(10000); // Espera explícita para asegurar que todos los procesos asíncronos se completen
    cy.get("#restaurantes").select(0).should('have.value', '4');
    cy.get("#fecha").type("2024-05-15");
    cy.get("#hora").type("18:00");
    cy.get("#recomendacion").type("Sin pimientos");

    cy.wait(500);
    cy.get("#enviar").click();

    // Opcionalmente, esperar un momento antes de proceder si es necesario
    cy.wait(500); // Espera 500 ms si es necesario para la actualización del DOM

    cy.get("#volver").click();

    cy.wait(10000);
    cy.get("#verReservas").click();
    cy.url().should("include", "/misReservas.html");

    // Verificar que la reserva creada esté presente en la página de Mis Reservas
    cy.contains(".reserva", "Cantina la 15");
  });
});
