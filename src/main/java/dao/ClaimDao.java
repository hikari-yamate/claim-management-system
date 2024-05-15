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
    public Claim findById(Long id) {
        List<Claim> claims = query("SELECT * FROM claim_request WHERE id = ?", new Claim.ClaimMapper(), id);
        return claims.isEmpty()? null : claims.get(0);
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

    @Override
    public void updateStatus(Claim claim) {
        update("UPDATE claim_request SET status = ?, notes = ? where id = ?", claim.getStatus(),
                 claim.getNote(),
                claim.getId());
    }
}
