/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.TMCHelper;

public class TMCTitleLineManager {
    static final int NO_ICON = 0;
    static final int TMC = 1;
    static final int NO_TMC = 2;
    static final int TMC_PRO = 3;
    static final int ONLINE_TRAFFIC = 4;
    static final int TPEG = 5;
    private int activeTrafficSource;
    private LogChannel logCh;
    private final InfoEnv env;

    public TMCTitleLineManager(LogChannel logChannel, InfoEnv infoEnv) {
        this.logCh = logChannel;
        this.env = infoEnv;
        infoEnv.getChoiceModel(410).setValue(0);
    }

    public void setActiveTrafficSource(int n) {
        this.activeTrafficSource = n;
        this.setTitleLineIconId();
    }

    protected void setTitleLineIconId() {
        if (TMCHelper.isHURegionNAR()) {
            if (this.logCh.isDebug2()) {
                this.logCh.log(100000000, "[TMCTitleLineManager#setTitleLineIconId] NAR variant.");
            }
            this.setTitleLineIconIdForNAR();
        } else {
            if (this.logCh.isDebug2()) {
                this.logCh.log(100000000, "[TMCTitleLineManager#setTitleLineIconId] European variant.");
            }
            this.setTitleLineIconIdForEurope();
        }
    }

    private void setTitleLineIconIdForEurope() {
        int n = 0;
        if (this.activeTrafficSource == 0) {
            n = 0;
        } else if (this.activeTrafficSource == 1) {
            n = 1;
        } else if (this.activeTrafficSource == 2) {
            n = 3;
        } else if (this.activeTrafficSource == 3) {
            n = 5;
        } else if (this.activeTrafficSource == 4) {
            n = 4;
        } else if (this.activeTrafficSource == 5) {
            this.logCh.log(10000, "TMCTitleLineManager#setTitleLineIconIdForEurope() unexpected provider");
        } else if (this.activeTrafficSource == 6) {
            this.logCh.log(10000, "TMCTitleLineManager#setTitleLineIconIdForEurope() unexpected provider");
        }
        this.env.getChoiceModel(410).setValue(n);
    }

    private void setTitleLineIconIdForNAR() {
        int n = 0;
        if (this.activeTrafficSource == 4) {
            n = 4;
        }
        this.env.getChoiceModel(410).setValue(n);
    }

    public void setTitleLineIconsForAsia(int n) {
        this.activeTrafficSource = n;
        int n2 = 0;
        if (this.activeTrafficSource == 0) {
            n2 = 0;
        } else if (this.activeTrafficSource == 1) {
            n2 = 1;
        } else if (this.activeTrafficSource == 2) {
            n2 = 3;
        } else if (this.activeTrafficSource == 3) {
            n2 = 5;
        } else if (this.activeTrafficSource == 4) {
            n2 = 4;
        } else if (this.activeTrafficSource == 5) {
            this.logCh.log(10000, "TMCTitleLineManager#setTitleLineIconsForAsia() unexpected provider");
        } else if (this.activeTrafficSource == 6) {
            this.logCh.log(10000, "TMCTitleLineManager#setTitleLineIconsForAsia() unexpected provider");
        }
        this.env.getChoiceModel(410).setValue(n2);
    }

    public int getTitleLineIconId() {
        return this.env.getChoiceModel(410).getValue();
    }
}

