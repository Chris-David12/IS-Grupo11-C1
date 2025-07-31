import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.junit.*;

import main.controller.controlerScanner;

class ControlerScannerTest {

    @Test
    void testCompareImagesWithSameImages() {
        controlerScanner scanner = new controlerScanner();
        BufferedImage img1 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        BufferedImage img2 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        
        // Hacer que las imágenes sean idénticas
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                img1.setRGB(x, y, 0xFF0000); // Rojo
                img2.setRGB(x, y, 0xFF0000); // Rojo
            }
        }
        
        boolean result = scanner.compareImages("test_path", img2, 0);
        assertTrue(result);
    }

    @Test
    void testCompareImagesWithDifferentSizes() {
        controlerScanner scanner = new controlerScanner();
        BufferedImage img1 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        BufferedImage img2 = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
        
        boolean result = scanner.compareImages("test_path", img2, 50);
        assertFalse(result);
    }
}