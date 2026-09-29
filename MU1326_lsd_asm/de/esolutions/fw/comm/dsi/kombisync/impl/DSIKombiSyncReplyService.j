.version 50 0 
.class public super [233] 
.super [235] 
.field private static final [236] [237] 
.field private static [238] [239] 
.field private [240] [241] 

.method public [243] : [244] 
    .attribute [242] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [39] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [33] 
L17:    invokespecial [34] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [40] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [245] : [246] 
    .attribute [242] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [35] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [242] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [242] .code stack 4 locals 3 
        .catch [15] from L0 to L393 using L396 
L0:     iload_1 
L1:     lookupswitch 
            0 : L292 
            15 : L84 
            16 : L334 
            25 : L148 
            26 : L116 
            27 : L180 
            33 : L242 
            34 : L212 
            39 : L262 
            default : L366 

L84:    aload_2 
L85:    invokeinterface [41] 0 
L90:    istore 4 
L92:    aload_2 
L93:    invokeinterface [42] 0 
L98:    istore 5 
L100:   aload_0 
L101:   getfield [28] 
L104:   iload 4 
L106:   iload 5 
L108:   invokeinterface [43] 0 
L113:   goto L393 
L116:   aload_2 
L117:   invokeinterface [42] 0 
L122:   istore 4 
L124:   aload_2 
L125:   invokeinterface [42] 0 
L130:   istore 5 
L132:   aload_0 
L133:   getfield [28] 
L136:   iload 4 
L138:   iload 5 
L140:   invokeinterface [44] 0 
L145:   goto L393 
L148:   aload_2 
L149:   invokeinterface [42] 0 
L154:   istore 4 
L156:   aload_2 
L157:   invokeinterface [42] 0 
L162:   istore 5 
L164:   aload_0 
L165:   getfield [28] 
L168:   iload 4 
L170:   iload 5 
L172:   invokeinterface [45] 0 
L177:   goto L393 
L180:   aload_2 
L181:   invokeinterface [42] 0 
L186:   istore 4 
L188:   aload_2 
L189:   invokeinterface [42] 0 
L194:   istore 5 
L196:   aload_0 
L197:   getfield [28] 
L200:   iload 4 
L202:   iload 5 
L204:   invokeinterface [46] 0 
L209:   goto L393 
L212:   aload_2 
L213:   invokestatic [9] 
L216:   astore 4 
L218:   aload_2 
L219:   invokeinterface [42] 0 
L224:   istore 5 
L226:   aload_0 
L227:   getfield [28] 
L230:   aload 4 
L232:   iload 5 
L234:   invokeinterface [47] 0 
L239:   goto L393 
L242:   aload_2 
L243:   invokestatic [10] 
L246:   astore 4 
L248:   aload_0 
L249:   getfield [28] 
L252:   aload 4 
L254:   invokeinterface [48] 0 
L259:   goto L393 
L262:   aload_2 
L263:   invokestatic [11] 
L266:   astore 4 
L268:   aload_2 
L269:   invokeinterface [42] 0 
L274:   istore 5 
L276:   aload_0 
L277:   getfield [28] 
L280:   aload 4 
L282:   iload 5 
L284:   invokeinterface [49] 0 
L289:   goto L393 
L292:   aload_2 
L293:   invokeinterface [42] 0 
L298:   istore 4 
L300:   aload_2 
L301:   invokeinterface [50] 0 
L306:   astore 5 
L308:   aload_2 
L309:   invokeinterface [42] 0 
L314:   istore 6 
L316:   aload_0 
L317:   getfield [28] 
L320:   iload 4 
L322:   aload 5 
L324:   iload 6 
L326:   invokeinterface [51] 0 
L331:   goto L393 
L334:   aload_2 
L335:   invokeinterface [50] 0 
L340:   astore 4 
L342:   aload_2 
L343:   invokeinterface [50] 0 
L348:   astore 5 
L350:   aload_0 
L351:   getfield [28] 
L354:   aload 4 
L356:   aload 5 
L358:   invokeinterface [52] 0 
L363:   goto L393 
L366:   new [53] 
L369:   dup 
L370:   new [54] 
L373:   dup 
L374:   invokespecial [37] 
L377:   ldc [14] 
L379:   invokevirtual [29] 
L382:   iload_1 
L383:   invokevirtual [30] 
L386:   invokevirtual [31] 
L389:   invokespecial [38] 
L392:   athrow 
L393:   goto L438 
L396:   astore 4 
L398:   new [53] 
L401:   dup 
L402:   new [54] 
L405:   dup 
L406:   invokespecial [37] 
L409:   ldc [16] 
L411:   invokevirtual [29] 
L414:   iload_1 
L415:   invokevirtual [30] 
L418:   ldc [17] 
L420:   invokevirtual [29] 
L423:   aload 4 
L425:   invokevirtual [32] 
L428:   invokevirtual [29] 
L431:   invokevirtual [31] 
L434:   invokespecial [38] 
L437:   athrow 
L438:   return 
L439:   nop 
L440:   
    .end code 
