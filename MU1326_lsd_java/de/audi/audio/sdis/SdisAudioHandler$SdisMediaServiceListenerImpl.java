/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.interapp.media.IMediaServiceListener;
import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.audio.sdis.SdisAudioHandler;
import de.audi.audio.sdis.SdisAudioHandler$1;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import java.util.Map;

class SdisAudioHandler$SdisMediaServiceListenerImpl
implements IMediaServiceListener {
    private final /* synthetic */ SdisAudioHandler this$0;

    private SdisAudioHandler$SdisMediaServiceListenerImpl(SdisAudioHandler sdisAudioHandler) {
        this.this$0 = sdisAudioHandler;
    }

    @Override
    public int getTerminalID() {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.getTerminalID]");
        return 0;
    }

    @Override
    public void sourceAvailable(int n, boolean bl) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.sourceAvailable] sourceID: %1", (long)n);
    }

    @Override
    public void sourceListChanged(Map map) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.sourceListChanged] do nothing");
    }

    @Override
    public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
        if (mediaSlotInfo.getSourceType() == 4 || mediaSlotInfo.getSourceType() == 7) {
            if (mediaSlotInfo.getType() == 1) {
                SdisAudioHandler.access$802(this.this$0, 2);
            } else {
                SdisAudioHandler.access$802(this.this$0, 1);
            }
        } else {
            SdisAudioHandler.access$802(this.this$0, 0);
        }
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] slotInfo: %1 restart: %2", (Object)mediaSlotInfo, (Object)String.valueOf(bl));
        if (SdisAudioHandler.access$300(this.this$0).getAudioContext() != 3 && SdisAudioHandler.access$300(this.this$0).getAudioContext() != 4) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] audioContext: %1 is not media or TV", (long)SdisAudioHandler.access$300(this.this$0).getAudioContext());
            return;
        }
        int n = mediaSlotInfo.getSourceType() == 7 || mediaSlotInfo.getSourceType() == 8 ? 4 : 3;
        if (SdisAudioHandler.access$300(this.this$0).getAudioContext() != n) {
            SdisAudioHandler.access$300(this.this$0).setAudioContext(n, null);
        }
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] current audioContext: %1, mediaSource %2, new audioContext %3", (long)SdisAudioHandler.access$300(this.this$0).getAudioContext(), (long)SdisAudioHandler.access$800(this.this$0), (long)n);
        CommandList commandList = new CommandList(SdisAudioHandler.access$400(this.this$0));
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStopStreaming(true));
        if (bl) {
            commandList.add(SdisAudioHandler.access$500(this.this$0).cmdRequestConf(n, SdisAudioHandler.access$800(this.this$0)));
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] added conf");
            commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStartStreaming());
            commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendReady(n));
        }
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendLockState(SdisAudioHandler.access$900(this.this$0)));
        CommandList commandList2 = SdisAudioHandler.access$400(this.this$0).getActiveCommandList();
        if (commandList2 != null && commandList2.hasActiveCommand()) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] add to active cl");
            commandList2.add(commandList);
        } else {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] execute cl");
            commandList.execute("SdisMediaServiceListenerImpl.updateActiveSource");
        }
    }

    @Override
    public void updatePlaybackState(int n) {
        if (SdisAudioHandler.access$300(this.this$0).getAudioContext() != 3 || n != 1) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updatePlaybackState] playbackState: %1, audiocontext:%2 do nothing ", (long)n, (long)SdisAudioHandler.access$300(this.this$0).getAudioContext());
            return;
        }
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updatePlaybackState] playbackState: %1", (long)n);
        CommandList commandList = new CommandList(SdisAudioHandler.access$400(this.this$0));
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStartStreaming());
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendReady(SdisAudioHandler.access$300(this.this$0).getAudioContext()));
        CommandList commandList2 = SdisAudioHandler.access$400(this.this$0).getActiveCommandList();
        if (commandList2 != null && commandList2.hasActiveCommand()) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updatePlaybackState] finish active cl");
            commandList2.add(commandList);
        } else {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updatePlaybackState] execute cl");
            commandList.execute("SdisMediaServiceListenerImpl.updatePlaybackState");
        }
    }

    @Override
    public void sourceDeactivated() {
        if (SdisAudioHandler.access$300(this.this$0).getAudioContext() != 3 && SdisAudioHandler.access$300(this.this$0).getAudioContext() != 4) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SdisMediaServiceListenerImpl.sourceDeactivated] audioContext: %1 is not media or TV", (long)SdisAudioHandler.access$300(this.this$0).getAudioContext());
            return;
        }
        CommandList commandList = new CommandList(SdisAudioHandler.access$400(this.this$0));
        Command command = SdisAudioHandler.access$500(this.this$0).cmdStopStreaming(true);
        commandList.add(command);
        command.execute();
    }

    /* synthetic */ SdisAudioHandler$SdisMediaServiceListenerImpl(SdisAudioHandler sdisAudioHandler, SdisAudioHandler$1 sdisAudioHandler$1) {
        this(sdisAudioHandler);
    }
}

