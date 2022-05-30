package com.kreitek.kreitekfy.infrastructure.rest;

import com.kreitek.kreitekfy.application.dto.StyleDTO;
import com.kreitek.kreitekfy.application.dto.UserDTO;
import com.kreitek.kreitekfy.application.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StyleRestController {
    private final StyleService styleService;

    @Autowired
    public StyleRestController(StyleService styleService) {
        this.styleService = styleService;
    }

    @CrossOrigin
    @PostMapping(value = "/styles", produces = "application/json", consumes = "application/json")
    ResponseEntity<StyleDTO> insertUser(@RequestBody StyleDTO styleDTO) {
        StyleDTO styleSaved = this.styleService.saveStyle(styleDTO);
        return new ResponseEntity<>(styleSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(value = "/style/{styleId}")
    ResponseEntity<StyleDTO> getUserById(@PathVariable Long styleId) {
        Optional<StyleDTO> style = this.styleService.getStyleById(styleId);

        if (style.isPresent()) {
            return new ResponseEntity<>(style.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/styles", produces = "application/json")
    ResponseEntity<List<StyleDTO>> getStylesPartialName(@RequestParam(name = "partialName", required = false) String partialStyleName) {
        List<StyleDTO> styles;

        if (partialStyleName == null) {
            styles = styleService.getAllStyles();
        } else {
            styles = this.styleService.getAllStylesByPartialName(partialStyleName);
        }
        return new ResponseEntity<>(styles, HttpStatus.OK);
    }
}
