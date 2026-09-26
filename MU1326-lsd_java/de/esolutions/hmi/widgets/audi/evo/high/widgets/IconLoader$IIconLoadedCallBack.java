/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ATIPEventListener;
import de.eso.IconExtractor.IconExtractor$Bitmap;

public interface IconLoader$IIconLoadedCallBack
extends ATIPEventListener {
    default public void onIconLoaded(int n, Integer n2, IconExtractor$Bitmap iconExtractor$Bitmap) {
    }
}

