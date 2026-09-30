/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.TagInformation;

public interface DSIRadioTagging
extends DSIBase {
    public static final String VERSION = "2.11.52";
    public static final int ATTR_COMPATIBLEDEVAVAIL = 1;
    public static final int RT_TAGSONG = 1000;
    public static final int RT_TAGAMBIGUOUSSONG = 1001;
    public static final int RT_GROUPTAGS = 1002;
    public static final int RP_TAGRESULT = 2000;
    public static final int RP_GROUPTAGSRESULT = 2001;
    public static final int TAGRESULT_OK = 0;
    public static final int TAGRESULT_ERROR = 1;
    public static final int TAGRESULT_TARGETMEMORY_FULL = 2;
    public static final int DEVICESTATUS_NODEVICE = 0;
    public static final int DEVICESTATUS_AVAILABLE = 1;
    public static final int DEVICESTATUS_NOT_SUPPORTED = 2;
    public static final int DEVICESTATUS_ERROR = 3;

    public void tagSong(TagInformation var1);

    public void tagAmbiguousSong(TagInformation var1, TagInformation var2);

    public void groupTags(int var1);
}

