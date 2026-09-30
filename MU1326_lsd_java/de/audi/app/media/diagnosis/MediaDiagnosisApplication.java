/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.diagnosis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.IDiagnosisApp;
import java.util.Hashtable;
import java.util.Iterator;
import org.osgi.framework.ServiceRegistration;

public class MediaDiagnosisApplication
implements IDiagnosisApp {
    private static final String LOGCLASS = "MediaDiagnosisApplication";
    private final IMediaLogger logger;
    private final IFrameworkAccess framework;
    private final IServiceManager serviceManager;
    private final IMediaTerminal[] terminals;
    private final IMediaDSIBaseController dsiBaseController;
    private volatile ServiceRegistration diagServiceRegistration;
    private volatile ISourceSlot[] lastSourceSlot = new ISourceSlot[8];
    static /* synthetic */ Class class$de$audi$atip$diag$IDiagnosisApp;

    public MediaDiagnosisApplication(IMediaLogger iMediaLogger, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, IMediaTerminal[] iMediaTerminalArray, IMediaDSIBaseController iMediaDSIBaseController) {
        this.logger = iMediaLogger;
        this.serviceManager = iServiceManager;
        this.framework = iFrameworkAccess;
        this.terminals = iMediaTerminalArray;
        this.dsiBaseController = iMediaDSIBaseController;
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.diagServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$diag$IDiagnosisApp == null ? (class$de$audi$atip$diag$IDiagnosisApp = MediaDiagnosisApplication.class$("de.audi.atip.diag.IDiagnosisApp")) : class$de$audi$atip$diag$IDiagnosisApp, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.diagServiceRegistration.unregister();
    }

    public void performAction(int n, Object object) {
        block0 : switch (n) {
            case 9: {
                this.logger.main().log(1000000, "[%1.performAction] DIAG_ACTION_RESET_DVD_PM_PASSWORD.", (Object)LOGCLASS);
                this.terminals[0].getMediaPersistence().setGlobalStringProperty("GLOBAL_KEY_DVDV_PM_PASSWORD", "1234");
                break;
            }
            case 10: {
                this.logger.main().log(1000000, "[%1.performAction] DIAG_ACTION_RESET_DVD_PM_LEVEL.", (Object)LOGCLASS);
                this.dsiBaseController.setParentalML(0);
                this.terminals[0].getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_DVDV_PM_LEVEL", 0);
                break;
            }
            case 5: {
                this.logger.main().log(1000000, "[%1.performAction] DIAG_ACTION_SWITCH_SOURCE.", (Object)LOGCLASS);
                switch ((Integer)object) {
                    case 17: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_TV.", (Object)LOGCLASS);
                        this.switchToSource(7);
                        break block0;
                    }
                    case 16: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_INTERNALDRIVE.", (Object)LOGCLASS);
                        if (this.framework.isFrontMU()) {
                            this.switchToInternalDrive(0);
                            return;
                        }
                        this.switchToInternalDrive(3);
                        this.switchToInternalDrive(4);
                        break block0;
                    }
                    case 8: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_DVDC.", (Object)LOGCLASS);
                        this.switchToSource(3);
                        break block0;
                    }
                    case 7: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_SD1.", (Object)LOGCLASS);
                        this.switchToSourceSlot(5, 0);
                        break block0;
                    }
                    case 21: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_SD2.", (Object)LOGCLASS);
                        this.switchToSourceSlot(5, 1);
                        break block0;
                    }
                    case 18: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_USB.", (Object)LOGCLASS);
                        this.switchToUSBSourceDevice(0);
                        break block0;
                    }
                    case 22: {
                        this.logger.main().log(1000000, "[%1.performAction]SOURCESWITCH_USB2.", (Object)LOGCLASS);
                        this.switchToUSBSourceDevice(1);
                        break block0;
                    }
                    case 9: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_BT.", (Object)LOGCLASS);
                        this.switchToSource(11);
                        break block0;
                    }
                    case 4: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_CDC.", (Object)LOGCLASS);
                        this.switchToSource(1);
                        break block0;
                    }
                    case 11: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_WLAN.", (Object)LOGCLASS);
                        this.switchToSource(12);
                        break block0;
                    }
                    case 15: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_JUEKBOX.", (Object)LOGCLASS);
                        this.switchToSource(6);
                        break block0;
                    }
                    case 5: 
                    case 6: 
                    case 19: {
                        this.logger.main().log(1000000, "[%1.performAction] SOURCESWITCH_AUX.", (Object)LOGCLASS);
                        this.switchToSource(9);
                        break block0;
                    }
                }
                break;
            }
        }
    }

    private void switchToInternalDrive(int n) {
        this.logger.main().log(1000000, "[%1.switchToInternalDrive] terminal='%2'", (Object)LOGCLASS, (long)n);
        final IMediaTerminal iMediaTerminal = this.terminals[n];
        if (iMediaTerminal == null) {
            this.logger.main().log(100000, "[%1.switchToInternalDrive] Terminal '%2' not found. Ignore. ", (Object)LOGCLASS, (long)n);
            return;
        }
        iMediaTerminal.getDispatcher().execute(new AbstractDispatcherRunnable("MediaDiagnosis.activateSource"){

            public void run() {
                ISource iSource = iMediaTerminal.getSourceController().getSource(2);
                if (iSource == null) {
                    iSource = iMediaTerminal.getSourceController().getSource(0);
                }
                if (iSource == null) {
                    MediaDiagnosisApplication.this.logger.main().log(100000, "[%1.switchToInternalDrive] No internal drive found. ", (Object)MediaDiagnosisApplication.LOGCLASS);
                    return;
                }
                iMediaTerminal.getSourceController().activateSource(new ActivationContext(iSource.getSlot(0)));
            }
        });
    }

    private void switchToSource(int n) {
        this.switchToSourceSlot(n, 0);
    }

    private void switchToSourceSlot(int n, int n2) {
        if (this.framework.isFrontMU()) {
            this.switchTerminalToSourceSlot(0, n, n2);
            return;
        }
        this.switchTerminalToSourceSlot(3, n, n2);
        this.switchTerminalToSourceSlot(4, n, n2);
    }

    private void switchTerminalToSourceSlot(int n, int n2, final int n3) {
        this.logger.main().log(1000000, "[%1.switchTerminalToSourceSlot] terminal='%2',source='%3', pSlotIdx='%4'", (Object)LOGCLASS, (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3));
        final IMediaTerminal iMediaTerminal = this.terminals[n];
        if (iMediaTerminal == null) {
            this.logger.main().log(100000, "[%1.switchTerminalToSourceSlot] Terminal '%2' not found. Ignore. ", (Object)LOGCLASS, (long)n);
            return;
        }
        final ISource iSource = iMediaTerminal.getSourceController().getSource(n2);
        if (iSource == null) {
            this.logger.main().log(100000, "[%1.switchTerminalToSourceSlot] Source not found. Ignore.", (Object)LOGCLASS);
            return;
        }
        iMediaTerminal.getDispatcher().execute(new AbstractDispatcherRunnable("MediaDiagnosis.switchTerminalToSourceSlot"){

            public void run() {
                ISourceSlot iSourceSlot = iSource.getSlot(n3);
                iMediaTerminal.getSourceController().activateSource(new ActivationContext(iSourceSlot));
            }
        });
    }

    private ISourceSlot getCurrentSelectedSource(int n) {
        IMediaTerminal iMediaTerminal = this.terminals[n];
        if (iMediaTerminal == null) {
            return null;
        }
        return iMediaTerminal.getSourceController().getSelectedSlot();
    }

    private void switchToUSBSourceDevice(final int n) {
        this.logger.main().log(1000000, "[%1.switchToUSBSourceDevice] ", (Object)LOGCLASS);
        final IMediaTerminal iMediaTerminal = this.terminals[0];
        if (iMediaTerminal == null) {
            this.logger.main().log(100000, "[%1.switchToUSBSourceDevice] Terminal Main not found. Ignore. ", (Object)LOGCLASS);
            return;
        }
        final ISource iSource = iMediaTerminal.getSourceController().getSource(10);
        if (iSource == null) {
            this.logger.main().log(100000, "[%1.switchToUSBSourceDevice] USB source not found. Ignore.", (Object)LOGCLASS);
            return;
        }
        iMediaTerminal.getDispatcher().execute(new AbstractDispatcherRunnable("MediaDiagnosis.switchTerminalToSourceSlot"){

            public void run() {
                ISourceSlot iSourceSlot;
                Iterator iterator = iSource.getSlots().iterator();
                int n2 = -1;
                while (iterator.hasNext()) {
                    iSourceSlot = (ISourceSlot)iterator.next();
                    if (iSourceSlot.getDeviceIndex() != n) continue;
                    n2 = iSourceSlot.getIndex();
                    break;
                }
                if (n2 == -1) {
                    n2 = n;
                }
                iSourceSlot = iSource.getSlot(n2);
                iMediaTerminal.getSourceController().activateSource(new ActivationContext(iSourceSlot));
            }
        });
    }

    public void updateDiagnosticValueChanged(int n, long l) {
    }

    public void startDiagSession() {
        for (int i2 = 0; i2 < 8; ++i2) {
            this.lastSourceSlot[i2] = this.getCurrentSelectedSource(i2);
        }
    }

    public void stopDiagSession() {
    }

    public void switch2OriginSource(final int n, int n2) {
        if (n2 != 1) {
            return;
        }
        final IMediaTerminal iMediaTerminal = this.terminals[n];
        if (iMediaTerminal == null || this.lastSourceSlot[n] == null) {
            return;
        }
        iMediaTerminal.getDispatcher().execute(new AbstractDispatcherRunnable("MediaDiagnosis.switch2OriginSource"){

            public void run() {
                iMediaTerminal.getSourceController().activateSource(new ActivationContext(MediaDiagnosisApplication.this.lastSourceSlot[n]));
            }
        });
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

