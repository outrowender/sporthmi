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

    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    public void requestBeginDialog(boolean bl, int n, int n2) {
        super.log();
    }

    public void requestEndDialog() {
        super.log();
    }

    public void requestReadoutMessage() {
        super.log();
    }

    public String requestReadoutText() {
        return null;
    }

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

