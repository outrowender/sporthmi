.version 50 0 
.class public super [339] 
.super [341] 

.method private annotation [343] : [344] 
    .attribute [342] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [61] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [345] : [346] 
    .attribute [342] .code stack 4 locals 18 
L0:     aconst_null 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     invokevirtual [35] 
L9:     newarray byte 
L11:    astore_3 
L12:    aload_0 
L13:    aload_3 
L14:    iconst_0 
L15:    aload_3 
L16:    arraylength 
L17:    invokevirtual [36] 
L20:    pop 
L21:    aload_1 
L22:    invokevirtual [35] 
L25:    newarray byte 
L27:    astore 4 
L29:    aload_1 
L30:    aload 4 
L32:    iconst_0 
L33:    aload 4 
L35:    arraylength 
L36:    invokevirtual [36] 
L39:    pop 
L40:    aload_0 
L41:    invokevirtual [37] 
L44:    aload_1 
L45:    invokevirtual [37] 
        .catch [30] from L48 to L62 using L62 
L48:    new [68] 
L51:    dup 
L52:    aload 4 
L54:    invokespecial [62] 
L57:    astore 5 
L59:    goto L65 
L62:    pop 
L63:    aload_2 
L64:    areturn 
L65:    aload 5 
L67:    invokevirtual [38] 
L70:    invokevirtual [39] 
L73:    astore 6 
L75:    aload 6 
L77:    iconst_0 
L78:    aaload 
L79:    astore 7 
L81:    aload 7 
L83:    invokevirtual [40] 
L86:    astore 8 
L88:    aload 7 
L90:    invokevirtual [41] 
L93:    astore 9 
L95:    aconst_null 
L96:    astore 10 
L98:    aconst_null 
L99:    astore 11 
L101:   aconst_null 
L102:   astore 12 
        .catch [31] from L104 to L211 using L211 
L104:   ldc [8] 
L106:   invokestatic [10] 
L109:   astore 13 
L111:   aload 13 
L113:   new [69] 
L116:   dup 
L117:   aload 4 
L119:   invokespecial [63] 
L122:   invokevirtual [42] 
L125:   astore 12 
L127:   aload 12 
L129:   invokeinterface [70] 0 
L134:   astore 14 
L136:   goto L186 
L139:   aload 14 
L141:   invokeinterface [71] 0 
L146:   checkcast [14] 
L149:   astore 11 
L151:   aload 11 
L153:   invokevirtual [43] 
L156:   aload 8 
L158:   invokeinterface [72] 0 
L163:   ifeq L186 
L166:   aload 11 
L168:   invokevirtual [44] 
L171:   aload 9 
L173:   invokevirtual [45] 
L176:   ifeq L186 
L179:   aload 11 
L181:   astore 10 
L183:   goto L201 
L186:   aload 10 
L188:   ifnonnull L201 
L191:   aload 14 
L193:   invokeinterface [73] 0 
L198:   ifne L139 
L201:   aload 10 
L203:   ifnonnull L214 
L206:   aload_2 
L207:   areturn 
L208:   goto L214 
L211:   pop 
L212:   aload_2 
L213:   areturn 
L214:   aconst_null 
L215:   astore 13 
L217:   aload 7 
L219:   invokevirtual [46] 
L222:   astore 14 
        .catch [32] from L224 to L239 using L239 
L224:   aload 14 
L226:   ifnull L240 
L229:   aload 14 
L231:   invokestatic [18] 
L234:   astore 13 
L236:   goto L240 
L239:   pop 
L240:   aload 13 
L242:   ifnonnull L272 
        .catch [32] from L245 to L269 using L269 
L245:   aload 7 
L247:   invokevirtual [47] 
L250:   astore 14 
L252:   aload 14 
L254:   ifnonnull L259 
L257:   aload_2 
L258:   areturn 
L259:   aload 14 
L261:   invokestatic [18] 
L264:   astore 13 
L266:   goto L272 
L269:   pop 
L270:   aload_2 
L271:   areturn 
        .catch [33] from L272 to L285 using L285 
