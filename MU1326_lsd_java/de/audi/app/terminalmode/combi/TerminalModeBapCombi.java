/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.combi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.combi.NullCombiBAPService;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi$ActiveDeviceStateListener;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi$AudioStateListener;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi$CachingEventListener;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi$CombiBapServiceTrackerCustomizer;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi$EventListener;
import de.audi.app.terminalmode.events.IEventListener;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public class TerminalModeBapCombi
implements ITerminalModeComponent {
    private static final String LOGCLASS;
    private final IContext context;
    private final BundleContext bundleContext;
    private final LogChannel lc;
    private final IServiceTracker serviceTracker;
    private final IServiceManager serviceManager;
    private final IEventListener eventListener;
    private final TerminalModeBapCombi$CachingEventListener cachingEventListener;
    private volatile CombiBAPServiceTerminalMode bapService;
    private TerminalModeBapCombi$ActiveDeviceStateListener activeDeviceListener;
    private final IAudioStateListener audioStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode;

    public TerminalModeBapCombi(IContext iContext) {
        this.context = iContext;
        this.bundleContext = this.context.getFramework().getBundleCxt();
        this.lc = this.context.getLogger().main();
        this.bapService = new NullCombiBAPService(this.lc);
        this.serviceManager = this.context.getServiceManager();
        this.serviceTracker = this.serviceManager.createServiceTracker(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode = TerminalModeBapCombi.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode, new TerminalModeBapCombi$CombiBapServiceTrackerCustomizer(this, null));
        this.eventListener = new TerminalModeBapCombi$EventListener(this, null);
        this.cachingEventListener = new TerminalModeBapCombi$CachingEventListener(this, null);
        this.activeDeviceListener = new TerminalModeBapCombi$ActiveDeviceStateListener(this, null);
        this.audioStateListener = new TerminalModeBapCombi$AudioStateListener(this, null);
    }

    @Override
    public void init() {
        this.serviceTracker.open();
        this.context.getEventBus().registerListener(this.cachingEventListener);
        this.context.getDeviceManager().addActiveDeviceListener(this.activeDeviceListener);
        this.context.getAudioManager().addAudioContextListener(this.audioStateListener);
    }

    @Override
    public void deinit() {
        this.serviceTracker.close();
        this.context.getEventBus().unregisterListener(this.eventListener);
        this.context.getEventBus().unregisterListener(this.cachingEventListener);
        this.context.getDeviceManager().removeActiveDeviceListener(this.activeDeviceListener);
        this.context.getAudioManager().removeAudioContextListener(this.audioStateListener);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ CombiBAPServiceTerminalMode access$500(TerminalModeBapCombi terminalModeBapCombi) {
        return terminalModeBapCombi.bapService;
    }

    static /* synthetic */ IEventListener access$600(TerminalModeBapCombi terminalModeBapCombi) {
        return terminalModeBapCombi.eventListener;
    }

    static /* synthetic */ LogChannel access$700(TerminalModeBapCombi terminalModeBapCombi) {
        return terminalModeBapCombi.lc;
    }

    static /* synthetic */ IContext access$800(TerminalModeBapCombi terminalModeBapCombi) {
        return terminalModeBapCombi.context;
    }

    static /* synthetic */ CombiBAPServiceTerminalMode access$502(TerminalModeBapCombi terminalModeBapCombi, CombiBAPServiceTerminalMode combiBAPServiceTerminalMode) {
        terminalModeBapCombi.bapService = combiBAPServiceTerminalMode;
        return terminalModeBapCombi.bapService;
    }

    static /* synthetic */ BundleContext access$900(TerminalModeBapCombi terminalModeBapCombi) {
        return terminalModeBapCombi.bundleContext;
    }

    static /* synthetic */ TerminalModeBapCombi$CachingEventListener access$1000(TerminalModeBapCombi terminalModeBapCombi) {
        return terminalModeBapCombi.cachingEventListener;
    }
}

