package by.myself.crypto.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "crypto_data")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Crypto {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "symbol_cr")
    private String symbol;

    @Column(name = "name")
    private String name;

    @Column(name = "nameid")
    private String nameid;

    @Column(name = "rank_cr")
    private Integer rank;

    @Column(name = "price_usd")
    private String price_usd;

    @Column(name = "percent_change_24h")
    private String percent_change_24h;

    @Column(name = "percent_change_1h")
    private String percent_change_1h;

    @Column(name = "percent_change_7d")
    private String percent_change_7d;

    @Column(name = "market_cap_usd")
    private String market_cap_usd;

    @Column(name = "volume24")
    private String volume24;

    @Column(name = "volume24_native")
    private String volume24_native;

    @Column(name = "c_supply")
    private String csupply;

    @Column(name = "price_btc")
    private String price_btc;

    @Column(name = "t_supply")
    private String tsupply;

    @Column(name = "m_supply")
    private String msupply;

    public Crypto(String symbol, String name, String nameid, Integer rank, String price_usd, String percent_change_24h, String percent_change_1h, String percent_change_7d, String market_cap_usd, String volume24, String volume24_native, String csupply, String price_btc, String tsupply, String msupply) {
        this.symbol = symbol;
        this.name = name;
        this.nameid = nameid;
        this.rank = rank;
        this.price_usd = price_usd;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_7d = percent_change_7d;
        this.market_cap_usd = market_cap_usd;
        this.volume24 = volume24;
        this.volume24_native = volume24_native;
        this.csupply = csupply;
        this.price_btc = price_btc;
        this.tsupply = tsupply;
        this.msupply = msupply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Crypto crypto = (Crypto) o;
        return id != null && Objects.equals(id, crypto.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
