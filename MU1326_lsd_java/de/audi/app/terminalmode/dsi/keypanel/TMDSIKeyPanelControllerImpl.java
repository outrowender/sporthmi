/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.keypanel;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.dsi.AbstractDSIController;
import de.audi.app.terminalmode.dsi.keypanel.ITMDSIKeyPanelController;
import de.audi.app.terminalmode.dsi.keypanel.NullTMDSIKeyPanelListener;
import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelControllerImpl$1;
import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelControllerImpl$2;
import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelControllerImpl$3;
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
    private static final String LOGCLASS;
    private static final int INSTANCE_ID;
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
        this.logger.log(1078071040, "[%1.activate]", (Object)"TMDSIKeyPanelControllerImpl");
        this.startDSI();
        this.kbdService = null;
        ServiceReference serviceReference = this.framework.getBundleCxt().getServiceReference((class$de$audi$atip$hmi$KbdService == null ? (class$de$audi$atip$hmi$KbdService = TMDSIKeyPanelControllerImpl.class$("de.audi.atip.hmi.KbdService")) : class$de$audi$atip$hmi$KbdService).getName());
        if (serviceReference == null) {
            throw new FrameworkException("No key board service available! The initialisation has been aborted!");
        }
        this.kbdService = (KbdService)this.framework.getBundleCxt().getService(serviceReference);
    }

    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"TMDSIKeyPanelControllerImpl");
        this.kbdService = null;
    }

    @Override
    public void addTMKeyPanelListener(TMDSIKeyPanelListener tMDSIKeyPanelListener) {
        if (null == tMDSIKeyPanelListener) {
            this.listener = this.nullDSIKeyPanelListener;
            return;
        }
        this.listener = tMDSIKeyPanelListener;
    }

    @Override
    public void removeTMKeyPanelListener() {
        this.listener = this.nullDSIKeyPanelListener;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateKey2(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void updateEncoder2(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void updateDisplayTurnMechStatus(int n, int n2) {
    }

    @Override
    public void updateRecognizerLanguage2(int n, String string, int n2, int n3) {
        if (!this.isValid(n3)) {
            this.logger.log(-2137614336, "[%1.updateRecognizerLanguage2] Invalid.", (Object)"TMDSIKeyPanelControllerImpl");
            return;
        }
        this.logger.log(1078071040, "[%1.updateRecognizerLanguage2]", (Object)"TMDSIKeyPanelControllerImpl");
        this.dispatcher.execute(new TMDSIKeyPanelControllerImpl$1(this, "keyPanelListener.updateRecognizerLanguage2", n, string, n2));
    }

    @Override
    public void updateRecognizerMode(int n, int n2, int n3) {
        if (!this.isValid(n3)) {
            this.logger.log(-2137614336, "[%1.updateRecognizerMode] Invalid.", (Object)"TMDSIKeyPanelControllerImpl");
            return;
        }
        this.logger.log(1078071040, "[%1.updateRecognizerMode] %2", (Object)"TMDSIKeyPanelControllerImpl", (long)n2);
        this.dispatcher.execute(new TMDSIKeyPanelControllerImpl$2(this, "keyPanelListener.updateRecognizerMode", n, n2));
    }

    @Override
    public void updateCharacterEvent2(int n, String[] stringArray, int[] nArray, int n2) {
        if (!this.isValid(n2)) {
            this.logger.log(-2137614336, "[%1.updateCharacterEvent2] Invalid.", (Object)"TMDSIKeyPanelControllerImpl");
            return;
        }
        this.logger.log(1078071040, "[%1.updateCharacterEvent2]", (Object)"TMDSIKeyPanelControllerImpl");
        this.dispatcher.execute(new TMDSIKeyPanelControllerImpl$3(this, "keyPanelListener.updateCharacterEvent2", n, stringArray, nArray));
    }

    @Override
    public void updateGesture2(int n, int n2, int n3, boolean bl, int n4, int n5, int n6, int n7, int n8, int n9) {
    }

    @Override
    public void genericSettingResponse(int n, int n2, int n3) {
    }

    @Override
    public void updateProximity(int n, int n2, int n3) {
    }

    @Override
    public void lastKey(int n, int n2, int n3) {
    }

    @Override
    public void updateKeyboardType(int n, int n2) {
    }

    @Override
    public void updateTouchSensitiveArea(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public void getVersionInfo(int n, int n2, String string) {
    }

    @Override
    public void updateInputPanelReady(int n, int n2, int n3) {
    }

    @Override
    public void setTextInputActive(int n, boolean bl) {
        this.logger.log(1078071040, "[%1.setTextInputActive] %2", (Object)"TMDSIKeyPanelControllerImpl", (Object)String.valueOf(bl));
        if (null != this.keyPanelService) {
            if (bl) {
                this.kbdService.setRecognizerLanguage(this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageCode(), 2);
            }
            this.kbdService.setRecognizerMode(bl ? 26 : 25);
        }
    }

    @Override
    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = TMDSIKeyPanelControllerImpl.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel;
    }

    @Override
    protected DSIListener getDSIListener() {
        return this;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$keypanel$DSIKeyPanelListener == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanelListener = TMDSIKeyPanelControllerImpl.class$("org.dsi.ifc.keypanel.DSIKeyPanelListener")) : class$org$dsi$ifc$keypanel$DSIKeyPanelListener;
    }

    @Override
    protected void addDSIService(DSIBase dSIBase) {
        if (null != dSIBase) {
            this.keyPanelService = (DSIKeyPanel)dSIBase;
            this.keyPanelService.setNotification(new int[]{7, 9, 18, 19, 20, 21, 22, 23, 24, 25, 26}, (DSIListener)this);
        }
    }

    @Override
    protected void removeDSIService() {
        this.logger.log(1078071040, "[%1.removeDSIService]", (Object)"TMDSIKeyPanelControllerImpl");
        this.keyPanelService = null;
    }

    @Override
    public void getProperty(int n, int n2, int n3, int n4, byte[] byArray) {
    }

    @Override
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

    static /* synthetic */ TMDSIKeyPanelListener access$000(TMDSIKeyPanelControllerImpl tMDSIKeyPanelControllerImpl) {
        return tMDSIKeyPanelControllerImpl.listener;
    }
}

