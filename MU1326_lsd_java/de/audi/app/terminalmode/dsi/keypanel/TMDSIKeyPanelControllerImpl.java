/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.keypanel;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.dsi.AbstractDSIController;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.keypanel.ITMDSIKeyPanelController;
import de.audi.app.terminalmode.dsi.keypanel.NullTMDSIKeyPanelListener;
import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelListener;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.keypanel.DSIKeyPanel;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;
import org.osgi.framework.ServiceReference;

public class TMDSIKeyPanelControllerImpl
extends AbstractDSIController
implements ITMDSIKeyPanelController,
DSIKeyPanelListener {
    private static final String LOGCLASS = "TMDSIKeyPanelControllerImpl";
    private static final int INSTANCE_ID = 0;
    private final LogChannel logger;
    private final TMDSIKeyPanelListener nullDSIKeyPanelListener;
    private volatile TMDSIKeyPanelListener listener;
    private final DispatcherBase dispatcher;
    private final IFrameworkAccess framework;
    private volatile DSIKeyPanel keyPanelService;
    private KbdService kbdService;
    static /* synthetic */ Class class$de$audi$atip$hmi$KbdService;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanelListener;

    public TMDSIKeyPanelControllerImpl(IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, ITerminalLogger iTerminalLogger, IFrameworkAccess iFrameworkAccess2) {
        super(0, iServiceManager, iFrameworkAccess, dispatcherBase, false, iTerminalLogger.keypanel());
        this.logger = iTerminalLogger.keypanel();
        this.dispatcher = dispatcherBase;
        this.listener = this.nullDSIKeyPanelListener = new NullTMDSIKeyPanelListener(iTerminalLogger.keypanel());
        this.framework = iFrameworkAccess2;
    }

    public void activate() {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.startDSI();
        this.kbdService = null;
        ServiceReference serviceReference = this.framework.getBundleCxt().getServiceReference((class$de$audi$atip$hmi$KbdService == null ? (class$de$audi$atip$hmi$KbdService = TMDSIKeyPanelControllerImpl.class$("de.audi.atip.hmi.KbdService")) : class$de$audi$atip$hmi$KbdService).getName());
        if (serviceReference == null) {
            throw new FrameworkException("No key board service available! The initialisation has been aborted!");
        }
        this.kbdService = (KbdService)this.framework.getBundleCxt().getService(serviceReference);
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.kbdService = null;
    }

    public void addTMKeyPanelListener(TMDSIKeyPanelListener tMDSIKeyPanelListener) {
        if (null == tMDSIKeyPanelListener) {
            this.listener = this.nullDSIKeyPanelListener;
            return;
        }
        this.listener = tMDSIKeyPanelListener;
    }

    public void removeTMKeyPanelListener() {
        this.listener = this.nullDSIKeyPanelListener;
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void updateKey2(int n, int n2, int n3, int n4, int n5) {
    }

    public void updateEncoder2(int n, int n2, int n3, int n4, int n5) {
    }

    public void updateDisplayTurnMechStatus(int n, int n2) {
    }

    public void updateRecognizerLanguage2(final int n, final String string, final int n2, int n3) {
        if (!this.isValid(n3)) {
            this.logger.log(10000000, "[%1.updateRecognizerLanguage2] Invalid.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.updateRecognizerLanguage2]", (Object)LOGCLASS);
        this.dispatcher.execute(new AbstractDispatcherRunnable("keyPanelListener.updateRecognizerLanguage2"){

            public void run() {
                TMDSIKeyPanelControllerImpl.this.listener.updateRecognizerLanguage2(n, string, n2);
            }
        });
    }

    public void updateRecognizerMode(final int n, final int n2, int n3) {
        if (!this.isValid(n3)) {
            this.logger.log(10000000, "[%1.updateRecognizerMode] Invalid.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.updateRecognizerMode] %2", (Object)LOGCLASS, (long)n2);
        this.dispatcher.execute(new AbstractDispatcherRunnable("keyPanelListener.updateRecognizerMode"){

            public void run() {
                TMDSIKeyPanelControllerImpl.this.listener.updateRecognizerMode(n, n2);
            }
        });
    }

    public void updateCharacterEvent2(final int n, final String[] stringArray, final int[] nArray, int n2) {
        if (!this.isValid(n2)) {
            this.logger.log(10000000, "[%1.updateCharacterEvent2] Invalid.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.updateCharacterEvent2]", (Object)LOGCLASS);
        this.dispatcher.execute(new AbstractDispatcherRunnable("keyPanelListener.updateCharacterEvent2"){

            public void run() {
                TMDSIKeyPanelControllerImpl.this.listener.updateCharacterEvent2(n, stringArray, nArray);
            }
        });
    }

    public void updateGesture2(int n, int n2, int n3, boolean bl, int n4, int n5, int n6, int n7, int n8, int n9) {
    }

    public void genericSettingResponse(int n, int n2, int n3) {
    }

    public void updateProximity(int n, int n2, int n3) {
    }

    public void lastKey(int n, int n2, int n3) {
    }

    public void updateKeyboardType(int n, int n2) {
    }

    public void updateTouchSensitiveArea(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void getVersionInfo(int n, int n2, String string) {
    }

    public void updateInputPanelReady(int n, int n2, int n3) {
    }

    public void setTextInputActive(int n, boolean bl) {
        this.logger.log(1000000, "[%1.setTextInputActive] %2", (Object)LOGCLASS, (Object)String.valueOf(bl));
        if (null != this.keyPanelService) {
            if (bl) {
                this.kbdService.setRecognizerLanguage(this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageCode(), 2);
            }
            this.kbdService.setRecognizerMode(bl ? 26 : 25);
        }
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = TMDSIKeyPanelControllerImpl.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel;
    }

    protected DSIListener getDSIListener() {
        return this;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$keypanel$DSIKeyPanelListener == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanelListener = TMDSIKeyPanelControllerImpl.class$("org.dsi.ifc.keypanel.DSIKeyPanelListener")) : class$org$dsi$ifc$keypanel$DSIKeyPanelListener;
    }

    protected void addDSIService(DSIBase dSIBase) {
        if (null != dSIBase) {
            this.keyPanelService = (DSIKeyPanel)dSIBase;
            this.keyPanelService.setNotification(new int[]{7, 9, 18, 19, 20, 21, 22, 23, 24, 25, 26}, (DSIListener)this);
        }
    }

    protected void removeDSIService() {
        this.logger.log(1000000, "[%1.removeDSIService]", (Object)LOGCLASS);
        this.keyPanelService = null;
    }

    public void getProperty(int n, int n2, int n3, int n4, byte[] byArray) {
    }

    public void updateAdvancedProximity(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
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

