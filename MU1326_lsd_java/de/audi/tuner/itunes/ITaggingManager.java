/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.itunes;

import de.audi.tuner.itunes.ITaggingManagerListener;
import de.audi.tuner.itunes.TaggingData;
import org.dsi.ifc.media.TagInformation;

public interface ITaggingManager {
    public static final int TAGGING_UNKNOWN;
    public static final int TAGGING_NO_INFO;
    public static final int TAGGING_TAGGING_ALLOWED;
    public static final int TAGGING_ALREADY_TAGGED;
    public static final int TAGGING_MEMORY_FULL;

    default public int addTag(TaggingData taggingData) {
    }

    default public boolean isAlreadyStored(int n) {
    }

    default public boolean isAlreadyStored(TagInformation tagInformation) {
    }

    default public boolean isTaggingSpaceFree() {
    }

    default public int getExpectedTagResult() {
    }

    default public void register(ITaggingManagerListener iTaggingManagerListener) {
    }
}

