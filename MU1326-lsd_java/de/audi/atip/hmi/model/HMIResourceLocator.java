/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.esolutions.fw.util.commons.Buffer;

public class HMIResourceLocator {
    public static final int UNDEFINED_ID;
    public static final String UNDEFINED_URI;
    public static final int STATUS_VALID;
    public static final int STATUS_INVALID;
    private final int resourceID;
    private final String resourceURI;
    private int pictureConfigUseCase;
    private int requestHandle;
    private int status = 0;
    private int minDisplayDuration;

    public HMIResourceLocator(int n) {
        this(n, UNDEFINED_URI);
    }

    public HMIResourceLocator(String string) {
        this(-1, string);
    }

    public HMIResourceLocator(int n, String string) {
        this.resourceID = n;
        this.resourceURI = string;
    }

    public HMIResourceLocator(int n, String string, int n2) {
        this.resourceID = n;
        this.resourceURI = string;
        this.pictureConfigUseCase = n2;
    }

    public HMIResourceLocator(HMIResourceLocator hMIResourceLocator) {
        this.resourceID = hMIResourceLocator.getResourceID();
        this.resourceURI = hMIResourceLocator.getResourceURI();
        this.pictureConfigUseCase = hMIResourceLocator.getPictureConfigUseCase();
        this.minDisplayDuration = hMIResourceLocator.minDisplayDuration;
        this.requestHandle = hMIResourceLocator.getRequestHandle();
    }

    public int getResourceID() {
        return this.resourceID;
    }

    public String getResourceURI() {
        return this.resourceURI;
    }

    public boolean containsResourceID() {
        return this.resourceID != -1;
    }

    public boolean containsResourceURI() {
        return this.resourceURI != UNDEFINED_URI && this.resourceURI.trim().length() > 0;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof HMIResourceLocator)) {
            return false;
        }
        HMIResourceLocator hMIResourceLocator = (HMIResourceLocator)object;
        if (this.resourceURI != UNDEFINED_URI) {
            return this.resourceURI.equals(hMIResourceLocator.getResourceURI());
        }
        if (hMIResourceLocator.resourceURI != UNDEFINED_URI) {
            return false;
        }
        if (this.resourceID != -1) {
            return this.resourceID == hMIResourceLocator.getResourceID();
        }
        return false;
    }

    public int hashCode() {
        int n = 31 + this.resourceID;
        n = 31 * n + (this.resourceURI == null ? 0 : this.resourceURI.hashCode());
        return n;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.toString());
        buffer.append(" [ID:").append(this.resourceID);
        buffer.append(" URI:").append(this.resourceURI);
        buffer.append(" status:").append(this.status);
        buffer.append(" min duration:").append(this.minDisplayDuration).append(']');
        return buffer.toString();
    }

    public int getPictureConfigUseCase() {
        return this.pictureConfigUseCase;
    }

    public void setPictureConfigUseCase(int n) {
        this.pictureConfigUseCase = n;
    }

    public int getRequestHandle() {
        return this.requestHandle;
    }

    public void setRequestHandle(int n) {
        this.requestHandle = n;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int n) {
        this.status = n;
    }

    public int getMinDisplayDuration() {
        return this.minDisplayDuration;
    }

    public void setMinDisplayDuration(int n) {
        this.minDisplayDuration = n;
    }

    static {
        UNDEFINED_URI = null;
    }
}

