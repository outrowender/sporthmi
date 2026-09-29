.version 50 0 
.class public super [235] 
.super [237] 
.field private static final [238] [239] 
.field private static [240] [241] 
.field private [242] [243] 

.method public [245] : [246] 
    .attribute [244] .code stack 7 locals 0 
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

.method private static synchronized [247] : [248] 
    .attribute [244] .code stack 2 locals 1 
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

.method public [249] : [250] 
    .attribute [244] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [244] .code stack 4 locals 3 
        .catch [13] from L0 to L507 using L510 
L0:     iload_1 
L1:     tableswitch 13 
            L406 
            L152 
            L310 
            L248 
            L342 
            L68 
            L110 
            L278 
            L374 
            L184 
            L448 
            L480 
            L216 
            default : L480 

L68:    aload_2 
L69:    invokeinterface [37] 0 
L74:    istore 4 
L76:    aload_2 
L77:    invokeinterface [37] 0 
L82:    istore 5 
L84:    aload_2 
L85:    invokeinterface [37] 0 
L90:    istore 6 
L92:    aload_0 
L93:    getfield [24] 
L96:    iload 4 
L98:    iload 5 
L100:   iload 6 
L102:   invokeinterface [38] 0 
L107:   goto L507 
L110:   aload_2 
L111:   invokeinterface [37] 0 
L116:   istore 4 
L118:   aload_2 
L119:   invokeinterface [37] 0 
L124:   istore 5 
L126:   aload_2 
L127:   invokeinterface [37] 0 
L132:   istore 6 
L134:   aload_0 
L135:   getfield [24] 
L138:   iload 4 
L140:   iload 5 
L142:   iload 6 
L144:   invokeinterface [39] 0 
L149:   goto L507 
L152:   aload_2 
L153:   invokeinterface [37] 0 
L158:   istore 4 
L160:   aload_2 
L161:   invokeinterface [37] 0 
L166:   istore 5 
L168:   aload_0 
L169:   getfield [24] 
L172:   iload 4 
L174:   iload 5 
L176:   invokeinterface [40] 0 
L181:   goto L507 
L184:   aload_2 
L185:   invokeinterface [41] 0 
L190:   istore 4 
L192:   aload_2 
L193:   invokeinterface [37] 0 
L198:   istore 5 
L200:   aload_0 
L201:   getfield [24] 
L204:   iload 4 
L206:   iload 5 
L208:   invokeinterface [42] 0 
L213:   goto L507 
L216:   aload_2 
L217:   invokeinterface [41] 0 
L222:   istore 4 
L224:   aload_2 
L225:   invokeinterface [37] 0 
L230:   istore 5 
L232:   aload_0 
L233:   getfield [24] 
L236:   iload 4 
L238:   iload 5 
L240:   invokeinterface [43] 0 
L245:   goto L507 
L248:   aload_2 
L249:   invokestatic [9] 
L252:   astore 4 
L254:   aload_2 
L255:   invokeinterface [37] 0 
L260:   istore 5 
L262:   aload_0 
L263:   getfield [24] 
L266:   aload 4 
L268:   iload 5 
L270:   invokeinterface [44] 0 
L275:   goto L507 
L278:   aload_2 
L279:   invokeinterface [41] 0 
L284:   istore 4 
L286:   aload_2 
L287:   invokeinterface [37] 0 
L292:   istore 5 
L294:   aload_0 
L295:   getfield [24] 
L298:   iload 4 
L300:   iload 5 
L302:   invokeinterface [45] 0 
L307:   goto L507 
L310:   aload_2 
L311:   invokeinterface [37] 0 
L316:   istore 4 
L318:   aload_2 
L319:   invokeinterface [37] 0 
L324:   istore 5 
L326:   aload_0 
L327:   getfield [24] 
L330:   iload 4 
L332:   iload 5 
L334:   invokeinterface [46] 0 
L339:   goto L507 
L342:   aload_2 
L343:   invokeinterface [37] 0 
L348:   istore 4 
L350:   aload_2 
L351:   invokeinterface [37] 0 
L356:   istore 5 
L358:   aload_0 
L359:   getfield [24] 
L362:   iload 4 
L364:   iload 5 
L366:   invokeinterface [47] 0 
L371:   goto L507 
L374:   aload_2 
L375:   invokeinterface [37] 0 
L380:   istore 4 
L382:   aload_2 
L383:   invokeinterface [37] 0 
L388:   istore 5 
L390:   aload_0 
L391:   getfield [24] 
L394:   iload 4 
L396:   iload 5 
L398:   invokeinterface [48] 0 
L403:   goto L507 
L406:   aload_2 
L407:   invokeinterface [37] 0 
L412:   istore 4 
L414:   aload_2 
L415:   invokeinterface [49] 0 
L420:   astore 5 
L422:   aload_2 
L423:   invokeinterface [37] 0 
L428:   istore 6 
L430:   aload_0 
L431:   getfield [24] 
L434:   iload 4 
L436:   aload 5 
L438:   iload 6 
L440:   invokeinterface [50] 0 
L445:   goto L507 
L448:   aload_2 
L449:   invokeinterface [49] 0 
L454:   astore 4 
L456:   aload_2 
L457:   invokeinterface [49] 0 
L462:   astore 5 
L464:   aload_0 
L465:   getfield [24] 
L468:   aload 4 
L470:   aload 5 
L472:   invokeinterface [51] 0 
L477:   goto L507 
L480:   new [52] 
L483:   dup 
L484:   new [53] 
L487:   dup 
L488:   invokespecial [33] 
L491:   ldc [12] 
L493:   invokevirtual [25] 
L496:   iload_1 
L497:   invokevirtual [26] 
L500:   invokevirtual [27] 
L503:   invokespecial [34] 
L506:   athrow 
L507:   goto L552 
L510:   astore 4 
L512:   new [52] 
L515:   dup 
L516:   new [53] 
L519:   dup 
L520:   invokespecial [33] 
L523:   ldc [14] 
L525:   invokevirtual [25] 
L528:   iload_1 
L529:   invokevirtual [26] 
L532:   ldc [15] 
L534:   invokevirtual [25] 
L537:   aload 4 
L539:   invokevirtual [28] 
L542:   invokevirtual [25] 
L545:   invokevirtual [27] 
L548:   invokespecial [34] 
L551:   athrow 
L552:   return 
L553:   nop 
L554:   nop 
L555:   nop 
L556:   
    .end code 
