/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.onlinelogo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.onlinelogo.OnlineLogoItem$OnlineLogoIOWrapper;
import de.audi.atip.onlinelogo.OnlineLogoItem$OnlineLogoIOWrapperImpl;
import java.io.File;

public class OnlineLogoItem {
    private final HMIModelApp model;
    private final String path;
    private String checksum = null;
    private final LogChannel logChannel;
    private OnlineLogoItem$OnlineLogoIOWrapper ioWrapper;
    private final String defaultPath;
    private final IFrameworkAccess frameworkAccess;

    public OnlineLogoItem(LogChannel logChannel, HMIModelApp hMIModelApp, String string, String string2, IFrameworkAccess iFrameworkAccess) {
        this.logChannel = logChannel;
        this.model = hMIModelApp;
        this.path = string;
        this.defaultPath = string2;
        this.ioWrapper = new OnlineLogoItem$OnlineLogoIOWrapperImpl(null);
        this.frameworkAccess = iFrameworkAccess;
        this.updateModelPath();
        logChannel.log(1078071040, "OnlineLogoItem#OnlineLogoItem(): called with path = %1, default path = %2", (Object)this.path, (Object)this.defaultPath);
    }

    private void updateModelPath() {
        String string = this.path;
        File file = new File(string);
        if (!file.exists()) {
            string = this.defaultPath;
        }
        this.logChannel.log(1078071040, "OnlineLogoItem#updateModelPath: %1", (Object)string);
        if (this.model != null) {
            if (this.model instanceof LabelModelApp) {
                ((LabelModelApp)this.model).setText(string);
            } else if (this.model instanceof ResourceLocatorModelApp) {
                ((ResourceLocatorModelApp)this.model).setResourceLocator(-1, string);
            }
        }
    }

    public void update(String string, String string2) {
        this.logChannel.log(1078071040, new StringBuffer().append("OnlineLogoItem#update() ").append(string).append(" checksum:").append(string2).toString());
        if (string2 == null || string == null) {
            this.deleteDownloadedFile();
            this.updateModelPath();
        } else {
            if (this.frameworkAccess.getOnlineLogoProvider() == null) {
                this.logChannel.log(10000, "OnlineLogoItem#update(): no online logo provider available");
                return;
            }
            if (this.checksum == null) {
                this.checksum = this.computeChecksum(this.path);
                this.logChannel.log(1078071040, "OnlineLogoItem#update(): computing checksum");
            }
            if (this.checksum == null || !this.checksum.equals(string2)) {
                this.logChannel.log(1078071040, "OnlineLogoItem#update(): checksums do not match, computed is %1, provided is %2", (Object)this.checksum, (Object)string2);
                this.frameworkAccess.getOnlineLogoProvider().downloadLogoItem(string, this.path, this);
            }
        }
    }

    public void computeAndSetChecksum() {
        this.checksum = this.computeChecksum(this.path);
    }

    private void deleteDownloadedFile() {
        File file;
        if (this.path != null && this.defaultPath != null && !this.path.equals(this.defaultPath) && (file = new File(this.path)).exists()) {
            this.logChannel.log(1078071040, "OnlineLogoItem#deleteDownloadedFile: deleting file %1", (Object)this.path);
            try {
                if (!file.delete()) {
                    this.logChannel.log(-1601830656, "OnlineLogoItem#deleteDownloadedFile: file could not be deleted");
                }
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "OnlineLogoItem#deleteDownloadedFile: exception %1", (Throwable)exception);
            }
        }
    }

    private String computeChecksum(String string) {
        if (this.ioWrapper != null) {
            return this.ioWrapper.computeChecksum(string);
        }
        return "";
    }

    public void updateFinished() {
        this.logChannel.log(1078071040, "OnlineLogoItem: Logo update finished");
        this.updateModelPath();
    }

    public void setVisible(boolean bl) {
        this.logChannel.log(-2137614336, new StringBuffer().append("OnlineLogoItem#setVisible() image: ").append(this.path).append(" visibility: ").append(bl).toString());
        this.model.setStatus(bl ? 0 : 2);
    }
}

