/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.ToneActionProxy;
import de.audi.tone.app.ap.ActionProxyListener;
import de.audi.tone.app.ap.ToneActionProxyBase;

public class ToneActionProxyEvo
extends ToneActionProxyBase
implements ToneActionProxy {
    ToneActionProxyEvo(LogChannel logChannel, ActionProxyListener[] actionProxyListenerArray) {
        super(logChannel, actionProxyListenerArray);
    }
}

