package agenda_CRUD;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class JFrame_Janela extends JFrame {

	private static final long serialVersionUID = 1L;

	static JFrame_Janela frame;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu menuContato = new JMenu("Opções");
	private final JMenuItem itemCadastrar = new JMenuItem("Cadastrar contato");
	private final JMenuItem itemConsultar = new JMenuItem("Consultar contato");
	private final JMenuItem itemAlterar = new JMenuItem("Alterar contato");
	private final JMenuItem itemRemover = new JMenuItem("Remover contato");
	private final JMenu menuAjuda = new JMenu("Ajuda");
	private final JMenuItem itemSobre = new JMenuItem("Sobre");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
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
		setBounds(100, 100, 800, 600);
		setJMenuBar(this.menuBar);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrame_Janela.class.getResource("/agenda_CRUD/telephone.png")));
		this.menuContato.setForeground(Color.BLACK);
		this.menuContato.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.menuBar.add(this.menuContato);
		this.itemCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro();
			}
		});
		this.itemCadastrar.setForeground(Color.BLACK);
		this.itemCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.menuContato.add(this.itemCadastrar);
		this.itemConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaConsulta();
			}
		});
		this.itemConsultar.setForeground(Color.BLACK);
		this.menuContato.add(this.itemConsultar);
		this.itemAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaAlterar();
			}
		});
		this.itemAlterar.setForeground(Color.BLACK);
		this.menuContato.add(this.itemAlterar);
		this.itemRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaRemover();
			}
		});
		this.itemRemover.setForeground(Color.BLACK);
		this.menuContato.add(this.itemRemover);
		this.menuAjuda.setForeground(Color.BLACK);
		this.menuBar.add(this.menuAjuda);
		this.itemSobre.setForeground(Color.BLACK);
		this.menuAjuda.add(this.itemSobre);
		this.itemSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Trabalho Avaliativo - Agenda de Contatos\n" + "Versão: 1.0\n" + "Desenvolvedor: Rafael Müller Tischler\n"
																																		+ "E-mail: rafaelmullertischler@gmail.com\n", "Sobre",
																																		JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	protected void abrirTelaCadastro() {
		this.setContentPane(new TelaCadastro());
		this.setVisible(true);
	}

	protected void abrirTelaConsulta() {
		this.setContentPane(new TelaConsulta());
		this.setVisible(true);
	}

	protected void abrirTelaAlterar() {
		this.setContentPane(new TelaAlterar());
		this.setVisible(true);
	}

	protected void abrirTelaRemover() {
		this.setContentPane(new TelaRemover());
		this.setVisible(true);
	}
}
