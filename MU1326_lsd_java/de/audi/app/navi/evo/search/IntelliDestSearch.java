/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestController;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.search.AbstractNaviGuiSearchHandler;
import de.audi.tghu.navi.app.search.LastDestSearch;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.SearchFilter;
import org.osgi.framework.BundleContext;

public class IntelliDestSearch
extends AbstractSearch {
    private static int TRUFFELS_AVAILABLE = 1;
    private static int TRUFFELS_NOT_AVAILABLE = 0;
    protected IVehicle vehicle;
    private final NavigationEnv env;
    private final IntelliDestController searchController;
    private final LastDestSearch lastDestSearch;
    private boolean navDbSourceAvailable = true;
    protected boolean destinationAddedToContact = false;
    private boolean removeFromHistoryCalled = false;
    public static final int HIDE_DIDYOUMEAN_BUTTON = 0;
    public static final int SHOW_DIDYOUMEAN_BUTTON_CITY = 1;
    public static final int SHOW_DIDYOUMEAN_BUTTON_INTERSECTION = 2;
    public static final int SHOW_DIDYOUMEAN_BUTTON_LABEL_ONLY = 3;
    private SearchFilter adbAddressDataFilter = new SearchFilter(new int[]{5}, null, 240, null);
    private SearchFilter adbNameFilter = new SearchFilter(new int[]{5}, null, 0, null);
    private SearchFilter historyFilter = new SearchFilter(new int[]{5, 1, 3, 4, 2, 7, 17, 11, 12, 6, 22}, null, 0, null);
    private SearchFilter favoritesFilter = new SearchFilter(new int[]{5, 1, 3, 4, 2, 7, 12, 6, 18, 19}, null, 0, null);
    private static final String LOGCLASS = "IntelliDestSearch";
    private static final int[] MAX_COUNT_PER_SOURCE_RESTRICTED = new int[]{Integer.MAX_VALUE, 2};
    private static final int[] MAX_COUNT_PER_SOURCE_UNRESTRICTED = new int[0];

    public IntelliDestSearch(IntelliDestController intelliDestController, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, int n, IVehicle iVehicle, LogChannel logChannel, NavigationEnv navigationEnv, LastDestSearch lastDestSearch) {
        super(bundleContext, iFrameworkAccess, logChannel, n);
        this.lastDestSearch = lastDestSearch;
        navigationEnv.getButtonModel(401871).setButtonListener(new DidYouMeanButtonListener());
        this.searchController = intelliDestController;
        this.vehicle = iVehicle;
        this.env = navigationEnv;
        this.refreshCarPosition();
    }

    protected void initDSI() {
        super.initDSI();
        Util.logStartupEvent(this.env.getFramework(), "[Startup] IntelliDestSearch#setDSI()");
        this.env.getChoiceModel(402529).setValue(TRUFFELS_NOT_AVAILABLE);
        this.setActiveProfile(0);
        this.setEnvironment();
        this.requestSupportedCountries();
        this.refreshCarPosition();
        this.setSearchFilterForSource(4);
        this.setSearchFilterForSource(5);
        this.setSearchFilterForSource(3);
    }

    protected Object getLock() {
        return super.getLock();
    }

    public IVehicle getVehicle() {
        return this.vehicle;
    }

    protected void clearAddressDataFilterForAdb() {
        this.setSearchFilter(3, this.adbNameFilter);
    }

    public void setSearchFilterForSource(int n) {
        if (n == 4) {
            this.setSearchFilter(4, this.historyFilter);
        } else if (n == 5) {
            this.setSearchFilter(5, this.favoritesFilter);
        } else if (n == 3) {
            this.setSearchFilter(3, this.adbAddressDataFilter);
        } else {
            this.logChannel.log(100000, "IntelliDestSearch#setSearchFilterForSource no filter for source %1", (long)n);
        }
    }

    public final void refreshCarPosition() {
        if (this.vehicle != null) {
            NavLocation navLocation = this.vehicle.getVehicleLocation();
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "%1#refreshCarPosition # longitude=%2 # latitude=%3", (Object)LOGCLASS, (long)navLocation.getLongitude(), (long)navLocation.getLatitude());
            }
            float f2 = (float)NavigationUtilities.wgs84ToDegree(navLocation.getLongitude());
            float f3 = (float)NavigationUtilities.wgs84ToDegree(navLocation.getLatitude());
            this.setCurrentPosition(new NavPosition(f3, f2));
        }
    }

    public void requestSupportedCountriesResult(int n, Country[] countryArray) {
        this.logChannel.log(10000000, "%1#requestSupportedCountriesResult # success=%3, countries=%2", (Object)LOGCLASS, (Object)Converter.array2String(countryArray), (long)n);
        this.searchController.updateCountries(countryArray);
        this.setActiveSearchCountries(this.searchController.getSelection());
    }

    public void setActiveSearchCountriesResult(int n) {
        this.logChannel.log(10000000, "%1#setActiveSearchCountriesResult # success=%2", (Object)LOGCLASS, (long)n);
        this.activeGuiSearchHandler.refreshQuery();
        this.lastDestSearch.refreshList();
    }

    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        if (n == 16 && this.navDbSourceAvailable) {
            this.navDbSourceAvailable = bl;
        } else if (n == 16) {
            this.navDbSourceAvailable = bl;
            if (bl) {
                this.requestSupportedCountries();
            }
        }
    }

    public void invalidateData(int[] nArray) {
        this.logChannel.log(10000000, "IntelliDestSearch#invalidateData # sources=%1", (Object)nArray);
        if (this.removeFromHistoryCalled) {
            this.removeFromHistoryCalled = false;
            return;
        }
        if (((AbstractNaviGuiSearchHandler)this.activeGuiSearchHandler).isActive()) {
            super.invalidateData(nArray);
        } else {
            if (nArray == null || this.activeGuiSearchHandler == null || this.activeGuiSearchHandler.getSources() == null) {
                return;
            }
            int[] nArray2 = this.activeGuiSearchHandler.getSources();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                for (int i3 = 0; i3 < nArray2.length; ++i3) {
                    if (nArray[i2] != nArray2[i3]) continue;
                    ((IntelliDestGuiSearchHandler)this.activeGuiSearchHandler).setInvalidateDataMissed(true);
                    return;
                }
            }
        }
    }

    public void removeFromHistory(long l) {
        super.removeFromHistory(l);
        this.removeFromHistoryCalled = true;
    }

    public void resetToFactorySettingsResult(int n) {
        this.logChannel.log(10000000, "IntelliDestSearch#resetToFactorySettingsResult # success=%1", (long)n);
        ((IntelliDestGuiSearchHandler)this.activeGuiSearchHandler).loadInitialScreen();
    }

    private void setEnvironment() {
        int n = this.framework.getSysApp().getDiagnosisCOD().getCountry();
        String string = "";
        String string2 = "";
        switch (n) {
            case 0: {
                this.logChannel.log(10000, "IntelliDestSearch#setEnvironment() no country coding available for %1", (long)n);
                break;
            }
            case 1: {
                string = "eu";
                string2 = "ER";
                break;
            }
            case 2: {
                string = "nar";
                string2 = "NAR";
                break;
            }
            case 3: {
                string = "msa";
                string2 = "ER";
                break;
            }
            case 4: {
                string = "korea";
                string2 = "KR";
                break;
            }
            case 5: {
                string = "china";
                string2 = "CN";
                break;
            }
            case 6: {
                string = "japan";
                string2 = "JP";
                break;
            }
            case 7: {
                string = "asia";
                string2 = "ER";
                break;
            }
            case 8: {
                string = "aus";
                string2 = "ER";
                break;
            }
            case 9: {
                string = "za";
                string2 = "ER";
                break;
            }
            case 10: {
                string = "neast";
                string2 = "ER";
                break;
            }
            case 11: {
                string = "za";
                string2 = "ER";
                break;
            }
            case 12: {
                string = "meast";
                string2 = "ER";
                break;
            }
            case 13: {
                string = "asia";
                string2 = "ER";
                break;
            }
            case 14: {
                string = "india";
                string2 = "ER";
                break;
            }
            case 15: {
                string = "il";
                string2 = "ER";
                break;
            }
            case 16: {
                string = "taiwan";
                string2 = "TW";
                break;
            }
            case 17: {
                string = "msa2";
                string2 = "ER";
                break;
            }
            default: {
                this.logChannel.log(10000, "IntelliDestSearch#setEnvironment() no country coding available for %1", (long)n);
            }
        }
        this.setEnvironment(new Environment("AU", string2, string, null));
    }

    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
        this.logChannel.log(10000000, "IntelliDestSearch#updatePotentialConflict conflictMatch=%1, conflictMode=%2, isConflict=%3, queryId=%4", (Object)conflictMatch, (long)(this.conflictMode ? 1 : 0), (long)(bl ? 1 : 0));
        int n3 = this.getLastQueryID();
        if (n != n3) {
            this.logChannel.log(10000000, "IntelliDestSearch#updatePotentialConflict recveived conflict for queryId %1 but currentQuerryId is %2", (long)n, (long)n3);
            return;
        }
        if (bl) {
            this.env.getLabelModel(401873).setText(this.getConflictButtonText(conflictMatch));
            if (!this.conflictMode) {
                switch (conflictMatch.type) {
                    case 1: {
                        this.env.getChoiceModel(401872).setValue(1);
                        break;
                    }
                    case 2: {
                        this.env.getChoiceModel(401872).setValue(2);
                        break;
                    }
                    default: {
                        this.logChannel.log(100000, "IntelliDestSearch#updatePotentialConflict received unknown ConflictMatch#type %1", (long)conflictMatch.type);
                        this.env.getChoiceModel(401872).setValue(3);
                    }
                }
            }
            if (this.conflictMode && !this.conflictMatchEqual(this.lastConflictMatch, conflictMatch)) {
                this.conflictMode = false;
                this.restartSearch();
            }
            this.lastConflictMatch = conflictMatch;
        } else {
            this.env.getChoiceModel(401872).setValue(0);
            if (this.conflictMode) {
                this.conflictMode = false;
                this.restartSearch();
            }
        }
    }

    private String getConflictButtonText(ConflictMatch conflictMatch) {
        if (conflictMatch == null) {
            return "";
        }
        if (conflictMatch.getCountry() != null) {
            Buffer buffer = new Buffer(conflictMatch.getToken().getToken());
            buffer.append(" (");
            buffer.append(conflictMatch.getCountry().getCode());
            buffer.append(")");
            return buffer.toString();
        }
        return conflictMatch.getToken().getToken();
    }

    private void onDidYouMeanPressed() {
        this.logChannel.log(10000000, "IntelliDestSearch#onDidYouMeanPressed()");
        this.conflictMode = true;
        this.restartSearch();
        this.env.getChoiceModel(401872).setValue(0);
    }

    protected void restartSearch() {
        String string = Util.isHURegionKR() ? this.env.getSpellerModel(402379).getText() : this.env.getSpellerModel(402563).getText();
        ((IntelliDestGuiSearchHandler)this.getActiveGuiSearchHandler()).performQuery(string, new String[0]);
    }

    private boolean conflictMatchEqual(ConflictMatch conflictMatch, ConflictMatch conflictMatch2) {
        if (conflictMatch == null || conflictMatch2 == null) {
            this.logChannel.log(10000, "IntelliDestSearch#conflictMatchEqual() lastConflictMatch=%1, conflictMatch=%2", (Object)conflictMatch, (Object)conflictMatch2);
            return false;
        }
        if (conflictMatch.token.wordType != conflictMatch2.token.wordType || !conflictMatch.token.token.equals(conflictMatch2.token.token)) {
            return false;
        }
        if (conflictMatch.country == null && conflictMatch2.country == null) {
            return true;
        }
        if (conflictMatch.country == null || conflictMatch2.country == null) {
            return false;
        }
        return conflictMatch.country.countryID == conflictMatch2.country.countryID && conflictMatch.country.houseNumberFormatting == conflictMatch2.country.houseNumberFormatting && this.stringsAreEqual(conflictMatch.country.code, conflictMatch2.country.code) && this.stringsAreEqual(conflictMatch.country.name, conflictMatch2.country.name) && this.stringsAreEqual(conflictMatch.country.stateAbbreviation, conflictMatch2.country.stateAbbreviation) && this.stringsAreEqual(conflictMatch.country.stateName, conflictMatch2.country.stateName);
    }

    private boolean stringsAreEqual(String string, String string2) {
        if (string == null && string2 == null) {
            return true;
        }
        if (string == null || string2 == null) {
            return false;
        }
        return string.equals(string2);
    }

    public void turnMaxResultRestrictionOn() {
        if (this.env.getFramework().getSysConst(4474) == 0) {
            this.setMaxCountPerSource(MAX_COUNT_PER_SOURCE_UNRESTRICTED);
        } else {
            this.setMaxCountPerSource(MAX_COUNT_PER_SOURCE_RESTRICTED);
        }
    }

    public void turnMaxResultRestrictionOff() {
        this.setMaxCountPerSource(MAX_COUNT_PER_SOURCE_UNRESTRICTED);
    }

    public void setLanguage(Language language) {
        super.setLanguage(language);
        this.env.getChoiceModel(402529).setValue(TRUFFELS_NOT_AVAILABLE);
        this.activeGuiSearchHandler.textChanged(0, "", ' ', 0);
    }

    public void setLanguageResult(int n) {
        super.setLanguageResult(n);
        this.env.getChoiceModel(402529).setValue(TRUFFELS_AVAILABLE);
    }

    public void setConflictMode(boolean bl) {
        this.conflictMode = bl;
    }

    private class DidYouMeanButtonListener
    extends DefaultButtonListener {
        private DidYouMeanButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            IntelliDestSearch.this.onDidYouMeanPressed();
        }
    }
}

