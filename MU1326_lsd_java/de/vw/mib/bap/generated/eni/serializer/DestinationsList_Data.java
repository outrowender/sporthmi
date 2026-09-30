/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class DestinationsList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_NAME_POSITION_LATITUDE_POSITION_LONGITUDE_TYPE_OF_DESTINATION_POI_TYPE_POI_EXTENSION_TOUR_ID_STOPOVER_SN_ADDR_STREET_ADDR_NUMBER_ADDR_TOWN_ADDR_STATE_ADDR_POSTAL_CODE_ADDR_COUNTRY_ADDR_TELEPHONE = 0;
    public static final int RECORD_ADDRESS_NAME = 1;
    public static final int RECORD_ADDRESS_POSITION_LATITUDE_POSITION_LONGITUDE_TYPE_OF_DESTINATION_POI_TYPE_STOPOVER_SN = 2;
    public static final int RECORD_ADDRESS_POS = 15;
    public static final int POS_MIN = 0;
    public int pos;
    private static final int MAX_NAME_LENGTH = 128;
    public final BAPString name;
    public static final int POSITION_LATITUDE_MIN = -90;
    public int position_Latitude;
    public static final int POSITION_LONGITUDE_MIN = -180;
    public int position_Longitude;
    public static final int TYPE_OF_DESTINATION_UNKNOWN_ANY_TYPE_OF_DESTINATION = 0;
    public static final int TYPE_OF_DESTINATION_POI_POINT_OF_INTERESST = 1;
    public static final int TYPE_OF_DESTINATION_STOPOVER_DESTINATION_ZWISCHENZIEL = 2;
    public static final int TYPE_OF_DESTINATION_FINAL_DESTINATION = 3;
    public static final int TYPE_OF_DESTINATION_FINAL_DESTINATION_START_ROUT_GUIDANCE_IMMEDIATLY = 4;
    public int typeOfDestination;
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
    public static final int POI_TYPE_VIP_CATEGORY_0 = 240;
    public static final int POI_TYPE_VIP_CATEGORY_1 = 241;
    public static final int POI_TYPE_VIP_CATEGORY_2 = 242;
    public static final int POI_TYPE_VIP_CATEGORY_3 = 243;
    public static final int POI_TYPE_VIP_CATEGORY_4 = 244;
    public static final int POI_TYPE_VIP_CATEGORY_5 = 245;
    public static final int POI_TYPE_VIP_CATEGORY_6 = 246;
    public static final int POI_TYPE_VIP_CATEGORY_7 = 247;
    public static final int POI_TYPE_VIP_CATEGORY_8 = 248;
    public static final int POI_TYPE_VIP_CATEGORY_9 = 249;
    public static final int POI_TYPE_UNKNOWN = 255;
    public int poi_Type;
    private static final int MAX_POI_EXTENSION_LENGTH = 51;
    public final BAPString poi_Extension;
    public static final int TOUR_ID_MIN = 0;
    public int tour_Id;
    public static final int STOPOVER_SN_MIN = 0;
    public int stopover_Sn;
    private static final int MAX_ADDR_STREET_LENGTH = 128;
    public final BAPString addr_Street;
    private static final int MAX_ADDR_NUMBER_LENGTH = 11;
    public final BAPString addr_Number;
    private static final int MAX_ADDR_TOWN_LENGTH = 61;
    public final BAPString addr_Town;
    private static final int MAX_ADDR_STATE_LENGTH = 61;
    public final BAPString addr_State;
    private static final int MAX_ADDR_POSTALCODE_LENGTH = 22;
    public final BAPString addr_PostalCode;
    private static final int MAX_ADDR_COUNTRY_LENGTH = 61;
    public final BAPString addr_Country;
    private static final int MAX_ADDR_TELEPHONE_LENGTH = 41;
    public final BAPString addr_Telephone;

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public DestinationsList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.name = new BAPString(128);
        this.poi_Extension = new BAPString(51);
        this.addr_Street = new BAPString(128);
        this.addr_Number = new BAPString(11);
        this.addr_Town = new BAPString(61);
        this.addr_State = new BAPString(61);
        this.addr_PostalCode = new BAPString(22);
        this.addr_Country = new BAPString(61);
        this.addr_Telephone = new BAPString(41);
        this.internalReset();
        this.customInitialization();
    }

    public DestinationsList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.position_Latitude = -90;
        this.position_Longitude = -180;
        this.typeOfDestination = 0;
        this.poi_Type = 0;
        this.tour_Id = 0;
        this.stopover_Sn = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.name.reset();
        this.poi_Extension.reset();
        this.addr_Street.reset();
        this.addr_Number.reset();
        this.addr_Town.reset();
        this.addr_State.reset();
        this.addr_PostalCode.reset();
        this.addr_Country.reset();
        this.addr_Telephone.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DestinationsList_Data destinationsList_Data = (DestinationsList_Data)bAPEntity;
        return this.arrayHeader.equalTo(destinationsList_Data.arrayHeader) && this.pos == destinationsList_Data.pos && this.name.equalTo(destinationsList_Data.name) && this.position_Latitude == destinationsList_Data.position_Latitude && this.position_Longitude == destinationsList_Data.position_Longitude && this.typeOfDestination == destinationsList_Data.typeOfDestination && this.poi_Type == destinationsList_Data.poi_Type && this.poi_Extension.equalTo(destinationsList_Data.poi_Extension) && this.tour_Id == destinationsList_Data.tour_Id && this.stopover_Sn == destinationsList_Data.stopover_Sn && this.addr_Street.equalTo(destinationsList_Data.addr_Street) && this.addr_Number.equalTo(destinationsList_Data.addr_Number) && this.addr_Town.equalTo(destinationsList_Data.addr_Town) && this.addr_State.equalTo(destinationsList_Data.addr_State) && this.addr_PostalCode.equalTo(destinationsList_Data.addr_PostalCode) && this.addr_Country.equalTo(destinationsList_Data.addr_Country) && this.addr_Telephone.equalTo(destinationsList_Data.addr_Telephone);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DestinationsList_Data");
        stringBuffer.append("\n - pos:" + this.pos);
        stringBuffer.append("\n - name:" + this.name.toString());
        stringBuffer.append("\n - position_Latitude:" + this.position_Latitude);
        stringBuffer.append("\n - position_Longitude:" + this.position_Longitude);
        stringBuffer.append("\n - typeOfDestination:" + this.typeOfDestination);
        stringBuffer.append("\n - poi_Type:" + this.poi_Type);
        stringBuffer.append("\n - poi_Extension:" + this.poi_Extension.toString());
        stringBuffer.append("\n - tour_Id:" + this.tour_Id);
        stringBuffer.append("\n - stopover_Sn:" + this.stopover_Sn);
        stringBuffer.append("\n - addr_Street:" + this.addr_Street.toString());
        stringBuffer.append("\n - addr_Number:" + this.addr_Number.toString());
        stringBuffer.append("\n - addr_Town:" + this.addr_Town.toString());
        stringBuffer.append("\n - addr_State:" + this.addr_State.toString());
        stringBuffer.append("\n - addr_PostalCode:" + this.addr_PostalCode.toString());
        stringBuffer.append("\n - addr_Country:" + this.addr_Country.toString());
        stringBuffer.append("\n - addr_Telephone:" + this.addr_Telephone.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushInt(this.position_Latitude);
                bitStream.pushInt(this.position_Longitude);
                bitStream.pushByte((byte)this.typeOfDestination);
                bitStream.pushByte((byte)this.poi_Type);
                bitStream.pushByte((byte)this.stopover_Sn);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                bitStream.pushInt(this.position_Latitude);
                bitStream.pushInt(this.position_Longitude);
                bitStream.pushByte((byte)this.typeOfDestination);
                bitStream.pushByte((byte)this.poi_Type);
                this.poi_Extension.serialize(bitStream);
                bitStream.pushInt(this.tour_Id);
                bitStream.pushByte((byte)this.stopover_Sn);
                this.addr_Street.serialize(bitStream);
                this.addr_Number.serialize(bitStream);
                this.addr_Town.serialize(bitStream);
                this.addr_State.serialize(bitStream);
                this.addr_PostalCode.serialize(bitStream);
                this.addr_Country.serialize(bitStream);
                this.addr_Telephone.serialize(bitStream);
                break;
            }
        }
    }

    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.position_Latitude = bitStream.popFrontInt();
                this.position_Longitude = bitStream.popFrontInt();
                this.typeOfDestination = bitStream.popFrontByte();
                this.poi_Type = bitStream.popFrontByte();
                this.stopover_Sn = bitStream.popFrontByte();
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                this.position_Latitude = bitStream.popFrontInt();
                this.position_Longitude = bitStream.popFrontInt();
                this.typeOfDestination = bitStream.popFrontByte();
                this.poi_Type = bitStream.popFrontByte();
                this.poi_Extension.deserialize(bitStream);
                this.tour_Id = bitStream.popFrontInt();
                this.stopover_Sn = bitStream.popFrontByte();
                this.addr_Street.deserialize(bitStream);
                this.addr_Number.deserialize(bitStream);
                this.addr_Town.deserialize(bitStream);
                this.addr_State.deserialize(bitStream);
                this.addr_PostalCode.deserialize(bitStream);
                this.addr_Country.deserialize(bitStream);
                this.addr_Telephone.deserialize(bitStream);
                break;
            }
        }
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public int getPos() {
        return this.pos;
    }
}

