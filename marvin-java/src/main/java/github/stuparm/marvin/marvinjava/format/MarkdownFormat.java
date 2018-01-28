/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github.stuparm.marvin.marvinjava.format;

import github.stuparm.marvin.marvinjava.model.Output;

/**
 *
 * @author stuparm
 */
public class MarkdownFormat {
    
    
    public static String format(Output output) {
        
        StringBuilder text = new StringBuilder();
        
        text.append("Exit Value: ").append(code(output.getExitValue())).append("\n");
        text.append("StdOut:").append("\n").append(code(output.getStdOut())).append("\n");
        text.append("StdErr:").append("\n").append(code(output.getStdErr())).append("\n");
        
        return text.toString();
        
    }
    
    private static String code(String text) {
        return "'''"+text+"'''";
    }
    
    private static String code(int text) {
        return "'''"+text+"'''";
    }
}
