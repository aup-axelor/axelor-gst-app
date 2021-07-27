package com.axelor.gst.module;

import com.axelor.app.AxelorModule;
import com.axelor.gst.service.SequenceService;
import com.axelor.gst.service.impl.SequenceServiceImpl;

public class GstModule extends AxelorModule {
    @Override
    protected void configure() {
        bind(SequenceService.class).to(SequenceServiceImpl.class);
    }
}
