package Enigma;

/**
 *The Controller class represents the component of Enigma machine that controls
 * the flow of the character through the path of the machine.
 * The Controller class accepts a valid character variable from the GUI Class,
 * sets and gets the character to/from the Plugboard class, then sets and gets 
 * the character  to/from the Rotor class, and then sets and gets the character 
 * to/from the Reflector class.  Then, from this point, the character is worked
 * back though the same process in a reverse manner.
 * 
 * The current state of the machine is based on the values of the current Settings
 * data member.  As the state of the machine changes, the current settings class
 * is stored in the Stack class and a new Settings class is called.  The new
 * new Settings values are set to equal the previous Settings values.
 * 
 * To display the character as it travels along the path, the current settings is 
 * updated during the process.
 * 
 * <p>
The class data members:
 * <ul>
 * <li>Type char: m_outputChar - character to be returned to GUI Class
 * <li>Type Reflector: m_reflector - Represents the reflector to be used to process character
 * <li>Type Plugboard: m_plugboard - Represents the plugboard to be used to process character
 * <li>Type Rotor:     m_rotor - Represents the 3 rotors to be used to process character
 * <li>Type Settings:  m_settings - stores the current state of the machine
 * <li>Type History:   m_history - Stack class that holds all Settings
 * </ul>
 * </p>         
@version     1.0
 *  
 */
public class Controller {
    //Class data members
    private char m_outputChar;      
    private Reflector m_reflector;  
    private Plugboard m_plugboard;  
    private Rotor m_rotor;          
    private Settings m_settings;    
    private History m_history;
    
    /** 
    * Class constructor. The default constructor assigns a value to the data 
    * members. By default, the data member m_outputChar is set to '/0', and 
    * the classes used in by the Controller class are instantiated.  m_history is 
    * set with a default Settings class to serve as a baseline state.  Then a new 
    * Settings class is called.
    */
    public Controller()
    {
        m_outputChar = '\0';
        m_reflector = new Reflector();
        m_plugboard = new Plugboard();
        m_history = new History();
        m_rotor = new Rotor();        
        m_settings = new Settings();
        m_history.histSet(m_settings);
        m_settings = new Settings();
    }    
 
  /**
   * Accepts a character variable that is passed as an argument from the 
   * GUI Class. Assuming the parameter is valid, the setInputChar() method is called
   * and the character is passed as an argument.
   * 
   * The path in which the character is passed is as follows:
   * 
   * GUI        -> Controller
   * Controller -> Plugboard
   * Plugboard  -> Controller
   * Controller -> Rotor
   * Rotor      -> Controller
   * Controller -> Reflector
   * Reflector  -> Controller
   * Controller -> Rotor
   * Rotor      -> Controller
   * Controller -> Plugboard
   * Plugboard  -> Controller
   * Controller -> GUI
   * 
   * As the character moves around the path, and is changed; the character(s) are 
   * stored in the Settings class
   * 
   * Once the character completes the path, the current Settings is placed on the
   * stack
   * 
   * @param c the character passed from the GUI class
   */
    public void setInputChar(char c)
    {
        m_outputChar='\0';
        m_settings.setDisplayPlainTxt(Character.toString(c));
        m_rotor = new Rotor(m_settings.getRotorSettingsVals()); 
        m_settings.setInputChar(c);
        m_plugboard.setInputChar(c);            
        m_settings.setPlugBoardIn_1(c);
        m_settings.setPlugBoardOut_1(m_plugboard.getOutputChar());
        m_rotor.cryptPass1(m_settings.getRotorSettingsVals(),m_plugboard.getOutputChar());
        m_reflector.setInputChar(m_rotor.getOutputChar());
        m_settings.setReflectorIn(m_rotor.getOutputChar());
        m_settings.setReflectorOut(m_reflector.getOutputChar());
        m_rotor.cryptPass2(m_settings.getRotorSettingsVals(),m_reflector.getOutputChar());
        m_settings.setWirePathChars(m_rotor.getRotorWiringChars());
        m_plugboard.setInputChar(m_rotor.getOutputChar());          
        m_settings.setPlugBoardIn_2(m_rotor.getOutputChar());
        m_settings.setPlugBoardOut_2(m_plugboard.getOutputChar());  
        m_outputChar = m_plugboard.getOutputChar();
        m_settings.setOutputChar(m_outputChar);
        m_settings.setDisplayCypherTxt(Character.toString(m_outputChar));
        m_settings.setRotorDisplayVals(m_rotor.getRotorDisplayVals());
        m_settings.setRotorSettingVals(m_rotor.getRotorSettingVals()); 
        m_settings.setRotorDisplay_1();
        m_settings.setRotorDisplay_2();
        m_settings.setRotorDisplay_3();        
        m_history.histSet(m_settings);
        m_settings = new Settings();
        updateSettings();
    }

    /**
     * 
     * @return the current Settings of the machines current state
     */
    public Settings getSettings()
    {
        return m_settings;
    }
    /**
     * Moves the current Settings from the History Stack to the Forward Stack.
     * Initializes a new Settings and sets the values of of the new Settings to 
     * the Settings that are on top of the History Stack 
     */
    public void back() {
        if (m_history.backDisabled()==false) {            
            m_history.histBack();
            m_settings = new Settings();            
            updateSettings();            
        }
    }
    
