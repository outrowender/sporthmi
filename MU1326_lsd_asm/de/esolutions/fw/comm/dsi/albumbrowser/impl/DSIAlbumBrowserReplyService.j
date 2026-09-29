.version 50 0 
.class public super [217] 
.super [219] 
.field private static final [220] [221] 
.field private static [222] [223] 
.field private [224] [225] 

.method public [227] : [228] 
    .attribute [226] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [35] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [29] 
L17:    invokespecial [30] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [36] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [229] : [230] 
    .attribute [226] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [31] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [226] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [226] .code stack 5 locals 4 
        .catch [13] from L0 to L413 using L416 
L0:     iload_1 
L1:     tableswitch 8 
            L258 
            L386 
            L386 
            L386 
            L386 
            L386 
            L386 
            L386 
            L386 
            L386 
            L386 
            L386 
            L386 
            L280 
            L312 
            L100 
            L132 
            L162 
            L194 
            L226 
            L354 
            default : L386 

L100:   aload_2 
L101:   invokeinterface [37] 0 
L106:   istore 4 
L108:   aload_2 
L109:   invokeinterface [37] 0 
L114:   istore 5 
L116:   aload_0 
L117:   getfield [24] 
L120:   iload 4 
L122:   iload 5 
L124:   invokeinterface [38] 0 
L129:   goto L413 
L132:   aload_2 
L133:   invokestatic [9] 
L136:   astore 4 
L138:   aload_2 
L139:   invokeinterface [37] 0 
L144:   istore 5 
L146:   aload_0 
L147:   getfield [24] 
L150:   aload 4 
L152:   iload 5 
L154:   invokeinterface [39] 0 
L159:   goto L413 
L162:   aload_2 
L163:   invokeinterface [40] 0 
L168:   lstore 4 
L170:   aload_2 
L171:   invokeinterface [37] 0 
L176:   istore 6 
L178:   aload_0 
L179:   getfield [24] 
L182:   lload 4 
L184:   iload 6 
L186:   invokeinterface [41] 0 
L191:   goto L413 
L194:   aload_2 
L195:   invokeinterface [40] 0 
L200:   lstore 4 
L202:   aload_2 
L203:   invokeinterface [37] 0 
L208:   istore 6 
L210:   aload_0 
L211:   getfield [24] 
L214:   lload 4 
L216:   iload 6 
L218:   invokeinterface [42] 0 
L223:   goto L413 
L226:   aload_2 
L227:   invokeinterface [37] 0 
L232:   istore 4 
L234:   aload_2 
L235:   invokeinterface [37] 0 
L240:   istore 5 
L242:   aload_0 
L243:   getfield [24] 
L246:   iload 4 
L248:   iload 5 
L250:   invokeinterface [43] 0 
L255:   goto L413 
L258:   aload_2 
L259:   invokeinterface [40] 0 
L264:   lstore 4 
L266:   aload_0 
L267:   getfield [24] 
L270:   lload 4 
L272:   invokeinterface [44] 0 
L277:   goto L413 
L280:   aload_2 
L281:   invokeinterface [40] 0 
L286:   lstore 4 
L288:   aload_2 
L289:   invokeinterface [40] 0 
L294:   lstore 6 
L296:   aload_0 
L297:   getfield [24] 
L300:   lload 4 
L302:   lload 6 
L304:   invokeinterface [45] 0 
L309:   goto L413 
L312:   aload_2 
L313:   invokeinterface [37] 0 
L318:   istore 4 
L320:   aload_2 
L321:   invokeinterface [46] 0 
L326:   astore 5 
L328:   aload_2 
L329:   invokeinterface [37] 0 
L334:   istore 6 
L336:   aload_0 
L337:   getfield [24] 
L340:   iload 4 
L342:   aload 5 
L344:   iload 6 
L346:   invokeinterface [47] 0 
L351:   goto L413 
L354:   aload_2 
L355:   invokeinterface [46] 0 
L360:   astore 4 
L362:   aload_2 
L363:   invokeinterface [46] 0 
L368:   astore 5 
L370:   aload_0 
L371:   getfield [24] 
L374:   aload 4 
L376:   aload 5 
L378:   invokeinterface [48] 0 
L383:   goto L413 
L386:   new [49] 
L389:   dup 
L390:   new [50] 
L393:   dup 
L394:   invokespecial [33] 
L397:   ldc [12] 
L399:   invokevirtual [25] 
L402:   iload_1 
L403:   invokevirtual [26] 
L406:   invokevirtual [27] 
L409:   invokespecial [34] 
L412:   athrow 
L413:   goto L458 
L416:   astore 4 
L418:   new [49] 
L421:   dup 
L422:   new [50] 
L425:   dup 
L426:   invokespecial [33] 
L429:   ldc [14] 
L431:   invokevirtual [25] 
L434:   iload_1 
L435:   invokevirtual [26] 
L438:   ldc [15] 
L440:   invokevirtual [25] 
L443:   aload 4 
L445:   invokevirtual [28] 
L448:   invokevirtual [25] 
L451:   invokevirtual [27] 
L454:   invokespecial [34] 
L457:   athrow 
L458:   return 
L459:   nop 
L460:   
    .end code 
