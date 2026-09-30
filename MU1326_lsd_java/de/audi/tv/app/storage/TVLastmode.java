/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.settings.TVSettings;
import de.audi.tv.app.storage.TVStorage;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVLastmode {
    private final TVStorage storage;
    private final DSIHandler dsihandler;
    private final TVEnv env;
    private final TVSettings settings;
    public final DefaultTVListener tvListener = new TVListenerImpl();
    public final DSICallListener dsiCallListener = new DSICallListenerExt();
    public final ITVEventListener dsiHandlerLockedListener;
    private int currentTunerState = -1;
    private int currentTerminalMode = 0;

    public TVLastmode(TVStorage tVStorage, DSIHandler dSIHandler, TVEnv tVEnv, TVSettings tVSettings) {
        this.storage = tVStorage;
        this.dsihandler = dSIHandler;
        this.env = tVEnv;
        this.settings = tVSettings;
        this.dsiHandlerLockedListener = new OnDSIHandlerStateChangedListenerImpl();
    }

    private boolean isValidSource(int n) {
        return n == 0 || n == 1;
    }

    private void restore(boolean bl) {
        int n = this.storage.getActiveSource();
        if (this.currentTunerState == 1 && this.isValidSource(n)) {
            this.env.lcMain.log(1000000, "[TVLastmode.restoreAfterSleep] activeSource:%1, terminalmode:%2", (long)n, (long)this.currentTerminalMode);
            if (n == 0) {
                ServiceInfo serviceInfo = this.storage.getTunedService();
                serviceInfo.contentGroup = 0;
                this.dsihandler.selectService(serviceInfo, false);
            }
            this.env.properties.terminalMode.desiredTerminalMode.accept(new Integer(this.currentTerminalMode));
            this.settings.restoreSettings(n);
        }
    }

    private class TVListenerImpl
    extends DefaultTVListener {
        private TVListenerImpl() {
        }

        public void updateTerminalMode(int n, int n2) {
            TVLastmode.this.currentTerminalMode = n;
        }

        public void updateTunerState(int n) {
            ((TVLastmode)TVLastmode.this).env.lcMain.log(10000000, "[TVLastmode.updateTunerState] state:%1", (long)n);
            boolean bl = TVLastmode.this.currentTunerState == 0 && n == 1;
            TVLastmode.this.currentTunerState = n;
            TVLastmode.this.restore(bl);
        }

        public void updateSelectedService(ProgramInfo programInfo) {
            TVLastmode.this.storage.setTunedService(programInfo.serviceInfo);
        }
    }

    private class DSICallListenerExt
    extends DSICallListener {
        private DSICallListenerExt() {
        }

        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            TVLastmode.this.storage.setTunedService(serviceInfo);
        }

        public void switchSource(int n, boolean bl) {
            ((TVLastmode)TVLastmode.this).env.lcMain.log(10000000, "[TVLastmode.switchSource] source:%1", (long)n);
            int n2 = TVUtil.getInternalSourceRepresentation(n);
            if (n2 != -1) {
                TVLastmode.this.storage.setActiveSource(n2);
            }
        }

        public void setTerminalMode(int n, int n2) {
            TVLastmode.this.currentTerminalMode = n;
        }
    }

    private class OnDSIHandlerStateChangedListenerImpl
    extends TVEventDefaultListener {
        private OnDSIHandlerStateChangedListenerImpl() {
        }

        public void onDSILocked() {
        }

        public void onDSIUnlocked() {
            TVLastmode.this.restore(false);
        }
    }
}

