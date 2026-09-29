/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.statemachine.AbstractStateChange;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.esolutions.fw.util.commons.Buffer;

public class ApplicationStateChange
extends AbstractStateChange {
    private Application applicationId;
    private ApplicationOwner oldOwner;
    private ApplicationOwner newOwner;

    public ApplicationStateChange(Application application, ApplicationOwner applicationOwner, ApplicationOwner applicationOwner2) {
        super(APPLICATION);
        this.applicationId = application;
        this.oldOwner = applicationOwner;
        this.newOwner = applicationOwner2;
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + this.applicationId.ordinal();
        n = 31 * n + this.newOwner.ordinal();
        n = 31 * n + this.oldOwner.ordinal();
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ApplicationStateChange applicationStateChange = (ApplicationStateChange)object;
        if (this.applicationId != applicationStateChange.applicationId) {
            return false;
        }
        if (this.newOwner != applicationStateChange.newOwner) {
            return false;
        }
        return this.oldOwner == applicationStateChange.oldOwner;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("[ApplicationOwnerChange application='");
        buffer.append(this.applicationId);
        buffer.append("' oldOwner='");
        buffer.append(this.oldOwner);
        buffer.append("' newOwner='");
        buffer.append(this.newOwner);
        buffer.append("']");
        return buffer.toString();
    }
}

