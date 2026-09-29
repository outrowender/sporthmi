/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.kombipictures;

import de.audi.app.combi.bap.app.kombipictures.AbstractPictureManager$1;
import de.audi.app.combi.bap.app.kombipictures.IPictureManager;
import de.audi.app.combi.bap.app.kombipictures.IPictureProvider;
import de.audi.app.combi.bap.dsi.pictureserver.DSIKombiPictureServerController;
import de.audi.app.combi.bap.dsi.pictureserver.DSIKombiPictureServerListenerImpl;
import de.audi.app.combi.bap.dsi.pictureserver.IDSIKombiPictureServerController;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractPictureManager
implements IPictureManager {
    protected static final int DEFAULT_PICTURE_COVER_ART;
    protected static final int DEFAULT_PICTURE_STATION_ART;
    protected static final int DEFAULT_PICTURE_ACTIVE_CALL;
    protected static final int DEFAULT_PICTURE_ACTIVE_CALL_CONFERENCE;
    protected static final int DEFAULT_PICTURE_ADB_CONTACT;
    private static final int ACTIVECALLPICTURETYPE_DEFAULT;
    private static final int INVALID_RESOURCE_LOCATOR_ID;
    private final LogChannel logChannel = CombiLogger.getPicServerLog();
    private final IFrameworkAccess frameworkAccess;
    private final Map pictureProviders;
    private final DSIKombiPictureServerListener dsiKombiPictureServerListener;
    private final IDSIKombiPictureServerController dsiKombiPictureServerController;
    private volatile ServiceRegistration serviceRegPictureManager;
    private ServiceTracker serviceTrackerDSIKombiPictureServerListener;
    private final boolean[] notifications;
    private long currentStationArtEntryID;
    private ResourceLocator currentStationArtRL;
    static /* synthetic */ Class class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer;
    static /* synthetic */ Class class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public AbstractPictureManager(IFrameworkAccess iFrameworkAccess) {
        this.frameworkAccess = iFrameworkAccess;
        this.pictureProviders = new HashMap(4);
        this.notifications = new boolean[4];
        this.dsiKombiPictureServerController = new DSIKombiPictureServerController();
        this.dsiKombiPictureServerListener = new DSIKombiPictureServerListenerImpl(this);
    }

    @Override
    public void init(BundleContext bundleContext) {
        this.registerDSIKombiPictureServerListener(bundleContext);
        this.serviceTrackerDSIKombiPictureServerListener = new ServiceTracker(bundleContext, (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer = AbstractPictureManager.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServer")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer).getName(), (ServiceTrackerCustomizer)new AbstractPictureManager$1(this, bundleContext));
        this.serviceTrackerDSIKombiPictureServerListener.open();
        this.frameworkAccess.startDSIService((class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer = AbstractPictureManager.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServer")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer).getName(), 0);
    }

    @Override
    public void deinit() {
        this.serviceRegPictureManager.unregister();
        this.serviceTrackerDSIKombiPictureServerListener.close();
    }

    @Override
    public void setNotification(int n) {
        if (n >= 0 && n < 4) {
            this.notifications[n] = true;
        } else {
            this.logChannel.log(10000, "[AbstractPictureManager#setNotification] invalid notification: %1", (long)n);
        }
    }

    private void registerDSIKombiPictureServerListener(BundleContext bundleContext) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener = AbstractPictureManager.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        hashtable.put("moduleID", new Integer(20));
        this.logChannel.log(-2137614336, "[CombiActivator#start] Registering DSIKombiPictureServerListener");
        this.serviceRegPictureManager = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractPictureManager.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.dsiKombiPictureServerListener, (Dictionary)hashtable);
    }

    @Override
    public IDSIKombiPictureServerController getDSIKombiPictureServerController() {
        return this.dsiKombiPictureServerController;
    }

    @Override
    public DSIKombiPictureServerListener getDSIKombiPictureServerListener() {
        return this.dsiKombiPictureServerListener;
    }

    private int convertToDSISourceType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 8;
            }
            case 9: {
                return 9;
            }
            case 10: {
                return 10;
            }
            case 11: {
                return 11;
            }
            case 12: {
                return 12;
            }
            case 13: {
                return 13;
            }
            case 14: {
                return 14;
            }
            case 15: {
                return 15;
            }
            case 16: {
                return 16;
            }
            case 17: {
                return 17;
            }
            case 18: {
                return 18;
            }
            case 19: {
                return 19;
            }
            case 20: {
                return 20;
            }
            case 21: {
                return 21;
            }
            case 22: {
                return 22;
            }
            case 23: {
                return 23;
            }
            case 24: {
                return 24;
            }
            case 31: {
                return 25;
            }
            case 32: {
                return 32;
            }
            case 33: {
                return 33;
            }
            case 34: {
                return 28;
            }
            case 35: {
                return 35;
            }
            case 255: {
                return 255;
            }
        }
        this.logChannel.log(-1601830656, "[AbstractPictureManager#convertToDSISourceType] sourceType not available at DSIKombiPictureServer: %1", (long)n);
        return n;
    }

    @Override
    public void registerPictureProvider(int n, IPictureProvider iPictureProvider) {
        this.logChannel.log(-2137614336, "[AbstractPictureManager#registerPictureProvider] pictureProvider registered: pictureType=%2, %1", (Object)iPictureProvider, (long)n);
        this.pictureProviders.put(new Integer(n), iPictureProvider);
    }

    @Override
    public void requestCoverArt(long l, int n) {
        this.logChannel.log(-2137614336, "[AbstractPictureManager#requestCoverArt] bapEntryID=%1, sourceType=%2", l, (long)n);
        IPictureProvider iPictureProvider = (IPictureProvider)this.pictureProviders.get(new Integer(0));
        if (iPictureProvider != null) {
            iPictureProvider.requestPicture(l, n);
        } else {
            this.logChannel.log(-1601830656, "[AbstractPictureManager#requestActiveCallPicture] no picture provider for cover art available!");
        }
    }

    @Override
    public void responseCoverArt(long l, int n, ResourceLocator resourceLocator, boolean bl) {
        this.logChannel.log(1078071040, "[AbstractPictureManager#responseCoverArt] bapEntryID=%2, sourceType=%3, resourceLocator=%1", (Object)resourceLocator, l, (long)n);
        if (!this.frameworkAccess.getSysConstManager().getAdaptationANP().isCoverartAvailable()) {
            this.logChannel.log(-1601830656, "[AbstractPictureManager#responseCoverArt] adaption for coverArt not set");
            return;
        }
        if (bl && !this.notifications[0]) {
            this.logChannel.log(-1601830656, "[AbstractPictureManager#responseCoverArt] push notification not set");
            return;
        }
        if (resourceLocator == null || resourceLocator.isIntResource() && -1 == resourceLocator.getId()) {
            resourceLocator = this.getDefaultPicture(0);
            this.logChannel.log(-2137614336, "[AbstractPictureManager#responseCoverArt] resourceLocator is empty -> use default picture: %1", (Object)resourceLocator.getUrl());
        }
        this.dsiKombiPictureServerController.responseCoverArt(l, 0, this.convertToDSISourceType(n), 1, resourceLocator);
    }

    @Override
    public void requestStationArt(long l, int n) {
        this.logChannel.log(-2137614336, "[AbstractPictureManager#requestStationArt] bapEntryID=%1, sourceType=%2", l, (long)n);
        if (l == this.currentStationArtEntryID) {
            this.responseStationArt(this.currentStationArtEntryID, n, this.currentStationArtRL, false);
        } else {
            IPictureProvider iPictureProvider = (IPictureProvider)this.pictureProviders.get(new Integer(1));
            if (iPictureProvider != null) {
                iPictureProvider.requestPicture(l, n);
            } else {
                this.logChannel.log(-1601830656, "[AbstractPictureManager#requestActiveCallPicture] no picture provider for station art available!");
            }
        }
    }

    @Override
    public void responseStationArt(long l, int n, ResourceLocator resourceLocator, boolean bl) {
        int n2;
        this.logChannel.log(1078071040, "[AbstractPictureManager#responseStationArt] bapEntryID=%2, sourceType=%3, resourceLocator=%1", (Object)resourceLocator, l, (long)n);
        if (!this.frameworkAccess.getSysConstManager().getAdaptationANP().isStationartAvailable()) {
            this.logChannel.log(-1601830656, "[AbstractPictureManager#responseStationArt] adaption for stationArt not set");
            return;
        }
        if (bl && !this.notifications[1]) {
            this.logChannel.log(-1601830656, "[AbstractPictureManager#responseStationArt] push notification not set");
            return;
        }
        this.currentStationArtEntryID = l;
        this.currentStationArtRL = resourceLocator;
        if (resourceLocator == null || resourceLocator.isIntResource() && -1 == resourceLocator.getId()) {
            n2 = 2;
            resourceLocator = this.getDefaultPicture(1);
            this.logChannel.log(-2137614336, "[AbstractPictureManager#responseStationArt] resourceLocator is empty -> use default picture: %1", (Object)resourceLocator.getUrl());
        } else {
            n2 = 1;
        }
        this.dsiKombiPictureServerController.responseStationArt(l, 0, this.convertToDSISourceType(n), n2, resourceLocator);
    }

    @Override
    public void requestActiveCallPicture(int n) {
        this.logChannel.log(-2137614336, "[AbstractPictureManager#requestActiveCallPicture] callID=%1", (long)n);
        IPictureProvider iPictureProvider = (IPictureProvider)this.pictureProviders.get(new Integer(2));
        if (iPictureProvider != null) {
            iPictureProvider.requestPicture(n);
        } else {
            this.logChannel.log(-1601830656, "[AbstractPictureManager#requestActiveCallPicture] no picture provider for call picture available!");
        }
    }

    @Override
    public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator, boolean bl) {
        ResourceLocator resourceLocator2;
        int n3;
        this.logChannel.log(1078071040, "[AbstractPictureManager#responseActiveCallPicture] callID=%2, callType=%3, resourceLocator=%1", (Object)resourceLocator, (long)n, (long)n2);
        if (!this.frameworkAccess.getSysConstManager().getAdaptationANP().isCallPictureAvailable()) {
            this.logChannel.log(-1601830656, "[AbstractPictureManager#responseActiveCallPicture] adaptation for callPicture not set");
            return;
        }
        if (bl && !this.notifications[2]) {
            this.logChannel.log(-1601830656, "[AbstractPictureManager#responseActiveCallPicture] push notification not set");
            return;
        }
        if (5 == n2) {
            n3 = 5;
            resourceLocator2 = this.getDefaultPicture(21);
            this.logChannel.log(-2137614336, "[AbstractPictureManager#responseActiveCallPicture] use default conference picture: pictureType='%1',  url='%2'", (Object)Integer.toString(n3), (Object)resourceLocator2.getUrl());
        } else if (resourceLocator == null || resourceLocator.isIntResource() && -1 == resourceLocator.getId()) {
            n3 = 6;
            resourceLocator2 = this.getDefaultPicture(2);
            this.logChannel.log(-2137614336, "[AbstractPictureManager#responseActiveCallPicture] resourceLocator is empty -> use default picture: %1", (Object)resourceLocator2.getUrl());
        } else {
            switch (n2) {
                case 4: 
                case 8: {
                    n3 = 4;
                    break;
                }
                case 5: {
                    n3 = 5;
                    break;
                }
                case 6: {
                    n3 = 2;
                    break;
                }
                case 7: {
                    n3 = 3;
                    break;
                }
                default: {
                    n3 = 1;
                }
            }
            resourceLocator2 = resourceLocator;
        }
        this.dsiKombiPictureServerController.responseActiveCallPicture(n, n3, resourceLocator2);
    }

    @Override
    public void requestAdbContactPicture(long l) {
        this.logChannel.log(-2137614336, "[AbstractPictureManager#requestAdbContactPicture] bapEntryID=%1", l);
        IPictureProvider iPictureProvider = (IPictureProvider)this.pictureProviders.get(new Integer(3));
        if (iPictureProvider != null) {
            iPictureProvider.requestPicture(l);
        } else {
            this.logChannel.log(-1601830656, "[AbstractPictureManager#requestAdbContactPicture] no picture provider for addressbook contact picture available!");
        }
    }

    @Override
    public void responseAdbContactPicture(long l, ResourceLocator resourceLocator) {
        int n;
        this.logChannel.log(1078071040, "[AbstractPictureManager#responseAdbContactPicture] bapEntryID=%2, resourceLocator=%1", (Object)resourceLocator, l);
        if (resourceLocator == null || resourceLocator.isIntResource() && -1 == resourceLocator.getId()) {
            n = 2;
            resourceLocator = this.getDefaultPicture(3);
            this.logChannel.log(-2137614336, "[AbstractPictureManager#responseAdbContactPicture] resourceLocator is empty -> use default picture: %1", (Object)resourceLocator.getUrl());
        } else {
            n = 1;
        }
        this.dsiKombiPictureServerController.responseAdbContactPicture(l, 0, n, resourceLocator);
    }

    private ResourceLocator getDefaultPicture(int n) {
        String string;
        int n2 = this.getDefaultPictureImageID(n);
        HMIBundle hMIBundle = this.frameworkAccess.getHMIService().getHMIBundle(n2);
        if (n2 == -1 || hMIBundle == null) {
            this.logChannel.log(-1601830656, "[AbstractPictureManager#getDefaultPicture] no default picture available -> use fallback picture");
            string = "default.png";
        } else {
            string = hMIBundle.getImagePath(n2, 0);
        }
        Buffer buffer = new Buffer();
        buffer.append(System.getProperty("ImageRoot", "/images"));
        buffer.append('/');
        buffer.append(string);
        return new ResourceLocator(buffer.toString());
    }

    protected abstract int getDefaultPictureImageID(int n) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(AbstractPictureManager abstractPictureManager) {
        return abstractPictureManager.logChannel;
    }

    static /* synthetic */ IDSIKombiPictureServerController access$100(AbstractPictureManager abstractPictureManager) {
        return abstractPictureManager.dsiKombiPictureServerController;
    }

    static /* synthetic */ DSIKombiPictureServerListener access$200(AbstractPictureManager abstractPictureManager) {
        return abstractPictureManager.dsiKombiPictureServerListener;
    }
}

