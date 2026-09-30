/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navfleetservices;

import org.dsi.ifc.base.DSIListener;

public interface DSINavFleetServicesListener
extends DSIListener {
    public void setVZOTrackerStateResult(int var1);

    public void setVZODownloadStateResult(int var1);

    public void setLGITrackerStateResult(int var1);

    public void setLGIDownloadStateResult(int var1);
}

