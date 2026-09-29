/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.OAuthToken;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class OAuthTokenSerializer {
    public static void putOptionalOAuthToken(ISerializer iSerializer, OAuthToken oAuthToken) {
        boolean bl = oAuthToken == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = oAuthToken.getScope();
            iSerializer.putOptionalString(string);
            long l = oAuthToken.getExpiresIn();
            iSerializer.putUInt32(l);
            String string2 = oAuthToken.getType();
            iSerializer.putOptionalString(string2);
            String string3 = oAuthToken.getAccessToken();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalOAuthTokenVarArray(ISerializer iSerializer, OAuthToken[] oAuthTokenArray) {
        boolean bl = oAuthTokenArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oAuthTokenArray.length);
            for (int i2 = 0; i2 < oAuthTokenArray.length; ++i2) {
                OAuthTokenSerializer.putOptionalOAuthToken(iSerializer, oAuthTokenArray[i2]);
            }
        }
    }

    public static OAuthToken getOptionalOAuthToken(IDeserializer iDeserializer) {
        OAuthToken oAuthToken = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            long l;
            String string3;
            oAuthToken = new OAuthToken();
            oAuthToken.scope = string3 = iDeserializer.getOptionalString();
            oAuthToken.expiresIn = l = iDeserializer.getUInt32();
            oAuthToken.type = string2 = iDeserializer.getOptionalString();
            oAuthToken.accessToken = string = iDeserializer.getOptionalString();
        }
        return oAuthToken;
    }

    public static OAuthToken[] getOptionalOAuthTokenVarArray(IDeserializer iDeserializer) {
        OAuthToken[] oAuthTokenArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oAuthTokenArray = new OAuthToken[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oAuthTokenArray[i2] = OAuthTokenSerializer.getOptionalOAuthToken(iDeserializer);
            }
        }
        return oAuthTokenArray;
    }
}

