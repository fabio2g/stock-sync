package com.github.fabio2g.stocksync.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_suppliers")
public class Supllier {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String corporateReason;
    private String description;
    private String site;
    private String branchOfActivity;
    private String cnpj;
    private String cep;
    private String address;
    private String neighborhood;
    private String city;
    private String state;
    private String seller;
    private String email;
    private String telephone;
    private String celPhone;
    private String fax;
    private String mailbox;
    private String account;
    private String bank;
    private String agency;
    private boolean supplierStatus;
    private Instant createAt;
    private Instant updateAt;

    @ManyToMany(mappedBy = "suppliers")
    private List<Product> products = new ArrayList<>();

    public Supllier(String name, String corporateReason, String description, String site, String branchOfActivity, String cnpj, String cep, String address, String neighborhood, String city, String state, String seller, String email, String telephone, String celPhone, String fax, String mailbox, String account, String bank, String agency, boolean supplierStatus) {
        this.name = name;
        this.corporateReason = corporateReason;
        this.description = description;
        this.site = site;
        this.branchOfActivity = branchOfActivity;
        this.cnpj = cnpj;
        this.cep = cep;
        this.address = address;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.seller = seller;
        this.email = email;
        this.telephone = telephone;
        this.celPhone = celPhone;
        this.fax = fax;
        this.mailbox = mailbox;
        this.account = account;
        this.bank = bank;
        this.agency = agency;
        this.supplierStatus = supplierStatus;
    }
}
