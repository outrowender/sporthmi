/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.util.IMyLocationAccessorFactory;
import de.audi.tghu.navi.app.util.PCLocationAccessorFactory;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.base.IAdapterManager;
import org.dsi.ifc.navigation.util.ILocationAccessorFactory;

public class NaviLocationAccessor {
    public static final int ADDITIONALFLAG_POI_24H;
    public static final int ADDITIONALFLAG_POI_3D;
    public static final int ADDITIONALFLAG_POI_PREMIUM;
    public static final int ADDITIONALFLAG_POI_DIESEL;
    public static final int ADDITIONALFLAG_FULLPOSTALCODE;
    public static final int ADDITIONALFLAG_NEEDEDFORREFINEMENT_TOWNREFINEMENT;
    public static final int ADDITIONALFLAG_NEEDEDFORREFINEMENT_ZIPCODE;
    public static final int ADDITIONALFLAG_ISSPELLED_ZIPCODE;
    public static final int ADDITIONALFLAG_TOWNISORDER9;
    public static final int LOCATIONTYPE_GEOGRAPHICAL_POSITION;
    private final LogChannel logChannel;
    private IAdapterManager manager;
    private IMyLocationAccessorFactory factory;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$util$ILocationAccessorFactory;

    public NaviLocationAccessor(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void registerAdapterManager(IAdapterManager iAdapterManager) {
        this.logChannel.log(-2137614336, "NaviLocationAccessor#registerAdapterManager( %1 )", (Object)iAdapterManager);
        this.manager = iAdapterManager;
        this.updateLocationAccessorFactory();
    }

    public IMyLocationAccessorFactory getLocationAccessorFactory() {
        return this.factory != null ? this.factory : new PCLocationAccessorFactory(null);
    }

    private synchronized void updateLocationAccessorFactory() {
        if (Boolean.getBoolean("UseInternalLocationAccessor")) {
            if (this.factory == null) {
                this.factory = new PCLocationAccessorFactory(null);
            }
        } else if (this.manager != null) {
            ILocationAccessorFactory iLocationAccessorFactory = (ILocationAccessorFactory)this.manager.getFactory(class$org$dsi$ifc$navigation$util$ILocationAccessorFactory == null ? (class$org$dsi$ifc$navigation$util$ILocationAccessorFactory = NaviLocationAccessor.class$("org.dsi.ifc.navigation.util.ILocationAccessorFactory")) : class$org$dsi$ifc$navigation$util$ILocationAccessorFactory);
            if (iLocationAccessorFactory != null) {
                this.logChannel.log(-2137614336, "NaviLocationAccessor#updateLocationAccessor() - retrieved ILocationAccessorFactory");
                this.factory = new PCLocationAccessorFactory(iLocationAccessorFactory);
            } else {
                this.logChannel.log(-1601830656, "NaviLocationAccessor#updateLocationAccessor() - no ILocationAccessorFactory registered, using default implementation!");
                this.factory = new PCLocationAccessorFactory(null);
            }
        } else {
            this.logChannel.log(-2137614336, "NaviLocationAccessor#updateLocationAccessor() - remove ILocationAccessorFactory");
            this.factory = null;
        }
        Util.setLocationAccessorFactory(this.factory);
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

