/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$1;

class SeekActiveContentHandler$ReplaceButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SeekActiveContentHandler this$0;

    private SeekActiveContentHandler$ReplaceButtonListener(SeekActiveContentHandler seekActiveContentHandler) {
        this.this$0 = seekActiveContentHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (SeekActiveContentHandler.access$1600(this.this$0) != null) {
            SeekActiveContentHandler.access$700(this.this$0).hidePartialPopup(17);
            switch (SeekActiveContentHandler.access$1600(this.this$0).getTypeOfContent()) {
                case 1: {
                    SeekActiveContentHandler.access$700(this.this$0).showPartialPopup(19);
                    break;
                }
                case 2: 
                case 3: {
                    SeekActiveContentHandler.access$700(this.this$0).showPartialPopup(20);
                    break;
                }
            }
        }
    }

    /* synthetic */ SeekActiveContentHandler$ReplaceButtonListener(SeekActiveContentHandler seekActiveContentHandler, SeekActiveContentHandler$1 seekActiveContentHandler$1) {
        this(seekActiveContentHandler);
    }
}

