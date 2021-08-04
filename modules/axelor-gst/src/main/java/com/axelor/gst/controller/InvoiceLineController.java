package com.axelor.gst.controller;

import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.service.InvoiceLineService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

import java.math.BigDecimal;

public class InvoiceLineController {

    @Inject
    InvoiceLineService service;

    public void getTaxes(ActionRequest request, ActionResponse response){
        InvoiceLine line=request.getContext().asType(InvoiceLine.class);
        Invoice invoice=request.getContext().getParent().asType(Invoice.class);//
        BigDecimal igst=service.getIgst(invoice,line);
        BigDecimal sgst=service.getSgst(invoice,line);
        BigDecimal cgst=service.getCgst(invoice,line);
        response.setValue("igst",igst);
        response.setValue("cgst",cgst);
        response.setValue("sgst",sgst);
    }

    public void getGrossAmount(ActionRequest request,ActionResponse response){
        InvoiceLine line=request.getContext().asType(InvoiceLine.class);
        BigDecimal grossAmount=service.getGrossAmount(line);
        response.setValue("grossAmount",grossAmount);
    }
}
