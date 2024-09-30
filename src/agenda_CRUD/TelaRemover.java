package agenda_CRUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class TelaRemover extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel txtTelaRemover = new JLabel("TelaRemover");
	private final JLabel txtBusca = new JLabel("Nome: ");
	private final JTextField edit_nomeAlterar = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnBuscar = new JButton("Buscar");
	private final JTable tb_remover = new JTable();
	private final JButton btnVoltar = new JButton("Voltar");
	private final JButton btnRemover = new JButton("Remover");

	public TelaRemover() {
		this.edit_nomeAlterar.setBackground(new Color(255, 250, 200));
		this.edit_nomeAlterar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.edit_nomeAlterar.setColumns(10);
		initComponents();
	}

	private void initComponents() {
		setBounds(100, 100, 640, 480);
		setBackground(new Color(129, 178, 154));
		setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow]"));
		this.panel.setBackground(new Color(61, 64, 91));
		add(this.panel, "cell 1 1,grow");
		this.panel.setLayout(new MigLayout("", "[][][grow,left][][]", "[][][][][][grow][][][grow]"));
		this.txtTelaRemover.setForeground(Color.WHITE);
		this.txtTelaRemover.setFont(new Font("Segoe UI", Font.BOLD, 16));
		this.panel.add(this.txtTelaRemover, "flowy,cell 1 1 2 1");
		this.txtBusca.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.txtBusca.setForeground(Color.WHITE);
		this.panel.add(this.txtBusca, "cell 1 3,alignx right");
		this.panel.add(this.edit_nomeAlterar, "cell 2 3,growx,aligny center");
		this.btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnBuscar, "cell 3 3,growx,aligny center");
		this.panel.add(this.scrollPane, "cell 1 5 3 1,grow");
		this.tb_remover.setBackground(new Color(255, 250, 200));
		this.tb_remover.setForeground(Color.BLACK);
		this.tb_remover.setColumnSelectionAllowed(true);
		this.tb_remover.setRowSelectionAllowed(true);
		this.tb_remover.getTableHeader().setReorderingAllowed(false);
		this.tb_remover.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nome:", "E-mail:", "Telefone:", "Tipo:" }) {
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		this.tb_remover.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.tb_remover.getColumnModel().getColumn(0).setResizable(false);
		this.tb_remover.getColumnModel().getColumn(1).setResizable(false);
		this.tb_remover.getColumnModel().getColumn(2).setResizable(false);
		this.scrollPane.setViewportView(this.tb_remover);
		this.btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirMenuPrincipal();
			}
		});
		this.btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnVoltar, "cell 2 7,alignx right,aligny center");
		this.btnRemover.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnRemover, "cell 3 7");
	}

	protected void abrirMenuPrincipal() {
		JFrame_Janela.frame.setContentPane(new MenuPrincipal());
		JFrame_Janela.frame.setVisible(true);
	}

}
