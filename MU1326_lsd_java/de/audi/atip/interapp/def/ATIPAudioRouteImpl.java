/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.ATIPAudioRoute;

public class ATIPAudioRouteImpl
implements ATIPAudioRoute {
    public int routingInput;
    public int routingOutput;
    public int routeStatus;

    public boolean equals(Object object) {
        if (object instanceof ATIPAudioRouteImpl) {
            ATIPAudioRouteImpl aTIPAudioRouteImpl = (ATIPAudioRouteImpl)object;
            if (aTIPAudioRouteImpl.routingInput == this.routingInput && aTIPAudioRouteImpl.routingOutput == this.routingOutput && aTIPAudioRouteImpl.routeStatus == this.routeStatus) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.routeStatus;
        n = 31 * n + this.routingInput;
        n = 31 * n + this.routingOutput;
        return n;
    }

    public ATIPAudioRouteImpl() {
        this.routingInput = 0;
        this.routingOutput = 0;
        this.routeStatus = 0;
    }

    public ATIPAudioRouteImpl(int n, int n2, int n3) {
        this.routingInput = n;
        this.routingOutput = n2;
        this.routeStatus = n3;
    }

    public int getRoutingInput() {
        return this.routingInput;
    }

    public int getRoutingOutput() {
        return this.routingOutput;
    }

    public int getRouteStatus() {
        return this.routeStatus;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("AudioRoute");
        stringBuffer.append('(');
        stringBuffer.append("routingInput");
        stringBuffer.append('=');
        stringBuffer.append(this.routingInput);
        stringBuffer.append(',');
        stringBuffer.append("routingOutput");
        stringBuffer.append('=');
        stringBuffer.append(this.routingOutput);
        stringBuffer.append(',');
        stringBuffer.append("routeStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.routeStatus);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

