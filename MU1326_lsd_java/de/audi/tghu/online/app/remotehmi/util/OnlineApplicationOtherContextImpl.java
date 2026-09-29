/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.util;

import de.audi.atip.interapp.online.OnlineApplicationOtherContext;
import de.audi.remotehmi.ui.mib2.IExternalService;
import de.esolutions.fw.util.commons.Buffer;

public class OnlineApplicationOtherContextImpl
implements OnlineApplicationOtherContext {
    private final String appName;
    private final String appContext;
    private String sourceListIconActive;
    private String sourceListIconInactive;
    private String captionIcon;
    private String loadingIcon;
    private String sourceListIconReflection;
    private boolean isEnabled;
    private String appDescription;
    private int entryPointId;
    private String subEntryPoint;

    public OnlineApplicationOtherContextImpl(IExternalService iExternalService) {
        this.appName = iExternalService.getEntryName();
        this.appContext = iExternalService.getEntryContext();
        this.subEntryPoint = iExternalService.getSubEntryPoint();
        this.setEnabled(iExternalService.isEnabled());
        this.setSourceListIconActive(iExternalService.getIcon());
        this.setSourceListIconInactive(iExternalService.getInactiveIconLocalUrl());
        this.setSourceListIconReflection(iExternalService.getReflectionIcon());
        this.setCaptionIcon(iExternalService.getCaptionIconLocalUrl());
        this.setLoadingIcon(iExternalService.getLoadingIconLocalUrl());
        this.setAppDescription(iExternalService.getEntryDescription());
        this.setEntryPointId(iExternalService.getEntryPointId());
    }

    @Override
    public String getAppName() {
        return this.appName;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean bl) {
        this.isEnabled = bl;
    }

    @Override
    public String getAppContext() {
        return this.appContext;
    }

    @Override
    public String getSourceListIconActive() {
        return this.sourceListIconActive;
    }

    public void setSourceListIconActive(String string) {
        this.sourceListIconActive = string;
    }

    @Override
    public String getSourceListIconInactive() {
        return this.sourceListIconInactive;
    }

    public void setSourceListIconInactive(String string) {
        this.sourceListIconInactive = string;
    }

    @Override
    public String getCaptionIcon() {
        return this.captionIcon;
    }

    public void setCaptionIcon(String string) {
        this.captionIcon = string;
    }

    @Override
    public String getLoadingIcon() {
        return this.loadingIcon;
    }

    public void setLoadingIcon(String string) {
        this.loadingIcon = string;
    }

    @Override
    public String getSourceListIconReflection() {
        return this.sourceListIconReflection;
    }

    public void setSourceListIconReflection(String string) {
        this.sourceListIconReflection = string;
    }

    public String getAppDescription() {
        return this.appDescription;
    }

    public void setAppDescription(String string) {
        this.appDescription = string;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof OnlineApplicationOtherContextImpl)) {
            return false;
        }
        OnlineApplicationOtherContextImpl onlineApplicationOtherContextImpl = (OnlineApplicationOtherContextImpl)object;
        boolean bl = onlineApplicationOtherContextImpl.isEnabled();
        String string = onlineApplicationOtherContextImpl.getAppName();
        String string2 = onlineApplicationOtherContextImpl.getAppContext();
        return string.equals(this.appName) && string2.equals(this.appContext) && bl == this.isEnabled;
    }

    public String toString() {
        Buffer buffer = new Buffer(300);
        buffer.append("Application name: ").append(this.getAppName()).append(", Application context: ").append(this.getAppContext());
        buffer.append("\nSourceListIconActive: ").append(this.getSourceListIconActive());
        buffer.append("\nSourceListIconInactive: ").append(this.getSourceListIconInactive());
        buffer.append("\nCaptionIcon: ").append(this.getCaptionIcon());
        buffer.append("\nLoadingIcon: ").append(this.getLoadingIcon());
        buffer.append("\nSourceListIconReflection: ").append(this.getSourceListIconReflection());
        return buffer.toString();
    }

    public void setEntryPointId(int n) {
        this.entryPointId = n;
    }

    @Override
    public int getEntryPointId() {
        return this.entryPointId;
    }

    public void setSubntryPoint(String string) {
        this.subEntryPoint = string;
    }

    @Override
    public String getSubEntryPoint() {
        return this.subEntryPoint;
    }
}

