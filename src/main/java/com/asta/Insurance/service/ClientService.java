package com.asta.Insurance.service;


import com.asta.Insurance.model.Client;
import com.asta.Insurance.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAll(String query) {
        if (query != null) {
            return clientRepository.findByQuery(query);
        }
        return clientRepository.findAll();
    }

    public Client getById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public void updateClient(Long id, Client updatedClient) {
        Client client = this.getById(id);

        client.setName(updatedClient.getName());
        client.setSurname(updatedClient.getSurname());
        client.setFatherName(updatedClient.getFatherName());
        client.setDateOfBirth(updatedClient.getDateOfBirth());
        client.setIdAgent(updatedClient.getIdAgent());
        client.setDateOfInsurance(updatedClient.getDateOfInsurance());
        client.setDurationOfInsurance(updatedClient.getDurationOfInsurance());


        clientRepository.save(client);
    }
    public void save(Client client) {
        clientRepository.save(client);
    }
}
