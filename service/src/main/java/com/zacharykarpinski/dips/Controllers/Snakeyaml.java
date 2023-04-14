package com.zacharykarpinski.dips.Controllers;

// Micronaut imports
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.io.InputStream;
import java.util.Map;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

@Controller("/Snakeyaml")
public class Snakeyaml {

    @Get("/")
    public HttpResponse run(Boolean safe) {
        Yaml yaml;
        Map<String, Object> obj = new HashMap<>();

         // Avoid Code Injection by using SafeConstructor
        if (safe) {
            yaml = new Yaml(new SafeConstructor());
        } 
        else {
            yaml = new Yaml();
        }
    
        try {
            // Load local yaml file from resources folder
            InputStream in = Snakeyaml.class.getClassLoader().getResourceAsStream("CVE-2022-1471.yaml");
            obj = yaml.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }       

        return HttpResponse.ok(obj.toString());
    }

}