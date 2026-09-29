/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.dsi.high;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.dsi.IFacadeFactory;
import de.audi.tghu.dsi.audio.DSISoundExt;
import de.audi.tghu.dsi.high.audio.DSISoundExtHigh;

public class HighFacadeFactory
implements IFacadeFactory {
    @Override
    public DSISoundExt getDSISoundExt(LogChannel logChannel) {
        return new DSISoundExtHigh(logChannel);
    }
}

