/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.combi.bap.dsi.fastlist.listener.DSIFastListScrollingTelephoneListenerImpl;
import de.audi.app.combi.bap.fw.arrays.fastlist.AbstractListAdapterFastList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener;

public abstract class AbstractListAdapterFastListPhone
extends AbstractListAdapterFastList {
    private final DSIFastListScrollingTelephoneListener dsiListener = new DSIFastListScrollingTelephoneListenerImpl(this);
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener;

    public AbstractListAdapterFastListPhone(ArrayHandler arrayHandler) {
        super(arrayHandler);
    }

    @Override
    public int[] getDSINotifications() {
        return new int[0];
    }

    @Override
    protected final DSIListener getDSIListener() {
        return this.dsiListener;
    }

    @Override
    protected final Class getDSIListenerClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener = AbstractListAdapterFastListPhone.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener;
    }

    public abstract void setNotificationFavoriteList(boolean bl) {
    }

    public abstract void setNotificationCombinedNumbers(boolean bl) {
    }

    public abstract void setNotificationCurrentListSizes(boolean bl) {
    }

    public abstract void addPhonebookJob(int n, int n2, ArrayHeader arrayHeader) {
    }

    public abstract void addPhonebookJobs(int n, int n2, ArrayHeader[] arrayHeaderArray) {
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

