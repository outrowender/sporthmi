/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media.requests;

import de.audi.app.media.dsi.AbstractRequestParameter;
import de.esolutions.fw.util.commons.Buffer;

public class RequestParameterEntryID
extends AbstractRequestParameter {
    private final long entryID;
    private final int clientID;

    public RequestParameterEntryID(long l, int n) {
        this.entryID = l;
        this.clientID = n;
    }

    @Override
    public boolean equals(Object object) {
        try {
            RequestParameterEntryID requestParameterEntryID = (RequestParameterEntryID)object;
            return requestParameterEntryID.getEntryID() == this.entryID && requestParameterEntryID.getClientID() == this.clientID;
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new Long(this.entryID).hashCode() * new Integer(this.clientID).hashCode();
    }

    public long getEntryID() {
        return this.entryID;
    }

    @Override
    public int getClientID() {
        return this.clientID;
    }

    public String toString() {
        Buffer buffer = new Buffer(50);
        buffer.append("entryID='");
        buffer.append(this.entryID);
        buffer.append("',cID='");
        buffer.append(this.clientID);
        buffer.append("'@");
        buffer.append(this.hashCode());
        return buffer.toString();
    }
}

