/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import java.util.Map;

public interface IAddressInputSDSForm {
    public void startDestinationInput(int var1, NaviServiceListener var2);

    public void startDestinationInputWithCurrentLD(int var1, NaviServiceListener var2);

    public void setCountry(String var1, String var2, NaviServiceListener var3);

    public void setState(String var1, String var2, NaviServiceListener var3);

    public void setCity(String var1, String var2, NaviServiceListener var3);

    public void setStreet(String var1, String var2, NaviServiceListener var3);

    public void setJunction(String var1, String var2, NaviServiceListener var3);

    public void setHouseNumber(String var1, String var2, NaviServiceListener var3);

    public void setHouseNumberByIndex(int var1, NaviServiceListener var2);

    public void setCenter(NaviServiceListener var1);

    public void setZIPCode(String var1, String var2, NaviServiceListener var3);

    public void setProvince(String var1, String var2, NaviServiceListener var3);

    public void setPrefecture(String var1, String var2, NaviServiceListener var3);

    public void setPlacename(String var1, String var2, NaviServiceListener var3);

    public void setWard(String var1, String var2, NaviServiceListener var3);

    public void setChome(String var1, String var2, NaviServiceListener var3);

    public void setSubmunicipalTownOrStreet(String var1, String var2, NaviServiceListener var3);

    public void setVillageAndStreet(String var1, String var2, NaviServiceListener var3);

    public void setOneShotData(Map var1, NaviServiceListener var2);

    public void validateSpelledStreetName(String var1, NaviServiceListener var2);

    public void querySpelledCityResultList(String var1, NaviServiceListener var2);

    public void querySpelledStreetResultList(String var1, NaviServiceListener var2);

    public void querySpelledStreetResultList2(String var1, NaviServiceListener var2);

    public void selectSpelledCityName(boolean var1, Object var2, NaviServiceListener var3);

    public void selectSpelledStreetName(boolean var1, Object var2, NaviServiceListener var3);

    public void selectSpelledStreetName2(boolean var1, Object var2, NaviServiceListener var3);

    public void queryCityListLength(NaviServiceListener var1);

    public void queryZIPCodeListLength(NaviServiceListener var1);

    public void queryHouseNrListLength(NaviServiceListener var1);

    public void queryStreetListLength(NaviServiceListener var1);

    public void queryIntersectionListLength(NaviServiceListener var1);

    public void setCountryAndState(String var1, String var2, String var3, String var4, NaviServiceListener var5);

    public void updateDetailScreenInfo(NaviServiceListener var1);

    public void enterMapCode(NaviServiceListener var1);

    public void inputMapCode(String var1, NaviServiceListener var2);

    public void deleteLastMapCodeInput(NaviServiceListener var1);

    public void clearMapCode(NaviServiceListener var1);

    public void disambiguateMapCode(NaviServiceListener var1);

    public void selectDisambiguatedMapCodeByIndex(int var1, NaviServiceListener var2);

    public String getLastValidMapCodeBlock();

    public String getCurrentMapCode();

    public boolean isCurrentMapCodeNavigable();

    public boolean isFurtherMapCodeInputPossible();

    public void enterTelephoneNumber(NaviServiceListener var1);

    public void inputTelephoneNumber(String var1, NaviServiceListener var2);

    public void deleteLastTelephoneNumberInput(NaviServiceListener var1);

    public void clearTelephoneNumber(NaviServiceListener var1);

    public void selectTelephoneNumberByIndex(int var1, NaviServiceListener var2);

    public String getLastValidTelephoneNumberBlock();

    public String getCurrentTelephoneNumber();

    public boolean isFurtherTelephonenumberInputPossible();

    public void startTpegPOI(NaviServiceListener var1);

    public void getTpegPOIResultsByCategoryIndex(int var1, NaviServiceListener var2);

    public void selectTpegPOIResultByIndex(int var1, NaviServiceListener var2);

    public void triggerAddressInputReturn(int var1, NaviServiceListener var2);

    public void triggerAddressInputReturn(int var1, int var2, NaviServiceListener var3);

    public void synchronizeSpeechCountryWithCurrentLD(NaviServiceListener var1);

    public void triggerMapCodeReturn(NaviServiceListener var1);

    public void nextDestinationInput(int var1);
}

