/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.IMessagingLicenseService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullMessagingLicenseService
extends NullService
implements IMessagingLicenseService {
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingLicenseService;

    public NullMessagingLicenseService(LogChannel logChannel) {
        super(logChannel, class$de$audi$atip$interapp$IMessagingLicenseService == null ? (class$de$audi$atip$interapp$IMessagingLicenseService = NullMessagingLicenseService.class$("de.audi.atip.interapp.IMessagingLicenseService")) : class$de$audi$atip$interapp$IMessagingLicenseService);
    }

    @Override
    public void requestOnlineDictationLicenseInfo() {
        super.log();
    }

    @Override
    public void setExpirationWarning(boolean bl) {
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

