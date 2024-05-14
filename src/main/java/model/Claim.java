package model;

import dao.IMapper;
import lombok.*;

import java.sql.ResultSet;
import java.util.Date;


@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Claim {
    private Long id;
    private Date claimDate;
    private String insuredPerson;
    private String cardNumber;
    private Date examDate;
    private String document;
    private Long claimAmount;
    private String status;
    private String receiverBankName;
    private String receiverBankAccount;


    public static class ClaimMapper implements IMapper<Claim> {

        @Override
        public Claim mapping(ResultSet resultSet) {
            return null;
        }
    }
}
