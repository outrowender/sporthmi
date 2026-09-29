/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;

final class PhoneServices$1
implements Runnable {
    private final /* synthetic */ ITelService val$telService;
    private final /* synthetic */ String val$phoneNumber;
    private final /* synthetic */ LogChannel val$log;

    PhoneServices$1(ITelService iTelService, String string, LogChannel logChannel) {
        this.val$telService = iTelService;
        this.val$phoneNumber = string;
        this.val$log = logChannel;
    }

    @Override
    public void run() {
        try {
            this.val$telService.dialNumber(this.val$phoneNumber, null, true);
        }
        catch (Exception exception) {
            Logs.logException(this.val$log, exception, "[PhoneServices#callMatchedNumber]");
        }
    }
}

