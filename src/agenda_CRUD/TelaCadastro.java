package agenda_CRUD;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class TelaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel txtTelaCad = new JLabel("TelaCadastro");
	private final JButton btnVoltar = new JButton("Voltar");
	private final JLabel txtNome = new JLabel("Nome: ");
	private final JTextField edit_nomeCad = new JTextField();
	private final JLabel txtEmail = new JLabel("Email: ");
	private final JTextField edit_emailCad = new JTextField();
	private final JLabel txtCell = new JLabel("Telefone: ");
	private final JTextField edit_cellCad = new JTextField();
	private final JLabel txtTipo = new JLabel("Tipo: ");
	private final JRadioButton rdbtn_pessoal = new JRadioButton("Pessoal");
	private final JRadioButton rdbtn_profissional = new JRadioButton("Profissional");
	private final ButtonGroup btngrp_tipoContato = new ButtonGroup();
	private final JButton btnCadastrar = new JButton("Cadastrar");
	Arquivo arquivo = new Arquivo("agenda");

	public TelaCadastro() {
		this.edit_cellCad.setBackground(new Color(255, 250, 200));
		this.edit_cellCad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.edit_cellCad.setColumns(10);
		this.edit_emailCad.setBackground(new Color(255, 250, 200));
		this.edit_emailCad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.edit_emailCad.setColumns(10);
		this.edit_nomeCad.setBackground(new Color(255, 250, 200));
		this.edit_nomeCad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.edit_nomeCad.setColumns(10);
		initComponents();
	}

	private void initComponents() {
		setBounds(100, 100, 640, 480);
		setBackground(new Color(129, 178, 154));
		setLayout(new MigLayout("", "[grow][196px][grow]", "[grow][92px][grow]"));
		this.panel.setBackground(new Color(61, 64, 91));
		add(this.panel, "cell 1 1,alignx left,aligny top");
		this.panel.setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][][]"));
		this.txtTelaCad.setForeground(Color.WHITE);
		this.txtTelaCad.setFont(new Font("Segoe UI", Font.BOLD, 16));
		this.panel.add(this.txtTelaCad, "cell 1 1 2 1,alignx left,aligny top");
		this.txtNome.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.txtNome.setForeground(Color.WHITE);
		this.panel.add(this.txtNome, "cell 1 3,alignx right,aligny center");
		this.panel.add(this.edit_nomeCad, "cell 2 3 2 1,growx,aligny center");
		this.txtEmail.setForeground(Color.WHITE);
		this.txtEmail.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.panel.add(this.txtEmail, "cell 1 4,alignx right,aligny center");
		this.panel.add(this.edit_emailCad, "cell 2 4 2 1,growx");
		this.txtCell.setForeground(Color.WHITE);
		this.txtCell.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.panel.add(this.txtCell, "cell 1 5,alignx right,aligny center");
		this.panel.add(this.edit_cellCad, "cell 2 5 2 1,growx");
		this.txtTipo.setForeground(Color.WHITE);
		this.txtTipo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.panel.add(this.txtTipo, "cell 1 6,alignx right,aligny center");
		this.btngrp_tipoContato.add(this.rdbtn_pessoal);
		this.rdbtn_pessoal.setSelected(true);
		this.rdbtn_pessoal.setOpaque(false);
		this.rdbtn_pessoal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.rdbtn_pessoal.setForeground(Color.WHITE);
		this.panel.add(this.rdbtn_pessoal, "flowx,cell 2 6");
		this.btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirMenuPrincipal();
			}
		});
		this.btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnVoltar, "flowx,cell 2 8,alignx right,aligny center");
		this.btngrp_tipoContato.add(this.rdbtn_profissional);
		this.rdbtn_profissional.setOpaque(false);
		this.rdbtn_profissional.setForeground(Color.WHITE);
		this.rdbtn_profissional.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.rdbtn_profissional, "cell 2 6");
		this.btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarContato();
			}
		});
		this.btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnCadastrar, "cell 3 8,alignx right,aligny center");
	}

	protected void abrirMenuPrincipal() {
		JFrame_Janela.frame.setContentPane(new MenuPrincipal());
		JFrame_Janela.frame.setVisible(true);
	}

	private void salvarContato() {
		String nome = edit_nomeCad.getText();
		String email = edit_emailCad.getText();
		String celular = edit_cellCad.getText();
		String tipo = "";
		if (rdbtn_pessoal.isSelected()) {
			tipo = "Pessoal";
		} else if (rdbtn_profissional.isSelected()) {
			tipo = "Profissional";
		}

		if (!nome.isEmpty() && !email.isEmpty() && !celular.isEmpty()) {
			Contato novoContato = new Contato(nome, email, celular, tipo);
			arquivo.gravarContato(novoContato);
			JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
			edit_nomeCad.setText("");
			edit_emailCad.setText("");
			edit_cellCad.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
		}

	}

}
