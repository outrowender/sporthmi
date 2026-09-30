/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.display;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.display.ContextSetting;
import de.audi.app.media.display.DisplaySettingsHMIHandler;
import de.audi.app.media.dsi.display.DSIDisplayManagerControllerImpl;
import de.audi.app.media.dsi.display.IDSIDisplayManagerController;
import de.audi.app.media.dsi.display.IMediaDisplayManagerListener;
import de.audi.atip.power.PowerEventListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Hashtable;
import java.util.Map;
import org.osgi.framework.ServiceRegistration;

public class DisplaySettingManager
extends AbstractMediaTerminalComponent
implements PowerEventListener,
IMediaDisplayManagerListener,
IActionProxyListener {
    private static final String LOGCLASS = "DisplaySettingManager";
    public static final byte CONTEXT_NONE = -1;
    public static final byte CONTEXT_DVD_VIDEO = 0;
    public static final byte CONTEXT_FILE_VIDEO = 1;
    public static final byte CONTEXT_AUX_VIDEOSTREAM = 2;
    public static final byte CONTEXT_TV = 3;
    public static final byte CONTEXT_AV1 = 4;
    public static final byte CONTEXT_AV2 = 5;
    private final DisplaySettingsHMIHandler hmiHandler;
    private final IDSIDisplayManagerController dsiController;
    private volatile byte activeContext = (byte)-1;
    private volatile int activeDisplayable = -1;
    private volatile int activeDisplayContext = 0;
    private volatile ServiceRegistration powerEventListenerRegistration;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public DisplaySettingManager(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.dsiController = new DSIDisplayManagerControllerImpl(0, iMediaTerminal.getServiceManager(), iMediaTerminal.getFramework(), iMediaTerminal.getDispatcher(), this.logger.dsi());
        this.hmiHandler = new DisplaySettingsHMIHandler(iMediaTerminal, this);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.hmiHandler.init();
        this.dsiController.init();
        this.dsiController.startDSI();
        this.dsiController.setDisplayManagerListener(this);
        this.getTerminal().addActionProxyListener(1009, (IActionProxyListener)this);
        this.powerEventListenerRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = DisplaySettingManager.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.getTerminal().removeActionProxyListener(this);
        this.dsiController.setDisplayManagerListener(null);
        this.dsiController.deinit();
        this.powerEventListenerRegistration.unregister();
        this.hmiHandler.deinit();
    }

    public void setActiveContext(byte by, int n) {
        if (by == this.activeContext) {
            this.logger.main().log(1000000, "[%1.setActiveContext] Already active.", (Object)LOGCLASS);
            return;
        }
        this.activeContext = by;
        if (by == -1) {
            this.logger.main().log(1000000, "[%1.setActiveContext] CONTEXT_NONE. ", (Object)LOGCLASS);
            this.activeDisplayContext = 0;
            this.activeDisplayable = -1;
            this.enableVideoOverlay(false);
            return;
        }
        this.activeDisplayContext = n;
        this.activeDisplayable = this.getVideoDisplayable(n);
        this.logger.main().log(1000000, "[%1.setActiveContext] '%2' (displayable='%3'). ", (Object)LOGCLASS, (Object)DisplaySettingManager.getVideoContextStr(by), (long)this.activeDisplayable);
        ContextSetting contextSetting = new ContextSetting(this.activeContext, this.getTerminal().getMediaPersistence().getStorage().loadByteArray(DisplaySettingManager.getAddress(this.activeContext)));
        this.logger.main().log(1000000, "[%1.setActiveContext] Restore '%2'.", (Object)LOGCLASS, (Object)contextSetting);
        this.setContextValues(contextSetting);
        this.enableVideoOverlay(true);
    }

    private int getVideoDisplayable(int n) {
        int[] nArray = this.getTerminal().getFramework().getHMIService().getDisplayManager().getDisplayables(n);
        if (nArray == null) {
            this.logger.main().log(1000000, "[%1.getVideoDisplayable] No displayables.", (Object)LOGCLASS);
            return -1;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == 16 || nArray[i2] == 36) continue;
            return nArray[i2];
        }
        return -1;
    }

    public static final String getVideoContextStr(byte by) {
        switch (by) {
            case 2: {
                return "CONTEXT_AUX_VIDEOSTREAM";
            }
            case 4: {
                return "CONTEXT_AV1";
            }
            case 5: {
                return "CONTEXT_AV2";
            }
            case 0: {
                return "CONTEXT_DVD_VIDEO";
            }
            case 3: {
                return "CONTEXT_TV";
            }
            case 1: {
                return "CONTEXT_FILE_VIDEO";
            }
        }
        return "UNKNOWN";
    }

    public void setNTSCMode(boolean bl) {
        this.logger.main().log(1000000, "[%2.setNTSCMode] '%1'", bl, (Object)LOGCLASS);
        this.hmiHandler.setTintMode(bl);
    }

    public void resetSettings(byte by, boolean bl) {
        this.logger.main().log(1000000, "[%1.resetSettings] '%2'.", (Object)LOGCLASS, (Object)DisplaySettingManager.getVideoContextStr(by));
        ContextSetting contextSetting = new ContextSetting(by);
        this.getTerminal().getMediaPersistence().getStorage().persistByteArray(DisplaySettingManager.getAddress(by), contextSetting.getDataArray());
        if (bl) {
            this.setContextValues(contextSetting);
        }
    }

    private void setContextValues(ContextSetting contextSetting) {
        this.setBrightness(contextSetting.getBrightness());
        this.setColor(contextSetting.getColor());
        this.setContrast(contextSetting.getContrast());
        this.setTint(contextSetting.getTint());
    }

    public void enableVideoOverlay(boolean bl) {
        this.getChoiceModel(200564).setValue(bl ? this.activeDisplayContext : 0);
    }

    public void setBrightness(int n) {
        this.logger.main().log(1000000, "[%1.setBrightness] '%2'", (Object)LOGCLASS, (long)n);
        this.dsiController.setBrightness(this.getActiveDisplayable(), n);
    }

    public void setColor(int n) {
        this.logger.main().log(1000000, "[%1.setColor] '%2'", (Object)LOGCLASS, (long)n);
        this.dsiController.setColor(this.getActiveDisplayable(), n);
    }

    public void setContrast(int n) {
        this.logger.main().log(1000000, "[%1.setContrast] '%2'", (Object)LOGCLASS, (long)n);
        this.dsiController.setContrast(this.getActiveDisplayable(), n);
    }

    public void setTint(int n) {
        this.logger.main().log(1000000, "[%1.setTint] '%2'", (Object)LOGCLASS, (long)n);
        this.dsiController.setTint(this.getActiveDisplayable(), n);
    }

    private int getActiveDisplayable() {
        return this.activeDisplayable;
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
        if (n != 2) {
            return;
        }
        if (!this.hmiHandler.haveSettingsChanged()) {
            this.logger.main().log(1000000, "[%1.notifyPowerListenerOnEnterState] Settings not changed. ", (Object)LOGCLASS);
            return;
        }
        this.logger.main().log(10000000, "[%1.notifyPowerListenerOnEnterState] Saving settings. ", (Object)LOGCLASS);
        this.hmiHandler.resetDSIUpdateState();
        ContextSetting contextSetting = new ContextSetting(this.activeContext, (byte)this.hmiHandler.getColor(), (byte)this.hmiHandler.getContrast(), (byte)this.hmiHandler.getBrightness(), (byte)this.hmiHandler.getTint());
        this.getTerminal().getMediaPersistence().getStorage().persistByteArray(DisplaySettingManager.getAddress(this.activeContext), contextSetting.getDataArray());
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    public void updateBrigthness(int n, int n2) {
        if (n != this.getActiveDisplayable()) {
            return;
        }
        this.logger.main().log(1000000, "[%1.updateBrigthness] '%2'", (Object)LOGCLASS, (long)n2);
        this.hmiHandler.setBrightness(n2);
    }

    public void updateContrast(int n, int n2) {
        if (n != this.getActiveDisplayable()) {
            return;
        }
        this.logger.main().log(1000000, "[%1.updateContrast] '%2'", (Object)LOGCLASS, (long)n2);
        this.hmiHandler.setContrast(n2);
    }

    public void updateColor(int n, int n2) {
        if (n != this.getActiveDisplayable()) {
            return;
        }
        this.logger.main().log(1000000, "[%1.updateColor] '%2'", (Object)LOGCLASS, (long)n2);
        this.hmiHandler.setColor(n2);
    }

    public void updateTint(int n, int n2) {
        if (n != this.getActiveDisplayable()) {
            return;
        }
        this.logger.main().log(1000000, "[%1.updateTint] '%2'", (Object)LOGCLASS, (long)n2);
        this.hmiHandler.setTint(n2);
    }

    public void actionProxyCallPerformed(int n, Map map) {
        if (n != 1009) {
            return;
        }
        Integer n2 = (Integer)map.get("SETTING");
        if (n2 == null) {
            this.logger.main().log(1000000, "[%1.actionProxyCallPerformed] No setting.", (Object)LOGCLASS);
            return;
        }
        this.hmiHandler.resetDSIUpdateState();
        ContextSetting contextSetting = new ContextSetting(this.activeContext, (byte)this.hmiHandler.getColor(), (byte)this.hmiHandler.getContrast(), (byte)this.hmiHandler.getBrightness(), (byte)this.hmiHandler.getTint());
        this.getTerminal().getMediaPersistence().getStorage().persistByteArray(DisplaySettingManager.getAddress(this.activeContext), contextSetting.getDataArray());
    }

    private static int getAddress(byte by) {
        switch (by) {
            case 3: {
                return 30;
            }
            case 4: {
                return 40;
            }
            case 5: {
                return 50;
            }
            case 0: {
                return 60;
            }
            case 1: {
                return 70;
            }
            case 2: {
                return 80;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Wrong context '").append(by).append("'").toString());
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
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

