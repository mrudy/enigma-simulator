package Enigma;

/**
 *The Plugboard class represents the plugboard component of Enigma machine.
 *The plugboard class permits 'wiring' sets of two character variables together.
 *This can be configured by the operator. The effect is to swap those letters 
 *before and after the main rotor scrambling unit. The action is performed by the
 *user interaction in the GUI. The user pairs, or "plugs", the characters together
 *by clicking a character on the plugboard GUI.  The GUI will display a set of 
 *the character that was clicked.  Once another character is clicked, the GUI will
 *should display a set of the paired character set.  When either paired character
 *set is clicked after the pair is "unplugged".  The display is reset.
 * <p>
The class data members:
 * <ul>
 * <li>Type char[][]: m_outputChar    - multidimensional array (26*3)  that holds the 
 *                                      values of the plugboard in it's current state                                
 * <li>Type boolean: m_plugIsAwaiting - boolean that represents whether or not a plug
 *                                      has been plugged in and is awaiting to be 
 *                                      plugged into another socket of the plugboard
 * <li>Type char: m_waitingPlug       - character that represents the plug that last
 *                                      received the action of being plugged in, and is
 *                                      now awaiting for another plug.
 * <li>Type char: m_outputChar        - character that represents the character is being 
 *                                      used as the output
 * </ul>
 * </p>
 *  
                    
@version     1.0
 *  
 */
public class Plugboard {
    //Class data members
    char[ ][ ] m_aryPlugboard = new char[26][3];
    private boolean m_plugIsAwaiting;
    private char m_waitingPlug;
    private char m_outputChar;
    /** 
    * Class constructor. The default constructor assigns a value to the data 
    * members. 
    * 
    * By default: - data members m_waitingPlug and m_outputChar are set to '/0
    *             - m_plugIsAwaiting is set to false
    *             - call the buildAry() method to populate array with default values
    */
    Plugboard()
    {
        m_plugIsAwaiting = false;
        m_waitingPlug = '\0';
        m_outputChar = '\0';
        buildAry();
    }
    /**
    *-Accepts a character variable that is passed as an argument from the Controller Class
    *-Assuming the parameter is valid, output character is set the the value determined
    * by the plugboard array
    *-The value is determined by comparing the input character with the characters
    * in first column of the array (input chars[A-Z]). The resulting index is used
    * assign a value from the array (output chars[A-Z]) to  the output char variable.
    * 
    * @param  c the character passed from the controller class, and to the setInputChar() method
    */
    public void setInputChar(char c)
    {
        if (Character.isLetter(c))          //Verify Character is type char        
            if (Character.isUpperCase(c))   //Verify Character is uppercase            
                for (int i=0; i<26; i++)
                {
                    if(m_aryPlugboard[i][0]==c) m_outputChar = m_aryPlugboard[i][2];
                }
            else   
                throw new IllegalArgumentException("Plugboard: Character is not uppercase");            
        else
            throw new IllegalArgumentException("Plugboard: Character is not a letter"); 
    }
    
    /**
     * 
     * Set the values to values that represent the status of the plugboard.
     * The plugboard status is used by the GUI for user interaction.
     * 
     * A = Awaiting; indicates a character has been selected, and awaiting a 
     *     corresponding character to be mapped to 
     * Y = Yes; indicates character is selected, and a corresponding character 
     *     has been selected
     * N = No; indicates character has not been selected
     * 
     * @param c character value to be set into the plugboard
     */
    public void setPlugboard(char c)
    {
        if (getPluggedInStatus(c)=='N' && m_plugIsAwaiting==false)
        {
            setPluggedInStatus(c, 'A');
            m_plugIsAwaiting = true;
            m_waitingPlug = c;
        }
        else if (getPluggedInStatus(c)=='N' && m_plugIsAwaiting==true)
        {
            setOutputValue(c, m_waitingPlug);
            setOutputValue(m_waitingPlug, c);
            setPluggedInStatus(c, 'Y');
            setPluggedInStatus(m_waitingPlug, 'Y');
            m_waitingPlug='\0';
            m_plugIsAwaiting=false;
        }
        else if (getPluggedInStatus(c)=='Y' && m_plugIsAwaiting==false)
        {
            char outputValue = getOutputValue(c);
            setPluggedInStatus(outputValue, 'N');
            setPluggedInStatus(c, 'N');
            setOutputValue(outputValue, outputValue);            
            setOutputValue(c, c);
        }
        else if (getPluggedInStatus(c)=='A' && m_plugIsAwaiting==true)
        {
            setPluggedInStatus(c, 'N');
            m_plugIsAwaiting = false;
        }
        else
        {
          throw new IllegalArgumentException("Plugboard: Can not set Plugboard");  
        }       
    }

