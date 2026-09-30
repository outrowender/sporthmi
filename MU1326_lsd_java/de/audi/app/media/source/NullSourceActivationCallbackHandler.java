/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISourceActivationCallbackHandler;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;

public final class NullSourceActivationCallbackHandler
implements ISourceActivationCallbackHandler {
    private static final String LOGCLASS = "NullSourceActivationCallbackHandler";
    private final LogChannel logger;

    public NullSourceActivationCallbackHandler(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void sourceDeviceActivated(ISourceSlot iSourceSlot, int n, boolean bl) {
        this.logger.log(1000000, "[%1.sourceDeviceActivated] '%2'", (Object)LOGCLASS, (Object)iSourceSlot);
    }

    public void sourceDeviceDeactivated() {
        this.logger.log(1000000, "[%1.sourceDeviceDeactivated]", (Object)LOGCLASS);
    }

    public void sourceDevicePending(long l) {
        this.logger.log(1000000, "[%1.sourceDevicePending] '%2'", (Object)LOGCLASS, l);
    }

    public void sourceActivationFailed() {
        this.logger.log(1000000, "[%1.sourceActivationFailed]", (Object)LOGCLASS);
    }
}

