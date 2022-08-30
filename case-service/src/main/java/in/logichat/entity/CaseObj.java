package in.logichat.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CaseObj {

    @Id
    @GeneratedValue
    private long caseId;

    @NotBlank
    @Size(max=100,message = "Value should be less than 100")
    private String client;
    @NotBlank
    @Size(max=100,message = "Value should be less than 100")
    private String opponent;
    private String caseDetails;


}