    private void setOutputValue(char c, char outputVal)
    {
        for (int i=0; i<26; i++)
            if(m_aryPlugboard[i][0]==c)         //Character Index
                m_aryPlugboard[i][2]=outputVal;
    }
    /**
    *  
    *gets the output value of the character plug being called
    * 
    * @param  c      the character passed from setPlugboard() of Plugboard Class
    */
    private char getOutputValue(char c)
    {
        char outputChar = '$';
        for (int i=0; i<26; i++)
            if(m_aryPlugboard[i][0]==c) 
                outputChar = m_aryPlugboard[i][2];                 
        
        return outputChar;
    }
    /**
    *  
    *gets the current status of the character plug being called
    * 
    * @param  c      the character passed from setPlugboard() of Plugboard Class
    */
    private char getPluggedInStatus(char c)
    {
        char rtnChar = '\0';
        
        for (int i=0; i<26; i++)
            if(m_aryPlugboard[i][0]==c)         //Character Index
                rtnChar = m_aryPlugboard[i][1]; //Plug Status        
        return rtnChar;                         //Return Plug Status
    }
    /**
    *  
    *sets the plug status of the character in array
    * 
    * @param  c      the character passed from setPlugboard() of Plugboard Class
    * @param  status the status passed from setPlugboard() of Plugboard Class
    */ 
    private void setPluggedInStatus(char c, char status)
    {
        for (int i=0; i<26; i++)
            if(m_aryPlugboard[i][0]==c)
                m_aryPlugboard[i][1] = status;      
    }
    /**
    *  
    *returns the character value of m_outputChar
    * 
    * @return character value of the output character
    */   
    public char getOutputChar()
    {
        return m_outputChar;
    }
    /**
    *  
    *
    * @return array of characters that represent the plugboard
    */ 
    public char[ ][ ] getPlugAry()
    {
        return m_aryPlugboard;
    }
    /**
    *  
    *initializes the values of the plugboard array
    */ 
    private void buildAry()
    {
        m_aryPlugboard[0][0]  = 'A';
        m_aryPlugboard[1][0]  = 'B';
        m_aryPlugboard[2][0]  = 'C';
        m_aryPlugboard[3][0]  = 'D';
        m_aryPlugboard[4][0]  = 'E';
        m_aryPlugboard[5][0]  = 'F';
        m_aryPlugboard[6][0]  = 'G';
        m_aryPlugboard[7][0]  = 'H';
        m_aryPlugboard[8][0]  = 'I';
        m_aryPlugboard[9][0]  = 'J';
        m_aryPlugboard[10][0] = 'K';
        m_aryPlugboard[11][0] = 'L';
        m_aryPlugboard[12][0] = 'M';
        m_aryPlugboard[13][0] = 'N';
        m_aryPlugboard[14][0] = 'O';
        m_aryPlugboard[15][0] = 'P';
        m_aryPlugboard[16][0] = 'Q';
        m_aryPlugboard[17][0] = 'R';
        m_aryPlugboard[18][0] = 'S';
        m_aryPlugboard[19][0] = 'T';
        m_aryPlugboard[20][0] = 'U';
        m_aryPlugboard[21][0] = 'V';
        m_aryPlugboard[22][0] = 'W';
        m_aryPlugboard[23][0] = 'X';
        m_aryPlugboard[24][0] = 'Y';
        m_aryPlugboard[25][0] = 'Z';
        
        m_aryPlugboard[0][1]  = 'N';
        m_aryPlugboard[1][1]  = 'N';
        m_aryPlugboard[2][1]  = 'N';
        m_aryPlugboard[3][1]  = 'N';
        m_aryPlugboard[4][1]  = 'N';
        m_aryPlugboard[5][1]  = 'N';
        m_aryPlugboard[6][1]  = 'N';
        m_aryPlugboard[7][1]  = 'N';
        m_aryPlugboard[8][1]  = 'N';
        m_aryPlugboard[9][1]  = 'N';
        m_aryPlugboard[10][1] = 'N';
        m_aryPlugboard[11][1] = 'N';
        m_aryPlugboard[12][1] = 'N';
        m_aryPlugboard[13][1] = 'N';
        m_aryPlugboard[14][1] = 'N';
        m_aryPlugboard[15][1] = 'N';
        m_aryPlugboard[16][1] = 'N';
        m_aryPlugboard[17][1] = 'N';
        m_aryPlugboard[18][1] = 'N';
        m_aryPlugboard[19][1] = 'N';
        m_aryPlugboard[20][1] = 'N';
        m_aryPlugboard[21][1] = 'N';
        m_aryPlugboard[22][1] = 'N';
        m_aryPlugboard[23][1] = 'N';
        m_aryPlugboard[24][1] = 'N';
        m_aryPlugboard[25][1] = 'N';
        
        m_aryPlugboard[0][2]  = 'A';
        m_aryPlugboard[1][2]  = 'B';
        m_aryPlugboard[2][2]  = 'C';
        m_aryPlugboard[3][2]  = 'D';
        m_aryPlugboard[4][2]  = 'E';
        m_aryPlugboard[5][2]  = 'F';
        m_aryPlugboard[6][2]  = 'G';
        m_aryPlugboard[7][2]  = 'H';
        m_aryPlugboard[8][2]  = 'I';
        m_aryPlugboard[9][2]  = 'J';
        m_aryPlugboard[10][2] = 'K';
        m_aryPlugboard[11][2] = 'L';
        m_aryPlugboard[12][2] = 'M';
        m_aryPlugboard[13][2] = 'N';
        m_aryPlugboard[14][2] = 'O';
        m_aryPlugboard[15][2] = 'P';
        m_aryPlugboard[16][2] = 'Q';
        m_aryPlugboard[17][2] = 'R';
        m_aryPlugboard[18][2] = 'S';
        m_aryPlugboard[19][2] = 'T';
        m_aryPlugboard[20][2] = 'U';
        m_aryPlugboard[21][2] = 'V';
        m_aryPlugboard[22][2] = 'W';
        m_aryPlugboard[23][2] = 'X';
        m_aryPlugboard[24][2] = 'Y';
        m_aryPlugboard[25][2] = 'Z';
    }
    
}
