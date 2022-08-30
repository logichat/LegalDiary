package in.logichat.controller;

import in.logichat.entity.CaseObj;
import in.logichat.service.CaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cases")
@Slf4j
public class CaseController {

    @Autowired
    private CaseService caseService;

    @PostMapping("/")
    public CaseObj saveCase(@Valid @RequestBody CaseObj caseObj)
    {
        log.info("Inside save case method");
        log.info(caseObj.toString());
        return caseService.saveCase(caseObj);
    }
    @GetMapping("/{caseId}")
    public CaseObj getCaseById(@PathVariable Long caseId)
    {    log.info("Inside get case method");
        return caseService.getCaseById(caseId);
    }

}
