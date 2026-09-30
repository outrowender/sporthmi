/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractAddressInputWorkFlowManager
implements IAddressInputWorkFlowManager {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected final NavigationEnv env;
    protected final ICommandListFactory commandListFactory;
    protected final SpellerStack spellerStack;
    protected final LogChannel logChannel;

    public AbstractAddressInputWorkFlowManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
    }

    protected boolean isSystemEU(int n) {
        return n >= 1 && n <= 9999;
    }

    protected boolean isEuMainScreen(int n) {
        return n >= 1 && n <= 100;
    }

    protected boolean isEuCountryScreen(int n) {
        return n >= 101 && n <= 200;
    }

    protected boolean isEuCityZipScreen(int n) {
        return n >= 201 && n <= 300;
    }

    protected boolean isEuStreetScreen(int n) {
        return n >= 301 && n <= 400;
    }

    protected boolean isEuHousenumberFreetextScreen(int n) {
        return n >= 401 && n <= 500;
    }

    protected boolean isEuHousenumberMatchSpellerScreen(int n) {
        return n >= 501 && n <= 600;
    }

    protected boolean isEuJunctionScreen(int n) {
        return n >= 601 && n <= 700;
    }

    protected boolean isEuRefinementScreen(int n) {
        return n >= 701 && n <= 800;
    }

    protected boolean isSystemCN(int n) {
        return n >= 10000 && n <= 19999;
    }

    protected boolean isCNMainScreen(int n) {
        return n >= 10001 && n <= 10100;
    }

    protected boolean isCNCityScreen(int n) {
        return n >= 10101 && n <= 10200;
    }

    protected boolean isCNLocationScreen(int n) {
        return n >= 10301 && n <= 10400;
    }

    protected boolean isCNStreetScreen(int n) {
        return n >= 10401 && n <= 10500;
    }

    protected boolean isCNHousenumberMatchSpellerScreen(int n) {
        return n >= 10501 && n <= 10600;
    }

    protected boolean isCNIntersectionScreen(int n) {
        return n >= 10601 && n <= 10700;
    }

    protected boolean isSystemJP(int n) {
        return n >= 20000 && n <= 29999;
    }

    protected boolean isJPMainScreen(int n) {
        return n >= 20001 && n <= 20100;
    }

    protected boolean isJPPrefectureScreen(int n) {
        return n >= 20101 && n <= 20200;
    }

    protected boolean isJPCityScreen(int n) {
        return n >= 20201 && n <= 20300;
    }

    protected boolean isJPWardScreen(int n) {
        return n >= 20701 && n <= 20800;
    }

    protected boolean isJPFacilityScreen(int n) {
        return n >= 20301 && n <= 20400;
    }

    protected boolean isJPPlaceScreen(int n) {
        return n >= 20401 && n <= 20500;
    }

    protected boolean isJPChomeScreen(int n) {
        return n >= 20501 && n <= 20600;
    }

    protected boolean isJPHouseNumberScreen(int n) {
        return n >= 20801 && n <= 20900;
    }

    protected boolean isSystemNAR(int n) {
        return n >= 30000 && n <= 39999;
    }

    protected boolean isNARMainScreen(int n) {
        return n >= 30001 && n <= 30100;
    }

    protected boolean isNARCountryScreen(int n) {
        return n >= 30101 && n <= 30200;
    }

    protected boolean isNARCityScreen(int n) {
        return n >= 30201 && n <= 30300;
    }

    protected boolean isNARStreetScreen(int n) {
        return n >= 30301 && n <= 30400;
    }

    protected boolean isNARStreetRefinementScreen(int n) {
        return n >= 30701 && n <= 30800;
    }

    protected boolean isNARCityRefinementScreen(int n) {
        return n >= 30401 && n <= 30500;
    }

    protected boolean isNARHousenumberScreen(int n) {
        return n >= 30601 && n <= 30700;
    }

    protected boolean isNARIntersectionScreen(int n) {
        return n >= 30501 && n <= 30600;
    }

    protected boolean isSystemKR(int n) {
        return n >= 40000 && n <= 49999;
    }

    protected boolean isKRMainScreen(int n) {
        return n >= 40001 && n <= 40100;
    }

    protected boolean isKRProvinceScreen(int n) {
        return n >= 40101 && n <= 40200;
    }

    protected boolean isKRCityScreen(int n) {
        return n >= 40201 && n <= 40300;
    }

    protected boolean isKRWardScreen(int n) {
        return n >= 40301 && n <= 40400;
    }

    protected boolean isKRFacilityScreen(int n) {
        return n >= 40401 && n <= 40500;
    }

    protected boolean isKRTownStreetScreen(int n) {
        return n >= 40501 && n <= 40600;
    }

    protected boolean isKRVillageStreetScreen(int n) {
        return n >= 40601 && n <= 40700;
    }

    protected boolean isKRNumberScreen(int n) {
        return n >= 40701 && n <= 40800;
    }
}

