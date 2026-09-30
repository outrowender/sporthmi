/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IFormattingRequest {
    public void setCountry(String var1);

    public void setStreet(String var1);

    public void setState(String var1);

    public void setStateAbbreviation(String var1);

    public void setCity(String var1);

    public void setCityPart(String var1);

    public void setDistrict(String var1);

    public void setWard(String var1);

    public void setZip(String var1);

    public void setHouseNumber(String var1);

    public void setPoiName(String var1);

    public void setContactOrFavoriteName(String var1);

    public String toString();
}

