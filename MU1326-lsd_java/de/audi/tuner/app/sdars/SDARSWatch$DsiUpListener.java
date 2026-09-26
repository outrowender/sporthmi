/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SDARSWatch;
import de.audi.tuner.app.sdars.SDARSWatch$1;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.global.DateTime;

class SDARSWatch$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SDARSWatch this$0;

    private SDARSWatch$DsiUpListener(SDARSWatch sDARSWatch) {
        this.this$0 = sDARSWatch;
    }

    @Override
    public void responseTime(DateTime dateTime) {
        this.this$0.updateModuleTime(dateTime.time);
    }

    /* synthetic */ SDARSWatch$DsiUpListener(SDARSWatch sDARSWatch, SDARSWatch$1 sDARSWatch$1) {
        this(sDARSWatch);
    }
}

