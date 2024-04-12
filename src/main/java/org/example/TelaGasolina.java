package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.DEFAULT_OPTION;
import static javax.swing.JOptionPane.showMessageDialog;

public class TelaGasolina extends JFrame {

    JButton botaoAbastecer;
    JButton botaoVoltar;
    JTextField campoValor1;
    double resultado;
    double preco = 5.76;

    public TelaGasolina() {
        setTitle("Bomba 1");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelNome1 = new JLabel("Gasolina esta R$" + preco);
        constraints.gridx = 0;
        constraints.gridy = 0;
        painel.add(labelNome1, constraints);

        JLabel labelNome2 = new JLabel("Quantos litros deseja abastecer?");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(labelNome2, constraints);

        campoValor1 = new JTextField(10);
        constraints.gridx = 0;
        constraints.gridy = 2;
        painel.add(campoValor1, constraints);

        botaoAbastecer = new JButton("Abastecer");
        botaoAbastecer.addActionListener(e -> abastecer());
        constraints.gridx = 0;
        constraints.gridy = 3;
        painel.add(botaoAbastecer, constraints);

        botaoVoltar = new JButton("Menu");
        botaoVoltar.addActionListener(e -> voltar());
        constraints.gridx = 0;
        constraints.gridy = 4;
        painel.add(botaoVoltar, constraints);

        add(painel);
        setLocationRelativeTo(null);
    }

    private void voltar() {
        this.dispose();
        TelaAbastecer form2 = new TelaAbastecer();
        form2.setVisible(true);
    }

    private void validar() {
        if (campoValor1.getText().isEmpty()) throw new NumberFormatException("Insira um valor!");

        var numero = Double.parseDouble(campoValor1.getText());
    }

    private void abastecer() {
        try {
            validar();
            double valor1 = Double.parseDouble(campoValor1.getText());
            resultado = valor1 * preco;
            String result = String.format("%.2f", resultado);
            String resString = resultado + "";
            salvarResultado(campoValor1.getText(), resString);

            int i = JOptionPane.showConfirmDialog(this, "Pronto! fica um total de R$" + result + ". Abastecido " + valor1 + "L de gasolina.",
                    "Abastecido", DEFAULT_OPTION);

            if (i == 0) {
                this.dispose();
                TelaAbastecer form2 = new TelaAbastecer();
                form2.setVisible(true);
            }
        } catch (NumberFormatException e) { //valida se o campo contem apenas numeros
            showMessageDialog(this,
                    "Valor a abastecer deve ser numerico");
        } catch (RuntimeException re) { //valida se o campo esta vazio
            showMessageDialog(this,
                    re.getMessage());
        }
    }

    private void salvarResultado(String litros, String valor) {
        var diretorioProjeto = System.getProperty("user.dir");
        var nomeArquivo = "\\HistoricoGasolina.txt";
        var arquivo = new File(diretorioProjeto, nomeArquivo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.newLine();
            writer.write("Foi abastecido R$"+valor+" equivalente a "+litros+"L.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}






