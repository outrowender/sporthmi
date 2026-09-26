/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class Selcrit {
    private static final String CLASS_NAME = Util.getClassNameFromPackageName(class$de$audi$tghu$navi$app$util$Selcrit == null ? (class$de$audi$tghu$navi$app$util$Selcrit = Selcrit.class$("de.audi.tghu.navi.app.util.Selcrit")) : class$de$audi$tghu$navi$app$util$Selcrit);
    static /* synthetic */ Class class$de$audi$tghu$navi$app$util$Selcrit;

    public static String asString(int[] nArray) {
        Buffer buffer = new Buffer();
        buffer.append("[");
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                buffer.append(Selcrit.asString(nArray[i2]));
                if (i2 + 1 >= nArray.length) continue;
                buffer.append(", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static String asString(int n) {
        Buffer buffer = new Buffer();
        switch (n) {
            case 0: {
                buffer.append("SELCRITDES_RESERVED");
                break;
            }
            case 1: {
                buffer.append("SELCRITDES_COUNTRY");
                break;
            }
            case 2: {
                buffer.append("SELCRITDES_TOWN");
                break;
            }
            case 3: {
                buffer.append("SELCRITDES_STREET");
                break;
            }
            case 4: {
                buffer.append("SELCRITDES_JUNCTION");
                break;
            }
            case 5: {
                buffer.append("SELCRITDES_HOUSENUMBER");
                break;
            }
            case 6: {
                buffer.append("SELCRITDES_ZIP_CODE");
                break;
            }
            case 8: {
                buffer.append("SELCRITDES_TELEPHONENUMBER");
                break;
            }
            case 16: {
                buffer.append("SELCRITDES_TOWNCENTER");
                break;
            }
            case 133: {
                buffer.append("SELCRITDES_LICENSEPLATE_CODE");
                break;
            }
            case 134: {
                buffer.append("SELCRITDES_VIAPOINTCOUNTRYLIST");
                break;
            }
            case 135: {
                buffer.append("SELCRITDES_HOUSENUMBER_FREETEXT");
                break;
            }
            case 136: {
                buffer.append("SELCRITDES_HOUSENUMBER_ALTERNATIVES");
                break;
            }
            case 137: {
                buffer.append("SELCRITDES_TOWN_AND_ZIP");
                break;
            }
            case 138: {
                buffer.append("SELCRITDES_STATE");
                break;
            }
            case 139: {
                buffer.append("SELCRITDES_COUNTRY_STATE");
                break;
            }
            case 140: {
                buffer.append("SELCRITDES_HOUSENUMBER_EXTENDED_ALTERNATIVES");
                break;
            }
            case 141: {
                buffer.append("SELCRITDES_STREET_FULLNAME");
                break;
            }
            case 142: {
                buffer.append("SELCRITDES_MAPCODE");
                break;
            }
            case 143: {
                buffer.append("SELCRITDES_DISTRICT");
                break;
            }
            case 144: {
                buffer.append("SELCRITDES_CHOME");
                break;
            }
            case 145: {
                buffer.append("SELCRITDES_TOWN_WITHOUTDISTRICT");
                break;
            }
            case 146: {
                buffer.append("SELCRITDES_POI_BY_BUILDING");
                break;
            }
            case 147: {
                buffer.append("SELCRITDES_PLACENAME");
                break;
            }
            case 148: {
                buffer.append("SELCRITDES_SUBMUNICIPALTOWN");
                break;
            }
            case 149: {
                buffer.append("SELCRITDES_VILLAGE");
                break;
            }
            case 150: {
                buffer.append("SELCRITDES_SUBMUNICIPALTOWN_AND_STREET");
                break;
            }
            case 151: {
                buffer.append("SELCRITDES_VILLAGE_AND_STREET");
                break;
            }
            case 152: {
                buffer.append("SELCRITDES_WARD");
                break;
            }
            case 153: {
                buffer.append("SELCRITDES_POI_BY_TPEG");
                break;
            }
            case 154: {
                buffer.append("SELCRITDES_HOUSENUMBER_BYSDS");
                break;
            }
            case 124: {
                buffer.append("SELCRITDES_GEOGRAPHICAL_POSITION");
                break;
            }
            case 125: {
                buffer.append("SELCRITDES_REFINEBYADDITONALCRITERIA");
                break;
            }
            case 127: {
                buffer.append("SELCRITDES_REFINEBYASSOCIATION");
                break;
            }
            case 32768: {
                buffer.append("SELCRITDES_POI");
                break;
            }
            case 32769: {
                buffer.append("SELCRITDES_POI_BY_CLASS");
                break;
            }
            case 32770: {
                buffer.append("SELCRITDES_POI_BY_CATEGORY");
                break;
            }
            case 32771: {
                buffer.append("SELCRITDES_POI_BY_NAME");
                break;
            }
            case 32772: {
                buffer.append("SELCRITDES_POI_BY_CHILD");
                break;
            }
            case 32773: {
                buffer.append("SELCRITDES_POI_BY_CHILD_CLASS");
                break;
            }
            case 32774: {
                buffer.append("SELCRITDES_POI_BY_CHILD_CATEGORY");
                break;
            }
            case 32775: {
                buffer.append("SELCRITDES_POI_BY_CHILD_NAME");
                break;
            }
            case 32776: {
                buffer.append("SELCRITDES_POI_BY_PHONE");
                break;
            }
            case 32777: {
                buffer.append("SELCRITDES_POI_BY_TOP_POI");
                break;
            }
            case 32778: {
                buffer.append("SELCRITDES_POI_BY_SUBSTRING");
                break;
            }
            case 32779: {
                buffer.append("SELCRITDES_POI_BY_THESAURUS");
                break;
            }
            case 32780: {
                buffer.append("SELCRITDES_POI_BY_PARENT_POI");
                break;
            }
            case 32781: {
                buffer.append("SELCRITDES_POI_BY_STACK");
                break;
            }
            case 32782: {
                buffer.append("SELCRITDES_STREET_FIRST");
                break;
            }
            case 32783: {
                buffer.append("SELCRITDES_POI_CATEGORY_BY_UID");
                break;
            }
            case 122: {
                buffer.append("SELCRITDES_ROAD_DISTANCE");
                break;
            }
            case 121: {
                buffer.append("SELCRITDES_NAVIGATION_INTERNAL_DATA");
                break;
            }
            case 123: {
                buffer.append("SELCRITDES_AIR_DISTANCE");
                break;
            }
            case 126: {
                buffer.append("SELCRITDES_REFINEBYINCLUSION");
                break;
            }
            case 263: {
                buffer.append("SELCRITDES_COUNTRYABBREVIATION");
                break;
            }
            case 281: {
                buffer.append("SELCRITDES_SEGMENTID");
                break;
            }
            case 282: {
                buffer.append("SELCRITDES_SUBICONINDEX");
                break;
            }
            case 520: {
                buffer.append("SELCRITDES_ICONINDEX");
                break;
            }
            case 768: {
                buffer.append("SELCRITDES_MMI_INTERNAL_DATA");
                break;
            }
            case 1279: {
                buffer.append("SELCRITDES_POI_INDEX");
                break;
            }
            case 1281: {
                buffer.append("SELCRITDES_XAC_POI");
                break;
            }
            case 1455: {
                buffer.append("SELCRITDES_XAC_POI_MAX");
                break;
            }
            case 4096: {
                buffer.append("SELCRITDES_INDEX_TYPE");
                break;
            }
            case 4097: {
                buffer.append("SELCRITDES_INDEX_VALUE");
                break;
            }
            case 16641: {
                buffer.append("SELCRITDES_POI_INDEX_NAME");
                break;
            }
            case 16642: {
                buffer.append("SELCRITDES_POI_INDEX_TYPE");
                break;
            }
            case 32784: {
                buffer.append("SELCRITDES_POI_ADDITIONAL_FLAGS");
                break;
            }
            case 32785: {
                buffer.append("SELCRITDES_POI_MULTISUBSTRING");
                break;
            }
            case 32786: {
                buffer.append("SELCRITDES_POI_FROMPOIINFO");
                break;
            }
            case 65535: {
                buffer.append("SELCRITDES_MAX");
                break;
            }
            case 16384: {
                buffer.append("SELCRITDES_SSPVDE_ADMINID");
                break;
            }
            case 16385: {
                buffer.append("SELCRITDES_SSPVDE_CLUSTERID");
                break;
            }
            case 16386: {
                buffer.append("SELCRITDES_SSPVDE_EXPORTZONE");
                break;
            }
            case 128: {
                buffer.append("SELCRITDES_URLADDRESS");
                break;
            }
            case 129: {
                buffer.append("SELCRITDES_COUNTRIES_WITH_VIGNETTE");
                break;
            }
            case 130: {
                buffer.append("SELCRITDES_CITIES_WITH_VIGNETTE");
                break;
            }
            case 131: {
                buffer.append("SELCRITDES_VIAPOINTS");
                break;
            }
            default: {
                return buffer.append("SELCRITDES_").append(n).append(" (no match found in ").append(CLASS_NAME).append("#asString, check the mapping there!)").toString();
            }
        }
        return buffer.append(" (").append(n).append(")").toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

