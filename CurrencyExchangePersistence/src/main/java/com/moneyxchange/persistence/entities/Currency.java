/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneyxchange.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vtrujillo
 */
@Entity
@Table(name = "currency",schema="currencyexchange")
public class Currency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "inclusion_date")
    @Temporal(TemporalType.TIME)
    private Date inclusionDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currency", fetch = FetchType.LAZY)
    private List<Currencyconverurl> currencyconverurlList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currency1", fetch = FetchType.LAZY)
    private List<Currencyconverurl> currencyconverurlList1;
    @OneToMany(mappedBy = "fromcurrency", fetch = FetchType.LAZY)
    private List<Exchange> exchangeList;
    @OneToMany(mappedBy = "tocurrency", fetch = FetchType.LAZY)
    private List<Exchange> exchangeList1;

    public Currency() {
    }

    public Currency(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(Date inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    @XmlTransient
    public List<Currencyconverurl> getCurrencyconverurlList() {
        return currencyconverurlList;
    }

    public void setCurrencyconverurlList(List<Currencyconverurl> currencyconverurlList) {
        this.currencyconverurlList = currencyconverurlList;
    }

    @XmlTransient
    public List<Currencyconverurl> getCurrencyconverurlList1() {
        return currencyconverurlList1;
    }

    public void setCurrencyconverurlList1(List<Currencyconverurl> currencyconverurlList1) {
        this.currencyconverurlList1 = currencyconverurlList1;
    }

    @XmlTransient
    public List<Exchange> getExchangeList() {
        return exchangeList;
    }

    public void setExchangeList(List<Exchange> exchangeList) {
        this.exchangeList = exchangeList;
    }

    @XmlTransient
    public List<Exchange> getExchangeList1() {
        return exchangeList1;
    }

    public void setExchangeList1(List<Exchange> exchangeList1) {
        this.exchangeList1 = exchangeList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.moneyxchange.persistence.entities.Currency[ id=" + id + " ]";
    }
    
}
