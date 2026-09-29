/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag;

import de.audi.remotehmi.ui.pag.IPreviewContainer$IGenericButton;
import de.audi.remotehmi.ui.pag.IPreviewContainer$IMapInfo;
import de.audi.remotehmi.ui.pag.IPreviewContainer$INavInfo;
import java.util.List;

public interface IPreviewContainer {
    public static final int STATUS_UNLOADED;
    public static final int STATUS_DATA_LOADED;
    public static final int STATUS_ERROR;

    default public int getStatus() {
    }

    default public String getUrl() {
    }

    default public void setGridId(String string) {
    }

    default public void setPreviewMap(IMapInfo iMapInfo, boolean bl) {
    }

    default public void setTitle(String string, boolean bl) {
    }

    default public void setTimeStamp(String string, boolean bl) {
    }

    default public void setImage(String string, boolean bl) {
    }

    default public void updateImage(String string) {
    }

    default public void setDescriptionText(String string, boolean bl) {
    }

    default public void setDescription2Text(String string, boolean bl) {
    }

    default public void setImageText(String string, boolean bl) {
    }

    default public void setNavInfo(INavInfo iNavInfo, boolean bl) {
    }

    default public void setGenericButton1(IGenericButton iGenericButton, boolean bl) {
    }

    default public void setGenericButton2(IGenericButton iGenericButton, boolean bl) {
    }

    default public void setComments(List list, boolean bl) {
    }

    default public void setPhoneButton(String string, boolean bl) {
    }

    default public void setMail(String string, boolean bl) {
    }

    default public void setImageList(List list, boolean bl) {
    }

    default public void setTable2(List list, boolean bl) {
    }

    default public void setTable(List list, boolean bl) {
    }

    default public String getTitle(boolean bl) {
    }

    default public String getImage(boolean bl) {
    }

    default public IMapInfo getPreviewMap(boolean bl) {
    }

    default public String getTimeStamp(boolean bl) {
    }

    default public String getDescriptionText(boolean bl) {
    }

    default public String getDescription2Text(boolean bl) {
    }

    default public String getImageText(boolean bl) {
    }

    default public INavInfo getNavInfo(boolean bl) {
    }

    default public IGenericButton getGenericButton1(boolean bl) {
    }

    default public IGenericButton getGenericButton2(boolean bl) {
    }

    default public List getComments(boolean bl) {
    }

    default public String getPhoneButton(boolean bl) {
    }

    default public String getMail(boolean bl) {
    }

    default public List getImageList(boolean bl) {
    }

    default public List getTable(boolean bl) {
    }

    default public List getTable2(boolean bl) {
    }

    default public String getGridId() {
    }

    default public boolean hasContent() {
    }

    default public void setTTSContent(String string) {
    }

    default public String getTTSContent() {
    }

    default public boolean getMinOnItemIsBlockable() {
    }

    default public void setMinOnItemIsBlockable(boolean bl) {
    }
}

