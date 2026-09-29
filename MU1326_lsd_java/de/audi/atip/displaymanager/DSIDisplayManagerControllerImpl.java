/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.displaymanager.DSIDisplayManagerControllerImpl$1;
import de.audi.atip.displaymanager.IDSIDisplayManagerController;
import de.audi.atip.displaymanager.NullDisplayManagerListener;
import de.audi.atip.interapp.displaymanager.IDisplayManagerListener;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;
import org.osgi.framework.BundleContext;

public class DSIDisplayManagerControllerImpl
implements IDSIDisplayManagerController,
DSIDisplayManagementListener {
    private static final String LOGCLASS;
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

    @Override
    public void addListener(IDisplayManagerListener iDisplayManagerListener) {
        this.logger.log(1078071040, "[%1.addListener]", (Object)"DSIDisplayManagerControllerImpl");
        this.displayManagerListener = null == iDisplayManagerListener ? this.nullDisplayManagerListener : iDisplayManagerListener;
    }

    @Override
    public void startDSI() {
        this.logger.log(1078071040, "[%1.startDSI]", (Object)"DSIDisplayManagerControllerImpl");
        this.getDSIActivator().start(this.bundleContext);
    }

    @Override
    public void stopDSI() {
        this.logger.log(1078071040, "[%1.stopDSI]", (Object)"DSIDisplayManagerControllerImpl");
        this.getDSIActivator().stop(this.bundleContext);
    }

    private DSIActivator getDSIActivator() {
        if (this.dsiActivator == null) {
            DSIDisplayManagerControllerImpl$1 dSIDisplayManagerControllerImpl$1 = new DSIDisplayManagerControllerImpl$1(this);
            this.dsiActivator = new DSIActivator(this.framework, (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = DSIDisplayManagerControllerImpl.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement).getName(), (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = DSIDisplayManagerControllerImpl.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener).getName(), new Integer(this.instanceId), this, dSIDisplayManagerControllerImpl$1);
        }
        return this.dsiActivator;
    }

    @Override
    public void startComponent(int n, int n2, int n3) {
        this.logger.log(1078071040, "[%1.startComponent]", (Object)"DSIDisplayManagerControllerImpl");
        this.dsiDisplayManagement.startComponent(n, n2, n3);
    }

    @Override
    public void stopComponent(int n, int n2, int n3) {
        this.logger.log(1078071040, "[%1.stopComponent]", (Object)"DSIDisplayManagerControllerImpl");
        this.dsiDisplayManagement.stopComponent(n, n2, n3);
    }

    @Override
    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.logger.log(1078071040, "[%1.setCropping]", (Object)"DSIDisplayManagerControllerImpl");
        this.dsiDisplayManagement.setCropping(n, n2, n3, n4, n5, n6, n7, n8, n9, n10);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(1078071040, "[%1.asyncException]", (Object)"DSIDisplayManagerControllerImpl");
        this.displayManagerListener.error();
    }

    @Override
    public void startComponentResult(int n, int n2, int n3, int n4) {
        this.logger.log(1078071040, "[%1.startComponentResult]", (Object)"DSIDisplayManagerControllerImpl");
        this.displayManagerListener.startComponentResult(n, n2, n3, n4);
    }

    @Override
    public void stopComponentResult(int n, int n2, int n3, int n4) {
        this.logger.log(1078071040, "[%1.stopComponentResult]", (Object)"DSIDisplayManagerControllerImpl");
        this.displayManagerListener.stopComponentResult(n, n2, n3, n4);
    }

    @Override
    public void setCroppingResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        this.logger.log(1078071040, "[%1.setCroppingResult]", (Object)"DSIDisplayManagerControllerImpl");
        this.displayManagerListener.setCroppingResult(n11);
    }

    @Override
    public void getExtents(int n, int n2, int n3) {
    }

    @Override
    public void activeContext(int n, int n2, int n3) {
    }

    @Override
    public void fadeStarted(int n, int n2) {
    }

    @Override
    public void fadeComplete(int n, int n2) {
    }

    @Override
    public void getDisplayPower(int n, int n2) {
    }

    @Override
    public void getDisplayBrightness(int n, int n2) {
    }

    @Override
    public void getBrightness(int n, int n2) {
    }

    @Override
    public void getContrast(int n, int n2) {
    }

    @Override
    public void getColor(int n, int n2) {
    }

    @Override
    public void getTint(int n, int n2) {
    }

    @Override
    public void lockDisplayResult(int n) {
    }

    @Override
    public void unlockDisplayResult(int n) {
    }

    @Override
    public void getDisplayableInfo(int n, int n2, int n3) {
    }

    @Override
    public void takeScreenshotOnExternalStorageResult(int n, int n2, String string) {
    }

    @Override
    public void setDisplayTypeResult(int n, int n2) {
    }

    @Override
    public void getDisplayTypeResult(int n, int n2) {
    }

    @Override
    public void setUpdateRateResult(int n, int n2) {
    }

    @Override
    public void getUpdateRateResult(int n, int n2) {
    }

    @Override
    public void setAnnotationDataResponse(int n, int n2) {
    }

    @Override
    public void initAnnotationsResponse(int n, int n2) {
    }

    @Override
    public void destroyImageDisplayableResponse(int n, int n2) {
    }

    @Override
    public void requestUpdateImageDisplayableResponse(int n, int n2) {
    }

    @Override
    public void createImageDisplayableResponse(int n, int n2) {
    }

    static /* synthetic */ DSIDisplayManagement access$002(DSIDisplayManagerControllerImpl dSIDisplayManagerControllerImpl, DSIDisplayManagement dSIDisplayManagement) {
        dSIDisplayManagerControllerImpl.dsiDisplayManagement = dSIDisplayManagement;
        return dSIDisplayManagerControllerImpl.dsiDisplayManagement;
    }

    static /* synthetic */ LogChannel access$100(DSIDisplayManagerControllerImpl dSIDisplayManagerControllerImpl) {
        return dSIDisplayManagerControllerImpl.logger;
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

