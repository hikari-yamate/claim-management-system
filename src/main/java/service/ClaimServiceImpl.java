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
    public Claim save(Claim claim) {
        claimDao.save(claim);
        return claim;
    }
}
