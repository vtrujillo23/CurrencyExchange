/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneyxchange.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vtrujillo
 */
@Entity
@Table(name = "exchange",schema="currencyexchange")
public class Exchange implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @Column(name = "dateexchange")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateexchange;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "fromcurrency", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Currency fromcurrency;
    @JoinColumn(name = "tocurrency", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Currency tocurrency;

    public Exchange() {
    }

    public Exchange(Integer id) {
        this.id = id;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getDateexchange() {
        return dateexchange;
    }

    public void setDateexchange(Date dateexchange) {
        this.dateexchange = dateexchange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Currency getFromcurrency() {
        return fromcurrency;
    }

    public void setFromcurrency(Currency fromcurrency) {
        this.fromcurrency = fromcurrency;
    }

    public Currency getTocurrency() {
        return tocurrency;
    }

    public void setTocurrency(Currency tocurrency) {
        this.tocurrency = tocurrency;
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
        if (!(object instanceof Exchange)) {
            return false;
        }
        Exchange other = (Exchange) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.moneyxchange.persistence.entities.Exchange[ id=" + id + " ]";
    }
    
}
