/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.persistence;

import de.audi.app.media.persistence.MediaStorage;
import de.audi.app.media.source.ISourceSlot;

public interface IMediaPersistence {
    public static final int SCOPE_GLOBAL = 0;
    public static final int SCOPE_SOURCE = 1;
    public static final int SCOPE_MEDIATYPE = 2;
    public static final int SCOPE_SOURCESLOT = 3;
    public static final String GLOBAL_KEY_DVDV_PM_LEVEL = "GLOBAL_KEY_DVDV_PM_LEVEL";
    public static final String GLOBAL_KEY_DVDV_PM_PASSWORD = "GLOBAL_KEY_DVDV_PM_PASSWORD";
    public static final String GLOBAL_KEY_DVDV_REGIONCODE_CHANGES_LEFT = "GLOBAL_KEY_DVDV_REGIONCODE_CHANGES_LEFT";
    public static final String GLOBAL_KEY_LAST_ACTIVE_SOURCE = "GLOBAL_KEY_LAST_ACTIVE_SOURCE";
    public static final String GLOBAL_KEY_LAST_ACTIVE_SLOT = "GLOBAL_KEY_LAST_ACTIVE_SLOT";
    public static final String GLOBAL_KEY_IOS_AUTOSTART = "GLOBAL_KEY_IOS_AUTOSTART";
    public static final String GLOBAL_KEY_RIPPING_ENCODING_QUALITY = "GLOBAL_KEY_RIPPING_ENCODING_QUALITY";
    public static final String GLOBAL_KEY_BROWSER_LAST_SELECTION = "GLOBAL_KEY_BROWSER_LAST_SELECTION";
    public static final String GLOBAL_KEY_DVDC_REPEAT_SCOPE = "GLOBAL_KEY_DVDC_REPEAT_SCOPE";
    public static final String DEFAULT_PML_PASSWORD = "1234";
    public static final int DEFAULT_PML_LEVEL = 0;
    public static final String DEFAULT_IOS_AUTOSTART = "";

    public void setGlobalStringProperty(String var1, String var2);

    public void setGlobalIntProperty(String var1, int var2);

    public String getGlobalStringProperty(String var1);

    public int getGlobalIntProperty(String var1);

    public void setLocalProperty(int var1, ISourceSlot var2, int var3, Object var4);

    public Object getLocalProperty(int var1, ISourceSlot var2, int var3, Object var4);

    public void registerIntProperty(String var1, int var2, int var3, int var4);

    public void registerStringProperty(String var1, String var2);

    public MediaStorage getStorage();
}

