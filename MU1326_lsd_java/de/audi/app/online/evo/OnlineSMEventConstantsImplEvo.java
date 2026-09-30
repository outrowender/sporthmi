/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.IOnlineTextConstants;

public class OnlineSMEventConstantsImplEvo
implements IOnlineTextConstants {
    private LogChannel logChannel;

    public OnlineSMEventConstantsImplEvo(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public int mapToVariant(int n) {
        this.logChannel.log(100000, "OnlineSMEventConstantsImplEvo#mapToVariant: not implemented! Returns always -1");
        return -1;
    }
}

