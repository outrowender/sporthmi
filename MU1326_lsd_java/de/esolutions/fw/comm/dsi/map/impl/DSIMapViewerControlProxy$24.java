/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavRectangle;

class DSIMapViewerControlProxy$24
implements ISerializable {
    private final /* synthetic */ NavRectangle val$copyrightRectangle;
    private final /* synthetic */ int val$textAlignment;
    private final /* synthetic */ int val$verticalAlignment;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$24(DSIMapViewerControlProxy dSIMapViewerControlProxy, NavRectangle navRectangle, int n, int n2) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$copyrightRectangle = navRectangle;
        this.val$textAlignment = n;
        this.val$verticalAlignment = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavRectangleSerializer.putOptionalNavRectangle(iSerializer, this.val$copyrightRectangle);
        iSerializer.putInt32(this.val$textAlignment);
        iSerializer.putInt32(this.val$verticalAlignment);
    }
}

