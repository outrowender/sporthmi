/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.interapp.NaviService$NaviDetails;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormatAddress;
import de.audi.tghu.navi.app.util.addressformatting.FormatAddressAsDefault;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressCNEnglishEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressCNNativeEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressEUEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressJPEnglishEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressJPNativeEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressKREnglishEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressKRNativeEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressNarEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressRdWEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressTWEnglishEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressTWNativeEvo;
import de.audi.tghu.navi.app.util.addressformatting.pgen2.FormatAddressEUPGen2;
import de.audi.tghu.navi.app.util.addressformatting.pgen2.FormatAddressNARPGen2;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressCNEnglishPAG;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressCNNativePAG;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressEUPAG;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressJPEnglishPAG;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressJPNativePAG;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressKREnglishPAG;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressKRNativePAG;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressNARPAG;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressRdWPAG;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressTWEnglishPAG;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressTWNativePAG;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.search.SearchResult;

class AddressFormatter$VariantSpecificFormatter {
    private FormatAddress format;
    private NavigationEnv env;

    public AddressFormatter$VariantSpecificFormatter(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.format = Util.isPorsche(navigationEnv.getFramework()) ? this.getPorscheFormatter() : (Util.isPorscheGen2(navigationEnv.getFramework()) ? this.getPGen2Formatter(navigationEnv) : this.getAudiFormatter());
    }

    public LocationFormattingResponse formatOneLine(NavLocation navLocation) {
        return this.format.asSingleLine(navLocation, this.env);
    }

    public LocationFormattingResponse formatOneLine(NavLocation navLocation, boolean bl) {
        return this.format.asSingleLine(navLocation, this.env, bl);
    }

    public LocationFormattingResponse formatOneLine(SearchResult searchResult) {
        return this.format.asSingleLine(searchResult, this.env);
    }

    public LocationFormattingResponse formatOneLine(NaviService$NaviDetails naviService$NaviDetails) {
        return this.format.asSingleLine(naviService$NaviDetails, this.env);
    }

    public LocationFormattingResponse formatOneLine(LocationFormattingRequest locationFormattingRequest) {
        return this.format.asSingleLine(locationFormattingRequest);
    }

    public LocationFormattingResponse formatTwoLines(NavLocation navLocation, boolean bl) {
        return this.format.asTwoLines(navLocation, this.env, bl);
    }

    public LocationFormattingResponse formatTwoLines(NavLocation navLocation, boolean bl, boolean bl2) {
        return this.format.asTwoLines(navLocation, this.env, bl, bl2);
    }

    public LocationFormattingResponse formatTwoLines(SearchResult searchResult) {
        return this.format.asTwoLines(searchResult, this.env);
    }

    public LocationFormattingResponse formatTwoLines(OperatorCallResult operatorCallResult) {
        return this.format.asTwoLines(operatorCallResult, this.env);
    }

    public LocationFormattingResponse formatTwoLines(LocationFormattingRequest locationFormattingRequest) {
        return this.format.asTwoLines(locationFormattingRequest);
    }

    public LocationFormattingResponse formatTwoLines(NaviService$NaviDetails naviService$NaviDetails) {
        return this.format.asTwoLines(naviService$NaviDetails, this.env);
    }

    public LocationFormattingResponse formatThreeLines(NavLocation navLocation, boolean bl) {
        return this.format.asThreeLines(navLocation, this.env, bl);
    }

    public LocationFormattingResponse formatThreeLines(SearchResult searchResult) {
        return this.format.asThreeLines(searchResult, this.env);
    }

    public LocationFormattingResponse formatThreeLines(OperatorCallResult operatorCallResult) {
        return this.format.asThreeLines(operatorCallResult, this.env);
    }

    public LocationFormattingResponse formatThreeLines(NaviService$NaviDetails naviService$NaviDetails) {
        return this.format.asThreeLines(naviService$NaviDetails, this.env);
    }

    public LocationFormattingResponse formatThreeLines(LocationFormattingRequest locationFormattingRequest) {
        return this.format.asThreeLines(locationFormattingRequest);
    }

    private FormatAddress getAudiFormatter() {
        int n = this.env.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
        if (Util.isHURegionCN()) {
            if (n == 14 || n == 23) {
                return new FormatAddressCNNativeEvo(this.env);
            }
            return new FormatAddressCNEnglishEvo(this.env);
        }
        if (Util.isHURegionEU() || Util.isHURegionRdW()) {
            return new FormatAddressEUEvo(this.env);
        }
        if (Util.isHURegionJP()) {
            if (n == 12) {
                return new FormatAddressJPNativeEvo(this.env);
            }
            return new FormatAddressJPEnglishEvo(this.env);
        }
        if (Util.isHURegionKR()) {
            if (n == 16) {
                return new FormatAddressKRNativeEvo(this.env);
            }
            return new FormatAddressKREnglishEvo(this.env);
        }
        if (Util.isHURegionNAR()) {
            return new FormatAddressNarEvo(this.env);
        }
        if (Util.isHURegionRdW()) {
            return new FormatAddressRdWEvo(this.env);
        }
        if (Util.isHURegionTW()) {
            if (n == 24) {
                return new FormatAddressTWNativeEvo(this.env);
            }
            return new FormatAddressTWEnglishEvo(this.env);
        }
        return new FormatAddressAsDefault(this.env);
    }

    private FormatAddress getPorscheFormatter() {
        int n = this.env.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
        if (Util.isHURegionCN()) {
            if (n == 14 || n == 23) {
                return new FormatAddressCNNativePAG(this.env);
            }
            return new FormatAddressCNEnglishPAG(this.env);
        }
        if (Util.isHURegionEU()) {
            return new FormatAddressEUPAG(this.env);
        }
        if (Util.isHURegionJP()) {
            if (n == 12) {
                return new FormatAddressJPNativePAG(this.env);
            }
            return new FormatAddressJPEnglishPAG(this.env);
        }
        if (Util.isHURegionKR()) {
            if (n == 16) {
                return new FormatAddressKRNativePAG(this.env);
            }
            return new FormatAddressKREnglishPAG(this.env);
        }
        if (Util.isHURegionNAR()) {
            return new FormatAddressNARPAG(this.env);
        }
        if (Util.isHURegionRdW()) {
            return new FormatAddressRdWPAG(this.env);
        }
        if (Util.isHURegionTW()) {
            if (n == 24) {
                return new FormatAddressTWNativePAG(this.env);
            }
            return new FormatAddressTWEnglishPAG(this.env);
        }
        return new FormatAddressAsDefault(this.env);
    }

    private FormatAddress getPGen2Formatter(NavigationEnv navigationEnv) {
        if (Util.isHURegionEU()) {
            return new FormatAddressEUPGen2(navigationEnv);
        }
        if (Util.isHURegionNAR()) {
            return new FormatAddressNARPGen2(navigationEnv);
        }
        return this.getPorscheFormatter();
    }
}

