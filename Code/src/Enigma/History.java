package Enigma;

import java.util.*;

/**
 *The History class contains two stacks that hold Settings class type.  Each settings
 * represent a state of the Enigma machine.  As the machine moves to a new state,
 * the previous state (Settings) is placed on the history Stack.  If the 'BACK' button
 * is pressed (from the GUI), the Settings is popped from the history stack, and  is pushed 
 * onto the forward stack.  If the 'FORWARD' button is pressed (from the GUI), 
 * the Settings is popped from the forward stack, and pushed onto the history stack. 
 * <p>
The class data members:
 * <ul>
 * <li>Type Stack<Settings>: histStack - Stack of the type Settings that holds the
 *                                       history of the machines states (back)
 * <li>Type Stack<Settings>: histStack - Stack of the type Settings that holds the
 *                                       history of the machines states (forward)
 * </ul>
 * </p>
 *  
                    
@version     1.0
 *  
 */
public class History{
  //class data members
  Stack<Settings> histStack = new Stack<Settings>();
  Stack<Settings> fwdStack = new Stack<Settings>();  
  /**
   * 
   * Pushes Settings type object onto histStack
   * 
   * @param s Settings type object to be pushed onto stack
   * @return Settings type object that was pushed onto stack
   */
  public Settings histSet(Settings s){
    histStack.push(s);    
    if(!(fwdStack.isEmpty())) {
        fwdStack.clear();
    }
    
    return histStack.peek();
  }  
  /**
   * 
   * if histStack is not empty, push the Settings on top of the histStack to the 
   * fwdStack, then pop the Settings from the histStack.
   * 
   * @return Settings type object on top of the histStack
   */
  public Settings histBack(){
    if(!(histStack.isEmpty())) {         
        fwdStack.push(histStack.pop());
        return histStack.peek();
    }
    else {
        return histStack.peek();
    }  
  } 
  /**
   * 
   * if fwdStack is not empty, push the Settings on top of the fwdStack to the 
   * histStack, then pop the Settings from the fwdStack.
   * 
   * @return Settings type object on top of the histStack
   */
  public Settings histForward(){
    if(!(fwdStack.isEmpty())){
      histStack.push(fwdStack.pop());
      return histStack.peek();
    }
    else return histStack.peek();
  }  
  /**
   * 
   * @return Settings type object that is on top of histStack
   */
  public Settings getCurrent(){
    return histStack.peek();
  }    
  /**
   * 
   * @return True if fwdStack contains at least one item; false if zero
   */
  public boolean forwardDisabled()
  {
    if(fwdStack.size() >= 1)
    {
      return false;
    }
    else
      return true;
  }
  
  /**
   * 
   @return True if histStack contains at least one item; false if zero
   */
  public boolean backDisabled()
  {
    if(histStack.size() <= 1)
    {
      return true;
    }
    else
      return false;
  }
}
