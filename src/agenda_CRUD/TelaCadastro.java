package agenda_CRUD;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
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
	private final JLabel lblNewLabel = new JLabel("TelaCadastro");
	private final JButton btnVoltar = new JButton("Voltar");
	private final JLabel lblNewLabel_1 = new JLabel("Nome: ");
	private final JTextField edit_nomeCad = new JTextField();
	private final JLabel lblNewLabel_2 = new JLabel("Email: ");
	private final JTextField edit_emailCad = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("Telefone: ");
	private final JTextField edit_cellCad = new JTextField();
	private final JLabel lblNewLabel_4 = new JLabel("Tipo: ");
	private final JRadioButton rdbtn_pessoal = new JRadioButton("Pessoal");
	private final JRadioButton rdbtn_profissional = new JRadioButton("Profissional");
	private final ButtonGroup btngrp_tipoContato = new ButtonGroup();
	private final JButton btnCadastrar = new JButton("Cadastrar");

	public TelaCadastro() {
		this.edit_cellCad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.edit_cellCad.setColumns(10);
		this.edit_emailCad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.edit_emailCad.setColumns(10);
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
		this.lblNewLabel.setForeground(Color.WHITE);
		this.lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		this.panel.add(this.lblNewLabel, "cell 1 1 2 1,alignx left,aligny top");
		this.lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.lblNewLabel_1.setForeground(Color.WHITE);
		this.panel.add(this.lblNewLabel_1, "cell 1 3,alignx right,aligny center");
		this.panel.add(this.edit_nomeCad, "cell 2 3 2 1,growx,aligny center");
		this.lblNewLabel_2.setForeground(Color.WHITE);
		this.lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.panel.add(this.lblNewLabel_2, "cell 1 4,alignx right,aligny center");
		this.panel.add(this.edit_emailCad, "cell 2 4 2 1,growx");
		this.lblNewLabel_3.setForeground(Color.WHITE);
		this.lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.panel.add(this.lblNewLabel_3, "cell 1 5,alignx right,aligny center");
		this.panel.add(this.edit_cellCad, "cell 2 5 2 1,growx");
		this.lblNewLabel_4.setForeground(Color.WHITE);
		this.lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.panel.add(this.lblNewLabel_4, "cell 1 6,alignx right,aligny center");
		this.btngrp_tipoContato.add(this.rdbtn_pessoal);
		this.rdbtn_pessoal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.rdbtn_pessoal.setForeground(Color.WHITE);
		this.rdbtn_pessoal.setOpaque(false);
		this.panel.add(this.rdbtn_pessoal, "flowx,cell 2 6");
		this.btnVoltar.setOpaque(false);
		this.btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirMenuPrincipal();
			}
		});
		this.btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnVoltar, "flowx,cell 2 8,alignx right,aligny center");
		this.btngrp_tipoContato.add(this.rdbtn_profissional);
		this.rdbtn_profissional.setForeground(Color.WHITE);
		this.rdbtn_profissional.setOpaque(false);
		this.rdbtn_profissional.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.rdbtn_profissional, "cell 2 6");
		this.btnCadastrar.setOpaque(false);
		this.btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnCadastrar, "cell 3 8,alignx right,aligny center");
	}

	protected void abrirMenuPrincipal() {
		JFrame_Janela.frame.setContentPane(new MenuPrincipal());
		JFrame_Janela.frame.setVisible(true);
	}

}
