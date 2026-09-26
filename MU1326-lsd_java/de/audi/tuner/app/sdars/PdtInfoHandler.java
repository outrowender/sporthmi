/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.sdars.PdtInfoHandler$CoverArtRequestInfo;
import de.audi.tuner.app.sdars.PdtInfoHandler$DsiUpListener;
import de.audi.tuner.app.sdars.PdtInfoHandler$PdtListenerStorage;
import de.audi.tuner.app.sdars.PdtInfoHandler$SDARSCoverArtHandler;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.ifc.listener.IPdtListener;
import de.audi.tuner.itunes.ITaggingManager;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map$Entry;
import org.dsi.ifc.sdars.RadioText;

public class PdtInfoHandler
extends DefaultTimerListener {
    public final SDARSDsiUpInfo dsiUpListener = new PdtInfoHandler$DsiUpListener(this, null);
    public static final int INTERESTED_IN_COVERART_NO;
    public static final int INTERESTED_IN_COVERART_YES;
    public static final int INTERESTED_IN_COVERART_YES_FORCE;
    private final Object mutex = new Object();
    private final SimpleIntObjectMap pdtBuffer;
    private final Logger logger;
    private final TunerModels models;
    private final PdtInfoHandler$PdtListenerStorage listenerStorage;
    private final ITaggingManager taggingMngr;
    private boolean noSiganlActive;
    private final Timer pdtResetTimer;
    private final PdtInfoHandler$SDARSCoverArtHandler coverArt;
    private PdtInfoHandler$CoverArtRequestInfo lastCoverArtRequest = PdtInfoHandler$CoverArtRequestInfo.EMPTY_DUMMY;

    PdtInfoHandler(TunerBasics tunerBasics, ITaggingManager iTaggingManager) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.taggingMngr = iTaggingManager;
        this.pdtBuffer = new SimpleIntObjectMap(390);
        this.listenerStorage = new PdtInfoHandler$PdtListenerStorage(null);
        this.pdtResetTimer = new Timer("PDTResetTimer", 5, this.logger.timer, this, 0, true);
        this.coverArt = new PdtInfoHandler$SDARSCoverArtHandler(this, tunerBasics);
    }

    public void register(IGracenoteRequest iGracenoteRequest) {
        this.coverArt.register(iGracenoteRequest);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListener(int n, IPdtListener iPdtListener, int n2) {
        SdarsRadioText sdarsRadioText;
        Object object = this.mutex;
        synchronized (object) {
            this.listenerStorage.addListener(n, iPdtListener, n2 != 0);
            RadioText radioText = (RadioText)this.pdtBuffer.get(n);
            if (n2 == 1) {
                this.orderGracenoteCoverArtForIfNotAlreadyOrdered(radioText);
            } else if (n2 == 2) {
                this.orderGracenoteCoverArt(radioText);
            }
            sdarsRadioText = this.constructSdarsRadioText(radioText);
        }
        iPdtListener.updatePdt(n, sdarsRadioText);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(int n, IPdtListener iPdtListener) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.listenerStorage.removeListener(n, iPdtListener)) {
                this.coverArt.clear();
                this.lastCoverArtRequest = PdtInfoHandler$CoverArtRequestInfo.EMPTY_DUMMY;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setNoSignal(boolean bl) {
        boolean bl2 = false;
        Object object = this.mutex;
        synchronized (object) {
            if (this.noSiganlActive != bl) {
                this.noSiganlActive = bl;
                if (this.noSiganlActive) {
                    this.pdtResetTimer.restart();
                } else {
                    this.pdtResetTimer.cancel();
                }
                bl2 = true;
            }
        }
        if (bl2) {
            this.informAllListeners();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void clearPDTBuffer() {
        this.logger.sdarsRadioText.log(1078071040, "[pdtInfoHandler.clearPDTBuffer]");
        Object object = this.mutex;
        synchronized (object) {
            this.pdtBuffer.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public RadioText get(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return (RadioText)this.pdtBuffer.get(n);
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(this.pdtResetTimer)) {
            this.clearPDTBuffer();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String dumpListenerData() {
        Object object = this.mutex;
        synchronized (object) {
            return this.listenerStorage.dumpListenerData();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSIInformationRadioText2(RadioText radioText) {
        short s = radioText.sID;
        radioText = this.checkIfEmpty(radioText);
        Object object = this.mutex;
        synchronized (object) {
            this.pdtBuffer.add(s, radioText);
            if (this.listenerStorage.hasListenersForSidInterestedInGracenoteCoverArt(s)) {
                this.orderGracenoteCoverArtForIfNotAlreadyOrdered(radioText);
            }
        }
        this.informListeners(s, radioText);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onGracenoteCoverArtArrived() {
        RadioText radioText;
        int n;
        Object object = this.mutex;
        synchronized (object) {
            n = PdtInfoHandler$CoverArtRequestInfo.access$200(this.lastCoverArtRequest);
            radioText = (RadioText)this.pdtBuffer.get(n);
        }
        this.informListeners(n, radioText);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void informAllListeners() {
        Object object;
        Object object2;
        Object object3;
        HashMap hashMap = new HashMap();
        Object object4 = this.mutex;
        synchronized (object4) {
            object3 = this.listenerStorage.getAllSIdsWithRegisteredListeners();
            object2 = object3.iterator();
            while (object2.hasNext()) {
                object = (Integer)object2.next();
                RadioText radioText = (RadioText)this.pdtBuffer.get((Integer)object);
                hashMap.put(object, radioText);
            }
        }
        object4 = hashMap.entrySet().iterator();
        while (object4.hasNext()) {
            object3 = (Map$Entry)object4.next();
            object2 = (Integer)object3.getKey();
            object = (RadioText)object3.getValue();
            this.informListeners((Integer)object2, (RadioText)object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void informListeners(int n, RadioText radioText) {
        Collection collection;
        SdarsRadioText sdarsRadioText = null;
        Object object = this.mutex;
        synchronized (object) {
            if (!this.listenerStorage.hasListenersForSid(n)) {
                return;
            }
            collection = this.listenerStorage.getListenersForSId(n);
            sdarsRadioText = this.constructSdarsRadioText(radioText);
        }
        object = collection.iterator();
        while (object.hasNext()) {
            ((IPdtListener)object.next()).updatePdt(n, sdarsRadioText);
        }
    }

    private SdarsRadioText constructSdarsRadioText(RadioText radioText) {
        if (this.noSiganlActive || radioText == null) {
            return null;
        }
        SdarsRadioText sdarsRadioText = new SdarsRadioText(radioText);
        if (PdtInfoHandler$CoverArtRequestInfo.access$200(this.lastCoverArtRequest) == radioText.sID) {
            sdarsRadioText.setCoverArt(this.coverArt.getCoverArt());
        }
        int n = this.taggingMngr.isTaggingSpaceFree() ? (sdarsRadioText.iTunesID != 0 ? (this.taggingMngr.isAlreadyStored(sdarsRadioText.iTunesID) ? 3 : 2) : 1) : 4;
        sdarsRadioText.setTaggingStatus(n);
        return sdarsRadioText;
    }

    private void orderGracenoteCoverArtForIfNotAlreadyOrdered(RadioText radioText) {
        if (this.models.getActiveTuner() == 7 && this.lastCoverArtRequest.differesFrom(radioText)) {
            this.orderGracenoteCoverArt(radioText);
        }
    }

    private void orderGracenoteCoverArt(RadioText radioText) {
        if (this.models.getActiveTuner() == 7) {
            this.coverArt.clear();
            this.lastCoverArtRequest = PdtInfoHandler$CoverArtRequestInfo.EMPTY_DUMMY;
            if (radioText != null) {
                this.lastCoverArtRequest = PdtInfoHandler$CoverArtRequestInfo.fromRadioText(radioText);
                this.coverArt.requestCoverArt(PdtInfoHandler$CoverArtRequestInfo.access$300(this.lastCoverArtRequest), "", PdtInfoHandler$CoverArtRequestInfo.access$400(this.lastCoverArtRequest));
            }
        }
    }

    private RadioText checkIfEmpty(RadioText radioText) {
        if (radioText != null) {
            if (radioText.getArtistID() == null) {
                radioText.artistID = "";
            }
            if (radioText.getComposer() == null) {
                radioText.composer = "";
            }
            if (radioText.getLongArtistName() == null) {
                radioText.longArtistName = "";
            }
            if (radioText.getLongProgramTitle() == null) {
                radioText.longProgramTitle = "";
            }
            if (radioText.getProgramID() == null) {
                radioText.programID = "";
            }
            if (radioText.getShortArtistName() == null) {
                radioText.shortArtistName = "";
            }
            if (radioText.getShortProgramTitle() == null) {
                radioText.shortProgramTitle = "";
            }
            if (radioText.getLongArtistName().length() == 0 && radioText.getComposer().length() == 0 && radioText.getLongProgramTitle().length() == 0) {
                this.logger.sdarsRadioText.log(-2137614336, "Received empty pdt for channel %1", (long)radioText.sID);
                radioText = null;
            }
        }
        return radioText;
    }

    static /* synthetic */ void access$500(PdtInfoHandler pdtInfoHandler, RadioText radioText) {
        pdtInfoHandler.onDSIInformationRadioText2(radioText);
    }

    static /* synthetic */ void access$600(PdtInfoHandler pdtInfoHandler, boolean bl) {
        pdtInfoHandler.setNoSignal(bl);
    }

    static /* synthetic */ void access$700(PdtInfoHandler pdtInfoHandler) {
        pdtInfoHandler.onGracenoteCoverArtArrived();
    }
}

