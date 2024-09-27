package agenda_CRUD;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class TelaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();

	/**
	 * Create the panel.
	 */
	public TelaCadastro() {

		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(129, 178, 154));
		setLayout(new MigLayout("", "[][grow][fill]", "[][grow][]"));
		this.panel.setBackground(new Color(61, 64, 91));
		add(this.panel, "cell 1 1,grow");
	}

}
