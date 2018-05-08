/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneyxchange.persistence.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vtrujillo
 */
@Entity
@Table(name = "currencyconverurl",schema="currencyexchange")
public class Currencyconverurl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CurrencyconverurlPK currencyconverurlPK;
    @Column(name = "urlvalue")
    private String urlvalue;
    @JoinColumn(name = "tocurrency", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Currency currency;
    @JoinColumn(name = "fromcurrency", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Currency currency1;

    public Currencyconverurl() {
    }

    public Currencyconverurl(CurrencyconverurlPK currencyconverurlPK) {
        this.currencyconverurlPK = currencyconverurlPK;
    }

    public Currencyconverurl(String tocurrency, String fromcurrency) {
        this.currencyconverurlPK = new CurrencyconverurlPK(tocurrency, fromcurrency);
    }

    public CurrencyconverurlPK getCurrencyconverurlPK() {
        return currencyconverurlPK;
    }

    public void setCurrencyconverurlPK(CurrencyconverurlPK currencyconverurlPK) {
        this.currencyconverurlPK = currencyconverurlPK;
    }

    public String getUrlvalue() {
        return urlvalue;
    }

    public void setUrlvalue(String urlvalue) {
        this.urlvalue = urlvalue;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency1() {
        return currency1;
    }

    public void setCurrency1(Currency currency1) {
        this.currency1 = currency1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyconverurlPK != null ? currencyconverurlPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currencyconverurl)) {
            return false;
        }
        Currencyconverurl other = (Currencyconverurl) object;
        if ((this.currencyconverurlPK == null && other.currencyconverurlPK != null) || (this.currencyconverurlPK != null && !this.currencyconverurlPK.equals(other.currencyconverurlPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.moneyxchange.persistence.entities.Currencyconverurl[ currencyconverurlPK=" + currencyconverurlPK + " ]";
    }
    
}
