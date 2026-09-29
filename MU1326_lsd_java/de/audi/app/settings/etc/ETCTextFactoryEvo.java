/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.etc.AbstractETCTextFactory;

public class ETCTextFactoryEvo
extends AbstractETCTextFactory {
    @Override
    public String getYenSymbol() {
        return this.getI18nText(-120778752);
    }

    @Override
    public String getErrorMessageText(int n) {
        switch (n) {
            case 0: {
                return this.getI18nText(953028608);
            }
            case 2: {
                return this.getI18nText(969805824);
            }
            case 3: {
                return this.getI18nText(986583040);
            }
            case 4: {
                return this.getI18nText(1003360256);
            }
            case 5: {
                return this.getI18nText(1020137472);
            }
            case 6: {
                return this.getI18nText(1036914688);
            }
            case 7: {
                return this.getI18nText(1053691904);
            }
            case 8: {
                return this.getI18nText(1070469120);
            }
            case 9: {
                return this.getI18nText(1087246336);
            }
            case 10: {
                return this.getI18nText(1104023552);
            }
            case 11: {
                return this.getI18nText(1120800768);
            }
            case 12: {
                return this.getI18nText(1137577984);
            }
            case 13: {
                return this.getI18nText(1154355200);
            }
            case 14: {
                return this.getI18nText(1171132416);
            }
        }
        return "";
    }

    @Override
    public String getWarningMessageCardInsertedText(boolean bl) {
        if (bl) {
            return this.getI18nText(1020137472);
        }
        return this.getI18nText(1187909632);
    }

    @Override
    public String getTollInfoText(boolean bl, boolean bl2) {
        if (bl) {
            if (bl2) {
                return this.getI18nText(1255018496);
            }
            return this.getI18nText(1238241280);
        }
        if (bl2) {
            return this.getI18nText(1221464064);
        }
        return this.getI18nText(1204686848);
    }
}

