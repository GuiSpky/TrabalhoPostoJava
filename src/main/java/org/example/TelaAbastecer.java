package org.example;

import org.example.historico.TelaHistorioco;

import javax.swing.*;
import java.awt.*;

public class TelaAbastecer extends JFrame {

    JButton botaoGasolina;
    JButton botaoEtanol;
    JButton botaoDiesel;
    public TelaAbastecer(){
        setTitle("Posto UniAlfa");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);

        JLabel labelNome1 = new JLabel("Escolha o tipo de Combustivel:");
        constraints.gridx = 1;
        constraints.gridy = 0;
        painel.add(labelNome1, constraints);


        botaoGasolina = new JButton("Gasolina");
        botaoGasolina.addActionListener(e -> gasolina());
        constraints.gridx = 0;
        constraints.gridy = 2;
        painel.add(botaoGasolina,constraints);

        botaoEtanol = new JButton("Etanol");
        botaoEtanol.addActionListener(e -> etanol());
        constraints.gridx = 1;
        constraints.gridy = 2;
        painel.add(botaoEtanol,constraints);

        botaoDiesel = new JButton("Diesel");
        botaoDiesel.addActionListener(e -> diesel());
        constraints.gridx = 2;
        constraints.gridy = 2;
        painel.add(botaoDiesel,constraints);

        botaoDiesel = new JButton("Histórico");
        botaoDiesel.addActionListener(e -> historico());
        constraints.gridx = 0;
        constraints.gridy = 3;
        painel.add(botaoDiesel,constraints);



        add(painel);
        setLocationRelativeTo(null);
    }
    private void historico() {
        this.dispose();
        TelaHistorioco form2 = new TelaHistorioco();
        form2.setVisible(true);
    }
    private void gasolina() {
        this.dispose();
        TelaGasolina form2 = new TelaGasolina();
        form2.setVisible(true);
    }
    private void etanol() {
        this.dispose();
        TelaEtanol form2 = new TelaEtanol();
        form2.setVisible(true);
    }
    private void diesel() {
        this.dispose();
        TelaDiesel form2 = new TelaDiesel();
        form2.setVisible(true);
    }
}
