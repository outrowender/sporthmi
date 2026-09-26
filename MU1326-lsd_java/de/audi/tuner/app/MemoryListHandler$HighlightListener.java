/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.dsi.RadioInfo;

class MemoryListHandler$HighlightListener
extends RadioInfo {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$HighlightListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void updateStation(TunerObjectContainer tunerObjectContainer, int n) {
        switch (tunerObjectContainer.getType()) {
            case 3: {
                MemoryListHandler.access$2200(this.this$0, tunerObjectContainer.getAMFMService(), n);
                break;
            }
            case 6: {
                MemoryListHandler.access$2300(this.this$0, tunerObjectContainer.getDABStation(), tunerObjectContainer.getReceptionStatus(), n);
                break;
            }
            case 7: {
                MemoryListHandler.access$2400(this.this$0, tunerObjectContainer.getUniStation(), n);
                break;
            }
            case 5: {
                this.this$0.setCurrentStation(tunerObjectContainer.getSDARSService(), n);
                break;
            }
        }
        if (this.this$0.firstHighlightCall) {
            MemoryListHandler.access$2500(this.this$0).trigger(ModelTrigger.JOIN_CURSOR);
            this.this$0.firstHighlightCall = false;
        }
    }

    /* synthetic */ MemoryListHandler$HighlightListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

