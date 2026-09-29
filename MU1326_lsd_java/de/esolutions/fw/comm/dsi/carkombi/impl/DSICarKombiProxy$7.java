/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDCollectiveTopicsSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDCollectiveTopics;

class DSICarKombiProxy$7
implements ISerializable {
    private final /* synthetic */ HUDCollectiveTopics val$collectiveTopics;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$7(DSICarKombiProxy dSICarKombiProxy, HUDCollectiveTopics hUDCollectiveTopics) {
        this.this$0 = dSICarKombiProxy;
        this.val$collectiveTopics = hUDCollectiveTopics;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        HUDCollectiveTopicsSerializer.putOptionalHUDCollectiveTopics(iSerializer, this.val$collectiveTopics);
    }
}

