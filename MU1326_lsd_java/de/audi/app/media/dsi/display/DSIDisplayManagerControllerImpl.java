/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.display;

import de.audi.app.media.dsi.AbstractDSIController;
import de.audi.app.media.dsi.display.DSIDisplayManagerListener;
import de.audi.app.media.dsi.display.IDSIDisplayManagerController;
import de.audi.app.media.dsi.display.IMediaDisplayManagerListener;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;

public class DSIDisplayManagerControllerImpl
extends AbstractDSIController
implements IDSIDisplayManagerController {
    private static final String LOGCLASS;
    private static final int NO_VALUE;
    private static final int CALL_COLOR_SET;
    private static final int CALL_CONTRAST_SET;
    private static final int CALL_TINT_SET;
    private static final int CALL_BRIGHTNESS_SET;
    private static final int CALL_COLOR_GET;
    private static final int CALL_CONTRAST_GET;
    private static final int CALL_TINT_GET;
    private static final int CALL_BRIGHTNESS_GET;
    private final DSIDisplayManagementListener dsiListener;
    private volatile DSIDisplayManagement dsiDisplay;
    private volatile IMediaDisplayManagerListener listener;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;

    public DSIDisplayManagerControllerImpl(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, LogChannel logChannel) {
        super(n, iServiceManager, iFrameworkAccess, dispatcherBase, false, logChannel);
        this.dsiListener = new DSIDisplayManagerListener(this, logChannel);
    }

    @Override
    public void addDSIService(DSIBase dSIBase) {
        this.dsiDisplay = (DSIDisplayManagement)dSIBase;
    }

    @Override
    protected void removeDSIService() {
        this.logger.log(1078071040, "[%1.removeDSIService] DSI service removed.", (Object)"DSIDisplayManagerControllerImpl");
        this.dsiDisplay = null;
    }

    protected void registerAttributeNotifications(DSIBase dSIBase) {
    }

    @Override
    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    @Override
    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = DSIDisplayManagerControllerImpl.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = DSIDisplayManagerControllerImpl.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;
    }

    @Override
    public void setDisplayManagerListener(IMediaDisplayManagerListener iMediaDisplayManagerListener) {
        this.logger.log(1078071040, "[%1.setDisplayManagerListener] '%2'", (Object)"DSIDisplayManagerControllerImpl", (Object)iMediaDisplayManagerListener);
        this.listener = iMediaDisplayManagerListener;
    }

    protected IMediaDisplayManagerListener getDisplayManagerListener() {
        return this.listener;
    }

    @Override
    public void setBrightness(int n, int n2) {
        this.callDSI(n, 3, n2, "setBrightness");
        this.callDSI(n, 7, 128, "getBrightness");
    }

    @Override
    public void setColor(int n, int n2) {
        this.callDSI(n, 0, n2, "setColor");
        this.callDSI(n, 4, 128, "getColor");
    }

    @Override
    public void setContrast(int n, int n2) {
        this.callDSI(n, 1, n2, "setContrast");
        this.callDSI(n, 5, 128, "getContrast");
    }

    @Override
    public void setTint(int n, int n2) {
        this.callDSI(n, 2, n2, "setTint");
        this.callDSI(n, 6, 128, "getTint");
    }

    private void callDSI(int n, int n2, int n3, String string) {
        DSIDisplayManagement dSIDisplayManagement;
        if (this.logger.isInfo()) {
            this.logger.log(1078071040, "[%1.callDSI] [%3] '%2','%4'", (Object)"DSIDisplayManagerControllerImpl", (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n3));
        }
        if ((dSIDisplayManagement = this.dsiDisplay) == null) {
            this.logger.log(-1601830656, "[%1.callDSI] No DSI service registered. Ignore.", (Object)"DSIDisplayManagerControllerImpl");
            return;
        }
        if (n == -1) {
            this.logger.log(-1601830656, "[%1.callDSI] No active displayable found.", (Object)"DSIDisplayManagerControllerImpl");
            return;
        }
        switch (n2) {
            case 0: {
                dSIDisplayManagement.setColor(n, n3);
                break;
            }
            case 1: {
                dSIDisplayManagement.setContrast(n, n3);
                break;
            }
            case 3: {
                dSIDisplayManagement.setBrightness(n, n3);
                break;
            }
            case 2: {
                dSIDisplayManagement.setTint(n, n3);
                break;
            }
            case 4: {
                dSIDisplayManagement.getColor(n);
                break;
            }
            case 5: {
                dSIDisplayManagement.getContrast(n);
                break;
            }
            case 7: {
                dSIDisplayManagement.getBrightness(n);
                break;
            }
            case 6: {
                dSIDisplayManagement.getTint(n);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1.callDSI] Unknown DSI call '%2'.", (Object)"DSIDisplayManagerControllerImpl", (long)n2);
            }
        }
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

