/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.gracenote.CoverArtHandler$1;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.gracenote.IGracenoteResponse;
import de.audi.tuner.ifc.ISimpleTuner;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.CoverartInfo;

public class CoverArtHandler
implements IGracenoteResponse {
    private static final int NO_JOB;
    private final LogChannel log;
    private HMIResourceLocator coverArt = ISimpleTuner.EMPTY_RL;
    private final Object mutex = new Object();
    private IGracenoteRequest gracenote = new CoverArtHandler$1(this);
    private CoverartInfo gracenoteRequest = new CoverartInfo();
    private int requestId = -1;

    public CoverArtHandler(TunerBasics tunerBasics) {
        this.log = tunerBasics.getLogger().gracenote;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void register(IGracenoteRequest iGracenoteRequest) {
        Object object = this.mutex;
        synchronized (object) {
            this.gracenote = iGracenoteRequest;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestCoverArt(String string, String string2, String string3) {
        Object object = this.mutex;
        synchronized (object) {
            if (string.length() == 0 && string3.length() == 0 && string2.length() == 0) {
                if (this.requestId != -1) {
                    this.clear();
                }
            } else if (this.requestId == -1) {
                this.gracenoteRequest = new CoverartInfo(string, string2, string3);
                this.requestId = this.gracenote.gracenoteRequest(this.gracenoteRequest, this);
            } else if (!(string.equals(this.gracenoteRequest.artist) && string2.equals(this.gracenoteRequest.album) && string3.equals(this.gracenoteRequest.title))) {
                this.gracenoteRequest = new CoverartInfo(string, string2, string3);
                this.requestId = this.gracenote.gracenoteRequest(this.gracenoteRequest, this);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.requestId = -1;
            this.gracenoteRequest = new CoverartInfo();
            this.coverArt = ISimpleTuner.EMPTY_RL;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean setCoverArt(int n, ResourceLocator resourceLocator) {
        this.log.log(-2137614336, "[CoverArtManager.setCoverArt] %1", (Object)resourceLocator);
        Object object = this.mutex;
        synchronized (object) {
            String string;
            String string2;
            if (n == this.requestId && CoverArtHandler.isUriNew(string2 = this.coverArt.getResourceURI(), string = resourceLocator.getUrl())) {
                this.coverArt = new HMIResourceLocator(string);
                return true;
            }
        }
        return false;
    }

    private static boolean isUriNew(String string, String string2) {
        string = string == null ? "" : string;
        string2 = string2 == null ? "" : string2;
        return !string2.equals(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public HMIResourceLocator getCoverArt() {
        Object object = this.mutex;
        synchronized (object) {
            return this.coverArt;
        }
    }
}

