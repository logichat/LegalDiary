package in.logichat.controller;

import in.logichat.entity.CaseObj;
import in.logichat.service.CaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class CaseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CaseService caseService;

    private CaseObj caseObj;

    @BeforeEach
    void setUp() {
        caseObj=CaseObj.builder().caseId(1L).opponent("saurabh").client("sameer").caseDetails("pizza").build();
    }

    @Test
    void saveCase() throws Exception {

        CaseObj inputCaseObj=CaseObj.builder().caseId(1L).opponent("saurabh").client("sameer").caseDetails("pizza").build();

        Mockito.when(caseService.saveCase(inputCaseObj)).thenReturn(caseObj);

        mockMvc.perform(MockMvcRequestBuilders.post("/cases/").contentType(MediaType.APPLICATION_JSON).
                        content("{\"client\":\"sameer\",\"opponent\":\"saurabh\",\"caseDetails\":\"pizza\",\"caseId\":1}")).
                andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getCaseById() throws Exception {
        Long id=1L;

        Mockito.when(caseService.getCaseById(id)).thenReturn(caseObj);

        mockMvc.perform(MockMvcRequestBuilders.get("/cases/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk ()).
                andExpect(MockMvcResultMatchers.jsonPath("$.client").value(caseObj.getClient()));

    }
}