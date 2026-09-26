.version 50 0 
.class public super [235] 
.super [237] 
.field private static final [238] [239] 
.field private static [240] [241] 
.field private [242] [243] 

.method public [245] : [246] 
    .attribute [244] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [41] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [35] 
L17:    invokespecial [36] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [42] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [247] : [248] 
    .attribute [244] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [37] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [244] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [244] .code stack 6 locals 5 
        .catch [16] from L0 to L519 using L522 
L0:     iload_1 
L1:     tableswitch 0 
            L418 
            L492 
            L492 
            L492 
            L492 
            L492 
            L492 
            L492 
            L492 
            L492 
            L492 
            L492 
            L492 
            L492 
            L492 
            L492 
            L298 
            L346 
            L236 
            L152 
            L112 
            L194 
            L376 
            L460 
            default : L492 

L112:   aload_2 
L113:   invokeinterface [43] 0 
L118:   astore 4 
L120:   aload_2 
L121:   invokestatic [9] 
L124:   astore 5 
L126:   aload_2 
L127:   invokeinterface [44] 0 
L132:   istore 6 
L134:   aload_0 
L135:   getfield [30] 
L138:   aload 4 
L140:   aload 5 
L142:   iload 6 
L144:   invokeinterface [45] 0 
L149:   goto L519 
L152:   aload_2 
L153:   invokeinterface [43] 0 
L158:   astore 4 
L160:   aload_2 
L161:   invokeinterface [44] 0 
L166:   istore 5 
L168:   aload_2 
L169:   invokeinterface [44] 0 
L174:   istore 6 
L176:   aload_0 
L177:   getfield [30] 
L180:   aload 4 
L182:   iload 5 
L184:   iload 6 
L186:   invokeinterface [46] 0 
L191:   goto L519 
L194:   aload_2 
L195:   invokeinterface [43] 0 
L200:   astore 4 
L202:   aload_2 
L203:   invokeinterface [44] 0 
L208:   istore 5 
L210:   aload_2 
L211:   invokeinterface [44] 0 
L216:   istore 6 
L218:   aload_0 
L219:   getfield [30] 
L222:   aload 4 
L224:   iload 5 
L226:   iload 6 
L228:   invokeinterface [47] 0 
L233:   goto L519 
L236:   aload_2 
L237:   invokeinterface [43] 0 
L242:   astore 4 
L244:   aload_2 
L245:   invokeinterface [43] 0 
L250:   astore 5 
L252:   aload_2 
L253:   invokeinterface [44] 0 
L258:   istore 6 
L260:   aload_2 
L261:   invokeinterface [44] 0 
L266:   istore 7 
L268:   aload_2 
L269:   invokeinterface [44] 0 
L274:   istore 8 
L276:   aload_0 
L277:   getfield [30] 
L280:   aload 4 
L282:   aload 5 
L284:   iload 6 
L286:   iload 7 
L288:   iload 8 
L290:   invokeinterface [48] 0 
L295:   goto L519 
L298:   aload_2 
L299:   invokeinterface [43] 0 
L304:   astore 4 
L306:   aload_2 
L307:   invokestatic [10] 
L310:   astore 5 
L312:   aload_2 
L313:   invokestatic [11] 
L316:   astore 6 
L318:   aload_2 
L319:   invokeinterface [44] 0 
L324:   istore 7 
L326:   aload_0 
L327:   getfield [30] 
L330:   aload 4 
L332:   aload 5 
L334:   aload 6 
L336:   iload 7 
L338:   invokeinterface [49] 0 
L343:   goto L519 
L346:   aload_2 
L347:   invokestatic [12] 
L350:   astore 4 
L352:   aload_2 
L353:   invokeinterface [44] 0 
L358:   istore 5 
L360:   aload_0 
L361:   getfield [30] 
L364:   aload 4 
L366:   iload 5 
L368:   invokeinterface [50] 0 
L373:   goto L519 
L376:   aload_2 
L377:   invokeinterface [43] 0 
L382:   astore 4 
L384:   aload_2 
L385:   invokeinterface [44] 0 
L390:   istore 5 
L392:   aload_2 
L393:   invokeinterface [44] 0 
L398:   istore 6 
L400:   aload_0 
L401:   getfield [30] 
L404:   aload 4 
L406:   iload 5 
L408:   iload 6 
L410:   invokeinterface [51] 0 
L415:   goto L519 
L418:   aload_2 
L419:   invokeinterface [44] 0 
L424:   istore 4 
L426:   aload_2 
L427:   invokeinterface [43] 0 
L432:   astore 5 
L434:   aload_2 
L435:   invokeinterface [44] 0 
L440:   istore 6 
L442:   aload_0 
L443:   getfield [30] 
L446:   iload 4 
L448:   aload 5 
L450:   iload 6 
L452:   invokeinterface [52] 0 
L457:   goto L519 
L460:   aload_2 
L461:   invokeinterface [43] 0 
L466:   astore 4 
L468:   aload_2 
L469:   invokeinterface [43] 0 
L474:   astore 5 
L476:   aload_0 
L477:   getfield [30] 
L480:   aload 4 
L482:   aload 5 
L484:   invokeinterface [53] 0 
L489:   goto L519 
L492:   new [54] 
L495:   dup 
L496:   new [55] 
L499:   dup 
L500:   invokespecial [39] 
L503:   ldc [15] 
L505:   invokevirtual [31] 
L508:   iload_1 
L509:   invokevirtual [32] 
L512:   invokevirtual [33] 
L515:   invokespecial [40] 
L518:   athrow 
L519:   goto L564 
L522:   astore 4 
L524:   new [54] 
L527:   dup 
L528:   new [55] 
L531:   dup 
L532:   invokespecial [39] 
L535:   ldc [17] 
L537:   invokevirtual [31] 
L540:   iload_1 
L541:   invokevirtual [32] 
L544:   ldc [18] 
L546:   invokevirtual [31] 
L549:   aload 4 
L551:   invokevirtual [34] 
L554:   invokevirtual [31] 
L557:   invokevirtual [33] 
L560:   invokespecial [40] 
L563:   athrow 
L564:   return 
L565:   nop 
L566:   nop 
L567:   nop 
L568:   
    .end code 
