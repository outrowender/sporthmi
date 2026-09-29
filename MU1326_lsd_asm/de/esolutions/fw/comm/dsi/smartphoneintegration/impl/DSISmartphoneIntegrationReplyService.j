.version 50 0 
.class public super [211] 
.super [213] 
.field private static final [214] [215] 
.field private static [216] [217] 
.field private [218] [219] 

.method public [221] : [222] 
    .attribute [220] .code stack 7 locals 0 
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

.method private static synchronized [223] : [224] 
    .attribute [220] .code stack 2 locals 1 
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

.method public [225] : [226] 
    .attribute [220] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [220] .code stack 5 locals 4 
        .catch [13] from L0 to L411 using L414 
L0:     iload_1 
L1:     tableswitch 0 
            L310 
            L384 
            L384 
            L384 
            L384 
            L384 
            L384 
            L384 
            L384 
            L130 
            L100 
            L352 
            L384 
            L384 
            L384 
            L384 
            L182 
            L214 
            L246 
            L384 
            L278 
            default : L384 

L100:   aload_2 
L101:   invokestatic [9] 
L104:   astore 4 
L106:   aload_2 
L107:   invokeinterface [37] 0 
L112:   istore 5 
L114:   aload_0 
L115:   getfield [24] 
L118:   aload 4 
L120:   iload 5 
L122:   invokeinterface [38] 0 
L127:   goto L411 
L130:   aload_2 
L131:   invokeinterface [37] 0 
L136:   istore 4 
L138:   aload_2 
L139:   invokeinterface [37] 0 
L144:   istore 5 
L146:   aload_2 
L147:   invokeinterface [37] 0 
L152:   istore 6 
L154:   aload_2 
L155:   invokeinterface [37] 0 
L160:   istore 7 
L162:   aload_0 
L163:   getfield [24] 
L166:   iload 4 
L168:   iload 5 
L170:   iload 6 
L172:   iload 7 
L174:   invokeinterface [39] 0 
L179:   goto L411 
L182:   aload_2 
L183:   invokeinterface [37] 0 
L188:   istore 4 
L190:   aload_2 
L191:   invokeinterface [40] 0 
L196:   istore 5 
L198:   aload_0 
L199:   getfield [24] 
L202:   iload 4 
L204:   iload 5 
L206:   invokeinterface [41] 0 
L211:   goto L411 
L214:   aload_2 
L215:   invokeinterface [37] 0 
L220:   istore 4 
L222:   aload_2 
L223:   invokeinterface [37] 0 
L228:   istore 5 
L230:   aload_0 
L231:   getfield [24] 
L234:   iload 4 
L236:   iload 5 
L238:   invokeinterface [42] 0 
L243:   goto L411 
L246:   aload_2 
L247:   invokeinterface [40] 0 
L252:   istore 4 
L254:   aload_2 
L255:   invokeinterface [37] 0 
L260:   istore 5 
L262:   aload_0 
L263:   getfield [24] 
L266:   iload 4 
L268:   iload 5 
L270:   invokeinterface [43] 0 
L275:   goto L411 
L278:   aload_2 
L279:   invokeinterface [40] 0 
L284:   istore 4 
L286:   aload_2 
L287:   invokeinterface [37] 0 
L292:   istore 5 
L294:   aload_0 
L295:   getfield [24] 
L298:   iload 4 
L300:   iload 5 
L302:   invokeinterface [44] 0 
L307:   goto L411 
L310:   aload_2 
L311:   invokeinterface [37] 0 
L316:   istore 4 
L318:   aload_2 
L319:   invokeinterface [45] 0 
L324:   astore 5 
L326:   aload_2 
L327:   invokeinterface [37] 0 
L332:   istore 6 
L334:   aload_0 
L335:   getfield [24] 
L338:   iload 4 
L340:   aload 5 
L342:   iload 6 
L344:   invokeinterface [46] 0 
L349:   goto L411 
L352:   aload_2 
L353:   invokeinterface [45] 0 
L358:   astore 4 
L360:   aload_2 
L361:   invokeinterface [45] 0 
L366:   astore 5 
L368:   aload_0 
L369:   getfield [24] 
L372:   aload 4 
L374:   aload 5 
L376:   invokeinterface [47] 0 
L381:   goto L411 
L384:   new [48] 
L387:   dup 
L388:   new [49] 
L391:   dup 
L392:   invokespecial [33] 
L395:   ldc [12] 
L397:   invokevirtual [25] 
L400:   iload_1 
L401:   invokevirtual [26] 
L404:   invokevirtual [27] 
L407:   invokespecial [34] 
L410:   athrow 
L411:   goto L456 
L414:   astore 4 
L416:   new [48] 
L419:   dup 
L420:   new [49] 
L423:   dup 
L424:   invokespecial [33] 
L427:   ldc [14] 
L429:   invokevirtual [25] 
L432:   iload_1 
L433:   invokevirtual [26] 
L436:   ldc [15] 
L438:   invokevirtual [25] 
L441:   aload 4 
L443:   invokevirtual [28] 
L446:   invokevirtual [25] 
L449:   invokevirtual [27] 
L452:   invokespecial [34] 
L455:   athrow 
L456:   return 
L457:   nop 
L458:   nop 
L459:   nop 
L460:   
    .end code 
