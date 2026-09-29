/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.TargetImageInfoAddressBook;
import de.audi.atip.hmi.TargetImageInfoCar;
import de.audi.atip.hmi.TargetImageInfoConnectivity;
import de.audi.atip.hmi.TargetImageInfoEarlyApps;
import de.audi.atip.hmi.TargetImageInfoInfo;
import de.audi.atip.hmi.TargetImageInfoMedia;
import de.audi.atip.hmi.TargetImageInfoMessaging;
import de.audi.atip.hmi.TargetImageInfoNavi;
import de.audi.atip.hmi.TargetImageInfoOnline;
import de.audi.atip.hmi.TargetImageInfoPhone;
import de.audi.atip.hmi.TargetImageInfoSWDL;
import de.audi.atip.hmi.TargetImageInfoSettings;
import de.audi.atip.hmi.TargetImageInfoSystem;
import de.audi.atip.hmi.TargetImageInfoTV;
import de.audi.atip.hmi.TargetImageInfoTone;
import de.audi.atip.hmi.TargetImageInfoTpegKR;
import de.audi.atip.hmi.TargetImageInfoTrafficInfoJP;
import de.audi.atip.hmi.TargetImageInfoTuner;
import de.audi.atip.hmi.TargetImageInfoWirelessCharging;

public class TargetImageInfo {
    public static int[][][] imgSizes = new int[][][]{TargetImageInfoSystem.imgSizes, TargetImageInfoTuner.imgSizes, TargetImageInfoMedia.imgSizes, TargetImageInfoPhone.imgSizes, TargetImageInfoNavi.imgSizes, TargetImageInfoInfo.imgSizes, TargetImageInfoCar.imgSizes, TargetImageInfoAddressBook.imgSizes, TargetImageInfoTpegKR.imgSizes, TargetImageInfoTrafficInfoJP.imgSizes, TargetImageInfoTone.imgSizes, TargetImageInfoSettings.imgSizes, new int[0][], new int[0][], new int[0][], new int[0][], new int[0][], TargetImageInfoSWDL.imgSizes, new int[0][], new int[0][], new int[0][], TargetImageInfoEarlyApps.imgSizes, TargetImageInfoMessaging.imgSizes, TargetImageInfoOnline.imgSizes, new int[0][], TargetImageInfoConnectivity.imgSizes, TargetImageInfoTV.imgSizes, new int[0][], new int[0][], new int[0][], new int[0][], new int[0][], new int[0][], new int[0][], TargetImageInfoWirelessCharging.imgSizes};
    public static int totalImageSize = TargetImageInfoSystem.totalImageSize + TargetImageInfoTuner.totalImageSize + TargetImageInfoMedia.totalImageSize + TargetImageInfoPhone.totalImageSize + TargetImageInfoNavi.totalImageSize + TargetImageInfoInfo.totalImageSize + TargetImageInfoCar.totalImageSize + TargetImageInfoAddressBook.totalImageSize + TargetImageInfoTpegKR.totalImageSize + TargetImageInfoTrafficInfoJP.totalImageSize + TargetImageInfoTone.totalImageSize + TargetImageInfoSettings.totalImageSize + 0 + 0 + 0 + 0 + 0 + TargetImageInfoSWDL.totalImageSize + 0 + 0 + 0 + TargetImageInfoEarlyApps.totalImageSize + TargetImageInfoMessaging.totalImageSize + TargetImageInfoOnline.totalImageSize + 0 + TargetImageInfoConnectivity.totalImageSize + TargetImageInfoTV.totalImageSize + 0 + 0 + 0 + 0 + 0 + 0 + 0 + TargetImageInfoWirelessCharging.totalImageSize;
    public static int[][][] imgTypes = new int[][][]{TargetImageInfoSystem.imgTypes, TargetImageInfoTuner.imgTypes, TargetImageInfoMedia.imgTypes, TargetImageInfoPhone.imgTypes, TargetImageInfoNavi.imgTypes, TargetImageInfoInfo.imgTypes, TargetImageInfoCar.imgTypes, TargetImageInfoAddressBook.imgTypes, TargetImageInfoTpegKR.imgTypes, TargetImageInfoTrafficInfoJP.imgTypes, TargetImageInfoTone.imgTypes, TargetImageInfoSettings.imgTypes, new int[0][], new int[0][], new int[0][], new int[0][], new int[0][], TargetImageInfoSWDL.imgTypes, new int[0][], new int[0][], new int[0][], TargetImageInfoEarlyApps.imgTypes, TargetImageInfoMessaging.imgTypes, TargetImageInfoOnline.imgTypes, new int[0][], TargetImageInfoConnectivity.imgTypes, TargetImageInfoTV.imgTypes, new int[0][], new int[0][], new int[0][], new int[0][], new int[0][], new int[0][], new int[0][], TargetImageInfoWirelessCharging.imgTypes};

    public static int getImageType(int n) {
        try {
            return imgTypes[n / -1601830656][n % -1601830656 - 0][0];
        }
        catch (Exception exception) {
            return -1;
        }
    }

    public static int getWidth(int n) {
        try {
            return imgTypes[n / -1601830656][n % -1601830656 - 0][1];
        }
        catch (Exception exception) {
            return -1;
        }
    }

    public static int getHeight(int n) {
        try {
            return imgTypes[n / -1601830656][n % -1601830656 - 0][2];
        }
        catch (Exception exception) {
            return -1;
        }
    }

    public static int getImageFlags(int n) {
        try {
            return imgTypes[n / -1601830656][n % -1601830656 - 0][3];
        }
        catch (Exception exception) {
            return -1;
        }
    }
}

