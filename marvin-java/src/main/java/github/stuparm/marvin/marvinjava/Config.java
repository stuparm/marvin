/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github.stuparm.marvin.marvinjava;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author stuparm
 */
@Configuration
public class Config {

    @Value("${response.type}")
    private String responseType;

    @Value("${scripts.folder}")
    private String scriptsFolder;

    public String getResponseType() {
        return responseType;
    }

    public String getScriptsFolder() {
        return scriptsFolder;
    }

}
