package in.logichat.service;

import in.logichat.entity.CaseObj;
import in.logichat.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseService {
    @Autowired
    private CaseRepository caseRepository;


    public CaseObj saveCase(CaseObj caseObj) {
        return caseRepository.save(caseObj);
    }

    public CaseObj getCaseById(Long caseId) {

        return caseRepository.findByCaseId(caseId);
    }
}
