/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDSectionConfigListRecordSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDSectionConfigListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

class DSICarKombiProxy$9
implements ISerializable {
    private final /* synthetic */ CarArrayListUpdateInfo val$arrayHeader;
    private final /* synthetic */ HUDSectionConfigListRecord[] val$data;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$9(DSICarKombiProxy dSICarKombiProxy, CarArrayListUpdateInfo carArrayListUpdateInfo, HUDSectionConfigListRecord[] hUDSectionConfigListRecordArray) {
        this.this$0 = dSICarKombiProxy;
        this.val$arrayHeader = carArrayListUpdateInfo;
        this.val$data = hUDSectionConfigListRecordArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, this.val$arrayHeader);
        HUDSectionConfigListRecordSerializer.putOptionalHUDSectionConfigListRecordVarArray(iSerializer, this.val$data);
    }
}

