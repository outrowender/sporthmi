/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.indication.IBAPFunctionStatusAllListener;
import de.audi.app.bap.utils.ErrorCodes;
import de.vw.mib.bap.datatypes.BAPEntity;

public class BAPFunctionGetAll
extends AbstractBAPFunction {
    private IBAPFunctionStatusAllListener listener;

    public BAPFunctionGetAll(AbstractBAPModule abstractBAPModule, int n) {
        super(abstractBAPModule, n);
    }

    @Override
    public BAPEntity getIndicationSerializer(int n) {
        return null;
    }

    @Override
    public void reset() {
        this.logChannel.log(14808325, "[BAPFunctionGetAll#reset] called; do nothing");
    }

    @Override
    protected boolean isIndicationTypeSupported(int n) {
        return n == 9;
    }

    @Override
    protected void doProcessIndication(int n, BAPEntity bAPEntity) {
        if (n == 9) {
            this.statusAllIND();
        }
    }

    @Override
    protected void doProcessError(int n) {
        this.logChannel.log(-2137614336, "[BAPFunctionGetAll#doProcessError] Received BAP Error: 0x%2, %1", (Object)ErrorCodes.getDescription(n), (long)n);
    }

    public void setStatusAllListener(IBAPFunctionStatusAllListener iBAPFunctionStatusAllListener) {
        this.listener = iBAPFunctionStatusAllListener;
        this.logChannel.log(-2137614336, "[BAPFunctionGetAll#setStatusAllListener] listener=%1", (Object)iBAPFunctionStatusAllListener);
    }

    public void resetStatusAllListener() {
        this.listener = null;
    }

    public void getAllREQ() {
        this.logChannel.log(-2137614336, "[BAPFunctionGetAll#getAllREQ] lsgID=%1, send GetAll request", (Object)this.lsgIDDesc);
        this.sendRequest(2);
    }

    private void statusAllIND() {
        this.logChannel.log(-2137614336, "[BAPFunctionGetAll#statusAllIND] lsgID=%1, StatusAll received", (Object)this.lsgIDDesc);
        if (this.listener != null) {
            this.listener.notifyStatusAllIndicationReceived(this.fctID);
        }
    }
}

