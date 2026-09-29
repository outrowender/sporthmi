/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.util;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.evo.util.AbstractTelStageChangeListener$ViewSizeServiceTrackerListener;

public abstract class AbstractTelStageChangeListener
extends AbstractPhoneComponent {
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IViewSizeManager;

    public AbstractTelStageChangeListener(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
        this.addSubPhoneComponent(new AbstractTelStageChangeListener$ViewSizeServiceTrackerListener(this, iTelApplication, string));
    }

    protected abstract void smallStageShown() {
    }

    protected abstract void largeStateShown() {
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

