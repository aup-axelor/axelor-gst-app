package com.axelor.gst.controller;

import com.axelor.gst.db.Party;
import com.axelor.gst.service.SequenceService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class PartyController {

    @Inject
    SequenceService sequenceService;


    public void getReference(ActionRequest request, ActionResponse response){
//        Party party=request.getContext().asType(Party.class);
        String reference= sequenceService.getReference("Party");
        if(reference=="") response.setError("No sequence is specified for the Invoice");
        else response.setValue("reference",reference);
    }
}
