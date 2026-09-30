/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.tuner.app.gracenote.IGracenoteResponse;
import org.dsi.ifc.media.CoverartInfo;

public interface IGracenoteRequest {
    public int gracenoteRequest(CoverartInfo var1, IGracenoteResponse var2);
}

