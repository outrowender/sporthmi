/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.observables.Observable
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable$Stub;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.tv.app.SourceManager$Properties;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.tm.handling.DisplayManagerHandler$1;
import de.audi.tv.app.tm.handling.DisplayManagerHandler$2;
import de.audi.tv.app.tm.handling.DisplayManagerHandler$3;
import de.audi.tv.app.tm.handling.DisplayManagerHandler$4;
import de.audi.tv.app.tm.handling.DisplayManagerHandler$Properties;
import de.audi.tv.app.util.generics.Triple;
import de.audi.tv.app.util.generics.TvPredicates;

public class DisplayManagerHandler {
    private static final int START_WARMUP_MILLIS;
    private IDispatcher$ICancelable lastStartComponentJob = new IDispatcher$ICancelable$Stub();
    private final DSITV dsi;
    private final IDispatcher tvDispatcher;
    private final TVEnv env;

    public DisplayManagerHandler(TVEnv tVEnv, DSITV dSITV, IDispatcher iDispatcher) {
        this.dsi = dSITV;
        this.tvDispatcher = iDispatcher;
        this.env = tVEnv;
        DisplayManagerHandler$Properties displayManagerHandler$Properties = tVEnv.properties.dmComponent;
        SourceManager$Properties sourceManager$Properties = tVEnv.properties.source;
        tVEnv.properties.terminalMode.terminalModeChangeRunning.filter(TvPredicates.IS_FALSE).combineWith((Observable)tVEnv.properties.terminalMode.currentTerminalAndScreenMode).using(new DisplayManagerHandler$1(this)).subscribe((Consumer)DisplayManagerHandler$Properties.access$000(displayManagerHandler$Properties));
        tVEnv.properties.terminalMode.terminalModeChangeRunning.combineWith(tVEnv.properties.eventDispatcher.tunerEsmReady).combineWith(tVEnv.properties.eventDispatcher.mostUnused).using(new DisplayManagerHandler$2(this)).subscribe((Consumer)DisplayManagerHandler$Properties.access$100(displayManagerHandler$Properties));
        displayManagerHandler$Properties.showVideoPossible.combineWith(displayManagerHandler$Properties.currentDisplayableId).combineWith(sourceManager$Properties.currentSource).using(Triple.combine()).distinctUntilChanged().async(iDispatcher).subscribe((Consumer)new DisplayManagerHandler$3(this, tVEnv));
    }

    private void onRelevantDataChanged(boolean bl, int n, Integer n2, boolean bl2) {
        boolean bl3 = n2 != null && n != n2;
        this.env.lcDSI.log(-2137614336, "[DisplayManagerHandler.onRelevantDataChanged] isDisplayIdChange: %1", bl3);
        this.env.lcDSI.log(-2137614336, "[DisplayManagerHandler.onRelevantDataChanged] showVideoPossible: %1, displayId: %2, previousDisplayId: %3, SourceSwitched: %4", (Object)bl, (Object)new Integer(n), (Object)n2, (Object)bl2);
        this.lastStartComponentJob.cancel();
        if (!bl || bl3 || bl2 && bl3) {
            if (n2 != null) {
                this.dsi.stopComponent(n2);
                this.env.framework.getMsgDistrib().sendMessage(203);
                this.env.lcDSI.log(-2137614336, "[DisplayManagerHandler.onRelevantDataChanged] -> TV_TUNER_DEACTIVATED!!");
            } else {
                this.dsi.stopComponent(0);
            }
        }
        if (bl) {
            this.lastStartComponentJob = this.tvDispatcher.execute(new DisplayManagerHandler$4(this, n), 0);
        }
    }

    static /* synthetic */ void access$200(DisplayManagerHandler displayManagerHandler, boolean bl, int n, Integer n2, boolean bl2) {
        displayManagerHandler.onRelevantDataChanged(bl, n, n2, bl2);
    }

    static /* synthetic */ TVEnv access$300(DisplayManagerHandler displayManagerHandler) {
        return displayManagerHandler.env;
    }

    static /* synthetic */ DSITV access$400(DisplayManagerHandler displayManagerHandler) {
        return displayManagerHandler.dsi;
    }
}

