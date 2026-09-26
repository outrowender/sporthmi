/*
 * Decompiled with CFR 0.152.
 */
package de.audi.mib.config;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.mib.config.AbstractSysConstManager;

public class SysConstManagerEvoHighScale
extends AbstractSysConstManager {
    private final boolean isScale;

    SysConstManagerEvoHighScale(IFrameworkAccess iFrameworkAccess, boolean bl) {
        super(iFrameworkAccess);
        this.isScale = bl;
    }

    @Override
    void initVariant() {
        this.setSysConstBool(4581, !this.isScale);
        if (this.isScale) {
            this.lc.log(-2137614336, "SysConstManagerEvoHighScale#initVariantG21HighScale");
            this.initVariantG21HighScale();
        } else {
            this.lc.log(-2137614336, "SysConstManagerEvoHighScale#initVariantG21High");
            super.initVariantDefault();
        }
    }

    @Override
    void rangeCheckVariant() {
        if (this.isScale) {
            this.lc.log(-2137614336, "SysConstManagerEvoHighScale#rangeCheckVariantG21HighScale");
            this.rangeCheckVariantG21HighScale();
        } else {
            this.lc.log(-2137614336, "SysConstManagerEvoHighScale#rangeCheckVariantG21High");
            super.rangeCheckVariantDefault();
        }
    }

    private void initVariantG21HighScale() {
        this.setSysConstBool(500, true);
        this.setSysConstBool(3858, true);
    }

    private void rangeCheckVariantG21HighScale() {
        this.setSysConstBool(3892, false);
        this.setSysConstBool(4159, false);
        this.setSysConst(4120, 0);
        this.setSysConstBool(4004, true);
        this.setSysConstBool(4065, true);
        this.setSysConstBool(4108, false);
        this.setSysConstBool(4249, true);
        this.setSysConstBool(4248, true);
        this.setSysConstBool(4263, true);
        this.setSysConstBool(4368, this.isHURegionNAR());
        this.setSysConstBool(4450, this.isCN());
        this.setSysConstBool(4572, true);
        this.setSysConstBool(556, false);
        this.setSysConstBool(4404, false);
        boolean bl = !this.isAsia() && this.getSysConst(442) != 1;
        this.setSysConstBool(4405, bl);
        this.setSysConst(4283, 8);
        this.setSysConst(4284, 500);
        this.setSysConstBool(4420, true);
        this.setSysConstBool(4417, true);
        this.setSysConstBool(4462, this.areOnlineServicesAvailable() && !this.isAsia());
        this.setSysConstBool(4519, true);
        this.setSysConstBool(4485, this.getSysConst(488) == 1 && !this.isHURegionNAR() && !this.isAsia());
        this.setSysConstBool(4588, this.getSysConst(488) == 1 && this.isHURegionJP());
        this.setSysConst(4633, 1);
        this.setSysConst(5541, 0);
        this.setSysConstBool(5616, false);
        this.setSysConstBool(5581, this.isCN());
    }
}

