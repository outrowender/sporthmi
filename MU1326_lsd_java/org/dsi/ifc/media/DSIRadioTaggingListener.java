/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;

public interface DSIRadioTaggingListener
extends DSIListener {
    public void tagResult(int var1);

    public void updateCompatibleDevAvail(int var1, int var2);

    public void groupTagsResult(int var1, int var2);
}

