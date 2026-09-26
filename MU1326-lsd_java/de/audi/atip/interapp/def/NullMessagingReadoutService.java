/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullMessagingReadoutService
extends NullService
implements IMessagingReadoutService {
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingReadoutService;

    public NullMessagingReadoutService(LogChannel logChannel) {
        super(logChannel, class$de$audi$atip$interapp$IMessagingReadoutService == null ? (class$de$audi$atip$interapp$IMessagingReadoutService = NullMessagingReadoutService.class$("de.audi.atip.interapp.IMessagingReadoutService")) : class$de$audi$atip$interapp$IMessagingReadoutService);
    }

    @Override
    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public void requestBeginDialog(boolean bl, int n, int n2) {
        super.log();
    }

    @Override
    public void requestEndDialog() {
        super.log();
    }

    @Override
    public void requestReadoutMessage() {
        super.log();
    }

    @Override
    public String requestReadoutText() {
        return null;
    }

    @Override
    public void requestBeginLastSelectedEntry() {
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

