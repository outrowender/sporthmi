/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.HMIProperties;

public class RemoteHMIAction {
    private int myType;
    private HMIProperties myProps;

    public RemoteHMIAction(int n) {
        this.myType = n;
        this.myProps = new HMIProperties();
    }

    public int getType() {
        return this.myType;
    }

    public void setParameters(HMIProperties hMIProperties) {
        this.myProps = hMIProperties;
    }

    public HMIProperties getParameters() {
        return this.myProps;
    }

    public String toString() {
        String string = "Action: ";
        string = new StringBuffer().append(string).append(" Type: ").append(this.getType()).toString();
        string = new StringBuffer().append(string).append(this.getParameters().toString()).toString();
        return string;
    }
}

