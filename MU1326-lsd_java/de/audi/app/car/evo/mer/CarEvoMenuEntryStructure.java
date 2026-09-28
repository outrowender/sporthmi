/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.mer;

import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.car.common.mer.IncludeMenuEntry;
import de.audi.app.car.common.mer.MenuEntry;
import de.audi.app.car.common.mer.MenuEntryPersistence;
import de.audi.app.car.common.mer.SlotMenuEntry;
import de.audi.app.car.evo.mer.CarEvoMenuEntryIDs;
import de.audi.app.car.evo.mer.EvoMenuEntryFactory;
import de.audi.app.car.evo.mer.MenuEntryMMICombi;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import java.util.HashMap;

public class CarEvoMenuEntryStructure
implements IMenuEntryStructure,
CarEvoMenuEntryIDs {
    private /*final*/ HashMap menuEntries;
    private /*final*/ IFrameworkAccess framework;
    private /*final*/ EvoMenuEntryFactory entryFactory;

    public CarEvoMenuEntryStructure(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, CarFuncAdap carFuncAdap) {
        MenuEntry menuEntry;
        this.framework = iFrameworkAccess;
        this.menuEntries = new HashMap();
        this.entryFactory = new EvoMenuEntryFactory(iFrameworkAccess, logChannel, this.menuEntries);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(1596459264, "CAR_FUNC_CHARISMA", -282457856);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(1630013696, "CAR_FUNC_SETTINGS", -1305802496);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(1646790912, "CAR_FUNC_DRIVE_ASSIST", -1339356928);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(1663568128, "CAR_FUNC_AIR_CONDITION", -1389688576);
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(1680345344, "CAR_FUNC_AUXHEAT", -1356134144);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(10, "CAR_FUNC_AUX_AC)", -1372911360);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(11, "CAR_FUNC_AUX_COMBINED)", 1210976512);
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(1713899776, "CAR_FUNC_SERVICE", -1322579712);
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(1177094400, "CAR_FUNC_BORDBOOK", 1412172032);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(640289024, "CAR_FUNC_CHARGE", -1842607872);
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(-383121152, "CAR_FUNC_STATISTICS", -349370112);
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(12, "CAR_FUNC_SPORT", 120588544);
        if (this.framework.getKombiType() == 4) {
            menuEntry = this.entryFactory.createMMICombiMenuEntry(507, "CAR_FUNC_CHARISMA_COMBI", 11);
            MenuEntryMMICombi menuEntryMMICombi = this.entryFactory.createMMICombiMenuEntry(501, "CAR_FUNC_SETTINGS_COMBI", 7);
            MenuEntryMMICombi menuEntryMMICombi2 = this.entryFactory.createMMICombiMenuEntry(503, "CAR_FUNC_DRIVE_ASSIST_COMBI", 0);
            MenuEntryMMICombi menuEntryMMICombi3 = this.entryFactory.createMMICombiMenuEntry(508, "CAR_FUNC_AIR_CONDITION_COMBI", 6);
            MenuEntryMMICombi menuEntryMMICombi4 = this.entryFactory.createMMICombiMenuEntry(504, "CAR_FUNC_AUXHEAT_COMBI", 5);
            MenuEntryMMICombi menuEntryMMICombi5 = this.entryFactory.createMMICombiMenuEntry(505, "CAR_FUNC_AUX_AC_COMBI", 10);
            MenuEntryMMICombi menuEntryMMICombi6 = this.entryFactory.createMMICombiMenuEntry(502, "CAR_FUNC_SERVICE_COMBI", 4);
            MenuEntryMMICombi menuEntryMMICombi7 = this.entryFactory.createMMICombiMenuEntry(509, "CAR_FUNC_BORDBOOK_COMBI", 12);
            MenuEntryMMICombi menuEntryMMICombi8 = this.entryFactory.createMMICombiMenuEntry(510, "CAR_FUNC_STATISTICS_COMBI", 9);
            menuEntry.setChildren(new IMenuEntry[]{menuEntry2});
            menuEntryMMICombi.setChildren(new IMenuEntry[]{menuEntry3});
            menuEntryMMICombi2.setChildren(new IMenuEntry[]{menuEntry4});
            menuEntryMMICombi3.setChildren(new IMenuEntry[]{menuEntry5});
            menuEntryMMICombi4.setChildren(new IMenuEntry[]{menuEntry6});
            menuEntryMMICombi5.setChildren(new IMenuEntry[]{menuEntry7});
            menuEntryMMICombi6.setChildren(new IMenuEntry[]{menuEntry9});
            menuEntryMMICombi7.setChildren(new IMenuEntry[]{menuEntry10});
            menuEntryMMICombi8.setChildren(new IMenuEntry[]{menuEntry12});
        } else {
            menuEntry = this.entryFactory.createMenuEntry(1, "CAR_MAIN", -987100928);
            menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4, menuEntry5, menuEntry6, menuEntry7, menuEntry8, menuEntry9, menuEntry10, menuEntry11, menuEntry12, menuEntry13});
        }
        menuEntry11.setChildren(this.buildMenuCharge(logChannel));
        menuEntry2.setChildren(this.buildMenuCharisma(logChannel));
        menuEntry3.setChildren(this.buildMenuSettings(logChannel));
        menuEntry4.setChildren(this.buildMenuDriveAssist(logChannel));
        menuEntry5.setChildren(this.buildMenuAirCondition(logChannel));
        menuEntry13.setChildren(this.buildMenuSport(logChannel));
        boolean bl = carFuncAdap.isMenuDisplayActivated((short)9);
        boolean bl2 = carFuncAdap.isMenuDisplayActivated((short)46);
        if (bl) {
            if (bl2) {
                menuEntry8.setChildren(this.buildMenuAuxAC(logChannel));
            } else {
                menuEntry6.setChildren(this.buildMenuAuxheat(logChannel));
            }
        } else if (bl2) {
            menuEntry7.setChildren(this.buildMenuAuxAC(logChannel));
        }
        menuEntry9.setChildren(this.buildMenuService(logChannel));
        menuEntry12.setChildren(this.buildMenuStatistics());
        this.buildDrawerIntLightMenuEntries(logChannel);
        this.makeDefaultBinding(logChannel);
    }

    private IMenuEntry[] buildMenuSport(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(604, "SPORT_TORQUE", 103811328);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(605, "SPORT_TORQUE_MAX");
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(606, "SPORT_TORQUE_CURRENT");
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3});
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(601, "SPORT_POWER", 70256896);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(602, "SPORT_POWER_MAX");
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(603, "SPORT_POWER_CURRENT");
        menuEntry4.setChildren(new IMenuEntry[]{menuEntry5, menuEntry6});
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(607, "SPORT_OIL_TEMPERATURE", 19925248);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(608, "SPORT_AIR_PRESSURE", 36702464);
        return new IMenuEntry[]{menuEntry4, menuEntry, menuEntry7, menuEntry8};
    }

    private IMenuEntry[] buildMenuCharge(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(511, "CHARGE_TIMER1");
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(512, "CHARGE_TIMER2");
        return new IMenuEntry[]{menuEntry, menuEntry2};
    }

    private IMenuEntry[] buildMenuStatistics() {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(17, "CAR_FUNC_HYBRID_RANGE_MONITOR", -2144335616);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(18, "CAR_FUNC_HYBRID_RANGE_MONITOR_RANGE", -2026895104);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(19, "CAR_FUNC_HYBRID_RANGE_MONITOR", -2043672320);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(20, "CAR_FUNC_HYBRID_RANGE_MONITOR_CONSUMER_LIST", -2077226752);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(21, "CAR_FUNC_HYBRID_RANGE_MONITOR_STATISTICS", -2060449536);
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4, menuEntry5});
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(15, "CAR_FUNC_HYBRID_STATISTICS_SHORT_TERM", 489621760);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(16, "CAR_FUNC_HYBRID_STATISTICS_LONG_TERM", 539953408);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(14, "CAR_FUNC_HYBRID_STATISTICS_LONG_TERM_RESET", -785512192);
        return new IMenuEntry[]{menuEntry, menuEntry6, menuEntry7};
    }

    private void makeDefaultBinding(LogChannel logChannel) {
        if (this.menuEntries != null) {
            try {
                IncludeMenuEntry includeMenuEntry = (IncludeMenuEntry)this.menuEntries.get(new Integer(56));
                SlotMenuEntry slotMenuEntry = (SlotMenuEntry)this.menuEntries.get(new Integer(55));
                if (includeMenuEntry != null && slotMenuEntry != null) {
                    includeMenuEntry.moveToSlot(slotMenuEntry);
                } else {
                    logChannel.log(1000, "[CarEvoMenuEntryStructure#makeDefaultBinding] null value received from menuEntries hashMap");
                }
            }
            catch (ClassCastException classCastException) {
                logChannel.log(1000, "[CarEvoMenuEntryStructure#makeDefaultBinding] cce occured: ", (Throwable)classCastException);
            }
        }
    }

    private void buildDrawerIntLightMenuEntries(LogChannel logChannel) {
        this.entryFactory.createMenuEntry(340, "INTLIGHT_INDIVIDUAL_AMBIENT_COLOR", 791415040);
        this.entryFactory.createMenuEntry(341, "INTLIGHT_INDIVIDUAL_CONTOUR_BRIGHTNESS", 808192256);
        this.entryFactory.createMenuEntry(342, "INTLIGHT_INDIVIDUAL_CONTOUR_COLOR", 824969472);
        this.entryFactory.createMenuEntry(343, "INTLIGHT_INDIVIDUAL_DOOR_BRIGHTNESS", 841746688);
        this.entryFactory.createMenuEntry(344, "INTLIGHT_INDIVIDUAL_FOOT_BRIGHTNESS", 456198400);
        this.entryFactory.createMenuEntry(345, "INTLIGHT_INDIVIDUAL_FRONT_BRIGHTNESS", 187762944);
        this.entryFactory.createMenuEntry(346, "INTLIGHT_INDIVIDUAL_ROOF_BRIGHTNESS", 892078336);
        this.entryFactory.createMenuEntry(347, "INTLIGHT_INDIVIDUAL_SURFACE_BRIGHTNESS", -600897280);
    }

    private IMenuEntry[] buildMenuDriveAssist(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(-1305999104, "DRIVE_ASSIST_RAIN", 2083064064);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(824707328, "DRIVE_ASSIST_NV_CONTRAST", 237570304);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(-1322776320, "DRIVE_ASSIST_MKE_PAUSE", -819263232);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(858261760, "DRIVE_ASSIST_DISTANCE_WARNING", -668268288);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(841484544, "DRIVE_ASSIST_SWA", 87099648);
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(640157952, "PARKING_SETTINGS", 405342464);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(-1289221888, "ACC_TRAFFIC_JAM_ASSIST", 1697253632);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(-1255667456, "DRIVING_SCHOOL", 959121664);
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(656935168, "DRIVE_ASSIST_HUD", 1462438144);
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(573049088, "HUD_BRIGHTNESS", 1495992576);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(1462241536, "HUD_ROTATION", 388761856);
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(556271872, "HUD_CONTENT", 1512769792);
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(-1641543424, "HUD_CONTENT_ACC", 1445660928);
        MenuEntry menuEntry14 = this.entryFactory.createMenuEntry(-1658320640, "HUD_CONTENT_GRA", 1546324224);
        MenuEntry menuEntry15 = this.entryFactory.createMenuEntry(-1624766208, "HUD_CONTENT_HCA", 1613433088);
        MenuEntry menuEntry16 = this.entryFactory.createMenuEntry(60, "HUD_CONTENT_HCA_ACC", 1596655872);
        MenuEntry menuEntry17 = this.entryFactory.createMenuEntry(-919992064, "HUD_CONTENT_NAV_RGI_COMBINED", -30471936);
        MenuEntry menuEntry18 = this.entryFactory.createMenuEntry(-1691875072, "HUD_CONTENT_RGI", 1747650816);
        MenuEntry menuEntry19 = this.entryFactory.createMenuEntry(-1574434560, "HUD_CONTENT_NV", 1680541952);
        MenuEntry menuEntry20 = this.entryFactory.createMenuEntry(-1675097856, "HUD_CONTENT_TRAFFICSIGN", 1781205248);
        MenuEntry menuEntry21 = this.entryFactory.createMenuEntry(-1591211776, "HUD_CONTENT_PEA", 355207424);
        MenuEntry menuEntry22 = this.entryFactory.createMenuEntry(958990592, "HUD_CONTENT_SPEEDLIMITER", 623642880);
        MenuEntry menuEntry23 = this.entryFactory.createMenuEntry(975767808, "HUD_CONTENT_DRIVEASSIST", 590088448);
        menuEntry12.setChildren(new IMenuEntry[]{menuEntry13, menuEntry14, menuEntry15, menuEntry16, menuEntry18, menuEntry19, menuEntry20, menuEntry21, menuEntry17, menuEntry22, menuEntry23});
        menuEntry9.setChildren(new IMenuEntry[]{menuEntry10, menuEntry12, menuEntry11});
        MenuEntry menuEntry24 = this.entryFactory.createMenuEntry(690489600, "DRIVE_ASSIST_ACC", 1479149824);
        MenuEntry menuEntry25 = this.entryFactory.createMenuEntry(-1557657344, "ACC_TIME_GAP", 1663699200);
        MenuEntry menuEntry26 = this.entryFactory.createMenuEntry(-1540880128, "ACC_DRIVING_PROGRAM", 1546258688);
        MenuEntry menuEntry27 = this.entryFactory.createMenuEntry(-987100928, "ACC_SPEED_LIMIT_OFFSET", 1630144768);
        MenuEntry menuEntry28 = this.entryFactory.createMenuEntry(-970323712, "ACC_CURVE_ASSIST", 1512704256);
        MenuEntry menuEntry29 = this.entryFactory.createMenuEntry(-936769280, "ACC_PACC", 657459456);
        menuEntry29.setChildren(new IMenuEntry[]{menuEntry27, menuEntry28});
        MenuEntry menuEntry30 = this.entryFactory.createMenuEntry(-903214848, "ACC_LASTDISTANCE", 623905024);
        MenuEntry menuEntry31 = this.entryFactory.createMenuEntry(-1524102912, "ACC_SPEED_LIMIT_ADOPTION", 1596590336);
        menuEntry24.setChildren(new IMenuEntry[]{menuEntry26, menuEntry25, menuEntry29, menuEntry31, menuEntry30});
        MenuEntry menuEntry32 = this.entryFactory.createMenuEntry(774375680, "DRIVE_ASSIST_LDW", -1557460736);
        MenuEntry menuEntry33 = this.entryFactory.createMenuEntry(-1406662400, "LDW_INTERVENTION", -1507129088);
        MenuEntry menuEntry34 = this.entryFactory.createMenuEntry(-1423439616, "LDW_TOLERANCE_LEVEL", 472975616);
        menuEntry32.setChildren(new IMenuEntry[]{menuEntry33, menuEntry34});
        MenuEntry menuEntry35 = this.entryFactory.createMenuEntry(791152896, "DRIVE_ASSIST_TSD", 1462307072);
        MenuEntry menuEntry36 = this.entryFactory.createMenuEntry(-1389885184, "TSD_TRAILER_DETECTION", 1529415936);
        MenuEntry menuEntry37 = this.entryFactory.createMenuEntry(807930112, "TSD_TRAILER_SPEED_LIMIT", -1876358912);
        menuEntry35.setChildren(new IMenuEntry[]{menuEntry36, menuEntry37});
        MenuEntry menuEntry38 = this.entryFactory.createMenuEntry(707266816, "PRESENSE_RGS", 589957376);
        MenuEntry menuEntry39 = this.entryFactory.createMenuEntry(724044032, "PRESENSE_RGS_SYSTEM", 623511808);
        MenuEntry menuEntry40 = this.entryFactory.createMenuEntry(-1473771264, "PRESENSE_RGS_WARNING", 657066240);
        menuEntry38.setChildren(new IMenuEntry[]{menuEntry39, menuEntry40});
        MenuEntry menuEntry41 = this.entryFactory.createMenuEntry(757598464, "PRESENSE_AWV", -1557526272);
        MenuEntry menuEntry42 = this.entryFactory.createMenuEntry(-1456994048, "PRESENSE_AWV_SYSTEM", -1523971840);
        MenuEntry menuEntry43 = this.entryFactory.createMenuEntry(-1440216832, "PRESENSE_AWV_WARNING", -1490417408);
        MenuEntry menuEntry44 = this.entryFactory.createMenuEntry(-349566720, "PRESENSE_AWV_WARNING_TIMEGAP", 1026689280);
        menuEntry41.setChildren(new IMenuEntry[]{menuEntry42, menuEntry43, menuEntry44});
        MenuEntry menuEntry45 = this.entryFactory.createMenuEntry(589826304, "DRIVE_ASSIST_SPEED_WARNING_HIGH", -1003943680);
        MenuEntry menuEntry46 = this.entryFactory.createMenuEntry(623380736, "DRIVE_ASSIST_SPEED_WARNING_LOW", -232060672);
        MenuEntry menuEntry47 = this.entryFactory.createMenuEntry(606603520, "SPEEDWARNING_MANUAL", -1406531328);
        MenuEntry menuEntry48 = this.entryFactory.createMenuEntry(53, "SPEEDWARNING_CAMERA", -1356199680);
        MenuEntry menuEntry49 = this.entryFactory.createMenuEntry(-1792538368, "SPEEDWARNING_CAMERA_KMPH");
        MenuEntry menuEntry50 = this.entryFactory.createMenuEntry(-1775761152, "SPEEDWARNING_CAMERA_MPH");
        menuEntry48.setChildren(new IMenuEntry[]{menuEntry49, menuEntry50});
        SlotMenuEntry slotMenuEntry = this.entryFactory.createSlotMenuEntry(55, "SPEEDWARNING_SLOT_LOW_VARIANT", new int[]{56});
        SlotMenuEntry slotMenuEntry2 = this.entryFactory.createSlotMenuEntry(54, "SPEEDWARNING_SLOT_HIGH_VARIANT", new int[]{56});
        IncludeMenuEntry includeMenuEntry = this.entryFactory.createIncludeMenuEntry(56, "SPEEDWARNING_INCLUDE", new int[]{slotMenuEntry.getID(), slotMenuEntry2.getID()});
        includeMenuEntry.setChildren(new IMenuEntry[]{menuEntry47});
        menuEntry45.setChildren(new IMenuEntry[]{menuEntry48, slotMenuEntry2});
        menuEntry46.setChildren(new IMenuEntry[]{slotMenuEntry});
        MenuEntry menuEntry51 = this.entryFactory.createMenuEntry(-1742206720, "PARKING_SETTINGS_VOLUME_FRONT");
        MenuEntry menuEntry52 = this.entryFactory.createMenuEntry(-1725429504, "PARKING_SETTINGS_VOLUME_REAR");
        MenuEntry menuEntry53 = this.entryFactory.createMenuEntry(-1708652288, "PARKING_SETTINGS_ENTERTAINMENT_LOWERING");
        MenuEntry menuEntry54 = this.entryFactory.createMenuEntry(-1758983936, "PARKING_SETTINGS_AUTO_VPS_VIEW_SWITCHING");
        MenuEntry menuEntry55 = this.entryFactory.createMenuEntry(600, "PARKING_SETTINGS_OPS_AUTO_ACTIVATION");
        menuEntry6.setChildren(new IMenuEntry[]{menuEntry51, menuEntry52, menuEntry53, menuEntry54, menuEntry55});
        MenuEntry menuEntry56 = this.entryFactory.createMenuEntry(1479018752, "FAS_PEA", 522979584);
        MenuEntry menuEntry57 = this.entryFactory.createMenuEntry(-1373107968, "PEA_SYSTEM", 422316288);
        MenuEntry menuEntry58 = this.entryFactory.createMenuEntry(-1356330752, "PEA_PEDAL", 455870720);
        MenuEntry menuEntry59 = this.entryFactory.createMenuEntry(774506752, "PEA_FREEWHEEL", 120457472);
        MenuEntry menuEntry60 = this.entryFactory.createMenuEntry(450, "PEA_HYBRID_FUNCTIONS", -1808922368);
        MenuEntry menuEntry61 = this.entryFactory.createMenuEntry(451, "PEA_HYBRID_SYSTEM", -1825699584);
        MenuEntry menuEntry62 = this.entryFactory.createMenuEntry(452, "PEA_HYBRID_BURNER", -1842476800);
        menuEntry60.setChildren(new IMenuEntry[]{menuEntry61, menuEntry62});
        menuEntry56.setChildren(new IMenuEntry[]{menuEntry57, menuEntry58, menuEntry59, menuEntry60});
        MenuEntry menuEntry63 = this.entryFactory.createMenuEntry(757729536, "FAS_PEA_SIMPLE", 86903040);
        return new IMenuEntry[]{menuEntry, menuEntry2, menuEntry9, menuEntry24, menuEntry4, menuEntry3, menuEntry32, menuEntry35, menuEntry5, menuEntry38, menuEntry41, menuEntry45, menuEntry46, menuEntry6, menuEntry7, menuEntry8, menuEntry56, menuEntry63};
    }

    private IMenuEntry[] buildMenuSettings(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(-47773440, "SETTINGS_JOKER", 338757888);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(-735508224, "SETTINGS_JOKER_KEY_POI_CALL", -517207808);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(1797785856, "SETTINGS_JOKER_KEY_AUX_HEATING_ON_OFF", -433387264);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(1814563072, "SETTINGS_JOKER_KEY_CHANGE_DRIVE_SELECT_MODE", -416610048);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(1831340288, "SETTINGS_JOKER_KEY_NAV_ANNOUNCEMENT", -366278400);
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(1848117504, "SETTINGS_JOKER_KEY_NAV_MAP_COLOR_DAY_NIGHT", 170985728);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(70, "SETTINGS_JOKER_KEY_NAV_MAP_ADDITIONAL_INFO", -349501184);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(1898449152, "SETTINGS_JOKER_KEY_SHOW_TMC_MESSAGES", -181729024);
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(1881671936, "SETTINGS_JOKER_KEY_TRAFFIC_ANNOUNCEMENT", -282392320);
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(1915226368, "SETTINGS_JOKER_KEY_CLUSTER_SCREENSAVER", -399832832);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(71, "SETTINGS_JOKER_KEY_CLUSTER_TRAFFIC_SIGNS_ON_OFF", -383055616);
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(1076431104, "SETTINGS_JOKER_KEY_CLUSTER_SWITCH_TO_TRAFFIC_SIGNS", 1345063168);
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(1948780800, "SETTINGS_JOKER_KEY_SWITCH_TUNER_MEDIA", -299169536);
        MenuEntry menuEntry14 = this.entryFactory.createMenuEntry(1965558016, "SETTINGS_JOKER_KEY_SKIP_FORWARD", -315946752);
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4, menuEntry5, menuEntry6, menuEntry7, menuEntry8, menuEntry9, menuEntry10, menuEntry11, menuEntry12, menuEntry13, menuEntry14});
        MenuEntry menuEntry15 = this.entryFactory.createMenuEntry(187173120, "SETTINGS_LOCKING", 606800128);
        MenuEntry menuEntry16 = this.entryFactory.createMenuEntry(-1909978880, "LOCKING_UNLOCK", 892012800);
        MenuEntry menuEntry17 = this.entryFactory.createMenuEntry(-1893201664, "LOCKING_LONGPUSH", 724240640);
        MenuEntry menuEntry18 = this.entryFactory.createMenuEntry(-1876424448, "LOCKING_AUTOLOCK", 590022912);
        MenuEntry menuEntry19 = this.entryFactory.createMenuEntry(-1859647232, "LOCKING_BOOT", 673908992);
        MenuEntry menuEntry20 = this.entryFactory.createMenuEntry(-1842870016, "LOCKING_MIRROR", 858458368);
        MenuEntry menuEntry21 = this.entryFactory.createMenuEntry(-1826092800, "LOCKING_BEEP", 640354560);
        MenuEntry menuEntry22 = this.entryFactory.createMenuEntry(-165017344, "LOCKING_KEYLESS", 1831995648);
        menuEntry15.setChildren(new IMenuEntry[]{menuEntry16, menuEntry17, menuEntry18, menuEntry19, menuEntry20, menuEntry21, menuEntry22});
        MenuEntry menuEntry23 = this.entryFactory.createMenuEntry(136841472, "SETTINGS_EXTLIGHT", 221317376);
        MenuEntry menuEntry24 = this.entryFactory.createMenuEntry(-98105088, "EXTLIGHT_AUTOMATIC_LIGHT", 1043007744);
        MenuEntry menuEntry25 = this.entryFactory.createMenuEntry(-2111305472, "EXTLIGHT_DAY_LIGHT", 1160448256);
        MenuEntry menuEntry26 = this.entryFactory.createMenuEntry(-2094528256, "EXTLIGHT_TOURIST_LEFT", 321980672);
        MenuEntry menuEntry27 = this.entryFactory.createMenuEntry(-2077751040, "EXTLIGHT_TOURIST_RIGHT", 1412106496);
        MenuEntry menuEntry28 = this.entryFactory.createMenuEntry(-2128082688, "EXTLIGHT_COMING_LEAVING_HOME", 1126893824);
        menuEntry23.setChildren(new IMenuEntry[]{menuEntry24, menuEntry25, menuEntry26, menuEntry27, menuEntry28});
        MenuEntry menuEntry29 = this.entryFactory.createMenuEntry(2082998528, "EXTLIGHT_SWITCH_ON_SENSITIVITY", 1344997632);
        MenuEntry menuEntry30 = this.entryFactory.createMenuEntry(2116552960, "EXTLIGHT_HEAD_LIGHT", 254871808);
        MenuEntry menuEntry31 = this.entryFactory.createMenuEntry(2099775744, "EXTLIGHT_GLIDING_LIGHT", 1210779904);
        MenuEntry menuEntry32 = this.entryFactory.createMenuEntry(2133330176, "EXTLIGHT_MATRIX_BEAM", 1311443200);
        MenuEntry menuEntry33 = this.entryFactory.createMenuEntry(-567736064, "EXTLIGHT_HEAD_LIGHT_SUBMENU", -802420480);
        MenuEntry menuEntry34 = this.entryFactory.createMenuEntry(-618067712, "EXTLIGHT_HEAD_LIGHT_NORMAL", -752088832);
        MenuEntry menuEntry35 = this.entryFactory.createMenuEntry(-517404416, "EXTLIGHT_HEAD_LIGHT_LASER", -869529344);
        menuEntry33.setChildren(new IMenuEntry[]{menuEntry34, menuEntry35});
        MenuEntry menuEntry36 = this.entryFactory.createMenuEntry(-550958848, "EXTLIGHT_GLIDING_LIGHT_SUBMENU", -819197696);
        MenuEntry menuEntry37 = this.entryFactory.createMenuEntry(-601290496, "EXTLIGHT_GLIDING_LIGHT_NORMAL", -768866048);
        MenuEntry menuEntry38 = this.entryFactory.createMenuEntry(-500627200, "EXTLIGHT_GLIDING_LIGHT_LASER", -903083776);
        menuEntry36.setChildren(new IMenuEntry[]{menuEntry37, menuEntry38});
        MenuEntry menuEntry39 = this.entryFactory.createMenuEntry(-534181632, "EXTLIGHT_MATRIX_BEAM_SUBMENU", -785643264);
        MenuEntry menuEntry40 = this.entryFactory.createMenuEntry(-584513280, "EXTLIGHT_MATRIX_BEAM_NORMAL", -735311616);
        MenuEntry menuEntry41 = this.entryFactory.createMenuEntry(-651622144, "EXTLIGHT_MATRIX_BEAM_LASER", -835974912);
        menuEntry39.setChildren(new IMenuEntry[]{menuEntry40, menuEntry41});
        menuEntry24.setChildren(new IMenuEntry[]{menuEntry29, menuEntry30, menuEntry31, menuEntry32, menuEntry33, menuEntry36, menuEntry39});
        MenuEntry menuEntry42 = this.entryFactory.createMenuEntry(203950336, "SETTINGS_UGDO", 1546193152);
        MenuEntry menuEntry43 = this.entryFactory.createMenuEntry(220727552, "UGDO_LEARNING", 1613302016);
        MenuEntry menuEntry44 = this.entryFactory.createMenuEntry(287836416, "UGDO_DELETE", 1562970368);
        MenuEntry menuEntry45 = this.entryFactory.createMenuEntry(6003, "UGDO_VERSION", 1446119680);
        menuEntry42.setChildren(new IMenuEntry[]{menuEntry43, menuEntry44, menuEntry45});
        MenuEntry menuEntry46 = this.entryFactory.createMenuEntry(237504768, "UGDO_LEARN_BUTTON1", -147846912);
        MenuEntry menuEntry47 = this.entryFactory.createMenuEntry(254281984, "UGDO_LEARN_BUTTON2", 1663633664);
        MenuEntry menuEntry48 = this.entryFactory.createMenuEntry(271059200, "UGDO_LEARN_BUTTON3", 1697188096);
        MenuEntry menuEntry49 = this.entryFactory.createMenuEntry(6001, "UGDO_LEARN_BUTTON_DEFAULT_MODE", 1496320256);
        MenuEntry menuEntry50 = this.entryFactory.createMenuEntry(6002, "UGDO_LEARN_BUTTON_FIXKIT", 1513097472);
        menuEntry43.setChildren(new IMenuEntry[]{menuEntry46, menuEntry47, menuEntry48, menuEntry49, menuEntry50});
        MenuEntry menuEntry51 = this.entryFactory.createMenuEntry(153618688, "INTLIGHT_PROFILES", -450164480);
        MenuEntry menuEntry52 = this.entryFactory.createMenuEntry(-2060973824, "INTLIGHT_PROFILE_1", 3213568);
        MenuEntry menuEntry53 = this.entryFactory.createMenuEntry(-2044196608, "INTLIGHT_PROFILE_2", -148174592);
        MenuEntry menuEntry54 = this.entryFactory.createMenuEntry(-2027419392, "INTLIGHT_PROFILE_3", -131397376);
        MenuEntry menuEntry55 = this.entryFactory.createMenuEntry(-2010642176, "INTLIGHT_PROFILE_4", -114620160);
        MenuEntry menuEntry56 = this.entryFactory.createMenuEntry(-1993864960, "INTLIGHT_PROFILE_5", -97842944);
        MenuEntry menuEntry57 = this.entryFactory.createMenuEntry(-1977087744, "INTLIGHT_PROFILE_6", -81065728);
        MenuEntry menuEntry58 = this.entryFactory.createMenuEntry(-1960310528, "INTLIGHT_PROFILE_7", -64288512);
        MenuEntry menuEntry59 = this.entryFactory.createMenuEntry(-1943533312, "INTLIGHT_PROFILE_8", -47511296);
        MenuEntry menuEntry60 = this.entryFactory.createMenuEntry(338, "INTLIGHT_INDIVIDUAL", -30734080);
        menuEntry51.setChildren(new IMenuEntry[]{menuEntry52, menuEntry53, menuEntry54, menuEntry55, menuEntry56, menuEntry57, menuEntry58, menuEntry59, menuEntry60});
        MenuEntry menuEntry61 = this.entryFactory.createMenuEntry(170395904, "INTLIGHT_ROTARY_ONLY", -13956864);
        MenuEntry menuEntry62 = this.entryFactory.createMenuEntry(-30996224, "SETTINGS_SEAT", -517404416);
        MenuEntry menuEntry63 = this.entryFactory.createMenuEntry(-14219008, "SEAT_DRIVER_HIGH_VARIANT", -450295552);
        MenuEntry menuEntry64 = this.entryFactory.createMenuEntry(120064256, "SEAT_DRIVER_LOW_VARIANT", 204081408);
        MenuEntry menuEntry65 = this.entryFactory.createMenuEntry(2623744, "SEAT_CODRIVER", -500627200);
        MenuEntry menuEntry66 = this.entryFactory.createMenuEntry(69732608, "SEAT_REAR", -383186688);
        MenuEntry menuEntry67 = this.entryFactory.createMenuEntry(86509824, "NORMAL_POSITION", -399963904);
        menuEntry62.setChildren(new IMenuEntry[]{menuEntry63, menuEntry65, menuEntry66, menuEntry67});
        SlotMenuEntry slotMenuEntry = this.entryFactory.createSlotMenuEntry(-1615984128, "SEAT_SLOT_HIGH_VARIANT", new int[]{422906880});
        menuEntry63.setChildren(new IMenuEntry[]{slotMenuEntry});
        SlotMenuEntry slotMenuEntry2 = this.entryFactory.createSlotMenuEntry(-1481766400, "SEAT_SLOT_LOW_VARIANT", new int[]{422906880});
        menuEntry64.setChildren(new IMenuEntry[]{slotMenuEntry2});
        IncludeMenuEntry includeMenuEntry = this.entryFactory.createIncludeMenuEntry(422906880, "SEAT_INCLUDE_DRIVER", new int[]{slotMenuEntry.getID(), slotMenuEntry2.getID()});
        MenuEntry menuEntry68 = this.entryFactory.createMenuEntry(1982335232, "SEAT_DRIVER_EASY_ENTRY", -433518336);
        MenuEntry menuEntry69 = this.entryFactory.createMenuEntry(2015889664, "SEAT_DRIVER_RADIO_KEY", -416741120);
        MenuEntry menuEntry70 = this.entryFactory.createMenuEntry(-1574303488, "SEAT_DRIVER_PRELOAD_DEVICE", 388958464);
        includeMenuEntry.setChildren(new IMenuEntry[]{menuEntry68, menuEntry69, menuEntry70});
        MenuEntry menuEntry71 = this.entryFactory.createMenuEntry(2049444096, "SEAT_REAR_EASY_ENTRY", -349632256);
        MenuEntry menuEntry72 = this.entryFactory.createMenuEntry(2066221312, "SEAT_REAR_CODRIVER_POS", -366409472);
        menuEntry66.setChildren(new IMenuEntry[]{menuEntry71, menuEntry72});
        MenuEntry menuEntry73 = this.entryFactory.createMenuEntry(19400960, "SEAT_CO_DRV_POSITION", -483849984);
        MenuEntry menuEntry74 = this.entryFactory.createMenuEntry(36178176, "SEAT_CO_DRV_SYMMETRY", -467072768);
        MenuEntry menuEntry75 = this.entryFactory.createMenuEntry(-1557526272, "SEAT_CODRIVER_PRELOAD_DEVICE", 372181248);
        menuEntry65.setChildren(new IMenuEntry[]{menuEntry73, menuEntry74, menuEntry75});
        MenuEntry menuEntry76 = this.entryFactory.createMenuEntry(-1809315584, "AIR_SUSPENSION_TRAILER_MODE", -685045504);
        MenuEntry menuEntry77 = this.entryFactory.createMenuEntry(-1473640192, "SETTINGS_PEA_HYBRID", -1808922368);
        MenuEntry menuEntry78 = this.entryFactory.createMenuEntry(-1456862976, "SETTINGS_PEA_HYBRID_PEDAL", -1825699584);
        MenuEntry menuEntry79 = this.entryFactory.createMenuEntry(-1440085760, "SETTINGS_PEA_HYBRID_COMBUSTOR", -1842476800);
        menuEntry77.setChildren(new IMenuEntry[]{menuEntry78, menuEntry79});
        return new IMenuEntry[]{menuEntry, menuEntry15, menuEntry23, menuEntry42, menuEntry62, menuEntry64, menuEntry76, menuEntry51, menuEntry61, menuEntry77};
    }

    private IMenuEntry[] buildMenuAuxheat(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(221, "AUXHEAT_NOW", 405866752);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(-165213952, "AUXHEAT_NOW_ON");
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(-148436736, "AUXHEAT_NOW_OFF");
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3});
        this.entryFactory.createMenuEntry(222, "AUXHEAT_TIMER1", 154208512);
        this.entryFactory.createMenuEntry(223, "AUXHEAT_TIMER2", -1691744000);
        this.entryFactory.createMenuEntry(224, "AUXHEAT_HEATING_EFFECT_RIGHT_DRAWER", 304875776);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(2210, "AUXHEAT_NOW_VO");
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(2220, "AUXHEAT_TIMER1_VO");
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(2230, "AUXHEAT_TIMER2_VO");
        MenuEntry menuEntry7 = this.buildMenuAuxAcExtendedOptions();
        return new IMenuEntry[]{menuEntry4, menuEntry5, menuEntry6, menuEntry7};
    }

    private IMenuEntry[] buildMenuAuxAC(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(221, "AUXHEAT_NOW");
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(-47642368, "AUXCOOLER_NOW_ON");
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(1361709312, "AUXCOOLER_NOW_OFF");
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(-1825961728, "AUXCOMBINED_NOW_ON");
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(-1809184512, "AUXCOMBINED_NOW_OFF");
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4, menuEntry5});
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(222, "AUXHEAT_TIMER1");
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(223, "AUXHEAT_TIMER2");
        MenuEntry menuEntry8 = this.buildMenuAuxAcExtendedOptions();
        this.entryFactory.createMenuEntry(225, "AUX_AC_IMMEDIATE_AC_TYPE_RIGHT_DRAWER", 2016282880);
        this.entryFactory.createMenuEntry(226, "AUX_AC_TIMER1_AC_TYPE_RIGHT_DRAWER", 1999505664);
        this.entryFactory.createMenuEntry(227, "AUX_AC_TIMER2_AC_TYPE_RIGHT_DRAWER", 2033060096);
        return new IMenuEntry[]{menuEntry, menuEntry6, menuEntry7, menuEntry8};
    }

    private MenuEntry buildMenuAuxAcExtendedOptions() {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(-332789504, "AUX_AC_EXTENDED_CONDITIONING", 1563560192);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(-316012288, "AUX_AC_EXTENDED_ZONES", 1580337408);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(-299235072, "AUX_AC_WINDOWS_ZONES", 1496451328);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(-282457856, "AUX_AC_UNLOCK_CLIMATING", 1546782976);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(-248903424, "AUX_AC_Z1RL", 1647446272);
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(-232126208, "AUX_AC_Z1RR", 1714555136);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(-215348992, "AUX_AC_Z2RL", 1681000704);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(-198571776, "AUX_AC_Z2RR", 1697777920);
        menuEntry2.setChildren(new IMenuEntry[]{menuEntry5, menuEntry6, menuEntry7, menuEntry8});
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4});
        return menuEntry;
    }

    private IMenuEntry[] buildMenuService(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(-1222113024, "SERVICE_WIPERPOSITION", 2116618496);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(1126697216, "SERVICE_OILLEVEL", 321456384);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(1160251648, "SERVICE_VEHICLE_INFO", 1831602432);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(182, "SERVICE_VIN", 2049509632);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(181, "SERVICE_KEYDATA", 1143736576);
        menuEntry3.setChildren(new IMenuEntry[]{menuEntry4, menuEntry5});
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(1143474432, "SERVICE_SIA", 1227426048);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(402, "SIA_OIL_CHANGE_INTERVAL", 1244203264);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(403, "SIA_SERVICE_INTERVAL", 1344866560);
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(-1675032320, "SIA_OIL_RESET", 1328089344);
        menuEntry6.setChildren(new IMenuEntry[]{menuEntry7, menuEntry8, menuEntry9});
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(1109920000, "RDK_LOW_MAIN", -1826027264);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(1009256704, "RDK_HIGH_MAIN", -1842804480);
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(1042811136, "RDK_HIGH_SAVE_PRESSURE", 556337408);
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(1026033920, "RDK_HIGH_DISPLAY_PRESSURE", 589891840);
        MenuEntry menuEntry14 = this.entryFactory.createMenuEntry(1093142784, "RDK_HIGH_TYRE_CHANGED", 0x22290900);
        menuEntry11.setChildren(new IMenuEntry[]{menuEntry12, menuEntry13, menuEntry14});
        MenuEntry menuEntry15 = this.entryFactory.createMenuEntry(-1238890240, "AIR_SUSPENSION_CAR_JACK_MODE", -701822720);
        MenuEntry menuEntry16 = this.entryFactory.createMenuEntry(1177028864, "AD_BLUE", -718599936);
        return new IMenuEntry[]{menuEntry, menuEntry2, menuEntry3, menuEntry6, menuEntry10, menuEntry11, menuEntry15, menuEntry16};
    }

    private IMenuEntry[] buildMenuAirCondition(LogChannel logChannel) {
        IStorageAccess iStorageAccess = this.framework.getStorageMgr();
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(1747454208, "AIRCONDITION_CIRCULATION", -785708800, new MenuEntryPersistence(iStorageAccess, 80));
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(-1976956672, "AIRCONDITION_FOOTWELL_DRIVER_LH", -1657927424, new MenuEntryPersistence(iStorageAccess, 83));
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(-1960179456, "AIRCONDITION_FOOTWELL_CODRIVER_LH", -1674704640, new MenuEntryPersistence(iStorageAccess, 84));
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(-450230016, "AIRCONDITION_FOOTWELL_DRIVER_RH", -1204811520, new MenuEntryPersistence(iStorageAccess, 85));
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(-433452800, "AIRCONDITION_FOOTWELL_CODRIVER_RH", -1188034304, new MenuEntryPersistence(iStorageAccess, 86));
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(-1993733888, "AIRCONDITION_FOOTWELL", -768931584);
        menuEntry6.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4, menuEntry5});
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(1764231424, "AIRCONDITION_HEATER", -752154368, new MenuEntryPersistence(iStorageAccess, 81));
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(1781008640, "AIRCONDITION_SOLAR", -735377152, new MenuEntryPersistence(iStorageAccess, 82));
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(-282654464, "AIRCONDITION_SEAT_HEATING", 1814890752);
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(-500758272, "AIRCONDITION_SEAT_VENTILATION", 1798113536);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(-483981056, "AC_SEAT_VENTILATION_DRIVER", 1848445184, new MenuEntryPersistence(iStorageAccess, 90));
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(-433649408, "AC_SEAT_VENTILATION_CODRIVER", 1831667968, new MenuEntryPersistence(iStorageAccess, 91));
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(-383317760, "AC_SEAT_VENTILATION_REAR_DRIVER", 1881999616, new MenuEntryPersistence(iStorageAccess, 92));
        MenuEntry menuEntry14 = this.entryFactory.createMenuEntry(-332986112, "AC_SEAT_VENTILATION_REAR_CODRIVER", 1865222400, new MenuEntryPersistence(iStorageAccess, 93));
        MenuEntry menuEntry15 = this.entryFactory.createMenuEntry(-265877248, "AC_SEAT_HEATING_DRIVER", 1965885696, new MenuEntryPersistence(iStorageAccess, 94));
        MenuEntry menuEntry16 = this.entryFactory.createMenuEntry(-249100032, "AC_SEAT_HEATING_CODRIVER", 1949108480, new MenuEntryPersistence(iStorageAccess, 95));
        MenuEntry menuEntry17 = this.entryFactory.createMenuEntry(-232322816, "AC_SEAT_HEATING_REAR_DRIVER", 1999440128, new MenuEntryPersistence(iStorageAccess, 96));
        MenuEntry menuEntry18 = this.entryFactory.createMenuEntry(-215545600, "AC_SEAT_HEATING_REAR_CODRIVER", 1982662912, new MenuEntryPersistence(iStorageAccess, 97));
        IMenuEntry[] iMenuEntryArray = new IMenuEntry[]{menuEntry11, menuEntry12, menuEntry13, menuEntry14};
        IMenuEntry[] iMenuEntryArray2 = new IMenuEntry[]{menuEntry15, menuEntry16, menuEntry17, menuEntry18};
        menuEntry10.setChildren(iMenuEntryArray);
        menuEntry9.setChildren(iMenuEntryArray2);
        return new IMenuEntry[]{menuEntry, menuEntry6, menuEntry7, menuEntry8, menuEntry9, menuEntry10};
    }

    private IMenuEntry[] buildMenuCharisma(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(1277692160, "CHARISMA_PROFILE_ALLROAD", 355141888);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(1260914944, "CHARISMA_PROFILE_OFFROAD", 472582400);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(1328023808, "CHARISMA_PROFILE_AUTO", 707856640);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(1344801024, "CHARISMA_PROFILE_DYNAMIC", -181401344);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(1294469376, "CHARISMA_PROFILE_EFFICIENY", 422250752);
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(1311246592, "CHARISMA_PROFILE_COMFORT", 388696320);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(1361578240, "CHARISMA_PROFILE_INDIVIDUAL", 523307264);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(1965689088, "CHARSIMA_PROFILE_LIFT", 455805184);
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(238, "CHARISMA_PROFILE_RACE", 305203456);
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(1244137728, "CHARSIMA_PROFILE_LIFT_OFFROAD", -1741813504);
        menuEntry8.setFunctionalStateValues(new int[]{4});
        menuEntry2.setFunctionalStateValues(new int[]{4});
        menuEntry10.setFunctionalStateValues(new int[]{4});
        menuEntry5.setFunctionalStateValues(new int[]{8});
        this.entryFactory.createMenuEntry(260, "AIR_SUSPENSION_INDICATOR", 237766912);
        this.entryFactory.createMenuEntry(240, "CHARISMA_INDIVIDUAL_ACC", -215348992);
        this.entryFactory.createMenuEntry(241, "CHARISMA_INDIVIDUAL_AIRSUSPENSION", -148240128);
        this.entryFactory.createMenuEntry(242, "CHARISMA_INDIVIDUAL_DAMPER", -64354048);
        this.entryFactory.createMenuEntry(243, "CHARISMA_INDIVIDUAL_ENGINE", -30799616);
        this.entryFactory.createMenuEntry(244, "CHARISMA_INDIVIDUAL_GEAR_ENGINE", 2820352);
        this.entryFactory.createMenuEntry(245, "CHARISMA_INDIVIDUAL_POWER_STEERING", 69929216);
        this.entryFactory.createMenuEntry(246, "CHARISMA_INDIVIDUAL_SOUND", 103483648);
        this.entryFactory.createMenuEntry(247, "CHARISMA_INDIVIDUAL_STEERING_LIGHT", 170592512);
        this.entryFactory.createMenuEntry(248, "CHARISMA_INDIVIDUAL_SUPERPOS_STEERING", 204146944);
        this.entryFactory.createMenuEntry(270, "CHARISMA_EFFICIENCY_BCME_LIVE_TIPS", 1663895808);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(250, "CHARISMA_EFFICIENCY_BCME_ADD_INFO", 1898776832);
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(252, "CHARISMA_EFFICIENCY_BCME_CONSUMPTION_BARGRAPH", 1613564160);
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(251, "CHARISMA_EFFICIENCY_BCME_CONSUMER_LIST", 1915554048);
        menuEntry11.setChildren(new IMenuEntry[]{menuEntry12, menuEntry13});
        MenuEntry menuEntry14 = this.entryFactory.createMenuEntry(326, "TAD_MAIN", 1999374592);
        MenuEntry menuEntry15 = this.entryFactory.createMenuEntry(328, "TAD_PITCH_ANGLE", 1965820160);
        MenuEntry menuEntry16 = this.entryFactory.createMenuEntry(327, "TAD_ROLL_ANGLE", 1982597376);
        menuEntry14.setChildren(new IMenuEntry[]{menuEntry15, menuEntry16});
        return new IMenuEntry[]{menuEntry, menuEntry2, menuEntry3, menuEntry4, menuEntry5, menuEntry7, menuEntry6, menuEntry8, menuEntry10, menuEntry9};
    }

   // @Override
    public HashMap getMenuEntries() {
        return this.menuEntries;
    }
}

