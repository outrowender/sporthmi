/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MediaSubEntryPointsContainer {
    private Map mediaEntryPoints = new HashMap();
    private EntryPoint currentEntryPoint;
    private final LogChannel logChannel;

    public MediaSubEntryPointsContainer(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void setCurrentEntryPoint(EntryPoint entryPoint) {
        this.logChannel.log(1078071040, "MediaSubEntryPointsContainer#setCurrentEntryPoint: current entry point id for Media is '%1'", entryPoint == null ? -1L : (long)entryPoint.getEntryPointId());
        this.currentEntryPoint = entryPoint;
    }

    public EntryPoint getCurrentEntryPoint() {
        return this.currentEntryPoint;
    }

    public EntryPoint getEntryPointByAppContext(String string) {
        this.logChannel.log(1078071040, "MediaSubEntryPointsContainer#getEntryPointById: called for entry point id '%1'", (Object)string);
        if (string == null) {
            return null;
        }
        EntryPoint entryPoint = (EntryPoint)this.mediaEntryPoints.get(string);
        return entryPoint;
    }

    public Set getEntryPoints() {
        return this.mediaEntryPoints.entrySet();
    }

    public void putEntryPoint(String string, EntryPoint entryPoint) {
        this.mediaEntryPoints.put(string, entryPoint);
    }
}

