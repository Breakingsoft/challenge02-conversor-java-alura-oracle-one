// Programa principal
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App extends JFrame {

    private static final long serialVersionUID = 949744218770101004L;

	public static void main(String[] args) throws Exception {

        UnitsList[] units = UnitsList.values();
        MoneyExchange[] money = MoneyExchange.values();
        String[] moneyName = new String[money.length];
        String[] unit = new String[units.length];

        for (int i = 0; i < money.length; i++) {
            moneyName[i] = money[i].getName();
        }
        for (int i = 0; i < units.length; i++) {
            unit[i] = units[i].getName();
        }
        
        JFrame ventanaPrincipal = new JFrame();
        JPanel principalPanel = new JPanel();
        JPanel selectionPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JButton buttonSeleccionar = new JButton("Seleccionar");
        JButton buttonCancelar = new JButton("Salir");
        JComboBox<String> comboBox = new JComboBox<String>(
                new String[] { "Conversor de temperatura", "Tipo de cambio" });
        
        selectionPanel.setPreferredSize(new Dimension(300, 60));
        selectionPanel.add(new JLabel("Seleccione tipo de conversión"));
        selectionPanel.add(comboBox);
        buttonsPanel.add(buttonSeleccionar);
        buttonsPanel.add(buttonCancelar);

        principalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 0));
        principalPanel.setPreferredSize(new Dimension(350, 110));
        principalPanel.add(selectionPanel);
        principalPanel.add(buttonsPanel);

        ventanaPrincipal.add(principalPanel);

        ventanaPrincipal.setTitle("Calculadora conversora");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(350, 140);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setVisible(true);

        buttonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) comboBox.getSelectedItem();
                if (opcionSeleccionada.equals("Conversor de temperatura")) {
                    MainConverter convertidorDeTemperatura = new MainConverter(ventanaPrincipal,
                            "Conversor de temperatura", "Conversor de temperatura", unit, unit);
                    convertidorDeTemperatura.setVisible(true);
                } else if (opcionSeleccionada.equals("Tipo de cambio")) {
                    MainConverter moneyConverter = new MainConverter(ventanaPrincipal, "Tipo de cambio",
                            "Ingrese monto:", moneyName, moneyName);
                    moneyConverter.setVisible(true);

                }
                ventanaPrincipal.setVisible(false);
            }
        });

      // Closing the window.
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();
            }
        });
    }
}