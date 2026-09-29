/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.diagnosis;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.diagnosis.MediaDiagnosisApplication$1;
import de.audi.app.media.diagnosis.MediaDiagnosisApplication$2;
import de.audi.app.media.diagnosis.MediaDiagnosisApplication$3;
import de.audi.app.media.diagnosis.MediaDiagnosisApplication$4;
import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.IDiagnosisApp;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class MediaDiagnosisApplication
implements IDiagnosisApp {
    private static final String LOGCLASS;
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
        this.logger.main().log(1078071040, "[%1.init]", (Object)"MediaDiagnosisApplication");
        this.diagServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$diag$IDiagnosisApp == null ? (class$de$audi$atip$diag$IDiagnosisApp = MediaDiagnosisApplication.class$("de.audi.atip.diag.IDiagnosisApp")) : class$de$audi$atip$diag$IDiagnosisApp, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"MediaDiagnosisApplication");
        this.diagServiceRegistration.unregister();
    }

    @Override
    public void performAction(int n, Object object) {
        block0 : switch (n) {
            case 9: {
                this.logger.main().log(1078071040, "[%1.performAction] DIAG_ACTION_RESET_DVD_PM_PASSWORD.", (Object)"MediaDiagnosisApplication");
                this.terminals[0].getMediaPersistence().setGlobalStringProperty("GLOBAL_KEY_DVDV_PM_PASSWORD", "1234");
                break;
            }
            case 10: {
                this.logger.main().log(1078071040, "[%1.performAction] DIAG_ACTION_RESET_DVD_PM_LEVEL.", (Object)"MediaDiagnosisApplication");
                this.dsiBaseController.setParentalML(0);
                this.terminals[0].getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_DVDV_PM_LEVEL", 0);
                break;
            }
            case 5: {
                this.logger.main().log(1078071040, "[%1.performAction] DIAG_ACTION_SWITCH_SOURCE.", (Object)"MediaDiagnosisApplication");
                switch ((Integer)object) {
                    case 17: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_TV.", (Object)"MediaDiagnosisApplication");
                        this.switchToSource(7);
                        break block0;
                    }
                    case 16: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_INTERNALDRIVE.", (Object)"MediaDiagnosisApplication");
                        if (this.framework.isFrontMU()) {
                            this.switchToInternalDrive(0);
                            return;
                        }
                        this.switchToInternalDrive(3);
                        this.switchToInternalDrive(4);
                        break block0;
                    }
                    case 8: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_DVDC.", (Object)"MediaDiagnosisApplication");
                        this.switchToSource(3);
                        break block0;
                    }
                    case 7: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_SD1.", (Object)"MediaDiagnosisApplication");
                        this.switchToSourceSlot(5, 0);
                        break block0;
                    }
                    case 21: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_SD2.", (Object)"MediaDiagnosisApplication");
                        this.switchToSourceSlot(5, 1);
                        break block0;
                    }
                    case 18: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_USB.", (Object)"MediaDiagnosisApplication");
                        this.switchToUSBSourceDevice(0);
                        break block0;
                    }
                    case 22: {
                        this.logger.main().log(1078071040, "[%1.performAction]SOURCESWITCH_USB2.", (Object)"MediaDiagnosisApplication");
                        this.switchToUSBSourceDevice(1);
                        break block0;
                    }
                    case 9: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_BT.", (Object)"MediaDiagnosisApplication");
                        this.switchToSource(11);
                        break block0;
                    }
                    case 4: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_CDC.", (Object)"MediaDiagnosisApplication");
                        this.switchToSource(1);
                        break block0;
                    }
                    case 11: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_WLAN.", (Object)"MediaDiagnosisApplication");
                        this.switchToSource(12);
                        break block0;
                    }
                    case 15: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_JUEKBOX.", (Object)"MediaDiagnosisApplication");
                        this.switchToSource(6);
                        break block0;
                    }
                    case 5: 
                    case 6: 
                    case 19: {
                        this.logger.main().log(1078071040, "[%1.performAction] SOURCESWITCH_AUX.", (Object)"MediaDiagnosisApplication");
                        this.switchToSource(9);
                        break block0;
                    }
                }
                break;
            }
        }
    }

    private void switchToInternalDrive(int n) {
        this.logger.main().log(1078071040, "[%1.switchToInternalDrive] terminal='%2'", (Object)"MediaDiagnosisApplication", (long)n);
        IMediaTerminal iMediaTerminal = this.terminals[n];
        if (iMediaTerminal == null) {
            this.logger.main().log(-1601830656, "[%1.switchToInternalDrive] Terminal '%2' not found. Ignore. ", (Object)"MediaDiagnosisApplication", (long)n);
            return;
        }
        iMediaTerminal.getDispatcher().execute(new MediaDiagnosisApplication$1(this, "MediaDiagnosis.activateSource", iMediaTerminal));
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

    private void switchTerminalToSourceSlot(int n, int n2, int n3) {
        this.logger.main().log(1078071040, "[%1.switchTerminalToSourceSlot] terminal='%2',source='%3', pSlotIdx='%4'", (Object)"MediaDiagnosisApplication", (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3));
        IMediaTerminal iMediaTerminal = this.terminals[n];
        if (iMediaTerminal == null) {
            this.logger.main().log(-1601830656, "[%1.switchTerminalToSourceSlot] Terminal '%2' not found. Ignore. ", (Object)"MediaDiagnosisApplication", (long)n);
            return;
        }
        ISource iSource = iMediaTerminal.getSourceController().getSource(n2);
        if (iSource == null) {
            this.logger.main().log(-1601830656, "[%1.switchTerminalToSourceSlot] Source not found. Ignore.", (Object)"MediaDiagnosisApplication");
            return;
        }
        iMediaTerminal.getDispatcher().execute(new MediaDiagnosisApplication$2(this, "MediaDiagnosis.switchTerminalToSourceSlot", iSource, n3, iMediaTerminal));
    }

    private ISourceSlot getCurrentSelectedSource(int n) {
        IMediaTerminal iMediaTerminal = this.terminals[n];
        if (iMediaTerminal == null) {
            return null;
        }
        return iMediaTerminal.getSourceController().getSelectedSlot();
    }

    private void switchToUSBSourceDevice(int n) {
        this.logger.main().log(1078071040, "[%1.switchToUSBSourceDevice] ", (Object)"MediaDiagnosisApplication");
        IMediaTerminal iMediaTerminal = this.terminals[0];
        if (iMediaTerminal == null) {
            this.logger.main().log(-1601830656, "[%1.switchToUSBSourceDevice] Terminal Main not found. Ignore. ", (Object)"MediaDiagnosisApplication");
            return;
        }
        ISource iSource = iMediaTerminal.getSourceController().getSource(10);
        if (iSource == null) {
            this.logger.main().log(-1601830656, "[%1.switchToUSBSourceDevice] USB source not found. Ignore.", (Object)"MediaDiagnosisApplication");
            return;
        }
        iMediaTerminal.getDispatcher().execute(new MediaDiagnosisApplication$3(this, "MediaDiagnosis.switchTerminalToSourceSlot", iSource, n, iMediaTerminal));
    }

    @Override
    public void updateDiagnosticValueChanged(int n, long l) {
    }

    @Override
    public void startDiagSession() {
        for (int i2 = 0; i2 < 8; ++i2) {
            this.lastSourceSlot[i2] = this.getCurrentSelectedSource(i2);
        }
    }

    @Override
    public void stopDiagSession() {
    }

    @Override
    public void switch2OriginSource(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        IMediaTerminal iMediaTerminal = this.terminals[n];
        if (iMediaTerminal == null || this.lastSourceSlot[n] == null) {
            return;
        }
        iMediaTerminal.getDispatcher().execute(new MediaDiagnosisApplication$4(this, "MediaDiagnosis.switch2OriginSource", iMediaTerminal, n));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IMediaLogger access$000(MediaDiagnosisApplication mediaDiagnosisApplication) {
        return mediaDiagnosisApplication.logger;
    }

    static /* synthetic */ ISourceSlot[] access$100(MediaDiagnosisApplication mediaDiagnosisApplication) {
        return mediaDiagnosisApplication.lastSourceSlot;
    }
}

