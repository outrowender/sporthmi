/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.ToneServiceListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullToneServiceListener
extends NullService
implements ToneServiceListener {
    public NullToneServiceListener(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    @Override
    public void updateApsEntertainmentLoweringComboboxState(int n) {
        this.log();
    }
}

