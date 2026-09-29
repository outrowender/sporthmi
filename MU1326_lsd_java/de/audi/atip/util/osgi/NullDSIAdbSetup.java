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

    @Override
    public void setLanguage(String string) {
        this.log();
    }

    @Override
    public void setSortOrder(int n) {
        this.log();
    }

    @Override
    public void setPublicProfileVisibility(boolean bl) {
        this.log();
    }

    @Override
    public void resetToFactorySettings() {
        this.log();
    }

    @Override
    public void resetTopDestination() {
        this.log();
    }

    @Override
    public void createBackupFile(String string) {
        this.log();
    }

    @Override
    public void importBackupFile(String string) {
        this.log();
    }

    @Override
    public void setPictureVisibility(boolean bl) {
        this.log();
    }

    @Override
    public void setContextSpecificVisibility(boolean bl) {
        this.log();
    }
}

