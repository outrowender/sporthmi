/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetProperty;

public interface IBAPIndicationHandlerPropertyFSG {
    default public void processIndicationAck(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AckProperty ackProperty) {
    }

    default public void processIndicationSet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
    }

    default public void processIndicationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, SetGetProperty setGetProperty) {
    }
}

