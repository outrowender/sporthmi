/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.AbstractView;
import de.audi.tghu.navi.app.map.utils.AdvancedChoiceListener;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.math.BigInteger;

public class MapSetupView
extends AbstractView {
    public static final int ITEM_PANORAMA;
    public static final int ITEM_COLOR;
    public static final int ITEM_TYPE;
    public static final int ITEM_DISPLAY;
    public static final int ITEM_ADDITIONAL_INFO;
    public static final int ITEM_INTERSECTION;
    public static final int ITEM_AUTOZOOM;
    public static final int ITEM_MAX;
    private static final int BITMASK_ADD_INFO_ROUTEINFO;
    private static final int BITMASK_ADD_INFO_COMPLETE;
    private static final int BITMASK_ADD_INFO_TURN;
    private static final int BITMASK_ADD_INFO_OVERVIEW;
    private static final int BITMASK_ADD_INFO_ON;
    private static final int BITMASK_ADD_INFO_OFF;
    private static final int BITMASK_MAP_REPRESENTATION_STANDARD;
    private static final int BITMASK_MAP_REPRESENTATION_GOOGLE;
    private static final int BITMASK_MAP_REPRESENTATION_TRAFFIC;
    private static final int BITMASK_MAP_REPRESENTATION_RANGE;
    private final ChoiceModelApp[] models = new ChoiceModelApp[7];
    private final AdvancedChoiceListener[] listeners;

    public MapSetupView(NavigationEnv navigationEnv, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        super(navigationEnv);
        this.models[0] = bl ? navigationEnv.getChoiceModel(-1843526144) : null;
        this.models[1] = navigationEnv.getChoiceModel(-1843591680);
        this.models[2] = navigationEnv.getChoiceModel(-1726151168);
        this.models[3] = navigationEnv.getChoiceModel(1780221440);
        this.models[4] = navigationEnv.getChoiceModel(-1927477760);
        this.models[5] = bl2 ? navigationEnv.getChoiceModel(18744832) : null;
        this.models[6] = navigationEnv.getChoiceModel(-1575156224);
        int n = 0;
        if (bl5) {
            n = 8;
        }
        n = bl2 ? (bl4 ? 38 : 48) : (bl4 ? (bl3 ? 48 : 38) : 48);
        this.models[4].addHint(n);
        int n2 = 1;
        if (Util.isGoogleEarthPresent(navigationEnv.getFramework())) {
            n2 |= 2;
        }
        if (Util.isTrafficMapAvailable(navigationEnv.getFramework())) {
            n2 |= 4;
        }
        if (Util.isRangeMapDisplayPresent(navigationEnv.getFramework())) {
            n2 |= 8;
        }
        this.models[3].addHint(n2);
        this.listeners = new AdvancedChoiceListener[7];
        for (int i2 = 0; i2 < 7; ++i2) {
            if (this.models[i2] != null) {
                this.listeners[i2] = new AdvancedChoiceListener(this.getLogger());
                this.models[i2].setChoiceListener(this.listeners[i2]);
                continue;
            }
            this.listeners[i2] = null;
        }
    }

    public void addChoiceListener(int n, ChoiceListener choiceListener) {
        if (0 <= n && n <= 7 && choiceListener != null && this.listeners[n] != null) {
            this.listeners[n].addChoiceListener(choiceListener);
        }
    }

    public void addChoiceListener(int[] nArray, ChoiceListener choiceListener) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.addChoiceListener(nArray[i2], choiceListener);
        }
    }

    public int getValue(int n) {
        if (0 <= n && n <= 7 && this.models[n] != null) {
            return this.models[n].getValue();
        }
        return -1;
    }

    public void setValue(int n, int n2) {
        if (0 <= n && n <= 7 && this.models[n] != null) {
            this.models[n].setValue(n2);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < 7; ++i2) {
            buffer.append(i2).append("\n");
            if (this.listeners[i2] != null) continue;
            buffer.append("    - null");
        }
        return buffer.toString();
    }

    public void updateSetupModels(int n, int n2, int n3, int n4, int n5, int n6) {
        this.models[1].setValue(n);
        this.models[2].setValue(n2);
        this.models[3].setValue(n3);
        this.models[4].setValue(n4);
        if (this.models[5] != null) {
            this.models[5].setValue(n5);
        }
        this.models[6].setValue(n6);
    }

    public void setGoogleSettingVisible(boolean bl) {
        if (Util.isGoogleEarthPresent(this.getEnv().getFramework())) {
            int n = this.models[3].getHints();
            n = bl ? (n |= 2) : (n &= 0xFFFFFFFD);
            if (this.getLogger().isDebug2()) {
                Buffer buffer = new Buffer();
                buffer.append("RNG=").append(BigInteger.valueOf(n).testBit(3));
                buffer.append(", TFC=").append(BigInteger.valueOf(n).testBit(2));
                buffer.append(", GEC=").append(BigInteger.valueOf(n).testBit(1));
                buffer.append(", STD=").append(BigInteger.valueOf(n).testBit(0));
                this.getLogger().log(14808325, "MapSetupView#setGoogleSettingVisible(%1) - %2 -> %3 (%4)", (Object)bl, (Object)Integer.toBinaryString(this.models[3].getHints()), (Object)Integer.toBinaryString(n), (Object)buffer);
            }
            this.models[3].resetHints();
            this.models[3].addHint(n);
            this.models[3].publishHints();
        }
    }
}

