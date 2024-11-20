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
        if (viewPaintFrame.nameField.getText().length()==0) {
            viewPaintFrame.nameError.setVisible(true);
        }else{
            viewPaintFrame.nameError.setVisible(false);
        }
        if (!viewPaintFrame.emailField.getText().matches(regex)) {
            viewPaintFrame.emailError.setVisible(true);
        }else{
            viewPaintFrame.emailError.setVisible(false);
        }
        if (viewPaintFrame.passField.getText().length()<8) {
            viewPaintFrame.passError.setVisible(true);
        }else{
            viewPaintFrame.passError.setVisible(false);
        }

        if (viewPaintFrame.nameField.getText().length()!=0 &&
            viewPaintFrame.emailField.getText().matches(regex) &&
            viewPaintFrame.passField.getText().length()>=8
            ) {
            
            JOptionPane.showMessageDialog(null, "Formulario enviado con éxito ");
            viewPaintFrame.nameField.setVisible(false);
            viewPaintFrame.emailField.setVisible(false);
            viewPaintFrame.passField.setVisible(false);
        }

        viewPaintFrame.pack();
    }
}
