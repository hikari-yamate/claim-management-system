package model;

import dao.IMapper;
import lombok.*;
import utils.DateTimeUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Claim implements IObject {
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
    private String note;

    @Override
    public Object[] toObject() {
        return new Object[] {
            id, DateTimeUtils.format(claimDate), insuredPerson, cardNumber, claimAmount, status, DateTimeUtils.format(examDate)
        };
    }

    @Override
    public String toString() {
        return id + " - " + insuredPerson + " - " + cardNumber;
    }

    public static class ClaimMapper implements IMapper<Claim> {

        @Override
        public Claim mapping(ResultSet resultSet) {
            try {
                return Claim.builder()
                        .id(resultSet.getLong("id"))
                        .claimDate(resultSet.getDate("claimDate"))
                        .insuredPerson(resultSet.getString("insuredPerson"))
                        .cardNumber(resultSet.getString("cardNumber"))
                        .examDate(resultSet.getDate("examDate"))
                        .document(resultSet.getString("document"))
                        .claimAmount(resultSet.getLong("claimAmount"))
                        .status(resultSet.getString("status"))
                        .receiverBankName(resultSet.getString("receiverBankName"))
                        .receiverBankAccount(resultSet.getString("receiverBankAccount"))
                        .note(resultSet.getString("notes"))
                        .build();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}
