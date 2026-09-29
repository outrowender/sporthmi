/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media.requests;

import de.audi.app.media.dsi.AbstractRequestParameter;
import de.esolutions.fw.util.commons.Buffer;

public class RequestParameterList
extends AbstractRequestParameter {
    private final long entryID;
    private final int contentType;
    private final int index;
    private final int count;
    private final int clientId;

    public RequestParameterList(long l, int n, int n2, int n3, int n4) {
        this(l, n, n2, n3, n4, false);
    }

    public RequestParameterList(long l, int n, int n2, int n3, int n4, boolean bl) {
        this.entryID = l;
        this.contentType = n;
        this.index = n2;
        this.count = n3;
        this.clientId = n4;
        this.retry = bl;
    }

    @Override
    public boolean equals(Object object) {
        try {
            RequestParameterList requestParameterList = (RequestParameterList)object;
            return requestParameterList.getEntryID() == this.getEntryID() && requestParameterList.getContentType() == this.getContentType() && requestParameterList.getIndex() == this.getIndex() && requestParameterList.getCount() == this.getCount() && requestParameterList.getClientID() == this.getClientID();
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new Long(this.entryID).hashCode() + new Integer(this.clientId).hashCode();
    }

    public long getEntryID() {
        return this.entryID;
    }

    public int getContentType() {
        return this.contentType;
    }

    public int getCount() {
        return this.count;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public int getClientID() {
        return this.clientId;
    }

    public String toString() {
        Buffer buffer = new Buffer(50);
        buffer.append("entryID='");
        buffer.append(this.entryID);
        buffer.append("',cT='");
        buffer.append(this.contentType);
        buffer.append("',idx='");
        buffer.append(this.index);
        buffer.append("',cnt='");
        buffer.append(this.count);
        buffer.append("',cID='");
        buffer.append(this.clientId);
        buffer.append("',retry='");
        buffer.append(this.retry);
        buffer.append("'@");
        buffer.append(this.hashCode());
        return buffer.toString();
    }
}

