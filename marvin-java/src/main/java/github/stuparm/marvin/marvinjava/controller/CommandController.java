/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github.stuparm.marvin.marvinjava.controller;

import github.stuparm.marvin.marvinjava.model.Output;
import github.stuparm.marvin.marvinjava.processor.ShellProcessor;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author stuparm
 */
@RestController
@RequestMapping(value = "/marvin")
public class CommandController {
    
    @Autowired
    ShellProcessor shellProcessor;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map marvin(@RequestParam Map<String, String> body) {
        
        String text = body.get("text");
        Map<String, String> map = new HashMap<>();
        
        String[] commands = text.trim().split(" ");
        if (commands.length == 0) {
            map.put("text", "Ooops! Something is wrong with your command. It needs to have at least one word");
            return map;
        }
        
        String script = commands[0].trim();
        String[] args = new String[commands.length - 1];
        for (int i = 1; i < commands.length; i++) {
            args[i-1] = commands[i];
        }
        
        Output output = shellProcessor.executeScript(script, args);
        
        

        
        return map;
    }
    
    
}
