/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.interapp.radio.IGracenoteService;
import de.audi.atip.interapp.radio.IGracenoteServiceListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.gracenote.IGracenoteResponse;
import de.audi.tuner.app.gracenote.NullDSIMetadataService;
import de.audi.tuner.app.gracenote.NullGracenoteServiceListener;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.listener.MessageListener;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.CoverartInfo;
import org.dsi.ifc.media.DSIMetadataService;
import org.dsi.ifc.media.DSIMetadataServiceListener;

public class RadioGracenote
implements IGracenoteRequest {
    public final DSIMetadataServiceListener gracenoteListener = new GracenoteListener();
    public final IGracenoteService mediaListener = new MediaListener();
    public final MessageListener resetListener = new ResetListener();
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
        this.models.getChoiceModel(100580).setStatus(0);
        this.models.getChoiceModel(100580).setValue(this.gracenoteLookup ? 1 : 0);
        this.models.getChoiceModel(100580).setChoiceListener(new ChoiceListener());
    }

    public void setDeviceService(DSIMetadataService dSIMetadataService) {
        int n = Utilities.getImgConfig();
        if (dSIMetadataService == null) {
            this.gracenoteDsi = new NullDSIMetadataService(this.logger.gracenote);
            this.models.getChoiceModel(100580).setStatus(0);
        } else {
            this.gracenoteDsi = dSIMetadataService;
            n |= 2;
            if (Utilities.isGraceNoteOnline()) {
                this.models.getChoiceModel(100580).setStatus(1);
            }
        }
        this.models.getChoiceModel(100548).addHint(n);
        if (Utilities.countBits(n) > 1) {
            this.models.getChoiceModel(100548).setStatus(1);
        } else {
            this.models.getChoiceModel(100548).setStatus(0);
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
    public int gracenoteRequest(CoverartInfo coverartInfo, IGracenoteResponse iGracenoteResponse) {
        ++this.jobId;
        Object object = this.mutex;
        synchronized (object) {
            this.destAdresses.add(this.jobId, iGracenoteResponse);
        }
        this.logger.gracenote.log(10000000, "[RadioGracenote.requestCoverArt] job %2, %1", (Object)coverartInfo, (long)this.jobId);
        this.gracenoteDsi.requestCoverArt(this.jobId, coverartInfo);
        return this.jobId;
    }

    public void enableOnlineLookup() {
        this.gracenoteDsi.enableOnlineLookup();
    }

    public void disableOnlineLookup() {
        this.gracenoteDsi.disableOnlineLookup();
    }

    private class MediaListener
    implements IGracenoteService {
        private MediaListener() {
        }

        public void disableOnlineLookup() {
            ((RadioGracenote)RadioGracenote.this).logger.gracenote.log(10000000, "[RadioGracenote.MediaListener.disableOnlineLookup]");
            RadioGracenote.this.disableOnlineLookup();
        }

        public void enableOnlineLookup() {
            ((RadioGracenote)RadioGracenote.this).logger.gracenote.log(10000000, "[RadioGracenote.MediaListener.enableOnlineLookup]");
            RadioGracenote.this.enableOnlineLookup();
        }
    }

    private class ResetListener
    extends MessageListener {
        private ResetListener() {
        }

        public void resetToDefaultSettings() {
            ((RadioGracenote)RadioGracenote.this).logger.gracenote.log(10000000, "[RadioGracenote.ResetListener.enableOnlineLookup]");
            RadioGracenote.this.enableOnlineLookup();
        }
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            ((RadioGracenote)RadioGracenote.this).logger.hmi.log(10000000, "[RadioGracenote.ChoiceListener.itemSelected] change online lookup, itemID: %1", (long)n2);
            if (n2 == 0) {
                RadioGracenote.this.disableOnlineLookup();
            } else {
                RadioGracenote.this.enableOnlineLookup();
            }
            TunerProxyManager.getInstance().getActiveTuner().reRequestCoverArt();
        }
    }

    private class GracenoteListener
    implements DSIMetadataServiceListener {
        private GracenoteListener() {
        }

        public void asyncException(int n, String string, int n2) {
        }

        public void updateOnlineLookupStatus(int n, int n2) {
            ((RadioGracenote)RadioGracenote.this).logger.gracenote.log(10000000, "[DSIMetadataServiceListener.updateOnlineLookupStatus] %1 valid:%2", (long)n, (long)n2);
            if (n2 == 1) {
                try {
                    if (n != 0) {
                        RadioGracenote.this.gracenoteLookup = n == 1;
                        RadioGracenote.this.models.getChoiceModel(100580).setValue(RadioGracenote.this.gracenoteLookup ? 1 : 0);
                        RadioGracenote.this.storage.storeGracenoteOnlineLookup(RadioGracenote.this.gracenoteLookup);
                    }
                    RadioGracenote.this.mediaService.updateOnlineLookupStatus(n);
                }
                catch (Exception exception) {
                    ((RadioGracenote)RadioGracenote.this).logger.gracenote.log(10000, "[DSIMetadataServiceListener.updateOnlineLookupStatus]", (Throwable)exception);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void responseCoverArt(int n, ResourceLocator resourceLocator) {
            IGracenoteResponse iGracenoteResponse;
            ((RadioGracenote)RadioGracenote.this).logger.gracenote.log(10000000, "[DSIMetadataServiceListener.responseCoverArt] job %2, %1", (Object)resourceLocator, (long)n);
            Object object = RadioGracenote.this.mutex;
            synchronized (object) {
                iGracenoteResponse = (IGracenoteResponse)RadioGracenote.this.destAdresses.get(n);
                RadioGracenote.this.destAdresses.remove(n);
            }
            if (iGracenoteResponse != null) {
                iGracenoteResponse.setCoverArt(n, resourceLocator);
            } else {
                ((RadioGracenote)RadioGracenote.this).logger.gracenote.log(10000, "no destination for jobId %1 found", (long)n);
            }
        }
    }
}

