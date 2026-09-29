/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.settings.TVSettings;
import de.audi.tv.app.storage.TVLastmode$DSICallListenerExt;
import de.audi.tv.app.storage.TVLastmode$OnDSIHandlerStateChangedListenerImpl;
import de.audi.tv.app.storage.TVLastmode$TVListenerImpl;
import de.audi.tv.app.storage.TVStorage;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVLastmode {
    private final TVStorage storage;
    private final DSIHandler dsihandler;
    private final TVEnv env;
    private final TVSettings settings;
    public final DefaultTVListener tvListener = new TVLastmode$TVListenerImpl(this, null);
    public final DSICallListener dsiCallListener = new TVLastmode$DSICallListenerExt(this, null);
    public final ITVEventListener dsiHandlerLockedListener;
    private int currentTunerState = -1;
    private int currentTerminalMode = 0;

    public TVLastmode(TVStorage tVStorage, DSIHandler dSIHandler, TVEnv tVEnv, TVSettings tVSettings) {
        this.storage = tVStorage;
        this.dsihandler = dSIHandler;
        this.env = tVEnv;
        this.settings = tVSettings;
        this.dsiHandlerLockedListener = new TVLastmode$OnDSIHandlerStateChangedListenerImpl(this, null);
    }

    private boolean isValidSource(int n) {
        return n == 0 || n == 1;
    }

    private void restore(boolean bl) {
        int n = this.storage.getActiveSource();
        if (this.currentTunerState == 1 && this.isValidSource(n)) {
            this.env.lcMain.log(1078071040, "[TVLastmode.restoreAfterSleep] activeSource:%1, terminalmode:%2", (long)n, (long)this.currentTerminalMode);
            if (n == 0) {
                ServiceInfo serviceInfo = this.storage.getTunedService();
                serviceInfo.contentGroup = 0;
                this.dsihandler.selectService(serviceInfo, false);
            }
            this.env.properties.terminalMode.desiredTerminalMode.accept(new Integer(this.currentTerminalMode));
            this.settings.restoreSettings(n);
        }
    }

    static /* synthetic */ int access$302(TVLastmode tVLastmode, int n) {
        tVLastmode.currentTerminalMode = n;
        return tVLastmode.currentTerminalMode;
    }

    static /* synthetic */ TVEnv access$400(TVLastmode tVLastmode) {
        return tVLastmode.env;
    }

    static /* synthetic */ int access$500(TVLastmode tVLastmode) {
        return tVLastmode.currentTunerState;
    }

    static /* synthetic */ int access$502(TVLastmode tVLastmode, int n) {
        tVLastmode.currentTunerState = n;
        return tVLastmode.currentTunerState;
    }

    static /* synthetic */ void access$600(TVLastmode tVLastmode, boolean bl) {
        tVLastmode.restore(bl);
    }

    static /* synthetic */ TVStorage access$700(TVLastmode tVLastmode) {
        return tVLastmode.storage;
    }
}

