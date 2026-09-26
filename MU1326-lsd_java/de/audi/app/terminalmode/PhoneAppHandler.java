/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.PhoneAppHandler$1;
import de.audi.app.terminalmode.PhoneAppHandler$2;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.interapp.terminalmode.ITerminalModeService;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.Generics;

public class PhoneAppHandler
implements ITerminalModeComponent {
    private static final String LOGCLASS;
    private volatile IServiceTracker createServiceTracker;
    private volatile IServiceTracker updateListenerServiceTracker;
    private final GCopyOnWriteList terminalModeServiceList;
    private final GCopyOnWriteList terminalModeUpdateListenerList;
    private volatile boolean videoFocus;
    private final IContext context;
    private final LogChannel logger;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeService;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;

    public PhoneAppHandler(IContext iContext) {
        this.context = (IContext)Preconditions.checkNotNull((Object)iContext);
        this.logger = (LogChannel)Preconditions.checkNotNull((Object)iContext.getLogger().main());
        this.terminalModeServiceList = Generics.newCopyOnWriteArrayList();
        this.terminalModeUpdateListenerList = Generics.newCopyOnWriteArrayList();
    }

    @Override
    public void init() {
        this.logger.log(14808325, "[%1.init]", (Object)"PhoneAppHandler");
        this.videoFocus = false;
        this.createServiceTracker = this.context.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$terminalmode$ITerminalModeService == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeService = PhoneAppHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeService")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeService, new PhoneAppHandler$1(this));
        this.updateListenerServiceTracker = this.context.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = PhoneAppHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener, new PhoneAppHandler$2(this));
        this.createServiceTracker.open();
        this.updateListenerServiceTracker.open();
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"PhoneAppHandler");
        this.createServiceTracker.close();
        this.updateListenerServiceTracker.close();
    }

    public void updateVideoFocus(boolean bl) {
        this.logger.log(1078071040, "[%1.updateVideoFocus] videoFocus=%2", (Object)"PhoneAppHandler", (Object)String.valueOf(bl));
        this.videoFocus = bl;
        this.notifyTerminalModeServices(bl);
    }

    private void notifyTerminalModeServices(boolean bl) {
        this.logger.log(1078071040, "[%1.notifyTerminalModeServices]", (Object)"PhoneAppHandler");
        GIterator gIterator = this.terminalModeUpdateListenerList.iterator();
        while (gIterator.hasNext()) {
            ((ITerminalModeUpdateListener)gIterator.next()).updateTMVideoFocus(bl);
        }
        gIterator = this.terminalModeServiceList.iterator();
        while (gIterator.hasNext()) {
            ((ITerminalModeService)gIterator.next()).updateTMVideoFocus(bl);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(PhoneAppHandler phoneAppHandler) {
        return phoneAppHandler.logger;
    }

    static /* synthetic */ GCopyOnWriteList access$100(PhoneAppHandler phoneAppHandler) {
        return phoneAppHandler.terminalModeServiceList;
    }

    static /* synthetic */ IContext access$200(PhoneAppHandler phoneAppHandler) {
        return phoneAppHandler.context;
    }

    static /* synthetic */ boolean access$300(PhoneAppHandler phoneAppHandler) {
        return phoneAppHandler.videoFocus;
    }

    static /* synthetic */ GCopyOnWriteList access$400(PhoneAppHandler phoneAppHandler) {
        return phoneAppHandler.terminalModeUpdateListenerList;
    }
}

