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

public class TelaRemover extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel txtTelaRemover = new JLabel("Remover contatos");
	private final JLabel txtBusca = new JLabel("Nome: ");
	private final JTextField edit_nomeRemover = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnBuscar = new JButton("Buscar");
	private final JTable tb_remover = new JTable();
	private final JButton btnVoltar = new JButton("Voltar");
	private final JButton btnRemover = new JButton("Remover");
	private LinkedList<Contato> contatos;
	private Arquivo arquivo = new Arquivo("agenda");
	private final JTextArea txtrNaveguePelosSeus = new JTextArea();

	public TelaRemover() {
		this.edit_nomeRemover.setBackground(new Color(255, 250, 200));
		this.edit_nomeRemover.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.edit_nomeRemover.setColumns(10);
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
		this.panel.setLayout(new MigLayout("", "[][][grow,left][][]", "[][][][][][][][grow][][][grow]"));
		this.txtTelaRemover.setForeground(Color.WHITE);
		this.txtTelaRemover.setFont(new Font("Segoe UI", Font.BOLD, 16));
		this.panel.add(this.txtTelaRemover, "flowy,cell 1 1 2 1");
		txtrNaveguePelosSeus.setText("Navegue pelos seus contatos na tabela abaixo ou utilize a barra de busca para encontrar o contato que deseja remover. Uma vez selecionado, você pode excluir permanentemente o contato da sua lista. Cuidado, pois esta ação é irreversível.");
		txtrNaveguePelosSeus.setOpaque(false);
		txtrNaveguePelosSeus.setWrapStyleWord(true);
		txtrNaveguePelosSeus.setLineWrap(true);
		txtrNaveguePelosSeus.setForeground(Color.WHITE);
		txtrNaveguePelosSeus.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		panel.add(txtrNaveguePelosSeus, "cell 1 3 3 1,grow");
		this.txtBusca.setFont(new Font("Segoe UI", Font.BOLD, 12));
		this.txtBusca.setForeground(Color.WHITE);
		this.panel.add(this.txtBusca, "cell 1 5,alignx right");
		this.panel.add(this.edit_nomeRemover, "cell 2 5,growx,aligny center");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarContato(edit_nomeRemover.getText());
			}
		});
		this.btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnBuscar, "cell 3 5,growx,aligny center");
		this.panel.add(this.scrollPane, "cell 1 7 3 1,grow");
		this.tb_remover.setBackground(new Color(255, 250, 200));
		this.tb_remover.setForeground(Color.BLACK);
		this.tb_remover.setColumnSelectionAllowed(false);
		this.tb_remover.setRowSelectionAllowed(true);
		this.tb_remover.getTableHeader().setReorderingAllowed(false);
		this.tb_remover.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome:", "E-mail:", "Telefone:", "Tipo:" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

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
		this.panel.add(this.btnVoltar, "cell 2 9,alignx right,aligny center");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerContato();
			}
		});
		this.btnRemover.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btnRemover, "cell 3 9");
	}

	protected void abrirMenuPrincipal() {
		JFrame_Janela.frame.setContentPane(new MenuPrincipal());
		JFrame_Janela.frame.setVisible(true);
	}

	private void preencherTabela() {
		DefaultTableModel model = (DefaultTableModel) tb_remover.getModel();
		model.setRowCount(0);
		for (Contato contato : contatos) {
			model.addRow(new Object[] { contato.getNome(), contato.getEmail(), contato.getTelefone(), contato.getTipo() });
		}
	}

	private void buscarContato(String nome) {
		DefaultTableModel model = (DefaultTableModel) tb_remover.getModel();
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

	private void removerContato() {
		int linha = tb_remover.getSelectedRow();
		if (linha >= 0) {
			String nome = tb_remover.getValueAt(linha, 0).toString();
			int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja remover o contato " + nome + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
			if (confirmacao == JOptionPane.YES_OPTION) {
				contatos.removeIf(contato -> contato.getNome().equals(nome));
				arquivo.regravarContatos(contatos);
				DefaultTableModel model = (DefaultTableModel) tb_remover.getModel();
				model.removeRow(linha);
				JOptionPane.showMessageDialog(this, "Contato removido com sucesso!");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecione um contato para remover");
		}
	}

}
