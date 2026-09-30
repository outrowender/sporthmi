/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.evo.proxy;

import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.TunerActionProxy;
import de.audi.tuner.app.ap.TunerActionProxyCore;
import de.audi.tuner.app.ap.TunerActionProxyListener;

public class TunerActionProxyEvo
extends TunerActionProxyCore
implements TunerActionProxy {
    public TunerActionProxyEvo(LogChannel logChannel, TunerActionProxyListener[] tunerActionProxyListenerArray) {
        super(logChannel, tunerActionProxyListenerArray);
    }

    public void tunerListSearchEntered(int n) {
        this.lc.log(1000000, "[TunerActionProxy.tunerListSearchEntered]");
    }

    public void tunerListSearchLeft(int n) {
        this.lc.log(1000000, "[TunerActionProxy.tunerListSearchLeft]");
    }

    public void tunerListUpdateLeft(int n) {
    }
}

