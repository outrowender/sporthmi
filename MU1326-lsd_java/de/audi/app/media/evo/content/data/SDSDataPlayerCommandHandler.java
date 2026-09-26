/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.evo.content.data.DataPlayer;
import de.audi.app.media.sds.ISDSCommandListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public class SDSDataPlayerCommandHandler
implements ISDSCommandListener {
    private static final String LOGCLASS;
    private final LogChannel logChannel;
    private final DataPlayer dataPlayer;
    private final IMediaTerminal terminal;

    public SDSDataPlayerCommandHandler(IMediaTerminal iMediaTerminal, DataPlayer dataPlayer) {
        this.logChannel = iMediaTerminal.getLogger().sds();
        this.dataPlayer = dataPlayer;
        this.terminal = iMediaTerminal;
    }

    @Override
    public int[] getCommandIDs() {
        return new int[]{20005};
    }

    @Override
    public Object performCommand(int n, Map map) {
        if (20005 != n) {
            this.logChannel.log(-1601830656, "[%1.performCommand] unknown command %2.", (Object)"SDSDataPlayerCommandHandler", (long)n);
            return new Integer(11004);
        }
        ISourceSlot iSourceSlot = this.terminal.getSourceController().getSelectedSlot();
        if (iSourceSlot == null) {
            this.logChannel.log(1078071040, "[%1.performCommand] no active slot.", (Object)"SDSDataPlayerCommandHandler");
            return new Integer(11003);
        }
        if (!this.dataPlayer.supportsPlaySimilar()) {
            this.logChannel.log(1078071040, "[%1.performCommand] current slot does not support playSimilarEntries.", (Object)"SDSDataPlayerCommandHandler");
            return new Integer(11004);
        }
        if (!(this.dataPlayer.isActive() && iSourceSlot.getFlags().isExtMetaDataSyncComplete() && iSourceSlot.getFlags().isSyncComplete())) {
            this.logChannel.log(1078071040, "[%1.performCommand] player or data not ready", (Object)"SDSDataPlayerCommandHandler");
            return new Integer(11005);
        }
        this.logChannel.log(1078071040, "[%1.performCommand] PlayMoreLikeThis is called", (Object)"SDSDataPlayerCommandHandler");
        int n2 = this.dataPlayer.playMoreLikeThis();
        return new Integer(n2 == 1 ? 11001 : 11003);
    }
}

