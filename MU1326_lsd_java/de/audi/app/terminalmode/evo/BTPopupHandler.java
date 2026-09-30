/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.evo;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.bt.dsi.IBTDSIControllerListener;
import de.audi.app.terminalmode.bt.dsi.IBTDSIControllerListenerUpdateProvider;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.log.LogChannel;

public class BTPopupHandler
implements ITerminalModeComponent,
IActiveDeviceStateListener,
IBTDSIControllerListener {
    private static final String LOGCLASS = "BTPopupHandler";
    private final LogChannel logger;
    private final IContext context;
    private volatile boolean androidAutoDevice;
    private volatile int currentBTState;
    static /* synthetic */ Class class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider;

    public BTPopupHandler(IContext iContext) {
        this.context = iContext;
        this.logger = iContext.getLogger().hmi();
        this.currentBTState = 0;
    }

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.context.getDeviceManager().addActiveDeviceListener(this);
        ((IBTDSIControllerListenerUpdateProvider)this.context.get(class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider == null ? (class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider = BTPopupHandler.class$("de.audi.app.terminalmode.bt.dsi.IBTDSIControllerListenerUpdateProvider")) : class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider)).addListener(this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.context.getDeviceManager().removeActiveDeviceListener(this);
    }

    public void updateActiveDeviceState(TMDevice tMDevice) {
        this.logger.log(1000000, "[%1.updateActiveDeviceState]", (Object)LOGCLASS);
        this.androidAutoDevice = tMDevice.isAndroidAutoDevice() && tMDevice.connectionState().isNot(TMDevice.ConnectionState.NOT_ATTACHED);
    }

    public void updateBTState(int n) {
        if (this.androidAutoDevice && this.currentBTState != n && n == 2) {
            this.logger.log(1000000, "[%1.updateBTState] old: %2, new: %3 -> showing popup", (Object)LOGCLASS, (long)this.currentBTState, (long)n);
            this.context.getFramework().getHmiServiceApp().showPartialPopup(0, 3200007);
        }
        this.currentBTState = n;
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

