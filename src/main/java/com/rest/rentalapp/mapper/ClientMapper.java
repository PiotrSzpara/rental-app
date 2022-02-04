package com.rest.rentalapp.mapper;

import com.rest.rentalapp.domain.Client;
import com.rest.rentalapp.domain.ClientDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ClientMapper {

    public Client mapToClient(final ClientDto clientDto) {
        return new Client(
                clientDto.getClientId(),
                clientDto.getName()
        );
    }

    public ClientDto mapToClientDto(final Client client) {
        return new ClientDto(
                client.getClientId(),
                client.getName()
        );
    }

    public List<ClientDto> mapToClientDtoList(final List<Client> clients) {
        return clients.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }
}
