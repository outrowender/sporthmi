/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.carplay.CarplayUtils;
import de.audi.app.terminalmode.dsi.carplay.DSICarplayTransferObjectFactory;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carplay.ResourceRequest;

class DSICarplayTransferObjectFactory$1
extends ResourceRequest {
    private final /* synthetic */ DSICarplayTransferObjectFactory this$0;

    DSICarplayTransferObjectFactory$1(DSICarplayTransferObjectFactory dSICarplayTransferObjectFactory, int n, int n2, int n3, int n4, int n5, int n6) {
        this.this$0 = dSICarplayTransferObjectFactory;
        super(n, n2, n3, n4, n5, n6);
    }

    @Override
    public String toString() {
        return new Buffer(400).append("ResourceRequest[").append(this.idToString()).append(", ").append(this.transferTypeToString()).append(", ").append(this.transferPriorityToString()).append(", take=").append(CarplayUtils.logResourceSharingPolicy(this.takeConstraint)).append(", borrow=").append(CarplayUtils.logResourceSharingPolicy(this.borrowConstraint)).append(", unborrow=").append(CarplayUtils.logResourceSharingPolicy(this.unborrowConstraint)).append("]").toString();
    }

    private String idToString() {
        switch (this.resourceID) {
            case 1: {
                return "RESOURCE_MAIN_AUDIO";
            }
            case 2: {
                return "RESOURCE_MAIN_SCREEN";
            }
            case 0: {
                return "RESOURCE_UNKNOWN";
            }
        }
        return new StringBuffer().append("RESOURCE ").append(this.resourceID).append(" is not valid! ").toString();
    }

    private String transferTypeToString() {
        switch (this.transferType) {
            case 3: {
                return "RESOURCETRANSFERTYPE_BORROW";
            }
            case 1: {
                return "RESOURCETRANSFERTYPE_TAKE";
            }
            case 4: {
                return "RESOURCETRANSFERTYPE_UNBORROW";
            }
            case 0: {
                return "RESOURCETRANSFERTYPE_UNKNOWN";
            }
            case 2: {
                return "RESOURCETRANSFERTYPE_UNTAKE";
            }
        }
        return new StringBuffer().append("RESOURCETRANSFERTYPE ").append(this.transferType).append(" is not valid!").toString();
    }

    private String transferPriorityToString() {
        switch (this.transferPriority) {
            case 2: {
                return "RESOURCETRANSFERPRIORITY_NICE_TO_HAVE";
            }
            case 0: {
                return "RESOURCETRANSFERPRIORITY_UNKNOWN";
            }
            case 1: {
                return "RESOURCETRANSFERPRIORITY_USER_INITIATED";
            }
        }
        return new StringBuffer().append("RESOURCETRANSFERPRIORITY ").append(this.transferPriority).append(" is not valid!").toString();
    }
}

