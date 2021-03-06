package Enigma;

/**
 *The Settings class holds the values of the current state of the Enigma machine,
 *The private data members are accessed through public class property getters and setters
 * <p>
The class data members:
 * <ul>
 * <li>Type char: m_rotorDisplay_1  - Character value that is display in the GUI; Rotor 1
 * <li>Type char: m_rotorDisplay_2  - Character value that is display in the GUI; Rotor 2
 * <li>Type char: m_rotorDisplay_3  - Character value that is display in the GUI; Rotor 3
 * <li>Type char: m_rotorDisplay_4  - Character value that is display in the GUI; Rotor 4 
 * <li>Type char: m_plugBoard_in_1  - Character value that enters the plugboard the first time
 * <li>Type char: m_plugBoard_out_1 - Character value that enters the plugboard the first time
 * <li>Type char: m_plugBoard_out_2 - Character value that exits the plugboard the first time
 * <li>Type char: m_reflector_in    - Character value that enters the reflector
 * <li>Type char: m_reflector_out   - Character value that exits the reflector 
 * <li>Type char: m_inputChar       - Character value that is set from the GUI
 * <li>Type char: m_outputChar      - Character value that is retrieved from the GUI
 * <li>Type char array: m_aryPlugboard        - Character array that contains the plugboard values
 * <li>Type char array: m_aryCharNdx          - Character array used to convert integer values to corresponding Character Value
 * <li>Type char array: m_aryRotorDisplayVals - Character array that store the Character values to be displayed in the GUI
 * <li>Type char array: m_aryWirePathChars    - Character array that store the characters as they pass along the rotors
 * <li>Type int array: m_aryRotorSettingsVals - Integer array that store the values of the rotors; used by the rotors class
 * <li>Type String: m_displayPlainTxt         - String value of plain text to be displayed by the GUI
 * <li>Type String: m_displayCypherTxt        - String value of cypher text to be displayed by the GUI
 * 
 * </ul>
 * </p>
 *                      
                    
@version     1.0
 *  
 */