.end method 

.method static [253] : [254] 
    .attribute [244] .code stack 1 locals 0 
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
.const [2] = Class [54] 
.const [3] = String [55] 
.const [4] = Method [56] [57] 
.const [5] = String [58] 
.const [6] = String [59] 
.const [7] = Field [60] [61] 
.const [8] = Field [62] [63] 
.const [9] = Method [64] [65] 
.const [10] = Class [66] 
.const [11] = Class [67] 
.const [12] = String [68] 
.const [13] = Class [69] 
.const [14] = String [70] 
.const [15] = String [71] 
.const [16] = String [72] 
.const [17] = Method [73] [74] 
.const [18] = Class [75] 
.const [19] = Class [76] 
.const [20] = Class [77] 
.const [21] = Class [78] 
.const [22] = Class [79] 
.const [23] = Class [80] 
.const [24] = Field [81] [82] 
.const [25] = Method [83] [84] 
.const [26] = Method [85] [86] 
.const [27] = Method [87] [88] 
.const [28] = Method [89] [90] 
.const [29] = Method [91] [92] 
.const [30] = Method [93] [94] 
.const [31] = Field [95] [96] 
.const [32] = Field [97] [98] 
.const [33] = Method [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Class [103] 
.const [36] = Field [104] [105] 
.const [37] = InterfaceMethod [106] [107] 
.const [38] = InterfaceMethod [108] [109] 
.const [39] = InterfaceMethod [110] [111] 
.const [40] = InterfaceMethod [112] [113] 
.const [41] = InterfaceMethod [114] [115] 
.const [42] = InterfaceMethod [116] [117] 
.const [43] = InterfaceMethod [118] [119] 
.const [44] = InterfaceMethod [120] [121] 
.const [45] = InterfaceMethod [122] [123] 
.const [46] = InterfaceMethod [124] [125] 
.const [47] = InterfaceMethod [126] [127] 
.const [48] = InterfaceMethod [128] [129] 
.const [49] = InterfaceMethod [130] [131] 
.const [50] = InterfaceMethod [132] [133] 
.const [51] = InterfaceMethod [134] [135] 
.const [52] = Class [136] 
.const [53] = Class [137] 
.const [54] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [55] = Utf8 '6f03b6fa-61a3-550e-b68d-542d13666d43' 
.const [56] = Class [138] 
.const [57] = NameAndType [139] [140] 
.const [58] = Utf8 '8fff252e-ea27-52bc-8f1f-2bc868ac2c70' 
.const [59] = Utf8 'dsi.powermanagement.DSIPowerManagement' 
.const [60] = Class [141] 
.const [61] = NameAndType [142] [143] 
.const [62] = Class [144] 
.const [63] = NameAndType [145] [146] 
.const [64] = Class [147] 
.const [65] = NameAndType [148] [149] 
.const [66] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [67] = Utf8 java/lang/StringBuffer 
.const [68] = Utf8 'Invalid Method Id ' 
.const [69] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [70] = Utf8 'Deserialization failed: method=' 
.const [71] = Utf8 ', error=' 
.const [72] = Utf8 'STUB.dsi.powermanagement.DSIPowerManagement' 
.const [73] = Class [150] 
.const [74] = NameAndType [151] [152] 
.const [75] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/DSIPowerManagementReplyService 
.const [76] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [77] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [78] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [79] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/ClampSignalSerializer 
.const [80] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [81] = Class [153] 
.const [82] = NameAndType [154] [155] 
.const [83] = Class [156] 
.const [84] = NameAndType [157] [158] 
.const [85] = Class [159] 
.const [86] = NameAndType [160] [161] 
.const [87] = Class [162] 
.const [88] = NameAndType [163] [164] 
.const [89] = Class [165] 
.const [90] = NameAndType [166] [167] 
.const [91] = Class [168] 
.const [92] = NameAndType [169] [170] 
.const [93] = Class [171] 
.const [94] = NameAndType [172] [173] 
.const [95] = Class [174] 
.const [96] = NameAndType [175] [176] 
.const [97] = Class [177] 
.const [98] = NameAndType [178] [179] 
.const [99] = Class [180] 
.const [100] = NameAndType [181] [182] 
.const [101] = Class [183] 
.const [102] = NameAndType [184] [185] 
.const [103] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [104] = Class [186] 
.const [105] = NameAndType [187] [188] 
.const [106] = Class [189] 
.const [107] = NameAndType [190] [191] 
.const [108] = Class [192] 
.const [109] = NameAndType [193] [194] 
.const [110] = Class [195] 
.const [111] = NameAndType [196] [197] 
.const [112] = Class [198] 
.const [113] = NameAndType [199] [200] 
.const [114] = Class [201] 
.const [115] = NameAndType [202] [203] 
.const [116] = Class [204] 
.const [117] = NameAndType [205] [206] 
.const [118] = Class [207] 
.const [119] = NameAndType [208] [209] 
.const [120] = Class [210] 
.const [121] = NameAndType [211] [212] 
.const [122] = Class [213] 
.const [123] = NameAndType [214] [215] 
.const [124] = Class [216] 
.const [125] = NameAndType [217] [218] 
.const [126] = Class [219] 
.const [127] = NameAndType [220] [221] 
.const [128] = Class [222] 
.const [129] = NameAndType [223] [224] 
.const [130] = Class [225] 
.const [131] = NameAndType [226] [227] 
.const [132] = Class [228] 
.const [133] = NameAndType [229] [230] 
.const [134] = Class [231] 
.const [135] = NameAndType [232] [233] 
.const [136] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/DSIPowerManagementReplyService 
.const [139] = Utf8 nextDynamicHandle 
.const [140] = Utf8 ()I 
.const [141] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/DSIPowerManagementReplyService 
.const [142] = Utf8 dynamicHandle 
.const [143] = Utf8 I 
.const [144] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/DSIPowerManagementReplyService 
.const [145] = Utf8 context 
.const [146] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [147] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/ClampSignalSerializer 
.const [148] = Utf8 getOptionalClampSignal 
.const [149] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/powermanagement/ClampSignal; 
.const [150] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [151] = Utf8 getContext 
.const [152] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [153] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/DSIPowerManagementReplyService 
.const [154] = Utf8 p_DSIPowerManagementReply 
.const [155] = Utf8 Lde/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply; 
.const [156] = Utf8 java/lang/StringBuffer 
.const [157] = Utf8 append 
.const [158] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [159] = Utf8 java/lang/StringBuffer 
.const [160] = Utf8 append 
.const [161] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [162] = Utf8 java/lang/StringBuffer 
.const [163] = Utf8 toString 
.const [164] = Utf8 ()Ljava/lang/String; 
.const [165] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [166] = Utf8 getMessage 
.const [167] = Utf8 ()Ljava/lang/String; 
.const [168] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [171] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [174] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/DSIPowerManagementReplyService 
.const [175] = Utf8 dynamicHandle 
.const [176] = Utf8 I 
.const [177] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/DSIPowerManagementReplyService 
.const [178] = Utf8 context 
.const [179] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [180] = Utf8 java/lang/StringBuffer 
.const [181] = Utf8 <init> 
.const [182] = Utf8 ()V 
.const [183] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Ljava/lang/String;)V 
.const [186] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/DSIPowerManagementReplyService 
.const [187] = Utf8 p_DSIPowerManagementReply 
.const [188] = Utf8 Lde/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply; 
.const [189] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [190] = Utf8 getInt32 
.const [191] = Utf8 ()I 
.const [192] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [193] = Utf8 updatePowerManagementState 
.const [194] = Utf8 (III)V 
.const [195] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [196] = Utf8 updatePowerManagementStateRight 
.const [197] = Utf8 (III)V 
.const [198] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [199] = Utf8 updateBEMState 
.const [200] = Utf8 (II)V 
.const [201] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [202] = Utf8 getBool 
.const [203] = Utf8 ()Z 
.const [204] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [205] = Utf8 updateTelMaxPopup 
.const [206] = Utf8 (ZI)V 
.const [207] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [208] = Utf8 updateTStandbyPopup 
.const [209] = Utf8 (ZI)V 
.const [210] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [211] = Utf8 updateClampSignal 
.const [212] = Utf8 (Lorg/dsi/ifc/powermanagement/ClampSignal;I)V 
.const [213] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [214] = Utf8 updateRVCActive 
.const [215] = Utf8 (ZI)V 
.const [216] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [217] = Utf8 updateChildLockState 
.const [218] = Utf8 (II)V 
.const [219] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [220] = Utf8 updateLastOn 
.const [221] = Utf8 (II)V 
.const [222] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [223] = Utf8 updateSplashScreenAnimation 
.const [224] = Utf8 (II)V 
.const [225] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [226] = Utf8 getOptionalString 
.const [227] = Utf8 ()Ljava/lang/String; 
.const [228] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [229] = Utf8 asyncException 
.const [230] = Utf8 (ILjava/lang/String;I)V 
.const [231] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply 
.const [232] = Utf8 yyIndication 
.const [233] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [234] = Utf8 de/esolutions/fw/comm/dsi/powermanagement/impl/DSIPowerManagementReplyService 
.const [235] = Class [234] 
.const [236] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [237] = Class [236] 
.const [238] = Utf8 context 
.const [239] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [240] = Utf8 dynamicHandle 
.const [241] = Utf8 I 
.const [242] = Utf8 p_DSIPowerManagementReply 
.const [243] = Utf8 Lde/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply; 
.const [244] = Utf8 Code 
.const [245] = Utf8 <init> 
.const [246] = Utf8 (Lde/esolutions/fw/comm/dsi/powermanagement/DSIPowerManagementReply;)V 
.const [247] = Utf8 nextDynamicHandle 
.const [248] = Utf8 ()I 
.const [249] = Utf8 getCallContext 
.const [250] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [251] = Utf8 handleCallMethod 
.const [252] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [253] = Utf8 <clinit> 
.const [254] = Utf8 ()V 
.end class 
