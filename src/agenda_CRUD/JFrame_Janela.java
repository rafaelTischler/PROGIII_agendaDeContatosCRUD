package agenda_CRUD;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame_Janela extends JFrame {

	private static final long serialVersionUID = 1L;

	static JFrame_Janela frame;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu menuContato = new JMenu("Contato");
	private final JMenuItem itemCadastrar = new JMenuItem("Cadastrar");
	private final JMenuItem itemConsultar = new JMenuItem("Consultar");
	private final JMenuItem itemAlterar = new JMenuItem("Alterar");
	private final JMenuItem itemRemover = new JMenuItem("Remover");
	private final JMenu menuAjuda = new JMenu("Ajuda");
	private final JMenuItem itemSobre = new JMenuItem("Sobre");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					frame = new JFrame_Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame_Janela() {
		initComponents();
		this.setContentPane(new MenuPrincipal());
	}

	private void initComponents() {
		setResizable(false);
		setTitle("Rafael Tischler ADS 19 - Agenda de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		setJMenuBar(this.menuBar);
		this.menuContato.setForeground(Color.DARK_GRAY);
		this.menuContato.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.menuBar.add(this.menuContato);
		this.itemCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro();
			}
		});
		this.itemCadastrar.setForeground(Color.DARK_GRAY);
		this.itemCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.menuContato.add(this.itemCadastrar);
		this.itemConsultar.setForeground(Color.DARK_GRAY);
		this.menuContato.add(this.itemConsultar);
		this.menuContato.add(this.itemAlterar);
		this.menuContato.add(this.itemRemover);
		this.menuBar.add(this.menuAjuda);
		this.menuAjuda.add(this.itemSobre);
		this.itemSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	protected void abrirTelaCadastro() {
		this.setContentPane(new TelaCadastro());
		this.setVisible(true);
	}
}
