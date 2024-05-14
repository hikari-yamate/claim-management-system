package dao;

import model.Claim;

import java.util.List;

public interface IClaimDao {
    List<Claim> findAll();
    void save(Claim claim);
}
