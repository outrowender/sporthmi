/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

final class ListEntryFactory {
    ListEntryFactory() {
    }

    static ListEntry createListEntry(SearchResult searchResult) {
        MessageListEntry messageListEntry;
        FolderEntry folderEntry;
        int n;
        long l = searchResult.getDataId();
        boolean bl = searchResult.getEntryType() == 12;
        int n2 = n = bl ? 1 : 2;
        if (bl) {
            folderEntry = ListEntryFactory.createFolderEntry(searchResult);
            messageListEntry = null;
        } else {
            folderEntry = null;
            messageListEntry = ListEntryFactory.createMessageListEntry(searchResult);
        }
        return new ListEntry(l, n, folderEntry, messageListEntry);
    }

    private static FolderEntry createFolderEntry(SearchResult searchResult) {
        Token[] tokenArray = searchResult.getTokens();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 8);
        Token token2 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 5);
        Token token3 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 12);
        Token token4 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 22);
        Token token5 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 19);
        int n = Integer.parseInt(token.getToken());
        String string = token2.getToken();
        int n2 = Integer.parseInt(token3.getToken());
        int n3 = Integer.parseInt(token4.getToken());
        int n4 = Integer.parseInt(token5.getToken());
        return new FolderEntry(n, n3, n2, string, n4);
    }

    private static MessageListEntry createMessageListEntry(SearchResult searchResult) {
        Token[] tokenArray = searchResult.getTokens();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 23);
        Token token2 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 22);
        Token token3 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 14);
        Token token4 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 16);
        Token token5 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 15);
        Token token6 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 18);
        Token token7 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 4);
        Token token8 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 11);
        Token token9 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 17);
        Token token10 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 7);
        Token[] tokenArray2 = ListEntryFactory.getTokensOfType(tokenArray, 21);
        Token token11 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 2);
        Token token12 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 12);
        Token token13 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 20);
        int n = Integer.parseInt(token.getToken());
        long l = Long.parseLong(token2.getToken());
        String string = token6.getToken();
        ResourceLocator resourceLocator = Strings.isNullOrEmpty(string) ? null : new ResourceLocator(string);
        MatchedAddress matchedAddress = new MatchedAddress(token4.getToken(), token5.getToken(), Long.parseLong(token3.getToken()), resourceLocator);
        String string2 = token7.getToken();
        int n2 = Integer.parseInt(token8.getToken());
        int n3 = Integer.parseInt(token9.getToken());
        int n4 = Integer.parseInt(token10.getToken());
        String[] stringArray = new String[tokenArray2.length];
        for (int i2 = 0; i2 < tokenArray2.length; ++i2) {
            stringArray[i2] = tokenArray2[i2].getToken();
        }
        String string3 = "";
        String string4 = token11.getToken();
        int n5 = Integer.parseInt(token12.getToken());
        int n6 = Integer.parseInt(token13.getToken());
        return new MessageListEntry(matchedAddress, string2, n3, string3, stringArray, l, n2, string4, n, n4, n5, n6);
    }

    private static Token[] getTokensOfType(Token[] tokenArray, int n) {
        ArrayList arrayList = new ArrayList();
        if (tokenArray != null) {
            for (int i2 = 0; i2 < tokenArray.length; ++i2) {
                if (tokenArray[i2].getWordType() != n) continue;
                arrayList.add(tokenArray[i2]);
            }
        }
        Object[] objectArray = new Token[arrayList.size()];
        return (Token[])arrayList.toArray(objectArray);
    }
}

