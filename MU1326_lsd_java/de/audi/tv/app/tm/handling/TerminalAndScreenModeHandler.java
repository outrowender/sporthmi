/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GList
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable$Stub;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler$1;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler$2;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler$Properties;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler$TVListenerExt;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler$UpdateTerminalModeSafetyLeashRunnable;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;

public class TerminalAndScreenModeHandler {
    public static final long SAFETY_LEASH_THRESHOLD_MILLIS;
    public final DefaultTVListener tvListener = new TerminalAndScreenModeHandler$TVListenerExt(this, null);
    private final TVEnv env;
    private final DSITV dsi;
    private final TerminalAndScreenModeHandler$Properties myProperties;
    private final GList allocationQueue;
    private IDispatcher$ICancelable lastSafetyLeashJob = new IDispatcher$ICancelable$Stub();

    public TerminalAndScreenModeHandler(TVEnv tVEnv, DSITV dSITV, IDispatcher iDispatcher) {
        this.env = tVEnv;
        this.dsi = dSITV;
        this.myProperties = tVEnv.properties.terminalMode;
        this.allocationQueue = Generics.newArrayList();
        this.myProperties.desiredTerminalMode.combineWith(this.myProperties.desiredScreenMode).using(TerminalAndScreenModeTuple.TERMINALMODE_SCREENMODE_COMBINATOR).async(iDispatcher).subscribe((Consumer)new TerminalAndScreenModeHandler$1(this, tVEnv));
        this.myProperties.currentTerminalAndScreenMode.async(iDispatcher).subscribe((Consumer)new TerminalAndScreenModeHandler$2(this));
    }

    private void registerNewDesiredModesInTuningQueue(TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        boolean bl = this.allocationQueue.isEmpty();
        this.env.lcDSI.log(-2137614336, "[TerminalAndScreenModeHandler.registerNewDesiredModesInTuningQueue] modes: %1, noAlloc: %2", (Object)terminalAndScreenModeTuple, (Object)new Boolean(bl));
        boolean bl2 = terminalAndScreenModeTuple.equals(TVUtil.lastOfOrNull(this.allocationQueue));
        boolean bl3 = bl && terminalAndScreenModeTuple.equals(this.myProperties.currentTerminalAndScreenMode.get());
        boolean bl4 = bl2 || bl3;
        this.env.lcDSI.log(-2137614336, "[TerminalAndScreenModeHandler.registerNewDesiredModesInTuningQueue] equalsLastOfQueue: %1, equalsCurModeAndNoAlloc: %2, ignoreNewModes: %3", bl2, bl3, bl4);
        if (bl4) {
            return;
        }
        this.allocationQueue.add((Object)terminalAndScreenModeTuple);
        if (this.allocationQueue.size() > 2) {
            this.allocationQueue.remove(1);
        }
        if (bl) {
            boolean bl5 = true;
            if (this.myProperties.currentTerminalAndScreenMode.get() != null && ((TerminalAndScreenModeTuple)this.myProperties.currentTerminalAndScreenMode.get()).terminalMode == terminalAndScreenModeTuple.terminalMode) {
                bl5 = false;
            }
            TerminalAndScreenModeHandler$Properties.access$300(this.myProperties).accept(new Boolean(bl5));
            this.dsi.setTerminalMode(terminalAndScreenModeTuple.terminalMode, terminalAndScreenModeTuple.screenMode);
            this.lastSafetyLeashJob.cancel();
            this.lastSafetyLeashJob = this.env.dispatch.execute(new TerminalAndScreenModeHandler$UpdateTerminalModeSafetyLeashRunnable(this, terminalAndScreenModeTuple), 0);
        }
    }

    private void reportModeAllocationAsFinised(TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        TerminalAndScreenModeTuple terminalAndScreenModeTuple2;
        TerminalAndScreenModeTuple terminalAndScreenModeTuple3 = terminalAndScreenModeTuple2 = this.allocationQueue.isEmpty() ? null : (TerminalAndScreenModeTuple)this.allocationQueue.get(0);
        if (terminalAndScreenModeTuple.equals(terminalAndScreenModeTuple2)) {
            this.allocationQueue.remove(0);
        } else {
            this.env.lcDSI.log(-1601830656, "[TerminalAndScreenModeHandler.reportModeAllocationAsFinised] req: %1, act: %2", (Object)terminalAndScreenModeTuple2, (Object)terminalAndScreenModeTuple);
            this.myProperties.desiredTerminalMode.accept(new Integer(terminalAndScreenModeTuple.terminalMode));
            this.myProperties.desiredScreenMode.accept(new Integer(terminalAndScreenModeTuple.screenMode));
        }
        if (this.allocationQueue.isEmpty()) {
            this.lastSafetyLeashJob.cancel();
            TerminalAndScreenModeHandler$Properties.access$300(this.myProperties).accept(new Boolean(false));
        } else {
            TerminalAndScreenModeTuple terminalAndScreenModeTuple4 = (TerminalAndScreenModeTuple)this.allocationQueue.get(0);
            this.dsi.setTerminalMode(terminalAndScreenModeTuple4.terminalMode, terminalAndScreenModeTuple4.screenMode);
            this.lastSafetyLeashJob.cancel();
            this.lastSafetyLeashJob = this.env.dispatch.execute(new TerminalAndScreenModeHandler$UpdateTerminalModeSafetyLeashRunnable(this, terminalAndScreenModeTuple4), 0);
        }
    }

    static /* synthetic */ void access$100(TerminalAndScreenModeHandler terminalAndScreenModeHandler, TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        terminalAndScreenModeHandler.registerNewDesiredModesInTuningQueue(terminalAndScreenModeTuple);
    }

    static /* synthetic */ void access$200(TerminalAndScreenModeHandler terminalAndScreenModeHandler, TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        terminalAndScreenModeHandler.reportModeAllocationAsFinised(terminalAndScreenModeTuple);
    }

    static /* synthetic */ TerminalAndScreenModeHandler$Properties access$400(TerminalAndScreenModeHandler terminalAndScreenModeHandler) {
        return terminalAndScreenModeHandler.myProperties;
    }

    static /* synthetic */ TVEnv access$700(TerminalAndScreenModeHandler terminalAndScreenModeHandler) {
        return terminalAndScreenModeHandler.env;
    }
}

