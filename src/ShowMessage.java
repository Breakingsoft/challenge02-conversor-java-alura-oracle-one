// Muestra los mensajes
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowMessage extends JFrame {
	
    private static final long serialVersionUID = -4396775850707575033L;

	public ShowMessage(MainConverter converter, String title, String message) {
    	
        JFrame frame = new JFrame(title);
        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);
        JButton button = new JButton("Ok");

        panel.setLayout(new FlowLayout(FlowLayout. CENTER, 300, 0));
        panel.add(new Interface());
        panel.add(label);
        panel.add(new Interface());
        panel.add(button);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 140);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        converter.setEnabled(false);;
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                converter.setEnabled(true);
                ShowMessage.this.dispose();
            }
        }
        );
    
    }
    
}