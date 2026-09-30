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
    private static final String LOGCLASS = "DSIDisplayManagerControllerImpl";
    private static final int NO_VALUE = Integer.MIN_VALUE;
    private static final int CALL_COLOR_SET = 0;
    private static final int CALL_CONTRAST_SET = 1;
    private static final int CALL_TINT_SET = 2;
    private static final int CALL_BRIGHTNESS_SET = 3;
    private static final int CALL_COLOR_GET = 4;
    private static final int CALL_CONTRAST_GET = 5;
    private static final int CALL_TINT_GET = 6;
    private static final int CALL_BRIGHTNESS_GET = 7;
    private final DSIDisplayManagementListener dsiListener;
    private volatile DSIDisplayManagement dsiDisplay;
    private volatile IMediaDisplayManagerListener listener;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;

    public DSIDisplayManagerControllerImpl(int n, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, LogChannel logChannel) {
        super(n, iServiceManager, iFrameworkAccess, dispatcherBase, false, logChannel);
        this.dsiListener = new DSIDisplayManagerListener(this, logChannel);
    }

    public void addDSIService(DSIBase dSIBase) {
        this.dsiDisplay = (DSIDisplayManagement)dSIBase;
    }

    protected void removeDSIService() {
        this.logger.log(1000000, "[%1.removeDSIService] DSI service removed.", (Object)LOGCLASS);
        this.dsiDisplay = null;
    }

    protected void registerAttributeNotifications(DSIBase dSIBase) {
    }

    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = DSIDisplayManagerControllerImpl.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = DSIDisplayManagerControllerImpl.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;
    }

    public void setDisplayManagerListener(IMediaDisplayManagerListener iMediaDisplayManagerListener) {
        this.logger.log(1000000, "[%1.setDisplayManagerListener] '%2'", (Object)LOGCLASS, (Object)iMediaDisplayManagerListener);
        this.listener = iMediaDisplayManagerListener;
    }

    protected IMediaDisplayManagerListener getDisplayManagerListener() {
        return this.listener;
    }

    public void setBrightness(int n, int n2) {
        this.callDSI(n, 3, n2, "setBrightness");
        this.callDSI(n, 7, Integer.MIN_VALUE, "getBrightness");
    }

    public void setColor(int n, int n2) {
        this.callDSI(n, 0, n2, "setColor");
        this.callDSI(n, 4, Integer.MIN_VALUE, "getColor");
    }

    public void setContrast(int n, int n2) {
        this.callDSI(n, 1, n2, "setContrast");
        this.callDSI(n, 5, Integer.MIN_VALUE, "getContrast");
    }

    public void setTint(int n, int n2) {
        this.callDSI(n, 2, n2, "setTint");
        this.callDSI(n, 6, Integer.MIN_VALUE, "getTint");
    }

    private void callDSI(int n, int n2, int n3, String string) {
        DSIDisplayManagement dSIDisplayManagement;
        if (this.logger.isInfo()) {
            this.logger.log(1000000, "[%1.callDSI] [%3] '%2','%4'", (Object)LOGCLASS, (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n3));
        }
        if ((dSIDisplayManagement = this.dsiDisplay) == null) {
            this.logger.log(100000, "[%1.callDSI] No DSI service registered. Ignore.", (Object)LOGCLASS);
            return;
        }
        if (n == -1) {
            this.logger.log(100000, "[%1.callDSI] No active displayable found.", (Object)LOGCLASS);
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
                this.logger.log(100000, "[%1.callDSI] Unknown DSI call '%2'.", (Object)LOGCLASS, (long)n2);
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

