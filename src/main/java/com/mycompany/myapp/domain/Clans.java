package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Clans.
 */
@Entity
@Table(name = "clans")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Clans implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "clan_name", length = 15, nullable = false)
    private String clanName;

    @NotNull
    @Column(name = "capitan_id", nullable = false)
    private Long capitanId;

    @OneToMany(mappedBy = "clans")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "payIds", "clans", "infoPaid" }, allowSetters = true)
    private Set<TelegramAccount> accIds = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "clanIds" }, allowSetters = true)
    private Turnirs turnirs;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Clans id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClanName() {
        return this.clanName;
    }

    public Clans clanName(String clanName) {
        this.setClanName(clanName);
        return this;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    public Long getCapitanId() {
        return this.capitanId;
    }

    public Clans capitanId(Long capitanId) {
        this.setCapitanId(capitanId);
        return this;
    }

    public void setCapitanId(Long capitanId) {
        this.capitanId = capitanId;
    }

    public Set<TelegramAccount> getAccIds() {
        return this.accIds;
    }

    public void setAccIds(Set<TelegramAccount> telegramAccounts) {
        if (this.accIds != null) {
            this.accIds.forEach(i -> i.setClans(null));
        }
        if (telegramAccounts != null) {
            telegramAccounts.forEach(i -> i.setClans(this));
        }
        this.accIds = telegramAccounts;
    }

    public Clans accIds(Set<TelegramAccount> telegramAccounts) {
        this.setAccIds(telegramAccounts);
        return this;
    }

    public Clans addAccId(TelegramAccount telegramAccount) {
        this.accIds.add(telegramAccount);
        telegramAccount.setClans(this);
        return this;
    }

    public Clans removeAccId(TelegramAccount telegramAccount) {
        this.accIds.remove(telegramAccount);
        telegramAccount.setClans(null);
        return this;
    }

    public Turnirs getTurnirs() {
        return this.turnirs;
    }

    public void setTurnirs(Turnirs turnirs) {
        this.turnirs = turnirs;
    }

    public Clans turnirs(Turnirs turnirs) {
        this.setTurnirs(turnirs);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Clans)) {
            return false;
        }
        return id != null && id.equals(((Clans) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Clans{" +
            "id=" + getId() +
            ", clanName='" + getClanName() + "'" +
            ", capitanId=" + getCapitanId() +
            "}";
    }
}
