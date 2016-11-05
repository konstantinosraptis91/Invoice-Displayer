/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice.displayer.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author konstantinos
 */
@XmlRootElement(name = "invoices")
@XmlSeeAlso({Invoice.class})
public class InvoiceList {
    
    private List<Invoice> invoices;

    public InvoiceList() {
        invoices = new ArrayList<>();
    }

    public InvoiceList(List<Invoice> invoices) {
        this.invoices = invoices;
    }
    
    @XmlAnyElement
    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    

}
