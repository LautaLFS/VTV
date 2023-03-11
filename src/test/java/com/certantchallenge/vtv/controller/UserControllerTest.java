package com.certantchallenge.vtv.controller;

import com.certantchallenge.vtv.dto.UserDTO;
import com.certantchallenge.vtv.dto.VehicleDTO;
import com.certantchallenge.vtv.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    ObjectMapper jsonMapper = new ObjectMapper();


    static List<UserDTO> generateDTOList() {
        UserDTO dto = new UserDTO();
        dto.setId("123");
        dto.setIsExempt(true);
        dto.setName("TestName");
        var vehicle = new VehicleDTO();
        dto.getVehicles().add(vehicle);

        return Collections.singletonList(dto);
    }
    @Test
    void createUser() throws Exception {

        UserDTO user = UserControllerTest.generateDTOList().get(0);

        when(userService.saveUser(any())).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/register")
                        .content(jsonMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(jsonMapper.writeValueAsString(user)))
                .andDo(MockMvcResultHandlers.print());
        verify(userService).saveUser(any());
    }

    @Test
    @DisplayName("Valid Case")
    void getAllUser() throws Exception {
        List<UserDTO> users = UserControllerTest.generateDTOList();
        when(userService.getAllUsers()).thenReturn(users);
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
        verify(userService).getAllUsers();
    }

    @Test
    void testFindById() throws Exception {
        UserDTO user = UserControllerTest.generateDTOList().get(0);
        String id = "123123";
        when(userService.getUser(id)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
        verify(userService).getUser(id);
    }

    @Test
    void updateUser() throws Exception {
        UserDTO user = UserControllerTest.generateDTOList().get(0);
        String id = "123";
        Mockito.when(userService.updateUser(Mockito.any(), Mockito.any())).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.put("/users/update/{id}", id)
                        .content(jsonMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
        Mockito.verify(userService).updateUser(Mockito.any(), Mockito.any());
    }

    @Test
    void deleteUser() throws Exception {

        String id = "123";
        UserController userController = new UserController(userService);
        ResponseEntity<?> response = userController.deleteUser(id);
        verify(userService).deleteUser(id);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}