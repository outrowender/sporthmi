/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.favorite;

import de.audi.app.phone.evo.favorite.ITelFavorite;
import de.audi.app.phone.evo.favorite.TelEvoFavoriteListRow;
import de.audi.atip.favorite.FavoriteListRow;
import de.esolutions.fw.util.commons.Buffer;

public class TelFavoriteStorage
implements ITelFavorite {
    private static final long serialVersionUID;
    private final String combinedName;
    private final String telNumber;
    private final int phoneNumberType;

    public TelFavoriteStorage(String string, String string2) {
        this(string, string2, 0);
    }

    public TelFavoriteStorage(String string, String string2, int n) {
        if (string == null) {
            throw new IllegalArgumentException("TelFavorite#combinedName is null!");
        }
        if (string2 == null) {
            throw new IllegalArgumentException("TelFavorite#telNumber is null!");
        }
        this.combinedName = string;
        this.telNumber = string2;
        this.phoneNumberType = n;
    }

    @Override
    public String getName() {
        return this.combinedName;
    }

    @Override
    public String getTelNumber() {
        return this.telNumber;
    }

    @Override
    public int getPhoneNumberType() {
        return this.phoneNumberType;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelFavoriteStorage(combinedName=");
        buffer.append(this.combinedName);
        buffer.append(", telNumber=");
        buffer.append(this.telNumber);
        buffer.append(", phoneNumberType=");
        buffer.append(this.phoneNumberType);
        buffer.append(")");
        return buffer.toString();
    }

    @Override
    public FavoriteListRow getFavoriteListRow() {
        return new TelEvoFavoriteListRow(this);
    }
}