.end method 

.method static [235] : [236] 
    .attribute [226] .code stack 1 locals 0 
L0:     ldc [16] 
L2:     invokestatic [17] 
L5:     putstatic [32] 
L8:     iconst_0 
L9:     putstatic [31] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [51] 
.const [3] = String [52] 
.const [4] = Method [53] [54] 
.const [5] = String [55] 
.const [6] = String [56] 
.const [7] = Field [57] [58] 
.const [8] = Field [59] [60] 
.const [9] = Method [61] [62] 
.const [10] = Class [63] 
.const [11] = Class [64] 
.const [12] = String [65] 
.const [13] = Class [66] 
.const [14] = String [67] 
.const [15] = String [68] 
.const [16] = String [69] 
.const [17] = Method [70] [71] 
.const [18] = Class [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Class [77] 
.const [24] = Field [78] [79] 
.const [25] = Method [80] [81] 
.const [26] = Method [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Method [88] [89] 
.const [30] = Method [90] [91] 
.const [31] = Field [92] [93] 
.const [32] = Field [94] [95] 
.const [33] = Method [96] [97] 
.const [34] = Method [98] [99] 
.const [35] = Class [100] 
.const [36] = Field [101] [102] 
.const [37] = InterfaceMethod [103] [104] 
.const [38] = InterfaceMethod [105] [106] 
.const [39] = InterfaceMethod [107] [108] 
.const [40] = InterfaceMethod [109] [110] 
.const [41] = InterfaceMethod [111] [112] 
.const [42] = InterfaceMethod [113] [114] 
.const [43] = InterfaceMethod [115] [116] 
.const [44] = InterfaceMethod [117] [118] 
.const [45] = InterfaceMethod [119] [120] 
.const [46] = InterfaceMethod [121] [122] 
.const [47] = InterfaceMethod [123] [124] 
.const [48] = InterfaceMethod [125] [126] 
.const [49] = Class [127] 
.const [50] = Class [128] 
.const [51] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [52] = Utf8 '11bb0e6e-82d5-5623-848e-eeb35a1a5bb1' 
.const [53] = Class [129] 
.const [54] = NameAndType [130] [131] 
.const [55] = Utf8 '7b023b24-ce3d-579c-b971-3ace26adedfb' 
.const [56] = Utf8 'dsi.albumbrowser.DSIAlbumBrowser' 
.const [57] = Class [132] 
.const [58] = NameAndType [133] [134] 
.const [59] = Class [135] 
.const [60] = NameAndType [136] [137] 
.const [61] = Class [138] 
.const [62] = NameAndType [139] [140] 
.const [63] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [64] = Utf8 java/lang/StringBuffer 
.const [65] = Utf8 'Invalid Method Id ' 
.const [66] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [67] = Utf8 'Deserialization failed: method=' 
.const [68] = Utf8 ', error=' 
.const [69] = Utf8 'STUB.dsi.albumbrowser.DSIAlbumBrowser' 
.const [70] = Class [141] 
.const [71] = NameAndType [142] [143] 
.const [72] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/DSIAlbumBrowserReplyService 
.const [73] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [74] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [75] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply 
.const [76] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/AlbumEntryInfoSerializer 
.const [77] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [78] = Class [144] 
.const [79] = NameAndType [145] [146] 
.const [80] = Class [147] 
.const [81] = NameAndType [148] [149] 
.const [82] = Class [150] 
.const [83] = NameAndType [151] [152] 
.const [84] = Class [153] 
.const [85] = NameAndType [154] [155] 
.const [86] = Class [156] 
.const [87] = NameAndType [157] [158] 
.const [88] = Class [159] 
.const [89] = NameAndType [160] [161] 
.const [90] = Class [162] 
.const [91] = NameAndType [163] [164] 
.const [92] = Class [165] 
.const [93] = NameAndType [166] [167] 
.const [94] = Class [168] 
.const [95] = NameAndType [169] [170] 
.const [96] = Class [171] 
.const [97] = NameAndType [172] [173] 
.const [98] = Class [174] 
.const [99] = NameAndType [175] [176] 
.const [100] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [101] = Class [177] 
.const [102] = NameAndType [178] [179] 
.const [103] = Class [180] 
.const [104] = NameAndType [181] [182] 
.const [105] = Class [183] 
.const [106] = NameAndType [184] [185] 
.const [107] = Class [186] 
.const [108] = NameAndType [187] [188] 
.const [109] = Class [189] 
.const [110] = NameAndType [190] [191] 
.const [111] = Class [192] 
.const [112] = NameAndType [193] [194] 
.const [113] = Class [195] 
.const [114] = NameAndType [196] [197] 
.const [115] = Class [198] 
.const [116] = NameAndType [199] [200] 
.const [117] = Class [201] 
.const [118] = NameAndType [202] [203] 
.const [119] = Class [204] 
.const [120] = NameAndType [205] [206] 
.const [121] = Class [207] 
.const [122] = NameAndType [208] [209] 
.const [123] = Class [210] 
.const [124] = NameAndType [211] [212] 
.const [125] = Class [213] 
.const [126] = NameAndType [214] [215] 
.const [127] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [128] = Utf8 java/lang/StringBuffer 
.const [129] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/DSIAlbumBrowserReplyService 
.const [130] = Utf8 nextDynamicHandle 
.const [131] = Utf8 ()I 
.const [132] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/DSIAlbumBrowserReplyService 
.const [133] = Utf8 dynamicHandle 
.const [134] = Utf8 I 
.const [135] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/DSIAlbumBrowserReplyService 
.const [136] = Utf8 context 
.const [137] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [138] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/AlbumEntryInfoSerializer 
.const [139] = Utf8 getOptionalAlbumEntryInfo 
.const [140] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/albumbrowser/AlbumEntryInfo; 
.const [141] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [142] = Utf8 getContext 
.const [143] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [144] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/DSIAlbumBrowserReplyService 
.const [145] = Utf8 p_DSIAlbumBrowserReply 
.const [146] = Utf8 Lde/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply; 
.const [147] = Utf8 java/lang/StringBuffer 
.const [148] = Utf8 append 
.const [149] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 append 
.const [152] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [153] = Utf8 java/lang/StringBuffer 
.const [154] = Utf8 toString 
.const [155] = Utf8 ()Ljava/lang/String; 
.const [156] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [157] = Utf8 getMessage 
.const [158] = Utf8 ()Ljava/lang/String; 
.const [159] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [162] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [165] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/DSIAlbumBrowserReplyService 
.const [166] = Utf8 dynamicHandle 
.const [167] = Utf8 I 
.const [168] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/DSIAlbumBrowserReplyService 
.const [169] = Utf8 context 
.const [170] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [171] = Utf8 java/lang/StringBuffer 
.const [172] = Utf8 <init> 
.const [173] = Utf8 ()V 
.const [174] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Ljava/lang/String;)V 
.const [177] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/DSIAlbumBrowserReplyService 
.const [178] = Utf8 p_DSIAlbumBrowserReply 
.const [179] = Utf8 Lde/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply; 
.const [180] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [181] = Utf8 getInt32 
.const [182] = Utf8 ()I 
.const [183] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply 
.const [184] = Utf8 updateBrowserState 
.const [185] = Utf8 (II)V 
.const [186] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply 
.const [187] = Utf8 updateFocusedEntry 
.const [188] = Utf8 (Lorg/dsi/ifc/albumbrowser/AlbumEntryInfo;I)V 
.const [189] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [190] = Utf8 getInt64 
.const [191] = Utf8 ()J 
.const [192] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply 
.const [193] = Utf8 updateListPosition 
.const [194] = Utf8 (JI)V 
.const [195] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply 
.const [196] = Utf8 updateNumEntries 
.const [197] = Utf8 (JI)V 
.const [198] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply 
.const [199] = Utf8 updateScrollMode 
.const [200] = Utf8 (II)V 
.const [201] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply 
.const [202] = Utf8 selectAlbum 
.const [203] = Utf8 (J)V 
.const [204] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply 
.const [205] = Utf8 albumIdxForFID 
.const [206] = Utf8 (JJ)V 
.const [207] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [208] = Utf8 getOptionalString 
.const [209] = Utf8 ()Ljava/lang/String; 
.const [210] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply 
.const [211] = Utf8 asyncException 
.const [212] = Utf8 (ILjava/lang/String;I)V 
.const [213] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply 
.const [214] = Utf8 yyIndication 
.const [215] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [216] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/DSIAlbumBrowserReplyService 
.const [217] = Class [216] 
.const [218] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [219] = Class [218] 
.const [220] = Utf8 context 
.const [221] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [222] = Utf8 dynamicHandle 
.const [223] = Utf8 I 
.const [224] = Utf8 p_DSIAlbumBrowserReply 
.const [225] = Utf8 Lde/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply; 
.const [226] = Utf8 Code 
.const [227] = Utf8 <init> 
.const [228] = Utf8 (Lde/esolutions/fw/comm/dsi/albumbrowser/DSIAlbumBrowserReply;)V 
.const [229] = Utf8 nextDynamicHandle 
.const [230] = Utf8 ()I 
.const [231] = Utf8 getCallContext 
.const [232] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [233] = Utf8 handleCallMethod 
.const [234] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [235] = Utf8 <clinit> 
.const [236] = Utf8 ()V 
.end class 
