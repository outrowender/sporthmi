/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.generated.onlinefunctions.AbstractBAPIndicationHandlerOnlineFunctions;
import de.vw.mib.bap.generated.onlinefunctions.serializer.FSG_Control_SetGet;
import de.vw.mib.bap.requests.GetArray;

public class BAPIndicationHandlerOnlineFunctions
extends AbstractBAPIndicationHandlerOnlineFunctions {
    public BAPIndicationHandlerOnlineFunctions(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        super(abstractBAPModuleFSG, abstractBAPModuleFSG.getLogChannel());
    }

    public GetArrayIndication evaluateGetArrayIndication(int n, GetArray getArray) {
        return null;
    }

    protected void processFsgControlSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, FSG_Control_SetGet fSG_Control_SetGet) {
    }
}

