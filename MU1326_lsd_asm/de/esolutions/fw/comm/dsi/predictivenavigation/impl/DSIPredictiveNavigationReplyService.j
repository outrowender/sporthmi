.version 50 0 
.class public super [193] 
.super [195] 
.field private static final [196] [197] 
.field private static [198] [199] 
.field private [200] [201] 

.method public [203] : [204] 
    .attribute [202] .code stack 7 locals 0 
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

.method private static synchronized [205] : [206] 
    .attribute [202] .code stack 2 locals 1 
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

.method public [207] : [208] 
    .attribute [202] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [202] .code stack 4 locals 3 
        .catch [13] from L0 to L283 using L286 
L0:     iload_1 
L1:     tableswitch 0 
            L182 
            L256 
            L170 
            L256 
            L256 
            L256 
            L256 
            L256 
            L256 
            L256 
            L256 
            L108 
            L138 
            L76 
            L224 
            default : L256 

L76:    aload_2 
L77:    invokeinterface [37] 0 
L82:    istore 4 
L84:    aload_2 
L85:    invokeinterface [37] 0 
L90:    istore 5 
L92:    aload_0 
L93:    getfield [24] 
L96:    iload 4 
L98:    iload 5 
L100:   invokeinterface [38] 0 
L105:   goto L283 
L108:   aload_2 
L109:   invokestatic [9] 
L112:   astore 4 
L114:   aload_2 
L115:   invokeinterface [37] 0 
L120:   istore 5 
L122:   aload_0 
L123:   getfield [24] 
L126:   aload 4 
L128:   iload 5 
L130:   invokeinterface [39] 0 
L135:   goto L283 
L138:   aload_2 
L139:   invokeinterface [37] 0 
L144:   istore 4 
L146:   aload_2 
L147:   invokeinterface [37] 0 
L152:   istore 5 
L154:   aload_0 
L155:   getfield [24] 
L158:   iload 4 
L160:   iload 5 
L162:   invokeinterface [40] 0 
L167:   goto L283 
L170:   aload_0 
L171:   getfield [24] 
L174:   invokeinterface [41] 0 
L179:   goto L283 
L182:   aload_2 
L183:   invokeinterface [37] 0 
L188:   istore 4 
L190:   aload_2 
L191:   invokeinterface [42] 0 
L196:   astore 5 
L198:   aload_2 
L199:   invokeinterface [37] 0 
L204:   istore 6 
L206:   aload_0 
L207:   getfield [24] 
L210:   iload 4 
L212:   aload 5 
L214:   iload 6 
L216:   invokeinterface [43] 0 
L221:   goto L283 
L224:   aload_2 
L225:   invokeinterface [42] 0 
L230:   astore 4 
L232:   aload_2 
L233:   invokeinterface [42] 0 
L238:   astore 5 
L240:   aload_0 
L241:   getfield [24] 
L244:   aload 4 
L246:   aload 5 
L248:   invokeinterface [44] 0 
L253:   goto L283 
L256:   new [45] 
L259:   dup 
L260:   new [46] 
L263:   dup 
L264:   invokespecial [33] 
L267:   ldc [12] 
L269:   invokevirtual [25] 
L272:   iload_1 
L273:   invokevirtual [26] 
L276:   invokevirtual [27] 
L279:   invokespecial [34] 
L282:   athrow 
L283:   goto L328 
L286:   astore 4 
L288:   new [45] 
L291:   dup 
L292:   new [46] 
L295:   dup 
L296:   invokespecial [33] 
L299:   ldc [14] 
L301:   invokevirtual [25] 
L304:   iload_1 
L305:   invokevirtual [26] 
L308:   ldc [15] 
L310:   invokevirtual [25] 
L313:   aload 4 
L315:   invokevirtual [28] 
L318:   invokevirtual [25] 
L321:   invokevirtual [27] 
L324:   invokespecial [34] 
L327:   athrow 
L328:   return 
L329:   nop 
L330:   nop 
L331:   nop 
L332:   
    .end code 
