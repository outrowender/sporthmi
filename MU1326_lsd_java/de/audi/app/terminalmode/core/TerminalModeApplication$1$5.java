/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.core;

import de.audi.app.terminalmode.core.TerminalModeApplication;
import de.audi.app.terminalmode.core.TerminalModeApplication$1;
import de.audi.app.terminalmode.util.DispatcherProxy;
import de.audi.atip.utils.injector.IInjector;
import de.audi.atip.utils.injector.Injector$IProvider;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener;

class TerminalModeApplication$1$5
implements Injector$IProvider {
    private final /* synthetic */ TerminalModeApplication$1 this$1;

    TerminalModeApplication$1$5(TerminalModeApplication$1 terminalModeApplication$1) {
        this.this$1 = terminalModeApplication$1;
    }

    @Override
    public Object provide(IInjector iInjector, Object object) {
        DSIAndroidAuto2Listener dSIAndroidAuto2Listener = (DSIAndroidAuto2Listener)iInjector.getInstance(object, TerminalModeApplication.class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2ListenerDistributor == null ? (TerminalModeApplication.class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2ListenerDistributor = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2ListenerDistributor")) : TerminalModeApplication.class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2ListenerDistributor);
        DispatcherBase dispatcherBase = (DispatcherBase)iInjector.getInstance(TerminalModeApplication.class$de$esolutions$fw$util$commons$job$DispatcherBase == null ? (TerminalModeApplication.class$de$esolutions$fw$util$commons$job$DispatcherBase = TerminalModeApplication.class$("de.esolutions.fw.util.commons.job.DispatcherBase")) : TerminalModeApplication.class$de$esolutions$fw$util$commons$job$DispatcherBase);
        return DispatcherProxy.create(TerminalModeApplication.class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener == null ? (TerminalModeApplication.class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener = TerminalModeApplication.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener")) : TerminalModeApplication.class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener, dSIAndroidAuto2Listener, dispatcherBase);
    }
}

