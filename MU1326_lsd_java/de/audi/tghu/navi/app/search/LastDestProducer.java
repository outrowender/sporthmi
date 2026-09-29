/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.search.LastDestProducer$1;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class LastDestProducer {
    private IMyLocationAccessor locationAccessor;
    private final ICommandListFactory commandListFactory;
    protected final LogChannel logger;
    private final NavigationEnv env;

    public LastDestProducer(LogChannel logChannel, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv) {
        this.commandListFactory = iCommandListFactory;
        this.logger = logChannel;
        this.env = navigationEnv;
    }

    public void createAndSaveLastDestination(NavLocation navLocation, AbstractSearch abstractSearch) {
        if (navLocation == null) {
            this.logger.log(-1601830656, "LastDestProducer#createAndSaveLastDestination - navLocation is null");
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LocationToStreamCommand(navLocation));
        commandList.add(new LastDestProducer$1(this, "CreateLastDest", navLocation, abstractSearch));
        commandList.execute("CreateAndSaveLastDestCommandList");
    }

    private Token[] createTokens(NavLocation navLocation, SearchResult searchResult) {
        Object object;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        ArrayList arrayList = new ArrayList();
        Token token = null;
        Token token2 = null;
        if (searchResult.entryType == 260) {
            string9 = LocationFormatter.formatLocationTitle(navLocation);
            if (string9 != null && string9.length() > 0) {
                arrayList.add(new Token(5, string9, null));
            }
        } else if (searchResult.entryType == 2 && (string9 = LocationFormatter.formatPOIName(navLocation)) != null && string9.length() > 0) {
            arrayList.add(new Token(5, string9, null));
        }
        string9 = this.getCity(this.locationAccessor, navLocation);
        String string10 = this.getCityPart(this.locationAccessor, navLocation);
        if (string9 != null && string9.length() > 0) {
            token = new Token(1, string9, null);
            arrayList.add(token);
        }
        if (string10 != null && string10.length() > 0) {
            arrayList.add(new Token(2, string10, null));
        }
        if ((string8 = this.getStreet(this.locationAccessor, navLocation)) != null && string8.length() > 0) {
            token2 = new Token(3, string8, null);
            arrayList.add(token2);
        }
        if ((string7 = this.getPostCode(this.locationAccessor, navLocation)) != null && string7.length() > 0) {
            arrayList.add(new Token(4, string7, null));
        }
        if ((string6 = LocationFormatter.formatHousenumber(navLocation)) != null && string6.length() > 0) {
            arrayList.add(new Token(7, string6, null));
        }
        if ((string5 = LocationFormatter.formatCountry(navLocation)) != null && string5.length() > 0) {
            arrayList.add(new Token(17, string5, null));
        }
        if ((string4 = this.locationAccessor.getPoiCategory()) != null && string4.length() > 0) {
            arrayList.add(new Token(12, string4, null));
        }
        if ((string3 = LocationFormatter.formatState(navLocation)) != null && string3.length() > 0) {
            arrayList.add(new Token(6, string3, null));
        }
        if ((string2 = LocationFormatter.formatJunction(navLocation)) != null && string2.length() > 0) {
            arrayList.add(new Token(103, string2, null));
        }
        if (token == null && token2 == null) {
            string = new StringBuffer().append(navLocation.longitude).append("").toString();
            if (string != null && string.length() > 0) {
                arrayList.add(new Token(19, string, null));
            }
            if ((object = new StringBuffer().append(navLocation.latitude).append("").toString()) != null && ((String)object).length() > 0) {
                arrayList.add(new Token(18, (String)object, null));
            }
        }
        if ((string = Util.getAreaInfoFromLocation(navLocation)) != null && string.length() > 0) {
            arrayList.add(new Token(24, string, null));
        }
        this.createPhoneticsToken(arrayList, navLocation);
        object = new Token[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            object[i2] = (Token)arrayList.get(i2);
        }
        return object;
    }

    protected String getCity(IMyLocationAccessor iMyLocationAccessor, NavLocation navLocation) {
        String string = "";
        if (Util.isHURegionCN() || Util.isHURegionTW()) {
            string = iMyLocationAccessor.isTownOrder9() ? iMyLocationAccessor.getTownRefinement() : iMyLocationAccessor.getTown();
        } else if (Util.isHURegionJP() || Util.isHURegionKR()) {
            string = Util.isHURegionKR() && iMyLocationAccessor.isLocationInCityState() ? "" : iMyLocationAccessor.getTown();
        } else if (iMyLocationAccessor.isTownOrder9()) {
            string = LocationFormatter.formatCityRefinement(navLocation);
        } else {
            try {
                string = iMyLocationAccessor.getAdditionalLocationInformation(1);
            }
            catch (Exception exception) {
                this.logger.log(10000, "LastDestProducer#getCity - intentionally catched exception while getting city from locationaccessor: %1", (Object)exception.getMessage());
            }
            if (Util.isEmpty(string)) {
                string = iMyLocationAccessor.getTown();
            }
        }
        this.logger.log(-2137614336, "LastDestProducer#getCity - city: %1", (Object)string);
        return string;
    }

    protected String getCityPart(IMyLocationAccessor iMyLocationAccessor, NavLocation navLocation) {
        String string = "";
        if (Util.isHURegionCN() || Util.isHURegionTW()) {
            string = iMyLocationAccessor.isTownOrder9() ? iMyLocationAccessor.getTown() : "";
        } else if (Util.isHURegionJP()) {
            string = iMyLocationAccessor.getPlaceName();
        } else if (Util.isHURegionKR()) {
            string = iMyLocationAccessor.getSubmunicipalTown();
        } else if (iMyLocationAccessor.isTownOrder9()) {
            try {
                string = iMyLocationAccessor.getAdditionalLocationInformation(1);
            }
            catch (Exception exception) {
                this.logger.log(10000, "LastDestProducer#getCity - intentionally catched exception while getting city from locationaccessor: %1", (Object)exception.getMessage());
            }
        } else {
            string = LocationFormatter.formatStreetRefinement(navLocation);
        }
        this.logger.log(-2137614336, "LastDestProducer#getCityPart - getCityPart: %1", (Object)string);
        return string;
    }

    private String getStreet(IMyLocationAccessor iMyLocationAccessor, NavLocation navLocation) {
        String string = "";
        string = Util.isHURegionJP() ? iMyLocationAccessor.getChome() : (Util.isHURegionKR() ? (!Util.isEmpty(iMyLocationAccessor.getSubmunicipalTown()) && Util.isEmpty(iMyLocationAccessor.getStreet()) ? iMyLocationAccessor.getVillage() : LocationFormatter.formatStreet(navLocation)) : LocationFormatter.formatStreet(navLocation));
        return string;
    }

    private String getPostCode(IMyLocationAccessor iMyLocationAccessor, NavLocation navLocation) {
        String string = "";
        string = Util.isHURegionJP() || Util.isHURegionKR() ? iMyLocationAccessor.getWard() : LocationFormatter.formatZIPCode(navLocation);
        return string;
    }

    private int getEntryType(NavLocation navLocation, IMyLocationAccessor iMyLocationAccessor) {
        if (LocationFormatter.formatLocationTitle(navLocation) != null && LocationFormatter.formatLocationTitle(navLocation).length() > 0) {
            return 260;
        }
        if (LocationFormatter.formatPOIName(navLocation) != null && LocationFormatter.formatPOIName(navLocation).length() > 0) {
            return 2;
        }
        if (iMyLocationAccessor.getType() != 1 && Util.isGeoPosFlag(navLocation)) {
            return 22;
        }
        if (LocationFormatter.formatJunction(navLocation) != null && LocationFormatter.formatJunction(navLocation).length() > 0) {
            return 32;
        }
        if (LocationFormatter.formatStreet(navLocation) != null && LocationFormatter.formatStreet(navLocation).length() > 0) {
            return 4;
        }
        if (LocationFormatter.formatCity(navLocation) != null && LocationFormatter.formatCity(navLocation).length() > 0) {
            return 16;
        }
        return 1;
    }

    private void createPhoneticsToken(List list, NavLocation navLocation) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "LastDestProducer#createPhoneticsToken()");
        }
        String string = "";
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatPhonetics(navLocation, this.env);
        string = Util.isHURegionAsia() && (Util.isPorsche(this.env.getFramework()) || Util.isPorscheGen2(this.env.getFramework()) || Util.isBentley(this.env.getFramework())) ? locationFormattingResponse.getPhoneticsAsTextForPAGAsia(this.env) : locationFormattingResponse.getPhoneticsAsText();
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "LastDestProducer#createPhoneticsToken() --> Phonetics String: %1", (Object)string);
        }
        list.add(new Token(23, string, null));
    }

    static /* synthetic */ IMyLocationAccessor access$002(LastDestProducer lastDestProducer, IMyLocationAccessor iMyLocationAccessor) {
        lastDestProducer.locationAccessor = iMyLocationAccessor;
        return lastDestProducer.locationAccessor;
    }

    static /* synthetic */ IMyLocationAccessor access$000(LastDestProducer lastDestProducer) {
        return lastDestProducer.locationAccessor;
    }

    static /* synthetic */ int access$100(LastDestProducer lastDestProducer, NavLocation navLocation, IMyLocationAccessor iMyLocationAccessor) {
        return lastDestProducer.getEntryType(navLocation, iMyLocationAccessor);
    }

    static /* synthetic */ Token[] access$200(LastDestProducer lastDestProducer, NavLocation navLocation, SearchResult searchResult) {
        return lastDestProducer.createTokens(navLocation, searchResult);
    }
}

