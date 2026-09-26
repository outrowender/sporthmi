/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG$1;
import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

final class BAPFunctionArrayFSG$ArrayRequestJob {
    private final int requestType;
    private final BAPArray serializer;

    private BAPFunctionArrayFSG$ArrayRequestJob(ChangedArray changedArray) {
        this.requestType = 10;
        this.serializer = changedArray;
    }

    private BAPFunctionArrayFSG$ArrayRequestJob(StatusArray statusArray) {
        this.requestType = 7;
        this.serializer = statusArray;
    }

    static /* synthetic */ int access$000(BAPFunctionArrayFSG$ArrayRequestJob bAPFunctionArrayFSG$ArrayRequestJob) {
        return bAPFunctionArrayFSG$ArrayRequestJob.requestType;
    }

    static /* synthetic */ BAPArray access$100(BAPFunctionArrayFSG$ArrayRequestJob bAPFunctionArrayFSG$ArrayRequestJob) {
        return bAPFunctionArrayFSG$ArrayRequestJob.serializer;
    }

    /* synthetic */ BAPFunctionArrayFSG$ArrayRequestJob(ChangedArray changedArray, BAPFunctionArrayFSG$1 bAPFunctionArrayFSG$1) {
        this(changedArray);
    }

    /* synthetic */ BAPFunctionArrayFSG$ArrayRequestJob(StatusArray statusArray, BAPFunctionArrayFSG$1 bAPFunctionArrayFSG$1) {
        this(statusArray);
    }
}