public class Settings {
    private char m_rotorDisplay_1;
    private char m_rotorDisplay_2;
    private char m_rotorDisplay_3;
    private char m_rotorDisplay_4;
    private char m_plugBoard_in_1;
    private char m_plugBoard_in_2;
    private char m_plugBoard_out_1;
    private char m_plugBoard_out_2;
    private char m_reflector_in;
    private char m_reflector_out;
    private char m_inputChar;
    private char m_outputChar;    
    private char[ ][ ] m_aryPlugboard = new char[26][3];
    private char[ ] m_aryCharNdx = new char[26];
    private char[] m_aryRotorDisplayVals = new char[4];
    private char[] m_aryWirePathChars = new char[12];    
    private int[] m_aryRotorSettingsVals = new int[12];    
    private String m_displayPlainTxt;
    private String m_displayCypherTxt;   
    /** 
    * Class constructor. The default constructor assigns a value to the data 
    * members with a call to initializeComponents()
    */
    public Settings()
    {
        initializeComponents();    
    }
    /*******************Class Property Setters*******************/
    /************************************************************/
    /**
     * Sets the value of the input character
     * @param c character value of the input character
     */
    public void setInputChar(char c)
    {
        m_inputChar=c;
    }
    /**
     * Sets the value of the output character
     * @param c character value of the output character
     */
    public void setOutputChar(char c)
    {
        m_outputChar = c;
    }
    /**
     * Sets the character value of the Rotor 1 without argument
     */
    public void setRotorDisplay_1()
    {
        m_rotorDisplay_1 = m_aryCharNdx[m_aryRotorSettingsVals[4]];
       
    }
    /**
     * Sets the character value of the Rotor 2 without argument
     */
    public void setRotorDisplay_2()
    {
        m_rotorDisplay_2 = m_aryCharNdx[m_aryRotorSettingsVals[5]];
    }
    /**
     * Sets the character value of the Rotor 3 without argument
     */
    public void setRotorDisplay_3()
    {
        m_rotorDisplay_3 = m_aryCharNdx[m_aryRotorSettingsVals[6]];
    }
    /**
     * Sets the character value of the Rotor 4 without argument
     */
    public void setRotorDisplay_4()
    {
        m_rotorDisplay_4 = m_aryCharNdx[m_aryRotorSettingsVals[7]];
    }
    /**
     * Sets the character value of the Rotor 1 with argument
     * @param c character value to be set to rotor display 1
     */
    public void setRotorDisplay_1(char c)
    {
        m_rotorDisplay_1 = c;
    }
    /**
     * Sets the character value of the Rotor 2 with argument
     * @param c character value to be set to rotor display 2
     */
    public void setRotorDisplay_2(char c)
    {
        m_rotorDisplay_2 = c;
    }
    /**
     * Sets the character value of the Rotor 3 with argument
     * @param c character value to be set to rotor display 3
     */
    public void setRotorDisplay_3(char c)
    {
        m_rotorDisplay_3 = c;
    }
    /**
     * Sets the character value of the Rotor 4 with argument
     * @param c character value to be set to rotor display 4
     */
    public void setRotorDisplay_4(char c)
    {
        m_rotorDisplay_4 = c;
    }
    
    
    /**
     * Set the values of the wire path characters
     * @param aryWPC character array of character values
     */
    public void setWirePathChars(char [] aryWPC){
        m_aryWirePathChars = aryWPC;
    }
    /**
     * Sets Character value that enters the plugboard the first time
     * @param c character value to set m_plugBoard_in_1
     */
    public void setPlugBoardIn_1(char c)
    {
        m_plugBoard_in_1=c;
    }
    /**
     * Sets Character value that enters the plugboard the second time
     * @param c character value to set m_plugBoard_in_2
     */
    public void setPlugBoardIn_2(char c)
    {
        m_plugBoard_in_2=c;
    }
    /**
     * Sets Character value that exits the plugboard the first time
     * @param c character value to set setPlugBoardOut_1
     */
    public void setPlugBoardOut_1(char c)
    {
        m_plugBoard_out_1=c;
    }    
    /**
     * Sets Character value that exits the plugboard the second time
     * @param c character value to set setPlugBoardOut_2
     */
    public void setPlugBoardOut_2(char c)
    {
        m_plugBoard_out_2=c;
    }
    /**
     * Sets Character value that enters the reflector
     * @param c character value to set m_reflector_in
     */
    public void setReflectorIn(char c)
    {
        m_reflector_in=c;
    }
    /**
     * Sets Character value that exits the reflector
     * @param c character value to set m_reflector_out
     */
    public void setReflectorOut(char c)
    {
        m_reflector_out=c;
    }
    /**
     * Sets the character values to the array that holds the rotor display values
     * @param aryRDV character array that hold the rotor display values
     */
    public void setRotorDisplayVals(char [] aryRDV)
    {
        m_aryRotorDisplayVals=aryRDV;
    }
    /**
     * Sets the integer values to the array that holds the rotor setting values
     * @param aryRSV integer array that hold the rotor setting values
     */
    public void setRotorSettingVals(int [] aryRSV)
    {
        m_aryRotorSettingsVals=aryRSV;
    }
    /**
     * Sets the character values to the array that holds the plugboard values
     * @param cA character array that holds the plugboard values
     */
    public void setPlugBoardArray(char[][] cA) {
        m_aryPlugboard = cA;
    }
    /**
     * Sets the number of the rotor to be set forward.  
     * @param rtrNum integer value of the rotor number
     */
    public void setRotorForward(int rtrNum){
        if (m_aryRotorSettingsVals[3+rtrNum]+1>=26){
            m_aryRotorSettingsVals[3+rtrNum]=0;
        }
        else {
            m_aryRotorSettingsVals[3+rtrNum]=m_aryRotorSettingsVals[3+rtrNum]+1;
        }
    }
    /**
     * Sets the number of the rotor to be set backward.  
     * @param rtrNum integer value of the rotor number
     */
    public void setRotorBackward(int rtrNum){
        if (m_aryRotorSettingsVals[3+rtrNum]-1<0){
            m_aryRotorSettingsVals[3+rtrNum]=25;
        }
        else {
            m_aryRotorSettingsVals[3+rtrNum]=m_aryRotorSettingsVals[3+rtrNum]-1;
        }
    }
    /**
     * Sets the string value of the plain text to be displayed by the GUI
     * @param c sting value to be concatenated to itself
     */
    public void setDisplayPlainTxt(String c){
        m_displayPlainTxt = m_displayPlainTxt.concat(c);
    }
    /**
     * Sets the string value of the cypher text to be displayed by the GUI
     * @param c sting value to be concatenated to itself
     */
    public void setDisplayCypherTxt(String c){
        m_displayCypherTxt = m_displayCypherTxt.concat(c);
    }
    /*******************Class Property Getters*******************/
    /************************************************************/
    /**
     * Returns the plain text to be displayed by the GUI
     * @return String value to be displayed by the GUI
     */
    public String getDisplayPlainTxt() {
        return m_displayPlainTxt;
    }
    /**
     * Returns the cypher text to be displayed by the GUI
     * @return String value to be displayed by the GUI
     */
    public String getDisplayCypherTxt() {
        return m_displayCypherTxt;
    }    
    /**
     * Returns the array that contains the values of the plugboard
     * @return character array that contains the values of the plugboard
     */
    public char[][] getPlugBoardArray() {
        return m_aryPlugboard;
    }
    
