/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.eso.IconExtractor.IconExtractor$Bitmap;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$IIconLoadedCallBack;

public class IconLoader$IconLoadedEvent
extends ATIPEvent {
    private final int iconID;
    private final Integer id_int;
    private final IconExtractor$Bitmap bitmap;

    protected IconLoader$IconLoadedEvent(IconLoader$IIconLoadedCallBack iconLoader$IIconLoadedCallBack, int n, Integer n2, IconExtractor$Bitmap iconExtractor$Bitmap) {
        super(iconLoader$IIconLoadedCallBack, n);
        this.iconID = n;
        this.id_int = n2;
        this.bitmap = iconExtractor$Bitmap;
    }

    public int getIconID() {
        return this.iconID;
    }

    public Integer getIDInt() {
        return this.id_int;
    }

    public IconExtractor$Bitmap getImage() {
        return this.bitmap;
    }
}

