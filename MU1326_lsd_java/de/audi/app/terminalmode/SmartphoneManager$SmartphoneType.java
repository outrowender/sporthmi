/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.util.Enum;

public class SmartphoneManager$SmartphoneType
extends Enum {
    public static final SmartphoneManager$SmartphoneType CARPLAY = new SmartphoneManager$SmartphoneType(1, "CARPLAY");
    public static final SmartphoneManager$SmartphoneType ANDROIDAUTO2 = new SmartphoneManager$SmartphoneType(2, "ANDROIDAUTO2");
    public static final SmartphoneManager$SmartphoneType CARLIFE = new SmartphoneManager$SmartphoneType(3, "CARLIFE");
    public static final SmartphoneManager$SmartphoneType UNKNOWN = new SmartphoneManager$SmartphoneType(0, "UNKNOWN");

    private SmartphoneManager$SmartphoneType(int n, String string) {
        super(n, string);
    }

    public static SmartphoneManager$SmartphoneType valueOf(String string) {
        return (SmartphoneManager$SmartphoneType)(SmartphoneManager.class$de$audi$app$terminalmode$SmartphoneManager$SmartphoneType == null ? (SmartphoneManager.class$de$audi$app$terminalmode$SmartphoneManager$SmartphoneType = SmartphoneManager.class$("de.audi.app.terminalmode.SmartphoneManager$SmartphoneType")) : SmartphoneManager.class$de$audi$app$terminalmode$SmartphoneManager$SmartphoneType).getField(string).get(null);
    }
}

