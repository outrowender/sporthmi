/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

public class OAuthToken {
    public String scope;
    public long expiresIn;
    public String type;
    public String accessToken;

    public String getScope() {
        return this.scope;
    }

    public void setScope(String string) {
        this.scope = string;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(long l) {
        this.expiresIn = l;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String string) {
        this.type = string;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String string) {
        this.accessToken = string;
    }

    public OAuthToken() {
    }

    public OAuthToken(String string, long l, String string2, String string3) {
        this.scope = string;
        this.expiresIn = l;
        this.type = string2;
        this.accessToken = string3;
    }

    public String toString() {
        return "OAuthToken{" + "scope=" + this.scope + ", expiresIn=" + this.expiresIn + ", type=" + this.type + ", accessToken=" + this.accessToken + "}";
    }
}

