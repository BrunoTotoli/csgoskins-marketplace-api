package com.bruno.clutchskins.controllers;

import com.bruno.clutchskins.entities.Skin;
import com.bruno.clutchskins.requests.SkinPostRequestBody;
import com.bruno.clutchskins.requests.SkinPutRequestBody;
import com.bruno.clutchskins.requests.SkinResponse;
import com.bruno.clutchskins.services.SkinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/skin")
@Log4j2
public class SkinController {

    private final SkinService skinService;

    @GetMapping
    public ResponseEntity<Page<SkinResponse>> findSkinsPageable(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(skinService.findAllSkinsPageable(page, size), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkinResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(skinService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Skin> save(@Valid @RequestBody SkinPostRequestBody skinPostRequestBody) {
        return new ResponseEntity<>(skinService.save(skinPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Skin> replace(@Valid @RequestBody SkinPutRequestBody skinPutRequestBody) {
        return new ResponseEntity<>(skinService.replace(skinPutRequestBody), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        skinService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/weapon")
    public ResponseEntity<List<SkinResponse>> findSkinsByWeapon(@RequestParam String weaponName) {
        return new ResponseEntity<>(skinService.findSkinListByWeaponName(weaponName.toUpperCase()), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<SkinResponse>> findSkinsByCategory(@RequestParam String category) {
        return new ResponseEntity<>(skinService.findSkinListByCategory(category.toUpperCase()), HttpStatus.OK);
    }

}
