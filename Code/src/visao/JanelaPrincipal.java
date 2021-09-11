package visao;
//SALD
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import dao.CandidatoDAO;
import modelo.Candidato;

@SuppressWarnings({ "serial", "unused" })
public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setTitle("Tela de Vota\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCandidatoA = new JLabel("Candidato A");
		lblCandidatoA.setFont(new Font("Arial", Font.BOLD, 20));
		lblCandidatoA.setBounds(80, 38, 124, 14);
		contentPane.add(lblCandidatoA);
		
		JLabel lblImagemCA = new JLabel("");
		lblImagemCA.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/visao/homer2.jpg")));
		lblImagemCA.setBounds(40, 63, 193, 236);
		contentPane.add(lblImagemCA);
		
		JLabel lblCandidatoB = new JLabel("Candidato B");
		lblCandidatoB.setFont(new Font("Arial", Font.BOLD, 20));
		lblCandidatoB.setBounds(308, 41, 124, 14);
		contentPane.add(lblCandidatoB);
		
		JLabel lblImagemCB = new JLabel("");
		lblImagemCB.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/visao/homer2.jpg")));
		lblImagemCB.setBounds(269, 63, 193, 236);
		contentPane.add(lblImagemCB);
		
		JRadioButton rdbtnCA = new JRadioButton("Candidato A selecionado");
		rdbtnCA.setBounds(60, 306, 153, 23);
		contentPane.add(rdbtnCA);
		
		JRadioButton rdbtnCB = new JRadioButton("Candidato B selecionado");
		rdbtnCB.setBounds(293, 306, 154, 23);
		contentPane.add(rdbtnCB);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnCA);
		bg.add(rdbtnCB);
		
		JButton btnVotar = new JButton("VOTAR");
		btnVotar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CandidatoDAO dao = new CandidatoDAO();
				
				if(rdbtnCA.isSelected())
				{
					Candidato can = new Candidato("A");
					if(dao.save(can))
					{
						JOptionPane.showMessageDialog(null, "O voto no candidado A foi computado com sucesso!");	
						bg.clearSelection();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Erro na hora de computar o voto no candidato A!");
						bg.clearSelection();
					}
				}
				else
				{
					Candidato can = new Candidato("B");
					if(dao.save(can))
					{
						JOptionPane.showMessageDialog(null, "O voto no candidato B foi computado com sucesso!");
						bg.clearSelection();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Erro na hora de computar o voto no candidato B!");
						bg.clearSelection();
					}								
				}			
			}
		});
		btnVotar.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/visao/OK.png")));
		btnVotar.setBounds(199, 336, 100, 23);
		contentPane.add(btnVotar);	
	}

}
