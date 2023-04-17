package com.zacharykarpinski.dips.Controllers;
// Micronaut imports
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class Main {

    @Get("/")
    public HttpResponse run() {
        return HttpResponse.ok("Hello!");
    }

}
