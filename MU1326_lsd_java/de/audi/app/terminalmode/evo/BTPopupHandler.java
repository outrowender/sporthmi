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
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.atip.log.LogChannel;

public class BTPopupHandler
implements ITerminalModeComponent,
IActiveDeviceStateListener,
IBTDSIControllerListener {
    private static final String LOGCLASS;
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

    @Override
    public void init() {
        this.logger.log(14808325, "[%1.init]", (Object)"BTPopupHandler");
        this.context.getDeviceManager().addActiveDeviceListener(this);
        ((IBTDSIControllerListenerUpdateProvider)this.context.get(class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider == null ? (class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider = BTPopupHandler.class$("de.audi.app.terminalmode.bt.dsi.IBTDSIControllerListenerUpdateProvider")) : class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider)).addListener(this);
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"BTPopupHandler");
        this.context.getDeviceManager().removeActiveDeviceListener(this);
    }

    @Override
    public void updateActiveDeviceState(TMDevice tMDevice) {
        this.logger.log(1078071040, "[%1.updateActiveDeviceState]", (Object)"BTPopupHandler");
        this.androidAutoDevice = tMDevice.isAndroidAutoDevice() && tMDevice.connectionState().isNot(TMDevice$ConnectionState.NOT_ATTACHED);
    }

    @Override
    public void updateBTState(int n) {
        if (this.androidAutoDevice && this.currentBTState != n && n == 2) {
            this.logger.log(1078071040, "[%1.updateBTState] old: %2, new: %3 -> showing popup", (Object)"BTPopupHandler", (long)this.currentBTState, (long)n);
            this.context.getFramework().getHmiServiceApp().showPartialPopup(0, 131346432);
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

