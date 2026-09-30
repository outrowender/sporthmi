/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.itunes;

import de.audi.tuner.itunes.ITaggingManagerListener;
import de.audi.tuner.itunes.TaggingData;
import org.dsi.ifc.media.TagInformation;

public interface ITaggingManager {
    public static final int TAGGING_UNKNOWN = 0;
    public static final int TAGGING_NO_INFO = 1;
    public static final int TAGGING_TAGGING_ALLOWED = 2;
    public static final int TAGGING_ALREADY_TAGGED = 3;
    public static final int TAGGING_MEMORY_FULL = 4;

    public int addTag(TaggingData var1);

    public boolean isAlreadyStored(int var1);

    public boolean isAlreadyStored(TagInformation var1);

    public boolean isTaggingSpaceFree();

    public int getExpectedTagResult();

    public void register(ITaggingManagerListener var1);
}