    /**
     * Moves the top Settings from the Forward Stack to the History Stack.
     * Initializes a new Settings and sets the values of of the new Settings to 
     * the Settings that are on top of the History Stack
     */
    public void forward() {
        if (m_history.forwardDisabled()==false) {
            m_settings = new Settings();
            m_history.histForward();
            m_settings = m_history.getCurrent();
        }
    }
    

    /**
     * Sets the values of the Current Settings to equal the values of the Settings 
     * from the History Stack
     */
    
   private void updateSettings() {       
    m_settings.setInputChar(m_history.getCurrent().getInputChar());
    m_settings.setOutputChar(m_history.getCurrent().getOutputChar());
    m_settings.setPlugBoardIn_1(m_history.getCurrent().getPlugBoardIn_1());
    m_settings.setPlugBoardIn_2(m_history.getCurrent().getPlugBoardIn_2());
    m_settings.setPlugBoardOut_1(m_history.getCurrent().getPlugBoardOut_1());
    m_settings.setPlugBoardOut_2(m_history.getCurrent().getPlugBoardOut_2());
    m_settings.setReflectorIn(m_history.getCurrent().getReflectorIn());
    m_settings.setReflectorOut(m_history.getCurrent().getReflectorOut());
    m_settings.setRotorDisplay_1(m_history.getCurrent().getRotorDisplay_1());
    m_settings.setRotorDisplay_2(m_history.getCurrent().getRotorDisplay_2());
    m_settings.setRotorDisplay_3(m_history.getCurrent().getRotorDisplay_3());
    m_settings.setRotorDisplay_4(m_history.getCurrent().getRotorDisplay_4());
    m_settings.setDisplayPlainTxt(m_history.getCurrent().getDisplayPlainTxt());
    m_settings.setDisplayCypherTxt(m_history.getCurrent().getDisplayCypherTxt());
    m_settings.setPlugBoardArray(m_plugboard.getPlugAry());    
    m_settings.setWirePathChars(m_history.getCurrent().getWirePathChars());   
    m_settings.setRotorSettingVals(m_history.getCurrent().getRotorSettingsVals());   
   } 
    
   /**
    * 
    * @return the output character; which is set once character completes the path
    */
   public char getOutputChar()
    {
        return m_outputChar;
    }
    
   /**
    *  
    * @return array containing the current values that represent the current state
    * of the plugboard
    */
   public char[ ][ ] getPlugAry()
    {
        return m_plugboard.getPlugAry();
    }

    /**
     * 
     * Sets a character to the Plugboard class
     * 
     * @param c character value to set into Plugboard class
     */
    public void setPlugboard(char c)
    {
       m_plugboard.setPlugboard(c);
    }
    
    /**
     * 
     * Sets the rotor position forward.  The GUI calls the method, and passes 
     * the argument of rtrNum to indicate which rotor is to be moved forward
     * 
     * @param rtrNum integer value indicating which rotor is moved forward
     */
    public void setRotorForward(int rtrNum)
    {
        m_settings.setRotorForward(rtrNum);
        m_settings.setRotorDisplay_1();
        m_settings.setRotorDisplay_2();
        m_settings.setRotorDisplay_3(); 
    }
    
    /**
     * 
     * Sets the rotor position backward.  The GUI calls the method, and passes 
     * the argument of rtrNum to indicate which rotor is to be moved backward
     * 
     * @param rtrNum integer value indicating which rotor is moved backward
     */
    public void setRotorBackward(int rtrNum)
    {
        m_settings.setRotorBackward(rtrNum);       
        m_settings.setRotorDisplay_1();
        m_settings.setRotorDisplay_2();
        m_settings.setRotorDisplay_3(); 
    }
   
    /**
     * Checks if the History Stack contains a Settings. 
     * Returns true if contains at least one Settings, or false if contains
     * no Settings
     * 
     * @return boolean value indicating if History Stack contains a Settings
     */
    public boolean getBackDisabled() {        
        return m_history.backDisabled();
    }
    /**
     * Checks if the Forward Stack contains a Settings. 
     * Returns true if contains at least one Settings, or false if contains
     * no Settings
     * 
     * @return boolean value indicating if Forward Stack contains a Settings
     */
    public boolean getForwardDisabled() { 
        return m_history.forwardDisabled();
    }
    
    /**
     * 
     * Sets the values of the Rotos Class.
     * When user changes the settings of the Rotor, all history is cleared and 
     * message values are cleared as well
     * 
     * @param aryRSV array of integer values that are used to set Rotor values
     */
    public void setRotorSettingVals(int [] aryRSV)
    {
        m_settings = new Settings();
        m_history.histSet(m_settings);
        m_settings = new Settings();
        m_settings.setRotorSettingVals(aryRSV);
        m_settings.setDisplayPlainTxt("");
        m_settings.setDisplayCypherTxt("");
        m_history.fwdStack.clear();
        m_history.histStack.clear();
        m_history.histSet(m_settings);
        m_settings = new Settings();        
        updateSettings();
    }
    
}
