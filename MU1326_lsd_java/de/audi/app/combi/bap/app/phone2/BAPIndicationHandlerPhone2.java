/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone2;

import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.generated.phone2.AbstractBAPIndicationHandlerPhone2;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.combi.bap.app.phone2.CombiModulePhone2;
import de.vw.mib.bap.requests.GetArray;

public class BAPIndicationHandlerPhone2
extends AbstractBAPIndicationHandlerPhone2 {
    protected BAPIndicationHandlerPhone2(CombiModulePhone2 combiModulePhone2) {
        super(combiModulePhone2, combiModulePhone2.getLogChannel());
    }

    @Override
    public GetArrayIndication evaluateGetArrayIndication(int n, GetArray getArray) {
        GetArrayIndication getArrayIndication = null;
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[BAPIndicationHandlerPhone2#evaluateGetArrayIndication] function is not an array or not supported yet (%1)", (Object)FunctionIDs.getDescription(this.lsgID, n));
        return getArrayIndication;
    }
}

