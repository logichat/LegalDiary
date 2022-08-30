package in.logichat.repository;

import in.logichat.entity.CaseObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<CaseObj,Long>{

    CaseObj findByCaseId(Long caseId);
}
