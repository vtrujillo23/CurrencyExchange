/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneyxchange.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author vtrujillo
 */
@Embeddable
public class CurrencyconverurlPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "tocurrency")
    private String tocurrency;
    @Basic(optional = false)
    @Column(name = "fromcurrency")
    private String fromcurrency;

    public CurrencyconverurlPK() {
    }

    public CurrencyconverurlPK(String tocurrency, String fromcurrency) {
        this.tocurrency = tocurrency;
        this.fromcurrency = fromcurrency;
    }

    public String getTocurrency() {
        return tocurrency;
    }

    public void setTocurrency(String tocurrency) {
        this.tocurrency = tocurrency;
    }

    public String getFromcurrency() {
        return fromcurrency;
    }

    public void setFromcurrency(String fromcurrency) {
        this.fromcurrency = fromcurrency;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tocurrency != null ? tocurrency.hashCode() : 0);
        hash += (fromcurrency != null ? fromcurrency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrencyconverurlPK)) {
            return false;
        }
        CurrencyconverurlPK other = (CurrencyconverurlPK) object;
        if ((this.tocurrency == null && other.tocurrency != null) || (this.tocurrency != null && !this.tocurrency.equals(other.tocurrency))) {
            return false;
        }
        if ((this.fromcurrency == null && other.fromcurrency != null) || (this.fromcurrency != null && !this.fromcurrency.equals(other.fromcurrency))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.moneyxchange.persistence.entities.CurrencyconverurlPK[ tocurrency=" + tocurrency + ", fromcurrency=" + fromcurrency + " ]";
    }
    
}
