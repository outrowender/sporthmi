/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISourceActivationCallbackHandler;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;

public final class NullSourceActivationCallbackHandler
implements ISourceActivationCallbackHandler {
    private static final String LOGCLASS;
    private final LogChannel logger;

    public NullSourceActivationCallbackHandler(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void sourceDeviceActivated(ISourceSlot iSourceSlot, int n, boolean bl) {
        this.logger.log(1078071040, "[%1.sourceDeviceActivated] '%2'", (Object)"NullSourceActivationCallbackHandler", (Object)iSourceSlot);
    }

    @Override
    public void sourceDeviceDeactivated() {
        this.logger.log(1078071040, "[%1.sourceDeviceDeactivated]", (Object)"NullSourceActivationCallbackHandler");
    }

    @Override
    public void sourceDevicePending(long l) {
        this.logger.log(1078071040, "[%1.sourceDevicePending] '%2'", (Object)"NullSourceActivationCallbackHandler", l);
    }

    @Override
    public void sourceActivationFailed() {
        this.logger.log(1078071040, "[%1.sourceActivationFailed]", (Object)"NullSourceActivationCallbackHandler");
    }
}

