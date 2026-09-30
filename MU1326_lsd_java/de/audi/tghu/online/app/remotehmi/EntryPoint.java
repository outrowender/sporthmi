/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.MediaSubEntryPointsContainer;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;

public class EntryPoint {
    public static final int ENTRY_POINT_ID_NONE = -1;
    public static final int ENTRY_POINT_AUDI_CONNECT = 1;
    public static final int ENTRY_POINT_DESTINATION = 2;
    public static final int ENTRY_POINT_MAP = 3;
    public static final int ENTRY_POINT_MEDIA = 4;
    public static final int ENTRY_POINT_OPERATOR = 5;
    public static final int ENTRY_POINT_PHONE = 6;
    public static final int ENTRY_POINT_MEDIA_SUBENTRIES_RANGE = 10;
    private int appStatus = 0;
    private RemoteHMIContext currentContext;
    private String nameOfContextToBeStarted;
    private final int entryPointId;
    private final LogChannel logChannel;
    private MediaSubEntryPointsContainer subEntryPointContainer;

    public EntryPoint(int n, LogChannel logChannel) {
        this.entryPointId = n;
        this.logChannel = logChannel;
    }

    public RemoteHMIContext getCurrentContext() {
        return this.currentContext;
    }

    public void setCurrentContext(RemoteHMIContext remoteHMIContext) {
        this.logChannel.log(1000000, "EntryPoint#setCurrentContext: called for context %1", (Object)remoteHMIContext);
        this.currentContext = remoteHMIContext;
    }

    public int getEntryPointId() {
        return this.entryPointId;
    }

    public int getAppStatus() {
        return this.appStatus;
    }

    public void setAppStatus(int n) {
        this.appStatus = n;
    }

    public MediaSubEntryPointsContainer getSubEntryPointContainer() {
        return this.subEntryPointContainer;
    }

    public void setSubEntryPointContainer(MediaSubEntryPointsContainer mediaSubEntryPointsContainer) {
        this.subEntryPointContainer = mediaSubEntryPointsContainer;
    }

    public String getNameOfContextToBeStarted() {
        return this.nameOfContextToBeStarted;
    }

    public void setNameOfContextToBeStarted(String string) {
        this.nameOfContextToBeStarted = string;
    }
}

