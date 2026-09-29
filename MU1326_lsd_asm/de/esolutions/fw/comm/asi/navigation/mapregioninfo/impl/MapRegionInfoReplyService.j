.version 50 0 
.class public super [181] 
.super [183] 
.field private static final [184] [185] 
.field private static [186] [187] 
.field private [188] [189] 

.method public [191] : [192] 
    .attribute [190] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [36] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [30] 
L17:    invokespecial [31] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [37] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [193] : [194] 
    .attribute [190] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [32] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [190] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [190] .code stack 4 locals 3 
        .catch [14] from L0 to L175 using L178 
L0:     iload_1 
L1:     tableswitch 0 
            L28 
            L68 
            L108 
            default : L148 

L28:    aload_2 
L29:    invokeinterface [38] 0 
L34:    istore 4 
L36:    aload_2 
L37:    invokestatic [9] 
L40:    astore 5 
L42:    aload_2 
L43:    invokeinterface [39] 0 
L48:    istore 6 
L50:    aload_0 
L51:    getfield [25] 
L54:    iload 4 
L56:    aload 5 
L58:    iload 6 
L60:    invokeinterface [40] 0 
L65:    goto L175 
L68:    aload_2 
L69:    invokeinterface [38] 0 
L74:    istore 4 
L76:    aload_2 
L77:    invokestatic [10] 
L80:    astore 5 
L82:    aload_2 
L83:    invokeinterface [39] 0 
L88:    istore 6 
L90:    aload_0 
L91:    getfield [25] 
L94:    iload 4 
L96:    aload 5 
L98:    iload 6 
L100:   invokeinterface [41] 0 
L105:   goto L175 
L108:   aload_2 
L109:   invokeinterface [38] 0 
L114:   istore 4 
L116:   aload_2 
L117:   invokestatic [10] 
L120:   astore 5 
L122:   aload_2 
L123:   invokeinterface [39] 0 
L128:   istore 6 
L130:   aload_0 
L131:   getfield [25] 
L134:   iload 4 
L136:   aload 5 
L138:   iload 6 
L140:   invokeinterface [42] 0 
L145:   goto L175 
L148:   new [43] 
L151:   dup 
L152:   new [44] 
L155:   dup 
L156:   invokespecial [34] 
L159:   ldc [13] 
L161:   invokevirtual [26] 
L164:   iload_1 
L165:   invokevirtual [27] 
L168:   invokevirtual [28] 
L171:   invokespecial [35] 
L174:   athrow 
L175:   goto L220 
L178:   astore 4 
L180:   new [43] 
L183:   dup 
L184:   new [44] 
L187:   dup 
L188:   invokespecial [34] 
L191:   ldc [15] 
L193:   invokevirtual [26] 
L196:   iload_1 
L197:   invokevirtual [27] 
L200:   ldc [16] 
L202:   invokevirtual [26] 
L205:   aload 4 
L207:   invokevirtual [29] 
L210:   invokevirtual [26] 
L213:   invokevirtual [28] 
L216:   invokespecial [35] 
L219:   athrow 
L220:   return 
L221:   nop 
L222:   nop 
L223:   nop 
L224:   
    .end code 
.end method 

.method static [199] : [200] 
    .attribute [190] .code stack 1 locals 0 
