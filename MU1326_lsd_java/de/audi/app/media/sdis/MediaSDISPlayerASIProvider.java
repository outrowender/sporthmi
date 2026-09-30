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
    private static final String LOGCLASS = "MediaSDISPlayerASIProvider";
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
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.contentHandler = mediaSDISContentHandler;
        this.sourceHandler = mediaSDISSourceHandler;
        this.asiServiceRegistration = this.terminal.getServiceManager().registerService(class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = MediaSDISPlayerASIProvider.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.terminal.getServiceManager().unregisterService(this.asiServiceRegistration);
    }

    public IService getService() {
        return this.mediaService;
    }

    public void attachStub(IStub iStub) {
        this.logger.log(1000000, "[%1.attachStub] '%2'", (Object)LOGCLASS, (Object)iStub);
    }

    public void detachStub(IStub iStub) {
        this.logger.log(1000000, "[%1.detachStub] '%2'", (Object)LOGCLASS, (Object)iStub);
    }

    public void activate(MediaSourceSlot mediaSourceSlot, MediaBrowserSelectionData mediaBrowserSelectionData, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.setActiveSource] '%2,'%3''", (Object)LOGCLASS, (long)mediaSourceSlot.getSource(), (long)mediaSourceSlot.getSlotIdx());
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.sourceHandler.activate(MediaUtilsSDIS.getSourceTypeOfSDISSource(mediaSourceSlot.getSource()), mediaSourceSlot.getSlotIdx(), mediaBrowserSelectionData != null ? new SelectionData(mediaBrowserSelectionData) : null);
    }

    public void pause(ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.pause]", (Object)LOGCLASS);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.pause();
    }

    public void resume(ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.resume]", (Object)LOGCLASS);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.resume();
    }

    public void skip(byte by, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.skip] '%2'", (Object)LOGCLASS, (long)by);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.skip(by);
    }

    public void seek(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.seek] '%2'", (Object)LOGCLASS, (Object)(bl ? "FORWARD" : "BACKWARD"));
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.startSeek(bl);
    }

    public void mix(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.mix] '%2'", (Object)LOGCLASS, (Object)(bl ? "ON" : "OFF"));
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.mix(bl);
    }

    public void repeatTitle(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.repeatTitle] '%2'", (Object)LOGCLASS, (Object)(bl ? "ON" : "OFF"));
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.repeatTitle(bl);
    }

    public void setEntry(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.playEntry] '%2'", (Object)LOGCLASS, l);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.playEntry(l);
    }

    public void setTimePosition(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.setTimePosition] '%2'", (Object)LOGCLASS, (long)n);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.setTimePosition(n);
    }

    public void touchEvent(int n, int n2, int n3, int n4, int n5, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        if (n4 <= 0 || n5 <= 0 || n2 < 0 || n3 < 0) {
            this.logger.log(1000000, "[%1.touchEvent] Invalid coordinates.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.touchEvent] ", (Object)LOGCLASS);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.touchEvent(n == 1, n2, n3, n4, n5);
    }

    public void executeDvdVideoCommand(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.executeDvdVideoCommand] ", (Object)LOGCLASS);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.executeMenuCommand(n);
    }

    public void requestPlayList(int n, long l, int n2, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, new StringBuffer().append("[%1.requestPlayList] pIndex='").append(n).append("', pEntryID='").append(l).append("', pCount='").append(n2).append("'.").toString(), (Object)LOGCLASS);
        if (l == 0L) {
            this.logger.log(1000000, "[%1.requestPlayList] Index based request is intended. Set pEntryID to '-1'. ", (Object)LOGCLASS);
            l = -1L;
        }
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.requestPlayList(new SDISPlayviewListRequest(this.logger, n, l, n2, aSIHMISyncMediaReply));
    }

    public void setPlaySelection(MediaBrowserSelectionData mediaBrowserSelectionData, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.setPlaySelection] browserID='%2', trackID='%3'", (Object)LOGCLASS, (long)mediaBrowserSelectionData.getBrowserInstance(), mediaBrowserSelectionData.getTrackID());
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.setPlaySelection(new MediaSDISPlayerSelectionRequest(this.logger, mediaBrowserSelectionData.getBrowserInstance(), mediaBrowserSelectionData.getTrackID(), mediaBrowserSelectionData.isSeamless(), aSIHMISyncMediaReply));
    }

    public void playMoreFrom(long l, int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.playMoreFrom], entryID='%3'", (Object)LOGCLASS, l);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.playMoreOf(l, n, new MediaSDISPlayMoreOfRequest(this.logger, l, n, aSIHMISyncMediaReply));
    }

    public void stopSeek(ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(1000000, "[%1.stopSeek]", (Object)LOGCLASS);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.stopSeek();
    }

    public void toggleRepeatState(ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(10000000, "[%1.toggleRepeatState]", (Object)LOGCLASS);
        this.contentHandler.setReplyService(aSIHMISyncMediaReply);
        this.contentHandler.toggleRepeatMode();
    }

    public void toggleShuffleState(ASIHMISyncMediaReply aSIHMISyncMediaReply) throws MethodException {
        this.logger.log(10000000, "[%1.toggleShuffleState]", (Object)LOGCLASS);
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