    /**
     * Return the character of rotor 1 to be displayed by the GUI
     * @return character value of rotor 1
     */
    public char getRotorDisplay_1()
    {
        return m_rotorDisplay_1;
    }
    
    /**
     * Return the character of rotor 2 to be displayed by the GUI
     * @return character value of rotor 2
     */
    public char getRotorDisplay_2()
    {
        return m_rotorDisplay_2;
    }    
    /**
     * Return the character of rotor 3 to be displayed by the GUI
     * @return character value of rotor 3
     */
    public char getRotorDisplay_3()
    {
        return m_rotorDisplay_3;
    }    
    /**
     * Return the character of rotor 4 to be displayed by the GUI
     * @return character value of rotor 4
     */
    public char getRotorDisplay_4()
    {
        return m_rotorDisplay_4;
    }
    /**
     * Returns the array of the characters that hold the values of the wire path
     * @return character array holding the values of the wire path
     */
    public char[] getWirePathChars(){
        return m_aryWirePathChars;
    }    
    /**
     * Returns a character that first enters the plugboard
     * @return Character value that first enters the plugboard
     */
    public char getPlugBoardIn_1()
    {
        return m_plugBoard_in_1;
    }
    /**
     * Returns a character that first exits the plugboard
     * @return Character value that first exits the plugboard
     */
    public char getPlugBoardOut_1()
    {
        return m_plugBoard_out_1;
    }
    /**
     * Returns a character that enters the plugboard second
     * @return Character value that enters the plugboard second
     */
    public char getPlugBoardIn_2()
    {
        return m_plugBoard_in_2;
    }    
    /**
     * Returns a character that exits the plugboard second
     * @return Character value that exits the plugboard second
     */
    public char getPlugBoardOut_2()
    {
        return m_plugBoard_out_2;
    }   
    /**
     * Returns a character that enters the reflector
     * @return Character value that enters the reflector
     */
    public char getReflectorIn()
    {
        return m_reflector_in;
    }
    /**
     * Returns a character that exits the reflector
     * @return Character value that exits the reflector
     */
    public char getReflectorOut()
    {
        return m_reflector_out;
    }
    /**
     * Returns the character array that contains the rotor display values
     * @return character array that contains the rotor display values
     */
    public char[] getRotorDisplayVals()
    {
        return m_aryRotorDisplayVals;
    }
    /**
     * Returns the integer array that contains the rotor setting values
     * @return integer array that contains the rotor setting values
     */
    public int[] getRotorSettingsVals()
    {
        return m_aryRotorSettingsVals;
    }
    /**
     * Returns the character value of the input character
     * @return character value of the input character
     */
    public char getInputChar()
    {
        return m_inputChar;
    }    
    /**
     * Returns the character value of the output character
     * @return character value of the output character
     */
    public char getOutputChar()
    {
        return m_outputChar;
    }
    private void initializeComponents()
    {
        m_rotorDisplay_1 = 'A';
        m_rotorDisplay_2 = 'A';
        m_rotorDisplay_3 = 'A';
        m_rotorDisplay_4 = 'A';
        m_plugBoard_in_1 = '\0';
        m_plugBoard_out_1 = '\0';
        m_plugBoard_in_2 = '\0';
        m_plugBoard_out_2 = '\0';
        m_reflector_in = '\0';
        m_reflector_out = '\0';
        m_inputChar = '\0';
        m_outputChar = '\0';
        m_displayPlainTxt="";
        m_displayCypherTxt="";
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
        
        m_aryPlugboard = new char[26][3];  
        m_aryWirePathChars = new char[12];
        m_aryRotorDisplayVals = new char[4];
        
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
    }
    
}