L272:   aload 13 
L274:   aload 10 
L276:   invokevirtual [48] 
L279:   invokevirtual [49] 
L282:   goto L288 
L285:   pop 
L286:   aload_2 
L287:   areturn 
L288:   aload 7 
L290:   invokevirtual [50] 
L293:   astore 15 
L295:   aload 15 
L297:   arraylength 
L298:   ifle L343 
L301:   new [74] 
L304:   dup 
L305:   invokespecial [64] 
L308:   astore 16 
L310:   aload 16 
L312:   bipush 17 
L314:   putfield [75] 
L317:   aload 16 
L319:   aload 15 
L321:   putfield [76] 
        .catch [26] from L324 to L337 using L337 
L324:   aload 13 
L326:   aload 16 
L328:   invokestatic [21] 
L331:   invokevirtual [51] 
L334:   goto L355 
L337:   pop 
L338:   aload_2 
L339:   areturn 
L340:   goto L355 
        .catch [26] from L343 to L352 using L352 
L343:   aload 13 
L345:   aload_3 
L346:   invokevirtual [51] 
L349:   goto L355 
L352:   pop 
L353:   aload_2 
L354:   areturn 
L355:   aload 7 
L357:   invokevirtual [52] 
L360:   astore 16 
L362:   aload 16 
L364:   ifnull L409 
        .catch [32] from L367 to L406 using L406 
L367:   aload 7 
L369:   invokevirtual [53] 
L372:   invokestatic [23] 
L375:   astore 17 
L377:   aload 17 
L379:   aload_3 
L380:   invokevirtual [54] 
L383:   astore 18 
L385:   aload 16 
L387:   aload 18 
L389:   invokestatic [25] 
L392:   ifne L409 
L395:   new [77] 
L398:   dup 
L399:   invokespecial [65] 
L402:   athrow 
L403:   goto L409 
L406:   pop 
L407:   aload_2 
L408:   areturn 
L409:   aload 13 
L411:   aload 7 
L413:   invokevirtual [55] 
L416:   invokevirtual [56] 
L419:   ifne L430 
L422:   new [77] 
L425:   dup 
L426:   invokespecial [65] 
L429:   athrow 
L430:   aload 10 
L432:   invokevirtual [57] 
L435:   ifeq L440 
L438:   aload_2 
L439:   areturn 
L440:   new [78] 
L443:   dup 
L444:   aload 10 
L446:   aload 12 
L448:   invokespecial [66] 
L451:   astore 17 
L453:   new [79] 
L456:   dup 
L457:   invokespecial [67] 
L460:   astore 18 
L462:   aload 17 
L464:   invokevirtual [58] 
L467:   astore 19 
L469:   goto L488 
L472:   aload 18 
L474:   aload 19 
L476:   invokeinterface [71] 0 
L481:   checkcast [29] 
L484:   invokevirtual [59] 
L487:   pop 
L488:   aload 19 
L490:   invokeinterface [73] 0 
L495:   ifne L472 
L498:   aload 18 
L500:   iconst_0 
L501:   anewarray [29] 
L504:   invokevirtual [60] 
L507:   checkcast [3] 
L510:   astore_2 
L511:   aload_2 
L512:   areturn 
L513:   nop 
L514:   nop 
L515:   nop 
L516:   
    .end code 
.end method 

.method public static [347] : [348] 
    .attribute [342] .code stack 4 locals 0 
