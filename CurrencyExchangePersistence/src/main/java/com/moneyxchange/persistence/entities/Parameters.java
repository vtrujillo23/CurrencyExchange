/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneyxchange.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vtrujillo
 */
@Entity
@Table(name = "parameters",schema="currencyexchange")
public class Parameters implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "paramkey")
    private String paramkey;
    @Column(name = "paramvalue")
    private String paramvalue;

    public Parameters() {
    }

    public Parameters(String paramkey) {
        this.paramkey = paramkey;
    }

    public String getParamkey() {
        return paramkey;
    }

    public void setParamkey(String paramkey) {
        this.paramkey = paramkey;
    }

    public String getParamvalue() {
        return paramvalue;
    }

    public void setParamvalue(String paramvalue) {
        this.paramvalue = paramvalue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paramkey != null ? paramkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parameters)) {
            return false;
        }
        Parameters other = (Parameters) object;
        if ((this.paramkey == null && other.paramkey != null) || (this.paramkey != null && !this.paramkey.equals(other.paramkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.moneyxchange.persistence.entities.Parameters[ paramkey=" + paramkey + " ]";
    }
    
}
