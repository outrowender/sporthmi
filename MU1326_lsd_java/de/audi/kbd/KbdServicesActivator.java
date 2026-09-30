/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.interapp.IEjectHandler;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.keyhandling.IVirtualGUIManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IMMICombiViewSizeSync;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.kbd.KeyMap;
import de.audi.kbd.dsi.KbdHandler;
import de.audi.kbd.dsi.KbdListener;
import de.audi.kbd.hmi.KeyBoardManagerImpl;
import de.audi.kbd.hmi.VirtualGUIManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.keypanel.DSIKeyPanel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class KbdServicesActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private LogChannel logChannel;
    private KbdListener kbdListener;
    private KbdHandler kbdHandler;
    private IVirtualGUIManager virtualGUIManager;
    private KeyBoardManagerImpl keyBoardManager;
    private ServiceTracker tracker;
    private final String[] trackedServices = new String[]{(class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = KbdServicesActivator.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel).getName(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = KbdServicesActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (class$de$audi$atip$interapp$IEjectHandler == null ? (class$de$audi$atip$interapp$IEjectHandler = KbdServicesActivator.class$("de.audi.atip.interapp.IEjectHandler")) : class$de$audi$atip$interapp$IEjectHandler).getName(), (class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = KbdServicesActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (class$de$audi$atip$mmicombi$IMMICombiViewSizeSync == null ? (class$de$audi$atip$mmicombi$IMMICombiViewSizeSync = KbdServicesActivator.class$("de.audi.atip.mmicombi.IMMICombiViewSizeSync")) : class$de$audi$atip$mmicombi$IMMICombiViewSizeSync).getName(), (class$de$audi$atip$mmicombi$IViewSizeManager == null ? (class$de$audi$atip$mmicombi$IViewSizeManager = KbdServicesActivator.class$("de.audi.atip.mmicombi.IViewSizeManager")) : class$de$audi$atip$mmicombi$IViewSizeManager).getName()};
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IEjectHandler;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IMMICombiViewSizeSync;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IViewSizeManager;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanelListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$de$audi$atip$hmi$KbdService;
    static /* synthetic */ Class class$de$audi$atip$hmi$IFocusManager;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IKeyBoardManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$ExternalKeyListener;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$RSESettingsEventListener;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.logChannel = this.framework.getLogChannel("Fw.Kbd.Activator");
        this.logChannel.log(1000000, "KbdServicesActivator.start(%1)", (Object)bundleContext);
        if (this.framework.getScreenRes() == 4) {
            this.logChannel.log(100000, "Patch KeyMap for MMIKombi");
            KeyMap.patchG24();
        } else if (this.framework.isPorsche()) {
            if (this.framework.isBentley()) {
                this.logChannel.log(100000, "Patch KeyMap for Bentley");
                KeyMap.patchBentley();
            } else {
                this.logChannel.log(100000, "Patch KeyMap for Porsche");
                KeyMap.patchPorsche();
            }
        }
        if (this.framework.isPGen2()) {
            KeyMap.patchPGen2();
        }
        this.virtualGUIManager = new VirtualGUIManager(this.framework);
        this.keyBoardManager = new KeyBoardManagerImpl(this.framework, this.virtualGUIManager);
        this.kbdListener = new KbdListener(this.framework, this.keyBoardManager);
        this.kbdHandler = new KbdHandler(this.framework, this.kbdListener);
        this.registerKbdServices(bundleContext);
        this.tracker = new ServiceTracker(bundleContext, this.trackedServices, (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    public void stop(BundleContext bundleContext) {
        if (this.tracker != null) {
            this.closeTracker(this.tracker);
            this.tracker = null;
        }
        super.stop(bundleContext);
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getBundleContext().getService(serviceReference);
        this.logChannel.log(1000000, "KbdServicesActivator.addingService: %1", object);
        if (object instanceof DSIKeyPanel) {
            DSIKeyPanel dSIKeyPanel = (DSIKeyPanel)object;
            this.kbdHandler.setDSIKeyPanel(dSIKeyPanel);
            dSIKeyPanel.setNotification(new int[]{19, 26, 25, 23, 7, 21, 20, 24, 22, 18}, (DSIListener)this.kbdListener);
        } else if (object instanceof SDSService) {
            this.kbdListener.setSDSService((SDSService)object);
            this.keyBoardManager.setSDSService((SDSService)object);
        } else if (object instanceof IEjectHandler) {
            this.kbdListener.setEjectHandler((IEjectHandler)object);
        } else if (object instanceof HMIApplication) {
            this.virtualGUIManager.connectService((HMIApplication)object);
            this.kbdHandler.initializeAsiaRecognizerTimeoutModel();
        } else if (object instanceof IMMICombiViewSizeSync) {
            this.kbdListener.setIMMICombiViewSizeSync((IMMICombiViewSizeSync)object);
        } else if (object instanceof IViewSizeManager) {
            this.kbdListener.setViewSizeManager((IViewSizeManager)object);
        } else {
            return null;
        }
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        this.logChannel.log(1000000, "KbdServicesActivator.removedService: %1", object);
        if (object instanceof DSIKeyPanel) {
            this.kbdHandler.setDSIKeyPanel(null);
        } else if (object instanceof IEjectHandler) {
            this.kbdListener.setEjectHandler(null);
        } else if (object instanceof HMIApplication) {
            this.virtualGUIManager.disconnectService((HMIApplication)object);
        } else if (object instanceof IMMICombiViewSizeSync) {
            this.kbdListener.setIMMICombiViewSizeSync(null);
        } else if (object instanceof IViewSizeManager) {
            this.kbdListener.setViewSizeManager(null);
        }
        this.bundleContext.ungetService(serviceReference);
    }

    private void registerKbdServices(BundleContext bundleContext) {
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = KbdServicesActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.kbdListener, (class$org$dsi$ifc$keypanel$DSIKeyPanelListener == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanelListener = KbdServicesActivator.class$("org.dsi.ifc.keypanel.DSIKeyPanelListener")) : class$org$dsi$ifc$keypanel$DSIKeyPanelListener).getName(), 0);
        this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = KbdServicesActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.kbdListener, null);
        this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = KbdServicesActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.kbdHandler, null);
        this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = KbdServicesActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.virtualGUIManager, null);
        this.registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = KbdServicesActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)this.kbdHandler, null);
        this.registerService((class$de$audi$atip$hmi$KbdService == null ? (class$de$audi$atip$hmi$KbdService = KbdServicesActivator.class$("de.audi.atip.hmi.KbdService")) : class$de$audi$atip$hmi$KbdService).getName(), (Object)this.kbdHandler, null);
        this.registerService((class$de$audi$atip$hmi$IFocusManager == null ? (class$de$audi$atip$hmi$IFocusManager = KbdServicesActivator.class$("de.audi.atip.hmi.IFocusManager")) : class$de$audi$atip$hmi$IFocusManager).getName(), (Object)this.virtualGUIManager.getFocusManager(), null);
        this.registerService((class$de$audi$atip$hmi$view$IKeyBoardManager == null ? (class$de$audi$atip$hmi$view$IKeyBoardManager = KbdServicesActivator.class$("de.audi.atip.hmi.view.IKeyBoardManager")) : class$de$audi$atip$hmi$view$IKeyBoardManager).getName(), (Object)this.keyBoardManager, null);
        this.registerService((class$de$audi$atip$interapp$ExternalKeyListener == null ? (class$de$audi$atip$interapp$ExternalKeyListener = KbdServicesActivator.class$("de.audi.atip.interapp.ExternalKeyListener")) : class$de$audi$atip$interapp$ExternalKeyListener).getName(), (Object)this.kbdListener, null);
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = KbdServicesActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.kbdListener, null);
        if (!this.framework.isFrontMU()) {
            this.registerService((class$de$audi$atip$interapp$RSESettingsEventListener == null ? (class$de$audi$atip$interapp$RSESettingsEventListener = KbdServicesActivator.class$("de.audi.atip.interapp.RSESettingsEventListener")) : class$de$audi$atip$interapp$RSESettingsEventListener).getName(), (Object)this.kbdListener, null);
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

