package com.github.fabio2g.stocksync.dto;

import java.time.Instant;

public record SupplyDTO(
        String id,
        String name,
        String corporateReason,
        String description,
        String site,
        String branchOfActivity,
        String cnpj,
        String cep,
        String address,
        String neighborhood,
        String city,
        String state,
        String seller,
        String email,
        String telephone,
        String celPhone,
        String fax,
        String mailbox,
        String account,
        String bank,
        String agency,
        boolean supplierStatus,
        Instant createAt,
        Instant updateAt
) {
}
