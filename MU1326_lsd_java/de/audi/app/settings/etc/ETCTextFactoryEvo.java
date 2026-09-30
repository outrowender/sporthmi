/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.etc.AbstractETCTextFactory;

public class ETCTextFactoryEvo
extends AbstractETCTextFactory {
    public String getYenSymbol() {
        return this.getI18nText(1101304);
    }

    public String getErrorMessageText(int n) {
        switch (n) {
            case 0: {
                return this.getI18nText(1101368);
            }
            case 2: {
                return this.getI18nText(1101369);
            }
            case 3: {
                return this.getI18nText(1101370);
            }
            case 4: {
                return this.getI18nText(1101371);
            }
            case 5: {
                return this.getI18nText(1101372);
            }
            case 6: {
                return this.getI18nText(1101373);
            }
            case 7: {
                return this.getI18nText(1101374);
            }
            case 8: {
                return this.getI18nText(1101375);
            }
            case 9: {
                return this.getI18nText(1101376);
            }
            case 10: {
                return this.getI18nText(1101377);
            }
            case 11: {
                return this.getI18nText(1101378);
            }
            case 12: {
                return this.getI18nText(1101379);
            }
            case 13: {
                return this.getI18nText(1101380);
            }
            case 14: {
                return this.getI18nText(1101381);
            }
        }
        return "";
    }

    public String getWarningMessageCardInsertedText(boolean bl) {
        if (bl) {
            return this.getI18nText(1101372);
        }
        return this.getI18nText(1101382);
    }

    public String getTollInfoText(boolean bl, boolean bl2) {
        if (bl) {
            if (bl2) {
                return this.getI18nText(1101386);
            }
            return this.getI18nText(1101385);
        }
        if (bl2) {
            return this.getI18nText(1101384);
        }
        return this.getI18nText(1101383);
    }
}