.end method 

.method static [253] : [254] 
    .attribute [244] .code stack 1 locals 0 
L0:     ldc [19] 
L2:     invokestatic [20] 
L5:     putstatic [38] 
L8:     iconst_0 
L9:     putstatic [37] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [56] 
.const [3] = String [57] 
.const [4] = Method [58] [59] 
.const [5] = String [60] 
.const [6] = String [61] 
.const [7] = Field [62] [63] 
.const [8] = Field [64] [65] 
.const [9] = Method [66] [67] 
.const [10] = Method [68] [69] 
.const [11] = Method [70] [71] 
.const [12] = Method [72] [73] 
.const [13] = Class [74] 
.const [14] = Class [75] 
.const [15] = String [76] 
.const [16] = Class [77] 
.const [17] = String [78] 
.const [18] = String [79] 
.const [19] = String [80] 
.const [20] = Method [81] [82] 
.const [21] = Class [83] 
.const [22] = Class [84] 
.const [23] = Class [85] 
.const [24] = Class [86] 
.const [25] = Class [87] 
.const [26] = Class [88] 
.const [27] = Class [89] 
.const [28] = Class [90] 
.const [29] = Class [91] 
.const [30] = Field [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Field [106] [107] 
.const [38] = Field [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Class [114] 
.const [42] = Field [115] [116] 
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
.const [53] = InterfaceMethod [137] [138] 
.const [54] = Class [139] 
.const [55] = Class [140] 
.const [56] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [57] = Utf8 b2460ea2-323f-538a-8290-4872acffc102 
.const [58] = Class [141] 
.const [59] = NameAndType [142] [143] 
.const [60] = Utf8 d60ab136-6c8a-5316-86b9-edfdbaa8b238 
.const [61] = Utf8 'dsi.upnp.DSIUPNPPlayer' 
.const [62] = Class [144] 
.const [63] = NameAndType [145] [146] 
.const [64] = Class [147] 
.const [65] = NameAndType [148] [149] 
.const [66] = Class [150] 
.const [67] = NameAndType [151] [152] 
.const [68] = Class [153] 
.const [69] = NameAndType [154] [155] 
.const [70] = Class [156] 
.const [71] = NameAndType [157] [158] 
.const [72] = Class [159] 
.const [73] = NameAndType [160] [161] 
.const [74] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [75] = Utf8 java/lang/StringBuffer 
.const [76] = Utf8 'Invalid Method Id ' 
.const [77] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [78] = Utf8 'Deserialization failed: method=' 
.const [79] = Utf8 ', error=' 
.const [80] = Utf8 'STUB.dsi.upnp.DSIUPNPPlayer' 
.const [81] = Class [162] 
.const [82] = NameAndType [163] [164] 
.const [83] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DSIUPNPPlayerReplyService 
.const [84] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [85] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [86] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/PlaybackModeSerializer 
.const [87] = Utf8 de/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply 
.const [88] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/EntryInfoSerializer 
.const [89] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [90] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DeviceInfoSerializer 
.const [91] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [92] = Class [165] 
.const [93] = NameAndType [166] [167] 
.const [94] = Class [168] 
.const [95] = NameAndType [169] [170] 
.const [96] = Class [171] 
.const [97] = NameAndType [172] [173] 
.const [98] = Class [174] 
.const [99] = NameAndType [175] [176] 
.const [100] = Class [177] 
.const [101] = NameAndType [178] [179] 
.const [102] = Class [180] 
.const [103] = NameAndType [181] [182] 
.const [104] = Class [183] 
.const [105] = NameAndType [184] [185] 
.const [106] = Class [186] 
.const [107] = NameAndType [187] [188] 
.const [108] = Class [189] 
.const [109] = NameAndType [190] [191] 
.const [110] = Class [192] 
.const [111] = NameAndType [193] [194] 
.const [112] = Class [195] 
.const [113] = NameAndType [196] [197] 
.const [114] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
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
.const [127] = Class [216] 
.const [128] = NameAndType [217] [218] 
.const [129] = Class [219] 
.const [130] = NameAndType [220] [221] 
.const [131] = Class [222] 
.const [132] = NameAndType [223] [224] 
.const [133] = Class [225] 
.const [134] = NameAndType [226] [227] 
.const [135] = Class [228] 
.const [136] = NameAndType [229] [230] 
.const [137] = Class [231] 
.const [138] = NameAndType [232] [233] 
.const [139] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [140] = Utf8 java/lang/StringBuffer 
.const [141] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DSIUPNPPlayerReplyService 
.const [142] = Utf8 nextDynamicHandle 
.const [143] = Utf8 ()I 
.const [144] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DSIUPNPPlayerReplyService 
.const [145] = Utf8 dynamicHandle 
.const [146] = Utf8 I 
.const [147] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DSIUPNPPlayerReplyService 
.const [148] = Utf8 context 
.const [149] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [150] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/PlaybackModeSerializer 
.const [151] = Utf8 getOptionalPlaybackModeVarArray 
.const [152] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/upnp/PlaybackMode; 
.const [153] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/EntryInfoSerializer 
.const [154] = Utf8 getOptionalEntryInfo 
.const [155] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/upnp/EntryInfo; 
.const [156] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [157] = Utf8 getOptionalResourceLocator 
.const [158] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/ResourceLocator; 
.const [159] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DeviceInfoSerializer 
.const [160] = Utf8 getOptionalDeviceInfoVarArray 
.const [161] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/upnp/DeviceInfo; 
.const [162] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [163] = Utf8 getContext 
.const [164] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [165] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DSIUPNPPlayerReplyService 
.const [166] = Utf8 p_DSIUPNPPlayerReply 
.const [167] = Utf8 Lde/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply; 
.const [168] = Utf8 java/lang/StringBuffer 
.const [169] = Utf8 append 
.const [170] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [171] = Utf8 java/lang/StringBuffer 
.const [172] = Utf8 append 
.const [173] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [174] = Utf8 java/lang/StringBuffer 
.const [175] = Utf8 toString 
.const [176] = Utf8 ()Ljava/lang/String; 
.const [177] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [178] = Utf8 getMessage 
.const [179] = Utf8 ()Ljava/lang/String; 
.const [180] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [183] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [186] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DSIUPNPPlayerReplyService 
.const [187] = Utf8 dynamicHandle 
.const [188] = Utf8 I 
.const [189] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DSIUPNPPlayerReplyService 
.const [190] = Utf8 context 
.const [191] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [192] = Utf8 java/lang/StringBuffer 
.const [193] = Utf8 <init> 
.const [194] = Utf8 ()V 
.const [195] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [196] = Utf8 <init> 
.const [197] = Utf8 (Ljava/lang/String;)V 
.const [198] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DSIUPNPPlayerReplyService 
.const [199] = Utf8 p_DSIUPNPPlayerReply 
.const [200] = Utf8 Lde/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply; 
.const [201] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [202] = Utf8 getOptionalString 
.const [203] = Utf8 ()Ljava/lang/String; 
.const [204] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [205] = Utf8 getInt32 
.const [206] = Utf8 ()I 
.const [207] = Utf8 de/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply 
.const [208] = Utf8 updatePlaybackModeList 
.const [209] = Utf8 (Ljava/lang/String;[Lorg/dsi/ifc/upnp/PlaybackMode;I)V 
.const [210] = Utf8 de/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply 
.const [211] = Utf8 updatePlaybackMode 
.const [212] = Utf8 (Ljava/lang/String;II)V 
.const [213] = Utf8 de/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply 
.const [214] = Utf8 updatePlaybackState 
.const [215] = Utf8 (Ljava/lang/String;II)V 
.const [216] = Utf8 de/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply 
.const [217] = Utf8 updatePlayPosition 
.const [218] = Utf8 (Ljava/lang/String;Ljava/lang/String;III)V 
.const [219] = Utf8 de/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply 
.const [220] = Utf8 updateDetailInfo 
.const [221] = Utf8 (Ljava/lang/String;Lorg/dsi/ifc/upnp/EntryInfo;Lorg/dsi/ifc/global/ResourceLocator;I)V 
.const [222] = Utf8 de/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply 
.const [223] = Utf8 updateDeviceList 
.const [224] = Utf8 ([Lorg/dsi/ifc/upnp/DeviceInfo;I)V 
.const [225] = Utf8 de/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply 
.const [226] = Utf8 updateVolume 
.const [227] = Utf8 (Ljava/lang/String;II)V 
.const [228] = Utf8 de/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply 
.const [229] = Utf8 asyncException 
.const [230] = Utf8 (ILjava/lang/String;I)V 
.const [231] = Utf8 de/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply 
.const [232] = Utf8 yyIndication 
.const [233] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [234] = Utf8 de/esolutions/fw/comm/dsi/upnp/impl/DSIUPNPPlayerReplyService 
.const [235] = Class [234] 
.const [236] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [237] = Class [236] 
.const [238] = Utf8 context 
.const [239] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [240] = Utf8 dynamicHandle 
.const [241] = Utf8 I 
.const [242] = Utf8 p_DSIUPNPPlayerReply 
.const [243] = Utf8 Lde/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply; 
.const [244] = Utf8 Code 
.const [245] = Utf8 <init> 
.const [246] = Utf8 (Lde/esolutions/fw/comm/dsi/upnp/DSIUPNPPlayerReply;)V 
.const [247] = Utf8 nextDynamicHandle 
.const [248] = Utf8 ()I 
.const [249] = Utf8 getCallContext 
.const [250] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [251] = Utf8 handleCallMethod 
.const [252] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [253] = Utf8 <clinit> 
.const [254] = Utf8 ()V 
.end class 
