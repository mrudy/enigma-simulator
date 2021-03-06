package Enigma;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.geom.Rectangle2D;
/**
 *The Enigma GUI Class provides iterations of the Enigma machine the user

 *  
 */
public class EnigmaGUI extends javax.swing.JFrame {

    Controller controller = new Controller();
    Settings settings = new Settings();
    private String str_plainTxt = "";
    private String str_cypherTxt = "";
    private String prevR1 = "A";
    private String prevR2 = "A";
    private String prevR3 = "A";
    private int strCharCtr = 0;
    private int strWrdCtr = 0;
    private int rotor1DisplayNdx = 0;
    private int rotor2DisplayNdx = 0;
    private int rotor3DisplayNdx = 0;
    private int cursorMoveNdx = 0;
    private int m_wrkRotorNum;
    private int m_wrkRingNum;
    private int m_rotorNum_1; 
    private int m_rotorNum_2;
    private int m_rotorNum_3;
    private int m_ringSetNum_1; 
    private int m_ringSetNum_2;
    private int m_ringSetNum_3;
    private int m_rotor_ring_1;
    private int m_rotor_ring_2;
    private int m_rotor_ring_3;
    private int m_rotor_ring_4;
    private int m_rotor_ring_5;
    private int m_rotor_ring_6;
    private int m_rotor_ring_7;
    private int m_rotor_ring_8;
    private int m_rotor_ring_9;
    private boolean m_rotorHold_1;
    private boolean m_rotorHold_2;
    private boolean m_rotorHold_3;
    private boolean m_rotorHold_4;
    private boolean m_rotorHold_5;
    private boolean m_rotorHold_6;
    private boolean m_rotorHold_7;
    private boolean m_rotorHold_8;
    private boolean m_rotorHold_9;
    private boolean m_rotorStandBy;
    private boolean m_rotorSet_1;
    private boolean m_rotorSet_2;
    private boolean m_rotorSet_3;    
    private char[ ] m_aryCharNdx = new char[26];
    private int[] m_aryRotorSettingsVals = new int[12];
    static SplashScreen mySplash;                   // instantiated by JVM we use it to get graphics
    static Graphics2D splashGraphics;               // graphics context for overlay of the splash image
    static Rectangle2D.Double splashTextArea;       // area where we draw the text
    static Rectangle2D.Double splashProgressArea;   // area where we draw the progress bar
    static Font font;                               // used to draw our text
    /**
     * Creates new form EnigmaGUI
     */
    public EnigmaGUI() {
        initComponents();
        m_rotorHold_1 = false;
        m_rotorHold_2 = false;
        m_rotorHold_3 = false;
        m_rotorHold_4 = true;
        m_rotorHold_5 = true;
        m_rotorHold_6 = true;
        m_rotorHold_7 = true;
        m_rotorHold_8 = true;
        m_rotorHold_9 = true;
        m_rotorStandBy = false;
        m_rotorSet_1 = true;
        m_rotorSet_2 = true;
        m_rotorSet_3 = true;
        m_wrkRotorNum = -1;
        m_wrkRingNum = 0;
        m_rotorNum_1 = 1; 
        m_rotorNum_2 = 2;
        m_rotorNum_3 = 3;
        m_ringSetNum_1 = 0; 
        m_ringSetNum_2 = 0;
        m_ringSetNum_3 = 0;
        m_rotor_ring_1 = 0;
        m_rotor_ring_2 = 0;
        m_rotor_ring_3 = 0;
        m_rotor_ring_4 = 0;
        m_rotor_ring_5 = 0;
        m_rotor_ring_6 = 0;
        m_rotor_ring_7 = 0;
        m_rotor_ring_8 = 0;
        m_rotor_ring_9 = 0;
        jLayeredPaneChangeRotor.setVisible(false);
        jLayeredPanePlugboard.setVisible(false);
        m_aryCharNdx[0]  = 'A';
        m_aryCharNdx[1]  = 'B';
        m_aryCharNdx[2] = 'C';
        m_aryCharNdx[3]  = 'D';
        m_aryCharNdx[4] = 'E';
        m_aryCharNdx[5]  = 'F';
        m_aryCharNdx[6]  = 'G';
        m_aryCharNdx[7] = 'H';
        m_aryCharNdx[8] = 'I';
        m_aryCharNdx[9] = 'J';
        m_aryCharNdx[10] = 'K';
        m_aryCharNdx[11] = 'L';
        m_aryCharNdx[12]= 'M';
        m_aryCharNdx[13]= 'N';
        m_aryCharNdx[14] = 'O';
        m_aryCharNdx[15] = 'P';
        m_aryCharNdx[16] = 'Q';
        m_aryCharNdx[17]= 'R';
        m_aryCharNdx[18]= 'S';
        m_aryCharNdx[19] = 'T';
        m_aryCharNdx[20] = 'U';
        m_aryCharNdx[21] = 'V';
        m_aryCharNdx[22] = 'W';
        m_aryCharNdx[23] = 'X';
        m_aryCharNdx[24] = 'Y';
        m_aryCharNdx[25] = 'Z';
        lbl_rotor1_display.setText("Rotor: " + m_rotorNum_1+"-"+(m_ringSetNum_1+1));
        lbl_rotor2_display.setText("Rotor: " + m_rotorNum_2+"-"+(m_ringSetNum_2+1));
        lbl_rotor3_display.setText("Rotor: " + m_rotorNum_3+"-"+(m_ringSetNum_3+1));
        m_aryRotorSettingsVals[0] = 1; // Which rotor number is for the fastest rotor?
        m_aryRotorSettingsVals[1] = 2; // Which rotor number is for the medium rotor?
        m_aryRotorSettingsVals[2] = 3; // Which rotor number is for the slow rotor?
        m_aryRotorSettingsVals[3] = 0; // Which rotor number is for the slowest rotor, if it exists?
        m_aryRotorSettingsVals[4] = 0; // Starting position of rotor 1
        m_aryRotorSettingsVals[5] = 0; // Starting position of rotor 2
        m_aryRotorSettingsVals[6] = 0; // Starting position of rotor 3
        m_aryRotorSettingsVals[7] = 0; // Starting position of rotor 4
        m_aryRotorSettingsVals[8] = 0; // Starting position of rotor 1
        m_aryRotorSettingsVals[9] = 0; // Starting position of rotor 2
        m_aryRotorSettingsVals[10] = 0; // Starting position of rotor 3
        m_aryRotorSettingsVals[11] = 0; // Starting position of rotor 4
        updateDisplay();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPaneSettings = new javax.swing.JLayeredPane();
        jLayeredPaneChangeRotor = new javax.swing.JLayeredPane();
        lbl_close = new javax.swing.JLabel();
        lbl_ring_down = new javax.swing.JLabel();
        lbl_ring_up = new javax.swing.JLabel();
        lbl_rotorNum_Display = new javax.swing.JLabel();
        lbl_ringNum_Display = new javax.swing.JLabel();
        lbl_rotor_changeRing = new javax.swing.JLabel();
        lbl_rotorI = new javax.swing.JLabel();
        lbl_rotorII = new javax.swing.JLabel();
        lbl_rotorIII = new javax.swing.JLabel();
        lbl_reflector1 = new javax.swing.JLabel();
        lbl_rotorWheel_holdTray_1 = new javax.swing.JLabel();
        lbl_rotorWheel_holdTray_2 = new javax.swing.JLabel();
        lbl_rotorWheel_holdTray_3 = new javax.swing.JLabel();
        lbl_rotorWheel_holdTray_4 = new javax.swing.JLabel();
        lbl_rotorWheel_holdTray_5 = new javax.swing.JLabel();
        lbl_rotorWheel_holdTray_6 = new javax.swing.JLabel();
        lbl_rotorWheel_holdTray_7 = new javax.swing.JLabel();
        lbl_rotorWheel_holdTray_8 = new javax.swing.JLabel();
        lbl_rotorWheel_holdTray_9 = new javax.swing.JLabel();
        lbl_rotor_empty_3 = new javax.swing.JLabel();
        lbl_rotor_empty_2 = new javax.swing.JLabel();
        lbl_rotor_empty_1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_rotorTrayBtn = new javax.swing.JLabel();
        jLayeredPanePlugboard = new javax.swing.JLayeredPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        lbl_plug_in_A = new javax.swing.JLabel();
        lbl_plug_in_B = new javax.swing.JLabel();
        lbl_plug_in_C = new javax.swing.JLabel();
        lbl_plug_in_D = new javax.swing.JLabel();
        lbl_plug_in_E = new javax.swing.JLabel();
        lbl_plug_in_F = new javax.swing.JLabel();
        lbl_plug_in_G = new javax.swing.JLabel();
        lbl_plug_in_H = new javax.swing.JLabel();
        lbl_plug_in_I = new javax.swing.JLabel();
        lbl_plug_in_J = new javax.swing.JLabel();
        lbl_plug_in_K = new javax.swing.JLabel();
        lbl_plug_in_L = new javax.swing.JLabel();
        lbl_plug_in_M = new javax.swing.JLabel();
        lbl_plug_in_N = new javax.swing.JLabel();
        lbl_plug_in_O = new javax.swing.JLabel();
        lbl_plug_in_P = new javax.swing.JLabel();
        lbl_plug_in_Q = new javax.swing.JLabel();
        lbl_plug_in_R = new javax.swing.JLabel();
        lbl_plug_in_S = new javax.swing.JLabel();
        lbl_plug_in_T = new javax.swing.JLabel();
        lbl_plug_in_U = new javax.swing.JLabel();
        lbl_plug_in_V = new javax.swing.JLabel();
        lbl_plug_in_W = new javax.swing.JLabel();
        lbl_plug_in_X = new javax.swing.JLabel();
        lbl_plug_in_Y = new javax.swing.JLabel();
        lbl_plug_in_Z = new javax.swing.JLabel();
        lbl_plug_out_A = new javax.swing.JLabel();
        lbl_plug_out_B = new javax.swing.JLabel();
        lbl_plug_out_C = new javax.swing.JLabel();
        lbl_plug_out_D = new javax.swing.JLabel();
        lbl_plug_out_E = new javax.swing.JLabel();
        lbl_plug_out_F = new javax.swing.JLabel();
        lbl_plug_out_G = new javax.swing.JLabel();
        lbl_plug_out_H = new javax.swing.JLabel();
        lbl_plug_out_I = new javax.swing.JLabel();
        lbl_plug_out_J = new javax.swing.JLabel();
        lbl_plug_out_K = new javax.swing.JLabel();
        lbl_plug_out_L = new javax.swing.JLabel();
        lbl_plug_out_M = new javax.swing.JLabel();
        lbl_plug_out_N = new javax.swing.JLabel();
        lbl_plug_out_O = new javax.swing.JLabel();
        lbl_plug_out_P = new javax.swing.JLabel();
        lbl_plug_out_Q = new javax.swing.JLabel();
        lbl_plug_out_R = new javax.swing.JLabel();
        lbl_plug_out_S = new javax.swing.JLabel();
        lbl_plug_out_T = new javax.swing.JLabel();
        lbl_plug_out_U = new javax.swing.JLabel();
        lbl_plug_out_V = new javax.swing.JLabel();
        lbl_plug_out_W = new javax.swing.JLabel();
        lbl_plug_out_X = new javax.swing.JLabel();
        lbl_plug_out_Y = new javax.swing.JLabel();
        lbl_plug_out_Z = new javax.swing.JLabel();
        lbl_closePlugboard = new javax.swing.JLabel();
        lbl_plugboard_bg = new javax.swing.JLabel();
        jLayeredPaneRotorDisplay = new javax.swing.JLayeredPane();
        jLayeredPaneRotorDial = new javax.swing.JLayeredPane();
        lbl_openKnob = new javax.swing.JLabel();
        lbl_rotor_display_1 = new javax.swing.JLabel();
        lbl_rotor_display_2 = new javax.swing.JLabel();
        lbl_rotor_display_3 = new javax.swing.JLabel();
        lbl_Rotor_1_dial_top = new javax.swing.JLabel();
        lbl_Rotor_1_dial_bottom = new javax.swing.JLabel();
        lbl_Rotor_2_dial_top = new javax.swing.JLabel();
        lbl_Rotor_2_dial_bottom = new javax.swing.JLabel();
        lbl_Rotor_3_dial_top = new javax.swing.JLabel();
        lbl_Rotor_3_dial_bottom = new javax.swing.JLabel();
        lbl_rotor_display_bg1 = new javax.swing.JLabel();
        lbl_rotor_display_bg2 = new javax.swing.JLabel();
        lbl_rotor_display_bg3 = new javax.swing.JLabel();
        jLayeredPanelKeyboard = new javax.swing.JLayeredPane();
        lbl_key_Q = new javax.swing.JLabel();
        lbl_key_U = new javax.swing.JLabel();
        lbl_key_W = new javax.swing.JLabel();
        lbl_key_E = new javax.swing.JLabel();
        lbl_key_R = new javax.swing.JLabel();
        lbl_key_T = new javax.swing.JLabel();
        lbl_key_Z = new javax.swing.JLabel();
        lbl_key_O = new javax.swing.JLabel();
        lbl_key_I = new javax.swing.JLabel();
        lbl_key_P = new javax.swing.JLabel();
        lbl_key_Y = new javax.swing.JLabel();
        lbl_key_X = new javax.swing.JLabel();
        lbl_key_C = new javax.swing.JLabel();
        lbl_key_V = new javax.swing.JLabel();
        lbl_key_B = new javax.swing.JLabel();
        lbl_key_N = new javax.swing.JLabel();
        lbl_key_M = new javax.swing.JLabel();
        lbl_key_L = new javax.swing.JLabel();
        lbl_key_A = new javax.swing.JLabel();
        lbl_key_S = new javax.swing.JLabel();
        lbl_key_D = new javax.swing.JLabel();
        lbl_key_F = new javax.swing.JLabel();
        lbl_key_G = new javax.swing.JLabel();
        lbl_key_H = new javax.swing.JLabel();
        lbl_key_J = new javax.swing.JLabel();
        lbl_key_K = new javax.swing.JLabel();
        lbl_openPlugboard = new javax.swing.JLabel();
        jLayeredPaneLampboard = new javax.swing.JLayeredPane();
        lbl_lamp_L = new javax.swing.JLabel();
        lbl_lamp_Q = new javax.swing.JLabel();
        lbl_lamp_E = new javax.swing.JLabel();
        lbl_lamp_W = new javax.swing.JLabel();
        lbl_lamp_R = new javax.swing.JLabel();
        lbl_lamp_Z = new javax.swing.JLabel();
        lbl_lamp_T = new javax.swing.JLabel();
        lbl_lamp_U = new javax.swing.JLabel();
        lbl_lamp_I = new javax.swing.JLabel();
        lbl_lamp_D = new javax.swing.JLabel();
        lbl_lamp_A = new javax.swing.JLabel();
        lbl_lamp_S = new javax.swing.JLabel();
        lbl_lamp_F = new javax.swing.JLabel();
        lbl_lamp_G = new javax.swing.JLabel();
        lbl_lamp_H = new javax.swing.JLabel();
        lbl_lamp_J = new javax.swing.JLabel();
        lbl_lamp_K = new javax.swing.JLabel();
        lbl_lamp_V = new javax.swing.JLabel();
        lbl_lamp_B = new javax.swing.JLabel();
        lbl_lamp_N = new javax.swing.JLabel();
        lbl_lamp_X = new javax.swing.JLabel();
        lbl_lamp_P = new javax.swing.JLabel();
        lbl_lamp_M = new javax.swing.JLabel();
        lbl_lamp_Y = new javax.swing.JLabel();
        lbl_lamp_C = new javax.swing.JLabel();
        lbl_lamp_O = new javax.swing.JLabel();
        jLayeredPaneWireDiagram = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_plainTxt = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtArea_cypherTxt = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbl_rotor1_display = new javax.swing.JLabel();
        lbl_rotor2_display = new javax.swing.JLabel();
        lbl_rotor3_display = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_path_pb_in_1 = new javax.swing.JLabel();
        lbl_path_pb_in_2 = new javax.swing.JLabel();
        lbl_path_rotor_1_in_1 = new javax.swing.JLabel();
        lbl_path_rotor_1_in_2 = new javax.swing.JLabel();
        lbl_path_rotor_2_in_1 = new javax.swing.JLabel();
        lbl_path_rotor_2_in_2 = new javax.swing.JLabel();
        lbl_path_rotor_3_in_1 = new javax.swing.JLabel();
        lbl_path_rotor_3_in_2 = new javax.swing.JLabel();
        lbl_path_reflect_1 = new javax.swing.JLabel();
        lbl_path_reflect_2 = new javax.swing.JLabel();
        lbl_path_rotor_3_out_1 = new javax.swing.JLabel();
        lbl_path_rotor_3_out_2 = new javax.swing.JLabel();
        lbl_path_rotor_2_out_1 = new javax.swing.JLabel();
        lbl_path_rotor_2_out_2 = new javax.swing.JLabel();
        lbl_path_rotor_1_out_1 = new javax.swing.JLabel();
        lbl_path_rotor_1_out_2 = new javax.swing.JLabel();
        lbl_path_pb_out_1 = new javax.swing.JLabel();
        lbl_path_pb_out_2 = new javax.swing.JLabel();
        lbl_path_input = new javax.swing.JLabel();
        lbl_path_output = new javax.swing.JLabel();
        lbl_btn_forward = new javax.swing.JLabel();
        lbl_btn_back = new javax.swing.JLabel();
        lbl_Background = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Second Rotor:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ENIGMA");
        setMinimumSize(new java.awt.Dimension(800, 552));
        setResizable(false);

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(500, 550));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(500, 550));

        lbl_close.setForeground(new java.awt.Color(255, 255, 255));
        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/powerMod.jpg"))); // NOI18N
        lbl_close.setText("CLOSE COVER");
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_closeMouseReleased(evt);
            }
        });
        lbl_close.setBounds(340, 0, 130, 180);
        jLayeredPaneChangeRotor.add(lbl_close, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_close.getAccessibleContext().setAccessibleName("");

        lbl_ring_down.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ring_down.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_ring_downMouseReleased(evt);
            }
        });
        lbl_ring_down.setBounds(80, 270, 60, 30);
        jLayeredPaneChangeRotor.add(lbl_ring_down, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_ring_up.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ring_up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_ring_upMouseReleased(evt);
            }
        });
        lbl_ring_up.setBounds(80, 230, 60, 30);
        jLayeredPaneChangeRotor.add(lbl_ring_up, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorNum_Display.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_rotorNum_Display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_rotorNum_Display.setText("III");
        lbl_rotorNum_Display.setBounds(91, 210, 40, 15);
        jLayeredPaneChangeRotor.add(lbl_rotorNum_Display, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_ringNum_Display.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_ringNum_Display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ringNum_Display.setText("A-1");
        lbl_ringNum_Display.setBounds(88, 307, 40, 15);
        jLayeredPaneChangeRotor.add(lbl_ringNum_Display, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor_changeRing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel_change.jpg"))); // NOI18N
        lbl_rotor_changeRing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotor_changeRing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotor_changeRingMouseReleased(evt);
            }
        });
        lbl_rotor_changeRing.setBounds(7, 188, 202, 155);
        jLayeredPaneChangeRotor.add(lbl_rotor_changeRing, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel.jpg"))); // NOI18N
        lbl_rotorI.setToolTipText("");
        lbl_rotorI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotorI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorIMouseReleased(evt);
            }
        });
        lbl_rotorI.setBounds(250, 20, 45, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel.jpg"))); // NOI18N
        lbl_rotorII.setToolTipText("");
        lbl_rotorII.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotorII.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorIIMouseReleased(evt);
            }
        });
        lbl_rotorII.setBounds(205, 20, 45, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorII, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorIII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel.jpg"))); // NOI18N
        lbl_rotorIII.setToolTipText("");
        lbl_rotorIII.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotorIII.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorIIIMouseReleased(evt);
            }
        });
        lbl_rotorIII.setBounds(160, 20, 45, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorIII, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_reflector1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reflector_3Rotors.jpg"))); // NOI18N
        lbl_reflector1.setBounds(0, 0, 157, 182);
        jLayeredPaneChangeRotor.add(lbl_reflector1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorWheel_holdTray_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel_holdTray.jpg"))); // NOI18N
        lbl_rotorWheel_holdTray_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotorWheel_holdTray_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorWheel_holdTray_1MouseReleased(evt);
            }
        });
        lbl_rotorWheel_holdTray_1.setBounds(10, 390, 50, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorWheel_holdTray_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorWheel_holdTray_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel_holdTray.jpg"))); // NOI18N
        lbl_rotorWheel_holdTray_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotorWheel_holdTray_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorWheel_holdTray_2MouseReleased(evt);
            }
        });
        lbl_rotorWheel_holdTray_2.setBounds(60, 390, 50, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorWheel_holdTray_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorWheel_holdTray_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel_holdTray.jpg"))); // NOI18N
        lbl_rotorWheel_holdTray_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotorWheel_holdTray_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorWheel_holdTray_3MouseReleased(evt);
            }
        });
        lbl_rotorWheel_holdTray_3.setBounds(110, 390, 50, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorWheel_holdTray_3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorWheel_holdTray_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel_holdTray.jpg"))); // NOI18N
        lbl_rotorWheel_holdTray_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotorWheel_holdTray_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorWheel_holdTray_4MouseReleased(evt);
            }
        });
        lbl_rotorWheel_holdTray_4.setBounds(160, 390, 50, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorWheel_holdTray_4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorWheel_holdTray_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel_holdTray.jpg"))); // NOI18N
        lbl_rotorWheel_holdTray_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotorWheel_holdTray_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorWheel_holdTray_5MouseReleased(evt);
            }
        });
        lbl_rotorWheel_holdTray_5.setBounds(210, 390, 50, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorWheel_holdTray_5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorWheel_holdTray_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel_holdTray.jpg"))); // NOI18N
        lbl_rotorWheel_holdTray_6.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        lbl_rotorWheel_holdTray_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorWheel_holdTray_6MouseReleased(evt);
            }
        });
        lbl_rotorWheel_holdTray_6.setBounds(260, 390, 50, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorWheel_holdTray_6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorWheel_holdTray_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel_holdTray.jpg"))); // NOI18N
        lbl_rotorWheel_holdTray_7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotorWheel_holdTray_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorWheel_holdTray_7MouseReleased(evt);
            }
        });
        lbl_rotorWheel_holdTray_7.setBounds(310, 390, 50, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorWheel_holdTray_7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorWheel_holdTray_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel_holdTray.jpg"))); // NOI18N
        lbl_rotorWheel_holdTray_8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_rotorWheel_holdTray_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorWheel_holdTray_8MouseReleased(evt);
            }
        });
        lbl_rotorWheel_holdTray_8.setBounds(360, 390, 50, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorWheel_holdTray_8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorWheel_holdTray_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWheel_holdTray.jpg"))); // NOI18N
        lbl_rotorWheel_holdTray_9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_rotorWheel_holdTray_9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorWheel_holdTray_9MouseReleased(evt);
            }
        });
        lbl_rotorWheel_holdTray_9.setBounds(410, 390, 50, 148);
        jLayeredPaneChangeRotor.add(lbl_rotorWheel_holdTray_9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor_empty_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotor_empty_3MouseReleased(evt);
            }
        });
        lbl_rotor_empty_3.setBounds(160, 30, 40, 140);
        jLayeredPaneChangeRotor.add(lbl_rotor_empty_3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor_empty_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotor_empty_2MouseReleased(evt);
            }
        });
        lbl_rotor_empty_2.setBounds(206, 30, 40, 140);
        jLayeredPaneChangeRotor.add(lbl_rotor_empty_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor_empty_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotor_empty_1MouseReleased(evt);
            }
        });
        lbl_rotor_empty_1.setBounds(250, 30, 40, 140);
        jLayeredPaneChangeRotor.add(lbl_rotor_empty_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings_bg.jpg"))); // NOI18N
        jLabel6.setBounds(-10, -10, 500, 550);
        jLayeredPaneChangeRotor.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotorTrayBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_rotorTrayBtnMouseReleased(evt);
            }
        });
        lbl_rotorTrayBtn.setBounds(10, 400, 450, 130);
        jLayeredPaneChangeRotor.add(lbl_rotorTrayBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_rotorTrayBtn.getAccessibleContext().setAccessibleName("lbl_rotorTrayBtn");

        jLayeredPaneChangeRotor.setBounds(10, 10, 480, 540);
        jLayeredPaneSettings.add(jLayeredPaneChangeRotor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPaneSettings.setBounds(0, 0, 500, 550);
        jLayeredPane1.add(jLayeredPaneSettings, javax.swing.JLayeredPane.PALETTE_LAYER);

        lbl_plug_in_A.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_A.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_A.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_A.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_A.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_AMouseReleased(evt);
            }
        });
        lbl_plug_in_A.setBounds(57, 98, 20, 20);
        jLayeredPane3.add(lbl_plug_in_A, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_B.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_B.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_B.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_B.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_BMouseReleased(evt);
            }
        });
        lbl_plug_in_B.setBounds(292, 145, 20, 20);
        jLayeredPane3.add(lbl_plug_in_B, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_C.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_C.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_C.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_C.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_C.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_CMouseReleased(evt);
            }
        });
        lbl_plug_in_C.setBounds(188, 145, 20, 20);
        jLayeredPane3.add(lbl_plug_in_C, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_D.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_D.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_D.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_D.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_DMouseReleased(evt);
            }
        });
        lbl_plug_in_D.setBounds(161, 98, 20, 20);
        jLayeredPane3.add(lbl_plug_in_D, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_E.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_E.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_E.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_E.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_E.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_EMouseReleased(evt);
            }
        });
        lbl_plug_in_E.setBounds(135, 53, 20, 20);
        jLayeredPane3.add(lbl_plug_in_E, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_F.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_F.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_F.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_F.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_F.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_F.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_FMouseReleased(evt);
            }
        });
        lbl_plug_in_F.setBounds(214, 98, 20, 20);
        jLayeredPane3.add(lbl_plug_in_F, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_G.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_G.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_G.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_G.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_G.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_G.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_GMouseReleased(evt);
            }
        });
        lbl_plug_in_G.setBounds(266, 98, 20, 20);
        jLayeredPane3.add(lbl_plug_in_G, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_H.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_H.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_H.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_H.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_H.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_HMouseReleased(evt);
            }
        });
        lbl_plug_in_H.setBounds(319, 98, 20, 20);
        jLayeredPane3.add(lbl_plug_in_H, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_I.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_I.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_I.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_I.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_I.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_I.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_IMouseReleased(evt);
            }
        });
        lbl_plug_in_I.setBounds(397, 53, 20, 20);
        jLayeredPane3.add(lbl_plug_in_I, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_J.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_J.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_J.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_J.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_J.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_J.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_JMouseReleased(evt);
            }
        });
        lbl_plug_in_J.setBounds(371, 98, 20, 20);
        jLayeredPane3.add(lbl_plug_in_J, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_K.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_K.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_K.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_K.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_K.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_KMouseReleased(evt);
            }
        });
        lbl_plug_in_K.setBounds(424, 98, 20, 20);
        jLayeredPane3.add(lbl_plug_in_K, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_L.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_L.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_L.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_L.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_LMouseReleased(evt);
            }
        });
        lbl_plug_in_L.setBounds(450, 145, 20, 20);
        jLayeredPane3.add(lbl_plug_in_L, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_M.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_M.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_M.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_M.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_M.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_MMouseReleased(evt);
            }
        });
        lbl_plug_in_M.setBounds(397, 145, 20, 20);
        jLayeredPane3.add(lbl_plug_in_M, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_N.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_N.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_N.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_N.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_N.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_NMouseReleased(evt);
            }
        });
        lbl_plug_in_N.setBounds(345, 145, 20, 20);
        jLayeredPane3.add(lbl_plug_in_N, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_O.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_O.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_O.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_O.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_O.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_OMouseReleased(evt);
            }
        });
        lbl_plug_in_O.setBounds(450, 53, 20, 20);
        jLayeredPane3.add(lbl_plug_in_O, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_P.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_P.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_P.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_P.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_P.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_PMouseReleased(evt);
            }
        });
        lbl_plug_in_P.setBounds(31, 145, 20, 20);
        jLayeredPane3.add(lbl_plug_in_P, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_Q.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_Q.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_Q.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_Q.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_Q.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_Q.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_QMouseReleased(evt);
            }
        });
        lbl_plug_in_Q.setBounds(30, 53, 20, 20);
        jLayeredPane3.add(lbl_plug_in_Q, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_R.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_R.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_R.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_R.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_R.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_R.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_RMouseReleased(evt);
            }
        });
        lbl_plug_in_R.setBounds(189, 53, 20, 20);
        jLayeredPane3.add(lbl_plug_in_R, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_S.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_S.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_S.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_S.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_S.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_S.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_SMouseReleased(evt);
            }
        });
        lbl_plug_in_S.setBounds(109, 98, 20, 20);
        jLayeredPane3.add(lbl_plug_in_S, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_T.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_T.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_T.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_T.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_T.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_TMouseReleased(evt);
            }
        });
        lbl_plug_in_T.setBounds(240, 53, 20, 20);
        jLayeredPane3.add(lbl_plug_in_T, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_U.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_U.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_U.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_U.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_U.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_U.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_UMouseReleased(evt);
            }
        });
        lbl_plug_in_U.setBounds(345, 53, 20, 20);
        jLayeredPane3.add(lbl_plug_in_U, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_V.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_V.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_V.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_V.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_V.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_V.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_VMouseReleased(evt);
            }
        });
        lbl_plug_in_V.setBounds(240, 145, 20, 20);
        jLayeredPane3.add(lbl_plug_in_V, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_W.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_W.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_W.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_W.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_W.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_W.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_WMouseReleased(evt);
            }
        });
        lbl_plug_in_W.setBounds(83, 53, 20, 20);
        jLayeredPane3.add(lbl_plug_in_W, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_X.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_X.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_X.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_X.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_X.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_XMouseReleased(evt);
            }
        });
        lbl_plug_in_X.setBounds(136, 145, 20, 20);
        jLayeredPane3.add(lbl_plug_in_X, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_Y.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_Y.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_Y.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_Y.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_Y.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_Y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_YMouseReleased(evt);
            }
        });
        lbl_plug_in_Y.setBounds(83, 145, 20, 20);
        jLayeredPane3.add(lbl_plug_in_Y, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_in_Z.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_in_Z.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_in_Z.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_Z.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_in_Z.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_in_Z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_in_ZMouseReleased(evt);
            }
        });
        lbl_plug_in_Z.setBounds(292, 53, 20, 20);
        jLayeredPane3.add(lbl_plug_in_Z, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_A.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_A.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_A.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_A.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_A.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_AMouseReleased(evt);
            }
        });
        lbl_plug_out_A.setBounds(57, 126, 20, 20);
        jLayeredPane3.add(lbl_plug_out_A, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_B.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_B.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_B.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_B.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_BMouseReleased(evt);
            }
        });
        lbl_plug_out_B.setBounds(292, 173, 20, 20);
        jLayeredPane3.add(lbl_plug_out_B, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_C.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_C.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_C.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_C.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_C.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_CMouseReleased(evt);
            }
        });
        lbl_plug_out_C.setBounds(188, 173, 20, 20);
        jLayeredPane3.add(lbl_plug_out_C, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_D.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_D.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_D.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_D.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_DMouseReleased(evt);
            }
        });
        lbl_plug_out_D.setBounds(161, 126, 20, 20);
        jLayeredPane3.add(lbl_plug_out_D, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_E.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_E.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_E.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_E.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_E.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_EMouseReleased(evt);
            }
        });
        lbl_plug_out_E.setBounds(135, 83, 20, 20);
        jLayeredPane3.add(lbl_plug_out_E, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_F.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_F.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_F.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_F.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_F.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_F.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_FMouseReleased(evt);
            }
        });
        lbl_plug_out_F.setBounds(214, 126, 20, 20);
        jLayeredPane3.add(lbl_plug_out_F, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_G.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_G.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_G.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_G.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_G.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_G.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_GMouseReleased(evt);
            }
        });
        lbl_plug_out_G.setBounds(266, 126, 20, 20);
        jLayeredPane3.add(lbl_plug_out_G, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_H.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_H.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_H.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_H.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_H.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_HMouseReleased(evt);
            }
        });
        lbl_plug_out_H.setBounds(319, 126, 20, 20);
        jLayeredPane3.add(lbl_plug_out_H, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_I.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_I.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_I.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_I.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_I.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_I.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_IMouseReleased(evt);
            }
        });
        lbl_plug_out_I.setBounds(397, 83, 20, 20);
        jLayeredPane3.add(lbl_plug_out_I, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_J.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_J.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_J.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_J.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_J.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_J.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_JMouseReleased(evt);
            }
        });
        lbl_plug_out_J.setBounds(371, 126, 20, 20);
        jLayeredPane3.add(lbl_plug_out_J, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_K.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_K.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_K.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_K.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_K.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_K.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_KMouseReleased(evt);
            }
        });
        lbl_plug_out_K.setBounds(424, 126, 20, 20);
        jLayeredPane3.add(lbl_plug_out_K, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_L.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_L.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_L.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_L.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_LMouseReleased(evt);
            }
        });
        lbl_plug_out_L.setBounds(450, 173, 20, 20);
        jLayeredPane3.add(lbl_plug_out_L, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_M.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_M.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_M.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_M.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_M.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_M.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_MMouseReleased(evt);
            }
        });
        lbl_plug_out_M.setBounds(397, 173, 20, 20);
        jLayeredPane3.add(lbl_plug_out_M, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_N.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_N.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_N.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_N.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_N.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_N.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_NMouseReleased(evt);
            }
        });
        lbl_plug_out_N.setBounds(345, 173, 20, 20);
        jLayeredPane3.add(lbl_plug_out_N, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_O.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_O.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_O.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_O.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_O.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_OMouseReleased(evt);
            }
        });
        lbl_plug_out_O.setBounds(450, 83, 20, 20);
        jLayeredPane3.add(lbl_plug_out_O, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_P.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_P.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_P.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_P.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_P.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_PMouseReleased(evt);
            }
        });
        lbl_plug_out_P.setBounds(31, 173, 20, 20);
        jLayeredPane3.add(lbl_plug_out_P, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_Q.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_Q.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_Q.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_Q.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_Q.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_Q.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_QMouseReleased(evt);
            }
        });
        lbl_plug_out_Q.setBounds(30, 83, 20, 20);
        jLayeredPane3.add(lbl_plug_out_Q, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_R.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_R.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_R.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_R.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_R.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_R.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_RMouseReleased(evt);
            }
        });
        lbl_plug_out_R.setBounds(189, 83, 20, 20);
        jLayeredPane3.add(lbl_plug_out_R, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_S.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_S.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_S.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_S.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_S.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_S.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_SMouseReleased(evt);
            }
        });
        lbl_plug_out_S.setBounds(109, 126, 20, 20);
        jLayeredPane3.add(lbl_plug_out_S, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_T.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_T.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_T.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_T.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_T.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_TMouseReleased(evt);
            }
        });
        lbl_plug_out_T.setBounds(240, 83, 20, 20);
        jLayeredPane3.add(lbl_plug_out_T, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_U.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_U.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_U.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_U.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_U.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_U.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_UMouseReleased(evt);
            }
        });
        lbl_plug_out_U.setBounds(345, 83, 20, 20);
        jLayeredPane3.add(lbl_plug_out_U, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_V.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_V.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_V.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_V.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_V.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_V.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_VMouseReleased(evt);
            }
        });
        lbl_plug_out_V.setBounds(240, 173, 20, 20);
        jLayeredPane3.add(lbl_plug_out_V, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_W.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_W.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_W.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_W.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_W.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_W.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_WMouseReleased(evt);
            }
        });
        lbl_plug_out_W.setBounds(83, 83, 20, 20);
        jLayeredPane3.add(lbl_plug_out_W, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_X.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_X.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_X.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_X.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_X.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_XMouseReleased(evt);
            }
        });
        lbl_plug_out_X.setBounds(136, 173, 20, 20);
        jLayeredPane3.add(lbl_plug_out_X, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_Y.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_Y.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_Y.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_Y.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_Y.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_Y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_YMouseReleased(evt);
            }
        });
        lbl_plug_out_Y.setBounds(83, 173, 20, 20);
        jLayeredPane3.add(lbl_plug_out_Y, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plug_out_Z.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_plug_out_Z.setForeground(new java.awt.Color(255, 255, 255));
        lbl_plug_out_Z.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_Z.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_plug_out_Z.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_plug_out_Z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_plug_out_ZMouseReleased(evt);
            }
        });
        lbl_plug_out_Z.setBounds(292, 83, 20, 20);
        jLayeredPane3.add(lbl_plug_out_Z, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_closePlugboard.setToolTipText("Close Plugboard");
        lbl_closePlugboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_closePlugboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_closePlugboardMousePressed(evt);
            }
        });
        lbl_closePlugboard.setBounds(190, 0, 110, 20);
        jLayeredPane3.add(lbl_closePlugboard, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_plugboard_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plugboard.jpg"))); // NOI18N
        lbl_plugboard_bg.setBounds(0, 0, 500, 220);
        jLayeredPane3.add(lbl_plugboard_bg, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane3.setBounds(0, 10, 500, 220);
        jLayeredPanePlugboard.add(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPanePlugboard.setBounds(0, 320, 500, 230);
        jLayeredPane1.add(jLayeredPanePlugboard, javax.swing.JLayeredPane.PALETTE_LAYER);

        lbl_openKnob.setForeground(new java.awt.Color(255, 255, 255));
        lbl_openKnob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/openKnob.jpg"))); // NOI18N
        lbl_openKnob.setToolTipText("Open Cover");
        lbl_openKnob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_openKnobMouseReleased(evt);
            }
        });
        lbl_openKnob.setBounds(280, 70, 110, 40);
        jLayeredPaneRotorDial.add(lbl_openKnob, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor_display_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_rotor_display_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_rotor_display_1.setBounds(190, 50, 40, 30);
        jLayeredPaneRotorDial.add(lbl_rotor_display_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor_display_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_rotor_display_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_rotor_display_2.setBounds(130, 50, 40, 30);
        jLayeredPaneRotorDial.add(lbl_rotor_display_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor_display_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_rotor_display_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_rotor_display_3.setBounds(70, 50, 40, 30);
        jLayeredPaneRotorDial.add(lbl_rotor_display_3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_Rotor_1_dial_top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_top_1.jpg"))); // NOI18N
        lbl_Rotor_1_dial_top.setAlignmentY(0.0F);
        lbl_Rotor_1_dial_top.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Rotor_1_dial_top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_Rotor_1_dial_topMousePressed(evt);
            }
        });
        lbl_Rotor_1_dial_top.setBounds(230, 10, 30, 50);
        jLayeredPaneRotorDial.add(lbl_Rotor_1_dial_top, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_Rotor_1_dial_bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_bottom_1.jpg"))); // NOI18N
        lbl_Rotor_1_dial_bottom.setAlignmentY(0.0F);
        lbl_Rotor_1_dial_bottom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_Rotor_1_dial_bottomMousePressed(evt);
            }
        });
        lbl_Rotor_1_dial_bottom.setBounds(230, 60, 30, 50);
        jLayeredPaneRotorDial.add(lbl_Rotor_1_dial_bottom, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_Rotor_2_dial_top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_top_2.jpg"))); // NOI18N
        lbl_Rotor_2_dial_top.setAlignmentY(0.0F);
        lbl_Rotor_2_dial_top.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Rotor_2_dial_top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_Rotor_2_dial_topMousePressed(evt);
            }
        });
        lbl_Rotor_2_dial_top.setBounds(170, 10, 30, 50);
        jLayeredPaneRotorDial.add(lbl_Rotor_2_dial_top, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_Rotor_2_dial_bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_bottom_2.jpg"))); // NOI18N
        lbl_Rotor_2_dial_bottom.setAlignmentY(0.0F);
        lbl_Rotor_2_dial_bottom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_Rotor_2_dial_bottomMousePressed(evt);
            }
        });
        lbl_Rotor_2_dial_bottom.setBounds(170, 60, 30, 50);
        jLayeredPaneRotorDial.add(lbl_Rotor_2_dial_bottom, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_Rotor_3_dial_top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_top_3.jpg"))); // NOI18N
        lbl_Rotor_3_dial_top.setAlignmentY(0.0F);
        lbl_Rotor_3_dial_top.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Rotor_3_dial_top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_Rotor_3_dial_topMousePressed(evt);
            }
        });
        lbl_Rotor_3_dial_top.setBounds(110, 10, 30, 50);
        jLayeredPaneRotorDial.add(lbl_Rotor_3_dial_top, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_Rotor_3_dial_bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_bottom_3.jpg"))); // NOI18N
        lbl_Rotor_3_dial_bottom.setAlignmentY(0.0F);
        lbl_Rotor_3_dial_bottom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_Rotor_3_dial_bottomMousePressed(evt);
            }
        });
        lbl_Rotor_3_dial_bottom.setBounds(110, 60, 30, 50);
        jLayeredPaneRotorDial.add(lbl_Rotor_3_dial_bottom, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor_display_bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWindow.jpg"))); // NOI18N
        lbl_rotor_display_bg1.setName("lbl_rotor_display_bg2");
        lbl_rotor_display_bg1.setBounds(190, 50, 40, 30);
        jLayeredPaneRotorDial.add(lbl_rotor_display_bg1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor_display_bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWindow.jpg"))); // NOI18N
        lbl_rotor_display_bg2.setName("lbl_rotor_display_bg2");
        lbl_rotor_display_bg2.setBounds(130, 50, 40, 30);
        jLayeredPaneRotorDial.add(lbl_rotor_display_bg2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor_display_bg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorWindow.jpg"))); // NOI18N
        lbl_rotor_display_bg3.setName("lbl_rotor_display_bg2");
        lbl_rotor_display_bg3.setBounds(70, 50, 40, 30);
        jLayeredPaneRotorDial.add(lbl_rotor_display_bg3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPaneRotorDial.setBounds(10, 10, 390, 120);
        jLayeredPaneRotorDisplay.add(jLayeredPaneRotorDial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPaneRotorDisplay.setBounds(70, 30, 400, 140);
        jLayeredPane1.add(jLayeredPaneRotorDisplay, javax.swing.JLayeredPane.PALETTE_LAYER);

        jLayeredPanelKeyboard.setBackground(new java.awt.Color(255, 51, 51));

        lbl_key_Q.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_Q_up.jpg"))); // NOI18N
        lbl_key_Q.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_Q.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_Q.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_Q.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_QMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_QMouseReleased(evt);
            }
        });
        lbl_key_Q.setBounds(20, 10, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_Q, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_key_Q.getAccessibleContext().setAccessibleName("lbl_key_Q");

        lbl_key_U.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_U_up.jpg"))); // NOI18N
        lbl_key_U.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_U.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_U.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_U.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_UMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_UMouseReleased(evt);
            }
        });
        lbl_key_U.setBounds(320, 10, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_U, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_W.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_W_up.jpg"))); // NOI18N
        lbl_key_W.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_W.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_W.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_W.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_WMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_WMouseReleased(evt);
            }
        });
        lbl_key_W.setBounds(70, 10, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_W, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_E_up.jpg"))); // NOI18N
        lbl_key_E.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_E.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_E.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_EMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_EMouseReleased(evt);
            }
        });
        lbl_key_E.setBounds(120, 10, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_E, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_R.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_R_up.jpg"))); // NOI18N
        lbl_key_R.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_R.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_R.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_R.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_RMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_RMousePressed(evt);
            }
        });
        lbl_key_R.setBounds(170, 10, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_R, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_T.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_T_up.jpg"))); // NOI18N
        lbl_key_T.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_T.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_T.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_TMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_TMousePressed(evt);
            }
        });
        lbl_key_T.setBounds(220, 10, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_T, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_Z.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_Z_up.jpg"))); // NOI18N
        lbl_key_Z.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_Z.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_Z.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_Z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_ZMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_ZMousePressed(evt);
            }
        });
        lbl_key_Z.setBounds(270, 10, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_Z, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_O_up.jpg"))); // NOI18N
        lbl_key_O.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_O.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_O.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_OMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_OMousePressed(evt);
            }
        });
        lbl_key_O.setBounds(420, 10, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_O, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_I_up.jpg"))); // NOI18N
        lbl_key_I.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_I.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_I.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_I.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_IMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_IMousePressed(evt);
            }
        });
        lbl_key_I.setBounds(370, 10, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_I, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_P_up.jpg"))); // NOI18N
        lbl_key_P.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_P.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_P.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_PMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_PMousePressed(evt);
            }
        });
        lbl_key_P.setBounds(20, 130, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_P, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_Y.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_Y_up.jpg"))); // NOI18N
        lbl_key_Y.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_Y.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_Y.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_Y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_YMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_YMousePressed(evt);
            }
        });
        lbl_key_Y.setBounds(70, 130, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_Y, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_X_up.jpg"))); // NOI18N
        lbl_key_X.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_X.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_X.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_XMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_XMousePressed(evt);
            }
        });
        lbl_key_X.setBounds(120, 130, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_X, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_C_up.jpg"))); // NOI18N
        lbl_key_C.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_C.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_C.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_CMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_CMousePressed(evt);
            }
        });
        lbl_key_C.setBounds(170, 130, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_C, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_V.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_V_up.jpg"))); // NOI18N
        lbl_key_V.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_V.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_V.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_V.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_VMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_VMousePressed(evt);
            }
        });
        lbl_key_V.setBounds(220, 130, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_V, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_B_up.jpg"))); // NOI18N
        lbl_key_B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_B.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_B.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_BMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_BMousePressed(evt);
            }
        });
        lbl_key_B.setBounds(270, 130, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_B, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_N.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_N_up.jpg"))); // NOI18N
        lbl_key_N.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_N.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_N.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_N.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_NMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_NMousePressed(evt);
            }
        });
        lbl_key_N.setBounds(320, 130, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_N, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_M.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_M_up.jpg"))); // NOI18N
        lbl_key_M.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_M.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_M.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_M.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_MMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_MMousePressed(evt);
            }
        });
        lbl_key_M.setBounds(370, 130, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_M, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_L_up.jpg"))); // NOI18N
        lbl_key_L.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_L.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_L.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_LMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_LMousePressed(evt);
            }
        });
        lbl_key_L.setBounds(420, 130, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_L, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_A_up.jpg"))); // NOI18N
        lbl_key_A.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_A.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_A.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_AMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_AMousePressed(evt);
            }
        });
        lbl_key_A.setBounds(50, 70, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_A, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_S_up.jpg"))); // NOI18N
        lbl_key_S.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_S.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_S.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_S.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_SMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_SMousePressed(evt);
            }
        });
        lbl_key_S.setBounds(100, 70, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_S, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_D_up.jpg"))); // NOI18N
        lbl_key_D.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_D.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_D.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_DMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_DMousePressed(evt);
            }
        });
        lbl_key_D.setBounds(150, 70, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_D, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_F_up.jpg"))); // NOI18N
        lbl_key_F.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_F.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_F.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_F.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_FMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_FMousePressed(evt);
            }
        });
        lbl_key_F.setBounds(200, 70, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_F, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_G.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_G_up.jpg"))); // NOI18N
        lbl_key_G.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_G.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_G.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_G.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_GMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_GMousePressed(evt);
            }
        });
        lbl_key_G.setBounds(250, 70, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_G, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_H_up.jpg"))); // NOI18N
        lbl_key_H.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_H.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_H.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_H.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_HMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_HMousePressed(evt);
            }
        });
        lbl_key_H.setBounds(300, 70, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_H, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_J.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_J_up.jpg"))); // NOI18N
        lbl_key_J.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_J.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_J.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_J.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_JMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_JMousePressed(evt);
            }
        });
        lbl_key_J.setBounds(350, 70, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_J, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_key_K.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_K_up.jpg"))); // NOI18N
        lbl_key_K.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_key_K.setMaximumSize(new java.awt.Dimension(50, 50));
        lbl_key_K.setPreferredSize(new java.awt.Dimension(50, 50));
        lbl_key_K.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_key_KMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_key_KMousePressed(evt);
            }
        });
        lbl_key_K.setBounds(400, 70, 50, 50);
        jLayeredPanelKeyboard.add(lbl_key_K, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_openPlugboard.setToolTipText("Open Plugboard");
        lbl_openPlugboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_openPlugboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_openPlugboardMouseReleased(evt);
            }
        });
        lbl_openPlugboard.setBounds(180, 180, 120, 20);
        jLayeredPanelKeyboard.add(lbl_openPlugboard, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPanelKeyboard.setBounds(10, 350, 480, 200);
        jLayeredPane1.add(jLayeredPanelKeyboard, javax.swing.JLayeredPane.PALETTE_LAYER);

        jLayeredPaneLampboard.setMaximumSize(new java.awt.Dimension(432, 200));
        jLayeredPaneLampboard.setMinimumSize(new java.awt.Dimension(432, 200));

        lbl_lamp_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_L_off.jpg"))); // NOI18N
        lbl_lamp_L.setBounds(400, 100, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_L, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbl_lamp_L.getAccessibleContext().setAccessibleName("lbl_lamp_Q");

        lbl_lamp_Q.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_Q_off.jpg"))); // NOI18N
        lbl_lamp_Q.setBounds(0, 0, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_Q, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_F_off.jpg"))); // NOI18N
        lbl_lamp_E.setBounds(100, 0, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_E, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_W.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_W_off.jpg"))); // NOI18N
        lbl_lamp_W.setBounds(50, 0, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_W, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_R.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_R_off.jpg"))); // NOI18N
        lbl_lamp_R.setBounds(150, 0, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_R, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_Z.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_Z_off.jpg"))); // NOI18N
        lbl_lamp_Z.setBounds(250, 0, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_Z, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_T.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_T_off.jpg"))); // NOI18N
        lbl_lamp_T.setBounds(200, 0, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_T, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_U.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_U_off.jpg"))); // NOI18N
        lbl_lamp_U.setBounds(300, 0, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_U, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_I_off.jpg"))); // NOI18N
        lbl_lamp_I.setBounds(350, 0, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_I, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_D_off.jpg"))); // NOI18N
        lbl_lamp_D.setBounds(130, 50, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_D, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_B_off.jpg"))); // NOI18N
        lbl_lamp_A.setBounds(30, 50, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_A, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_S_off.jpg"))); // NOI18N
        lbl_lamp_S.setBounds(80, 50, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_S, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_F_off.jpg"))); // NOI18N
        lbl_lamp_F.setBounds(180, 50, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_F, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_G.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_G_off.jpg"))); // NOI18N
        lbl_lamp_G.setBounds(230, 50, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_G, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_H_off.jpg"))); // NOI18N
        lbl_lamp_H.setBounds(280, 50, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_H, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_J.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_J_off.jpg"))); // NOI18N
        lbl_lamp_J.setBounds(330, 50, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_J, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_K.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_K_off.jpg"))); // NOI18N
        lbl_lamp_K.setBounds(380, 50, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_K, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_V.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_V_off.jpg"))); // NOI18N
        lbl_lamp_V.setBounds(200, 100, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_V, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_B_off.jpg"))); // NOI18N
        lbl_lamp_B.setBounds(250, 100, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_B, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_N.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_N_off.jpg"))); // NOI18N
        lbl_lamp_N.setBounds(300, 100, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_N, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_X_off.jpg"))); // NOI18N
        lbl_lamp_X.setBounds(100, 100, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_X, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_P_off.jpg"))); // NOI18N
        lbl_lamp_P.setBounds(0, 100, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_P, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_M.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_M_off.jpg"))); // NOI18N
        lbl_lamp_M.setBounds(350, 100, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_M, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_Y.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_Y_off.jpg"))); // NOI18N
        lbl_lamp_Y.setBounds(50, 100, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_Y, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_C_off.jpg"))); // NOI18N
        lbl_lamp_C.setBounds(150, 100, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_C, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_lamp_O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_O_off.jpg"))); // NOI18N
        lbl_lamp_O.setBounds(400, 0, 48, 48);
        jLayeredPaneLampboard.add(lbl_lamp_O, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPaneLampboard.setBounds(30, 170, 450, 150);
        jLayeredPane1.add(jLayeredPaneLampboard, javax.swing.JLayeredPane.PALETTE_LAYER);

        jLayeredPaneWireDiagram.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("CHARACTER PATH");
        jLabel3.setBounds(20, 350, 110, 14);
        jLayeredPaneWireDiagram.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("PLAIN TEXT");
        jLabel4.setBounds(20, 10, 70, 14);
        jLayeredPaneWireDiagram.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("CYPHER TEXT");
        jLabel5.setBounds(20, 160, 80, 14);
        jLayeredPaneWireDiagram.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtArea_plainTxt.setBackground(new java.awt.Color(51, 51, 51));
        txtArea_plainTxt.setColumns(20);
        txtArea_plainTxt.setEditable(false);
        txtArea_plainTxt.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtArea_plainTxt.setForeground(new java.awt.Color(204, 204, 204));
        txtArea_plainTxt.setLineWrap(true);
        txtArea_plainTxt.setRows(5);
        txtArea_plainTxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        txtArea_plainTxt.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(txtArea_plainTxt);

        jScrollPane2.setBounds(10, 30, 290, 120);
        jLayeredPaneWireDiagram.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtArea_cypherTxt.setBackground(new java.awt.Color(51, 51, 51));
        txtArea_cypherTxt.setColumns(20);
        txtArea_cypherTxt.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtArea_cypherTxt.setForeground(new java.awt.Color(204, 204, 204));
        txtArea_cypherTxt.setRows(5);
        txtArea_cypherTxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        txtArea_cypherTxt.setFocusable(false);
        txtArea_cypherTxt.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(txtArea_cypherTxt);

        jScrollPane3.setBounds(10, 180, 290, 120);
        jLayeredPaneWireDiagram.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Input:");
        jLabel7.setBounds(60, 380, 50, 14);
        jLayeredPaneWireDiagram.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setText("Output:");
        jLabel30.setBounds(180, 380, 50, 14);
        jLayeredPaneWireDiagram.add(jLabel30, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setText("Plug Board:");
        jLabel29.setBounds(20, 410, 70, 14);
        jLayeredPaneWireDiagram.add(jLabel29, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor1_display.setForeground(new java.awt.Color(204, 204, 204));
        lbl_rotor1_display.setText("Rotor: W-26");
        lbl_rotor1_display.setBounds(20, 430, 70, 14);
        jLayeredPaneWireDiagram.add(lbl_rotor1_display, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor2_display.setForeground(new java.awt.Color(204, 204, 204));
        lbl_rotor2_display.setText("Rotor: W-26");
        lbl_rotor2_display.setBounds(20, 450, 70, 14);
        jLayeredPaneWireDiagram.add(lbl_rotor2_display, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_rotor3_display.setForeground(new java.awt.Color(204, 204, 204));
        lbl_rotor3_display.setText("Rotor: W-26");
        lbl_rotor3_display.setBounds(20, 470, 70, 14);
        jLayeredPaneWireDiagram.add(lbl_rotor3_display, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Reflector: A");
        jLabel2.setBounds(20, 490, 70, 14);
        jLayeredPaneWireDiagram.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_pb_in_1.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_pb_in_1.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_pb_in_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_pb_in_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_pb_in_1.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_in_1.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_in_1.setOpaque(true);
        lbl_path_pb_in_1.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_in_1.setBounds(100, 410, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_pb_in_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_pb_in_2.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_pb_in_2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_pb_in_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_pb_in_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_pb_in_2.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_in_2.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_in_2.setOpaque(true);
        lbl_path_pb_in_2.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_in_2.setBounds(190, 410, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_pb_in_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_1_in_1.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_1_in_1.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_1_in_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_1_in_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_1_in_1.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_in_1.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_in_1.setOpaque(true);
        lbl_path_rotor_1_in_1.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_in_1.setBounds(100, 430, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_1_in_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_1_in_2.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_1_in_2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_1_in_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_1_in_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_1_in_2.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_in_2.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_in_2.setOpaque(true);
        lbl_path_rotor_1_in_2.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_in_2.setBounds(150, 430, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_1_in_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_2_in_1.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_2_in_1.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_2_in_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_2_in_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_2_in_1.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_in_1.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_in_1.setOpaque(true);
        lbl_path_rotor_2_in_1.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_in_1.setBounds(100, 450, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_2_in_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_2_in_2.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_2_in_2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_2_in_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_2_in_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_2_in_2.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_in_2.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_in_2.setOpaque(true);
        lbl_path_rotor_2_in_2.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_in_2.setBounds(150, 450, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_2_in_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_3_in_1.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_3_in_1.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_3_in_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_3_in_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_3_in_1.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_in_1.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_in_1.setOpaque(true);
        lbl_path_rotor_3_in_1.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_in_1.setBounds(100, 470, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_3_in_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_3_in_2.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_3_in_2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_3_in_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_3_in_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_3_in_2.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_in_2.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_in_2.setOpaque(true);
        lbl_path_rotor_3_in_2.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_in_2.setBounds(150, 470, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_3_in_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_reflect_1.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_reflect_1.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_reflect_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_reflect_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_reflect_1.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_reflect_1.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_reflect_1.setOpaque(true);
        lbl_path_reflect_1.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_reflect_1.setBounds(150, 490, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_reflect_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_reflect_2.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_reflect_2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_reflect_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_reflect_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_reflect_2.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_reflect_2.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_reflect_2.setOpaque(true);
        lbl_path_reflect_2.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_reflect_2.setBounds(190, 490, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_reflect_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_3_out_1.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_3_out_1.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_3_out_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_3_out_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_3_out_1.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_out_1.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_out_1.setOpaque(true);
        lbl_path_rotor_3_out_1.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_out_1.setBounds(190, 470, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_3_out_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_3_out_2.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_3_out_2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_3_out_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_3_out_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_3_out_2.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_out_2.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_out_2.setOpaque(true);
        lbl_path_rotor_3_out_2.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_3_out_2.setBounds(240, 470, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_3_out_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_2_out_1.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_2_out_1.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_2_out_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_2_out_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_2_out_1.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_out_1.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_out_1.setOpaque(true);
        lbl_path_rotor_2_out_1.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_out_1.setBounds(190, 450, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_2_out_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_2_out_2.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_2_out_2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_2_out_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_2_out_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_2_out_2.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_out_2.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_out_2.setOpaque(true);
        lbl_path_rotor_2_out_2.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_2_out_2.setBounds(240, 450, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_2_out_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_1_out_1.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_1_out_1.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_1_out_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_1_out_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_1_out_1.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_out_1.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_out_1.setOpaque(true);
        lbl_path_rotor_1_out_1.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_out_1.setBounds(190, 430, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_1_out_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_rotor_1_out_2.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_rotor_1_out_2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_rotor_1_out_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_rotor_1_out_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_rotor_1_out_2.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_out_2.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_out_2.setOpaque(true);
        lbl_path_rotor_1_out_2.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_rotor_1_out_2.setBounds(240, 430, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_rotor_1_out_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_pb_out_1.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_pb_out_1.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_pb_out_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_pb_out_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_pb_out_1.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_out_1.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_out_1.setOpaque(true);
        lbl_path_pb_out_1.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_out_1.setBounds(150, 410, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_pb_out_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_pb_out_2.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_pb_out_2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_pb_out_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_pb_out_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_pb_out_2.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_out_2.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_out_2.setOpaque(true);
        lbl_path_pb_out_2.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_pb_out_2.setBounds(240, 410, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_pb_out_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_input.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_input.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_input.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_input.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_input.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_input.setOpaque(true);
        lbl_path_input.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_input.setBounds(110, 380, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_input, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_path_output.setBackground(new java.awt.Color(37, 33, 33));
        lbl_path_output.setForeground(new java.awt.Color(204, 204, 204));
        lbl_path_output.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_path_output.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_path_output.setMaximumSize(new java.awt.Dimension(15, 15));
        lbl_path_output.setMinimumSize(new java.awt.Dimension(15, 15));
        lbl_path_output.setOpaque(true);
        lbl_path_output.setPreferredSize(new java.awt.Dimension(15, 15));
        lbl_path_output.setBounds(230, 380, 20, 15);
        jLayeredPaneWireDiagram.add(lbl_path_output, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_btn_forward.setBackground(new java.awt.Color(255, 204, 0));
        lbl_btn_forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_forward_null.jpg"))); // NOI18N
        lbl_btn_forward.setText("Back");
        lbl_btn_forward.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btn_forward.setOpaque(true);
        lbl_btn_forward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_btn_forwardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_btn_forwardMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_btn_forwardMouseReleased(evt);
            }
        });
        lbl_btn_forward.setBounds(156, 315, 140, 20);
        jLayeredPaneWireDiagram.add(lbl_btn_forward, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_btn_back.setBackground(new java.awt.Color(255, 204, 0));
        lbl_btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_back_null.jpg"))); // NOI18N
        lbl_btn_back.setText("Back");
        lbl_btn_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btn_back.setOpaque(true);
        lbl_btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_btn_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_btn_backMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_btn_backMouseReleased(evt);
            }
        });
        lbl_btn_back.setBounds(14, 315, 140, 20);
        jLayeredPaneWireDiagram.add(lbl_btn_back, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPaneWireDiagram.setBounds(500, 0, 310, 550);
        jLayeredPane1.add(jLayeredPaneWireDiagram, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbl_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GUI.jpg"))); // NOI18N
        lbl_Background.setMaximumSize(new java.awt.Dimension(510, 571));
        lbl_Background.setMinimumSize(new java.awt.Dimension(510, 571));
        lbl_Background.setBounds(0, 0, 500, 550);
        jLayeredPane1.add(lbl_Background, javax.swing.JLayeredPane.PALETTE_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/controls_bg.jpg"))); // NOI18N
        jLabel1.setBounds(500, 0, 310, 550);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void lbl_key_QMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_QMousePressed
        lbl_key_Q.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_Q_down.jpg")));
        setChar('Q');
    }//GEN-LAST:event_lbl_key_QMousePressed

    private void lbl_key_QMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_QMouseReleased
        lbl_key_Q.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_Q_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_QMouseReleased

    private void lbl_key_UMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_UMouseReleased
        lbl_key_U.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_U_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_UMouseReleased

    private void lbl_key_UMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_UMousePressed
        lbl_key_U.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_U_down.jpg")));
        setChar('U');
    }//GEN-LAST:event_lbl_key_UMousePressed

    private void lbl_key_WMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_WMouseReleased
        lbl_key_W.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_W_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_WMouseReleased

    private void lbl_key_WMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_WMousePressed
        lbl_key_W.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_W_down.jpg")));
        setChar('W');
    }//GEN-LAST:event_lbl_key_WMousePressed

    private void lbl_key_EMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_EMouseReleased
        lbl_key_E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_E_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_EMouseReleased

    private void lbl_key_EMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_EMousePressed
        lbl_key_E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_E_down.jpg")));
        setChar('E');
    }//GEN-LAST:event_lbl_key_EMousePressed

    private void lbl_key_RMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_RMouseReleased
        lbl_key_R.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_R_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_RMouseReleased

    private void lbl_key_RMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_RMousePressed
        lbl_key_R.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_R_down.jpg")));
        setChar('R');
    }//GEN-LAST:event_lbl_key_RMousePressed

    private void lbl_key_TMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_TMouseReleased
        lbl_key_T.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_T_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_TMouseReleased

    private void lbl_key_TMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_TMousePressed
        lbl_key_T.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_T_down.jpg")));
        setChar('T');
    }//GEN-LAST:event_lbl_key_TMousePressed

    private void lbl_key_ZMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_ZMouseReleased
        lbl_key_Z.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_Z_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_ZMouseReleased

    private void lbl_key_ZMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_ZMousePressed
        lbl_key_Z.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_Z_down.jpg")));
        setChar('Z');
    }//GEN-LAST:event_lbl_key_ZMousePressed

    private void lbl_key_OMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_OMouseReleased
        lbl_key_O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_O_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_OMouseReleased

    private void lbl_key_OMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_OMousePressed
        lbl_key_O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_O_down.jpg")));
        setChar('O');
    }//GEN-LAST:event_lbl_key_OMousePressed

    private void lbl_key_IMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_IMouseReleased
        lbl_key_I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_I_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_IMouseReleased

    private void lbl_key_IMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_IMousePressed
        lbl_key_I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_I_down.jpg")));
        setChar('I');
    }//GEN-LAST:event_lbl_key_IMousePressed

    private void lbl_key_PMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_PMouseReleased
        lbl_key_P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_P_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_PMouseReleased

    private void lbl_key_PMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_PMousePressed
        lbl_key_P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_P_down.jpg")));
        setChar('P');
    }//GEN-LAST:event_lbl_key_PMousePressed

    private void lbl_key_YMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_YMouseReleased
        lbl_key_Y.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_Y_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_YMouseReleased

    private void lbl_key_YMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_YMousePressed
        lbl_key_Y.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_Y_down.jpg")));
        setChar('Y');
    }//GEN-LAST:event_lbl_key_YMousePressed

    private void lbl_key_XMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_XMouseReleased
        lbl_key_X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_X_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_XMouseReleased

    private void lbl_key_XMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_XMousePressed
        lbl_key_X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_X_down.jpg")));
        setChar('X');
    }//GEN-LAST:event_lbl_key_XMousePressed

    private void lbl_key_CMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_CMouseReleased
        lbl_key_C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_C_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_CMouseReleased

    private void lbl_key_CMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_CMousePressed
        lbl_key_C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_C_down.jpg")));
        setChar('C');
    }//GEN-LAST:event_lbl_key_CMousePressed

    private void lbl_key_VMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_VMouseReleased
        lbl_key_V.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_V_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_VMouseReleased

    private void lbl_key_VMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_VMousePressed
        lbl_key_V.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_V_down.jpg")));
        setChar('V');
    }//GEN-LAST:event_lbl_key_VMousePressed

    private void lbl_key_BMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_BMouseReleased
        lbl_key_B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_B_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_BMouseReleased

    private void lbl_key_BMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_BMousePressed
        lbl_key_B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_B_down.jpg")));
        setChar('B');
    }//GEN-LAST:event_lbl_key_BMousePressed

    private void lbl_key_NMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_NMouseReleased
        lbl_key_N.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_N_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_NMouseReleased

    private void lbl_key_NMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_NMousePressed
        lbl_key_N.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_N_down.jpg")));
        setChar('N');
    }//GEN-LAST:event_lbl_key_NMousePressed

    private void lbl_key_MMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_MMouseReleased
        lbl_key_M.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_M_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_MMouseReleased

    private void lbl_key_MMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_MMousePressed
        lbl_key_M.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_M_down.jpg")));
        setChar('M');
    }//GEN-LAST:event_lbl_key_MMousePressed

    private void lbl_key_LMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_LMouseReleased
        lbl_key_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_L_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_LMouseReleased

    private void lbl_key_LMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_LMousePressed
        lbl_key_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_L_down.jpg")));
        setChar('L');
    }//GEN-LAST:event_lbl_key_LMousePressed

    private void lbl_key_AMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_AMouseReleased
        lbl_key_A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_A_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_AMouseReleased

    private void lbl_key_AMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_AMousePressed
        lbl_key_A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_A_down.jpg")));
        setChar('A');
    }//GEN-LAST:event_lbl_key_AMousePressed

    private void lbl_key_SMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_SMouseReleased
        lbl_key_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_S_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_SMouseReleased

    private void lbl_key_SMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_SMousePressed
        lbl_key_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_S_down.jpg")));
        setChar('S');
    }//GEN-LAST:event_lbl_key_SMousePressed

    private void lbl_key_DMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_DMouseReleased
        lbl_key_D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_D_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_DMouseReleased

    private void lbl_key_DMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_DMousePressed
        lbl_key_D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_D_down.jpg")));
        setChar('D');
    }//GEN-LAST:event_lbl_key_DMousePressed

    private void lbl_key_FMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_FMouseReleased
        lbl_key_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_F_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_FMouseReleased

    private void lbl_key_FMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_FMousePressed
        lbl_key_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_F_down.jpg")));
        setChar('F');
    }//GEN-LAST:event_lbl_key_FMousePressed

    private void lbl_key_GMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_GMouseReleased
        lbl_key_G.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_G_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_GMouseReleased

    private void lbl_key_GMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_GMousePressed
        lbl_key_G.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_G_down.jpg")));
        setChar('G');
    }//GEN-LAST:event_lbl_key_GMousePressed

    private void lbl_key_HMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_HMouseReleased
        lbl_key_H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_H_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_HMouseReleased

    private void lbl_key_HMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_HMousePressed
        lbl_key_H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_H_down.jpg")));
        setChar('H');
    }//GEN-LAST:event_lbl_key_HMousePressed

    private void lbl_key_JMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_JMouseReleased
        lbl_key_J.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_J_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_JMouseReleased

    private void lbl_key_JMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_JMousePressed
        lbl_key_J.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_J_down.jpg")));
        setChar('J');
    }//GEN-LAST:event_lbl_key_JMousePressed

    private void lbl_key_KMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_KMouseReleased
        lbl_key_K.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_K_up.jpg")));
        turnOffLamp();
    }//GEN-LAST:event_lbl_key_KMouseReleased

    private void lbl_key_KMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_key_KMousePressed
        lbl_key_K.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key_K_down.jpg")));
        setChar('K');
    }//GEN-LAST:event_lbl_key_KMousePressed

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void lbl_closePlugboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closePlugboardMousePressed
        jLayeredPaneSettings.setVisible(false);
        jLayeredPaneChangeRotor.setVisible(false);
        jLayeredPanePlugboard.setVisible(false);
        jLayeredPaneRotorDisplay.setVisible(true);
        jLayeredPanelKeyboard.setVisible(true);
        jLayeredPaneLampboard.setVisible(true);
    }//GEN-LAST:event_lbl_closePlugboardMousePressed
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void lbl_plug_in_AMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_AMouseReleased
        setPlugboard('A');
    }//GEN-LAST:event_lbl_plug_in_AMouseReleased

    private void lbl_plug_in_BMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_BMouseReleased
        setPlugboard('B');
    }//GEN-LAST:event_lbl_plug_in_BMouseReleased

    private void lbl_plug_in_CMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_CMouseReleased
        setPlugboard('C');
    }//GEN-LAST:event_lbl_plug_in_CMouseReleased

    private void lbl_plug_out_AMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_AMouseReleased
        setPlugboard('A');
    }//GEN-LAST:event_lbl_plug_out_AMouseReleased

    private void lbl_plug_out_BMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_BMouseReleased
        setPlugboard('B');
    }//GEN-LAST:event_lbl_plug_out_BMouseReleased

    private void lbl_plug_out_CMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_CMouseReleased
        setPlugboard('C');
    }//GEN-LAST:event_lbl_plug_out_CMouseReleased

    private void lbl_plug_out_DMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_DMouseReleased
        setPlugboard('D');
    }//GEN-LAST:event_lbl_plug_out_DMouseReleased

    private void lbl_plug_out_EMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_EMouseReleased
        setPlugboard('E');
    }//GEN-LAST:event_lbl_plug_out_EMouseReleased

    private void lbl_plug_out_FMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_FMouseReleased
        setPlugboard('F');
    }//GEN-LAST:event_lbl_plug_out_FMouseReleased

    private void lbl_plug_out_GMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_GMouseReleased
        setPlugboard('G');
    }//GEN-LAST:event_lbl_plug_out_GMouseReleased

    private void lbl_plug_out_HMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_HMouseReleased
        setPlugboard('H');
    }//GEN-LAST:event_lbl_plug_out_HMouseReleased

    private void lbl_plug_out_IMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_IMouseReleased
        setPlugboard('I');
    }//GEN-LAST:event_lbl_plug_out_IMouseReleased

    private void lbl_plug_out_JMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_JMouseReleased
        setPlugboard('J');
    }//GEN-LAST:event_lbl_plug_out_JMouseReleased

    private void lbl_plug_out_KMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_KMouseReleased
        setPlugboard('K');
    }//GEN-LAST:event_lbl_plug_out_KMouseReleased

    private void lbl_plug_out_LMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_LMouseReleased
        setPlugboard('L');
    }//GEN-LAST:event_lbl_plug_out_LMouseReleased

    private void lbl_plug_out_MMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_MMouseReleased
        setPlugboard('M');
    }//GEN-LAST:event_lbl_plug_out_MMouseReleased

    private void lbl_plug_out_NMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_NMouseReleased
        setPlugboard('N');
    }//GEN-LAST:event_lbl_plug_out_NMouseReleased

    private void lbl_plug_out_OMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_OMouseReleased
        setPlugboard('O');
    }//GEN-LAST:event_lbl_plug_out_OMouseReleased

    private void lbl_plug_out_PMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_PMouseReleased
        setPlugboard('P');
    }//GEN-LAST:event_lbl_plug_out_PMouseReleased

    private void lbl_plug_out_QMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_QMouseReleased
        setPlugboard('Q');
    }//GEN-LAST:event_lbl_plug_out_QMouseReleased

    private void lbl_plug_out_RMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_RMouseReleased
        setPlugboard('R');
    }//GEN-LAST:event_lbl_plug_out_RMouseReleased

    private void lbl_plug_out_SMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_SMouseReleased
        setPlugboard('S');
    }//GEN-LAST:event_lbl_plug_out_SMouseReleased

    private void lbl_plug_out_TMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_TMouseReleased
        setPlugboard('T');
    }//GEN-LAST:event_lbl_plug_out_TMouseReleased

    private void lbl_plug_out_UMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_UMouseReleased
        setPlugboard('U');
    }//GEN-LAST:event_lbl_plug_out_UMouseReleased

    private void lbl_plug_out_VMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_VMouseReleased
        setPlugboard('V');
    }//GEN-LAST:event_lbl_plug_out_VMouseReleased

    private void lbl_plug_out_WMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_WMouseReleased
        setPlugboard('W');
    }//GEN-LAST:event_lbl_plug_out_WMouseReleased

    private void lbl_plug_out_XMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_XMouseReleased
        setPlugboard('X');
    }//GEN-LAST:event_lbl_plug_out_XMouseReleased

    private void lbl_plug_out_YMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_YMouseReleased
        setPlugboard('Y');
    }//GEN-LAST:event_lbl_plug_out_YMouseReleased

    private void lbl_plug_out_ZMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_out_ZMouseReleased
        setPlugboard('Z');
    }//GEN-LAST:event_lbl_plug_out_ZMouseReleased

    private void lbl_plug_in_DMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_DMouseReleased
        setPlugboard('D');
    }//GEN-LAST:event_lbl_plug_in_DMouseReleased

    private void lbl_plug_in_EMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_EMouseReleased
        setPlugboard('E');
    }//GEN-LAST:event_lbl_plug_in_EMouseReleased

    private void lbl_plug_in_FMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_FMouseReleased
        setPlugboard('F');
    }//GEN-LAST:event_lbl_plug_in_FMouseReleased

    private void lbl_plug_in_GMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_GMouseReleased
        setPlugboard('G');
    }//GEN-LAST:event_lbl_plug_in_GMouseReleased

    private void lbl_plug_in_HMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_HMouseReleased
        setPlugboard('H');
    }//GEN-LAST:event_lbl_plug_in_HMouseReleased

    private void lbl_plug_in_IMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_IMouseReleased
        setPlugboard('I');
    }//GEN-LAST:event_lbl_plug_in_IMouseReleased

    private void lbl_plug_in_JMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_JMouseReleased
        setPlugboard('J');
    }//GEN-LAST:event_lbl_plug_in_JMouseReleased

    private void lbl_plug_in_KMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_KMouseReleased
        setPlugboard('K');
    }//GEN-LAST:event_lbl_plug_in_KMouseReleased

    private void lbl_plug_in_LMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_LMouseReleased
        setPlugboard('L');
    }//GEN-LAST:event_lbl_plug_in_LMouseReleased

    private void lbl_plug_in_MMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_MMouseReleased
        setPlugboard('M');
    }//GEN-LAST:event_lbl_plug_in_MMouseReleased

    private void lbl_plug_in_NMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_NMouseReleased
        setPlugboard('N');
    }//GEN-LAST:event_lbl_plug_in_NMouseReleased

    private void lbl_plug_in_OMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_OMouseReleased
        setPlugboard('O');
    }//GEN-LAST:event_lbl_plug_in_OMouseReleased

    private void lbl_plug_in_PMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_PMouseReleased
        setPlugboard('P');
    }//GEN-LAST:event_lbl_plug_in_PMouseReleased

    private void lbl_plug_in_QMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_QMouseReleased
        setPlugboard('Q');
    }//GEN-LAST:event_lbl_plug_in_QMouseReleased

    private void lbl_plug_in_RMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_RMouseReleased
        setPlugboard('R');
    }//GEN-LAST:event_lbl_plug_in_RMouseReleased

    private void lbl_plug_in_SMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_SMouseReleased
        setPlugboard('S');
    }//GEN-LAST:event_lbl_plug_in_SMouseReleased

    private void lbl_plug_in_TMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_TMouseReleased
        setPlugboard('T');
    }//GEN-LAST:event_lbl_plug_in_TMouseReleased

    private void lbl_plug_in_UMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_UMouseReleased
        setPlugboard('U');
    }//GEN-LAST:event_lbl_plug_in_UMouseReleased

    private void lbl_plug_in_VMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_VMouseReleased
        setPlugboard('V');
    }//GEN-LAST:event_lbl_plug_in_VMouseReleased

    private void lbl_plug_in_WMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_WMouseReleased
        setPlugboard('W');
    }//GEN-LAST:event_lbl_plug_in_WMouseReleased

    private void lbl_plug_in_XMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_XMouseReleased
        setPlugboard('X');
    }//GEN-LAST:event_lbl_plug_in_XMouseReleased

    private void lbl_plug_in_YMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_YMouseReleased
        setPlugboard('Y');
    }//GEN-LAST:event_lbl_plug_in_YMouseReleased

    private void lbl_plug_in_ZMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plug_in_ZMouseReleased
        setPlugboard('Z');
    }//GEN-LAST:event_lbl_plug_in_ZMouseReleased
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void lbl_Rotor_1_dial_topMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Rotor_1_dial_topMousePressed
        controller.setRotorForward(1);
        updateDisplay();
    }//GEN-LAST:event_lbl_Rotor_1_dial_topMousePressed

    private void lbl_Rotor_2_dial_topMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Rotor_2_dial_topMousePressed
        controller.setRotorForward(2);
        updateDisplay();
    }//GEN-LAST:event_lbl_Rotor_2_dial_topMousePressed

    private void lbl_Rotor_1_dial_bottomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Rotor_1_dial_bottomMousePressed
        controller.setRotorBackward(1);
        updateDisplay();
    }//GEN-LAST:event_lbl_Rotor_1_dial_bottomMousePressed

    private void lbl_Rotor_2_dial_bottomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Rotor_2_dial_bottomMousePressed
        controller.setRotorBackward(2);
        updateDisplay();
    }//GEN-LAST:event_lbl_Rotor_2_dial_bottomMousePressed

    private void lbl_openPlugboardMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_openPlugboardMouseReleased
        jLayeredPaneSettings.setVisible(false);
        jLayeredPaneChangeRotor.setVisible(false);
        jLayeredPanePlugboard.setVisible(true);
        jLayeredPaneRotorDisplay.setVisible(true);
        jLayeredPanelKeyboard.setVisible(false);
        jLayeredPaneLampboard.setVisible(true);
    }//GEN-LAST:event_lbl_openPlugboardMouseReleased

    private void lbl_Rotor_3_dial_bottomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Rotor_3_dial_bottomMousePressed
        controller.setRotorBackward(3);
        updateDisplay();
    }//GEN-LAST:event_lbl_Rotor_3_dial_bottomMousePressed

    private void lbl_Rotor_3_dial_topMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Rotor_3_dial_topMousePressed
        controller.setRotorForward(3);
        updateDisplay();
    }//GEN-LAST:event_lbl_Rotor_3_dial_topMousePressed

    private void lbl_btn_forwardMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_forwardMouseReleased
        // TODO add your handling code here:
        if (controller.getForwardDisabled()==false){
            controller.forward();
            updateDisplay();
        }
    }//GEN-LAST:event_lbl_btn_forwardMouseReleased

    private void lbl_btn_backMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_backMouseReleased
        // TODO add your handling code here:
        if (controller.getBackDisabled()==false){
            controller.back();
            updateDisplay();
        }
    }//GEN-LAST:event_lbl_btn_backMouseReleased

    private void lbl_btn_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_backMouseEntered
        // TODO add your handling code here:
        if (controller.getBackDisabled()==false){
            lbl_btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_back_down.jpg")));
        }
        else {
            lbl_btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_back_null.jpg"))); 
        }
    }//GEN-LAST:event_lbl_btn_backMouseEntered

    private void lbl_btn_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_backMouseExited
        // TODO add your handling code here:
        if (controller.getBackDisabled()==false){
            lbl_btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_back_up.jpg")));
        }
        else {
            lbl_btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_back_null.jpg"))); 
        }
    }//GEN-LAST:event_lbl_btn_backMouseExited

    private void lbl_btn_forwardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_forwardMouseEntered
        // TODO add your handling code here:
        if (controller.getForwardDisabled()==false){
            lbl_btn_forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_forward_down.jpg")));
        }
        else {
            lbl_btn_forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_forward_null.jpg"))); 
        }
    }//GEN-LAST:event_lbl_btn_forwardMouseEntered

    private void lbl_btn_forwardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btn_forwardMouseExited
        // TODO add your handling code here:
        if (controller.getForwardDisabled()==false){
            lbl_btn_forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_forward_up.jpg")));
        }
        else {
            lbl_btn_forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_forward_null.jpg"))); 
        }
    }//GEN-LAST:event_lbl_btn_forwardMouseExited

    private void lbl_rotor_changeRingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotor_changeRingMouseReleased
        // TODO add your handling code here:
        updateRotorChange(m_wrkRotorNum);
    }//GEN-LAST:event_lbl_rotor_changeRingMouseReleased

    private void lbl_rotorIIIMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorIIIMouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = m_rotorNum_3;
            lbl_rotorIII.setVisible(false);
            m_rotorStandBy=true;
            m_rotorNum_3=-1;
            m_rotorSet_3=false;
            lbl_rotor3_display.setText("Rotor: ");
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorIIIMouseReleased

    private void lbl_rotorIIMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorIIMouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = m_rotorNum_2;
            lbl_rotorII.setVisible(false);
            m_rotorStandBy=true;
            m_rotorNum_2=-1;
            m_rotorSet_2=false;
            lbl_rotor2_display.setText("Rotor: ");
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorIIMouseReleased

    private void lbl_rotorIMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorIMouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = m_rotorNum_1;
            lbl_rotorI.setVisible(false);
            m_rotorStandBy=true;
            m_rotorNum_1=-1;
            m_rotorSet_1=false;
            lbl_rotor1_display.setText("Rotor: ");
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorIMouseReleased

    private void lbl_rotorWheel_holdTray_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorWheel_holdTray_1MouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = 1;
            m_rotorHold_1=false;
            m_rotorStandBy=true;
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorWheel_holdTray_1MouseReleased

    private void lbl_rotorWheel_holdTray_2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorWheel_holdTray_2MouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = 2;
            m_rotorHold_2=false;
            m_rotorStandBy=true;
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorWheel_holdTray_2MouseReleased

    private void lbl_rotorWheel_holdTray_3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorWheel_holdTray_3MouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = 3;
            m_rotorHold_3=false;
            m_rotorStandBy=true;
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorWheel_holdTray_3MouseReleased

    private void lbl_rotorWheel_holdTray_4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorWheel_holdTray_4MouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = 4;
            m_rotorHold_4=false;
            m_rotorStandBy=true;
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorWheel_holdTray_4MouseReleased

    private void lbl_rotorWheel_holdTray_5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorWheel_holdTray_5MouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = 5;
            m_rotorHold_5=false;
            m_rotorStandBy=true;
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorWheel_holdTray_5MouseReleased

    private void lbl_rotorWheel_holdTray_6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorWheel_holdTray_6MouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = 6;
            m_rotorHold_6=false;
            m_rotorStandBy=true;
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorWheel_holdTray_6MouseReleased

    private void lbl_rotorWheel_holdTray_7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorWheel_holdTray_7MouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = 7;
            m_rotorHold_7=false;
            m_rotorStandBy=true;
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorWheel_holdTray_7MouseReleased

    private void lbl_rotorWheel_holdTray_8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorWheel_holdTray_8MouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = 8;
            m_rotorHold_8=false;
            m_rotorStandBy=true;
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorWheel_holdTray_8MouseReleased

    private void lbl_rotorWheel_holdTray_9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorWheel_holdTray_9MouseReleased
        if (m_rotorStandBy == false) {
            m_wrkRotorNum = 9;
            m_rotorHold_9=false;
            m_rotorStandBy=true;
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotorWheel_holdTray_9MouseReleased

    private void lbl_rotorTrayBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotorTrayBtnMouseReleased
        if (m_rotorStandBy == true) {
            if (m_wrkRotorNum==1) {
                m_rotorHold_1=true;
            }
            else if (m_wrkRotorNum==2) {
                m_rotorHold_2=true;
            }
            else if (m_wrkRotorNum==3) {
                m_rotorHold_3=true;
            }
            else if (m_wrkRotorNum==4) {
                m_rotorHold_4=true;
            }
            else if (m_wrkRotorNum==5) {
                m_rotorHold_5=true;
            }
            else if (m_wrkRotorNum==6) {
                m_rotorHold_6=true;
            }
            else if (m_wrkRotorNum==7) {
                m_rotorHold_7=true;
            }
            else if (m_wrkRotorNum==8) {
                m_rotorHold_8=true;
            }
            else if (m_wrkRotorNum==9) {
                m_rotorHold_9=true;
            }
            m_rotorStandBy=false;
        }       
        updateRotorChange(m_wrkRotorNum);
    }//GEN-LAST:event_lbl_rotorTrayBtnMouseReleased

    private void lbl_rotor_empty_3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotor_empty_3MouseReleased
        if (m_rotorStandBy==true && m_rotorSet_3==false) {
            lbl_rotorIII.setVisible(true);
            m_rotorNum_3 = m_wrkRotorNum;
            m_rotorStandBy=false;
            m_rotorSet_3=true;
            m_ringSetNum_3 = m_wrkRingNum;
            lbl_rotor3_display.setText("Rotor: " + m_rotorNum_3+"-"+(m_ringSetNum_3+1));
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotor_empty_3MouseReleased

    private void lbl_rotor_empty_2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotor_empty_2MouseReleased
        if (m_rotorStandBy==true && m_rotorSet_2==false) {
            lbl_rotorII.setVisible(true);
            m_rotorNum_2 = m_wrkRotorNum;
            m_rotorStandBy=false;
            m_rotorSet_2=true;
            m_ringSetNum_2 = m_wrkRingNum;
            lbl_rotor2_display.setText("Rotor: " + m_rotorNum_2+"-"+(m_ringSetNum_2+1));
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotor_empty_2MouseReleased

    private void lbl_rotor_empty_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_rotor_empty_1MouseReleased
        if (m_rotorStandBy==true && m_rotorSet_1==false) {
            lbl_rotorI.setVisible(true);
            m_rotorNum_1 = m_wrkRotorNum;
            m_rotorStandBy=false;
            m_rotorSet_1=true;
            m_ringSetNum_1 = m_wrkRingNum;
            lbl_rotor1_display.setText("Rotor: " + m_rotorNum_1+"-"+(m_ringSetNum_1+1));
            updateRotorChange(m_wrkRotorNum);
        }
    }//GEN-LAST:event_lbl_rotor_empty_1MouseReleased

    private void lbl_ring_upMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ring_upMouseReleased
         if (m_rotorStandBy==true) {
            if (m_wrkRotorNum==1) {
                m_rotor_ring_1++;
                if (m_rotor_ring_1%26==0)m_rotor_ring_1=0;
                m_wrkRingNum=m_rotor_ring_1;
            }
            else if (m_wrkRotorNum==2) {
                m_rotor_ring_2++;
                if (m_rotor_ring_2%26==0)m_rotor_ring_2=0;
                m_wrkRingNum=m_rotor_ring_2;
            }
            else if (m_wrkRotorNum==3) {
                m_rotor_ring_3++;
                if (m_rotor_ring_3%26==0)m_rotor_ring_3=0;
                m_wrkRingNum=m_rotor_ring_3;
            }
            else if (m_wrkRotorNum==4) {
                m_rotor_ring_4++;
                if (m_rotor_ring_4%26==0)m_rotor_ring_4=0;
                m_wrkRingNum=m_rotor_ring_4;
            }
            else if (m_wrkRotorNum==5) {
                m_rotor_ring_5++;
                if (m_rotor_ring_5%26==0)m_rotor_ring_5=0;
                m_wrkRingNum=m_rotor_ring_5;
            }
            else if (m_wrkRotorNum==6) {
                m_rotor_ring_6++;
                if (m_rotor_ring_6%26==0)m_rotor_ring_6=0;
                m_wrkRingNum=m_rotor_ring_6;
            }
            else if (m_wrkRotorNum==7) {
                m_rotor_ring_7++;
                if (m_rotor_ring_7%26==0)m_rotor_ring_7=0;
                m_wrkRingNum=m_rotor_ring_7;
            }
            else if (m_wrkRotorNum==8) {
                m_rotor_ring_8++;
                if (m_rotor_ring_8%26==0)m_rotor_ring_8=0;
                m_wrkRingNum=m_rotor_ring_8;
            }
            else if (m_wrkRotorNum==9) {
                m_rotor_ring_9++;
                if (m_rotor_ring_9%26==0)m_rotor_ring_9=0;
                m_wrkRingNum=m_rotor_ring_9;
            }
            updateRotorChange(m_wrkRotorNum);
         }
    }//GEN-LAST:event_lbl_ring_upMouseReleased

    private void lbl_ring_downMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ring_downMouseReleased
         if (m_rotorStandBy==true) {
            if (m_wrkRotorNum==1) {
                m_rotor_ring_1--;
                if (m_rotor_ring_1==-1)m_rotor_ring_1=25;
            }
            else if (m_wrkRotorNum==2) {
                m_rotor_ring_2--;
                if (m_rotor_ring_2==-1)m_rotor_ring_2=25;
            }
            else if (m_wrkRotorNum==3) {
                m_rotor_ring_3--;
                if (m_rotor_ring_3==-1)m_rotor_ring_3=25;
            }
            else if (m_wrkRotorNum==4) {
                m_rotor_ring_4--;
                if (m_rotor_ring_4==-1)m_rotor_ring_4=25;
            }
            else if (m_wrkRotorNum==5) {
                m_rotor_ring_5--;
                if (m_rotor_ring_5==-1)m_rotor_ring_5=25;
            }
            else if (m_wrkRotorNum==6) {
                m_rotor_ring_6--;
                if (m_rotor_ring_6==-1)m_rotor_ring_6=25;
            }
            else if (m_wrkRotorNum==7) {
                m_rotor_ring_7--;
                if (m_rotor_ring_7==-1)m_rotor_ring_8=25;
            }
            else if (m_wrkRotorNum==8) {
                m_rotor_ring_8--;
                if (m_rotor_ring_8==-1)m_rotor_ring_8=25;
            }
            else if (m_wrkRotorNum==9) {
                m_rotor_ring_9--;
                if (m_rotor_ring_9==-1)m_rotor_ring_9=25;
            }
            updateRotorChange(m_wrkRotorNum);
         }
    }//GEN-LAST:event_lbl_ring_downMouseReleased

    private void lbl_closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseReleased
        if (m_rotorStandBy==false && m_rotorSet_1 == true && m_rotorSet_2 == true && m_rotorSet_3 == true) {
            jLayeredPaneChangeRotor.setVisible(false);
            jLayeredPaneRotorDisplay.setVisible(true);
            jLayeredPanelKeyboard.setVisible(true);
            jLayeredPaneLampboard.setVisible(true);
            jLayeredPaneSettings.setVisible(false);

            m_aryRotorSettingsVals[0] = m_rotorNum_1; // Which rotor number is for the fastest rotor?
            m_aryRotorSettingsVals[1] = m_rotorNum_2; // Which rotor number is for the medium rotor?
            m_aryRotorSettingsVals[2] = m_rotorNum_3; // Which rotor number is for the slow rotor?
            m_aryRotorSettingsVals[3] = 0; // Which rotor number is for the slowest rotor, if it exists?
            m_aryRotorSettingsVals[4] = 0; // Starting position of rotor 1
            m_aryRotorSettingsVals[5] = 0; // Starting position of rotor 2
            m_aryRotorSettingsVals[6] = 0; // Starting position of rotor 3
            m_aryRotorSettingsVals[7] = 0; // Starting position of rotor 4
            m_aryRotorSettingsVals[8] = m_ringSetNum_1; // Starting position of ring 1
            m_aryRotorSettingsVals[9] = m_ringSetNum_2; // Starting position of ring 2
            m_aryRotorSettingsVals[10] = m_ringSetNum_3; // Starting position of ring 3
            m_aryRotorSettingsVals[11] = 0; // Starting position of ring 4
            controller.setRotorSettingVals(m_aryRotorSettingsVals);
            txtArea_cypherTxt.setText("");
            txtArea_plainTxt.setText("");
            updateDisplay();
        }
    }//GEN-LAST:event_lbl_closeMouseReleased

    private void lbl_openKnobMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_openKnobMouseReleased
        jLayeredPaneSettings.setVisible(true);
        jLayeredPaneChangeRotor.setVisible(true);
        jLayeredPaneRotorDisplay.setVisible(false);
        jLayeredPanelKeyboard.setVisible(false);
        jLayeredPaneLampboard.setVisible(true);
    }//GEN-LAST:event_lbl_openKnobMouseReleased

    private void setChar(char c) {
        controller.setInputChar(c);
        turnOnLamp(controller.getOutputChar());
        updateDisplay();
    }

    private void setPlugboard(char c) {
        controller.setPlugboard(c);
        updatePlugboard();
    }
    private void updateRotorChange(int wrkNum) {
        if (m_rotorStandBy==true) {
            m_wrkRotorNum = wrkNum;
            m_rotorStandBy=true;
        }
        updateDisplay();
    }
    private void updatePlugboard() {
        char[][] m_aryPlugboard = controller.getPlugAry();
            //Set 'A'
            if (m_aryPlugboard[0][1] == 'A' || m_aryPlugboard[0][1] == 'Y') {
                lbl_plug_in_A.setText(String.valueOf(m_aryPlugboard[0][0]));
                lbl_plug_out_A.setText(String.valueOf(m_aryPlugboard[0][2]));
            } else {
                lbl_plug_in_A.setText("");
                lbl_plug_out_A.setText("");
            }
            //Set 'B'
            if (m_aryPlugboard[1][1] == 'A' || m_aryPlugboard[1][1] == 'Y') {
                lbl_plug_in_B.setText(String.valueOf(m_aryPlugboard[1][0]));
                lbl_plug_out_B.setText(String.valueOf(m_aryPlugboard[1][2]));
            } else {
                lbl_plug_in_B.setText("");
                lbl_plug_out_B.setText("");
            }
            //Set 'C'
            if (m_aryPlugboard[2][1] == 'A' || m_aryPlugboard[2][1] == 'Y') {
                lbl_plug_in_C.setText(String.valueOf(m_aryPlugboard[2][0]));
                lbl_plug_out_C.setText(String.valueOf(m_aryPlugboard[2][2]));
            } else {
                lbl_plug_in_C.setText("");
                lbl_plug_out_C.setText("");
            }
            //Set 'D'
            if (m_aryPlugboard[3][1] == 'A' || m_aryPlugboard[3][1] == 'Y') {
                lbl_plug_in_D.setText(String.valueOf(m_aryPlugboard[3][0]));
                lbl_plug_out_D.setText(String.valueOf(m_aryPlugboard[3][2]));
            } else {
                lbl_plug_in_D.setText("");
                lbl_plug_out_D.setText("");
            }
            //Set 'E'
            if (m_aryPlugboard[4][1] == 'A' || m_aryPlugboard[4][1] == 'Y') {
                lbl_plug_in_E.setText(String.valueOf(m_aryPlugboard[4][0]));
                lbl_plug_out_E.setText(String.valueOf(m_aryPlugboard[4][2]));
            } else {
                lbl_plug_in_E.setText("");
                lbl_plug_out_E.setText("");
            }
            //Set 'F'
            if (m_aryPlugboard[5][1] == 'A' || m_aryPlugboard[5][1] == 'Y') {
                lbl_plug_in_F.setText(String.valueOf(m_aryPlugboard[5][0]));
                lbl_plug_out_F.setText(String.valueOf(m_aryPlugboard[5][2]));
            } else {
                lbl_plug_in_F.setText("");
                lbl_plug_out_F.setText("");
            }
            //Set 'G'
            if (m_aryPlugboard[6][1] == 'A' || m_aryPlugboard[6][1] == 'Y') {
                lbl_plug_in_G.setText(String.valueOf(m_aryPlugboard[6][0]));
                lbl_plug_out_G.setText(String.valueOf(m_aryPlugboard[6][2]));
            } else {
                lbl_plug_in_G.setText("");
                lbl_plug_out_G.setText("");
            }
            //Set 'H'
            if (m_aryPlugboard[7][1] == 'A' || m_aryPlugboard[7][1] == 'Y') {
                lbl_plug_in_H.setText(String.valueOf(m_aryPlugboard[7][0]));
                lbl_plug_out_H.setText(String.valueOf(m_aryPlugboard[7][2]));
            } else {
                lbl_plug_in_H.setText("");
                lbl_plug_out_H.setText("");
            }
            //Set 'I'
            if (m_aryPlugboard[8][1] == 'A' || m_aryPlugboard[8][1] == 'Y') {
                lbl_plug_in_I.setText(String.valueOf(m_aryPlugboard[8][0]));
                lbl_plug_out_I.setText(String.valueOf(m_aryPlugboard[8][2]));
            } else {
                lbl_plug_in_I.setText("");
                lbl_plug_out_I.setText("");
            }
            //Set 'J'
            if (m_aryPlugboard[9][1] == 'A' || m_aryPlugboard[9][1] == 'Y') {
                lbl_plug_in_J.setText(String.valueOf(m_aryPlugboard[9][0]));
                lbl_plug_out_J.setText(String.valueOf(m_aryPlugboard[9][2]));
            } else {
                lbl_plug_in_J.setText("");
                lbl_plug_out_J.setText("");
            }
            //Set 'K'
            if (m_aryPlugboard[10][1] == 'A' || m_aryPlugboard[10][1] == 'Y') {
                lbl_plug_in_K.setText(String.valueOf(m_aryPlugboard[10][0]));
                lbl_plug_out_K.setText(String.valueOf(m_aryPlugboard[10][2]));
            } else {
                lbl_plug_in_K.setText("");
                lbl_plug_out_K.setText("");
            }
            //Set 'L'
            if (m_aryPlugboard[11][1] == 'A' || m_aryPlugboard[11][1] == 'Y') {
                lbl_plug_in_L.setText(String.valueOf(m_aryPlugboard[11][0]));
                lbl_plug_out_L.setText(String.valueOf(m_aryPlugboard[11][2]));
            } else {
                lbl_plug_in_L.setText("");
                lbl_plug_out_L.setText("");
            }
            //Set 'M'
            if (m_aryPlugboard[12][1] == 'A' || m_aryPlugboard[12][1] == 'Y') {
                lbl_plug_in_M.setText(String.valueOf(m_aryPlugboard[12][0]));
                lbl_plug_out_M.setText(String.valueOf(m_aryPlugboard[12][2]));
            } else {
                lbl_plug_in_M.setText("");
                lbl_plug_out_M.setText("");
            }
            //Set 'N'
            if (m_aryPlugboard[13][1] == 'A' || m_aryPlugboard[13][1] == 'Y') {
                lbl_plug_in_N.setText(String.valueOf(m_aryPlugboard[13][0]));
                lbl_plug_out_N.setText(String.valueOf(m_aryPlugboard[13][2]));
            } else {
                lbl_plug_in_N.setText("");
                lbl_plug_out_N.setText("");
            }
            //Set 'O'
            if (m_aryPlugboard[14][1] == 'A' || m_aryPlugboard[14][1] == 'Y') {
                lbl_plug_in_O.setText(String.valueOf(m_aryPlugboard[14][0]));
                lbl_plug_out_O.setText(String.valueOf(m_aryPlugboard[14][2]));
            } else {
                lbl_plug_in_O.setText("");
                lbl_plug_out_O.setText("");
            }
            //Set 'P'
            if (m_aryPlugboard[15][1] == 'A' || m_aryPlugboard[15][1] == 'Y') {
                lbl_plug_in_P.setText(String.valueOf(m_aryPlugboard[15][0]));
                lbl_plug_out_P.setText(String.valueOf(m_aryPlugboard[15][2]));
            } else {
                lbl_plug_in_P.setText("");
                lbl_plug_out_P.setText("");
            }
            //Set 'Q'
            if (m_aryPlugboard[16][1] == 'A' || m_aryPlugboard[16][1] == 'Y') {
                lbl_plug_in_Q.setText(String.valueOf(m_aryPlugboard[16][0]));
                lbl_plug_out_Q.setText(String.valueOf(m_aryPlugboard[16][2]));
            } else {
                lbl_plug_in_Q.setText("");
                lbl_plug_out_Q.setText("");
            }
            //Set 'R'
            if (m_aryPlugboard[17][1] == 'A' || m_aryPlugboard[17][1] == 'Y') {
                lbl_plug_in_R.setText(String.valueOf(m_aryPlugboard[17][0]));
                lbl_plug_out_R.setText(String.valueOf(m_aryPlugboard[17][2]));
            } else {
                lbl_plug_in_R.setText("");
                lbl_plug_out_R.setText("");
            }
            //Set 'S'
            if (m_aryPlugboard[18][1] == 'A' || m_aryPlugboard[18][1] == 'Y') {
                lbl_plug_in_S.setText(String.valueOf(m_aryPlugboard[18][0]));
                lbl_plug_out_S.setText(String.valueOf(m_aryPlugboard[18][2]));
            } else {
                lbl_plug_in_S.setText("");
                lbl_plug_out_S.setText("");
            }
            //Set 'T'
            if (m_aryPlugboard[19][1] == 'A' || m_aryPlugboard[19][1] == 'Y') {
                lbl_plug_in_T.setText(String.valueOf(m_aryPlugboard[19][0]));
                lbl_plug_out_T.setText(String.valueOf(m_aryPlugboard[19][2]));
            } else {
                lbl_plug_in_T.setText("");
                lbl_plug_out_T.setText("");
            }
            //Set 'U'
            if (m_aryPlugboard[20][1] == 'A' || m_aryPlugboard[20][1] == 'Y') {
                lbl_plug_in_U.setText(String.valueOf(m_aryPlugboard[20][0]));
                lbl_plug_out_U.setText(String.valueOf(m_aryPlugboard[20][2]));
            } else {
                lbl_plug_in_U.setText("");
                lbl_plug_out_U.setText("");
            }
            //Set 'V'
            if (m_aryPlugboard[21][1] == 'A' || m_aryPlugboard[21][1] == 'Y') {
                lbl_plug_in_V.setText(String.valueOf(m_aryPlugboard[21][0]));
                lbl_plug_out_V.setText(String.valueOf(m_aryPlugboard[21][2]));
            } else {
                lbl_plug_in_V.setText("");
                lbl_plug_out_V.setText("");
            }
            //Set 'W'
            if (m_aryPlugboard[22][1] == 'A' || m_aryPlugboard[22][1] == 'Y') {
                lbl_plug_in_W.setText(String.valueOf(m_aryPlugboard[22][0]));
                lbl_plug_out_W.setText(String.valueOf(m_aryPlugboard[22][2]));
            } else {
                lbl_plug_in_W.setText("");
                lbl_plug_out_W.setText("");
            }
            //Set 'X'
            if (m_aryPlugboard[23][1] == 'A' || m_aryPlugboard[23][1] == 'Y') {
                lbl_plug_in_X.setText(String.valueOf(m_aryPlugboard[23][0]));
                lbl_plug_out_X.setText(String.valueOf(m_aryPlugboard[23][2]));
            } else {
                lbl_plug_in_X.setText("");
                lbl_plug_out_X.setText("");
            }
            //Set 'Y'
            if (m_aryPlugboard[24][1] == 'A' || m_aryPlugboard[24][1] == 'Y') {
                lbl_plug_in_Y.setText(String.valueOf(m_aryPlugboard[24][0]));
                lbl_plug_out_Y.setText(String.valueOf(m_aryPlugboard[24][2]));
            } else {
                lbl_plug_in_Y.setText("");
                lbl_plug_out_Y.setText("");
            }
            //Set 'Z'
            if (m_aryPlugboard[25][1] == 'A' || m_aryPlugboard[25][1] == 'Y') {
                lbl_plug_in_Z.setText(String.valueOf(m_aryPlugboard[25][0]));
                lbl_plug_out_Z.setText(String.valueOf(m_aryPlugboard[25][2]));
            } else {
                lbl_plug_in_Z.setText("");
                lbl_plug_out_Z.setText("");
            }
    }

    private void turnOnLamp(char c) {
            switch (c) {
                case 'A':
                    lbl_lamp_A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_A_on.jpg")));
                    break;
                case 'B':
                    lbl_lamp_B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_B_on.jpg")));
                    break;
                case 'C':
                    lbl_lamp_C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_C_on.jpg")));
                    break;
                case 'D':
                    lbl_lamp_D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_D_on.jpg")));
                    break;
                case 'E':
                    lbl_lamp_E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_E_on.jpg")));
                    break;
                case 'F':
                    lbl_lamp_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_F_on.jpg")));
                    break;
                case 'G':
                    lbl_lamp_G.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_G_on.jpg")));
                    break;
                case 'H':
                    lbl_lamp_H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_H_on.jpg")));
                    break;
                case 'I':
                    lbl_lamp_I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_I_on.jpg")));
                    break;
                case 'J':
                    lbl_lamp_J.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_J_on.jpg")));
                    break;
                case 'K':
                    lbl_lamp_K.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_K_on.jpg")));
                    break;
                case 'L':
                    lbl_lamp_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_L_on.jpg")));
                    break;
                case 'M':
                    lbl_lamp_M.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_M_on.jpg")));
                    break;
                case 'N':
                    lbl_lamp_N.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_N_on.jpg")));
                    break;
                case 'O':
                    lbl_lamp_O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_O_on.jpg")));
                    break;
                case 'P':
                    lbl_lamp_P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_P_on.jpg")));
                    break;
                case 'Q':
                    lbl_lamp_Q.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_Q_on.jpg")));
                    break;
                case 'R':
                    lbl_lamp_R.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_R_on.jpg")));
                    break;
                case 'S':
                    lbl_lamp_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_S_on.jpg")));
                    break;
                case 'T':
                    lbl_lamp_T.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_T_on.jpg")));
                    break;
                case 'U':
                    lbl_lamp_U.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_U_on.jpg")));
                    break;
                case 'V':
                    lbl_lamp_V.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_V_on.jpg")));
                    break;
                case 'W':
                    lbl_lamp_W.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_W_on.jpg")));
                    break;
                case 'X':
                    lbl_lamp_X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_X_on.jpg")));
                    break;
                case 'Y':
                    lbl_lamp_Y.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_Y_on.jpg")));
                    break;
                case 'Z':
                    lbl_lamp_Z.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_Z_on.jpg")));
                    break;
                default:
                    ;
                    break;
            }
    }

    private void turnOffLamp() {
        lbl_lamp_A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_A_off.jpg")));
        lbl_lamp_B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_B_off.jpg")));
        lbl_lamp_C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_C_off.jpg")));
        lbl_lamp_D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_D_off.jpg")));
        lbl_lamp_E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_E_off.jpg")));
        lbl_lamp_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_F_off.jpg")));
        lbl_lamp_G.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_G_off.jpg")));
        lbl_lamp_H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_H_off.jpg")));
        lbl_lamp_I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_I_off.jpg")));
        lbl_lamp_J.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_J_off.jpg")));
        lbl_lamp_K.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_K_off.jpg")));
        lbl_lamp_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_L_off.jpg")));
        lbl_lamp_M.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_M_off.jpg")));
        lbl_lamp_N.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_N_off.jpg")));
        lbl_lamp_O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_O_off.jpg")));
        lbl_lamp_P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_P_off.jpg")));
        lbl_lamp_Q.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_Q_off.jpg")));
        lbl_lamp_R.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_R_off.jpg")));
        lbl_lamp_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_S_off.jpg")));
        lbl_lamp_T.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_T_off.jpg")));
        lbl_lamp_U.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_U_off.jpg")));
        lbl_lamp_V.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_V_off.jpg")));
        lbl_lamp_W.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_W_off.jpg")));
        lbl_lamp_X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_X_off.jpg")));
        lbl_lamp_Y.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_Y_off.jpg")));
        lbl_lamp_Z.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lamp_Z_off.jpg")));
    }

    private void updateTxtBx() {
        cursorMoveNdx +=  0;
        strWrdCtr=0;
        strWrdCtr=0;
           
        for (int i=0; i<settings.getDisplayPlainTxt().length(); i++) {
            if (i > 1 && i%5 == 0 && strWrdCtr<1) {
                    str_plainTxt = str_plainTxt.concat(Character.toString('\t'));
                    strWrdCtr++;
            }else if (i > 1 && i%5 == 0 && strWrdCtr%4 != 0) {
                    str_plainTxt = str_plainTxt.concat(Character.toString('\t'));
                    strWrdCtr++;
            }else if (i > 1 && i%5 == 0 && strWrdCtr%4 == 0) {
                    str_plainTxt = str_plainTxt.concat(Character.toString('\n'));
                    strWrdCtr=0;
            }
            strCharCtr++;
            str_plainTxt = str_plainTxt.concat(Character.toString(settings.getDisplayPlainTxt().charAt(i)));
        }
         strWrdCtr=0;
        strWrdCtr=0;
           
        for (int i=0; i<settings.getDisplayCypherTxt().length(); i++) {
            if (i > 1 && i%5 == 0 && strWrdCtr<1) {
                    str_cypherTxt = str_cypherTxt.concat(Character.toString('\t'));
                    strWrdCtr++;
            }else if (i > 1 && i%5 == 0 && strWrdCtr%4 != 0) {
                    str_cypherTxt = str_cypherTxt.concat(Character.toString('\t'));
                    strWrdCtr++;
            }else if (i > 1 && i%5 == 0 && strWrdCtr%4 == 0) {
                    str_cypherTxt = str_cypherTxt.concat(Character.toString('\n'));
                    strWrdCtr=0;
            }
            strCharCtr++;
            str_cypherTxt = str_cypherTxt.concat(Character.toString(settings.getDisplayCypherTxt().charAt(i)));
        }          
        txtArea_cypherTxt.setText(str_cypherTxt);
        txtArea_plainTxt.setText(str_plainTxt);
        txtArea_plainTxt.requestFocus();
        int i = (txtArea_plainTxt.getText().length()) + cursorMoveNdx;
        int start = (i - 1);
        int end = (i);
        txtArea_plainTxt.setSelectionStart(start);
        txtArea_plainTxt.setSelectionEnd(end);
        txtArea_plainTxt.setSelectedTextColor(Color.red);
        str_plainTxt="";
        str_cypherTxt="";
    }

    private void updateDisplay() {
        settings = controller.getSettings();
        
        if (controller.getBackDisabled()==false){
            lbl_btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_back_up.jpg")));
        }
        else {
            lbl_btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_back_null.jpg"))); 
        }
        
        if (controller.getForwardDisabled()==false){
            lbl_btn_forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_forward_up.jpg")));
        }
        else {
            lbl_btn_forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_forward_null.jpg"))); 
        }
        updateTxtBx();
        char[] aryChar = settings.getWirePathChars();
        lbl_path_pb_in_1.setText(String.valueOf(settings.getPlugBoardIn_1()));
        lbl_path_pb_out_1.setText(String.valueOf(settings.getPlugBoardOut_1()));
        lbl_path_pb_in_2.setText(String.valueOf(settings.getPlugBoardIn_2()));
        lbl_path_pb_out_2.setText(String.valueOf(settings.getPlugBoardOut_2()));
        lbl_path_reflect_1.setText(String.valueOf(settings.getReflectorIn()));
        lbl_path_reflect_2.setText(String.valueOf(settings.getReflectorOut()));
        lbl_path_output.setText(String.valueOf(settings.getOutputChar()));
        lbl_path_input.setText(String.valueOf(settings.getInputChar()));
        lbl_path_rotor_1_in_1.setText(String.valueOf(aryChar[0]));
        lbl_path_rotor_1_in_2.setText(String.valueOf(aryChar[1]));
        lbl_path_rotor_2_in_1.setText(String.valueOf(aryChar[2]));
        lbl_path_rotor_2_in_2.setText(String.valueOf(aryChar[3]));
        lbl_path_rotor_3_in_1.setText(String.valueOf(aryChar[4]));
        lbl_path_rotor_3_in_2.setText(String.valueOf(aryChar[5]));
        lbl_path_rotor_1_out_1.setText(String.valueOf(aryChar[10]));
        lbl_path_rotor_1_out_2.setText(String.valueOf(aryChar[11]));
        lbl_path_rotor_2_out_1.setText(String.valueOf(aryChar[8]));
        lbl_path_rotor_2_out_2.setText(String.valueOf(aryChar[9]));
        lbl_path_rotor_3_out_1.setText(String.valueOf(aryChar[6]));
        lbl_path_rotor_3_out_2.setText(String.valueOf(aryChar[7]));
        
        if (m_rotorHold_1 == false) {
            lbl_rotorWheel_holdTray_1.setVisible(false);
        }
        else {
            lbl_rotorWheel_holdTray_1.setVisible(true);
        }
        if (m_rotorHold_2 == false) {
            lbl_rotorWheel_holdTray_2.setVisible(false);
        }
        else {
            lbl_rotorWheel_holdTray_2.setVisible(true);
        }
        if (m_rotorHold_3 == false) {
            lbl_rotorWheel_holdTray_3.setVisible(false);
        }
        else {
            lbl_rotorWheel_holdTray_3.setVisible(true);
        }
        if (m_rotorHold_4 == false) {
            lbl_rotorWheel_holdTray_4.setVisible(false);
        }
        else {
            lbl_rotorWheel_holdTray_4.setVisible(true);
        }
        if (m_rotorHold_5 == false) {
            lbl_rotorWheel_holdTray_5.setVisible(false);
        }
        else {
            lbl_rotorWheel_holdTray_5.setVisible(true);
        }
        if (m_rotorHold_6 == false) {
            lbl_rotorWheel_holdTray_6.setVisible(false);
        }
        else {
            lbl_rotorWheel_holdTray_6.setVisible(true);
        }
        if (m_rotorHold_7 == false) {
            lbl_rotorWheel_holdTray_7.setVisible(false);
        }
        else {
            lbl_rotorWheel_holdTray_7.setVisible(true);
        }
        if (m_rotorHold_8 == false) {
            lbl_rotorWheel_holdTray_8.setVisible(false);
        }
        else {
            lbl_rotorWheel_holdTray_8.setVisible(true);
        }
        if (m_rotorHold_9 == false) {
            lbl_rotorWheel_holdTray_9.setVisible(false);
        }
        else {
            lbl_rotorWheel_holdTray_9.setVisible(true);
        }
        if (m_rotorStandBy == false) {
            lbl_rotor_changeRing.setVisible(false);
            lbl_rotorNum_Display.setVisible(false);
            lbl_ringNum_Display.setVisible(false);
            lbl_ring_up.setVisible(false);
            lbl_ring_down.setVisible(false);
        }
        else {
            lbl_rotor_changeRing.setVisible(true);
            lbl_rotorNum_Display.setVisible(true);
            lbl_ringNum_Display.setVisible(true);
            lbl_ring_up.setVisible(true);
            lbl_ring_down.setVisible(true);
            if (m_wrkRotorNum==1){
                lbl_rotorNum_Display.setText("I");
                lbl_ringNum_Display.setText(m_aryCharNdx[m_rotor_ring_1]+"-"+(m_rotor_ring_1+1));
                m_wrkRingNum=m_rotor_ring_1;
            }
            else if (m_wrkRotorNum==2) {
                lbl_rotorNum_Display.setText("II");
                lbl_ringNum_Display.setText(m_aryCharNdx[m_rotor_ring_2]+"-"+(m_rotor_ring_2+1));
                m_wrkRingNum=m_rotor_ring_2;
            }
            else if (m_wrkRotorNum==3) {
                lbl_rotorNum_Display.setText("III");
                lbl_ringNum_Display.setText(m_aryCharNdx[m_rotor_ring_3]+"-"+(m_rotor_ring_3+1));
                m_wrkRingNum=m_rotor_ring_3;
            }
            else if (m_wrkRotorNum==4) {
                lbl_rotorNum_Display.setText("IV");
                lbl_ringNum_Display.setText(m_aryCharNdx[m_rotor_ring_4]+"-"+(m_rotor_ring_4+1));
                m_wrkRingNum=m_rotor_ring_4;
            }
            else if (m_wrkRotorNum==5) {
                lbl_rotorNum_Display.setText("V");
                lbl_ringNum_Display.setText(m_aryCharNdx[m_rotor_ring_5]+"-"+(m_rotor_ring_5+1));
                m_wrkRingNum=m_rotor_ring_5; 
            }
            else if (m_wrkRotorNum==6) {
                lbl_rotorNum_Display.setText("VI");
                lbl_ringNum_Display.setText(m_aryCharNdx[m_rotor_ring_6]+"-"+(m_rotor_ring_6+1));
                m_wrkRingNum=m_rotor_ring_6;
            }
            else if (m_wrkRotorNum==7) {
                lbl_rotorNum_Display.setText("VII");
                lbl_ringNum_Display.setText(m_aryCharNdx[m_rotor_ring_7]+"-"+(m_rotor_ring_7+1));
                m_wrkRingNum=m_rotor_ring_7;
            }
            else if (m_wrkRotorNum==8) {
                lbl_rotorNum_Display.setText("BETA");
                lbl_ringNum_Display.setText(m_aryCharNdx[m_rotor_ring_8]+"-"+(m_rotor_ring_8+1));
                m_wrkRingNum=m_rotor_ring_8;
            }
            else if (m_wrkRotorNum==9) {
                lbl_rotorNum_Display.setText("GAMMA");
                lbl_ringNum_Display.setText(m_aryCharNdx[m_rotor_ring_9]+"-"+(m_rotor_ring_9+1));
                m_wrkRingNum=m_rotor_ring_9;
            }
        }


        
        
        //Update Rotor Display
        lbl_rotor_display_1.setText(Character.toString(settings.getRotorDisplay_1()));
        lbl_rotor_display_2.setText(Character.toString(settings.getRotorDisplay_2()));
        lbl_rotor_display_3.setText(Character.toString(settings.getRotorDisplay_3()));
        
        if (!prevR1.equals(Character.toString(settings.getRotorDisplay_1()))) {
            if (rotor1DisplayNdx==0){
                lbl_Rotor_1_dial_top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_top_2.jpg")));
                lbl_Rotor_1_dial_bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_bottom_2.jpg")));
                rotor1DisplayNdx=1;
            }
            else {
                lbl_Rotor_1_dial_top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_top_1.jpg")));
                lbl_Rotor_1_dial_bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_bottom_1.jpg")));
                rotor1DisplayNdx=0;
            }
            prevR1=Character.toString(settings.getRotorDisplay_1());
        }
        
        if (!prevR2.equals(Character.toString(settings.getRotorDisplay_2()))) {
            if (rotor2DisplayNdx==0){
                lbl_Rotor_2_dial_top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_top_1.jpg")));
                lbl_Rotor_2_dial_bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_bottom_1.jpg")));
                rotor2DisplayNdx=1;
            }
            else {
                lbl_Rotor_2_dial_top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_top_2.jpg")));
                lbl_Rotor_2_dial_bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_bottom_2.jpg")));
                rotor2DisplayNdx=0;
            }
            prevR2=Character.toString(settings.getRotorDisplay_2());
        }
        if (!prevR3.equals(Character.toString(settings.getRotorDisplay_3()))) {
            if (rotor3DisplayNdx==0){
                lbl_Rotor_3_dial_top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_top_2.jpg")));
                lbl_Rotor_3_dial_bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_bottom_2.jpg")));
                rotor3DisplayNdx=1;
            }
            else {
                lbl_Rotor_3_dial_top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_top_1.jpg")));
                lbl_Rotor_3_dial_bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotorDial_bottom_1.jpg")));
                rotor3DisplayNdx=0;
            }
            prevR3=Character.toString(settings.getRotorDisplay_3());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        splashInit();           // initialize splash overlay drawing parameters
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
 
            public void run() {                
                new EnigmaGUI().setVisible(true);                
            }
        });
    }
    /**
     * just a stub to simulate a long initialization task that updates
     * the text and progress parts of the status in the Splash
     */
    private static void appInit()
    {
    try {       
        // begin with the interactive portion of the program
        
        // begin with the interactive portion of the program
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnigmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnigmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnigmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnigmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Prepare the global variables for the other splash functions
     */
    private static void splashInit()
    {
        // the splash screen object is created by the JVM, if it is displaying a splash image
        
        mySplash = SplashScreen.getSplashScreen();
        // if there are any problems displaying the splash image
        // the call to getSplashScreen will returned null

        if (mySplash != null)
        {
            // get the size of the image now being displayed
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;

            // stake out some area for our status information
            splashTextArea = new Rectangle2D.Double(15., height*0.88, width * .45, 20.);
            splashProgressArea = new Rectangle2D.Double(width * .55, height*.92, width*.4, 12 );

            // create the Graphics environment for drawing status info
            splashGraphics = mySplash.createGraphics();
            font = new Font("Dialog", Font.PLAIN, 14);
            splashGraphics.setFont(font);

        }
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPaneChangeRotor;
    private javax.swing.JLayeredPane jLayeredPaneLampboard;
    private javax.swing.JLayeredPane jLayeredPanePlugboard;
    private javax.swing.JLayeredPane jLayeredPaneRotorDial;
    private javax.swing.JLayeredPane jLayeredPaneRotorDisplay;
    private javax.swing.JLayeredPane jLayeredPaneSettings;
    private javax.swing.JLayeredPane jLayeredPaneWireDiagram;
    private javax.swing.JLayeredPane jLayeredPanelKeyboard;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_Background;
    private javax.swing.JLabel lbl_Rotor_1_dial_bottom;
    private javax.swing.JLabel lbl_Rotor_1_dial_top;
    private javax.swing.JLabel lbl_Rotor_2_dial_bottom;
    private javax.swing.JLabel lbl_Rotor_2_dial_top;
    private javax.swing.JLabel lbl_Rotor_3_dial_bottom;
    private javax.swing.JLabel lbl_Rotor_3_dial_top;
    private javax.swing.JLabel lbl_btn_back;
    private javax.swing.JLabel lbl_btn_forward;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_closePlugboard;
    private javax.swing.JLabel lbl_key_A;
    private javax.swing.JLabel lbl_key_B;
    private javax.swing.JLabel lbl_key_C;
    private javax.swing.JLabel lbl_key_D;
    private javax.swing.JLabel lbl_key_E;
    private javax.swing.JLabel lbl_key_F;
    private javax.swing.JLabel lbl_key_G;
    private javax.swing.JLabel lbl_key_H;
    private javax.swing.JLabel lbl_key_I;
    private javax.swing.JLabel lbl_key_J;
    private javax.swing.JLabel lbl_key_K;
    private javax.swing.JLabel lbl_key_L;
    private javax.swing.JLabel lbl_key_M;
    private javax.swing.JLabel lbl_key_N;
    private javax.swing.JLabel lbl_key_O;
    private javax.swing.JLabel lbl_key_P;
    private javax.swing.JLabel lbl_key_Q;
    private javax.swing.JLabel lbl_key_R;
    private javax.swing.JLabel lbl_key_S;
    private javax.swing.JLabel lbl_key_T;
    private javax.swing.JLabel lbl_key_U;
    private javax.swing.JLabel lbl_key_V;
    private javax.swing.JLabel lbl_key_W;
    private javax.swing.JLabel lbl_key_X;
    private javax.swing.JLabel lbl_key_Y;
    private javax.swing.JLabel lbl_key_Z;
    private javax.swing.JLabel lbl_lamp_A;
    private javax.swing.JLabel lbl_lamp_B;
    private javax.swing.JLabel lbl_lamp_C;
    private javax.swing.JLabel lbl_lamp_D;
    private javax.swing.JLabel lbl_lamp_E;
    private javax.swing.JLabel lbl_lamp_F;
    private javax.swing.JLabel lbl_lamp_G;
    private javax.swing.JLabel lbl_lamp_H;
    private javax.swing.JLabel lbl_lamp_I;
    private javax.swing.JLabel lbl_lamp_J;
    private javax.swing.JLabel lbl_lamp_K;
    private javax.swing.JLabel lbl_lamp_L;
    private javax.swing.JLabel lbl_lamp_M;
    private javax.swing.JLabel lbl_lamp_N;
    private javax.swing.JLabel lbl_lamp_O;
    private javax.swing.JLabel lbl_lamp_P;
    private javax.swing.JLabel lbl_lamp_Q;
    private javax.swing.JLabel lbl_lamp_R;
    private javax.swing.JLabel lbl_lamp_S;
    private javax.swing.JLabel lbl_lamp_T;
    private javax.swing.JLabel lbl_lamp_U;
    private javax.swing.JLabel lbl_lamp_V;
    private javax.swing.JLabel lbl_lamp_W;
    private javax.swing.JLabel lbl_lamp_X;
    private javax.swing.JLabel lbl_lamp_Y;
    private javax.swing.JLabel lbl_lamp_Z;
    private javax.swing.JLabel lbl_openKnob;
    private javax.swing.JLabel lbl_openPlugboard;
    private javax.swing.JLabel lbl_path_input;
    private javax.swing.JLabel lbl_path_output;
    private javax.swing.JLabel lbl_path_pb_in_1;
    private javax.swing.JLabel lbl_path_pb_in_2;
    private javax.swing.JLabel lbl_path_pb_out_1;
    private javax.swing.JLabel lbl_path_pb_out_2;
    private javax.swing.JLabel lbl_path_reflect_1;
    private javax.swing.JLabel lbl_path_reflect_2;
    private javax.swing.JLabel lbl_path_rotor_1_in_1;
    private javax.swing.JLabel lbl_path_rotor_1_in_2;
    private javax.swing.JLabel lbl_path_rotor_1_out_1;
    private javax.swing.JLabel lbl_path_rotor_1_out_2;
    private javax.swing.JLabel lbl_path_rotor_2_in_1;
    private javax.swing.JLabel lbl_path_rotor_2_in_2;
    private javax.swing.JLabel lbl_path_rotor_2_out_1;
    private javax.swing.JLabel lbl_path_rotor_2_out_2;
    private javax.swing.JLabel lbl_path_rotor_3_in_1;
    private javax.swing.JLabel lbl_path_rotor_3_in_2;
    private javax.swing.JLabel lbl_path_rotor_3_out_1;
    private javax.swing.JLabel lbl_path_rotor_3_out_2;
    private javax.swing.JLabel lbl_plug_in_A;
    private javax.swing.JLabel lbl_plug_in_B;
    private javax.swing.JLabel lbl_plug_in_C;
    private javax.swing.JLabel lbl_plug_in_D;
    private javax.swing.JLabel lbl_plug_in_E;
    private javax.swing.JLabel lbl_plug_in_F;
    private javax.swing.JLabel lbl_plug_in_G;
    private javax.swing.JLabel lbl_plug_in_H;
    private javax.swing.JLabel lbl_plug_in_I;
    private javax.swing.JLabel lbl_plug_in_J;
    private javax.swing.JLabel lbl_plug_in_K;
    private javax.swing.JLabel lbl_plug_in_L;
    private javax.swing.JLabel lbl_plug_in_M;
    private javax.swing.JLabel lbl_plug_in_N;
    private javax.swing.JLabel lbl_plug_in_O;
    private javax.swing.JLabel lbl_plug_in_P;
    private javax.swing.JLabel lbl_plug_in_Q;
    private javax.swing.JLabel lbl_plug_in_R;
    private javax.swing.JLabel lbl_plug_in_S;
    private javax.swing.JLabel lbl_plug_in_T;
    private javax.swing.JLabel lbl_plug_in_U;
    private javax.swing.JLabel lbl_plug_in_V;
    private javax.swing.JLabel lbl_plug_in_W;
    private javax.swing.JLabel lbl_plug_in_X;
    private javax.swing.JLabel lbl_plug_in_Y;
    private javax.swing.JLabel lbl_plug_in_Z;
    private javax.swing.JLabel lbl_plug_out_A;
    private javax.swing.JLabel lbl_plug_out_B;
    private javax.swing.JLabel lbl_plug_out_C;
    private javax.swing.JLabel lbl_plug_out_D;
    private javax.swing.JLabel lbl_plug_out_E;
    private javax.swing.JLabel lbl_plug_out_F;
    private javax.swing.JLabel lbl_plug_out_G;
    private javax.swing.JLabel lbl_plug_out_H;
    private javax.swing.JLabel lbl_plug_out_I;
    private javax.swing.JLabel lbl_plug_out_J;
    private javax.swing.JLabel lbl_plug_out_K;
    private javax.swing.JLabel lbl_plug_out_L;
    private javax.swing.JLabel lbl_plug_out_M;
    private javax.swing.JLabel lbl_plug_out_N;
    private javax.swing.JLabel lbl_plug_out_O;
    private javax.swing.JLabel lbl_plug_out_P;
    private javax.swing.JLabel lbl_plug_out_Q;
    private javax.swing.JLabel lbl_plug_out_R;
    private javax.swing.JLabel lbl_plug_out_S;
    private javax.swing.JLabel lbl_plug_out_T;
    private javax.swing.JLabel lbl_plug_out_U;
    private javax.swing.JLabel lbl_plug_out_V;
    private javax.swing.JLabel lbl_plug_out_W;
    private javax.swing.JLabel lbl_plug_out_X;
    private javax.swing.JLabel lbl_plug_out_Y;
    private javax.swing.JLabel lbl_plug_out_Z;
    private javax.swing.JLabel lbl_plugboard_bg;
    private javax.swing.JLabel lbl_reflector1;
    private javax.swing.JLabel lbl_ringNum_Display;
    private javax.swing.JLabel lbl_ring_down;
    private javax.swing.JLabel lbl_ring_up;
    private javax.swing.JLabel lbl_rotor1_display;
    private javax.swing.JLabel lbl_rotor2_display;
    private javax.swing.JLabel lbl_rotor3_display;
    private javax.swing.JLabel lbl_rotorI;
    private javax.swing.JLabel lbl_rotorII;
    private javax.swing.JLabel lbl_rotorIII;
    private javax.swing.JLabel lbl_rotorNum_Display;
    private javax.swing.JLabel lbl_rotorTrayBtn;
    private javax.swing.JLabel lbl_rotorWheel_holdTray_1;
    private javax.swing.JLabel lbl_rotorWheel_holdTray_2;
    private javax.swing.JLabel lbl_rotorWheel_holdTray_3;
    private javax.swing.JLabel lbl_rotorWheel_holdTray_4;
    private javax.swing.JLabel lbl_rotorWheel_holdTray_5;
    private javax.swing.JLabel lbl_rotorWheel_holdTray_6;
    private javax.swing.JLabel lbl_rotorWheel_holdTray_7;
    private javax.swing.JLabel lbl_rotorWheel_holdTray_8;
    private javax.swing.JLabel lbl_rotorWheel_holdTray_9;
    private javax.swing.JLabel lbl_rotor_changeRing;
    private javax.swing.JLabel lbl_rotor_display_1;
    private javax.swing.JLabel lbl_rotor_display_2;
    private javax.swing.JLabel lbl_rotor_display_3;
    private javax.swing.JLabel lbl_rotor_display_bg1;
    private javax.swing.JLabel lbl_rotor_display_bg2;
    private javax.swing.JLabel lbl_rotor_display_bg3;
    private javax.swing.JLabel lbl_rotor_empty_1;
    private javax.swing.JLabel lbl_rotor_empty_2;
    private javax.swing.JLabel lbl_rotor_empty_3;
    private javax.swing.JTextArea txtArea_cypherTxt;
    private javax.swing.JTextArea txtArea_plainTxt;
    // End of variables declaration//GEN-END:variables
}
