/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.ui.pag.IPreviewContainer;
import java.util.List;

public interface IGenericDataUpdatePayload {
    public int getLocation();

    public String getId();

    public String getContext();

    public String getType();

    public int getUpdateState();

    public List getRows();

    public IWeatherInfos getWeatherInfos();

    public static interface IWeatherDay {
        public String getTitle();

        public String getDescription();

        public String getTempMin();

        public String getTempMax();

        public String getWind();

        public String getRain();

        public String getImage();

        public String getImageWind();

        public String getImageRain();
    }

    public static interface IWeatherInfos {
        public String getCity();

        public List getDays();
    }

    public static interface IGenericListRow {
        public String getId();

        public String getTitle();

        public String getLine1();

        public String getLine2();

        public String getIconLeft();

        public String getIconRight();

        public double getLat();

        public double getLon();

        public IPreviewContainer getPreview();
    }
}

