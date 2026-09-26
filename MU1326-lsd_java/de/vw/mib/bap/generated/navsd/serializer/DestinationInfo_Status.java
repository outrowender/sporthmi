/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.navsd.serializer.DestinationInfo_Status$Position;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DestinationInfo_Status
implements StatusProperty {
    public final DestinationInfo_Status$Position position = new DestinationInfo_Status$Position();
    public int totalNumOfStopovers;
    private static final int TOTAL_NUM_OF_STOPOVERS_BITSIZE;
    public int stopover_Sn;
    private static final int STOPOVER_SN_BITSIZE;
    public int poi_Type;
    private static final int POI_TYPE_BITSIZE;
    public static final int POI_TYPE_NO_POI;
    public static final int POI_TYPE_ACCOMMODATION;
    public static final int POI_TYPE_AIRPORT;
    public static final int POI_TYPE_ALL_RESTAURANTS;
    public static final int POI_TYPE_AMUSEMENT_PARK;
    public static final int POI_TYPE_APPAREL;
    public static final int POI_TYPE_ATM_CASHPOINT;
    public static final int POI_TYPE_ATTRACTION;
    public static final int POI_TYPE_AUTOMOBILE_CLUB;
    public static final int POI_TYPE_BANKING_AND_SHOPPING;
    public static final int POI_TYPE_BANKING;
    public static final int POI_TYPE_BANQUET_HALLS;
    public static final int POI_TYPE_BARS_AND_LOUNGE;
    public static final int POI_TYPE_BOATING;
    public static final int POI_TYPE_BOOKSTORE;
    public static final int POI_TYPE_BORDER_CROSS;
    public static final int POI_TYPE_BOWLING;
    public static final int POI_TYPE_BROADCASTING;
    public static final int POI_TYPE_BUSINESS_AND_SERVICE;
    public static final int POI_TYPE_BUSINESS;
    public static final int POI_TYPE_BUSSTATION;
    public static final int POI_TYPE_CAMPING;
    public static final int POI_TYPE_CAR_AND_TRAVEL;
    public static final int POI_TYPE_CAR_TRACK;
    public static final int POI_TYPE_CAR_TRAIN;
    public static final int POI_TYPE_CAR_SERVICE;
    public static final int POI_TYPE_CAR_WASH;
    public static final int POI_TYPE_CASINO;
    public static final int POI_TYPE_CEMETRY;
    public static final int POI_TYPE_CITYHALL;
    public static final int POI_TYPE_COFFEE;
    public static final int POI_TYPE_COMMUTER_RAILSTAION;
    public static final int POI_TYPE_CLEANING_LAUNCH;
    public static final int POI_TYPE_CLOTHING_STORE;
    public static final int POI_TYPE_COMMUNICATION;
    public static final int POI_TYPE_COMMUNITY_CENTER;
    public static final int POI_TYPE_COMPUTER_HARDWARE_SOFTWARE;
    public static final int POI_TYPE_CONVENIENCE_STORE;
    public static final int POI_TYPE_CONVENTION_CENTER;
    public static final int POI_TYPE_CORPORATIONS;
    public static final int POI_TYPE_CORPORATIONS_PUBLIC_PLACES;
    public static final int POI_TYPE_CULTURE_FACILITY;
    public static final int POI_TYPE_COURT;
    public static final int POI_TYPE_DEPARTMENT_STORE;
    public static final int POI_TYPE_DINING_AND_ENTERTAINMENT;
    public static final int POI_TYPE_DINNING_SHOPPING;
    public static final int POI_TYPE_DISCOUNT_STORE;
    public static final int POI_TYPE_EDUCATION;
    public static final int POI_TYPE_ELECTRONICS;
    public static final int POI_TYPE_EMBASSY;
    public static final int POI_TYPE_EMERGENCY;
    public static final int POI_TYPE_EMERGENCY_AND_PUBLIC;
    public static final int POI_TYPE_ENTERTAINMENT;
    public static final int POI_TYPE_FAST_FOOD;
    public static final int POI_TYPE_FERRY;
    public static final int POI_TYPE_FIRE_DEPARTMENT;
    public static final int POI_TYPE_FLOORING_AND_CARPETING;
    public static final int POI_TYPE_FLOWER_AND_JEWELRY;
    public static final int POI_TYPE_FOOD_AND_BEVERAGE;
    public static final int POI_TYPE_FUNERAL_DIRECTOR;
    public static final int POI_TYPE_FURNITURE;
    public static final int POI_TYPE_GAMES_MUSIC_AND_VIDEO;
    public static final int POI_TYPE_GARDEN_AND_OTHER;
    public static final int POI_TYPE_GASSTATION;
    public static final int POI_TYPE_GASSTATION_DIESEL_GASSTATION_LPG;
    public static final int POI_TYPE_GENERAL;
    public static final int POI_TYPE_GIFTS_AND_LEISURE;
    public static final int POI_TYPE_GIFTS_ANTIQUES_AND_ARTS;
    public static final int POI_TYPE_GLASS_AND_WINDOW;
    public static final int POI_TYPE_GOLFING;
    public static final int POI_TYPE_GOVERMENT;
    public static final int POI_TYPE_GROCERY_STORES;
    public static final int POI_TYPE_GUESTHOUSE;
    public static final int POI_TYPE_HAIR_AND_BEAUTY;
    public static final int POI_TYPE_HARBOR;
    public static final int POI_TYPE_HARDWARE_AND_LUMBER;
    public static final int POI_TYPE_HEALTH_AND_FITNESS;
    public static final int POI_TYPE_HEALTH_CARE;
    public static final int POI_TYPE_HIGHRISE_BLDG;
    public static final int POI_TYPE_HOME_AND_IMPROVMENT;
    public static final int POI_TYPE_HOME_CENTER;
    public static final int POI_TYPE_HOME_SERVICE;
    public static final int POI_TYPE_HOSPITAL;
    public static final int POI_TYPE_HOTEL_MOTEL;
    public static final int POI_TYPE_ICESKATING;
    public static final int POI_TYPE_INSURANCE;
    public static final int POI_TYPE_KARAOKAY;
    public static final int POI_TYPE_LIBRARY;
    public static final int POI_TYPE_LIQ_GAS_STATION;
    public static final int POI_TYPE_MAJOR_APPLIANCE;
    public static final int POI_TYPE_MENS_APPAREL;
    public static final int POI_TYPE_MONUMENT;
    public static final int POI_TYPE_MOTORWAY_EXIT;
    public static final int POI_TYPE_MOTORWAY_CROSS;
    public static final int POI_TYPE_MOTORWAY_SERVICE;
    public static final int POI_TYPE_MOVIE_THEATER;
    public static final int POI_TYPE_MOVING_AND_STORAGE;
    public static final int POI_TYPE_MUSEUM;
    public static final int POI_TYPE_NIGHTCLUBS;
    public static final int POI_TYPE_OPTICAL;
    public static final int POI_TYPE_RESTAURANT;
    public static final int POI_TYPE_PARK_AND_FITNESS;
    public static final int POI_TYPE_PARK_AND_RIDE;
    public static final int POI_TYPE_PARKING;
    public static final int POI_TYPE_PARKING_GARAGE;
    public static final int POI_TYPE_PARKS;
    public static final int POI_TYPE_PERFORMING_ARTS;
    public static final int POI_TYPE_PERSONAL_SERVICE;
    public static final int POI_TYPE_PHARMACIES;
    public static final int POI_TYPE_PHOTOGRAPHER;
    public static final int POI_TYPE_PLACE_OR_WORKSHIP;
    public static final int POI_TYPE_POLICE_STATION;
    public static final int POI_TYPE_POST_OFFICE;
    public static final int POI_TYPE_PUBLIC_PLACES;
    public static final int POI_TYPE_PUBLISHER;
    public static final int POI_TYPE_RAILWAY_STATION;
    public static final int POI_TYPE_RECREATION;
    public static final int POI_TYPE_RENTEL_SERVICE;
    public static final int POI_TYPE_REPAIR;
    public static final int POI_TYPE_REST_AREA;
    public static final int POI_TYPE_RETIREMENT_NURSING;
    public static final int POI_TYPE_SEARCH;
    public static final int POI_TYPE_SERVICE;
    public static final int POI_TYPE_SHOE_STORES;
    public static final int POI_TYPE_SHOPPING_CENTER;
    public static final int POI_TYPE_SKIING;
    public static final int POI_TYPE_SOCIAL_SERVICE;
    public static final int POI_TYPE_SPECIALITY_CLOTHING;
    public static final int POI_TYPE_SPECIALITY_STORE;
    public static final int POI_TYPE_SPECIALITY_FOOD;
    public static final int POI_TYPE_SPORT_GOODS;
    public static final int POI_TYPE_SPORTS;
    public static final int POI_TYPE_SPORT_AIRPORT;
    public static final int POI_TYPE_SPORTS_COMPLEX;
    public static final int POI_TYPE_TAILOR;
    public static final int POI_TYPE_TAX_SERVICE;
    public static final int POI_TYPE_TOOL_BOOTH;
    public static final int POI_TYPE_TOURIST_ATTRACTION;
    public static final int POI_TYPE_TOURIST_INFORMATION;
    public static final int POI_TYPE_TRAIN_STATION;
    public static final int POI_TYPE_TRANSPORTATION;
    public static final int POI_TYPE_TRAVEL;
    public static final int POI_TYPE_TRAVEL_AGENT;
    public static final int POI_TYPE_UNIVERSITY;
    public static final int POI_TYPE_UTILITIES;
    public static final int POI_TYPE_VARIETY_STORE;
    public static final int POI_TYPE_WINE_AND_LIQUOR;
    public static final int POI_TYPE_WOMENS_APPAREL;
    public static final int POI_TYPE_WINERY;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_VW;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_AUDI;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_SEAT;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_SKODA;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_VW_NUTZFAHRZEUGE;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_BENTLEY;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_BUGATTI;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_LAMBORGHINI;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_SCANIA;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_MAN;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_PORSCHE;
    public static final int POI_TYPE_ELECTRICAL_SERVICE_STATION;
    public static final int POI_TYPE_DIESEL_SERVICE_STATION;
    public static final int POI_TYPE_CNG_SERVICE_STATION;
    public static final int POI_TYPE_REST_AREA_AUTOHOF;
    public static final int POI_TYPE_REST_AREA_WITH_WC;
    public static final int POI_TYPE_MOTORWAY_SERVICE_AREA_RASTSTATTE;
    public static final int POI_TYPE_UNKNOWN;
    public final BAPString poi_Description = new BAPString(61);
    private static final int MAX_POI_DESCRIPTION_LENGTH;
    public final BAPString street = new BAPString(128);
    private static final int MAX_STREET_LENGTH;
    public final BAPString town = new BAPString(61);
    private static final int MAX_TOWN_LENGTH;
    public final BAPString state = new BAPString(61);
    private static final int MAX_STATE_LENGTH;
    public final BAPString postalCode = new BAPString(22);
    private static final int MAX_POSTAL_CODE_LENGTH;
    public final BAPString country = new BAPString(61);
    private static final int MAX_COUNTRY_LENGTH;

    public DestinationInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DestinationInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.totalNumOfStopovers = 0;
        this.stopover_Sn = 0;
        this.poi_Type = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.position.reset();
        this.poi_Description.reset();
        this.street.reset();
        this.town.reset();
        this.state.reset();
        this.postalCode.reset();
        this.country.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DestinationInfo_Status destinationInfo_Status = (DestinationInfo_Status)bAPEntity;
        return this.position.equalTo(destinationInfo_Status.position) && this.totalNumOfStopovers == destinationInfo_Status.totalNumOfStopovers && this.stopover_Sn == destinationInfo_Status.stopover_Sn && this.poi_Type == destinationInfo_Status.poi_Type && this.poi_Description.equalTo(destinationInfo_Status.poi_Description) && this.street.equalTo(destinationInfo_Status.street) && this.town.equalTo(destinationInfo_Status.town) && this.state.equalTo(destinationInfo_Status.state) && this.postalCode.equalTo(destinationInfo_Status.postalCode) && this.country.equalTo(destinationInfo_Status.country);
    }

    private void customInitialization() {
        this.postalCode.setLimitingLengthByCharacters();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DestinationInfo_Status:");
        stringBuffer.append("\n - Position - ");
        stringBuffer.append(this.position.toString());
        stringBuffer.append("\n - TotalNumOfStopovers - ");
        stringBuffer.append(this.totalNumOfStopovers);
        stringBuffer.append("\n - Stopover_SN - ");
        stringBuffer.append(this.stopover_Sn);
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
                stringBuffer.append("0xA1 (Diesel service station)");
                break;
            }
            case 162: {
                stringBuffer.append("0xA2 (CNG service station)");
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
        stringBuffer.append("\n - POI_Description - ");
        stringBuffer.append(this.poi_Description.toString());
        stringBuffer.append("\n - Street - ");
        stringBuffer.append(this.street.toString());
        stringBuffer.append("\n - Town - ");
        stringBuffer.append(this.town.toString());
        stringBuffer.append("\n - State - ");
        stringBuffer.append(this.state.toString());
        stringBuffer.append("\n - PostalCode - ");
        stringBuffer.append(this.postalCode.toString());
        stringBuffer.append("\n - Country - ");
        stringBuffer.append(this.country.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.position.bitSize();
        n += 8;
        n += 8;
        n += 8;
        n += this.poi_Description.bitSize();
        n += this.street.bitSize();
        n += this.town.bitSize();
        n += this.state.bitSize();
        n += this.postalCode.bitSize();
        return n += this.country.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.position.serialize(bitStream);
        bitStream.pushByte((byte)this.totalNumOfStopovers);
        bitStream.pushByte((byte)this.stopover_Sn);
        bitStream.pushByte((byte)this.poi_Type);
        this.poi_Description.serialize(bitStream);
        this.street.serialize(bitStream);
        this.town.serialize(bitStream);
        this.state.serialize(bitStream);
        this.postalCode.serialize(bitStream);
        this.country.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.position.deserialize(bitStream);
        this.totalNumOfStopovers = bitStream.popFrontByte();
        this.stopover_Sn = bitStream.popFrontByte();
        this.poi_Type = bitStream.popFrontByte();
        this.poi_Description.deserialize(bitStream);
        this.street.deserialize(bitStream);
        this.town.deserialize(bitStream);
        this.state.deserialize(bitStream);
        this.postalCode.deserialize(bitStream);
        this.country.deserialize(bitStream);
    }

    public static int functionId() {
        return 46;
    }

    @Override
    public int getFunctionId() {
        return DestinationInfo_Status.functionId();
    }
}

