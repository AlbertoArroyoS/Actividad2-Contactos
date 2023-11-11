package vista;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Define los colores del degradado
        Color color1 = new Color(0, 0, 0); // Color inicial
        Color color2 = new Color(128, 128, 128); // Color final

        // Crea un degradado vertical desde la parte superior hasta la inferior
        GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);

        // Establece el degradado en el contexto gráfico
        g2d.setPaint(gradient);

        // Rellena el fondo con el degradado
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}