
package org.entdes.todolist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodolistController.class)
public class TodolistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // @MockBean
    // private GestorTasques gestor;

    @BeforeEach
    public void setUp() {
        // Setup mock behavior if needed
    }

    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testGetTasques() throws Exception {
        mockMvc.perform(get("/tasques"))
                .andExpect(status().isOk())
                .andExpect(view().name("tasques"))
                .andExpect(model().attributeExists("tasques"));
    }

    @Test
    public void testAddTasca() throws Exception {
        mockMvc.perform(post("/tasques")
                .param("descripcio", "New Task"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tasques"));

    }

    @Test
    public void testAddTascaEmptyDescription() throws Exception {
        mockMvc.perform(post("/tasques")
                .param("descripcio", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("errorMessage"));
    }

    @Test
    public void testUpdateTasca() throws Exception {
        mockMvc.perform(post("/tasques/update/ExistingTask"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tasques"));

    }

    @Test
    public void testDeleteTasca() throws Exception {
        mockMvc.perform(post("/tasques/delete/ExistingTask"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tasques"));

    }
}