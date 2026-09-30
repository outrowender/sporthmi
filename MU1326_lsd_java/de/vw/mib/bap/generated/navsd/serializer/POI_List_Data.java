/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class POI_List_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_DIRECTION_SYMBOLIC_POI_TYPE_DISTANCE_TYPE_DISTANCE_UNIT_MAIN_DESCRIPTION_STREET_CITY_POSTAL_CODE = 0;
    public static final int RECORD_ADDRESS_DISTANCE_UNIT_MAIN_DESCRIPTION_STREET_CITY_POSTAL_CODE = 1;
    public static final int RECORD_ADDRESS_DISTANCE_UNIT = 2;
    public static final int RECORD_ADDRESS_DIRECTION_SYMBOLIC = 3;
    public static final int RECORD_ADDRESS_MAIN_DESCRIPTION_STREET_CITY_POSTAL_CODE = 4;
    public static final int RECORD_ADDRESS_DIRECTION_SYMBOLIC_POI_TYPE_DISTANCE_TYPE_DISTANCE_UNIT_MAIN_DESCRIPTION = 5;
    public static final int RECORD_ADDRESS_POS = 15;
    private int pos;
    public int direction_Symbolic;
    private static final int DIRECTION_SYMBOLIC_BITSIZE = 8;
    public static final int DIRECTION_SYMBOLIC_N = 0;
    public static final int DIRECTION_SYMBOLIC_NNO = 1;
    public static final int DIRECTION_SYMBOLIC_NO = 2;
    public static final int DIRECTION_SYMBOLIC_ONO = 3;
    public static final int DIRECTION_SYMBOLIC_O = 4;
    public static final int DIRECTION_SYMBOLIC_OSO = 5;
    public static final int DIRECTION_SYMBOLIC_SO = 6;
    public static final int DIRECTION_SYMBOLIC_SSO = 7;
    public static final int DIRECTION_SYMBOLIC_S = 8;
    public static final int DIRECTION_SYMBOLIC_SSW = 9;
    public static final int DIRECTION_SYMBOLIC_SW = 10;
    public static final int DIRECTION_SYMBOLIC_WSW = 11;
    public static final int DIRECTION_SYMBOLIC_W = 12;
    public static final int DIRECTION_SYMBOLIC_WNW = 13;
    public static final int DIRECTION_SYMBOLIC_NW = 14;
    public static final int DIRECTION_SYMBOLIC_NNW = 15;
    public static final int DIRECTION_SYMBOLIC_NOT_SUPPORTED = 255;
    public int poi_Type;
    private static final int POI_TYPE_BITSIZE = 8;
    public static final int POI_TYPE_NO_POI = 0;
    public static final int POI_TYPE_ACCOMMODATION = 1;
    public static final int POI_TYPE_AIRPORT = 2;
    public static final int POI_TYPE_ALL_RESTAURANTS = 3;
    public static final int POI_TYPE_AMUSEMENT_PARK = 4;
    public static final int POI_TYPE_APPAREL = 5;
    public static final int POI_TYPE_ATM_CASHPOINT = 6;
    public static final int POI_TYPE_ATTRACTION = 7;
    public static final int POI_TYPE_AUTOMOBILE_CLUB = 8;
    public static final int POI_TYPE_BANKING_AND_SHOPPING = 9;
    public static final int POI_TYPE_BANKING = 10;
    public static final int POI_TYPE_BANQUET_HALLS = 11;
    public static final int POI_TYPE_BARS_AND_LOUNGE = 12;
    public static final int POI_TYPE_BOATING = 13;
    public static final int POI_TYPE_BOOKSTORE = 14;
    public static final int POI_TYPE_BORDER_CROSS = 15;
    public static final int POI_TYPE_BOWLING = 16;
    public static final int POI_TYPE_BROADCASTING = 17;
    public static final int POI_TYPE_BUSINESS_AND_SERVICE = 18;
    public static final int POI_TYPE_BUSINESS = 19;
    public static final int POI_TYPE_BUSSTATION = 20;
    public static final int POI_TYPE_CAMPING = 21;
    public static final int POI_TYPE_CAR_AND_TRAVEL = 22;
    public static final int POI_TYPE_CAR_TRACK = 23;
    public static final int POI_TYPE_CAR_TRAIN = 24;
    public static final int POI_TYPE_CAR_SERVICE = 25;
    public static final int POI_TYPE_CAR_WASH = 26;
    public static final int POI_TYPE_CASINO = 27;
    public static final int POI_TYPE_CEMETRY = 28;
    public static final int POI_TYPE_CITYHALL = 29;
    public static final int POI_TYPE_COFFEE = 30;
    public static final int POI_TYPE_COMMUTER_RAILSTAION = 31;
    public static final int POI_TYPE_CLEANING_LAUNCH = 32;
    public static final int POI_TYPE_CLOTHING_STORE = 33;
    public static final int POI_TYPE_COMMUNICATION = 34;
    public static final int POI_TYPE_COMMUNITY_CENTER = 35;
    public static final int POI_TYPE_COMPUTER_HARDWARE_SOFTWARE = 36;
    public static final int POI_TYPE_CONVENIENCE_STORE = 37;
    public static final int POI_TYPE_CONVENTION_CENTER = 38;
    public static final int POI_TYPE_CORPORATIONS = 39;
    public static final int POI_TYPE_CORPORATIONS_PUBLIC_PLACES = 40;
    public static final int POI_TYPE_CULTURE_FACILITY = 41;
    public static final int POI_TYPE_COURT = 42;
    public static final int POI_TYPE_DEPARTMENT_STORE = 43;
    public static final int POI_TYPE_DINING_AND_ENTERTAINMENT = 44;
    public static final int POI_TYPE_DINNING_SHOPPING = 45;
    public static final int POI_TYPE_DISCOUNT_STORE = 46;
    public static final int POI_TYPE_EDUCATION = 47;
    public static final int POI_TYPE_ELECTRONICS = 48;
    public static final int POI_TYPE_EMBASSY = 49;
    public static final int POI_TYPE_EMERGENCY = 50;
    public static final int POI_TYPE_EMERGENCY_AND_PUBLIC = 51;
    public static final int POI_TYPE_ENTERTAINMENT = 52;
    public static final int POI_TYPE_FAST_FOOD = 53;
    public static final int POI_TYPE_FERRY = 54;
    public static final int POI_TYPE_FIRE_DEPARTMENT = 55;
    public static final int POI_TYPE_FLOORING_AND_CARPETING = 56;
    public static final int POI_TYPE_FLOWER_AND_JEWELRY = 57;
    public static final int POI_TYPE_FOOD_AND_BEVERAGE = 58;
    public static final int POI_TYPE_FUNERAL_DIRECTOR = 59;
    public static final int POI_TYPE_FURNITURE = 60;
    public static final int POI_TYPE_GAMES_MUSIC_AND_VIDEO = 61;
    public static final int POI_TYPE_GARDEN_AND_OTHER = 62;
    public static final int POI_TYPE_GASSTATION = 63;
    public static final int POI_TYPE_GASSTATION_DIESEL_GASSTATION_LPG = 64;
    public static final int POI_TYPE_GENERAL = 65;
    public static final int POI_TYPE_GIFTS_AND_LEISURE = 66;
    public static final int POI_TYPE_GIFTS_ANTIQUES_AND_ARTS = 67;
    public static final int POI_TYPE_GLASS_AND_WINDOW = 68;
    public static final int POI_TYPE_GOLFING = 69;
    public static final int POI_TYPE_GOVERMENT = 70;
    public static final int POI_TYPE_GROCERY_STORES = 71;
    public static final int POI_TYPE_GUESTHOUSE = 72;
    public static final int POI_TYPE_HAIR_AND_BEAUTY = 73;
    public static final int POI_TYPE_HARBOR = 74;
    public static final int POI_TYPE_HARDWARE_AND_LUMBER = 75;
    public static final int POI_TYPE_HEALTH_AND_FITNESS = 76;
    public static final int POI_TYPE_HEALTH_CARE = 77;
    public static final int POI_TYPE_HIGHRISE_BLDG = 78;
    public static final int POI_TYPE_HOME_AND_IMPROVMENT = 79;
    public static final int POI_TYPE_HOME_CENTER = 80;
    public static final int POI_TYPE_HOME_SERVICE = 81;
    public static final int POI_TYPE_HOSPITAL = 82;
    public static final int POI_TYPE_HOTEL_MOTEL = 83;
    public static final int POI_TYPE_ICESKATING = 84;
    public static final int POI_TYPE_INSURANCE = 85;
    public static final int POI_TYPE_KARAOKAY = 86;
    public static final int POI_TYPE_LIBRARY = 87;
    public static final int POI_TYPE_LIQ_GAS_STATION = 88;
    public static final int POI_TYPE_MAJOR_APPLIANCE = 89;
    public static final int POI_TYPE_MENS_APPAREL = 90;
    public static final int POI_TYPE_MONUMENT = 91;
    public static final int POI_TYPE_MOTORWAY_EXIT = 92;
    public static final int POI_TYPE_MOTORWAY_CROSS = 93;
    public static final int POI_TYPE_MOTORWAY_SERVICE = 94;
    public static final int POI_TYPE_MOVIE_THEATER = 95;
    public static final int POI_TYPE_MOVING_AND_STORAGE = 96;
    public static final int POI_TYPE_MUSEUM = 97;
    public static final int POI_TYPE_NIGHTCLUBS = 98;
    public static final int POI_TYPE_OPTICAL = 99;
    public static final int POI_TYPE_RESTAURANT = 100;
    public static final int POI_TYPE_PARK_AND_FITNESS = 101;
    public static final int POI_TYPE_PARK_AND_RIDE = 102;
    public static final int POI_TYPE_PARKING = 103;
    public static final int POI_TYPE_PARKING_GARAGE = 104;
    public static final int POI_TYPE_PARKS = 105;
    public static final int POI_TYPE_PERFORMING_ARTS = 106;
    public static final int POI_TYPE_PERSONAL_SERVICE = 107;
    public static final int POI_TYPE_PHARMACIES = 108;
    public static final int POI_TYPE_PHOTOGRAPHER = 109;
    public static final int POI_TYPE_PLACE_OR_WORKSHIP = 110;
    public static final int POI_TYPE_POLICE_STATION = 111;
    public static final int POI_TYPE_POST_OFFICE = 112;
    public static final int POI_TYPE_PUBLIC_PLACES = 113;
    public static final int POI_TYPE_PUBLISHER = 114;
    public static final int POI_TYPE_RAILWAY_STATION = 115;
    public static final int POI_TYPE_RECREATION = 116;
    public static final int POI_TYPE_RENTEL_SERVICE = 117;
    public static final int POI_TYPE_REPAIR = 118;
    public static final int POI_TYPE_REST_AREA = 119;
    public static final int POI_TYPE_RETIREMENT_NURSING = 120;
    public static final int POI_TYPE_SEARCH = 121;
    public static final int POI_TYPE_SERVICE = 122;
    public static final int POI_TYPE_SHOE_STORES = 123;
    public static final int POI_TYPE_SHOPPING_CENTER = 124;
    public static final int POI_TYPE_SKIING = 125;
    public static final int POI_TYPE_SOCIAL_SERVICE = 126;
    public static final int POI_TYPE_SPECIALITY_CLOTHING = 127;
    public static final int POI_TYPE_SPECIALITY_STORE = 128;
    public static final int POI_TYPE_SPECIALITY_FOOD = 129;
    public static final int POI_TYPE_SPORT_GOODS = 130;
    public static final int POI_TYPE_SPORTS = 131;
    public static final int POI_TYPE_SPORT_AIRPORT = 132;
    public static final int POI_TYPE_SPORTS_COMPLEX = 133;
    public static final int POI_TYPE_TAILOR = 134;
    public static final int POI_TYPE_TAX_SERVICE = 135;
    public static final int POI_TYPE_TOOL_BOOTH = 136;
    public static final int POI_TYPE_TOURIST_ATTRACTION = 137;
    public static final int POI_TYPE_TOURIST_INFORMATION = 138;
    public static final int POI_TYPE_TRAIN_STATION = 139;
    public static final int POI_TYPE_TRANSPORTATION = 140;
    public static final int POI_TYPE_TRAVEL = 141;
    public static final int POI_TYPE_TRAVEL_AGENT = 142;
    public static final int POI_TYPE_UNIVERSITY = 143;
    public static final int POI_TYPE_UTILITIES = 144;
    public static final int POI_TYPE_VARIETY_STORE = 145;
    public static final int POI_TYPE_WINE_AND_LIQUOR = 146;
    public static final int POI_TYPE_WOMENS_APPAREL = 147;
    public static final int POI_TYPE_WINERY = 148;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_VW = 149;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_AUDI = 150;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_SEAT = 151;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_SKODA = 152;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_VW_NUTZFAHRZEUGE = 153;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_BENTLEY = 154;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_BUGATTI = 155;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_LAMBORGHINI = 156;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_SCANIA = 157;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_MAN = 158;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_PORSCHE = 159;
    public static final int POI_TYPE_ELECTRICAL_SERVICE_STATION = 160;
    public static final int POI_TYPE_DIESEL_FUEL_STATION = 161;
    public static final int POI_TYPE_CNG_FUEL_STATION = 162;
    public static final int POI_TYPE_REST_AREA_AUTOHOF = 163;
    public static final int POI_TYPE_REST_AREA_WITH_WC = 164;
    public static final int POI_TYPE_MOTORWAY_SERVICE_AREA_RASTSTATTE = 165;
    public static final int POI_TYPE_UNKNOWN = 255;
    public int distanceType;
    private static final int DISTANCE_TYPE_BITSIZE = 8;
    public static final int DISTANCE_TYPE_NO_DISTANCE_AVAILABLE = 0;
    public static final int DISTANCE_TYPE_LINEAR_DISTANCE_AIR_DISTANCE = 1;
    public static final int DISTANCE_TYPE_DISTANCE_ALONG_THE_STREET = 2;
    public int distance;
    private static final int DISTANCE_BITSIZE = 32;
    public int unit;
    private static final int UNIT_BITSIZE = 8;
    public static final int UNIT_METER = 0;
    public static final int UNIT_KILOMETER = 1;
    public static final int UNIT_YARD = 2;
    public static final int UNIT_FEET = 3;
    public static final int UNIT_MILE_UK_AND_US_STATUTE_MILE = 4;
    public static final int UNIT_QUARTER_MILES_N_1_4MILE = 5;
    public static final int UNIT_NOT_SUPPORTED_NO_INFORMATION_ABOUT_UNIT_AVAILABLE = 255;
    public final BAPString mainDescription;
    private static final int MAX_MAIN_DESCRIPTION_LENGTH = 91;
    public final BAPString street;
    private static final int MAX_STREET_LENGTH = 91;
    public final BAPString city;
    private static final int MAX_CITY_LENGTH = 91;
    public final BAPString postalCode;
    private static final int MAX_POSTAL_CODE_LENGTH = 22;

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public int getPos() {
        return this.pos;
    }

    public POI_List_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.mainDescription = new BAPString(91);
        this.street = new BAPString(91);
        this.city = new BAPString(91);
        this.postalCode = new BAPString(22);
        this.internalReset();
        this.customInitialization();
    }

    public POI_List_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.direction_Symbolic = 0;
        this.poi_Type = 0;
        this.distanceType = 0;
        this.distance = 0;
        this.unit = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.mainDescription.reset();
        this.street.reset();
        this.city.reset();
        this.postalCode.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        POI_List_Data pOI_List_Data = (POI_List_Data)bAPEntity;
        return this.arrayHeader.equalTo(pOI_List_Data.arrayHeader) && this.pos == pOI_List_Data.pos && this.direction_Symbolic == pOI_List_Data.direction_Symbolic && this.poi_Type == pOI_List_Data.poi_Type && this.distanceType == pOI_List_Data.distanceType && this.distance == pOI_List_Data.distance && this.unit == pOI_List_Data.unit && this.mainDescription.equalTo(pOI_List_Data.mainDescription) && this.street.equalTo(pOI_List_Data.street) && this.city.equalTo(pOI_List_Data.city) && this.postalCode.equalTo(pOI_List_Data.postalCode);
    }

    private void customInitialization() {
        this.mainDescription.setLimitingLengthByCharacters();
        this.street.setLimitingLengthByCharacters();
        this.city.setLimitingLengthByCharacters();
        this.postalCode.setLimitingLengthByCharacters();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("POI_List_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - Direction_Symbolic: ");
        switch (this.direction_Symbolic) {
            case 0: {
                stringBuffer.append("0x00 (N)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (NNO)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (NO)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (ONO)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (O)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (OSO)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (SO)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (SSO)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (S)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (SSW)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (SW)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (WSW)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (W)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (WNW)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (NW)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (NNW)");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (not supported  )");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - POI_Type: ");
        switch (this.poi_Type) {
            case 0: {
                stringBuffer.append("0x00 (no POI)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (Accommodation )");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (Airport )");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (all restaurants)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (Amusement Park )");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (Apparel )");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (ATM (cashpoint))");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (Attraction )");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (Automobile Club )");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (Banking and Shopping )");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (Banking )");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (Banquet-Halls )");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (Bars and Lounge )");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (Boating )");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (Bookstore )");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (Border Cross )");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (Bowling )");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (Broadcasting )");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (Business and Service )");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (Business )");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (Busstation )");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (Camping )");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (Car and Travel )");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (Car Track )");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (Car Train )");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (Car Service )");
                break;
            }
            case 26: {
                stringBuffer.append("0x1A (Car Wash )");
                break;
            }
            case 27: {
                stringBuffer.append("0x1B (Casino )");
                break;
            }
            case 28: {
                stringBuffer.append("0x1C (Cemetry )");
                break;
            }
            case 29: {
                stringBuffer.append("0x1D (Cityhall )");
                break;
            }
            case 30: {
                stringBuffer.append("0x1E (coffee )");
                break;
            }
            case 31: {
                stringBuffer.append("0x1F (Commuter Railstaion )");
                break;
            }
            case 32: {
                stringBuffer.append("0x20 (Cleaning Launch )");
                break;
            }
            case 33: {
                stringBuffer.append("0x21 (Clothing Store )");
                break;
            }
            case 34: {
                stringBuffer.append("0x22 (Communication )");
                break;
            }
            case 35: {
                stringBuffer.append("0x23 (Community Center )");
                break;
            }
            case 36: {
                stringBuffer.append("0x24 (Computer Hardware-Software )");
                break;
            }
            case 37: {
                stringBuffer.append("0x25 (Convenience Store )");
                break;
            }
            case 38: {
                stringBuffer.append("0x26 (Convention Center )");
                break;
            }
            case 39: {
                stringBuffer.append("0x27 (Corporations )");
                break;
            }
            case 40: {
                stringBuffer.append("0x28 (Corporations Public Places )");
                break;
            }
            case 41: {
                stringBuffer.append("0x29 (Culture Facility )");
                break;
            }
            case 42: {
                stringBuffer.append("0x2A (Court )");
                break;
            }
            case 43: {
                stringBuffer.append("0x2B (Department Store )");
                break;
            }
            case 44: {
                stringBuffer.append("0x2C (Dining and Entertainment )");
                break;
            }
            case 45: {
                stringBuffer.append("0x2D (Dinning Shopping )");
                break;
            }
            case 46: {
                stringBuffer.append("0x2E (Discount Store )");
                break;
            }
            case 47: {
                stringBuffer.append("0x2F (Education )");
                break;
            }
            case 48: {
                stringBuffer.append("0x30 (Electronics )");
                break;
            }
            case 49: {
                stringBuffer.append("0x31 (Embassy )");
                break;
            }
            case 50: {
                stringBuffer.append("0x32 (Emergency )");
                break;
            }
            case 51: {
                stringBuffer.append("0x33 (Emergency and Public )");
                break;
            }
            case 52: {
                stringBuffer.append("0x34 (Entertainment )");
                break;
            }
            case 53: {
                stringBuffer.append("0x35 (Fast Food )");
                break;
            }
            case 54: {
                stringBuffer.append("0x36 (Ferry )");
                break;
            }
            case 55: {
                stringBuffer.append("0x37 (Fire Department )");
                break;
            }
            case 56: {
                stringBuffer.append("0x38 (Flooring and Carpeting )");
                break;
            }
            case 57: {
                stringBuffer.append("0x39 (Flower and Jewelry )");
                break;
            }
            case 58: {
                stringBuffer.append("0x3A (Food and Beverage )");
                break;
            }
            case 59: {
                stringBuffer.append("0x3B (Funeral Director )");
                break;
            }
            case 60: {
                stringBuffer.append("0x3C (Furniture )");
                break;
            }
            case 61: {
                stringBuffer.append("0x3D (Games, Music and Video )");
                break;
            }
            case 62: {
                stringBuffer.append("0x3E (Garden and other )");
                break;
            }
            case 63: {
                stringBuffer.append("0x3F (Gasstation )");
                break;
            }
            case 64: {
                stringBuffer.append("0x40 (Gasstation DieselGasstation LPG )");
                break;
            }
            case 65: {
                stringBuffer.append("0x41 (General )");
                break;
            }
            case 66: {
                stringBuffer.append("0x42 (Gifts and Leisure )");
                break;
            }
            case 67: {
                stringBuffer.append("0x43 (Gifts- Antiques and Arts )");
                break;
            }
            case 68: {
                stringBuffer.append("0x44 (Glass and Window )");
                break;
            }
            case 69: {
                stringBuffer.append("0x45 (Golfing )");
                break;
            }
            case 70: {
                stringBuffer.append("0x46 (Goverment )");
                break;
            }
            case 71: {
                stringBuffer.append("0x47 (Grocery Stores )");
                break;
            }
            case 72: {
                stringBuffer.append("0x48 (Guesthouse )");
                break;
            }
            case 73: {
                stringBuffer.append("0x49 (Hair and Beauty )");
                break;
            }
            case 74: {
                stringBuffer.append("0x4A (Harbor )");
                break;
            }
            case 75: {
                stringBuffer.append("0x4B (Hardware and Lumber )");
                break;
            }
            case 76: {
                stringBuffer.append("0x4C (Health and Fitness )");
                break;
            }
            case 77: {
                stringBuffer.append("0x4D (Health- Care )");
                break;
            }
            case 78: {
                stringBuffer.append("0x4E (Highrise- BLDG )");
                break;
            }
            case 79: {
                stringBuffer.append("0x4F (Home and Improvment )");
                break;
            }
            case 80: {
                stringBuffer.append("0x50 (Home Center )");
                break;
            }
            case 81: {
                stringBuffer.append("0x51 (Home Service )");
                break;
            }
            case 82: {
                stringBuffer.append("0x52 (Hospital )");
                break;
            }
            case 83: {
                stringBuffer.append("0x53 (Hotel / Motel )");
                break;
            }
            case 84: {
                stringBuffer.append("0x54 (Iceskating )");
                break;
            }
            case 85: {
                stringBuffer.append("0x55 (Insurance )");
                break;
            }
            case 86: {
                stringBuffer.append("0x56 (Karaokay )");
                break;
            }
            case 87: {
                stringBuffer.append("0x57 (Library )");
                break;
            }
            case 88: {
                stringBuffer.append("0x58 (LIQ-Gas-Station )");
                break;
            }
            case 89: {
                stringBuffer.append("0x59 (Major-Appliance )");
                break;
            }
            case 90: {
                stringBuffer.append("0x5A (Mens-Apparel )");
                break;
            }
            case 91: {
                stringBuffer.append("0x5B (Monument )");
                break;
            }
            case 92: {
                stringBuffer.append("0x5C (Motorway Exit )");
                break;
            }
            case 93: {
                stringBuffer.append("0x5D (Motorway Cross )");
                break;
            }
            case 94: {
                stringBuffer.append("0x5E (Motorway Service )");
                break;
            }
            case 95: {
                stringBuffer.append("0x5F (Movie-Theater )");
                break;
            }
            case 96: {
                stringBuffer.append("0x60 (Moving and Storage )");
                break;
            }
            case 97: {
                stringBuffer.append("0x61 (Museum )");
                break;
            }
            case 98: {
                stringBuffer.append("0x62 (Nightclubs )");
                break;
            }
            case 99: {
                stringBuffer.append("0x63 (Optical )");
                break;
            }
            case 100: {
                stringBuffer.append("0x64 (Restaurant )");
                break;
            }
            case 101: {
                stringBuffer.append("0x65 (Park and Fitness )");
                break;
            }
            case 102: {
                stringBuffer.append("0x66 (Park and Ride )");
                break;
            }
            case 103: {
                stringBuffer.append("0x67 (Parking )");
                break;
            }
            case 104: {
                stringBuffer.append("0x68 (Parking Garage )");
                break;
            }
            case 105: {
                stringBuffer.append("0x69 (Parks )");
                break;
            }
            case 106: {
                stringBuffer.append("0x6A (Performing-Arts )");
                break;
            }
            case 107: {
                stringBuffer.append("0x6B (Personal- Service )");
                break;
            }
            case 108: {
                stringBuffer.append("0x6C (Pharmacies )");
                break;
            }
            case 109: {
                stringBuffer.append("0x6D (Photographer )");
                break;
            }
            case 110: {
                stringBuffer.append("0x6E (Place or workship )");
                break;
            }
            case 111: {
                stringBuffer.append("0x6F (Police Station )");
                break;
            }
            case 112: {
                stringBuffer.append("0x70 (Post Office )");
                break;
            }
            case 113: {
                stringBuffer.append("0x71 (Public Places )");
                break;
            }
            case 114: {
                stringBuffer.append("0x72 (Publisher )");
                break;
            }
            case 115: {
                stringBuffer.append("0x73 (Railway Station )");
                break;
            }
            case 116: {
                stringBuffer.append("0x74 (Recreation )");
                break;
            }
            case 117: {
                stringBuffer.append("0x75 (Rentel Service )");
                break;
            }
            case 118: {
                stringBuffer.append("0x76 (Repair )");
                break;
            }
            case 119: {
                stringBuffer.append("0x77 (Rest-Area )");
                break;
            }
            case 120: {
                stringBuffer.append("0x78 (Retirement Nursing )");
                break;
            }
            case 121: {
                stringBuffer.append("0x79 (Search  )");
                break;
            }
            case 122: {
                stringBuffer.append("0x7A (Service )");
                break;
            }
            case 123: {
                stringBuffer.append("0x7B (Shoe Stores )");
                break;
            }
            case 124: {
                stringBuffer.append("0x7C (Shopping Center )");
                break;
            }
            case 125: {
                stringBuffer.append("0x7D (Skiing )");
                break;
            }
            case 126: {
                stringBuffer.append("0x7E (Social Service )");
                break;
            }
            case 127: {
                stringBuffer.append("0x7F (Speciality-Clothing )");
                break;
            }
            case 128: {
                stringBuffer.append("0x80 (Speciality-Store )");
                break;
            }
            case 129: {
                stringBuffer.append("0x81 (Speciality-Food )");
                break;
            }
            case 130: {
                stringBuffer.append("0x82 (Sport-Goods )");
                break;
            }
            case 131: {
                stringBuffer.append("0x83 (Sports )");
                break;
            }
            case 132: {
                stringBuffer.append("0x84 (Sport Airport )");
                break;
            }
            case 133: {
                stringBuffer.append("0x85 (Sports-Complex )");
                break;
            }
            case 134: {
                stringBuffer.append("0x86 (Tailor )");
                break;
            }
            case 135: {
                stringBuffer.append("0x87 (Tax-Service )");
                break;
            }
            case 136: {
                stringBuffer.append("0x88 (Tool-Booth )");
                break;
            }
            case 137: {
                stringBuffer.append("0x89 (Tourist Attraction )");
                break;
            }
            case 138: {
                stringBuffer.append("0x8A (Tourist Information )");
                break;
            }
            case 139: {
                stringBuffer.append("0x8B (Train Station )");
                break;
            }
            case 140: {
                stringBuffer.append("0x8C (Transportation )");
                break;
            }
            case 141: {
                stringBuffer.append("0x8D (Travel )");
                break;
            }
            case 142: {
                stringBuffer.append("0x8E (Travel-Agent )");
                break;
            }
            case 143: {
                stringBuffer.append("0x8F (University )");
                break;
            }
            case 144: {
                stringBuffer.append("0x90 (Utilities )");
                break;
            }
            case 145: {
                stringBuffer.append("0x91 (Variety-Store )");
                break;
            }
            case 146: {
                stringBuffer.append("0x92 (Wine and Liquor )");
                break;
            }
            case 147: {
                stringBuffer.append("0x93 (Womens Apparel )");
                break;
            }
            case 148: {
                stringBuffer.append("0x94 (Winery )");
                break;
            }
            case 149: {
                stringBuffer.append("0x95 (car repair shop - VW)");
                break;
            }
            case 150: {
                stringBuffer.append("0x96 (car repair shop - Audi)");
                break;
            }
            case 151: {
                stringBuffer.append("0x97 (car repair shop - Seat)");
                break;
            }
            case 152: {
                stringBuffer.append("0x98 (car repair shop - Skoda)");
                break;
            }
            case 153: {
                stringBuffer.append("0x99 (car repair shop - VW Nutzfahrzeuge)");
                break;
            }
            case 154: {
                stringBuffer.append("0x9A (car repair shop - Bentley)");
                break;
            }
            case 155: {
                stringBuffer.append("0x9B (car repair shop - Bugatti)");
                break;
            }
            case 156: {
                stringBuffer.append("0x9C (car repair shop - Lamborghini)");
                break;
            }
            case 157: {
                stringBuffer.append("0x9D (car repair shop - Scania)");
                break;
            }
            case 158: {
                stringBuffer.append("0x9E (car repair shop - MAN)");
                break;
            }
            case 159: {
                stringBuffer.append("0x9F (car repair shop - Porsche)");
                break;
            }
            case 160: {
                stringBuffer.append("0xA0 (electrical service station)");
                break;
            }
            case 161: {
                stringBuffer.append("0xA1 (Diesel fuel station)");
                break;
            }
            case 162: {
                stringBuffer.append("0xA2 (CNG fuel station)");
                break;
            }
            case 163: {
                stringBuffer.append("0xA3 (rest area (\\\"Autohof\\\"))");
                break;
            }
            case 164: {
                stringBuffer.append("0xA4 (rest area with WC)");
                break;
            }
            case 165: {
                stringBuffer.append("0xA5 (motorway service area (\\\"Rastst\u00e4tte\\\"))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unknown )");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - DistanceType: ");
        switch (this.distanceType) {
            case 0: {
                stringBuffer.append("0x00 (no distance available)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (linear distance (air distance))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (distance along the street)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Distance - ");
        stringBuffer.append(this.distance);
        stringBuffer.append("\n - Unit: ");
        switch (this.unit) {
            case 0: {
                stringBuffer.append("0x00 (meter)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (kilometer)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (yard)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (feet)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (mile (UK and US (statute mile)))");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (quarter mile(s) (n* 1/4mile))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (not supported / no information about unit available)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - MainDescription - ");
        stringBuffer.append(this.mainDescription.toString());
        stringBuffer.append("\n - Street - ");
        stringBuffer.append(this.street.toString());
        stringBuffer.append("\n - City - ");
        stringBuffer.append(this.city.toString());
        stringBuffer.append("\n - PostalCode - ");
        stringBuffer.append(this.postalCode.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += 8;
                n += 8;
                n += 32;
                n += 8;
                n += this.mainDescription.bitSize();
                n += this.street.bitSize();
                n += this.city.bitSize();
                n += this.postalCode.bitSize();
                break;
            }
            case 1: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 32;
                n += 8;
                n += this.mainDescription.bitSize();
                n += this.street.bitSize();
                n += this.city.bitSize();
                n += this.postalCode.bitSize();
                break;
            }
            case 2: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 32;
                n += 8;
                break;
            }
            case 3: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                break;
            }
            case 4: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.mainDescription.bitSize();
                n += this.street.bitSize();
                n += this.city.bitSize();
                n += this.postalCode.bitSize();
                break;
            }
            case 5: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += 8;
                n += 8;
                n += 32;
                n += 8;
                n += this.mainDescription.bitSize();
                break;
            }
            case 15: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                break;
            }
        }
        return n;
    }

    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.direction_Symbolic);
                bitStream.pushByte((byte)this.poi_Type);
                bitStream.pushByte((byte)this.distanceType);
                bitStream.pushInt(this.distance);
                bitStream.pushByte((byte)this.unit);
                this.mainDescription.serialize(bitStream);
                this.street.serialize(bitStream);
                this.city.serialize(bitStream);
                this.postalCode.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushInt(this.distance);
                bitStream.pushByte((byte)this.unit);
                this.mainDescription.serialize(bitStream);
                this.street.serialize(bitStream);
                this.city.serialize(bitStream);
                this.postalCode.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushInt(this.distance);
                bitStream.pushByte((byte)this.unit);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.direction_Symbolic);
                break;
            }
            case 4: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.mainDescription.serialize(bitStream);
                this.street.serialize(bitStream);
                this.city.serialize(bitStream);
                this.postalCode.serialize(bitStream);
                break;
            }
            case 5: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.direction_Symbolic);
                bitStream.pushByte((byte)this.poi_Type);
                bitStream.pushByte((byte)this.distanceType);
                bitStream.pushInt(this.distance);
                bitStream.pushByte((byte)this.unit);
                this.mainDescription.serialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.direction_Symbolic = bitStream.popFrontByte();
                this.poi_Type = bitStream.popFrontByte();
                this.distanceType = bitStream.popFrontByte();
                this.distance = bitStream.popFrontInt();
                this.unit = bitStream.popFrontByte();
                this.mainDescription.deserialize(bitStream);
                this.street.deserialize(bitStream);
                this.city.deserialize(bitStream);
                this.postalCode.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.distance = bitStream.popFrontInt();
                this.unit = bitStream.popFrontByte();
                this.mainDescription.deserialize(bitStream);
                this.street.deserialize(bitStream);
                this.city.deserialize(bitStream);
                this.postalCode.deserialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.distance = bitStream.popFrontInt();
                this.unit = bitStream.popFrontByte();
                break;
            }
            case 3: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.direction_Symbolic = bitStream.popFrontByte();
                break;
            }
            case 4: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.mainDescription.deserialize(bitStream);
                this.street.deserialize(bitStream);
                this.city.deserialize(bitStream);
                this.postalCode.deserialize(bitStream);
                break;
            }
            case 5: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.direction_Symbolic = bitStream.popFrontByte();
                this.poi_Type = bitStream.popFrontByte();
                this.distanceType = bitStream.popFrontByte();
                this.distance = bitStream.popFrontInt();
                this.unit = bitStream.popFrontByte();
                this.mainDescription.deserialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }
}

