package dao;

import model.Claim;

import java.util.List;

public interface IClaimDao {
    List<Claim> findAll();
    Claim findById(Long id);
    void save(Claim claim);
    void updateStatus(Claim claim);
}
