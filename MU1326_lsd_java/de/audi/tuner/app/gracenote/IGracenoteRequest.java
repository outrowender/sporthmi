/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.tuner.app.gracenote.IGracenoteResponse;
import org.dsi.ifc.media.CoverartInfo;

public interface IGracenoteRequest {
    default public int gracenoteRequest(CoverartInfo coverartInfo, IGracenoteResponse iGracenoteResponse) {
    }
}

