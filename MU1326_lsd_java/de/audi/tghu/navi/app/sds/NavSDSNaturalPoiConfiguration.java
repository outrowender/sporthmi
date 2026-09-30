/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.util.Util;

public class NavSDSNaturalPoiConfiguration {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public int getTranslatedCategoryForNaturalPoi(int n, NavigationEnv navigationEnv) {
        int n2;
        if (Util.isHURegionEU()) {
            n2 = this.translateSDSCategoryToNaviCategoryForEU(n);
        } else if (Util.isHURegionNAR()) {
            n2 = this.translateSDSCategoryToNaviCategoryForNAR(n);
        } else if (Util.isHURegionCN() || Util.isHURegionTW()) {
            n2 = this.translateSDSCategoryToNaviCategoryForCN(n);
        } else if (Util.isHURegionJP()) {
            n2 = this.translateSDSCategoryToNaviCategoryForJP(n);
        } else if (Util.isHURegionKR()) {
            n2 = this.translateSDSCategoryToNaviCategoryForKR(n);
        } else if (Util.isHURegionRdW()) {
            n2 = this.translateSDSCategoryToNaviCategoryForRDW(n);
        } else {
            navigationEnv.getSDSLogChannel().log(10000, "%1#getTranslatedCategoryForNaturalPoi - no valid HU Region found. Returning default mapping.", (Object)this.CLASS_NAME);
            n2 = this.translateSDSCategoryToNaviCategoryForEU(n);
        }
        navigationEnv.getSDSLogChannel().log(10000000, "%1#getTranslatedCategoryForNaturalPoi - matchedCategory=%2", (Object)this.CLASS_NAME, (long)n2);
        return n2;
    }

    private int translateSDSCategoryToNaviCategoryForEU(int n) {
        switch (n) {
            case 2: {
                return 104;
            }
            case 1: {
                return 101;
            }
            case 3: {
                return 103;
            }
            case 4: {
                return 19;
            }
            case 5: {
                return 128;
            }
        }
        return -1;
    }

    private int translateSDSCategoryToNaviCategoryForNAR(int n) {
        switch (n) {
            case 2: {
                return 104;
            }
            case 1: {
                return 101;
            }
            case 3: {
                return 103;
            }
            case 4: {
                return 19;
            }
            case 5: {
                return 128;
            }
        }
        return -1;
    }

    private int translateSDSCategoryToNaviCategoryForCN(int n) {
        if (this.isCarCurrentlyOnAMotorway()) {
            return this.getCategoryMappingForMotorway(n);
        }
        switch (n) {
            case 2: {
                return 104;
            }
            case 1: {
                return 101;
            }
            case 3: {
                return 102;
            }
            case 4: {
                return 101;
            }
            case 5: {
                return 128;
            }
        }
        return -1;
    }

    private int translateSDSCategoryToNaviCategoryForJP(int n) {
        if (this.isCarCurrentlyOnAMotorway()) {
            return this.getCategoryMappingForMotorway(n);
        }
        switch (n) {
            case 2: {
                return 104;
            }
            case 1: {
                return 101;
            }
            case 3: {
                return 113;
            }
            case 4: {
                return 113;
            }
            case 5: {
                return 128;
            }
        }
        return -1;
    }

    private int translateSDSCategoryToNaviCategoryForKR(int n) {
        if (this.isCarCurrentlyOnAMotorway()) {
            return this.getCategoryMappingForMotorway(n);
        }
        switch (n) {
            case 2: {
                return 104;
            }
            case 1: {
                return 101;
            }
            case 3: {
                return 102;
            }
            case 4: {
                return 101;
            }
            case 5: {
                return 128;
            }
        }
        return -1;
    }

    private int translateSDSCategoryToNaviCategoryForRDW(int n) {
        return this.translateSDSCategoryToNaviCategoryForEU(n);
    }

    private int getCategoryMappingForMotorway(int n) {
        switch (n) {
            case 2: {
                return 103;
            }
            case 1: {
                return 101;
            }
            case 3: {
                return 103;
            }
            case 4: {
                return 103;
            }
            case 5: {
                return 128;
            }
        }
        return -1;
    }

    private boolean isCarCurrentlyOnAMotorway() {
        return Vehicle.getInstance().getPosition().getRoadClass() == 1;
    }
}