.end method 

.method static [229] : [230] 
    .attribute [220] .code stack 1 locals 0 
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
.const [2] = Class [50] 
.const [3] = String [51] 
.const [4] = Method [52] [53] 
.const [5] = String [54] 
.const [6] = String [55] 
.const [7] = Field [56] [57] 
.const [8] = Field [58] [59] 
.const [9] = Method [60] [61] 
.const [10] = Class [62] 
.const [11] = Class [63] 
.const [12] = String [64] 
.const [13] = Class [65] 
.const [14] = String [66] 
.const [15] = String [67] 
.const [16] = String [68] 
.const [17] = Method [69] [70] 
.const [18] = Class [71] 
.const [19] = Class [72] 
.const [20] = Class [73] 
.const [21] = Class [74] 
.const [22] = Class [75] 
.const [23] = Class [76] 
.const [24] = Field [77] [78] 
.const [25] = Method [79] [80] 
.const [26] = Method [81] [82] 
.const [27] = Method [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Field [91] [92] 
.const [32] = Field [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Class [99] 
.const [36] = Field [100] [101] 
.const [37] = InterfaceMethod [102] [103] 
.const [38] = InterfaceMethod [104] [105] 
.const [39] = InterfaceMethod [106] [107] 
.const [40] = InterfaceMethod [108] [109] 
.const [41] = InterfaceMethod [110] [111] 
.const [42] = InterfaceMethod [112] [113] 
.const [43] = InterfaceMethod [114] [115] 
.const [44] = InterfaceMethod [116] [117] 
.const [45] = InterfaceMethod [118] [119] 
.const [46] = InterfaceMethod [120] [121] 
.const [47] = InterfaceMethod [122] [123] 
.const [48] = Class [124] 
.const [49] = Class [125] 
.const [50] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [51] = Utf8 b66bed86-0446-5574-bf7c-0a212b4857f5 
.const [52] = Class [126] 
.const [53] = NameAndType [127] [128] 
.const [54] = Utf8 c151f367-7bcf-50b9-9845-867e437d0e4f 
.const [55] = Utf8 'dsi.smartphoneintegration.DSISmartphoneIntegration' 
.const [56] = Class [129] 
.const [57] = NameAndType [130] [131] 
.const [58] = Class [132] 
.const [59] = NameAndType [133] [134] 
.const [60] = Class [135] 
.const [61] = NameAndType [136] [137] 
.const [62] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Utf8 'Invalid Method Id ' 
.const [65] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [66] = Utf8 'Deserialization failed: method=' 
.const [67] = Utf8 ', error=' 
.const [68] = Utf8 'STUB.dsi.smartphoneintegration.DSISmartphoneIntegration' 
.const [69] = Class [138] 
.const [70] = NameAndType [139] [140] 
.const [71] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DSISmartphoneIntegrationReplyService 
.const [72] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DeviceSerializer 
.const [74] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [75] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply 
.const [76] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [77] = Class [141] 
.const [78] = NameAndType [142] [143] 
.const [79] = Class [144] 
.const [80] = NameAndType [145] [146] 
.const [81] = Class [147] 
.const [82] = NameAndType [148] [149] 
.const [83] = Class [150] 
.const [84] = NameAndType [151] [152] 
.const [85] = Class [153] 
.const [86] = NameAndType [154] [155] 
.const [87] = Class [156] 
.const [88] = NameAndType [157] [158] 
.const [89] = Class [159] 
.const [90] = NameAndType [160] [161] 
.const [91] = Class [162] 
.const [92] = NameAndType [163] [164] 
.const [93] = Class [165] 
.const [94] = NameAndType [166] [167] 
.const [95] = Class [168] 
.const [96] = NameAndType [169] [170] 
.const [97] = Class [171] 
.const [98] = NameAndType [172] [173] 
.const [99] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [100] = Class [174] 
.const [101] = NameAndType [175] [176] 
.const [102] = Class [177] 
.const [103] = NameAndType [178] [179] 
.const [104] = Class [180] 
.const [105] = NameAndType [181] [182] 
.const [106] = Class [183] 
.const [107] = NameAndType [184] [185] 
.const [108] = Class [186] 
.const [109] = NameAndType [187] [188] 
.const [110] = Class [189] 
.const [111] = NameAndType [190] [191] 
.const [112] = Class [192] 
.const [113] = NameAndType [193] [194] 
.const [114] = Class [195] 
.const [115] = NameAndType [196] [197] 
.const [116] = Class [198] 
.const [117] = NameAndType [199] [200] 
.const [118] = Class [201] 
.const [119] = NameAndType [202] [203] 
.const [120] = Class [204] 
.const [121] = NameAndType [205] [206] 
.const [122] = Class [207] 
.const [123] = NameAndType [208] [209] 
.const [124] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [125] = Utf8 java/lang/StringBuffer 
.const [126] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DSISmartphoneIntegrationReplyService 
.const [127] = Utf8 nextDynamicHandle 
.const [128] = Utf8 ()I 
.const [129] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DSISmartphoneIntegrationReplyService 
.const [130] = Utf8 dynamicHandle 
.const [131] = Utf8 I 
.const [132] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DSISmartphoneIntegrationReplyService 
.const [133] = Utf8 context 
.const [134] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [135] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DeviceSerializer 
.const [136] = Utf8 getOptionalDeviceVarArray 
.const [137] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/smartphoneintegration/Device; 
.const [138] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [139] = Utf8 getContext 
.const [140] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [141] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DSISmartphoneIntegrationReplyService 
.const [142] = Utf8 p_DSISmartphoneIntegrationReply 
.const [143] = Utf8 Lde/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply; 
.const [144] = Utf8 java/lang/StringBuffer 
.const [145] = Utf8 append 
.const [146] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [147] = Utf8 java/lang/StringBuffer 
.const [148] = Utf8 append 
.const [149] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 toString 
.const [152] = Utf8 ()Ljava/lang/String; 
.const [153] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [154] = Utf8 getMessage 
.const [155] = Utf8 ()Ljava/lang/String; 
.const [156] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [159] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [162] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DSISmartphoneIntegrationReplyService 
.const [163] = Utf8 dynamicHandle 
.const [164] = Utf8 I 
.const [165] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DSISmartphoneIntegrationReplyService 
.const [166] = Utf8 context 
.const [167] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [168] = Utf8 java/lang/StringBuffer 
.const [169] = Utf8 <init> 
.const [170] = Utf8 ()V 
.const [171] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Ljava/lang/String;)V 
.const [174] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DSISmartphoneIntegrationReplyService 
.const [175] = Utf8 p_DSISmartphoneIntegrationReply 
.const [176] = Utf8 Lde/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply; 
.const [177] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [178] = Utf8 getInt32 
.const [179] = Utf8 ()I 
.const [180] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply 
.const [181] = Utf8 updateDiscoveredDevices 
.const [182] = Utf8 ([Lorg/dsi/ifc/smartphoneintegration/Device;I)V 
.const [183] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply 
.const [184] = Utf8 updateDeviceConnectionState 
.const [185] = Utf8 (IIII)V 
.const [186] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [187] = Utf8 getBool 
.const [188] = Utf8 ()Z 
.const [189] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply 
.const [190] = Utf8 responseFactorySettings 
.const [191] = Utf8 (IZ)V 
.const [192] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply 
.const [193] = Utf8 updateSWaPStatus 
.const [194] = Utf8 (II)V 
.const [195] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply 
.const [196] = Utf8 updateUSBResetActive 
.const [197] = Utf8 (ZI)V 
.const [198] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply 
.const [199] = Utf8 updateAppConnectContextRequested 
.const [200] = Utf8 (ZI)V 
.const [201] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [202] = Utf8 getOptionalString 
.const [203] = Utf8 ()Ljava/lang/String; 
.const [204] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply 
.const [205] = Utf8 asyncException 
.const [206] = Utf8 (ILjava/lang/String;I)V 
.const [207] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply 
.const [208] = Utf8 yyIndication 
.const [209] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [210] = Utf8 de/esolutions/fw/comm/dsi/smartphoneintegration/impl/DSISmartphoneIntegrationReplyService 
.const [211] = Class [210] 
.const [212] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [213] = Class [212] 
.const [214] = Utf8 context 
.const [215] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [216] = Utf8 dynamicHandle 
.const [217] = Utf8 I 
.const [218] = Utf8 p_DSISmartphoneIntegrationReply 
.const [219] = Utf8 Lde/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply; 
.const [220] = Utf8 Code 
.const [221] = Utf8 <init> 
.const [222] = Utf8 (Lde/esolutions/fw/comm/dsi/smartphoneintegration/DSISmartphoneIntegrationReply;)V 
.const [223] = Utf8 nextDynamicHandle 
.const [224] = Utf8 ()I 
.const [225] = Utf8 getCallContext 
.const [226] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [227] = Utf8 handleCallMethod 
.const [228] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [229] = Utf8 <clinit> 
.const [230] = Utf8 ()V 
.end class 
