package service;

import model.Claim;

import java.util.List;

public interface ClaimService {
    List<Claim> getAll();
    Claim getById(Long claimId);
    Claim save(Claim claim);
    void updateStatus(Long claimId, String status, String note);
}
