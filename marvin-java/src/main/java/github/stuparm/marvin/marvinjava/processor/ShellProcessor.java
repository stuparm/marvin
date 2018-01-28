/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github.stuparm.marvin.marvinjava.processor;

import github.stuparm.marvin.marvinjava.Config;
import github.stuparm.marvin.marvinjava.model.Output;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author stuparm
 */
public class ShellProcessor {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ShellProcessor.class);
    
    @Autowired
    private Config config;
    
    public Output executeScript(String script, String... args) {
        
        String stdOut = "";
        String stdErr = "";
        
        String command = config.getScriptsFolder()+script+".ah";
        for (String arg : args) {
            command+= " "+arg;
        }
        
        String s = null;
        try {
                       
            
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            
            while ((s = stdInput.readLine()) != null) {
                stdOut += s + "\n";
            }
            while ((s = stdError.readLine()) != null) {
                stdErr += s + "\n";
            }

            p.destroyForcibly();

            stdOut = stdOut.trim();
            stdErr = stdErr.trim();

            p.waitFor();
            
            int exitValue = p.exitValue();
            if (exitValue != 0) {
                LOGGER.warn("Command {}, executed with exit value: {}\n{}\n  -------------  ", command, exitValue, stdErr);
            } else {
                LOGGER.info("Command {} executed successfully", command);
            }
            
            Output output = new Output(exitValue, stdOut, stdErr);
            return output;

        } catch (Exception e) {
            LOGGER.error("Error during command execution: [ " + command + " ]", e);
            throw new RuntimeException(e);
        }
    }
    
    
}
