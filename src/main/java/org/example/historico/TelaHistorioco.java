package org.example.historico;

import org.example.TelaGasolina;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TelaHistorioco extends JFrame {

    JButton botaoGasolina;
    JButton botaoDiesel;
    JButton botaoEtanol;

    public TelaHistorioco() {
        setTitle("Histórico");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelNome1 = new JLabel("Escolha o histórico:");
        constraints.gridx = 1;
        constraints.gridy = 0;
        painel.add(labelNome1, constraints);

        botaoGasolina = new JButton("Gasolina");
        botaoGasolina.addActionListener(e -> HistGasolina());
        constraints.gridx = 0;
        constraints.gridy = 2;
        painel.add(botaoGasolina, constraints);

        botaoEtanol = new JButton("Etanol");
        botaoEtanol.addActionListener(e -> HistEtanol());
        constraints.gridx = 1;
        constraints.gridy = 2;
        painel.add(botaoEtanol, constraints);

        botaoDiesel = new JButton("Diesel");
        botaoDiesel.addActionListener(e -> HistDiesel());
        constraints.gridx = 2;
        constraints.gridy = 2;
        painel.add(botaoDiesel, constraints);



        add(painel);
        setLocationRelativeTo(null);
    }
    private void HistGasolina() {
        var diretorioProjeto = System.getProperty("user.dir");
        var nomeArquivo = "\\HistoricoGasolina.txt";
        var arquivo = new File(diretorioProjeto, nomeArquivo);

        readerHistorico(arquivo.toString());
    }

    private void HistEtanol() {
        var diretorioProjeto = System.getProperty("user.dir");
        var nomeArquivo = "\\HistoricoEtanol.txt";
        var arquivo = new File(diretorioProjeto, nomeArquivo);

        readerHistorico(arquivo.toString());
    }

    private void HistDiesel() {
        var diretorioProjeto = System.getProperty("user.dir");
        var nomeArquivo = "\\HistoricoDiesel.txt";
        var arquivo = new File(diretorioProjeto, nomeArquivo);

        readerHistorico(arquivo.toString());
    }
    private void readerHistorico(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
