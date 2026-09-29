/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.mer;

import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.car.common.mer.MenuEntry;
import de.audi.app.earlyfunc.evo.mer.EarlyFuncEvoMenuEntryIDs;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;

public class EarlyFuncEvoMenuEntryStructure
implements IMenuEntryStructure,
EarlyFuncEvoMenuEntryIDs {
    private final HashMap menuEntries;
    private final IFrameworkAccess framework;

    public EarlyFuncEvoMenuEntryStructure(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.framework = iFrameworkAccess;
        this.menuEntries = new HashMap();
        MenuEntry menuEntry = new MenuEntry(234, "CHARGE_THERMOMETER_ICON", -133423104, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry.getID()), menuEntry);
        MenuEntry menuEntry2 = new MenuEntry(235, "CHARGE_THERMOMETER_ICON_TIMER2", 17637376, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry2.getID()), menuEntry2);
        MenuEntry menuEntry3 = new MenuEntry(233, "CHARGE_HEAT_COIL_ICON_TIMER1", -150200320, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry3.getID()), menuEntry3);
        MenuEntry menuEntry4 = new MenuEntry(243, "CHARGE_HEAT_COIL_ICON_TIMER2", 403513344, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry4.getID()), menuEntry4);
        MenuEntry menuEntry5 = new MenuEntry(242, "CHARGE_ELECTRICAL_CLIMATE", 386736128, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry5.getID()), menuEntry5);
        MenuEntry menuEntry6 = new MenuEntry(236, "AUXAC_THERMOMETER_ICON", -116645888, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry6.getID()), menuEntry6);
        MenuEntry menuEntry7 = new MenuEntry(237, "AUXAC_THERMOMETER_ICON_TIMER2", 51191808, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry7.getID()), menuEntry7);
        MenuEntry menuEntry8 = new MenuEntry(238, "AUXAC_HEAT_COIL_ICON_TIMER1", -166977536, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry8.getID()), menuEntry8);
        MenuEntry menuEntry9 = new MenuEntry(239, "AUXAC_HEAT_COIL_ICON_TIMER2", 67969024, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry9.getID()), menuEntry9);
        MenuEntry menuEntry10 = new MenuEntry(228, "AUX_AC_IMMEDIATE_AC_TYPE_RIGHT_DRAWER", 235741184, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry10.getID()), menuEntry10);
        MenuEntry menuEntry11 = new MenuEntry(229, "AUX_AC_TIMER1_AC_TYPE_RIGHT_DRAWER", 185409536, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry11.getID()), menuEntry11);
        MenuEntry menuEntry12 = new MenuEntry(230, "AUX_AC_TIMER2_AC_TYPE_RIGHT_DRAWER", 202186752, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry12.getID()), menuEntry12);
        MenuEntry menuEntry13 = new MenuEntry(244, "AUX_AC_TIMER1_AC_RIGHT_DRAWER_PROGRAMMING", 453844992, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry13.getID()), menuEntry13);
        MenuEntry menuEntry14 = new MenuEntry(245, "AUX_AC_TIMER2_AC_RIGHT_DRAWER_PROGRAMMING", 470622208, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry14.getID()), menuEntry14);
        MenuEntry menuEntry15 = new MenuEntry(224, "AUXCOMBINED_NOW_ON", 0xD0D2000, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry15.getID()), menuEntry15);
        MenuEntry menuEntry16 = new MenuEntry(225, "AUXCOMBINED_NOW_OFF", -1391714304, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry16.getID()), menuEntry16);
        MenuEntry menuEntry17 = new MenuEntry(14, "CHARGE_TIMER_ALLOW_PARKHEATER", -1643372544, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry17.getID()), menuEntry17);
        MenuEntry menuEntry18 = new MenuEntry(246, "CHARGE_TIMER2_ALLOW_PARKHEATER", 487399424, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry18.getID()), menuEntry18);
        MenuEntry menuEntry19 = new MenuEntry(240, "CLIMATE_SYSTEM_TYPE_AUX_AC_TIMER1", 101523456, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry19.getID()), menuEntry19);
        MenuEntry menuEntry20 = new MenuEntry(241, "CLIMATE_SYSTEM_TYPE_AUX_AC_TIMER2", 84746240, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry20.getID()), menuEntry20);
        MenuEntry menuEntry21 = new MenuEntry(1005, "PARKING_SETTINGS_APS", 1678516224, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry21.getID()), menuEntry21);
        MenuEntry menuEntry22 = new MenuEntry(1002, "APS Volume Front", -2096422912, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry22.getID()), menuEntry22);
        MenuEntry menuEntry23 = new MenuEntry(1003, "APS Volume Rear", -2062868480, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry23.getID()), menuEntry23);
        MenuEntry menuEntry24 = new MenuEntry(1001, "Auto VPS View Switching", -1140121600, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry24.getID()), menuEntry24);
        MenuEntry menuEntry25 = new MenuEntry(1004, "APS_ENTERTAINMENT_LOWERING", -468901888, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry25.getID()), menuEntry25);
        menuEntry21.setChildren(new IMenuEntry[]{menuEntry22, menuEntry23, menuEntry25});
        MenuEntry menuEntry26 = new MenuEntry(1006, "PARKING_POPUP_ABORT", 1829511168, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry26.getID()), menuEntry26);
        MenuEntry menuEntry27 = new MenuEntry(1007, "PARKING_OPS_AUTO_ACTIVATION", 789389312, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry27.getID()), menuEntry27);
        MenuEntry menuEntry28 = new MenuEntry(1008, "PARKING_VPS_CAMERA_CLEANING", 1225596928, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry28.getID()), menuEntry28);
        MenuEntry menuEntry29 = new MenuEntry(11, "CHARGE_ETRON", -2129911808, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry29.getID()), menuEntry29);
        MenuEntry menuEntry30 = new MenuEntry(7, "ETRON_EV_MODE", -2062802944, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry30.getID()), menuEntry30);
        MenuEntry menuEntry31 = new MenuEntry(9, "ETRON_HYBRID_MODE", -2079580160, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry31.getID()), menuEntry31);
        MenuEntry menuEntry32 = new MenuEntry(8, "ETRON_SUSTAINING_MODE", -2113134592, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry32.getID()), menuEntry32);
        MenuEntry menuEntry33 = new MenuEntry(10, "ETRON_CHARGING_MODE", -2046025728, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry33.getID()), menuEntry33);
        menuEntry29.setChildren(new IMenuEntry[]{menuEntry30, menuEntry31, menuEntry32, menuEntry33});
        MenuEntry menuEntry34 = new MenuEntry(247, "CHARGE_TIMER1_MAIN", -2012471296, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry34.getID()), menuEntry34);
        MenuEntry menuEntry35 = new MenuEntry(248, "CHARGE_TIMER2_MAIN", -1928585216, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry35.getID()), menuEntry35);
        MenuEntry menuEntry36 = new MenuEntry(511, "CHARGE_TIMER1_GOODBYE_CONTEXT", -1794367488, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry36.getID()), menuEntry36);
        MenuEntry menuEntry37 = new MenuEntry(512, "CHARGE_TIMER2_GOODBYE_CONTEXT", -1777590272, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry37.getID()), menuEntry37);
        MenuEntry menuEntry38 = new MenuEntry(509, "CLIMATE_TIMER1", -200531968, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry38.getID()), menuEntry38);
        MenuEntry menuEntry39 = new MenuEntry(510, "CLIMATE_TIMER2", -217309184, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry39.getID()), menuEntry39);
        MenuEntry menuEntry40 = new MenuEntry(231, "AUXHEAT_TIMER1", -1744035840, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry40.getID()), menuEntry40);
        MenuEntry menuEntry41 = new MenuEntry(232, "AUXHEAT_TIMER2", -1760813056, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry41.getID()), menuEntry41);
        MenuEntry menuEntry42 = new MenuEntry(19, "AUXHEAT_NOW", -1458823168, iFrameworkAccess, logChannel);
        this.menuEntries.put(new Integer(menuEntry42.getID()), menuEntry42);
        MenuEntry menuEntry43 = new MenuEntry(226, "AUXCOOLER_NOW_ON", 0xD0D2000, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry43.getID()), menuEntry43);
        MenuEntry menuEntry44 = new MenuEntry(227, "AUXCOOLER_NOW_OFF", -1391714304, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry44.getID()), menuEntry44);
        menuEntry42.setChildren(new IMenuEntry[]{menuEntry43, menuEntry44});
        MenuEntry menuEntry45 = new MenuEntry(16, "CHARGE_CURRENTRANGE", -1593040896, this.framework, logChannel);
        this.menuEntries.put(new Integer(menuEntry45.getID()), menuEntry45);
    }

    @Override
    public HashMap getMenuEntries() {
        return this.menuEntries;
    }
}

