.version 50 0 
.class public super [175] 
.super [177] 
.field private static final [178] [179] 
.field private [180] [181] 

.method public [183] : [184] 
    .attribute [182] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [37] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [31] 
L15:    invokespecial [32] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [38] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [182] .code stack 2 locals 0 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [33] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [182] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [182] .code stack 4 locals 2 
        .catch [14] from L0 to L161 using L164 
L0:     iload_1 
L1:     tableswitch 3 
            L32 
            L66 
            L134 
            L100 
            default : L134 

L32:    aload_2 
L33:    invokestatic [8] 
L36:    astore 4 
L38:    aload_2 
L39:    invokeinterface [40] 0 
L44:    istore 5 
L46:    aload_0 
L47:    getfield [26] 
L50:    aload 4 
L52:    iload 5 
L54:    aload_3 
L55:    checkcast [6] 
L58:    invokeinterface [41] 0 
L63:    goto L161 
L66:    aload_2 
L67:    invokestatic [9] 
L70:    astore 4 
L72:    aload_2 
L73:    invokeinterface [40] 0 
L78:    istore 5 
L80:    aload_0 
L81:    getfield [26] 
L84:    aload 4 
L86:    iload 5 
L88:    aload_3 
L89:    checkcast [6] 
L92:    invokeinterface [42] 0 
L97:    goto L161 
L100:   aload_2 
L101:   invokestatic [10] 
L104:   astore 4 
L106:   aload_2 
L107:   invokeinterface [40] 0 
L112:   istore 5 
L114:   aload_0 
L115:   getfield [26] 
L118:   aload 4 
L120:   iload 5 
L122:   aload_3 
L123:   checkcast [6] 
L126:   invokeinterface [43] 0 
L131:   goto L161 
L134:   new [44] 
L137:   dup 
L138:   new [45] 
L141:   dup 
L142:   invokespecial [35] 
L145:   ldc [13] 
L147:   invokevirtual [27] 
L150:   iload_1 
L151:   invokevirtual [28] 
L154:   invokevirtual [29] 
L157:   invokespecial [36] 
L160:   athrow 
L161:   goto L206 
L164:   astore 4 
L166:   new [44] 
L169:   dup 
L170:   new [45] 
L173:   dup 
L174:   invokespecial [35] 
L177:   ldc [15] 
L179:   invokevirtual [27] 
L182:   iload_1 
L183:   invokevirtual [28] 
L186:   ldc [16] 
L188:   invokevirtual [27] 
L191:   aload 4 
L193:   invokevirtual [30] 
L196:   invokevirtual [27] 
L199:   invokevirtual [29] 
L202:   invokespecial [36] 
L205:   athrow 
L206:   return 
L207:   nop 
L208:   
    .end code 
.end method 

.method static [191] : [192] 
    .attribute [182] .code stack 1 locals 0 
