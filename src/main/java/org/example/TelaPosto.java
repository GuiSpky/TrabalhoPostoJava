package org.example;

import javax.swing.*;
import java.awt.*;

public class TelaPosto extends JFrame {

    private JTextField campoValor1;
    private JButton botaoSalvar;


    public TelaPosto() {
        setTitle("Posto UniAlfa");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);

        JLabel labelNome1 = new JLabel("Bem Vindo ao Posto Unialfa");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painel.add(labelNome1, constraints);

        botaoSalvar = new JButton("Continuar");
        botaoSalvar.addActionListener(e -> salvar() );
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(botaoSalvar,constraints);

        add(painel);
        setLocationRelativeTo(null);
    }


    private void salvar() {
        this.dispose();
        TelaAbastecer form2 = new TelaAbastecer();
        form2.setVisible(true);
    }
}
