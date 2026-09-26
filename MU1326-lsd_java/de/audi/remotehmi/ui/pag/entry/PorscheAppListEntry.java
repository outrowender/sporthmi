/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag.entry;

import de.audi.remotehmi.IRemoteHMILicense;
import de.audi.remotehmi.ui.pag.entry.PorscheGenericEntry;
import de.audi.remotehmi.util.DeepCloneable;
import de.esolutions.fw.util.commons.Buffer;

public final class PorscheAppListEntry
implements DeepCloneable,
PorscheGenericEntry {
    public static final int APP_STATE_NORMAL;
    public static final int APP_STATE_GREY;
    private static int count;
    public static final String ENTRY_POINT_MEDIA;
    public static final String ENTRY_POINT_PHONE_MSG;
    public static final String ENTRY_POINT_NAVI_FAV;
    public final int id;
    public int entryPointId;
    public final String context;
    public final String name;
    public String imageLocalPath;
    public boolean isLoginRequired = false;
    public IRemoteHMILicense license;
    public boolean hasActivatedLicense;
    public String entryPoint = null;
    public int type;
    public String serviceId;
    private int app_state = 0;

    public PorscheAppListEntry(String string, String string2, String string3, int n) {
        this.id = count++;
        this.context = string;
        this.name = string2;
        this.imageLocalPath = string3;
        this.entryPointId = n;
    }

    public PorscheAppListEntry(PorscheAppListEntry porscheAppListEntry) {
        this.context = porscheAppListEntry.context;
        this.id = porscheAppListEntry.id;
        this.name = porscheAppListEntry.name;
        this.imageLocalPath = porscheAppListEntry.imageLocalPath;
        this.isLoginRequired = porscheAppListEntry.isLoginRequired;
        this.license = porscheAppListEntry.license;
        this.hasActivatedLicense = porscheAppListEntry.hasActivatedLicense;
        this.entryPoint = porscheAppListEntry.entryPoint;
        this.type = porscheAppListEntry.type;
        this.entryPointId = porscheAppListEntry.entryPointId;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("PorscheAppListEntry[");
        buffer.append(" context: ").append(this.context);
        buffer.append(" name:").append(this.name);
        buffer.append(" needsLogin: ").append(this.isLoginRequired);
        buffer.append(" license: ").append(this.license);
        buffer.append(" hasActivatedLicense: ").append(this.hasActivatedLicense);
        buffer.append(" entryPoint: ").append(this.entryPoint);
        buffer.append(" imageLocalPath: ").append(this.imageLocalPath);
        buffer.append("]");
        return buffer.toString();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.context == null ? 0 : this.context.hashCode());
        n = 31 * n + (this.imageLocalPath == null ? 0 : this.imageLocalPath.hashCode());
        n = 31 * n + (this.name == null ? 0 : this.name.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof PorscheAppListEntry) {
            PorscheAppListEntry porscheAppListEntry = (PorscheAppListEntry)object;
            return this.context.equals(porscheAppListEntry.context);
        }
        if (object instanceof String) {
            String string = (String)object;
            return this.context.equals(string);
        }
        return false;
    }

    @Override
    public Object clone(boolean bl) {
        if (bl) {
            PorscheAppListEntry porscheAppListEntry = new PorscheAppListEntry(this);
            porscheAppListEntry.isLoginRequired = this.isLoginRequired;
            return porscheAppListEntry;
        }
        return this;
    }

    @Override
    public String getFirstImagePath() {
        return this.imageLocalPath;
    }

    @Override
    public void setFirstImagePath(String string) {
        this.imageLocalPath = string;
    }

    @Override
    public String getSecondImagePath() {
        return null;
    }

    @Override
    public void setSecondImagePath(String string) {
    }

    @Override
    public boolean isSecondImageAvailable() {
        return false;
    }

    @Override
    public void setContextName(String string) {
    }

    @Override
    public String getContextName() {
        return this.context;
    }

    public boolean setAppState(int n) {
        boolean bl = false;
        if (n != this.app_state) {
            this.app_state = n;
            bl = true;
        }
        return bl;
    }

    public int getAppState() {
        return this.app_state;
    }
}

