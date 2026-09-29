/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.phone.core.callstacks.TelCallStacksUtils;
import de.audi.app.phone.evo.callstacks.TelCallStack2JsonStringConverter;
import de.audi.app.phone.evo.intellicall.search.AbstractIntellicallSearchResultRow;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import java.util.ArrayList;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class IntellicallCallStackSearchResultRow
extends AbstractIntellicallSearchResultRow {
    private static final int COL_DATE;
    private static final int COL_TIME;
    private static final int ICONID_UNDEFINED;
    private static final int ICONID_CALLSTACK_LD;
    private static final int ICONID_CALLSTACK_MC;
    private static final int ICONID_CALLSTACK_RC;
    private final String number;
    private final String name;
    private final CallStackEntry callStackEntry;

    public IntellicallCallStackSearchResultRow(SearchResult searchResult, LogChannel logChannel) {
        super(searchResult, logChannel);
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), 23);
        CallStackEntry callStackEntry = this.callStackEntry = token != null ? TelCallStack2JsonStringConverter.deserialize(token.getToken()) : null;
        if (this.callStackEntry == null) {
            throw new IllegalArgumentException("IntellicallCallStackSearchResultRow: callStackEntry is null");
        }
        this.number = this.callStackEntry.getClNumber();
        this.name = this.callStackEntry.getClName();
        this.setRecordSetColumn(this.getRecordSetColumn());
        this.setInteger(1, searchResult.getListPosition());
        this.setInteger(2, this.getIconID(searchResult));
        this.setPropertyCell(7, this.getPropertyCell());
        this.setHighlightTextCell(3, this.getHighlightedNameCell());
        this.setHighlightTextCell(4, this.getHighlightedNumberCell());
        this.setText(5, this.getDate());
        this.setText(6, this.getTime());
        this.setInteger(8, ADBModelUtils.getIconTypeForPhoneNumber(this.callStackEntry.getAdbNumberType()));
    }

    private String getDate() {
        if (TelCallStacksUtils.hasValidTimestamp(this.callStackEntry)) {
            DateMetric dateMetric = new DateMetric(TelCallStacksUtils.getDate(this.callStackEntry), 0);
            return dateMetric.format();
        }
        return "";
    }

    private String getTime() {
        if (TelCallStacksUtils.hasValidTimestamp(this.callStackEntry)) {
            DateMetric dateMetric = new DateMetric(TelCallStacksUtils.getDate(this.callStackEntry), 1);
            return dateMetric.format();
        }
        return "";
    }

    private int getRecordSetColumn() {
        int n = 2;
        if (this.name != null && this.name.length() > 0) {
            n = this.name.equals(this.number) ? 1 : 0;
        } else if (this.number == null || this.number.length() == 0) {
            n = 3;
        }
        return n;
    }

    private PropertyListCell getPropertyCell() {
        ArrayList arrayList = new ArrayList(3);
        boolean bl = this.callStackEntry.getClNumber() != null && this.callStackEntry.getClNumber().length() > 0;
        arrayList.add(new Integer(bl ? -2040561860 : -1708374768));
        if (this.callStackEntry.getClEntryOrigin() == 1) {
            arrayList.add(new Integer(-1704199780));
        }
        if (this.callStackEntry.getAdbEntryID() > 0L) {
            arrayList.add(new Integer(553997474));
        }
        int[] nArray = new int[arrayList.size()];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = (Integer)arrayList.get(i2);
        }
        return new PropertyListCell(-1635178174, nArray);
    }

    private int getIconID(SearchResult searchResult) {
        if (searchResult == null) {
            this.log.log(10000, "[IntellicallCallStackSearchResultRow#getIconID] result is null.");
            return -1;
        }
        int n = searchResult.getEntryType();
        int n2 = -1;
        switch (n) {
            case 2049: {
                n2 = 0;
                break;
            }
            case 2050: {
                n2 = 1;
                break;
            }
            case 2048: {
                n2 = 2;
                break;
            }
            default: {
                this.log.log(-1601830656, "[IntellicallCallStackSearchResultRow#getIconID] no call stack type found for %1", (long)n);
                n2 = -1;
            }
        }
        return n2;
    }

    public CallStackEntry getCallStackEntry() {
        return this.callStackEntry;
    }

    @Override
    public EvoListRow copy() {
        return new IntellicallCallStackSearchResultRow(this.getSearchResult(), this.log);
    }
}

