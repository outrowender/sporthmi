/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite.d5;

import de.audi.atip.util.Util;
import de.audi.tghu.navi.app.favorite.d5.FavoriteLocation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class FavoriteIndex
implements Serializable {
    private static final long serialVersionUID;
    private static final int[] favPersKeys;
    private transient List allFavPersistenceKeys;
    private final List favorites = new LinkedList();

    public int getNumFreePersistenceKeys() {
        return FavoriteIndex.getMaxSize() - this.favorites.size();
    }

    private Integer getFreePersistenceKeys(List list) {
        ArrayList arrayList = new ArrayList(this.getAllFavPersistenceKeys());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            FavoriteLocation favoriteLocation = (FavoriteLocation)iterator.next();
            Integer n = favoriteLocation.getKey();
            arrayList.remove(n);
        }
        return (Integer)(arrayList.isEmpty() ? null : arrayList.get(0));
    }

    public boolean isStorageFull() {
        return this.favorites.size() == FavoriteIndex.getMaxSize();
    }

    public int addFavorite(FavoriteLocation favoriteLocation) {
        if (favoriteLocation == null) {
            throw new NullPointerException("Favorite can not be null");
        }
        Integer n = this.getFreePersistenceKeys(this.favorites);
        if (n == null) {
            throw new IllegalStateException("The list is already full");
        }
        favoriteLocation.setKey(n);
        this.favorites.add(favoriteLocation);
        return n;
    }

    public FavoriteLocation getFavoriteByKey(long l) {
        Iterator iterator = this.getFavoritesList().iterator();
        while (iterator.hasNext()) {
            FavoriteLocation favoriteLocation = (FavoriteLocation)iterator.next();
            if ((long)favoriteLocation.getKey().intValue() != l) continue;
            return favoriteLocation;
        }
        return null;
    }

    public List getFavoritesList() {
        return Collections.unmodifiableList(this.favorites);
    }

    public boolean delete(int n) {
        return this.favorites.remove(new FavoriteLocation(n));
    }

    public boolean delete(FavoriteLocation favoriteLocation) {
        return this.favorites.remove(favoriteLocation);
    }

    public boolean delete(Collection collection) {
        return this.favorites.removeAll(new Vector(collection));
    }

    public static int getMaxSize() {
        return favPersKeys.length;
    }

    private List getAllFavPersistenceKeys() {
        if (this.allFavPersistenceKeys == null) {
            this.allFavPersistenceKeys = new ArrayList(favPersKeys.length);
        }
        if (this.allFavPersistenceKeys.isEmpty()) {
            for (int i2 = 0; i2 < favPersKeys.length; ++i2) {
                this.allFavPersistenceKeys.add(new Integer(favPersKeys[i2]));
            }
        }
        return this.allFavPersistenceKeys;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(Util.getClassName(super.getClass()));
        stringBuffer.append(new StringBuffer().append(" with size= ").append(this.favorites.size()).toString());
        Iterator iterator = this.favorites.iterator();
        while (iterator.hasNext()) {
            stringBuffer.append("\n");
            stringBuffer.append(iterator.next());
        }
        return stringBuffer.toString();
    }

    static {
        favPersKeys = new int[]{991, 992, 993, 994, 995, 996, 997, 998, 999, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034, 1035, 1036, 1037, 1038, 1039, 1040};
    }
}

