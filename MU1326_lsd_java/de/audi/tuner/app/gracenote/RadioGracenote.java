/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.atip.interapp.radio.IGracenoteService;
import de.audi.atip.interapp.radio.IGracenoteServiceListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.gracenote.IGracenoteResponse;
import de.audi.tuner.app.gracenote.NullDSIMetadataService;
import de.audi.tuner.app.gracenote.NullGracenoteServiceListener;
import de.audi.tuner.app.gracenote.RadioGracenote$ChoiceListener;
import de.audi.tuner.app.gracenote.RadioGracenote$GracenoteListener;
import de.audi.tuner.app.gracenote.RadioGracenote$MediaListener;
import de.audi.tuner.app.gracenote.RadioGracenote$ResetListener;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.listener.MessageListener;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.CoverartInfo;
import org.dsi.ifc.media.DSIMetadataService;
import org.dsi.ifc.media.DSIMetadataServiceListener;

public class RadioGracenote
implements IGracenoteRequest {
    public final DSIMetadataServiceListener gracenoteListener = new RadioGracenote$GracenoteListener(this, null);
    public final IGracenoteService mediaListener = new RadioGracenote$MediaListener(this, null);
    public final MessageListener resetListener = new RadioGracenote$ResetListener(this, null);
    private int jobId;
    private final Object mutex = new Object();
    private final SimpleIntObjectMap destAdresses = new SimpleIntObjectMap(10);
    private final Logger logger;
    private final TunerModels models;
    private final TunerStorage storage;
    private DSIMetadataService gracenoteDsi;
    private IGracenoteServiceListener mediaService;
    private boolean gracenoteLookup;

    public RadioGracenote(TunerBasics tunerBasics, TunerStorage tunerStorage) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.gracenoteDsi = new NullDSIMetadataService(this.logger.gracenote);
        this.mediaService = new NullGracenoteServiceListener(this.logger.gracenote);
        this.storage = tunerStorage;
        this.gracenoteLookup = tunerStorage.loadGracenoteOnlineLookup();
        this.models.getChoiceModel(-460848896).setStatus(0);
        this.models.getChoiceModel(-460848896).setValue(this.gracenoteLookup ? 1 : 0);
        this.models.getChoiceModel(-460848896).setChoiceListener(new RadioGracenote$ChoiceListener(this, null));
    }

    public void setDeviceService(DSIMetadataService dSIMetadataService) {
        int n = Utilities.getImgConfig();
        if (dSIMetadataService == null) {
            this.gracenoteDsi = new NullDSIMetadataService(this.logger.gracenote);
            this.models.getChoiceModel(-460848896).setStatus(0);
        } else {
            this.gracenoteDsi = dSIMetadataService;
            n |= 2;
            if (Utilities.isGraceNoteOnline()) {
                this.models.getChoiceModel(-460848896).setStatus(1);
            }
        }
        this.models.getChoiceModel(-997719808).addHint(n);
        if (Utilities.countBits(n) > 1) {
            this.models.getChoiceModel(-997719808).setStatus(1);
        } else {
            this.models.getChoiceModel(-997719808).setStatus(0);
        }
    }

    public void register(IGracenoteServiceListener iGracenoteServiceListener) {
        if (iGracenoteServiceListener == null) {
            this.mediaService = new NullGracenoteServiceListener(this.logger.gracenote);
        } else {
            this.mediaService = iGracenoteServiceListener;
            this.gracenoteDsi.setNotification(1, (DSIListener)this.gracenoteListener);
        }
    }

    public boolean isDsiFound() {
        return !(this.gracenoteDsi instanceof NullDSIMetadataService);
    }

    public void init() {
        if (this.gracenoteLookup) {
            this.gracenoteDsi.enableOnlineLookup();
        } else {
            this.gracenoteDsi.disableOnlineLookup();
        }
        this.gracenoteDsi.setNotification(1, (DSIListener)this.gracenoteListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int gracenoteRequest(CoverartInfo coverartInfo, IGracenoteResponse iGracenoteResponse) {
        ++this.jobId;
        Object object = this.mutex;
        synchronized (object) {
            this.destAdresses.add(this.jobId, iGracenoteResponse);
        }
        this.logger.gracenote.log(-2137614336, "[RadioGracenote.requestCoverArt] job %2, %1", (Object)coverartInfo, (long)this.jobId);
        this.gracenoteDsi.requestCoverArt(this.jobId, coverartInfo);
        return this.jobId;
    }

    public void enableOnlineLookup() {
        this.gracenoteDsi.enableOnlineLookup();
    }

    public void disableOnlineLookup() {
        this.gracenoteDsi.disableOnlineLookup();
    }

    static /* synthetic */ Logger access$400(RadioGracenote radioGracenote) {
        return radioGracenote.logger;
    }

    static /* synthetic */ boolean access$502(RadioGracenote radioGracenote, boolean bl) {
        radioGracenote.gracenoteLookup = bl;
        return radioGracenote.gracenoteLookup;
    }

    static /* synthetic */ boolean access$500(RadioGracenote radioGracenote) {
        return radioGracenote.gracenoteLookup;
    }

    static /* synthetic */ TunerModels access$600(RadioGracenote radioGracenote) {
        return radioGracenote.models;
    }

    static /* synthetic */ TunerStorage access$700(RadioGracenote radioGracenote) {
        return radioGracenote.storage;
    }

    static /* synthetic */ IGracenoteServiceListener access$800(RadioGracenote radioGracenote) {
        return radioGracenote.mediaService;
    }

    static /* synthetic */ Object access$900(RadioGracenote radioGracenote) {
        return radioGracenote.mutex;
    }

    static /* synthetic */ SimpleIntObjectMap access$1000(RadioGracenote radioGracenote) {
        return radioGracenote.destAdresses;
    }
}

