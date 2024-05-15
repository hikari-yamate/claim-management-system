package model;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
@Setter
@Getter
public class Customer {
    private Long id;
    private String fullName;
    private String insuranceCard;
    private List<Claim> claims;
}
