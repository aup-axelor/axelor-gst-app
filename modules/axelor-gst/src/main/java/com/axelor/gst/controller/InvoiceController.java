package com.axelor.gst.controller;

import com.axelor.gst.service.SequenceService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class InvoiceController {
	
	  @Inject
	  SequenceService sequenceService;
	
    public void getReference(ActionRequest request, ActionResponse response){

      String reference= sequenceService.getReference("Invoice");
      if(reference=="") response.setError("No sequence is specified for the party");
      else response.setValue("reference",reference);

  }
}
