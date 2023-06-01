package com.asta.Insurance.controller;

import com.asta.Insurance.model.Client;
import com.asta.Insurance.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public String getAll(@RequestParam(name = "query", required = false) String query, Model model) {
        List<Client> clients = clientService.getAll(query);
        model.addAttribute("clients", clients);
        return "clients";
    }



    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "viewClient";
    }

    @PostMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "editClient";
    }


    @PostMapping("/edit/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute Client updatedClient) {
        clientService.updateClient(id, updatedClient);
        return "redirect:/clients/" + id;
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/add")
    public String getAddForm(Model model) {
        model.addAttribute("client", new Client());
        return "addClient";
    }


    @PostMapping("/add")
    public String addClient(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }
}
