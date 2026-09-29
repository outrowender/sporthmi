/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import java.util.Map;

public interface IAddressInputSDSForm {
    default public void startDestinationInput(int n, NaviServiceListener naviServiceListener) {
    }

    default public void startDestinationInputWithCurrentLD(int n, NaviServiceListener naviServiceListener) {
    }

    default public void setCountry(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setState(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setCity(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setStreet(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setJunction(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setHouseNumber(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setHouseNumberByIndex(int n, NaviServiceListener naviServiceListener) {
    }

    default public void setCenter(NaviServiceListener naviServiceListener) {
    }

    default public void setZIPCode(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setProvince(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setPrefecture(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setPlacename(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setWard(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setChome(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setSubmunicipalTownOrStreet(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setVillageAndStreet(String string, String string2, NaviServiceListener naviServiceListener) {
    }

    default public void setOneShotData(Map map, NaviServiceListener naviServiceListener) {
    }

    default public void validateSpelledStreetName(String string, NaviServiceListener naviServiceListener) {
    }

    default public void querySpelledCityResultList(String string, NaviServiceListener naviServiceListener) {
    }

    default public void querySpelledStreetResultList(String string, NaviServiceListener naviServiceListener) {
    }

    default public void querySpelledStreetResultList2(String string, NaviServiceListener naviServiceListener) {
    }

    default public void selectSpelledCityName(boolean bl, Object object, NaviServiceListener naviServiceListener) {
    }

    default public void selectSpelledStreetName(boolean bl, Object object, NaviServiceListener naviServiceListener) {
    }

    default public void selectSpelledStreetName2(boolean bl, Object object, NaviServiceListener naviServiceListener) {
    }

    default public void queryCityListLength(NaviServiceListener naviServiceListener) {
    }

    default public void queryZIPCodeListLength(NaviServiceListener naviServiceListener) {
    }

    default public void queryHouseNrListLength(NaviServiceListener naviServiceListener) {
    }

    default public void queryStreetListLength(NaviServiceListener naviServiceListener) {
    }

    default public void queryIntersectionListLength(NaviServiceListener naviServiceListener) {
    }

    default public void setCountryAndState(String string, String string2, String string3, String string4, NaviServiceListener naviServiceListener) {
    }

    default public void updateDetailScreenInfo(NaviServiceListener naviServiceListener) {
    }

    default public void enterMapCode(NaviServiceListener naviServiceListener) {
    }

    default public void inputMapCode(String string, NaviServiceListener naviServiceListener) {
    }

    default public void deleteLastMapCodeInput(NaviServiceListener naviServiceListener) {
    }

    default public void clearMapCode(NaviServiceListener naviServiceListener) {
    }

    default public void disambiguateMapCode(NaviServiceListener naviServiceListener) {
    }

    default public void selectDisambiguatedMapCodeByIndex(int n, NaviServiceListener naviServiceListener) {
    }

    default public String getLastValidMapCodeBlock() {
    }

    default public String getCurrentMapCode() {
    }

    default public boolean isCurrentMapCodeNavigable() {
    }

    default public boolean isFurtherMapCodeInputPossible() {
    }

    default public void enterTelephoneNumber(NaviServiceListener naviServiceListener) {
    }

    default public void inputTelephoneNumber(String string, NaviServiceListener naviServiceListener) {
    }

    default public void deleteLastTelephoneNumberInput(NaviServiceListener naviServiceListener) {
    }

    default public void clearTelephoneNumber(NaviServiceListener naviServiceListener) {
    }

    default public void selectTelephoneNumberByIndex(int n, NaviServiceListener naviServiceListener) {
    }

    default public String getLastValidTelephoneNumberBlock() {
    }

    default public String getCurrentTelephoneNumber() {
    }

    default public boolean isFurtherTelephonenumberInputPossible() {
    }

    default public void startTpegPOI(NaviServiceListener naviServiceListener) {
    }

    default public void getTpegPOIResultsByCategoryIndex(int n, NaviServiceListener naviServiceListener) {
    }

    default public void selectTpegPOIResultByIndex(int n, NaviServiceListener naviServiceListener) {
    }

    default public void triggerAddressInputReturn(int n, NaviServiceListener naviServiceListener) {
    }

    default public void triggerAddressInputReturn(int n, int n2, NaviServiceListener naviServiceListener) {
    }

    default public void synchronizeSpeechCountryWithCurrentLD(NaviServiceListener naviServiceListener) {
    }

    default public void triggerMapCodeReturn(NaviServiceListener naviServiceListener) {
    }

    default public void nextDestinationInput(int n) {
    }
}

