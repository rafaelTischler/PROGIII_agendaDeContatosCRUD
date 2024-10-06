package agenda_CRUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;

public class TelaAlterar extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel txtTelaAlt = new JLabel("Editar contatos\r\n");
	private final JLabel txtBusca = new JLabel("Nome: ");
	private final JTextField edit_nomeAlterar = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnBuscar = new JButton("Buscar");
	private final JTable tb_alterar = new JTable();
	private final JButton btnVoltar = new JButton("Voltar");
	private final JButton btnAlterar = new JButton("Confirmar");
	private LinkedList<Contato> contatos;
	private Arquivo arquivo = new Arquivo("agenda");
	private final JTextArea txtrAquiVocPode = new JTextArea();

	public TelaAlterar() {
		this.edit_nomeAlterar.setBackground(new Color(255, 250, 200));
		this.edit_nomeAlterar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.edit_nomeAlterar.setColumns(10);
		initComponents();
		contatos = arquivo.lerContato();
		preencherTabela();
	}

	private void initComponents() {
		setBounds(100, 100, 640, 480);
		setBackground(new Color(129, 178, 154));
		setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow]"));
		this.panel.setBackground(new Color(61, 64, 91));
		add(this.panel, "cell 1 1,grow");
		this.panel.setLayout(new MigLayout("", "[][][grow,right][][]", "[][][][][][][grow][][][grow]"));
		this.txtTelaAlt.setForeground(Color.WHITE);
		this.txtTelaAlt.setFont(new Font("Segoe UI", Font.BOLD, 16));
		this.panel.add(this.txtTelaAlt, "flowy,cell 1 1 2 1");
		txtrAquiVocPode.setOpaque(false);
		txtrAquiVocPode.setText("Aqui você pode atualizar as informações dos seus contatos. Visualize a lista completa ou use a busca para encontrar o contato desejado. Clique no campo que precisa ser editado, faça as alterações necessárias e salve para atualizar as informações.");
		txtrAquiVocPode.setWrapStyleWord(true);
		txtrAquiVocPode.setLineWrap(true);
		txtrAquiVocPode.setForeground(Color.WHITE);
		txtrAquiVocPode.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		panel.add(txtrAquiVocPode, "cell 1 3 3 1,growx,aligny center");
		this.txtBusca.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.txtBusca.setForeground(Color.WHITE);
		this.panel.add(this.txtBusca, "cell 1 4,alignx right,aligny center");
		this.panel.add(this.edit_nomeAlterar, "cell 2 4,growx,aligny center");
		this.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarContato(edit_nomeAlterar.getText());
			}
		});
		this.btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnBuscar, "cell 3 4,growx,aligny center");
		this.panel.add(this.scrollPane, "cell 1 6 3 1,grow");
		this.tb_alterar.setBackground(new Color(255, 250, 200));
		this.tb_alterar.setForeground(Color.BLACK);
		this.tb_alterar.setColumnSelectionAllowed(true);
		this.tb_alterar.setRowSelectionAllowed(true);
		this.tb_alterar.getTableHeader().setReorderingAllowed(false);
		this.tb_alterar.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome:", "E-mail:", "Telefone:", "Tipo:" }) {
			boolean[] columnEditables = new boolean[] { true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.tb_alterar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.tb_alterar.getColumnModel().getColumn(0).setResizable(false);
		this.tb_alterar.getColumnModel().getColumn(1).setResizable(false);
		this.tb_alterar.getColumnModel().getColumn(2).setResizable(false);
		this.scrollPane.setViewportView(this.tb_alterar);
		this.btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirMenuPrincipal();
			}
		});
		this.btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnVoltar, "cell 2 8,alignx right,aligny center");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarTabela();
			}
		});
		this.btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.panel.add(this.btnAlterar, "cell 3 8");
	}

	protected void abrirMenuPrincipal() {
		JFrame_Janela.frame.setContentPane(new MenuPrincipal());
		JFrame_Janela.frame.setVisible(true);
	}

	private void preencherTabela() {
		DefaultTableModel model = (DefaultTableModel) tb_alterar.getModel();
		model.setRowCount(0);
		for (Contato contato : contatos) {
			model.addRow(new Object[] { contato.getNome(), contato.getEmail(), contato.getTelefone(), contato.getTipo() });
		}
	}

	private void buscarContato(String nome) {
		DefaultTableModel model = (DefaultTableModel) tb_alterar.getModel();
		model.setRowCount(0);
		for (Contato contato : contatos) {
			if (contato.getNome().toLowerCase().contains(nome.toLowerCase())) {
				model.addRow(new Object[] { contato.getNome(), contato.getEmail(), contato.getTelefone(), contato.getTipo() });
			}
		}
		if (model.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this, "Contato não encontrado.");
		}
	}

	public void alterarTabela() {
		DefaultTableModel model = (DefaultTableModel) tb_alterar.getModel();
		LinkedList<Contato> novosContatos = new LinkedList<>();
		for (int i = 0; i < model.getRowCount(); i++) {
			String nome = (String) model.getValueAt(i, 0);
			String email = (String) model.getValueAt(i, 1);
			String telefone = (String) model.getValueAt(i, 2);
			String tipo = (String) model.getValueAt(i, 3);
			Contato contato = new Contato(nome, email, telefone, tipo);
			novosContatos.add(contato);
		}
		boolean houveAlteracao = !novosContatos.equals(contatos);
		if (houveAlteracao) {
			contatos.clear();
			contatos.addAll(novosContatos);
			arquivo.regravarContatos(contatos);
			JOptionPane.showMessageDialog(this, "Contato(s) alterado(s) com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Nenhuma alteração foi realizada.");
		}
	}
}