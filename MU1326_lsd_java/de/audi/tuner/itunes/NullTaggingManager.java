/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.itunes;

import de.audi.tuner.itunes.ITaggingManager;
import de.audi.tuner.itunes.ITaggingManagerListener;
import de.audi.tuner.itunes.TaggingData;
import org.dsi.ifc.media.TagInformation;

public class NullTaggingManager
implements ITaggingManager {
    public int addTag(TaggingData taggingData) {
        return 0;
    }

    public boolean isAlreadyStored(TagInformation tagInformation) {
        return false;
    }

    public boolean isAlreadyStored(int n) {
        return false;
    }

    public int getExpectedTagResult() {
        return 0;
    }

    public void register(ITaggingManagerListener iTaggingManagerListener) {
    }

    public boolean isTaggingSpaceFree() {
        return true;
    }
}