L0:     ldc [17] 
L2:     invokestatic [18] 
L5:     putstatic [33] 
L8:     iconst_0 
L9:     putstatic [32] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [45] 
.const [3] = String [46] 
.const [4] = Method [47] [48] 
.const [5] = String [49] 
.const [6] = String [50] 
.const [7] = Field [51] [52] 
.const [8] = Field [53] [54] 
.const [9] = Method [55] [56] 
.const [10] = Method [57] [58] 
.const [11] = Class [59] 
.const [12] = Class [60] 
.const [13] = String [61] 
.const [14] = Class [62] 
.const [15] = String [63] 
.const [16] = String [64] 
.const [17] = String [65] 
.const [18] = Method [66] [67] 
.const [19] = Class [68] 
.const [20] = Class [69] 
.const [21] = Class [70] 
.const [22] = Class [71] 
.const [23] = Class [72] 
.const [24] = Class [73] 
.const [25] = Field [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Field [88] [89] 
.const [33] = Field [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Class [96] 
.const [37] = Field [97] [98] 
.const [38] = InterfaceMethod [99] [100] 
.const [39] = InterfaceMethod [101] [102] 
.const [40] = InterfaceMethod [103] [104] 
.const [41] = InterfaceMethod [105] [106] 
.const [42] = InterfaceMethod [107] [108] 
.const [43] = Class [109] 
.const [44] = Class [110] 
.const [45] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [46] = Utf8 f6ed3bd2-c174-4a4c-a99f-5ca2e73a72e5 
.const [47] = Class [111] 
.const [48] = NameAndType [112] [113] 
.const [49] = Utf8 ea59591a-319c-5eba-8c59-1bc981eda986 
.const [50] = Utf8 'asi.navigation.mapregioninfo.MapRegionInfo' 
.const [51] = Class [114] 
.const [52] = NameAndType [115] [116] 
.const [53] = Class [117] 
.const [54] = NameAndType [118] [119] 
.const [55] = Class [120] 
.const [56] = NameAndType [121] [122] 
.const [57] = Class [123] 
.const [58] = NameAndType [124] [125] 
.const [59] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [60] = Utf8 java/lang/StringBuffer 
.const [61] = Utf8 'Invalid Method Id ' 
.const [62] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [63] = Utf8 'Deserialization failed: method=' 
.const [64] = Utf8 ', error=' 
.const [65] = Utf8 'STUB.asi.navigation.mapregioninfo.MapRegionInfo' 
.const [66] = Class [126] 
.const [67] = NameAndType [127] [128] 
.const [68] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyService 
.const [69] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [70] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [71] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/ComponentInfoSerializer 
.const [72] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply 
.const [73] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [74] = Class [129] 
.const [75] = NameAndType [130] [131] 
.const [76] = Class [132] 
.const [77] = NameAndType [133] [134] 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Class [138] 
.const [81] = NameAndType [139] [140] 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Class [144] 
.const [85] = NameAndType [145] [146] 
.const [86] = Class [147] 
.const [87] = NameAndType [148] [149] 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Class [156] 
.const [93] = NameAndType [157] [158] 
.const [94] = Class [159] 
.const [95] = NameAndType [160] [161] 
.const [96] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [97] = Class [162] 
.const [98] = NameAndType [163] [164] 
.const [99] = Class [165] 
.const [100] = NameAndType [166] [167] 
.const [101] = Class [168] 
.const [102] = NameAndType [169] [170] 
.const [103] = Class [171] 
.const [104] = NameAndType [172] [173] 
.const [105] = Class [174] 
.const [106] = NameAndType [175] [176] 
.const [107] = Class [177] 
.const [108] = NameAndType [178] [179] 
.const [109] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [110] = Utf8 java/lang/StringBuffer 
.const [111] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyService 
.const [112] = Utf8 nextDynamicHandle 
.const [113] = Utf8 ()I 
.const [114] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyService 
.const [115] = Utf8 dynamicHandle 
.const [116] = Utf8 I 
.const [117] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyService 
.const [118] = Utf8 context 
.const [119] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [120] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/ComponentInfoSerializer 
.const [121] = Utf8 getOptionalComponentInfo 
.const [122] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/ComponentInfo; 
.const [123] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/ComponentInfoSerializer 
.const [124] = Utf8 getOptionalComponentInfoVarArray 
.const [125] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/ComponentInfo; 
.const [126] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [127] = Utf8 getContext 
.const [128] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [129] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyService 
.const [130] = Utf8 p_MapRegionInfoReply 
.const [131] = Utf8 Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply; 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 append 
.const [134] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [135] = Utf8 java/lang/StringBuffer 
.const [136] = Utf8 append 
.const [137] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [138] = Utf8 java/lang/StringBuffer 
.const [139] = Utf8 toString 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [142] = Utf8 getMessage 
.const [143] = Utf8 ()Ljava/lang/String; 
.const [144] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [147] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [150] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyService 
.const [151] = Utf8 dynamicHandle 
.const [152] = Utf8 I 
.const [153] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyService 
.const [154] = Utf8 context 
.const [155] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [156] = Utf8 java/lang/StringBuffer 
.const [157] = Utf8 <init> 
.const [158] = Utf8 ()V 
.const [159] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Ljava/lang/String;)V 
.const [162] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyService 
.const [163] = Utf8 p_MapRegionInfoReply 
.const [164] = Utf8 Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply; 
.const [165] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [166] = Utf8 getUInt16 
.const [167] = Utf8 ()I 
.const [168] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [169] = Utf8 getEnum 
.const [170] = Utf8 ()I 
.const [171] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply 
.const [172] = Utf8 replyGetDatabaseInfo 
.const [173] = Utf8 (ILde/esolutions/fw/comm/asi/navigation/mapregioninfo/ComponentInfo;I)V 
.const [174] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply 
.const [175] = Utf8 replyGetMultipleDatabaseInfo 
.const [176] = Utf8 (I[Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/ComponentInfo;I)V 
.const [177] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply 
.const [178] = Utf8 replyGetRegionsInVicinity 
.const [179] = Utf8 (I[Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/ComponentInfo;I)V 
.const [180] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyService 
.const [181] = Class [180] 
.const [182] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [183] = Class [182] 
.const [184] = Utf8 context 
.const [185] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [186] = Utf8 dynamicHandle 
.const [187] = Utf8 I 
.const [188] = Utf8 p_MapRegionInfoReply 
.const [189] = Utf8 Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply; 
.const [190] = Utf8 Code 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply;)V 
.const [193] = Utf8 nextDynamicHandle 
.const [194] = Utf8 ()I 
.const [195] = Utf8 getCallContext 
.const [196] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [197] = Utf8 handleCallMethod 
.const [198] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [199] = Utf8 <clinit> 
.const [200] = Utf8 ()V 
.end class 