L0:     ldc [17] 
L2:     invokestatic [18] 
L5:     putstatic [34] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = String [47] 
.const [4] = String [48] 
.const [5] = String [49] 
.const [6] = Class [50] 
.const [7] = Field [51] [52] 
.const [8] = Method [53] [54] 
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
.const [25] = Class [74] 
.const [26] = Field [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Method [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Field [91] [92] 
.const [35] = Method [93] [94] 
.const [36] = Method [95] [96] 
.const [37] = Class [97] 
.const [38] = Field [98] [99] 
.const [39] = Class [100] 
.const [40] = InterfaceMethod [101] [102] 
.const [41] = InterfaceMethod [103] [104] 
.const [42] = InterfaceMethod [105] [106] 
.const [43] = InterfaceMethod [107] [108] 
.const [44] = Class [109] 
.const [45] = Class [110] 
.const [46] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [47] = Utf8 '3beb5497-ae2a-4128-9f05-6068d21ac40f' 
.const [48] = Utf8 f203c2e7-a0c6-56da-ae80-1a6f30666d1f 
.const [49] = Utf8 'asi.navigation.mapregioninfo.MapRegionInfo' 
.const [50] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyProxy 
.const [51] = Class [111] 
.const [52] = NameAndType [112] [113] 
.const [53] = Class [114] 
.const [54] = NameAndType [115] [116] 
.const [55] = Class [117] 
.const [56] = NameAndType [118] [119] 
.const [57] = Class [120] 
.const [58] = NameAndType [121] [122] 
.const [59] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [60] = Utf8 java/lang/StringBuffer 
.const [61] = Utf8 'Invalid Method Id ' 
.const [62] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [63] = Utf8 'Deserialization failed: method=' 
.const [64] = Utf8 ', error=' 
.const [65] = Utf8 'STUB.asi.navigation.mapregioninfo.MapRegionInfo' 
.const [66] = Class [123] 
.const [67] = NameAndType [124] [125] 
.const [68] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoService 
.const [69] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationWgs84Serializer 
.const [71] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [72] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoS 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [74] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [75] = Class [126] 
.const [76] = NameAndType [127] [128] 
.const [77] = Class [129] 
.const [78] = NameAndType [130] [131] 
.const [79] = Class [132] 
.const [80] = NameAndType [133] [134] 
.const [81] = Class [135] 
.const [82] = NameAndType [136] [137] 
.const [83] = Class [138] 
.const [84] = NameAndType [139] [140] 
.const [85] = Class [141] 
.const [86] = NameAndType [142] [143] 
.const [87] = Class [144] 
.const [88] = NameAndType [145] [146] 
.const [89] = Class [147] 
.const [90] = NameAndType [148] [149] 
.const [91] = Class [150] 
.const [92] = NameAndType [151] [152] 
.const [93] = Class [153] 
.const [94] = NameAndType [154] [155] 
.const [95] = Class [156] 
.const [96] = NameAndType [157] [158] 
.const [97] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [98] = Class [159] 
.const [99] = NameAndType [160] [161] 
.const [100] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyProxy 
.const [101] = Class [162] 
.const [102] = NameAndType [163] [164] 
.const [103] = Class [165] 
.const [104] = NameAndType [166] [167] 
.const [105] = Class [168] 
.const [106] = NameAndType [169] [170] 
.const [107] = Class [171] 
.const [108] = NameAndType [172] [173] 
.const [109] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [110] = Utf8 java/lang/StringBuffer 
.const [111] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoService 
.const [112] = Utf8 context 
.const [113] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [114] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationWgs84Serializer 
.const [115] = Utf8 getOptionalNavLocationWgs84 
.const [116] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [117] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationWgs84Serializer 
.const [118] = Utf8 getOptionalNavLocationWgs84VarArray 
.const [119] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [120] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [121] = Utf8 getOptionalNavRectangle 
.const [122] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavRectangle; 
.const [123] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [124] = Utf8 getContext 
.const [125] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [126] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoService 
.const [127] = Utf8 p_MapRegionInfo 
.const [128] = Utf8 Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoS; 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 append 
.const [131] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 append 
.const [134] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [135] = Utf8 java/lang/StringBuffer 
.const [136] = Utf8 toString 
.const [137] = Utf8 ()Ljava/lang/String; 
.const [138] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [139] = Utf8 getMessage 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [144] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [147] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoReplyProxy 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoService 
.const [151] = Utf8 context 
.const [152] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [153] = Utf8 java/lang/StringBuffer 
.const [154] = Utf8 <init> 
.const [155] = Utf8 ()V 
.const [156] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Ljava/lang/String;)V 
.const [159] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoService 
.const [160] = Utf8 p_MapRegionInfo 
.const [161] = Utf8 Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoS; 
.const [162] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [163] = Utf8 getUInt16 
.const [164] = Utf8 ()I 
.const [165] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoS 
.const [166] = Utf8 requestGetDatabaseInfo 
.const [167] = Utf8 (Lorg/dsi/ifc/global/NavLocationWgs84;ILde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply;)V 
.const [168] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoS 
.const [169] = Utf8 requestGetMultipleDatabaseInfo 
.const [170] = Utf8 ([Lorg/dsi/ifc/global/NavLocationWgs84;ILde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply;)V 
.const [171] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoS 
.const [172] = Utf8 requestGetRegionsInVicinity 
.const [173] = Utf8 (Lorg/dsi/ifc/global/NavRectangle;ILde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoReply;)V 
.const [174] = Utf8 de/esolutions/fw/comm/asi/navigation/mapregioninfo/impl/MapRegionInfoService 
.const [175] = Class [174] 
.const [176] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [177] = Class [176] 
.const [178] = Utf8 context 
.const [179] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [180] = Utf8 p_MapRegionInfo 
.const [181] = Utf8 Lde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoS; 
.const [182] = Utf8 Code 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (ILde/esolutions/fw/comm/asi/navigation/mapregioninfo/MapRegionInfoS;)V 
.const [185] = Utf8 createReplyProxy 
.const [186] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [187] = Utf8 getCallContext 
.const [188] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [189] = Utf8 handleCallMethod 
.const [190] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [191] = Utf8 <clinit> 
.const [192] = Utf8 ()V 
.end class 
