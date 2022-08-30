package in.logichat.repository;

import in.logichat.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Customer,Long> {

    Customer findByCustomerId(Long customerId);
}
