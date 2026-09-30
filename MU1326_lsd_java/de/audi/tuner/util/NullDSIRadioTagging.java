/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.util.NullDSIService;
import org.dsi.ifc.media.DSIRadioTagging;
import org.dsi.ifc.media.TagInformation;

public class NullDSIRadioTagging
extends NullDSIService
implements DSIRadioTagging {
    public NullDSIRadioTagging(LogChannel logChannel) {
        super(logChannel, "DSIRadioTagging");
    }

    public void tagSong(TagInformation tagInformation) {
        this.log();
    }

    public void tagAmbiguousSong(TagInformation tagInformation, TagInformation tagInformation2) {
        this.log();
    }

    public void groupTags(int n) {
        this.log();
    }
}

