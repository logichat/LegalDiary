package in.logichat.service;

import in.logichat.entity.CaseObj;
import in.logichat.repository.CaseRepository;
import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CaseServiceTest {

    @Autowired
    private CaseService caseService;

    @MockBean
    private CaseRepository caseRepository;


    private CaseObj caseObj;
    private CaseObj  inputCaseObj;

    @BeforeEach
    void setUp() {
        inputCaseObj =CaseObj.builder().caseId(1L).caseDetails("pizza").opponent("saurabh").client("sameer").build();
        caseObj=CaseObj.builder().caseId(1L).caseDetails("pizza").opponent("saurabh").client("sameer").build();

        Mockito.when(caseRepository.save(caseObj)).thenReturn(caseObj);
        Mockito.when(caseRepository.findByCaseId(1L)).thenReturn(caseObj);

    }

    @Test
    @DisplayName("Save case")
    void saveCase() {
            CaseObj caseObj1=caseService.saveCase(inputCaseObj);
            assertEquals(inputCaseObj,caseObj1);
    }

    @Test
    void getCaseById() {
        Long id=1L;

        CaseObj caseObj1=caseService.getCaseById(id);
        assertEquals(caseObj1.getCaseId(),id);

    }
}
