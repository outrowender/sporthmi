/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;

public class OnCommunicationUpHandler
extends AbstractEcallComponent
implements IGlobalEcallStateListener {
    public OnCommunicationUpHandler(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.Main");
    }

    @Override
    public void init() {
        this.getApplication().getEcallStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        this.getApplication().getEcallStateManager().registerListener(this);
    }

    @Override
    public void updateGlobalEcallStateProperty(int n, IEcallStateStruct iEcallStateStruct) {
        if (n == 6) {
            this.log.log(-2137614336, "OnCommunicationUpHandler#updateGlobalEcallStateProperty(): ATTR_ECALL_ON_COMMUNICATION_UP");
            this.getEcallBapServiceAdapter().onCommunicationUp();
        }
    }
}

