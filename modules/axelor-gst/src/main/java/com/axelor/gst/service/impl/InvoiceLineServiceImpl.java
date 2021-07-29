package com.axelor.gst.service.impl;

import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.db.State;
import com.axelor.gst.service.InvoiceLineService;

import java.math.BigDecimal;

public class InvoiceLineServiceImpl implements InvoiceLineService {
    @Override
    public BigDecimal getIgst(Invoice invoice, InvoiceLine invoiceLine) {
        State invoiceState=invoice.getInvoiceAddress().getState();
        State companyState=invoice.getCompany().getAddress().getState();

        if(!invoiceState.equals(companyState)){
            return invoiceLine.getGstRate().multiply(invoiceLine.getNetAmount());
        }
        return BigDecimal.ZERO;
    }
    public BigDecimal getSgst(Invoice invoice, InvoiceLine invoiceLine) {
        State invoiceState=invoice.getInvoiceAddress().getState();
        State companyState=invoice.getCompany().getAddress().getState();

        if(invoiceState.equals(companyState)){
            return invoiceLine.getGstRate().multiply(invoiceLine.getNetAmount()).divide(new BigDecimal(2));
        }
        return BigDecimal.ZERO;
    }
    public BigDecimal getCgst(Invoice invoice, InvoiceLine invoiceLine) {
        State invoiceState=invoice.getInvoiceAddress().getState();
        State companyState=invoice.getCompany().getAddress().getState();

        return invoiceLine.getGstRate().multiply(invoiceLine.getNetAmount()).divide(new BigDecimal(2));
    }

    public BigDecimal getGrossAmount(InvoiceLine invoiceLine){
        return invoiceLine.getIgst().add(invoiceLine.getCgst())
                .add(invoiceLine.getSgst()).add(invoiceLine.getNetAmount());
    }

}
