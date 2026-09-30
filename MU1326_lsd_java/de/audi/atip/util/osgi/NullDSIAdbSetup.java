/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBase;
import org.dsi.ifc.organizer.DSIAdbSetup;

public class NullDSIAdbSetup
extends NullDSIBase
implements DSIAdbSetup {
    public NullDSIAdbSetup(LogChannel logChannel) {
        super(logChannel, "DSIAdbSetup");
    }

    public void setLanguage(String string) {
        this.log();
    }

    public void setSortOrder(int n) {
        this.log();
    }

    public void setPublicProfileVisibility(boolean bl) {
        this.log();
    }

    public void resetToFactorySettings() {
        this.log();
    }

    public void resetTopDestination() {
        this.log();
    }

    public void createBackupFile(String string) {
        this.log();
    }

    public void importBackupFile(String string) {
        this.log();
    }

    public void setPictureVisibility(boolean bl) {
        this.log();
    }

    public void setContextSpecificVisibility(boolean bl) {
        this.log();
    }
}

