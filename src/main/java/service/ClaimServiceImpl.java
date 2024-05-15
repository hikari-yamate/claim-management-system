package service;

import dao.IClaimDao;
import model.Claim;

import java.util.List;

public class ClaimServiceImpl implements ClaimService {
    private final IClaimDao claimDao;

    public ClaimServiceImpl(IClaimDao claimDao) {
        this.claimDao = claimDao;
    }

    @Override
    public List<Claim> getAll() {
        return claimDao.findAll();
    }

    @Override
    public Claim getById(Long claimId) {
        return claimDao.findById(claimId);
    }

    @Override
    public Claim save(Claim claim) {
        claimDao.save(claim);
        return claim;
    }

    @Override
    public void updateStatus(Long claimId, String status, String note) {
        Claim c = getById(claimId);
        if(c == null) {
            return;
        }
        c.setStatus(status);
        c.setNote(note);
        claimDao.updateStatus(c);
    }
}
