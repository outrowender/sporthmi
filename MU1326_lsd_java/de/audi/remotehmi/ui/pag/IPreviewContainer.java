/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag;

import de.audi.remotehmi.ui.mib2.grid.GeoPosition;
import java.util.List;

public interface IPreviewContainer {
    public static final int STATUS_UNLOADED = 0;
    public static final int STATUS_DATA_LOADED = 1;
    public static final int STATUS_ERROR = 2;

    public int getStatus();

    public String getUrl();

    public void setGridId(String var1);

    public void setPreviewMap(IMapInfo var1, boolean var2);

    public void setTitle(String var1, boolean var2);

    public void setTimeStamp(String var1, boolean var2);

    public void setImage(String var1, boolean var2);

    public void updateImage(String var1);

    public void setDescriptionText(String var1, boolean var2);

    public void setDescription2Text(String var1, boolean var2);

    public void setImageText(String var1, boolean var2);

    public void setNavInfo(INavInfo var1, boolean var2);

    public void setGenericButton1(IGenericButton var1, boolean var2);

    public void setGenericButton2(IGenericButton var1, boolean var2);

    public void setComments(List var1, boolean var2);

    public void setPhoneButton(String var1, boolean var2);

    public void setMail(String var1, boolean var2);

    public void setImageList(List var1, boolean var2);

    public void setTable2(List var1, boolean var2);

    public void setTable(List var1, boolean var2);

    public String getTitle(boolean var1);

    public String getImage(boolean var1);

    public IMapInfo getPreviewMap(boolean var1);

    public String getTimeStamp(boolean var1);

    public String getDescriptionText(boolean var1);

    public String getDescription2Text(boolean var1);

    public String getImageText(boolean var1);

    public INavInfo getNavInfo(boolean var1);

    public IGenericButton getGenericButton1(boolean var1);

    public IGenericButton getGenericButton2(boolean var1);

    public List getComments(boolean var1);

    public String getPhoneButton(boolean var1);

    public String getMail(boolean var1);

    public List getImageList(boolean var1);

    public List getTable(boolean var1);

    public List getTable2(boolean var1);

    public String getGridId();

    public boolean hasContent();

    public void setTTSContent(String var1);

    public String getTTSContent();

    public boolean getMinOnItemIsBlockable();

    public void setMinOnItemIsBlockable(boolean var1);

    public static interface IMapInfo {
        public void setMapDecoratorGeoPosition(GeoPosition var1);

        public GeoPosition getMapDecoratorGeoPosition();

        public int getStyle();

        public void setStyle(int var1);
    }

    public static interface INavInfo {
        public void setPosition(GeoPosition var1);

        public void setStreet(String var1);

        public void setZip(String var1);

        public void setCountry(String var1);

        public void setNumber(String var1);

        public void setName(String var1);

        public void setCity(String var1);

        public void setCalculateRRD(boolean var1);

        public void setStartRg(boolean var1);

        public GeoPosition getPosition();

        public String getStreet();

        public String getZip();

        public String getCountry();

        public String getNumber();

        public String getName();

        public String getCity();

        public boolean isCalculateRRD();

        public boolean isStartRg();

        public String getState();

        public void setState(String var1);
    }

    public static interface IGenericButton {
        public void setSelectionId(String var1);

        public void setText(String var1);

        public void setImage(String var1);

        public String getSelectionId();

        public String getText();

        public String getImage();

        public void setDescription(String var1);

        public String getDescription();
    }

    public static interface IPreviewComment {
        public void setText(String var1);

        public void setProfile(String var1);

        public void setTimestamp(String var1);

        public void setImage(String var1);

        public void setLikes(String var1);

        public String getText();

        public String getProfile();

        public String getTimestamp();

        public String getImage();

        public String getLikes();
    }

    public static interface IBlockableObject {
        public boolean isBlockable();

        public Object getValue();
    }
}

