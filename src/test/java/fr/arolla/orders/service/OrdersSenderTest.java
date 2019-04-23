package fr.arolla.orders.service;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.arolla.orders.util.Drinks;
import fr.arolla.orders.util.Order;

public class OrdersSenderTest {
	
	@Test
	public void testSendOrder() {
		Order orderTeaSugar = new Order(Drinks.TEA,"1", 0.4);
		assertEquals("T:1:0", OrdersSender.sendOrder(orderTeaSugar));
		
		Order orderChocolateNoSugar = new Order(Drinks.CHOCOLATE,"0", 0.5);
		assertEquals("H::", OrdersSender.sendOrder(orderChocolateNoSugar));
		
		Order orderCoffeeSugar = new Order(Drinks.COFFEE,"2", 0.6);
		assertEquals("C:2:0", OrdersSender.sendOrder(orderCoffeeSugar));
		
		assertEquals("M:Preparation in progress..", OrdersSender.forwardMessage("Preparation in progress.."));
	}
	
	@Test
	public void testCheckAmountInserted() {
		Order orderTeaRightPrice = new Order(Drinks.TEA, "0", 0.4);
		assertEquals(0, OrdersSender.checkAmountInserted(orderTeaRightPrice), 0);
	}
}
