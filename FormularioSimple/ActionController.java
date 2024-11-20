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
            viewPaintFrame.nameError.setText("Este campo es obligatorio");
        }else{
            viewPaintFrame.nameError.setText("");
        }
        if (!viewPaintFrame.emailField.getText().matches(regex)) {
            viewPaintFrame.emailError.setText("Email no reconocido");
        }else{
            viewPaintFrame.emailError.setText("");
        }
        if (viewPaintFrame.passField.getText().length()<8) {
            viewPaintFrame.passError.setText("La contraseña debe de tener al menos 8 caracteres");
        }else{
            viewPaintFrame.passError.setText("");
        }

        if (viewPaintFrame.nameField.getText().length()!=0 &&
            viewPaintFrame.emailField.getText().matches(regex) &&
            viewPaintFrame.passField.getText().length()>=8
            ) {
            
            JOptionPane.showMessageDialog(null, "Formulario enviado con éxito ");
            viewPaintFrame.nameField.setText("");
            viewPaintFrame.emailField.setText("");
            viewPaintFrame.passField.setText("");
        }

        viewPaintFrame.pack();
    }
}
