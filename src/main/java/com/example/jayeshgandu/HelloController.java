package com.example.jayeshgandu;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

class Boy {

    private final String name;
    private List<String> character;

    Boy(String name, ArrayList<String> character) {
        this.name = name;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public List<String> getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return "Boy [name=" + name + ", character=" + character + "]";
    }

    public void setCharacter(List<String> character) {
        this.character = character;
    }

    
}

@RestController
public class HelloController {

    Boy jayesh = new Boy("Jayesh", new ArrayList<>());
    
    @GetMapping(value="/")
    public ResponseEntity<Object> sayHelloString() {

        return ResponseEntity.ok()
            .body(jayesh);
    }

    @GetMapping(value="/jayesh")
    public ResponseEntity<Object> setQuality(@RequestParam String quality) {
        jayesh.getCharacter().add(quality);
        return ResponseEntity.ok().body(jayesh);
    }
    
    

}