.end method 

.method static [211] : [212] 
    .attribute [202] .code stack 1 locals 0 
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
.const [2] = Class [47] 
.const [3] = String [48] 
.const [4] = Method [49] [50] 
.const [5] = String [51] 
.const [6] = String [52] 
.const [7] = Field [53] [54] 
.const [8] = Field [55] [56] 
.const [9] = Method [57] [58] 
.const [10] = Class [59] 
.const [11] = Class [60] 
.const [12] = String [61] 
.const [13] = Class [62] 
.const [14] = String [63] 
.const [15] = String [64] 
.const [16] = String [65] 
.const [17] = Method [66] [67] 
.const [18] = Class [68] 
.const [19] = Class [69] 
.const [20] = Class [70] 
.const [21] = Class [71] 
.const [22] = Class [72] 
.const [23] = Class [73] 
.const [24] = Field [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Field [88] [89] 
.const [32] = Field [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Class [96] 
.const [36] = Field [97] [98] 
.const [37] = InterfaceMethod [99] [100] 
.const [38] = InterfaceMethod [101] [102] 
.const [39] = InterfaceMethod [103] [104] 
.const [40] = InterfaceMethod [105] [106] 
.const [41] = InterfaceMethod [107] [108] 
.const [42] = InterfaceMethod [109] [110] 
.const [43] = InterfaceMethod [111] [112] 
.const [44] = InterfaceMethod [113] [114] 
.const [45] = Class [115] 
.const [46] = Class [116] 
.const [47] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [48] = Utf8 '858fb3eb-f9f4-5578-a0e6-68c88d2c9881' 
.const [49] = Class [117] 
.const [50] = NameAndType [118] [119] 
.const [51] = Utf8 '430e0b9d-dec1-5286-bf8c-d0b07c687172' 
.const [52] = Utf8 'dsi.predictivenavigation.DSIPredictiveNavigation' 
.const [53] = Class [120] 
.const [54] = NameAndType [121] [122] 
.const [55] = Class [123] 
.const [56] = NameAndType [124] [125] 
.const [57] = Class [126] 
.const [58] = NameAndType [127] [128] 
.const [59] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [60] = Utf8 java/lang/StringBuffer 
.const [61] = Utf8 'Invalid Method Id ' 
.const [62] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [63] = Utf8 'Deserialization failed: method=' 
.const [64] = Utf8 ', error=' 
.const [65] = Utf8 'STUB.dsi.predictivenavigation.DSIPredictiveNavigation' 
.const [66] = Class [129] 
.const [67] = NameAndType [130] [131] 
.const [68] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/DSIPredictiveNavigationReplyService 
.const [69] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [70] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [71] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply 
.const [72] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/LikelyDestinationSerializer 
.const [73] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Class [150] 
.const [87] = NameAndType [151] [152] 
.const [88] = Class [153] 
.const [89] = NameAndType [154] [155] 
.const [90] = Class [156] 
.const [91] = NameAndType [157] [158] 
.const [92] = Class [159] 
.const [93] = NameAndType [160] [161] 
.const [94] = Class [162] 
.const [95] = NameAndType [163] [164] 
.const [96] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [97] = Class [165] 
.const [98] = NameAndType [166] [167] 
.const [99] = Class [168] 
.const [100] = NameAndType [169] [170] 
.const [101] = Class [171] 
.const [102] = NameAndType [172] [173] 
.const [103] = Class [174] 
.const [104] = NameAndType [175] [176] 
.const [105] = Class [177] 
.const [106] = NameAndType [178] [179] 
.const [107] = Class [180] 
.const [108] = NameAndType [181] [182] 
.const [109] = Class [183] 
.const [110] = NameAndType [184] [185] 
.const [111] = Class [186] 
.const [112] = NameAndType [187] [188] 
.const [113] = Class [189] 
.const [114] = NameAndType [190] [191] 
.const [115] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/DSIPredictiveNavigationReplyService 
.const [118] = Utf8 nextDynamicHandle 
.const [119] = Utf8 ()I 
.const [120] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/DSIPredictiveNavigationReplyService 
.const [121] = Utf8 dynamicHandle 
.const [122] = Utf8 I 
.const [123] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/DSIPredictiveNavigationReplyService 
.const [124] = Utf8 context 
.const [125] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [126] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/LikelyDestinationSerializer 
.const [127] = Utf8 getOptionalLikelyDestinationVarArray 
.const [128] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/predictivenavigation/LikelyDestination; 
.const [129] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [130] = Utf8 getContext 
.const [131] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [132] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/DSIPredictiveNavigationReplyService 
.const [133] = Utf8 p_DSIPredictiveNavigationReply 
.const [134] = Utf8 Lde/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply; 
.const [135] = Utf8 java/lang/StringBuffer 
.const [136] = Utf8 append 
.const [137] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [138] = Utf8 java/lang/StringBuffer 
.const [139] = Utf8 append 
.const [140] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [141] = Utf8 java/lang/StringBuffer 
.const [142] = Utf8 toString 
.const [143] = Utf8 ()Ljava/lang/String; 
.const [144] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [145] = Utf8 getMessage 
.const [146] = Utf8 ()Ljava/lang/String; 
.const [147] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [150] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [153] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/DSIPredictiveNavigationReplyService 
.const [154] = Utf8 dynamicHandle 
.const [155] = Utf8 I 
.const [156] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/DSIPredictiveNavigationReplyService 
.const [157] = Utf8 context 
.const [158] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [159] = Utf8 java/lang/StringBuffer 
.const [160] = Utf8 <init> 
.const [161] = Utf8 ()V 
.const [162] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Ljava/lang/String;)V 
.const [165] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/DSIPredictiveNavigationReplyService 
.const [166] = Utf8 p_DSIPredictiveNavigationReply 
.const [167] = Utf8 Lde/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply; 
.const [168] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [169] = Utf8 getInt32 
.const [170] = Utf8 ()I 
.const [171] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply 
.const [172] = Utf8 updateOperationMode 
.const [173] = Utf8 (II)V 
.const [174] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply 
.const [175] = Utf8 updateLikelyDestinations 
.const [176] = Utf8 ([Lorg/dsi/ifc/predictivenavigation/LikelyDestination;I)V 
.const [177] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply 
.const [178] = Utf8 updateMaxPredictions 
.const [179] = Utf8 (II)V 
.const [180] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply 
.const [181] = Utf8 clearCacheResult 
.const [182] = Utf8 ()V 
.const [183] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [184] = Utf8 getOptionalString 
.const [185] = Utf8 ()Ljava/lang/String; 
.const [186] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply 
.const [187] = Utf8 asyncException 
.const [188] = Utf8 (ILjava/lang/String;I)V 
.const [189] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply 
.const [190] = Utf8 yyIndication 
.const [191] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [192] = Utf8 de/esolutions/fw/comm/dsi/predictivenavigation/impl/DSIPredictiveNavigationReplyService 
.const [193] = Class [192] 
.const [194] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [195] = Class [194] 
.const [196] = Utf8 context 
.const [197] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [198] = Utf8 dynamicHandle 
.const [199] = Utf8 I 
.const [200] = Utf8 p_DSIPredictiveNavigationReply 
.const [201] = Utf8 Lde/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply; 
.const [202] = Utf8 Code 
.const [203] = Utf8 <init> 
.const [204] = Utf8 (Lde/esolutions/fw/comm/dsi/predictivenavigation/DSIPredictiveNavigationReply;)V 
.const [205] = Utf8 nextDynamicHandle 
.const [206] = Utf8 ()I 
.const [207] = Utf8 getCallContext 
.const [208] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [209] = Utf8 handleCallMethod 
.const [210] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [211] = Utf8 <clinit> 
.const [212] = Utf8 ()V 
.end class 
