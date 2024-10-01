package agenda_CRUD;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class TelaConsulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel txtTelaCons = new JLabel("TelaConsulta");
	private final JLabel txtBusca = new JLabel("Nome: ");
	private final JTextField edit_nomeConsulta = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnBuscar = new JButton("Buscar");
	private final JTable tb_consulta = new JTable();
	private final JButton btnVoltar = new JButton("Voltar");
	private LinkedList<Contato> contatos;

	public TelaConsulta() {
		this.edit_nomeConsulta.setBackground(new Color(255, 250, 200));
		this.edit_nomeConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.edit_nomeConsulta.setColumns(10);
		initComponents();
		contatos = carregarArquivo();
		preencherTabela();
	}

	private void initComponents() {
		setBounds(100, 100, 640, 480);
		setBackground(new Color(129, 178, 154));
		setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow]"));
		this.panel.setBackground(new Color(61, 64, 91));
		add(this.panel, "cell 1 1,grow");
		this.panel.setLayout(new MigLayout("", "[][][grow,fill][][]", "[][][][][][grow][][][grow]"));
		this.txtTelaCons.setForeground(Color.WHITE);
		this.txtTelaCons.setFont(new Font("Segoe UI", Font.BOLD, 16));
		this.panel.add(this.txtTelaCons, "flowy,cell 1 1 2 1");
		this.txtBusca.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.txtBusca.setForeground(Color.WHITE);
		this.panel.add(this.txtBusca, "cell 1 3,alignx right");
		this.panel.add(this.edit_nomeConsulta, "cell 2 3,growx,aligny center");
		this.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarContato(edit_nomeConsulta.getText());
			}
		});
		this.btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnBuscar, "cell 3 3,growx,aligny center");
		this.panel.add(this.scrollPane, "cell 1 5 3 1,grow");
		this.tb_consulta.setForeground(Color.BLACK);
		this.tb_consulta.setColumnSelectionAllowed(true);
		this.tb_consulta.setRowSelectionAllowed(true);
		this.tb_consulta.getTableHeader().setReorderingAllowed(false);
		this.tb_consulta.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nome:", "E-mail:", "Telefone:", "Tipo:" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		this.tb_consulta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.tb_consulta.getColumnModel().getColumn(0).setResizable(false);
		this.tb_consulta.getColumnModel().getColumn(1).setResizable(false);
		this.tb_consulta.getColumnModel().getColumn(2).setResizable(false);
		this.tb_consulta.getColumnModel().getColumn(3).setResizable(false);
		this.scrollPane.setViewportView(this.tb_consulta);
		this.btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirMenuPrincipal();
			}
		});
		this.btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnVoltar, "cell 3 7,growx,aligny center");
	}

	protected void abrirMenuPrincipal() {
		JFrame_Janela.frame.setContentPane(new MenuPrincipal());
		JFrame_Janela.frame.setVisible(true);
	}

	private LinkedList<Contato> carregarArquivo() {
		Arquivo arquivo = new Arquivo("agenda");
		return arquivo.lerContato();
	}

	private void preencherTabela() {
		DefaultTableModel model = (DefaultTableModel) tb_consulta.getModel();
		model.setRowCount(0);
		for (Contato contato : contatos) {
			model.addRow(
					new Object[] { contato.getNome(), contato.getEmail(), contato.getTelefone(), contato.getTipo() });
		}
	}

	private void buscarContato(String nome) {
		DefaultTableModel model = (DefaultTableModel) tb_consulta.getModel();
		model.setRowCount(0);
		for (Contato contato : contatos) {
			if (contato.getNome().toLowerCase().contains(nome.toLowerCase())) {
				model.addRow(new Object[] { contato.getNome(), contato.getEmail(), contato.getTelefone(),
						contato.getTipo() });
			}
		}
		if (model.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this, "Contato não encontrado.");
		}
	}

}
