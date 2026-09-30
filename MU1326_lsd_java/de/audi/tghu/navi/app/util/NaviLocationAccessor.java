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
    public static final int ADDITIONALFLAG_POI_24H = 1;
    public static final int ADDITIONALFLAG_POI_3D = 2;
    public static final int ADDITIONALFLAG_POI_PREMIUM = 4;
    public static final int ADDITIONALFLAG_POI_DIESEL = 8;
    public static final int ADDITIONALFLAG_FULLPOSTALCODE = 0x8000000;
    public static final int ADDITIONALFLAG_NEEDEDFORREFINEMENT_TOWNREFINEMENT = 0x10000000;
    public static final int ADDITIONALFLAG_NEEDEDFORREFINEMENT_ZIPCODE = 0x20000000;
    public static final int ADDITIONALFLAG_ISSPELLED_ZIPCODE = 0x40000000;
    public static final int ADDITIONALFLAG_TOWNISORDER9 = Integer.MIN_VALUE;
    public static final int LOCATIONTYPE_GEOGRAPHICAL_POSITION = 2;
    private final LogChannel logChannel;
    private IAdapterManager manager;
    private IMyLocationAccessorFactory factory;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$util$ILocationAccessorFactory;

    public NaviLocationAccessor(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void registerAdapterManager(IAdapterManager iAdapterManager) {
        this.logChannel.log(10000000, "NaviLocationAccessor#registerAdapterManager( %1 )", (Object)iAdapterManager);
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
                this.logChannel.log(10000000, "NaviLocationAccessor#updateLocationAccessor() - retrieved ILocationAccessorFactory");
                this.factory = new PCLocationAccessorFactory(iLocationAccessorFactory);
            } else {
                this.logChannel.log(100000, "NaviLocationAccessor#updateLocationAccessor() - no ILocationAccessorFactory registered, using default implementation!");
                this.factory = new PCLocationAccessorFactory(null);
            }
        } else {
            this.logChannel.log(10000000, "NaviLocationAccessor#updateLocationAccessor() - remove ILocationAccessorFactory");
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

