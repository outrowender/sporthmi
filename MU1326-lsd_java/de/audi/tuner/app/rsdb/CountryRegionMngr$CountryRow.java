/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.rsdb.CountryRegionMngr;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;

class CountryRegionMngr$CountryRow
extends EvoListRow {
    private final CountryRegionData country;
    private final CountryRegionData subCountry;
    private final CountryRegionTranslationData countryTranslation;
    private final CountryRegionTranslationData subCountryTranslation;
    private final /* synthetic */ CountryRegionMngr this$0;

    public CountryRegionMngr$CountryRow(CountryRegionMngr countryRegionMngr, CountryRegionData countryRegionData, CountryRegionTranslationData countryRegionTranslationData) {
        this.this$0 = countryRegionMngr;
        super(countryRegionData.countryId, 2);
        this.country = countryRegionData;
        this.countryTranslation = countryRegionTranslationData;
        this.subCountry = null;
        this.subCountryTranslation = null;
        if (this.countryTranslation != null) {
            this.setText(0, this.countryTranslation.countryRegionTranslation);
        } else {
            this.setText(0, countryRegionData.countryNameInternational);
        }
        this.setInteger(1, 0);
    }

    public CountryRegionMngr$CountryRow(CountryRegionMngr countryRegionMngr, CountryRegionData countryRegionData, CountryRegionTranslationData countryRegionTranslationData, CountryRegionData countryRegionData2, CountryRegionTranslationData countryRegionTranslationData2) {
        this.this$0 = countryRegionMngr;
        super(countryRegionData2.countryId, 2);
        this.country = countryRegionData;
        this.countryTranslation = countryRegionTranslationData;
        this.subCountry = countryRegionData2;
        this.subCountryTranslation = countryRegionTranslationData2;
        Buffer buffer = new Buffer(50);
        if (this.countryTranslation != null) {
            buffer.append(this.countryTranslation.countryRegionTranslation).append(" - ");
        } else {
            buffer.append(this.country.countryNameInternational).append(" - ");
        }
        if (this.subCountryTranslation != null) {
            buffer.append(this.subCountryTranslation.countryRegionTranslation);
        } else {
            buffer.append(this.subCountry.countryNameInternational);
        }
        this.setText(0, buffer.toString());
        this.setInteger(1, 0);
    }

    public CountryRegionMngr$CountryRow(CountryRegionMngr countryRegionMngr, CountryRegionMngr$CountryRow countryRegionMngr$CountryRow) {
        this.this$0 = countryRegionMngr;
        super(countryRegionMngr$CountryRow);
        this.country = countryRegionMngr$CountryRow.country;
        this.subCountry = countryRegionMngr$CountryRow.subCountry;
        this.countryTranslation = countryRegionMngr$CountryRow.countryTranslation;
        this.subCountryTranslation = countryRegionMngr$CountryRow.subCountryTranslation;
    }

    @Override
    public EvoListRow copy() {
        return new CountryRegionMngr$CountryRow(this.this$0, this);
    }

    public int getSortId() {
        if (this.countryTranslation != null) {
            int n = this.countryTranslation.guiListItemPosition * 1000;
            if (this.subCountryTranslation != null) {
                n += this.subCountryTranslation.guiListItemPosition;
            }
            return n;
        }
        return 128;
    }

    public int getCountryId() {
        if (this.subCountry != null) {
            return this.subCountry.countryId;
        }
        return this.country.countryId;
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append(this.getCountryId()).append(' ');
        buffer.append(this.country.countryNameInternational);
        if (this.subCountry != null) {
            buffer.append('-').append(this.subCountry.countryNameInternational);
        }
        buffer.append(super.toString());
        return buffer.toString();
    }

    public boolean setRadioButton(int n) {
        this.setInteger(1, this.getCountryId() == n ? 1 : 0);
        return this.getCountryId() == n;
    }
}