L0:     aload_1 
L1:     aload_2 
L2:     aload_3 
L3:     aload_0 
L4:     invokestatic [34] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [80] 
.const [3] = Class [81] 
.const [4] = Class [82] 
.const [5] = Class [83] 
.const [6] = Class [84] 
.const [7] = Class [85] 
.const [8] = String [86] 
.const [9] = Class [87] 
.const [10] = Method [88] [89] 
.const [11] = Class [90] 
.const [12] = Class [91] 
.const [13] = Class [92] 
.const [14] = Class [93] 
.const [15] = Class [94] 
.const [16] = Class [95] 
.const [17] = Class [96] 
.const [18] = Method [97] [98] 
.const [19] = Class [99] 
.const [20] = Class [100] 
.const [21] = Method [101] [102] 
.const [22] = Class [103] 
.const [23] = Method [104] [105] 
.const [24] = Class [106] 
.const [25] = Method [107] [108] 
.const [26] = Class [109] 
.const [27] = Class [110] 
.const [28] = Class [111] 
.const [29] = Class [112] 
.const [30] = Class [113] 
.const [31] = Class [114] 
.const [32] = Class [115] 
.const [33] = Class [116] 
.const [34] = Method [117] [118] 
.const [35] = Method [119] [120] 
.const [36] = Method [121] [122] 
.const [37] = Method [123] [124] 
.const [38] = Method [125] [126] 
.const [39] = Method [127] [128] 
.const [40] = Method [129] [130] 
.const [41] = Method [131] [132] 
.const [42] = Method [133] [134] 
.const [43] = Method [135] [136] 
.const [44] = Method [137] [138] 
.const [45] = Method [139] [140] 
.const [46] = Method [141] [142] 
.const [47] = Method [143] [144] 
.const [48] = Method [145] [146] 
.const [49] = Method [147] [148] 
.const [50] = Method [149] [150] 
.const [51] = Method [151] [152] 
.const [52] = Method [153] [154] 
.const [53] = Method [155] [156] 
.const [54] = Method [157] [158] 
.const [55] = Method [159] [160] 
.const [56] = Method [161] [162] 
.const [57] = Method [163] [164] 
.const [58] = Method [165] [166] 
.const [59] = Method [167] [168] 
.const [60] = Method [169] [170] 
.const [61] = Method [171] [172] 
.const [62] = Method [173] [174] 
.const [63] = Method [175] [176] 
.const [64] = Method [177] [178] 
.const [65] = Method [179] [180] 
.const [66] = Method [181] [182] 
.const [67] = Method [183] [184] 
.const [68] = Class [185] 
.const [69] = Class [186] 
.const [70] = InterfaceMethod [187] [188] 
.const [71] = InterfaceMethod [189] [190] 
.const [72] = InterfaceMethod [191] [192] 
.const [73] = InterfaceMethod [193] [194] 
.const [74] = Class [195] 
.const [75] = Field [196] [197] 
.const [76] = Field [198] [199] 
.const [77] = Class [200] 
.const [78] = Class [201] 
.const [79] = Class [202] 
.const [80] = Utf8 java/lang/Object 
.const [81] = Utf8 [Ljava/security/cert/Certificate; 
.const [82] = Utf8 java/io/InputStream 
.const [83] = Utf8 com/ibm/oti/security/provider/PKCS7 
.const [84] = Utf8 com/ibm/oti/security/provider/PKCS7$SignedData 
.const [85] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [86] = Utf8 'X.509' 
.const [87] = Utf8 java/security/cert/CertificateFactory 
.const [88] = Class [203] 
.const [89] = NameAndType [204] [205] 
.const [90] = Utf8 java/io/ByteArrayInputStream 
.const [91] = Utf8 java/util/Collection 
.const [92] = Utf8 java/util/Iterator 
.const [93] = Utf8 java/security/cert/X509Certificate 
.const [94] = Utf8 java/security/Principal 
.const [95] = Utf8 java/math/BigInteger 
.const [96] = Utf8 java/security/Signature 
.const [97] = Class [206] 
.const [98] = NameAndType [207] [208] 
.const [99] = Utf8 com/ibm/oti/util/ASN1Decoder$Node 
.const [100] = Utf8 com/ibm/oti/util/ASN1Encoder 
.const [101] = Class [209] 
.const [102] = NameAndType [210] [211] 
.const [103] = Utf8 java/security/MessageDigest 
.const [104] = Class [212] 
.const [105] = NameAndType [213] [214] 
.const [106] = Utf8 java/util/Arrays 
.const [107] = Class [215] 
.const [108] = NameAndType [216] [217] 
.const [109] = Utf8 java/security/SignatureException 
.const [110] = Utf8 com/ibm/oti/security/provider/X509CertificateChain 
.const [111] = Utf8 java/util/Vector 
.const [112] = Utf8 java/security/cert/Certificate 
.const [113] = Utf8 java/lang/IllegalArgumentException 
.const [114] = Utf8 java/security/cert/CertificateException 
.const [115] = Utf8 java/security/NoSuchAlgorithmException 
.const [116] = Utf8 java/security/InvalidKeyException 
.const [117] = Class [218] 
.const [118] = NameAndType [219] [220] 
.const [119] = Class [221] 
.const [120] = NameAndType [222] [223] 
.const [121] = Class [224] 
.const [122] = NameAndType [225] [226] 
.const [123] = Class [227] 
.const [124] = NameAndType [228] [229] 
.const [125] = Class [230] 
.const [126] = NameAndType [231] [232] 
.const [127] = Class [233] 
.const [128] = NameAndType [234] [235] 
.const [129] = Class [236] 
.const [130] = NameAndType [237] [238] 
.const [131] = Class [239] 
.const [132] = NameAndType [240] [241] 
.const [133] = Class [242] 
.const [134] = NameAndType [243] [244] 
.const [135] = Class [245] 
.const [136] = NameAndType [246] [247] 
.const [137] = Class [248] 
.const [138] = NameAndType [249] [250] 
.const [139] = Class [251] 
.const [140] = NameAndType [252] [253] 
.const [141] = Class [254] 
.const [142] = NameAndType [255] [256] 
.const [143] = Class [257] 
.const [144] = NameAndType [258] [259] 
.const [145] = Class [260] 
.const [146] = NameAndType [261] [262] 
.const [147] = Class [263] 
.const [148] = NameAndType [264] [265] 
.const [149] = Class [266] 
.const [150] = NameAndType [267] [268] 
.const [151] = Class [269] 
.const [152] = NameAndType [270] [271] 
.const [153] = Class [272] 
.const [154] = NameAndType [273] [274] 
.const [155] = Class [275] 
.const [156] = NameAndType [276] [277] 
.const [157] = Class [278] 
.const [158] = NameAndType [279] [280] 
.const [159] = Class [281] 
.const [160] = NameAndType [282] [283] 
.const [161] = Class [284] 
.const [162] = NameAndType [285] [286] 
.const [163] = Class [287] 
.const [164] = NameAndType [288] [289] 
.const [165] = Class [290] 
.const [166] = NameAndType [291] [292] 
.const [167] = Class [293] 
.const [168] = NameAndType [294] [295] 
.const [169] = Class [296] 
.const [170] = NameAndType [297] [298] 
.const [171] = Class [299] 
.const [172] = NameAndType [300] [301] 
.const [173] = Class [302] 
.const [174] = NameAndType [303] [304] 
.const [175] = Class [305] 
.const [176] = NameAndType [306] [307] 
.const [177] = Class [308] 
.const [178] = NameAndType [309] [310] 
.const [179] = Class [311] 
.const [180] = NameAndType [312] [313] 
.const [181] = Class [314] 
.const [182] = NameAndType [315] [316] 
.const [183] = Class [317] 
.const [184] = NameAndType [318] [319] 
.const [185] = Utf8 com/ibm/oti/security/provider/PKCS7 
.const [186] = Utf8 java/io/ByteArrayInputStream 
.const [187] = Class [320] 
.const [188] = NameAndType [321] [322] 
.const [189] = Class [323] 
.const [190] = NameAndType [324] [325] 
.const [191] = Class [326] 
.const [192] = NameAndType [327] [328] 
.const [193] = Class [329] 
.const [194] = NameAndType [330] [331] 
.const [195] = Utf8 com/ibm/oti/util/ASN1Decoder$Node 
.const [196] = Class [332] 
.const [197] = NameAndType [333] [334] 
.const [198] = Class [335] 
.const [199] = NameAndType [336] [337] 
.const [200] = Utf8 java/security/SignatureException 
.const [201] = Utf8 com/ibm/oti/security/provider/X509CertificateChain 
.const [202] = Utf8 java/util/Vector 
.const [203] = Utf8 java/security/cert/CertificateFactory 
.const [204] = Utf8 getInstance 
.const [205] = Utf8 (Ljava/lang/String;)Ljava/security/cert/CertificateFactory; 
.const [206] = Utf8 java/security/Signature 
.const [207] = Utf8 getInstance 
.const [208] = Utf8 (Ljava/lang/String;)Ljava/security/Signature; 
.const [209] = Utf8 com/ibm/oti/util/ASN1Encoder 
.const [210] = Utf8 encodeNode 
.const [211] = Utf8 (Lcom/ibm/oti/util/ASN1Decoder$Node;)[B 
.const [212] = Utf8 java/security/MessageDigest 
.const [213] = Utf8 getInstance 
.const [214] = Utf8 (Ljava/lang/String;)Ljava/security/MessageDigest; 
.const [215] = Utf8 java/util/Arrays 
.const [216] = Utf8 equals 
.const [217] = Utf8 ([B[B)Z 
.const [218] = Utf8 com/ibm/oti/security/provider/PKCS7 
.const [219] = Utf8 getASN1DEREncoded 
.const [220] = Utf8 ([Ljava/security/cert/Certificate;Ljava/lang/String;Ljava/lang/String;[B)[B 
.const [221] = Utf8 java/io/InputStream 
.const [222] = Utf8 available 
.const [223] = Utf8 ()I 
.const [224] = Utf8 java/io/InputStream 
.const [225] = Utf8 read 
.const [226] = Utf8 ([BII)I 
.const [227] = Utf8 java/io/InputStream 
.const [228] = Utf8 close 
.const [229] = Utf8 ()V 
.const [230] = Utf8 com/ibm/oti/security/provider/PKCS7 
.const [231] = Utf8 signedData 
.const [232] = Utf8 ()Lcom/ibm/oti/security/provider/PKCS7$SignedData; 
.const [233] = Utf8 com/ibm/oti/security/provider/PKCS7$SignedData 
.const [234] = Utf8 signerInfos 
.const [235] = Utf8 ()[Lcom/ibm/oti/security/provider/PKCS7$SignerInfo; 
.const [236] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [237] = Utf8 getIssuer 
.const [238] = Utf8 ()Ljava/security/Principal; 
.const [239] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [240] = Utf8 getSerialNumber 
.const [241] = Utf8 ()Ljava/math/BigInteger; 
.const [242] = Utf8 java/security/cert/CertificateFactory 
.const [243] = Utf8 generateCertificates 
.const [244] = Utf8 (Ljava/io/InputStream;)Ljava/util/Collection; 
.const [245] = Utf8 java/security/cert/X509Certificate 
.const [246] = Utf8 getIssuerDN 
.const [247] = Utf8 ()Ljava/security/Principal; 
.const [248] = Utf8 java/security/cert/X509Certificate 
.const [249] = Utf8 getSerialNumber 
.const [250] = Utf8 ()Ljava/math/BigInteger; 
.const [251] = Utf8 java/math/BigInteger 
.const [252] = Utf8 equals 
.const [253] = Utf8 (Ljava/lang/Object;)Z 
.const [254] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [255] = Utf8 signatureName 
.const [256] = Utf8 ()Ljava/lang/String; 
.const [257] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [258] = Utf8 digestEncryptionAlgorithm 
.const [259] = Utf8 ()Ljava/lang/String; 
.const [260] = Utf8 java/security/cert/X509Certificate 
.const [261] = Utf8 getPublicKey 
.const [262] = Utf8 ()Ljava/security/PublicKey; 
.const [263] = Utf8 java/security/Signature 
.const [264] = Utf8 initVerify 
.const [265] = Utf8 (Ljava/security/PublicKey;)V 
.const [266] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [267] = Utf8 authenticatedAttributes 
.const [268] = Utf8 ()[Lcom/ibm/oti/util/ASN1Decoder$Node; 
.const [269] = Utf8 java/security/Signature 
.const [270] = Utf8 update 
.const [271] = Utf8 ([B)V 
.const [272] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [273] = Utf8 contentMessageDigest 
.const [274] = Utf8 ()[B 
.const [275] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [276] = Utf8 digestAlgorithm 
.const [277] = Utf8 ()Ljava/lang/String; 
.const [278] = Utf8 java/security/MessageDigest 
.const [279] = Utf8 digest 
.const [280] = Utf8 ([B)[B 
.const [281] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [282] = Utf8 encryptedDigest 
.const [283] = Utf8 ()[B 
.const [284] = Utf8 java/security/Signature 
.const [285] = Utf8 verify 
.const [286] = Utf8 ([B)Z 
.const [287] = Utf8 java/security/cert/X509Certificate 
.const [288] = Utf8 hasUnsupportedCriticalExtension 
.const [289] = Utf8 ()Z 
.const [290] = Utf8 com/ibm/oti/security/provider/X509CertificateChain 
.const [291] = Utf8 iterator 
.const [292] = Utf8 ()Ljava/util/Iterator; 
.const [293] = Utf8 java/util/Vector 
.const [294] = Utf8 add 
.const [295] = Utf8 (Ljava/lang/Object;)Z 
.const [296] = Utf8 java/util/Vector 
.const [297] = Utf8 toArray 
.const [298] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [299] = Utf8 java/lang/Object 
.const [300] = Utf8 <init> 
.const [301] = Utf8 ()V 
.const [302] = Utf8 com/ibm/oti/security/provider/PKCS7 
.const [303] = Utf8 <init> 
.const [304] = Utf8 ([B)V 
.const [305] = Utf8 java/io/ByteArrayInputStream 
.const [306] = Utf8 <init> 
.const [307] = Utf8 ([B)V 
.const [308] = Utf8 com/ibm/oti/util/ASN1Decoder$Node 
.const [309] = Utf8 <init> 
.const [310] = Utf8 ()V 
.const [311] = Utf8 java/security/SignatureException 
.const [312] = Utf8 <init> 
.const [313] = Utf8 ()V 
.const [314] = Utf8 com/ibm/oti/security/provider/X509CertificateChain 
.const [315] = Utf8 <init> 
.const [316] = Utf8 (Ljava/security/cert/X509Certificate;Ljava/util/Collection;)V 
.const [317] = Utf8 java/util/Vector 
.const [318] = Utf8 <init> 
.const [319] = Utf8 ()V 
.const [320] = Utf8 java/util/Collection 
.const [321] = Utf8 iterator 
.const [322] = Utf8 ()Ljava/util/Iterator; 
.const [323] = Utf8 java/util/Iterator 
.const [324] = Utf8 next 
.const [325] = Utf8 ()Ljava/lang/Object; 
.const [326] = Utf8 java/security/Principal 
.const [327] = Utf8 equals 
.const [328] = Utf8 (Ljava/lang/Object;)Z 
.const [329] = Utf8 java/util/Iterator 
.const [330] = Utf8 hasNext 
.const [331] = Utf8 ()Z 
.const [332] = Utf8 com/ibm/oti/util/ASN1Decoder$Node 
.const [333] = Utf8 type 
.const [334] = Utf8 I 
.const [335] = Utf8 com/ibm/oti/util/ASN1Decoder$Node 
.const [336] = Utf8 data 
.const [337] = Utf8 Ljava/lang/Object; 
.const [338] = Utf8 com/ibm/oti/util/JarUtils 
.const [339] = Class [338] 
.const [340] = Utf8 java/lang/Object 
.const [341] = Class [340] 
.const [342] = Utf8 Code 
.const [343] = Utf8 <init> 
.const [344] = Utf8 ()V 
.const [345] = Utf8 verifySignature 
.const [346] = Utf8 (Ljava/io/InputStream;Ljava/io/InputStream;)[Ljava/security/cert/Certificate; 
.const [347] = Utf8 getSignatureBlockBytes 
.const [348] = Utf8 ([B[Ljava/security/cert/Certificate;Ljava/lang/String;Ljava/lang/String;)[B 
.end class 
