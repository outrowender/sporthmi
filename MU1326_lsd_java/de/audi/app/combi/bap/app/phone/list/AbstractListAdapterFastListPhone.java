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

    public int[] getDSINotifications() {
        return new int[0];
    }

    protected final DSIListener getDSIListener() {
        return this.dsiListener;
    }

    protected final Class getDSIListenerClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener = AbstractListAdapterFastListPhone.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener;
    }

    public abstract void setNotificationFavoriteList(boolean var1);

    public abstract void setNotificationCombinedNumbers(boolean var1);

    public abstract void setNotificationCurrentListSizes(boolean var1);

    public abstract void addPhonebookJob(int var1, int var2, ArrayHeader var3);

    public abstract void addPhonebookJobs(int var1, int var2, ArrayHeader[] var3);

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

