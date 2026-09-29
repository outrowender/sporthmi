/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler$1;

class SDARSAdvisoryHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SDARSAdvisoryHandler this$0;

    private SDARSAdvisoryHandler$ButtonListener(SDARSAdvisoryHandler sDARSAdvisoryHandler) {
        this.this$0 = sDARSAdvisoryHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 100441: 
            case 100619: {
                this.this$0.requestAdvisory(11);
                break;
            }
            case 100631: {
                this.this$0.requestAdvisory(2);
                break;
            }
            case 100317: 
            case 100874: {
                boolean bl = n == -578354944;
                SDARSAdvisoryHandler.access$100(this.this$0, n3, bl);
                break;
            }
        }
    }

    /* synthetic */ SDARSAdvisoryHandler$ButtonListener(SDARSAdvisoryHandler sDARSAdvisoryHandler, SDARSAdvisoryHandler$1 sDARSAdvisoryHandler$1) {
        this(sDARSAdvisoryHandler);
    }
}

