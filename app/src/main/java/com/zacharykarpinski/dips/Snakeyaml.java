package com.zacharykarpinski.dips;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.constructor.SafeConstructor;

public class Snakeyaml {

    private Yaml yaml;

    public Snakeyaml() {
        yaml = new Yaml();
    
    }

    public Snakeyaml(String message) {
        yaml = new Yaml();
        System.out.println(message);

        this.CVE_2022_1471(false);
    
    }

    public Map<String, Object> CVE_2022_1471(Boolean safe) {
        Map<String, Object> obj = null;
        try {
             // Load local yaml file from resources folder
            InputStream in = Snakeyaml.class.getClassLoader().getResourceAsStream("CVE-2022-1471.yaml");
            
             // 'Avoid Code Injection by using SafeConstructor
            if (safe){
               
                yaml = new Yaml(new SafeConstructor());
            }

            obj = yaml.load(in);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
    
}
