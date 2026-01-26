describe('Cart Test', () => {
  beforeEach(() => {
    cy.visit('https://www.saucedemo.com');
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
    cy.url().should('include', '/inventory.html');
  });

  it('Should add a product to the cart', () => {
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');
  });

  it('Should sort products by price low to high', () => {
    cy.get('.product_sort_container').select('lohi');
    cy.get('.inventory_item_price').first().should('have.text', '$7.99');
  });

  // ✅ KỊCH BẢN MỚI: Xóa sản phẩm khỏi giỏ hàng
  it('Should remove product from cart and badge disappears', () => {
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');

    // Nút Add to cart sẽ đổi thành Remove ngay trên trang inventory
    cy.get('.inventory_item').first().find('.btn_inventory').click();

    // Badge biến mất (không hiển thị số lượng)
    cy.get('.shopping_cart_badge').should('not.exist');
  });

  // ✅ KỊCH BẢN MỚI: Quy trình checkout tới step two
  it('Should checkout and navigate to checkout-step-two', () => {
    // Add 1 item
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');

    // Go to cart
    cy.get('.shopping_cart_link').click();
    cy.url().should('include', '/cart.html');

    // Checkout step one
    cy.get('#checkout').click();
    cy.url().should('include', '/checkout-step-one.html');

    // Fill info
    cy.get('#first-name').type('John');
    cy.get('#last-name').type('Doe');
    cy.get('#postal-code').type('12345');

    // Continue to step two
    cy.get('#continue').click();
    cy.url().should('include', '/checkout-step-two.html');
  });
});
