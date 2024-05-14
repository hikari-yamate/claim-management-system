package service;

import model.Claim;

import java.util.List;

public interface ClaimService {
    List<Claim> getAll();
    Claim save(Claim claim);
}
