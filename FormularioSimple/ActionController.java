package FormularioSimple;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class ActionController implements ActionListener {
    PaintFrame viewPaintFrame;
    String regex = "([a-z]|[A-Z]|[0-9])+@([a-z]|[0-9])+.(net|es|com|org|info|biz|name|edu|gov)";

    public ActionController(PaintFrame vPaint) {
        viewPaintFrame = vPaint;
    }

    public void eventListener() {
        viewPaintFrame.button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (viewPaintFrame.nameField.getText()!=null &&
            viewPaintFrame.emailFieldField.getText().matches(regex) &&
            viewPaintFrame.passField.getText().length()>=8
            ) {
            
            
        }

     /*    String edad = JOptionPane.showInputDialog("Ingresa tu edad:");
        JOptionPane.showMessageDialog(null, "Tu edad es: " + edad); */
    }
}
