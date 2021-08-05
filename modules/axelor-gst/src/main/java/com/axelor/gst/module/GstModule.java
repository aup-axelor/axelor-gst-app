package com.axelor.gst.module;

import com.axelor.app.AxelorModule;
import com.axelor.gst.service.InvoiceLineService;
import com.axelor.gst.service.InvoiceService;
import com.axelor.gst.service.SequenceService;
import com.axelor.gst.service.impl.InvoiceLineServiceImpl;
import com.axelor.gst.service.impl.InvoiceServiceImpl;
import com.axelor.gst.service.impl.SequenceServiceImpl;

public class GstModule extends AxelorModule {
    @Override
    protected void configure() {
        bind(SequenceService.class).to(SequenceServiceImpl.class);
        bind(InvoiceLineService.class).to(InvoiceLineServiceImpl.class);
        bind(InvoiceService.class).to(InvoiceServiceImpl.class);
        
    }
}
