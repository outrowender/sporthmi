/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.screen;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.screen.AbstractTelPopupHandler;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.lang.reflect.Field;

public class TelEvoPopupHandler
extends AbstractTelPopupHandler {
    private static final SimpleIntObjectMap popupNameMap = new SimpleIntObjectMap();
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIPopUpsPhone;

    public TelEvoPopupHandler(ITelApplication iTelApplication, int n) {
        super(iTelApplication, n);
    }

    public TelEvoPopupHandler(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string, n);
    }

    protected String getPopupName(int n) {
        return (String)popupNameMap.get(n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        Field[] fieldArray = (class$de$audi$atip$hmi$HMIPopUpsPhone == null ? (class$de$audi$atip$hmi$HMIPopUpsPhone = TelEvoPopupHandler.class$("de.audi.atip.hmi.HMIPopUpsPhone")) : class$de$audi$atip$hmi$HMIPopUpsPhone).getFields();
        if (fieldArray != null) {
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                try {
                    popupNameMap.add(fieldArray[i2].getInt(null), fieldArray[i2].getName());
                    continue;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    illegalArgumentException.printStackTrace();
                    continue;
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
        }
    }
}

