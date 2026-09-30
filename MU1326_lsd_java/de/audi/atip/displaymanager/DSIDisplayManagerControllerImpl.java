/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.displaymanager.IDSIDisplayManagerController;
import de.audi.atip.displaymanager.NullDisplayManagerListener;
import de.audi.atip.interapp.displaymanager.IDisplayManagerListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIDisplayManagement;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;
import org.osgi.framework.BundleContext;

public class DSIDisplayManagerControllerImpl
implements IDSIDisplayManagerController,
DSIDisplayManagementListener {
    private static final String LOGCLASS = "DSIDisplayManagerControllerImpl";
    private final LogChannel logger;
    private final IFrameworkAccess framework;
    private final BundleContext bundleContext;
    private final int instanceId;
    private final IDisplayManagerListener nullDisplayManagerListener;
    private volatile DSIDisplayManagement dsiDisplayManagement;
    private volatile DSIActivator dsiActivator;
    private volatile IDisplayManagerListener displayManagerListener;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;

    public DSIDisplayManagerControllerImpl(int n, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.logger = logChannel;
        this.framework = iFrameworkAccess;
        this.instanceId = n;
        this.bundleContext = bundleContext;
        this.nullDisplayManagerListener = new NullDisplayManagerListener(logChannel);
    }

    public void addListener(IDisplayManagerListener iDisplayManagerListener) {
        this.logger.log(1000000, "[%1.addListener]", (Object)LOGCLASS);
        this.displayManagerListener = null == iDisplayManagerListener ? this.nullDisplayManagerListener : iDisplayManagerListener;
    }

    public void startDSI() {
        this.logger.log(1000000, "[%1.startDSI]", (Object)LOGCLASS);
        this.getDSIActivator().start(this.bundleContext);
    }

    public void stopDSI() {
        this.logger.log(1000000, "[%1.stopDSI]", (Object)LOGCLASS);
        this.getDSIActivator().stop(this.bundleContext);
    }

    private DSIActivator getDSIActivator() {
        if (this.dsiActivator == null) {
            IDSIClient iDSIClient = new IDSIClient(){

                public void setDSI(DSIBase dSIBase) {
                    DSIDisplayManagerControllerImpl.this.dsiDisplayManagement = dSIBase != null ? (DSIDisplayManagement)dSIBase : new NullDSIDisplayManagement(DSIDisplayManagerControllerImpl.this.logger);
                }

                public int[] getAutoNotifications() {
                    return null;
                }
            };
            this.dsiActivator = new DSIActivator(this.framework, (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = DSIDisplayManagerControllerImpl.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement).getName(), (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = DSIDisplayManagerControllerImpl.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener).getName(), new Integer(this.instanceId), this, iDSIClient);
        }
        return this.dsiActivator;
    }

    public void startComponent(int n, int n2, int n3) {
        this.logger.log(1000000, "[%1.startComponent]", (Object)LOGCLASS);
        this.dsiDisplayManagement.startComponent(n, n2, n3);
    }

    public void stopComponent(int n, int n2, int n3) {
        this.logger.log(1000000, "[%1.stopComponent]", (Object)LOGCLASS);
        this.dsiDisplayManagement.stopComponent(n, n2, n3);
    }

    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.logger.log(1000000, "[%1.setCropping]", (Object)LOGCLASS);
        this.dsiDisplayManagement.setCropping(n, n2, n3, n4, n5, n6, n7, n8, n9, n10);
    }

    public void asyncException(int n, String string, int n2) {
        this.logger.log(1000000, "[%1.asyncException]", (Object)LOGCLASS);
        this.displayManagerListener.error();
    }

    public void startComponentResult(int n, int n2, int n3, int n4) {
        this.logger.log(1000000, "[%1.startComponentResult]", (Object)LOGCLASS);
        this.displayManagerListener.startComponentResult(n, n2, n3, n4);
    }

    public void stopComponentResult(int n, int n2, int n3, int n4) {
        this.logger.log(1000000, "[%1.stopComponentResult]", (Object)LOGCLASS);
        this.displayManagerListener.stopComponentResult(n, n2, n3, n4);
    }

    public void setCroppingResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        this.logger.log(1000000, "[%1.setCroppingResult]", (Object)LOGCLASS);
        this.displayManagerListener.setCroppingResult(n11);
    }

    public void getExtents(int n, int n2, int n3) {
    }

    public void activeContext(int n, int n2, int n3) {
    }

    public void fadeStarted(int n, int n2) {
    }

    public void fadeComplete(int n, int n2) {
    }

    public void getDisplayPower(int n, int n2) {
    }

    public void getDisplayBrightness(int n, int n2) {
    }

    public void getBrightness(int n, int n2) {
    }

    public void getContrast(int n, int n2) {
    }

    public void getColor(int n, int n2) {
    }

    public void getTint(int n, int n2) {
    }

    public void lockDisplayResult(int n) {
    }

    public void unlockDisplayResult(int n) {
    }

    public void getDisplayableInfo(int n, int n2, int n3) {
    }

    public void takeScreenshotOnExternalStorageResult(int n, int n2, String string) {
    }

    public void setDisplayTypeResult(int n, int n2) {
    }

    public void getDisplayTypeResult(int n, int n2) {
    }

    public void setUpdateRateResult(int n, int n2) {
    }

    public void getUpdateRateResult(int n, int n2) {
    }

    public void setAnnotationDataResponse(int n, int n2) {
    }

    public void initAnnotationsResponse(int n, int n2) {
    }

    public void destroyImageDisplayableResponse(int n, int n2) {
    }

    public void requestUpdateImageDisplayableResponse(int n, int n2) {
    }

    public void createImageDisplayableResponse(int n, int n2) {
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

