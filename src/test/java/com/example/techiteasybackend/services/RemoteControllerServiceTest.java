package com.example.techiteasybackend.services;

import com.example.techiteasybackend.dto.input.RemoteControllerInputDto;
import com.example.techiteasybackend.dto.mapper.RemoteControllerMapper;
import com.example.techiteasybackend.dto.output.RemoteControllerOutputDto;
import com.example.techiteasybackend.models.RemoteController;
import com.example.techiteasybackend.repositories.RemoteControllerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class RemoteControllerServiceTest {

    @Mock
    RemoteControllerRepository remoteControllerRepository;
    @InjectMocks
    RemoteControllerService remoteControllerService;

    @Test
    @DisplayName("Should add remotecontroller")
    void createRemoteController() {
        //arrange
        RemoteControllerInputDto remoteControllerInputDto = new RemoteControllerInputDto();
        remoteControllerInputDto.setId(1);
        remoteControllerInputDto.setCompatibleWith("yes");
        remoteControllerInputDto.setBatteryType("AAA");
        remoteControllerInputDto.setName("RC54");
        remoteControllerInputDto.setBrand("Sony");
        remoteControllerInputDto.setPrice(25.0);
        remoteControllerInputDto.setOriginalStock(3);

        Mockito.when(remoteControllerRepository.save(Mockito.any())).thenReturn(RemoteControllerMapper.fromInputDtoToModel(remoteControllerInputDto));
        //act
        RemoteControllerOutputDto remoteControllerOutputDto = remoteControllerService.createRemoteController(remoteControllerInputDto);

        //assert
        assertEquals("yes", remoteControllerOutputDto.getCompatibleWith());
        assertEquals("AAA", remoteControllerOutputDto.getBatteryType());
        assertEquals("RC54", remoteControllerOutputDto.getName());
    }
}