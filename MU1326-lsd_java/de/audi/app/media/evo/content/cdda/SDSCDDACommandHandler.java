/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.cdda;

import de.audi.app.media.evo.content.cdda.CDDAPlayer;
import de.audi.app.media.sds.ISDSCommandListener;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public class SDSCDDACommandHandler
implements ISDSCommandListener {
    private static final String LOGCLASS;
    private final LogChannel logChannel;
    private final CDDAPlayer cddaPlayer;

    public SDSCDDACommandHandler(LogChannel logChannel, CDDAPlayer cDDAPlayer) {
        this.logChannel = logChannel;
        this.cddaPlayer = cDDAPlayer;
    }

    @Override
    public int[] getCommandIDs() {
        return new int[]{20002};
    }

    @Override
    public Object performCommand(int n, Map map) {
        if (n != 20002) {
            this.logChannel.log(-1601830656, "[%1.performCommand] unsupported command %2", (Object)"SDSCDDACommandHandler", (long)n);
            return new Integer(11004);
        }
        Integer n2 = (Integer)map.get("TRACK_NUMBER");
        if (n2 == null) {
            this.logChannel.log(-1601830656, "[%1.performCommand] no track number found", (Object)"SDSCDDACommandHandler");
            return new Integer(11003);
        }
        if (this.cddaPlayer.playTrackNumber(n2)) {
            this.logChannel.log(1078071040, "[%1.performCommand]  track number successful set", (Object)"SDSCDDACommandHandler");
            return new Integer(11001);
        }
        this.logChannel.log(-1601830656, "[%1.performCommand] no track number found", (Object)"SDSCDDACommandHandler");
        return new Integer(11003);
    }
}

