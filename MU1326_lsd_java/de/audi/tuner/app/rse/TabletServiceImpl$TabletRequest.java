/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rse;

import de.audi.tuner.app.rse.TabletServiceImpl;
import de.audi.tuner.app.rse.TabletServiceImpl$1;
import de.audi.tuner.ifc.IRadioInterappService;

class TabletServiceImpl$TabletRequest
implements IRadioInterappService {
    private final /* synthetic */ TabletServiceImpl this$0;

    private TabletServiceImpl$TabletRequest(TabletServiceImpl tabletServiceImpl) {
        this.this$0 = tabletServiceImpl;
    }

    @Override
    public void tuneStation(long l) {
        try {
            TabletServiceImpl.access$100(this.this$0, l);
        }
        catch (Exception exception) {
            TabletServiceImpl.access$200((TabletServiceImpl)this.this$0).rse.log(10000, "%1", (Throwable)exception);
        }
    }

    @Override
    public void selectBand(int n) {
        try {
            TabletServiceImpl.access$300(this.this$0, n);
        }
        catch (Exception exception) {
            TabletServiceImpl.access$200((TabletServiceImpl)this.this$0).rse.log(10000, "%1", (Throwable)exception);
        }
    }

    /* synthetic */ TabletServiceImpl$TabletRequest(TabletServiceImpl tabletServiceImpl, TabletServiceImpl$1 tabletServiceImpl$1) {
        this(tabletServiceImpl);
    }
}

