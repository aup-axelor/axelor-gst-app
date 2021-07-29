package com.axelor.gst.service;

import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;

import java.math.BigDecimal;

public interface InvoiceLineService {

    BigDecimal getIgst(Invoice invoice, InvoiceLine invoiceLine);
    BigDecimal getSgst(Invoice invoice, InvoiceLine invoiceLine);
    BigDecimal getCgst(Invoice invoice, InvoiceLine invoiceLine);
    BigDecimal getGrossAmount(InvoiceLine invoiceLine);
}
