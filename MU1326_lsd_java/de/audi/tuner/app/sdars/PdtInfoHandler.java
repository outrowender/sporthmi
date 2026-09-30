/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.gracenote.CoverArtHandler;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.ifc.listener.IPdtListener;
import de.audi.tuner.itunes.ITaggingManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.RadioText;

public class PdtInfoHandler
extends DefaultTimerListener {
    public final SDARSDsiUpInfo dsiUpListener = new DsiUpListener();
    public static final int INTERESTED_IN_COVERART_NO = 0;
    public static final int INTERESTED_IN_COVERART_YES = 1;
    public static final int INTERESTED_IN_COVERART_YES_FORCE = 2;
    private final Object mutex = new Object();
    private final SimpleIntObjectMap pdtBuffer;
    private final Logger logger;
    private final TunerModels models;
    private final PdtListenerStorage listenerStorage;
    private final ITaggingManager taggingMngr;
    private boolean noSiganlActive;
    private final Timer pdtResetTimer;
    private final SDARSCoverArtHandler coverArt;
    private CoverArtRequestInfo lastCoverArtRequest = CoverArtRequestInfo.EMPTY_DUMMY;

    PdtInfoHandler(TunerBasics tunerBasics, ITaggingManager iTaggingManager) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.taggingMngr = iTaggingManager;
        this.pdtBuffer = new SimpleIntObjectMap(390);
        this.listenerStorage = new PdtListenerStorage();
        this.pdtResetTimer = new Timer("PDTResetTimer", 5, this.logger.timer, this, 60000L, true);
        this.coverArt = new SDARSCoverArtHandler(tunerBasics);
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
                this.lastCoverArtRequest = CoverArtRequestInfo.EMPTY_DUMMY;
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
        this.logger.sdarsRadioText.log(1000000, "[pdtInfoHandler.clearPDTBuffer]");
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
            n = this.lastCoverArtRequest.sId;
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
            object3 = (Map.Entry)object4.next();
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
        if (this.lastCoverArtRequest.sId == radioText.sID) {
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
            this.lastCoverArtRequest = CoverArtRequestInfo.EMPTY_DUMMY;
            if (radioText != null) {
                this.lastCoverArtRequest = CoverArtRequestInfo.fromRadioText(radioText);
                this.coverArt.requestCoverArt(this.lastCoverArtRequest.artistName, "", this.lastCoverArtRequest.title);
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
                this.logger.sdarsRadioText.log(10000000, "Received empty pdt for channel %1", (long)radioText.sID);
                radioText = null;
            }
        }
        return radioText;
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void informationRadioText2(RadioText[] radioTextArray) {
            for (int i2 = 0; i2 < radioTextArray.length; ++i2) {
                PdtInfoHandler.this.onDSIInformationRadioText2(radioTextArray[i2]);
            }
        }

        public void updateSignalStatus(boolean bl) {
            PdtInfoHandler.this.setNoSignal(bl);
        }
    }

    private static class PdtListenerStorage {
        private final Map sIdToClassifiedListenerList = new HashMap();

        private PdtListenerStorage() {
        }

        public void addListener(int n, IPdtListener iPdtListener, boolean bl) {
            ArrayList arrayList = (ArrayList)this.sIdToClassifiedListenerList.get(new Integer(n));
            if (arrayList == null) {
                arrayList = new ArrayList(10);
                this.sIdToClassifiedListenerList.put(new Integer(n), arrayList);
            }
            Iterator iterator = arrayList.iterator();
            boolean bl2 = false;
            while (iterator.hasNext()) {
                ClassifiedPdtListener classifiedPdtListener = (ClassifiedPdtListener)iterator.next();
                if (!classifiedPdtListener.pdtListener.equals(iPdtListener)) continue;
                classifiedPdtListener.interestedInGracenoteCoverArt = bl;
                bl2 = true;
                break;
            }
            if (!bl2) {
                arrayList.add(new ClassifiedPdtListener(iPdtListener, bl));
            }
        }

        public boolean removeListener(int n, IPdtListener iPdtListener) {
            boolean bl = this.hasListenersForSidInterestedInGracenoteCoverArt(n);
            ArrayList arrayList = (ArrayList)this.sIdToClassifiedListenerList.get(new Integer(n));
            if (arrayList != null) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    if (!((ClassifiedPdtListener)iterator.next()).pdtListener.equals(iPdtListener)) continue;
                    iterator.remove();
                }
                if (arrayList.isEmpty()) {
                    this.sIdToClassifiedListenerList.remove(new Integer(n));
                }
            }
            boolean bl2 = !this.hasListenersForSidInterestedInGracenoteCoverArt(n);
            return bl && bl2;
        }

        public Collection getAllSIdsWithRegisteredListeners() {
            return new ArrayList(this.sIdToClassifiedListenerList.keySet());
        }

        public Collection getListenersForSId(int n) {
            ArrayList arrayList = (ArrayList)this.sIdToClassifiedListenerList.get(new Integer(n));
            List list = Collections.EMPTY_LIST;
            if (arrayList != null) {
                list = new ArrayList(arrayList.size());
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    list.add(((ClassifiedPdtListener)iterator.next()).pdtListener);
                }
            }
            return list;
        }

        public boolean hasListenersForSid(int n) {
            return this.sIdToClassifiedListenerList.containsKey(new Integer(n));
        }

        public boolean hasListenersForSidInterestedInGracenoteCoverArt(int n) {
            ArrayList arrayList = (ArrayList)this.sIdToClassifiedListenerList.get(new Integer(n));
            if (arrayList != null) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    if (!((ClassifiedPdtListener)iterator.next()).interestedInGracenoteCoverArt) continue;
                    return true;
                }
            }
            return false;
        }

        public String dumpListenerData() {
            Buffer buffer = new Buffer(1000);
            Iterator iterator = this.sIdToClassifiedListenerList.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                Integer n = (Integer)entry.getKey();
                ArrayList arrayList = (ArrayList)entry.getValue();
                buffer.append("sId ").append(n.toString()).append(": ");
                Iterator iterator2 = arrayList.iterator();
                while (iterator2.hasNext()) {
                    ClassifiedPdtListener classifiedPdtListener = (ClassifiedPdtListener)iterator2.next();
                    buffer.append(classifiedPdtListener.pdtListener);
                    buffer.append(" (gracenote ").append(classifiedPdtListener.interestedInGracenoteCoverArt).append("), ");
                }
                buffer.delete(buffer.length() - 2, buffer.length());
                buffer.append("\n");
            }
            return buffer.toString();
        }
    }

    private static class CoverArtRequestInfo {
        public static final CoverArtRequestInfo EMPTY_DUMMY = new CoverArtRequestInfo(-1, "", "");
        private final int sId;
        private final String artistName;
        private final String title;

        public CoverArtRequestInfo(int n, String string, String string2) {
            this.sId = n;
            this.artistName = string;
            this.title = string2;
        }

        public static CoverArtRequestInfo fromRadioText(RadioText radioText) {
            String string = CoverArtRequestInfo.artistNameForRadioText(radioText);
            String string2 = CoverArtRequestInfo.titleForRadioText(radioText);
            return new CoverArtRequestInfo(radioText.sID, string, string2);
        }

        public boolean differesFrom(RadioText radioText) {
            return !this.matches(radioText);
        }

        public boolean matches(RadioText radioText) {
            return radioText != null && this.sId == radioText.sID && this.artistName.equals(CoverArtRequestInfo.artistNameForRadioText(radioText)) && this.title.equals(CoverArtRequestInfo.titleForRadioText(radioText));
        }

        private static String artistNameForRadioText(RadioText radioText) {
            return radioText.longArtistName != null ? radioText.longArtistName : radioText.shortArtistName;
        }

        private static String titleForRadioText(RadioText radioText) {
            return radioText.longProgramTitle != null ? radioText.longProgramTitle : radioText.shortProgramTitle;
        }
    }

    private class SDARSCoverArtHandler
    extends CoverArtHandler {
        public SDARSCoverArtHandler(TunerBasics tunerBasics) {
            super(tunerBasics);
        }

        public boolean setCoverArt(int n, ResourceLocator resourceLocator) {
            boolean bl = super.setCoverArt(n, resourceLocator);
            if (bl) {
                PdtInfoHandler.this.onGracenoteCoverArtArrived();
            }
            return bl;
        }
    }

    private static class ClassifiedPdtListener {
        public final IPdtListener pdtListener;
        public boolean interestedInGracenoteCoverArt;

        public ClassifiedPdtListener(IPdtListener iPdtListener, boolean bl) {
            this.pdtListener = iPdtListener;
            this.interestedInGracenoteCoverArt = bl;
        }
    }
}

