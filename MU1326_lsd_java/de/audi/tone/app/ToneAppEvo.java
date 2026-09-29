/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.variant.IGUIVariantProvider;
import de.audi.tone.app.ToneActionProxyEvo;
import de.audi.tone.app.ap.ActionProxyListener;
import de.audi.tone.app.init.ToneAppCommon;
import de.audi.tone.app.volume.VolumeRangeManager;

public class ToneAppEvo
extends ToneAppCommon {
    final ToneActionProxyEvo actionProxy;

    ToneAppEvo(IFrameworkAccess iFrameworkAccess, IGUIVariantProvider iGUIVariantProvider) {
        super(iFrameworkAccess, iGUIVariantProvider);
        this.volMenuManager = new VolumeRangeManager(this.env, this.dsiSound, this.audioService);
        ActionProxyListener[] actionProxyListenerArray = this.getCommonActionProxyListeners();
        ActionProxyListener[] actionProxyListenerArray2 = new ActionProxyListener[]{this.volMenuManager.actionProxyListener};
        ActionProxyListener[] actionProxyListenerArray3 = this.merge(actionProxyListenerArray, actionProxyListenerArray2);
        this.actionProxy = new ToneActionProxyEvo(this.env.lcHMI, actionProxyListenerArray3);
    }
}

