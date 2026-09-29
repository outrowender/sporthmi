.version 50 0 
.class public super [215] 
.super [217] 
.field private static final [218] [219] 
.field private static [220] [221] 
.field private [222] [223] 

.method public [225] : [226] 
    .attribute [224] .code stack 7 locals 0 
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

.method private static synchronized [227] : [228] 
    .attribute [224] .code stack 2 locals 1 
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

.method public [229] : [230] 
    .attribute [224] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [224] .code stack 4 locals 3 
        .catch [15] from L0 to L357 using L360 
L0:     iload_1 
L1:     tableswitch 0 
            L256 
            L330 
            L330 
            L330 
            L330 
            L194 
            L330 
            L330 
            L330 
            L330 
            L104 
            L330 
            L330 
            L298 
            L330 
            L330 
            L224 
            L330 
            L330 
            L330 
            L134 
            L164 
            default : L330 

L104:   aload_2 
L105:   invokestatic [9] 
L108:   astore 4 
L110:   aload_2 
L111:   invokeinterface [41] 0 
L116:   istore 5 
L118:   aload_0 
L119:   getfield [28] 
L122:   aload 4 
L124:   iload 5 
L126:   invokeinterface [42] 0 
L131:   goto L357 
L134:   aload_2 
L135:   invokestatic [10] 
L138:   astore 4 
L140:   aload_2 
L141:   invokeinterface [41] 0 
L146:   istore 5 
L148:   aload_0 
L149:   getfield [28] 
L152:   aload 4 
L154:   iload 5 
L156:   invokeinterface [43] 0 
L161:   goto L357 
L164:   aload_2 
L165:   invokestatic [11] 
L168:   astore 4 
L170:   aload_2 
L171:   invokeinterface [41] 0 
L176:   istore 5 
L178:   aload_0 
L179:   getfield [28] 
L182:   aload 4 
L184:   iload 5 
L186:   invokeinterface [44] 0 
L191:   goto L357 
L194:   aload_2 
L195:   invokestatic [9] 
L198:   astore 4 
L200:   aload_2 
L201:   invokeinterface [41] 0 
L206:   istore 5 
L208:   aload_0 
L209:   getfield [28] 
L212:   aload 4 
L214:   iload 5 
L216:   invokeinterface [45] 0 
L221:   goto L357 
L224:   aload_2 
L225:   invokeinterface [41] 0 
L230:   istore 4 
L232:   aload_2 
L233:   invokeinterface [41] 0 
L238:   istore 5 
L240:   aload_0 
L241:   getfield [28] 
L244:   iload 4 
L246:   iload 5 
L248:   invokeinterface [46] 0 
L253:   goto L357 
L256:   aload_2 
L257:   invokeinterface [41] 0 
L262:   istore 4 
L264:   aload_2 
L265:   invokeinterface [47] 0 
L270:   astore 5 
L272:   aload_2 
L273:   invokeinterface [41] 0 
L278:   istore 6 
L280:   aload_0 
L281:   getfield [28] 
L284:   iload 4 
L286:   aload 5 
L288:   iload 6 
L290:   invokeinterface [48] 0 
L295:   goto L357 
L298:   aload_2 
L299:   invokeinterface [47] 0 
L304:   astore 4 
L306:   aload_2 
L307:   invokeinterface [47] 0 
L312:   astore 5 
L314:   aload_0 
L315:   getfield [28] 
L318:   aload 4 
L320:   aload 5 
L322:   invokeinterface [49] 0 
L327:   goto L357 
L330:   new [50] 
L333:   dup 
L334:   new [51] 
L337:   dup 
L338:   invokespecial [37] 
L341:   ldc [14] 
L343:   invokevirtual [29] 
L346:   iload_1 
L347:   invokevirtual [30] 
L350:   invokevirtual [31] 
L353:   invokespecial [38] 
L356:   athrow 
L357:   goto L402 
L360:   astore 4 
L362:   new [50] 
L365:   dup 
L366:   new [51] 
L369:   dup 
L370:   invokespecial [37] 
L373:   ldc [16] 
L375:   invokevirtual [29] 
L378:   iload_1 
L379:   invokevirtual [30] 
L382:   ldc [17] 
L384:   invokevirtual [29] 
L387:   aload 4 
L389:   invokevirtual [32] 
L392:   invokevirtual [29] 
L395:   invokevirtual [31] 
L398:   invokespecial [38] 
L401:   athrow 
L402:   return 
L403:   nop 
L404:   
    .end code 
.end method 

