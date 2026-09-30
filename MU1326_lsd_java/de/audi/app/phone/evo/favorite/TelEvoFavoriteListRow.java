/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.favorite;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.phone.evo.favorite.ITelFavorite;
import de.audi.app.phone.evo.favorite.TelFavoriteHandler;
import de.audi.app.phone.evo.favorite.TelFavoriteStorage;
import de.audi.atip.favorite.FavoriteListRow;
import de.audi.atip.favorite.IFavoriteStorage;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;

public class TelEvoFavoriteListRow
extends FavoriteListRow {
    static final int MAX_COLUMNS = 4;
    private static final int COL_NAME = 0;
    private static final int COL_NUMBER = 1;
    private static final int COL_PROPERTIES = 2;
    private static final int COL_PHONE_NUMBER_TYPE = 3;
    private final String name;
    private final String number;
    private final int phoneNumberType;

    public TelEvoFavoriteListRow(String string, String string2, long l, int n) {
        super(l, 4);
        this.name = string;
        this.number = string2;
        this.phoneNumberType = n;
        this.setText(0, string);
        this.setText(1, string2);
        this.setInteger(3, ADBModelUtils.getIconTypeForPhoneNumber(n));
        this.setPropertyCell(2, PropertyListCell.create(1110018462, new int[]{1139720254, 1014980486}));
    }

    public TelEvoFavoriteListRow(ITelFavorite iTelFavorite) {
        this(iTelFavorite.getName(), iTelFavorite.getTelNumber(), TelFavoriteHandler.getNextUniqueID(), iTelFavorite.getPhoneNumberType());
    }

    public TelEvoFavoriteListRow(TelEvoFavoriteListRow telEvoFavoriteListRow) {
        this(telEvoFavoriteListRow.name, telEvoFavoriteListRow.number, telEvoFavoriteListRow.getUniqueID(), telEvoFavoriteListRow.phoneNumberType);
    }

    public IFavoriteStorage getIFavorite() {
        return new TelFavoriteStorage(this.name, this.number, this.phoneNumberType);
    }

    public EvoListRow copy() {
        return new TelEvoFavoriteListRow(this);
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public int getPhoneNumberType() {
        return this.phoneNumberType;
    }
}

