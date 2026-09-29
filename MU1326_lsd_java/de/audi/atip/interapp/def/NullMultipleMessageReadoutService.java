/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutService;
import de.audi.atip.log.LogChannel;

public class NullMultipleMessageReadoutService
extends NullService
implements IMultipleMessageReadoutService {
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService;

    public NullMultipleMessageReadoutService(LogChannel logChannel) {
        super(logChannel, class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService == null ? (class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService = NullMultipleMessageReadoutService.class$("de.audi.atip.interapp.messaging.IMultipleMessageReadoutService")) : class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService);
    }

    public void requestReadoutMessage() {
        super.log();
    }

    @Override
    public void requestBeginDialog(boolean bl, int n) {
        super.log();
    }

    @Override
    public void requestEndDialog() {
        super.log();
    }

    @Override
    public boolean isMessageAvailable() {
        super.log();
        return false;
    }

    @Override
    public void requestNextMessage() {
        super.log();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

