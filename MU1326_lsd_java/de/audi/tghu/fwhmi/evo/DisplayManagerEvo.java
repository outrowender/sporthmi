/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.start.ILastmodeHandler;
import de.audi.atip.start.ILastmodeStorage;
import de.audi.tghu.fwhmi.DisplayManagerMIB2High;
import de.audi.tghu.fwhmi.IDisplayManagerKombiControl;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class DisplayManagerEvo
extends DisplayManagerMIB2High
implements IDisplayManagerKombiControl {
    public DisplayManagerEvo(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
        if (iFrameworkAccess == null) {
            this.log.log(10000, "DisplayManagerEvo#DisplayManagerEvo framework is null");
        }
    }

    protected void configureDM() {
        this.setupKDKBackground(this.getSkin(), false);
    }

    private int getSkin() {
        ILastmodeHandler iLastmodeHandler = null;
        if (this.framework != null) {
            iLastmodeHandler = this.framework.getLastmodeHandler();
        }
        ILastmodeStorage iLastmodeStorage = null;
        if (iLastmodeHandler != null) {
            iLastmodeStorage = iLastmodeHandler.getLastmodeStorage();
        }
        int n = 0;
        if (iLastmodeStorage != null) {
            n = iLastmodeStorage.getSkin();
        } else {
            this.log.log(10000, "DisplayManagerEvo#getSkin failed to retrieve either the lastmode handler or the lastmode storage");
        }
        this.log.log(1000000, "DisplayManagerEvo#getSkin skin: %1", (long)n);
        return n;
    }

    private boolean isSportSkin(int n) {
        return n == 1;
    }

    public void setupKDKBackground(int n) {
        this.setupKDKBackground(n, true);
    }

    private void setupKDKBackground(int n, boolean bl) {
        this.log.log(10000000, "DisplayManagerEvo#setupKDKBackground setting up the KDK background");
        String string = null;
        String string2 = null;
        if (this.framework != null && this.framework.getSysConst(541) == 2 && this.isAudi(this.framework)) {
            boolean bl2 = this.isA3(this.framework);
            if (bl2 || this.isB9(this.framework) || this.isQ1(this.framework) || this.isQ5(this.framework)) {
                if (this.isSportSkin(n)) {
                    this.log.log(10000000, "DisplayManagerEvo#setupKDKBackground detected a car model with a B9 Sport-compatible FPK");
                    string = this.getKDKBackgroundAbsolutePath(bl2, HMIImageConstantsSystem.kdk_background_b9_sport_small_stage);
                } else {
                    this.log.log(10000000, "DisplayManagerEvo#setupKDKBackground detected a car model with a B9-compatible FPK");
                    string = this.getKDKBackgroundAbsolutePath(bl2, HMIImageConstantsSystem.kdk_background_a4_classic_small_stage);
                }
                string2 = this.getKDKBackgroundAbsolutePath(bl2, HMIImageConstantsSystem.kdk_background_a4_classic_large_stage);
            } else if (this.isQ7(this.framework)) {
                if (this.isSportSkin(n)) {
                    this.log.log(10000000, "DisplayManagerEvo#setupKDKBackground detected a car model with a Q7 Sport-compatible FPK");
                    string = this.getKDKBackgroundAbsolutePath(HMIImageConstantsSystem.kdk_background_q7_sport_small_stage);
                } else {
                    this.log.log(10000000, "DisplayManagerEvo#setupKDKBackground detected a car model with a Q7-compatible FPK");
                    string = this.getKDKBackgroundAbsolutePath(HMIImageConstantsSystem.kdk_background_q7_classic_universal);
                }
                string2 = this.getKDKBackgroundAbsolutePath(HMIImageConstantsSystem.kdk_background_q7_classic_universal);
            }
        }
        if (string != null && string2 != null) {
            this.log.log(10000000, "DisplayManagerEvo#setupKDKBackground small stage KDK background URL: %1", string);
            this.log.log(10000000, "DisplayManagerEvo#setupKDKBackground large stage KDK background URL: %1", string2);
            this.setupKDKSmallStage(string, bl);
            this.setupKDKLargeStage(string2, bl);
        } else {
            this.log.log(10000000, "DisplayManagerEvo#setupKDKBackground failed to localize KDK backgrounds for both stage sizes; using the default method to set them up");
            super.configureDM();
        }
    }

    private boolean isAudi(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4168) == 1;
    }

    private boolean isA3(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(466) == 3 && iFrameworkAccess.getSysConst(469) == 7;
    }

    private boolean isB9(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(466) == 4 && iFrameworkAccess.getSysConst(469) == 9;
    }

    private boolean isQ1(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(466) == 2 && iFrameworkAccess.getSysConst(469) == 7 && iFrameworkAccess.getSysConst(467) == 6;
    }

    private boolean isQ5(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(466) == 4 && iFrameworkAccess.getSysConst(469) == 2 && iFrameworkAccess.getSysConst(467) == 6;
    }

    private boolean isQ7(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(466) == 7 && iFrameworkAccess.getSysConst(469) == 3;
    }

    private String getKDKBackgroundAbsolutePath(boolean bl, int n) {
        Buffer buffer = new Buffer();
        if (bl) {
            buffer.append("/mnt/app/eso/hmi/lsd/images/HMISystemEvoHighScale/");
        } else {
            buffer.append("/mnt/app/eso/hmi/lsd/images/HMISystemEvoHigh/");
        }
        buffer.append(n);
        buffer.append(".png");
        return buffer.toString();
    }

    private String getKDKBackgroundAbsolutePath(int n) {
        return this.getKDKBackgroundAbsolutePath(false, n);
    }

    private void setupKDK(int n, String string, boolean bl) {
        if (bl) {
            this.updateImageDisplayable(new ResourceLocator(n, string), n);
        } else {
            this.createImageDisplayable(new ResourceLocator(n, string), n);
        }
    }

    private void setupKDKSmallStage(String string, boolean bl) {
        this.setupKDK(101, string, bl);
    }

    private void setupKDKLargeStage(String string, boolean bl) {
        this.setupKDK(102, string, bl);
    }
}