.end method 

.method static [251] : [252] 
    .attribute [242] .code stack 1 locals 0 
L0:     ldc [18] 
L2:     invokestatic [19] 
L5:     putstatic [36] 
L8:     iconst_0 
L9:     putstatic [35] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [55] 
.const [3] = String [56] 
.const [4] = Method [57] [58] 
.const [5] = String [59] 
.const [6] = String [60] 
.const [7] = Field [61] [62] 
.const [8] = Field [63] [64] 
.const [9] = Method [65] [66] 
.const [10] = Method [67] [68] 
.const [11] = Method [69] [70] 
.const [12] = Class [71] 
.const [13] = Class [72] 
.const [14] = String [73] 
.const [15] = Class [74] 
.const [16] = String [75] 
.const [17] = String [76] 
.const [18] = String [77] 
.const [19] = Method [78] [79] 
.const [20] = Class [80] 
.const [21] = Class [81] 
.const [22] = Class [82] 
.const [23] = Class [83] 
.const [24] = Class [84] 
.const [25] = Class [85] 
.const [26] = Class [86] 
.const [27] = Class [87] 
.const [28] = Field [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Field [102] [103] 
.const [36] = Field [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Class [110] 
.const [40] = Field [111] [112] 
.const [41] = InterfaceMethod [113] [114] 
.const [42] = InterfaceMethod [115] [116] 
.const [43] = InterfaceMethod [117] [118] 
.const [44] = InterfaceMethod [119] [120] 
.const [45] = InterfaceMethod [121] [122] 
.const [46] = InterfaceMethod [123] [124] 
.const [47] = InterfaceMethod [125] [126] 
.const [48] = InterfaceMethod [127] [128] 
.const [49] = InterfaceMethod [129] [130] 
.const [50] = InterfaceMethod [131] [132] 
.const [51] = InterfaceMethod [133] [134] 
.const [52] = InterfaceMethod [135] [136] 
.const [53] = Class [137] 
.const [54] = Class [138] 
.const [55] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [56] = Utf8 '40d02636-2ab7-567a-9154-88be065dffaf' 
.const [57] = Class [139] 
.const [58] = NameAndType [140] [141] 
.const [59] = Utf8 '537ae951-1aea-55dd-a1d3-eb95ccc3ecd3' 
.const [60] = Utf8 'dsi.kombisync.DSIKombiSync' 
.const [61] = Class [142] 
.const [62] = NameAndType [143] [144] 
.const [63] = Class [145] 
.const [64] = NameAndType [146] [147] 
.const [65] = Class [148] 
.const [66] = NameAndType [149] [150] 
.const [67] = Class [151] 
.const [68] = NameAndType [152] [153] 
.const [69] = Class [154] 
.const [70] = NameAndType [155] [156] 
.const [71] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [72] = Utf8 java/lang/StringBuffer 
.const [73] = Utf8 'Invalid Method Id ' 
.const [74] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [75] = Utf8 'Deserialization failed: method=' 
.const [76] = Utf8 ', error=' 
.const [77] = Utf8 'STUB.dsi.kombisync.DSIKombiSync' 
.const [78] = Class [157] 
.const [79] = NameAndType [158] [159] 
.const [80] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/DSIKombiSyncReplyService 
.const [81] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [82] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [83] = Utf8 de/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply 
.const [84] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/KombiDisplayStatusSerializer 
.const [85] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/KombiDisplayRequestSerializer 
.const [86] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/KombiPopupStatusSerializer 
.const [87] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [88] = Class [160] 
.const [89] = NameAndType [161] [162] 
.const [90] = Class [163] 
.const [91] = NameAndType [164] [165] 
.const [92] = Class [166] 
.const [93] = NameAndType [167] [168] 
.const [94] = Class [169] 
.const [95] = NameAndType [170] [171] 
.const [96] = Class [172] 
.const [97] = NameAndType [173] [174] 
.const [98] = Class [175] 
.const [99] = NameAndType [176] [177] 
.const [100] = Class [178] 
.const [101] = NameAndType [179] [180] 
.const [102] = Class [181] 
.const [103] = NameAndType [182] [183] 
.const [104] = Class [184] 
.const [105] = NameAndType [185] [186] 
.const [106] = Class [187] 
.const [107] = NameAndType [188] [189] 
.const [108] = Class [190] 
.const [109] = NameAndType [191] [192] 
.const [110] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [111] = Class [193] 
.const [112] = NameAndType [194] [195] 
.const [113] = Class [196] 
.const [114] = NameAndType [197] [198] 
.const [115] = Class [199] 
.const [116] = NameAndType [200] [201] 
.const [117] = Class [202] 
.const [118] = NameAndType [203] [204] 
.const [119] = Class [205] 
.const [120] = NameAndType [206] [207] 
.const [121] = Class [208] 
.const [122] = NameAndType [209] [210] 
.const [123] = Class [211] 
.const [124] = NameAndType [212] [213] 
.const [125] = Class [214] 
.const [126] = NameAndType [215] [216] 
.const [127] = Class [217] 
.const [128] = NameAndType [218] [219] 
.const [129] = Class [220] 
.const [130] = NameAndType [221] [222] 
.const [131] = Class [223] 
.const [132] = NameAndType [224] [225] 
.const [133] = Class [226] 
.const [134] = NameAndType [227] [228] 
.const [135] = Class [229] 
.const [136] = NameAndType [230] [231] 
.const [137] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [138] = Utf8 java/lang/StringBuffer 
.const [139] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/DSIKombiSyncReplyService 
.const [140] = Utf8 nextDynamicHandle 
.const [141] = Utf8 ()I 
.const [142] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/DSIKombiSyncReplyService 
.const [143] = Utf8 dynamicHandle 
.const [144] = Utf8 I 
.const [145] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/DSIKombiSyncReplyService 
.const [146] = Utf8 context 
.const [147] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [148] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/KombiDisplayStatusSerializer 
.const [149] = Utf8 getOptionalKombiDisplayStatus 
.const [150] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/kombisync/KombiDisplayStatus; 
.const [151] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/KombiDisplayRequestSerializer 
.const [152] = Utf8 getOptionalKombiDisplayRequest 
.const [153] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/kombisync/KombiDisplayRequest; 
.const [154] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/KombiPopupStatusSerializer 
.const [155] = Utf8 getOptionalKombiPopupStatus 
.const [156] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/kombisync/KombiPopupStatus; 
.const [157] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [158] = Utf8 getContext 
.const [159] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [160] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/DSIKombiSyncReplyService 
.const [161] = Utf8 p_DSIKombiSyncReply 
.const [162] = Utf8 Lde/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply; 
.const [163] = Utf8 java/lang/StringBuffer 
.const [164] = Utf8 append 
.const [165] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [166] = Utf8 java/lang/StringBuffer 
.const [167] = Utf8 append 
.const [168] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [169] = Utf8 java/lang/StringBuffer 
.const [170] = Utf8 toString 
.const [171] = Utf8 ()Ljava/lang/String; 
.const [172] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [173] = Utf8 getMessage 
.const [174] = Utf8 ()Ljava/lang/String; 
.const [175] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [176] = Utf8 <init> 
.const [177] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [178] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [181] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/DSIKombiSyncReplyService 
.const [182] = Utf8 dynamicHandle 
.const [183] = Utf8 I 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/DSIKombiSyncReplyService 
.const [185] = Utf8 context 
.const [186] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [187] = Utf8 java/lang/StringBuffer 
.const [188] = Utf8 <init> 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Ljava/lang/String;)V 
.const [193] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/DSIKombiSyncReplyService 
.const [194] = Utf8 p_DSIKombiSyncReply 
.const [195] = Utf8 Lde/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply; 
.const [196] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [197] = Utf8 getBool 
.const [198] = Utf8 ()Z 
.const [199] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [200] = Utf8 getInt32 
.const [201] = Utf8 ()I 
.const [202] = Utf8 de/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply 
.const [203] = Utf8 updateKombiCommunicationState 
.const [204] = Utf8 (ZI)V 
.const [205] = Utf8 de/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply 
.const [206] = Utf8 updateKombiMessageStateDisplayStatus 
.const [207] = Utf8 (II)V 
.const [208] = Utf8 de/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply 
.const [209] = Utf8 updateKombiMessageStateDisplayRequest 
.const [210] = Utf8 (II)V 
.const [211] = Utf8 de/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply 
.const [212] = Utf8 updateKombiMessageStatePopupStatus 
.const [213] = Utf8 (II)V 
.const [214] = Utf8 de/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply 
.const [215] = Utf8 responseKombiDisplayStatus 
.const [216] = Utf8 (Lorg/dsi/ifc/kombisync/KombiDisplayStatus;I)V 
.const [217] = Utf8 de/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply 
.const [218] = Utf8 responseKombiDisplayRequest 
.const [219] = Utf8 (Lorg/dsi/ifc/kombisync/KombiDisplayRequest;)V 
.const [220] = Utf8 de/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply 
.const [221] = Utf8 responseKombiPopupStatus 
.const [222] = Utf8 (Lorg/dsi/ifc/kombisync/KombiPopupStatus;I)V 
.const [223] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [224] = Utf8 getOptionalString 
.const [225] = Utf8 ()Ljava/lang/String; 
.const [226] = Utf8 de/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply 
.const [227] = Utf8 asyncException 
.const [228] = Utf8 (ILjava/lang/String;I)V 
.const [229] = Utf8 de/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply 
.const [230] = Utf8 yyIndication 
.const [231] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [232] = Utf8 de/esolutions/fw/comm/dsi/kombisync/impl/DSIKombiSyncReplyService 
.const [233] = Class [232] 
.const [234] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [235] = Class [234] 
.const [236] = Utf8 context 
.const [237] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [238] = Utf8 dynamicHandle 
.const [239] = Utf8 I 
.const [240] = Utf8 p_DSIKombiSyncReply 
.const [241] = Utf8 Lde/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply; 
.const [242] = Utf8 Code 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (Lde/esolutions/fw/comm/dsi/kombisync/DSIKombiSyncReply;)V 
.const [245] = Utf8 nextDynamicHandle 
.const [246] = Utf8 ()I 
.const [247] = Utf8 getCallContext 
.const [248] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [249] = Utf8 handleCallMethod 
.const [250] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [251] = Utf8 <clinit> 
.const [252] = Utf8 ()V 
.end class 
