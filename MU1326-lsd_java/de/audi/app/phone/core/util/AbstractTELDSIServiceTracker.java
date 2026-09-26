/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.util;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public abstract class AbstractTELDSIServiceTracker
extends AbstractTelServiceTracker {
    private volatile DSIBase dsi;
    private final DSIListener dsiListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIBase;

    public AbstractTELDSIServiceTracker(ITelApplication iTelApplication, String string, Class clazz, DSIListener dSIListener) {
        super(iTelApplication, string, clazz);
        this.dsiListener = dSIListener;
    }

    @Override
    public void deinit() {
        super.deinit();
        DSIBase dSIBase = this.dsi;
        if (dSIBase != null) {
            dSIBase.clearNotification(this.dsiListener);
        }
    }

    @Override
    protected void serviceAvailable(Object object) {
        if ((class$org$dsi$ifc$base$DSIBase == null ? (class$org$dsi$ifc$base$DSIBase = AbstractTELDSIServiceTracker.class$("org.dsi.ifc.base.DSIBase")) : class$org$dsi$ifc$base$DSIBase).isInstance(object)) {
            ((DSIBase)object).setNotification(this.dsiListener);
        }
    }

    @Override
    protected void serviceRemoved(Object object) {
    }

    protected abstract int[] getNotifications() {
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

