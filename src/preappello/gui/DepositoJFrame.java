package preappello.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import preappello.aeromobili.Aeromobile;
import preappello.aeromobili.Aeroplano;
import preappello.aeromobili.Deposito;
import preappello.aeromobili.Elicottero;
import preappello.tool.FileAeromobile;

public class DepositoJFrame extends JFrame {
	public DepositoJFrame(String title, File file) throws FileNotFoundException, ClassNotFoundException, IOException{
		super(title);
		this.deposito = FileAeromobile.readAeromobili(file);
		initialize();
		riempi();
	}

	private void initialize() {
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.menu = new JMenu("Carica");
		this.item1 = new JMenuItem("Scegli file...");
		this.item2 = new JMenuItem("Chiudi");

		this.menu.add(item1);
		this.menu.add(item2);

		this.menubar = new JMenuBar();
		this.menubar.add(menu);

		this.setJMenuBar(menubar);

		this.mainPanel = new JPanel();
		this.topPanel = new JPanel();
		this.botPanel = new JPanel();
		this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.mainPanel.add(topPanel);

		this.label = new JLabel("Scegli il tuo AEROMOBILE!");
		this.combobox = new JComboBox<>();

		this.topPanel.setLayout(new BorderLayout());
		this.topPanel.add(combobox, BorderLayout.CENTER);
		this.topPanel.add(label, BorderLayout.NORTH);

		this.topPanel.setBorder(new TitledBorder(new EtchedBorder(), "-"));
		this.botPanel.setBorder(new TitledBorder(new EtchedBorder(), "-"));

		this.label.setHorizontalAlignment(JLabel.CENTER);

		this.textArea = new JTextArea("testo", 200, 0);
		this.textArea.setEditable(false);
		this.scrollPane = new JScrollPane(textArea);
		this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//this.botPanel.add(scrollPane);
		this.mainPanel.add(scrollPane);
		this.add(mainPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	private void riempi() throws FileNotFoundException, ClassNotFoundException, IOException{
		for (int i = 0; i < deposito.getDeposito().size(); i++){
			if (deposito.getDeposito().get(i) instanceof Aeroplano){
				Aeroplano aero = (Aeroplano) deposito.getDeposito().get(i);
				this.combobox.addItem(aero.getCodice());
			} else {
				Elicottero eli = (Elicottero) deposito.getDeposito().get(i);
				this.combobox.addItem(eli.getCodice());
			}
		}

		class AeromobileListner implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String codice = (String) combobox.getSelectedItem();
				Aeromobile aeromobile = deposito.ricercaCodice(codice);
				if (aeromobile instanceof Aeroplano){
					Aeroplano plano = (Aeroplano) aeromobile;
					textArea.setText("Ultima revisione: "+plano.getRevisione()+"\n");
					textArea.setText("Prossimo volo: "+plano.getProssimoVolo()+"\n");
					textArea.setText("Posti prenotati: "+plano.getPrenotazioni()+"\n");
					textArea.setText("Modello: "+plano.getModello()+"\n");
				}
				else if (aeromobile instanceof Elicottero){
					Elicottero eli = (Elicottero) aeromobile;
					textArea.setText("Ultima revizione: "+eli.getRevisione()+"\n");
					textArea.setText("Prossimo volo: "+eli.getProssimoVolo()+"\n");
					textArea.setText("Posti prenotati: "+eli.getPrenotazioni()+"\n");
				}
			}
		}
		
		ActionListener listner = new AeromobileListner();
		combobox.addActionListener(listner);
	}


	private JMenu menu;
	private JMenuBar menubar;
	private JMenuItem item1;
	private JMenuItem item2;
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel botPanel;
	private JLabel label;
	protected JScrollPane scrollPane;
	protected Deposito deposito;
	protected JTextArea textArea;
	protected JComboBox<String> combobox;
	static int FRAME_HEIGHT = 500;
	static int FRAME_WIDTH = 500;

}
