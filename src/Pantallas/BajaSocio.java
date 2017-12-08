package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Clases.SocioView;
import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.SocioException;

import javax.swing.border.BevelBorder;
import java.awt.Cursor;

public class BajaSocio {

	JFrame frmBajaSocio;
	SocioView so;
	ControladoraABM co;
	private JTextField txtInserteDniA;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public BajaSocio(ControladoraABM c) {
		co = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBajaSocio = new JFrame();
		frmBajaSocio.setTitle("Socio");
		frmBajaSocio.setBounds(100, 100, 388, 265);
		frmBajaSocio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBajaSocio.getContentPane().setLayout(null);
		
		JLabel lblBaja = new JLabel("Baja");
		lblBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaja.setBounds(153, 11, 46, 27);
		frmBajaSocio.getContentPane().add(lblBaja);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 54, 46, 14);
		frmBajaSocio.getContentPane().add(lblDni);
		
		txtInserteDniA = new JTextField();
		txtInserteDniA.setText("Inserte D.N.I a buscar");
		txtInserteDniA.setBounds(66, 51, 197, 20);
		frmBajaSocio.getContentPane().add(txtInserteDniA);
		txtInserteDniA.setColumns(10);
		txtInserteDniA.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				txtInserteDniA.setText("");
			}
		});
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBuscar.setBounds(273, 50, 89, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 so = co.devolverSocio(txtInserteDniA.getText());
					 textNombre.setText(so.getNombre());
					 textEmail.setText(so.getEmail());
					 textDomicilio.setText(so.getDomicilio());
					 textTelefono.setText(so.getTelefono());
					 textNombre.setEnabled(false);
					 textDomicilio.setEnabled(false);
					 textEmail.setEnabled(false);
					 textTelefono.setEnabled(false);
					 txtInserteDniA.setEnabled(true);
				} catch (SocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (ConnectionException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());
				}
			}
		});
		frmBajaSocio.getContentPane().add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 46, 14);
		frmBajaSocio.getContentPane().add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 104, 46, 14);
		frmBajaSocio.getContentPane().add(lblEmail);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 129, 57, 14);
		frmBajaSocio.getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 154, 57, 14);
		frmBajaSocio.getContentPane().add(lblTelefono);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setEnabled(false);
		textNombre.setBounds(66, 76, 197, 20);
		frmBajaSocio.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setEnabled(false);
		textEmail.setBounds(66, 101, 197, 20);
		frmBajaSocio.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setEditable(false);
		textDomicilio.setEnabled(false);
		textDomicilio.setBounds(66, 126, 197, 20);
		frmBajaSocio.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setEnabled(false);
		textTelefono.setBounds(66, 151, 197, 20);
		frmBajaSocio.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(174, 192, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 co.bajaLogicaSocio(txtInserteDniA.getText());
					 txtInserteDniA.setText("");
					 
				} catch (SocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}catch (ConnectionException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());
				}
			}
		});
		frmBajaSocio.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 192, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBajaSocio.dispose();
			}
		});
		frmBajaSocio.getContentPane().add(btnCancelar);
	}

}
