/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github.stuparm.marvin.marvinjava.model;

/**
 *
 * @author stuparm
 */
public class Output {

    private final int exitValue;
    private final String stdOut;
    private final String stdErr;
    
    
    public Output(int exitValue, String stdOut, String stdErr) {
        this.exitValue = exitValue;
        this.stdOut = stdOut;
        this.stdErr = stdErr;
    }
    

    public String getStdErr() {
        return stdErr;
    }

    public String getStdOut() {
        return stdOut;
    }

    public int getExitValue() {
        return exitValue;
    }
    
    
    
    
    
    
}
