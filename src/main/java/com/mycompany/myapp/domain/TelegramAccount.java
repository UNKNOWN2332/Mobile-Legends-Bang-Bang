package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mycompany.myapp.domain.enumeration.Role;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A TelegramAccount.
 */
@Entity
@Table(name = "telegram_account")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TelegramAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "chat_id", unique = true)
    private Long chatId;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "create_at")
    private Instant createAt;

    @OneToMany(mappedBy = "accId")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "accId", "periodId" }, allowSetters = true)
    private Set<Pay> payIds = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "accIds", "turnirs" }, allowSetters = true)
    private Clans clans;

    @ManyToOne
    @JsonIgnoreProperties(value = { "accs", "periods" }, allowSetters = true)
    private InfoPaid infoPaid;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public TelegramAccount id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return this.chatId;
    }

    public TelegramAccount chatId(Long chatId) {
        this.setChatId(chatId);
        return this;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getUsername() {
        return this.username;
    }

    public TelegramAccount username(String username) {
        this.setUsername(username);
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public TelegramAccount firstname(String firstname) {
        this.setFirstname(firstname);
        return this;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public TelegramAccount lastname(String lastname) {
        this.setLastname(lastname);
        return this;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public TelegramAccount phoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return this.role;
    }

    public TelegramAccount role(Role role) {
        this.setRole(role);
        return this;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Instant getCreateAt() {
        return this.createAt;
    }

    public TelegramAccount createAt(Instant createAt) {
        this.setCreateAt(createAt);
        return this;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public Set<Pay> getPayIds() {
        return this.payIds;
    }

    public void setPayIds(Set<Pay> pays) {
        if (this.payIds != null) {
            this.payIds.forEach(i -> i.setAccId(null));
        }
        if (pays != null) {
            pays.forEach(i -> i.setAccId(this));
        }
        this.payIds = pays;
    }

    public TelegramAccount payIds(Set<Pay> pays) {
        this.setPayIds(pays);
        return this;
    }

    public TelegramAccount addPayId(Pay pay) {
        this.payIds.add(pay);
        pay.setAccId(this);
        return this;
    }

    public TelegramAccount removePayId(Pay pay) {
        this.payIds.remove(pay);
        pay.setAccId(null);
        return this;
    }

    public Clans getClans() {
        return this.clans;
    }

    public void setClans(Clans clans) {
        this.clans = clans;
    }

    public TelegramAccount clans(Clans clans) {
        this.setClans(clans);
        return this;
    }

    public InfoPaid getInfoPaid() {
        return this.infoPaid;
    }

    public void setInfoPaid(InfoPaid infoPaid) {
        this.infoPaid = infoPaid;
    }

    public TelegramAccount infoPaid(InfoPaid infoPaid) {
        this.setInfoPaid(infoPaid);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TelegramAccount)) {
            return false;
        }
        return id != null && id.equals(((TelegramAccount) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TelegramAccount{" +
            "id=" + getId() +
            ", chatId=" + getChatId() +
            ", username='" + getUsername() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", role='" + getRole() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            "}";
    }
}
