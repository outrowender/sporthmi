/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.audio.TunerServiceHandler$1;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.def.NullTunerService;

public class TunerServiceHandler
extends AbstractMediaTerminalComponent {
    private static final String LOGCLASS;
    private final IServiceTracker serviceTracker;
    private volatile TunerService tunerService;
    static /* synthetic */ Class class$de$audi$atip$interapp$TunerService;

    public TunerServiceHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.tunerService = new NullTunerService(this.logger.audio());
        this.serviceTracker = iMediaTerminal.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$TunerService == null ? (class$de$audi$atip$interapp$TunerService = TunerServiceHandler.class$("de.audi.atip.interapp.TunerService")) : class$de$audi$atip$interapp$TunerService, new TunerServiceHandler$1(this));
    }

    protected void init() {
        this.logger.audio().log(1078071040, "[%1.init]", (Object)"TunerServiceHandler");
        this.serviceTracker.open();
    }

    protected void deinit() {
        this.logger.audio().log(1078071040, "[%1.deinit]", (Object)"TunerServiceHandler");
        this.serviceTracker.close();
    }

    protected void abortActiveTA() {
        this.logger.audio().log(-2137614336, "[%1.abortActiveTA]", (Object)"TunerServiceHandler");
        this.tunerService.abortActiveTA();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ TunerService access$002(TunerServiceHandler tunerServiceHandler, TunerService tunerService) {
        tunerServiceHandler.tunerService = tunerService;
        return tunerServiceHandler.tunerService;
    }

    static /* synthetic */ TunerService access$000(TunerServiceHandler tunerServiceHandler) {
        return tunerServiceHandler.tunerService;
    }

    static /* synthetic */ IMediaLogger access$100(TunerServiceHandler tunerServiceHandler) {
        return tunerServiceHandler.logger;
    }

    static /* synthetic */ IMediaLogger access$200(TunerServiceHandler tunerServiceHandler) {
        return tunerServiceHandler.logger;
    }

    static /* synthetic */ IMediaLogger access$300(TunerServiceHandler tunerServiceHandler) {
        return tunerServiceHandler.logger;
    }
}

