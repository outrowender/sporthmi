/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.combi.bap.dsi.fastlist.listener.DSIFastListScrollingNavigationListenerImpl;
import de.audi.app.combi.bap.fw.arrays.fastlist.AbstractListAdapterFastList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener;

public abstract class AbstractListAdapterFastListNavi
extends AbstractListAdapterFastList {
    private final DSIFastListScrollingNavigationListener dsiListener = new DSIFastListScrollingNavigationListenerImpl(this);
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener;

    public AbstractListAdapterFastListNavi(ArrayHandler arrayHandler) {
        super(arrayHandler);
    }

    protected final DSIListener getDSIListener() {
        return this.dsiListener;
    }

    protected final Class getDSIListenerClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener = AbstractListAdapterFastListNavi.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener;
    }

    public abstract void setNotificationLastDestinationsList(boolean var1);

    public abstract void setNotificationFavoriteDestinationsList(boolean var1);

    public abstract void setNotificationCurrentListSizes(boolean var1);

    public abstract void addNavBookJob(int var1, int var2, ArrayHeader var3);

    public abstract void addNavBookJobs(int var1, int var2, ArrayHeader[] var3);

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

