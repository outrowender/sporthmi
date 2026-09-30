/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturehandling;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureHandling
extends DSIBase {
    public static final String VERSION = "2.11.1";
    public static final int RT_SETPICTURECONFIG = 1000;
    public static final int RT_REQUESTPICTURES = 1001;
    public static final int RT_CANCELPICTURE = 1002;
    public static final int RT_FREEPICTURE = 1003;
    public static final int RP_FINISHPICTUREREQUEST = 2000;
    public static final int IN_INDICATEPICTURE = 3000;
    public static final int PICTURECONFIGUSECASE_DEFAULT = 0;
    public static final int PICTURECONFIGUSECASE_COVERART = 1;
    public static final int PICTURECONFIGUSECASE_PICTUREVIEWER = 2;
    public static final int PICTURECONFIGUSECASE_THUMBNAILICONS = 3;
    public static final int PICTURECONFIGUSECASE_ADDRESSBOOK = 4;
    public static final int PICTURECONFIGUSECASE_TUNERPRESETSTATIONS = 5;
    public static final int PICTURECONFIGUSECASE_TUNERSLIDESHOW = 6;
    public static final int PICTURECONFIGUSECASE_NAVICONS = 7;
    public static final int PICTURELOADINGRESULT_SUCCESS = 0;
    public static final int PICTURELOADINGRESULT_FAILED = 1;

    public void setPictureConfig(int var1, int var2, int var3);

    public void requestPictures(int var1, ResourceLocator[] var2, int var3);

    public void cancelPicture(int var1);

    public void freePicture(ResourceLocator var1);
}

