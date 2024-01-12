package com.abnamro.sluggish.controllers;

import com.abnamro.sluggish.dtos.ItemDto;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/sluggish/items")
@RequiredArgsConstructor
public class ItemController {

    @GetMapping("/{id}")
    public ItemDto one(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(15000);
        return ItemDto
            .builder()
                .id(id)
                .name("Item_" + UUID.randomUUID())
                .available(new Random().nextBoolean())
                .added(LocalDate.now())
            .build();
    }

    @GetMapping("/numbers")
    public List<Integer> all() {
        return List.of(1,2,3,4,5);
    }

}