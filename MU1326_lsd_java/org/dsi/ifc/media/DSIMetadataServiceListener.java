/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIMetadataServiceListener
extends DSIListener {
    public void updateOnlineLookupStatus(int var1, int var2);

    public void responseCoverArt(int var1, ResourceLocator var2);
}

