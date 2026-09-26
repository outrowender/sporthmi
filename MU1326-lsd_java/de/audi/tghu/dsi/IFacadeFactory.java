/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.dsi.audio.DSISoundExt;

public interface IFacadeFactory {
    default public DSISoundExt getDSISoundExt(LogChannel logChannel) {
    }
}

