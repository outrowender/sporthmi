/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media.requests;

import de.audi.app.media.dsi.AbstractRequestParameter;
import de.esolutions.fw.util.commons.Buffer;

public class RequestPickListParameterList
extends AbstractRequestParameter {
    private final long[] entryIDs;
    private final int clientId;

    public RequestPickListParameterList(long[] lArray, int n) {
        this.entryIDs = lArray;
        this.clientId = n;
    }

    public boolean equals(Object object) {
        try {
            RequestPickListParameterList requestPickListParameterList = (RequestPickListParameterList)object;
            long[] lArray = requestPickListParameterList.getEntryIDs();
            if (lArray.length != this.entryIDs.length || requestPickListParameterList.getClientID() != this.getClientID()) {
                return false;
            }
            boolean bl = true;
            for (int i2 = 0; i2 < lArray.length && bl; bl &= lArray[i2] == this.entryIDs[i2], ++i2) {
            }
            return bl;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int hashCode() {
        return 0;
    }

    public long[] getEntryIDs() {
        return this.entryIDs;
    }

    public int getClientID() {
        return this.clientId;
    }

    public String toString() {
        Buffer buffer = new Buffer(50);
        buffer.append("entryID='");
        for (int i2 = 0; i2 < this.entryIDs.length - 1; ++i2) {
            buffer.append(this.entryIDs[i2]);
            buffer.append(',');
        }
        buffer.append(this.entryIDs[this.entryIDs.length - 1]);
        buffer.append("',clientID='");
        buffer.append(this.clientId);
        buffer.append("'@");
        buffer.append(this.hashCode());
        return buffer.toString();
    }
}

