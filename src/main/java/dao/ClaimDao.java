package dao;

import model.Claim;
import utils.DateTimeUtils;

import java.util.List;

public class ClaimDao extends ServiceDAO<Claim> implements IServiceDAO<Claim>, IClaimDao {

    @Override
    public List<Claim> findAll() {
        return query("SELECT * FROM claim_request", new Claim.ClaimMapper());
    }

    @Override
    public void save(Claim claim) {
        insert("INSERT INTO claim_request(insuredPerson,cardNumber,examDate,document,claimAmount,status,receiverBankName,receiverBankAccount) " +
                "VALUES (?,?,?,?,?,?,?,?)",
                claim.getInsuredPerson(),
                claim.getCardNumber(),
                DateTimeUtils.format(claim.getExamDate()),
                claim.getDocument(),
                claim.getClaimAmount(),
                claim.getStatus(),
                claim.getReceiverBankName(),
                claim.getReceiverBankAccount());
    }
}
