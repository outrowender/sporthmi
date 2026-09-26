/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.online.IOperatorCallSDSService;
import de.audi.atip.interapp.online.IOperatorCallSDSServiceListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.online.OperatorCallResult;

public class NullOperatorCallSDSService
extends NullService
implements IOperatorCallSDSService {
    public NullOperatorCallSDSService(LogChannel logChannel) {
        super(logChannel, "OperatorCallSDSService");
    }

    @Override
    public void startCallcenterCallBySDS(int n, IOperatorCallSDSServiceListener iOperatorCallSDSServiceListener, boolean bl) {
        super.log();
    }

    @Override
    public int getNumberOfPoisOfHistoryCallForSDS(int n, int n2) {
        return 0;
    }

    @Override
    public OperatorCallResult getPoiOfIndexForSDS(int n, int n2) {
        return null;
    }
}