.method static [233] : [234] 
    .attribute [224] .code stack 1 locals 0 
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
.const [2] = Class [52] 
.const [3] = String [53] 
.const [4] = Method [54] [55] 
.const [5] = String [56] 
.const [6] = String [57] 
.const [7] = Field [58] [59] 
.const [8] = Field [60] [61] 
.const [9] = Method [62] [63] 
.const [10] = Method [64] [65] 
.const [11] = Method [66] [67] 
.const [12] = Class [68] 
.const [13] = Class [69] 
.const [14] = String [70] 
.const [15] = Class [71] 
.const [16] = String [72] 
.const [17] = String [73] 
.const [18] = String [74] 
.const [19] = Method [75] [76] 
.const [20] = Class [77] 
.const [21] = Class [78] 
.const [22] = Class [79] 
.const [23] = Class [80] 
.const [24] = Class [81] 
.const [25] = Class [82] 
.const [26] = Class [83] 
.const [27] = Class [84] 
.const [28] = Field [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Field [99] [100] 
.const [36] = Field [101] [102] 
.const [37] = Method [103] [104] 
.const [38] = Method [105] [106] 
.const [39] = Class [107] 
.const [40] = Field [108] [109] 
.const [41] = InterfaceMethod [110] [111] 
.const [42] = InterfaceMethod [112] [113] 
.const [43] = InterfaceMethod [114] [115] 
.const [44] = InterfaceMethod [116] [117] 
.const [45] = InterfaceMethod [118] [119] 
.const [46] = InterfaceMethod [120] [121] 
.const [47] = InterfaceMethod [122] [123] 
.const [48] = InterfaceMethod [124] [125] 
.const [49] = InterfaceMethod [126] [127] 
.const [50] = Class [128] 
.const [51] = Class [129] 
.const [52] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [53] = Utf8 '6901e511-3231-50d4-b201-4f6cac639de8' 
.const [54] = Class [130] 
.const [55] = NameAndType [131] [132] 
.const [56] = Utf8 f1dc0de3-ddd5-522b-83a1-8a345754745f 
.const [57] = Utf8 'dsi.trafficregulation.DSITrafficRegulation' 
.const [58] = Class [133] 
.const [59] = NameAndType [134] [135] 
.const [60] = Class [136] 
.const [61] = NameAndType [137] [138] 
.const [62] = Class [139] 
.const [63] = NameAndType [140] [141] 
.const [64] = Class [142] 
.const [65] = NameAndType [143] [144] 
.const [66] = Class [145] 
.const [67] = NameAndType [146] [147] 
.const [68] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 'Invalid Method Id ' 
.const [71] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [72] = Utf8 'Deserialization failed: method=' 
.const [73] = Utf8 ', error=' 
.const [74] = Utf8 'STUB.dsi.trafficregulation.DSITrafficRegulation' 
.const [75] = Class [148] 
.const [76] = NameAndType [149] [150] 
.const [77] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/DSITrafficRegulationReplyService 
.const [78] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [79] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/RoadClassSpeedInfoSerializer 
.const [80] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [81] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply 
.const [82] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/TrafficSignInformationSerializer 
.const [83] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/TrafficSignInformationOnRouteSerializer 
.const [84] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [85] = Class [151] 
.const [86] = NameAndType [152] [153] 
.const [87] = Class [154] 
.const [88] = NameAndType [155] [156] 
.const [89] = Class [157] 
.const [90] = NameAndType [158] [159] 
.const [91] = Class [160] 
.const [92] = NameAndType [161] [162] 
.const [93] = Class [163] 
.const [94] = NameAndType [164] [165] 
.const [95] = Class [166] 
.const [96] = NameAndType [167] [168] 
.const [97] = Class [169] 
.const [98] = NameAndType [170] [171] 
.const [99] = Class [172] 
.const [100] = NameAndType [173] [174] 
.const [101] = Class [175] 
.const [102] = NameAndType [176] [177] 
.const [103] = Class [178] 
.const [104] = NameAndType [179] [180] 
.const [105] = Class [181] 
.const [106] = NameAndType [182] [183] 
.const [107] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [108] = Class [184] 
.const [109] = NameAndType [185] [186] 
.const [110] = Class [187] 
.const [111] = NameAndType [188] [189] 
.const [112] = Class [190] 
.const [113] = NameAndType [191] [192] 
.const [114] = Class [193] 
.const [115] = NameAndType [194] [195] 
.const [116] = Class [196] 
.const [117] = NameAndType [197] [198] 
.const [118] = Class [199] 
.const [119] = NameAndType [200] [201] 
.const [120] = Class [202] 
.const [121] = NameAndType [203] [204] 
.const [122] = Class [205] 
.const [123] = NameAndType [206] [207] 
.const [124] = Class [208] 
.const [125] = NameAndType [209] [210] 
.const [126] = Class [211] 
.const [127] = NameAndType [212] [213] 
.const [128] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/DSITrafficRegulationReplyService 
.const [131] = Utf8 nextDynamicHandle 
.const [132] = Utf8 ()I 
.const [133] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/DSITrafficRegulationReplyService 
.const [134] = Utf8 dynamicHandle 
.const [135] = Utf8 I 
.const [136] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/DSITrafficRegulationReplyService 
.const [137] = Utf8 context 
.const [138] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [139] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/RoadClassSpeedInfoSerializer 
.const [140] = Utf8 getOptionalRoadClassSpeedInfoVarArray 
.const [141] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/trafficregulation/RoadClassSpeedInfo; 
.const [142] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/TrafficSignInformationSerializer 
.const [143] = Utf8 getOptionalTrafficSignInformation 
.const [144] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/trafficregulation/TrafficSignInformation; 
.const [145] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/TrafficSignInformationOnRouteSerializer 
.const [146] = Utf8 getOptionalTrafficSignInformationOnRouteVarArray 
.const [147] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/trafficregulation/TrafficSignInformationOnRoute; 
.const [148] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [149] = Utf8 getContext 
.const [150] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [151] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/DSITrafficRegulationReplyService 
.const [152] = Utf8 p_DSITrafficRegulationReply 
.const [153] = Utf8 Lde/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply; 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 append 
.const [156] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [157] = Utf8 java/lang/StringBuffer 
.const [158] = Utf8 append 
.const [159] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [160] = Utf8 java/lang/StringBuffer 
.const [161] = Utf8 toString 
.const [162] = Utf8 ()Ljava/lang/String; 
.const [163] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [164] = Utf8 getMessage 
.const [165] = Utf8 ()Ljava/lang/String; 
.const [166] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [169] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [170] = Utf8 <init> 
.const [171] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/DSITrafficRegulationReplyService 
.const [173] = Utf8 dynamicHandle 
.const [174] = Utf8 I 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/DSITrafficRegulationReplyService 
.const [176] = Utf8 context 
.const [177] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [178] = Utf8 java/lang/StringBuffer 
.const [179] = Utf8 <init> 
.const [180] = Utf8 ()V 
.const [181] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [182] = Utf8 <init> 
.const [183] = Utf8 (Ljava/lang/String;)V 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/DSITrafficRegulationReplyService 
.const [185] = Utf8 p_DSITrafficRegulationReply 
.const [186] = Utf8 Lde/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply; 
.const [187] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [188] = Utf8 getInt32 
.const [189] = Utf8 ()I 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply 
.const [191] = Utf8 updateCountrySpeedInformation 
.const [192] = Utf8 ([Lorg/dsi/ifc/trafficregulation/RoadClassSpeedInfo;I)V 
.const [193] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply 
.const [194] = Utf8 updateCurrentTrafficSign 
.const [195] = Utf8 (Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;I)V 
.const [196] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply 
.const [197] = Utf8 updateTrafficSignOnRoute 
.const [198] = Utf8 ([Lorg/dsi/ifc/trafficregulation/TrafficSignInformationOnRoute;I)V 
.const [199] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply 
.const [200] = Utf8 requestRoadClassSpeedInfoForCountryResult 
.const [201] = Utf8 ([Lorg/dsi/ifc/trafficregulation/RoadClassSpeedInfo;I)V 
.const [202] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply 
.const [203] = Utf8 updateTrailerStatus 
.const [204] = Utf8 (II)V 
.const [205] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [206] = Utf8 getOptionalString 
.const [207] = Utf8 ()Ljava/lang/String; 
.const [208] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply 
.const [209] = Utf8 asyncException 
.const [210] = Utf8 (ILjava/lang/String;I)V 
.const [211] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply 
.const [212] = Utf8 yyIndication 
.const [213] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [214] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/DSITrafficRegulationReplyService 
.const [215] = Class [214] 
.const [216] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [217] = Class [216] 
.const [218] = Utf8 context 
.const [219] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [220] = Utf8 dynamicHandle 
.const [221] = Utf8 I 
.const [222] = Utf8 p_DSITrafficRegulationReply 
.const [223] = Utf8 Lde/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply; 
.const [224] = Utf8 Code 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Lde/esolutions/fw/comm/dsi/trafficregulation/DSITrafficRegulationReply;)V 
.const [227] = Utf8 nextDynamicHandle 
.const [228] = Utf8 ()I 
.const [229] = Utf8 getCallContext 
.const [230] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [231] = Utf8 handleCallMethod 
.const [232] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [233] = Utf8 <clinit> 
.const [234] = Utf8 ()V 
.end class 
