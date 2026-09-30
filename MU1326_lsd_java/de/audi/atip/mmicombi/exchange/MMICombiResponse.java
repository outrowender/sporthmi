/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.audi.atip.mmicombi.exchange.IMMICombiDisplayExchangePacket;
import de.audi.atip.mmicombi.exchange.MMICombiDisplayExchangePacket;
import de.audi.atip.mmicombi.exchange.MMICombiDisplayStatus;
import de.audi.atip.mmicombi.exchange.MMICombiRequest;
import de.audi.atip.mmicombi.exchange.MMICombiRequestAnimationInfo;

public class MMICombiResponse
extends MMICombiDisplayExchangePacket {
    private MMICombiRequest originalRequest;
    private MMICombiRequestAnimationInfo animationInfo;
    private boolean kdkVisible;
    private int kdkOpacity;
    private int kdkPositionInfo;
    private boolean bargraphVisible;

    public MMICombiResponse(int n, int n2, MMICombiDisplayStatus mMICombiDisplayStatus, MMICombiRequestAnimationInfo mMICombiRequestAnimationInfo, boolean bl, int n3, int n4, boolean bl2) {
        super(n, n2, mMICombiDisplayStatus);
        this.animationInfo = mMICombiRequestAnimationInfo;
        this.kdkVisible = bl;
        this.kdkOpacity = n3;
        this.kdkPositionInfo = n4;
        this.bargraphVisible = bl2;
    }

    public MMICombiResponse(int n, int n2, MMICombiDisplayStatus mMICombiDisplayStatus, MMICombiRequestAnimationInfo mMICombiRequestAnimationInfo) {
        this(n, n2, mMICombiDisplayStatus, mMICombiRequestAnimationInfo, false, 0, 0, false);
    }

    public MMICombiResponse(int n, int n2, MMICombiDisplayStatus mMICombiDisplayStatus) {
        this(n, n2, mMICombiDisplayStatus, new MMICombiRequestAnimationInfo(), false, 0, 0, false);
    }

    public MMICombiResponse(IMMICombiDisplayExchangePacket iMMICombiDisplayExchangePacket) {
        super(iMMICombiDisplayExchangePacket);
        this.animationInfo = new MMICombiRequestAnimationInfo();
    }

    public void setOriginalRequest(MMICombiRequest mMICombiRequest) {
        this.originalRequest = mMICombiRequest;
    }

    public MMICombiRequest getOriginalRequest() {
        return this.originalRequest;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(48);
        stringBuffer.append("MMICombiResponse {");
        stringBuffer.append(super.toString());
        stringBuffer.append(", animationInfo=");
        stringBuffer.append(this.animationInfo);
        stringBuffer.append(", kdkVisible=");
        stringBuffer.append(this.kdkVisible);
        stringBuffer.append(", kdkOpacity=");
        stringBuffer.append(this.kdkOpacity);
        stringBuffer.append(", kdkPositionInfo=");
        stringBuffer.append(this.kdkPositionInfo);
        stringBuffer.append(", barpgraphVisible=");
        stringBuffer.append(this.bargraphVisible);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public MMICombiRequestAnimationInfo getAnimationInfo() {
        return this.animationInfo;
    }

    public void setKdkVisible(boolean bl) {
        this.kdkVisible = bl;
    }

    public boolean isKDKVisible() {
        return this.kdkVisible;
    }

    public int getKDKOpacity() {
        return this.kdkOpacity;
    }

    public int getKDKPositionInfo() {
        return this.kdkPositionInfo;
    }

    public boolean isBargraphVisible() {
        return this.bargraphVisible;
    }
}

