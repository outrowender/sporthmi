/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.properties.ObservableProperty;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class TerminalAndScreenModeHandler {
    public static final long SAFETY_LEASH_THRESHOLD_MILLIS = 5000L;
    public final DefaultTVListener tvListener = new TVListenerExt();
    private final TVEnv env;
    private final DSITV dsi;
    private final Properties myProperties;
    private final GList<TerminalAndScreenModeTuple> allocationQueue;
    private IDispatcher.ICancelable lastSafetyLeashJob = new IDispatcher.ICancelable.Stub();

    public TerminalAndScreenModeHandler(final TVEnv tVEnv, DSITV dSITV, IDispatcher iDispatcher) {
        this.env = tVEnv;
        this.dsi = dSITV;
        this.myProperties = tVEnv.properties.terminalMode;
        this.allocationQueue = Generics.newArrayList();
        this.myProperties.desiredTerminalMode.combineWith(this.myProperties.desiredScreenMode).using(TerminalAndScreenModeTuple.TERMINALMODE_SCREENMODE_COMBINATOR).async(iDispatcher).subscribe(new Consumer<TerminalAndScreenModeTuple>(){

            @Override
            public void accept(TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
                tVEnv.getChoiceModel(2600156).setValue(terminalAndScreenModeTuple.terminalMode);
                TerminalAndScreenModeHandler.this.registerNewDesiredModesInTuningQueue(terminalAndScreenModeTuple);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((TerminalAndScreenModeTuple)object);
            }
        });
        this.myProperties.currentTerminalAndScreenMode.async(iDispatcher).subscribe(new Consumer<TerminalAndScreenModeTuple>(){

            @Override
            public void accept(TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
                TerminalAndScreenModeHandler.this.reportModeAllocationAsFinised(terminalAndScreenModeTuple);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((TerminalAndScreenModeTuple)object);
            }
        });
    }

    private void registerNewDesiredModesInTuningQueue(TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        boolean bl = this.allocationQueue.isEmpty();
        this.env.lcDSI.log(10000000, "[TerminalAndScreenModeHandler.registerNewDesiredModesInTuningQueue] modes: %1, noAlloc: %2", (Object)terminalAndScreenModeTuple, (Object)new Boolean(bl));
        boolean bl2 = terminalAndScreenModeTuple.equals(TVUtil.lastOfOrNull(this.allocationQueue));
        boolean bl3 = bl && terminalAndScreenModeTuple.equals(this.myProperties.currentTerminalAndScreenMode.get());
        boolean bl4 = bl2 || bl3;
        this.env.lcDSI.log(10000000, "[TerminalAndScreenModeHandler.registerNewDesiredModesInTuningQueue] equalsLastOfQueue: %1, equalsCurModeAndNoAlloc: %2, ignoreNewModes: %3", bl2, bl3, bl4);
        if (bl4) {
            return;
        }
        this.allocationQueue.add(terminalAndScreenModeTuple);
        if (this.allocationQueue.size() > 2) {
            this.allocationQueue.remove(1);
        }
        if (bl) {
            boolean bl5 = true;
            if (this.myProperties.currentTerminalAndScreenMode.get() != null && ((TerminalAndScreenModeTuple)this.myProperties.currentTerminalAndScreenMode.get()).terminalMode == terminalAndScreenModeTuple.terminalMode) {
                bl5 = false;
            }
            this.myProperties.writableTerminalModeChangeRunning().accept(new Boolean(bl5));
            this.dsi.setTerminalMode(terminalAndScreenModeTuple.terminalMode, terminalAndScreenModeTuple.screenMode);
            this.lastSafetyLeashJob.cancel();
            this.lastSafetyLeashJob = this.env.dispatch.execute(new UpdateTerminalModeSafetyLeashRunnable(terminalAndScreenModeTuple), 5000L);
        }
    }

    private void reportModeAllocationAsFinised(TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        TerminalAndScreenModeTuple terminalAndScreenModeTuple2;
        TerminalAndScreenModeTuple terminalAndScreenModeTuple3 = terminalAndScreenModeTuple2 = this.allocationQueue.isEmpty() ? null : this.allocationQueue.get(0);
        if (terminalAndScreenModeTuple.equals(terminalAndScreenModeTuple2)) {
            this.allocationQueue.remove(0);
        } else {
            this.env.lcDSI.log(100000, "[TerminalAndScreenModeHandler.reportModeAllocationAsFinised] req: %1, act: %2", (Object)terminalAndScreenModeTuple2, (Object)terminalAndScreenModeTuple);
            this.myProperties.desiredTerminalMode.accept(new Integer(terminalAndScreenModeTuple.terminalMode));
            this.myProperties.desiredScreenMode.accept(new Integer(terminalAndScreenModeTuple.screenMode));
        }
        if (this.allocationQueue.isEmpty()) {
            this.lastSafetyLeashJob.cancel();
            this.myProperties.writableTerminalModeChangeRunning().accept(new Boolean(false));
        } else {
            TerminalAndScreenModeTuple terminalAndScreenModeTuple4 = this.allocationQueue.get(0);
            this.dsi.setTerminalMode(terminalAndScreenModeTuple4.terminalMode, terminalAndScreenModeTuple4.screenMode);
            this.lastSafetyLeashJob.cancel();
            this.lastSafetyLeashJob = this.env.dispatch.execute(new UpdateTerminalModeSafetyLeashRunnable(terminalAndScreenModeTuple4), 5000L);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Properties {
        public final Property<Integer> desiredTerminalMode;
        public final Property<Integer> desiredScreenMode;
        public final ObservableProperty<TerminalAndScreenModeTuple> currentTerminalAndScreenMode;
        public final ObservableProperty<Integer> correctDataBroadcastTerminalMode;
        public final ObservableProperty<Boolean> terminalModeChangeRunning;

        public Properties(PropertyFactory propertyFactory) {
            this.desiredTerminalMode = propertyFactory.createProperty("TerminalAndScreenModeHandler.desiredTerminalMode");
            this.desiredScreenMode = propertyFactory.createProperty("TerminalAndScreenModeHandler.desiredScreenMode", new Integer(0));
            this.currentTerminalAndScreenMode = propertyFactory.createProperty("TerminalAndScreenModeHandler.currentTerminalAndScreenMode");
            this.correctDataBroadcastTerminalMode = propertyFactory.createProperty("TerminalAndScreenModeHandler.correctDataBroadcastTerminalMode");
            this.terminalModeChangeRunning = propertyFactory.createProperty("TerminalAndScreenModeHandler.terminalModeChangeRunning", new Boolean(false));
        }

        private Property<TerminalAndScreenModeTuple> writeableCurrentTerminalAndScreenMode() {
            return (Property)this.currentTerminalAndScreenMode;
        }

        private Property<Integer> writeableCorrectDataBroadcastTerminalMode() {
            return (Property)this.correctDataBroadcastTerminalMode;
        }

        private Property<Boolean> writableTerminalModeChangeRunning() {
            return (Property)this.terminalModeChangeRunning;
        }
    }

    private class TVListenerExt
    extends DefaultTVListener {
        private TVListenerExt() {
        }

        public void updateTerminalMode(int n, int n2) {
            TerminalAndScreenModeHandler.this.myProperties.writeableCurrentTerminalAndScreenMode().accept(new TerminalAndScreenModeTuple(n, n2));
        }

        public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
            int n = -1;
            if (startUpConfig.tmDatabroadDVBAvail) {
                n = 2;
            } else if (startUpConfig.tmDatabroadATSCAvail) {
                n = 6;
            } else if (startUpConfig.tmDatabroadISDBAvail) {
                n = 3;
            } else if (startUpConfig.tmDatabroadDMBAvail) {
                n = 5;
            } else if (startUpConfig.tmDatabroadDTMBAvail) {
                n = 4;
            } else if (startUpConfig.tmDatabroad1Avail) {
                n = 7;
            } else if (startUpConfig.tmDatabroad2Avail) {
                n = 8;
            }
            TerminalAndScreenModeHandler.this.myProperties.writeableCorrectDataBroadcastTerminalMode().accept(new Integer(n));
        }
    }

    public class UpdateTerminalModeSafetyLeashRunnable
    implements Runnable {
        private final TerminalAndScreenModeTuple expectedTuple;

        public UpdateTerminalModeSafetyLeashRunnable(TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
            this.expectedTuple = terminalAndScreenModeTuple;
        }

        public void run() {
            ((TerminalAndScreenModeHandler)TerminalAndScreenModeHandler.this).env.lcDSI.log(10000, "[UpdateTerminalModeSafetyLeashRunnable] No update for %1 from DSI. Fake it now!", (Object)this.expectedTuple);
            TerminalAndScreenModeHandler.this.myProperties.writeableCurrentTerminalAndScreenMode().accept(this.expectedTuple);
        }
    }
}

