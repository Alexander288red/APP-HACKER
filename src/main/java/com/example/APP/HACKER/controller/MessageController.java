/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.APP.HACKER.controller;

import com.example.APP.HACKER.Repository.MessageRepository;
import com.example.APP.HACKER.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public String listMessages(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String newMessageForm(Model model) {
        model.addAttribute("message", new Message());
        return "add_message";
    }

    @PostMapping
    public String saveMessage(@ModelAttribute Message message) {
        messageRepository.save(message);
        return "redirect:/messages";
    }
}
