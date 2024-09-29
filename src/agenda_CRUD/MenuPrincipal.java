package agenda_CRUD;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Menu Principal");
	private final JButton btn_cadastrar = new JButton("Cadastrar");
	private final JButton btn_consultar = new JButton("Consultar");
	private final JButton btn_alterar = new JButton("Alterar");
	private final JButton btn_remover = new JButton("Remover");
	private final JButton btnNewButton = new JButton("Sair");

	public MenuPrincipal() {
		initComponents();
	}

	private void initComponents() {
		setBounds(100, 100, 640, 480);
		setLayout(new MigLayout("", "[]", "[]"));
		setBackground(new Color(129, 178, 154));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new MigLayout("", "[][150.00][][grow]", "[][grow][]"));
		this.panel.setBackground(new Color(61, 64, 91));
		add(this.panel, "cell 1 1,grow");
		this.panel.setLayout(new MigLayout("", "[][grow][]", "[][][grow][][][][][grow][][]"));
		this.lblNewLabel.setBorder(null);
		this.lblNewLabel.setForeground(new Color(255, 255, 255));
		this.lblNewLabel.setBackground(new Color(255, 255, 255));
		this.lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		this.panel.add(this.lblNewLabel, "cell 1 1,alignx center,aligny center");
		this.btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro();
			}
		});
		this.btn_cadastrar.setBackground(new Color(255, 255, 255));
		this.btn_cadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.btn_consultar.setBackground(new Color(255, 255, 255));
		this.btn_consultar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.btn_alterar.setBackground(new Color(255, 255, 255));
		this.btn_alterar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.btn_remover.setBackground(new Color(255, 255, 255));
		this.btn_remover.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btn_cadastrar, "cell 1 3,growx");
		this.panel.add(this.btn_consultar, "cell 1 4,growx");
		this.panel.add(this.btn_alterar, "cell 1 5,growx");
		this.panel.add(this.btn_remover, "cell 1 6,growx");
		this.btnNewButton.setBackground(new Color(255, 255, 255));
		this.btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnNewButton, "cell 1 8,growx");
	}

	protected void abrirTelaCadastro() {
		JFrame_Janela.frame.setContentPane(new TelaCadastro());
		JFrame_Janela.frame.setVisible(true);
	}
}
