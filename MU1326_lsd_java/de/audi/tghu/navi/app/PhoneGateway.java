/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.PhoneService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;

public final class PhoneGateway {
    private PhoneService phone = null;
    private final LogChannel logChannel;
    private NavigationEnv env;

    public PhoneGateway(NavigationEnv navigationEnv) {
        this.logChannel = navigationEnv.getLogChannel();
        this.env = navigationEnv;
    }

    public void setPhoneService(PhoneService phoneService) {
        this.logChannel.log(10000000, "PhoneGateway#setPhoneService(): phone: %1 ", (Object)phoneService);
        this.phone = phoneService;
    }

    public boolean phoneReady() {
        return this.env.getChoiceModel(186).getValue() == 1;
    }

    public void dialNumber(String string, String string2, boolean bl) {
        if (this.phone == null) {
            this.logChannel.log(10000, "PhoneGateway#dialNumber(): phone service not available! ");
            return;
        }
        this.phone.dialNumber(string, string2, true);
    }
}

