package com.axelor.gst.controller;

import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.service.SequenceService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

import java.util.Date;

import org.slf4j.Logger;

public class InvoiceController {
	@Inject
	SequenceService sequenceService;

	@Inject
	private Logger log;

	public void getReference(ActionRequest request, ActionResponse response) {

		String reference = sequenceService.getReference("Invoice");
		if (reference == "")
			response.setError("No sequence is specified for the party");
		else
			response.setValue("reference", reference);
		log.info("Reference");

	}

	public void getInvoiceLineData(ActionRequest request, ActionResponse response) {
		InvoiceLine line = request.getContext().asType(InvoiceLine.class);
		Invoice invoice = request.getContext().asType(Invoice.class);

	}

	public void invoiceOnNew(ActionRequest request, ActionResponse response) {
		response.setValue("status", "Draft");
		log.debug("Draft");
	}

}
