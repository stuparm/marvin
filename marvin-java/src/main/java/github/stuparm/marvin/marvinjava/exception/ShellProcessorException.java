/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github.stuparm.marvin.marvinjava.exception;

/**
 *
 * @author stuparm
 */
public class ShellProcessorException extends RuntimeException{
    
    public ShellProcessorException(String script, Exception ex) {
        super("Script "+script+" cannot be executed. Reason is unknown. More detailed information: "+ex.getMessage(), ex);
    } 
    
    
    
}
