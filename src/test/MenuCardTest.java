import org.junit.*;

import main.model.MenuCard;

import javax.swing.*;

class MenuCardTest {

    @Test
    void testMenuCardCreation() {
        MenuCard card = new MenuCard("Desayuno", "2023-01-01", "08:00-10:00", 
                                   "Pan, café, fruta", 50);
        
        assertNotNull(card);
        assertEquals(300, card.getPreferredSize().width);
        assertEquals(350, card.getPreferredSize().height);
    }

    @Test
    void testFormatDescription() {
        MenuCard card = new MenuCard("", "", "", "", 0);
        
        String input = "Pan, café, fruta";
        String expected = "Pan<br> café<br> fruta";
        assertEquals(expected, card.formatDescription(input));
    }
}
