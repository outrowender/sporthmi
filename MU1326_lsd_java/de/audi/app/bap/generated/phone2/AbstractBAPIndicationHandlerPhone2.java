/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone2;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.AbstractBAPIndicationHandlerFSG;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;

public abstract class AbstractBAPIndicationHandlerPhone2
extends AbstractBAPIndicationHandlerFSG {
    public AbstractBAPIndicationHandlerPhone2(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
    }

    @Override
    public void processIndicationStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, StartResultMethod startResultMethod) {
        switch (bAPFunctionMethodFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone2#processIndicationStartResult not implemented for fctID=%1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        switch (bAPFunctionMethodFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone2#processIndicationAbort not implemented for fctID=%1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone2#processIndicationSet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone2#processIndicationSetGet not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationAck(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AckProperty ackProperty) {
        switch (bAPFunctionPropertyFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone2#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionPropertyFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationAckArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, BAPArray bAPArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone2#processIndicationAck not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone2#processIndicationSetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }

    @Override
    public void processIndicationSetGetArray(BAPFunctionArrayFSG bAPFunctionArrayFSG, SetGetArray setGetArray) {
        switch (bAPFunctionArrayFSG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerPhone2#processIndicationSetGetArray not implemented for fctID=%1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
    }
}

