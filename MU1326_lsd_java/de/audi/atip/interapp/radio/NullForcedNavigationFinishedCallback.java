/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.radio;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.radio.IForcedNavigationFinishedCallback;
import de.audi.atip.log.LogChannel;

public class NullForcedNavigationFinishedCallback
extends NullService
implements IForcedNavigationFinishedCallback {
    static /* synthetic */ Class class$de$audi$atip$interapp$radio$IForcedNavigationFinishedCallback;

    public NullForcedNavigationFinishedCallback(LogChannel logChannel) {
        super(logChannel, class$de$audi$atip$interapp$radio$IForcedNavigationFinishedCallback == null ? (class$de$audi$atip$interapp$radio$IForcedNavigationFinishedCallback = NullForcedNavigationFinishedCallback.class$("de.audi.atip.interapp.radio.IForcedNavigationFinishedCallback")) : class$de$audi$atip$interapp$radio$IForcedNavigationFinishedCallback);
    }

    @Override
    public void tvFullscreenEntered() {
        this.log("tvFullscreenEntered");
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

