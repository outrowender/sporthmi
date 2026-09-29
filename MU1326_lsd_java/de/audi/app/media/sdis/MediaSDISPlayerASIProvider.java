/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.sdis.MediaSDISContentHandler;
import de.audi.app.media.sdis.MediaSDISPlayMoreOfRequest;
import de.audi.app.media.sdis.MediaSDISPlayerSelectionRequest;
import de.audi.app.media.sdis.MediaSDISSourceHandler;
import de.audi.app.media.sdis.MediaUtilsSDIS;
import de.audi.app.media.sdis.SDISPlayviewListRequest;
import de.audi.app.media.sdis.SelectionData;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class MediaSDISPlayerASIProvider
extends ASIHMISyncMediaAbstractBaseService
implements IASIProvider {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IMediaTerminal terminal;
    private volatile ServiceRegistration asiServiceRegistration;
    private final ASIHMISyncMediaService mediaService;
    volatile MediaSDISContentHandler contentHandler;
    volatile MediaSDISSourceHandler sourceHandler;
    static /* synthetic */ Class class$de$audi$atip$agent$IASIProvider;

    public MediaSDISPlayerASIProvider(LogChannel logChannel, IMediaTerminal iMediaTerminal) {
        this.logger = logChannel;
        this.terminal = iMediaTerminal;
        this.mediaService = new ASIHMISyncMediaService(0, this);
        try {
            this.updateASIVersion("4.8.2");
            this.updateRequestIDs(new short[]{1, 2, 3, 14, 15, 16, 0, 4, 5, 6, 33, 7, 8, 11, 12, 13, 17, 18, 19, 36, 20});
            this.updateReplyIDs(new short[]{9, 34, 10, 22, 21, 23, 24, 27, 38, 28, 25, 37, 29, 31, 32, 30, 35});
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "MediaSDISPlayerASIProvider - could not register ASI version!");
            methodException.printStackTrace();
        }
    }

    public void init(MediaSDISSourceHandler mediaSDISSourceHandler, MediaSDISContentHandler mediaSDISContentHandler) {
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaSDISPlayerASIProvider");
        this.contentHandler = mediaSDISContentHandler;
        this.sourceHandler = mediaSDISSourceHandler;
        this.asiServiceRegistration = this.terminal.getServiceManager().registerService(class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = MediaSDISPlayerASIProvider.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaSDISPlayerASIProvider");
        this.terminal.getServiceManager().unregisterService(this.asiServiceRegistration);
    }

    @Override
    public IService getService() {
        return this.mediaService;
    }

    @Override
    public void attachStub(IStub iStub) {
        this.logger.log(1078071040, "[%1.attachStub] '%2'", (Object)"MediaSDISPlayerASIProvider", (Object)iStub);
    }

    @Override
    public void detachStub(IStub iStub) {
        this.logger.log(1078071040, "[%1.detachStub] '%2'", (Object)"MediaSDISPlayerASIProvider", (Object)iStub);
    }

    @Override
    public void activate(MediaSourceSlot mediaSourceSlot, MediaBrowserSelectionData mediaBrowserSelectionData, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.setActiveSource] '%2,'%3''", (Object)"MediaSDISPlayerASIProvider", (long)mediaSourceSlot.getSource(), (long)mediaSourceSlot.getSlotIdx());
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.sourceHandler.activate(MediaUtilsSDIS.getSourceTypeOfSDISSource(mediaSourceSlot.getSource()), mediaSourceSlot.getSlotIdx(), mediaBrowserSelectionData != null ? new SelectionData(mediaBrowserSelectionData) : null);
    }

    @Override
    public void pause(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.pause]", (Object)"MediaSDISPlayerASIProvider");
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.pause();
    }

    @Override
    public void resume(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.resume]", (Object)"MediaSDISPlayerASIProvider");
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.resume();
    }

    @Override
    public void skip(byte by, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.skip] '%2'", (Object)"MediaSDISPlayerASIProvider", (long)by);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.skip(by);
    }

    @Override
    public void seek(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.seek] '%2'", (Object)"MediaSDISPlayerASIProvider", (Object)(bl ? "FORWARD" : "BACKWARD"));
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.startSeek(bl);
    }

    @Override
    public void mix(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.mix] '%2'", (Object)"MediaSDISPlayerASIProvider", (Object)(bl ? "ON" : "OFF"));
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.mix(bl);
    }

    @Override
    public void repeatTitle(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.repeatTitle] '%2'", (Object)"MediaSDISPlayerASIProvider", (Object)(bl ? "ON" : "OFF"));
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.repeatTitle(bl);
    }

    @Override
    public void setEntry(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.playEntry] '%2'", (Object)"MediaSDISPlayerASIProvider", l);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.playEntry(l);
    }

    @Override
    public void setTimePosition(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.setTimePosition] '%2'", (Object)"MediaSDISPlayerASIProvider", (long)n);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.setTimePosition(n);
    }

    @Override
    public void touchEvent(int n, int n2, int n3, int n4, int n5, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        if (n4 <= 0 || n5 <= 0 || n2 < 0 || n3 < 0) {
            this.logger.log(1078071040, "[%1.touchEvent] Invalid coordinates.", (Object)"MediaSDISPlayerASIProvider");
            return;
        }
        this.logger.log(1078071040, "[%1.touchEvent] ", (Object)"MediaSDISPlayerASIProvider");
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.touchEvent(n == 1, n2, n3, n4, n5);
    }

    @Override
    public void executeDvdVideoCommand(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.executeDvdVideoCommand] ", (Object)"MediaSDISPlayerASIProvider");
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.executeMenuCommand(n);
    }

    @Override
    public void requestPlayList(int n, long l, int n2, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, new StringBuffer().append("[%1.requestPlayList] pIndex='").append(n).append("', pEntryID='").append(l).append("', pCount='").append(n2).append("'.").toString(), (Object)"MediaSDISPlayerASIProvider");
        if (l == 0L) {
            this.logger.log(1078071040, "[%1.requestPlayList] Index based request is intended. Set pEntryID to '-1'. ", (Object)"MediaSDISPlayerASIProvider");
            l = -1L;
        }
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.requestPlayList(new SDISPlayviewListRequest(this.logger, n, l, n2, aSIHMISyncMediaReply));
    }

    @Override
    public void setPlaySelection(MediaBrowserSelectionData mediaBrowserSelectionData, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.setPlaySelection] browserID='%2', trackID='%3'", (Object)"MediaSDISPlayerASIProvider", (long)mediaBrowserSelectionData.getBrowserInstance(), mediaBrowserSelectionData.getTrackID());
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.setPlaySelection(new MediaSDISPlayerSelectionRequest(this.logger, mediaBrowserSelectionData.getBrowserInstance(), mediaBrowserSelectionData.getTrackID(), mediaBrowserSelectionData.isSeamless(), aSIHMISyncMediaReply));
    }

    @Override
    public void playMoreFrom(long l, int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.playMoreFrom], entryID='%3'", (Object)"MediaSDISPlayerASIProvider", l);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.playMoreOf(l, n, new MediaSDISPlayMoreOfRequest(this.logger, l, n, aSIHMISyncMediaReply));
    }

    @Override
    public void stopSeek(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(1078071040, "[%1.stopSeek]", (Object)"MediaSDISPlayerASIProvider");
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.stopSeek();
    }

    @Override
    public void toggleRepeatState(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(-2137614336, "[%1.toggleRepeatState]", (Object)"MediaSDISPlayerASIProvider");
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.toggleRepeatMode();
    }

    @Override
    public void toggleShuffleState(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(-2137614336, "[%1.toggleShuffleState]", (Object)"MediaSDISPlayerASIProvider");
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.toggleMixMode();
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

