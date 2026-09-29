/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.scxml.Status;

public class Step {
    private Collection externalEvents;
    private Status beforeStatus;
    private Status afterStatus;
    private List exitList;
    private List entryList;
    private List transitList;

    public Step() {
        this.externalEvents = new ArrayList();
        this.beforeStatus = new Status();
        this.afterStatus = new Status();
        this.exitList = new ArrayList();
        this.entryList = new ArrayList();
        this.transitList = new ArrayList();
    }

    public Step(Collection collection, Status status) {
        this.externalEvents = collection != null ? collection : new ArrayList();
        this.beforeStatus = status != null ? status : new Status();
        this.afterStatus = new Status();
        this.exitList = new ArrayList();
        this.entryList = new ArrayList();
        this.transitList = new ArrayList();
    }

    public Status getAfterStatus() {
        return this.afterStatus;
    }

    public void setAfterStatus(Status status) {
        this.afterStatus = status;
    }

    public Status getBeforeStatus() {
        return this.beforeStatus;
    }

    public void setBeforeStatus(Status status) {
        this.beforeStatus = status;
    }

    public List getEntryList() {
        return this.entryList;
    }

    public List getExitList() {
        return this.exitList;
    }

    public Collection getExternalEvents() {
        return this.externalEvents;
    }

    public List getTransitList() {
        return this.transitList;
    }
}

