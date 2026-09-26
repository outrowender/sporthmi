.version 50 0 
.class public super [213] 
.super [215] 
.field private static final [216] [217] 
.field private static [218] [219] 
.field private [220] [221] 

.method public [223] : [224] 
    .attribute [222] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [43] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [37] 
L17:    invokespecial [38] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [44] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [225] : [226] 
    .attribute [222] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [39] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [222] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [222] .code stack 5 locals 4 
        .catch [17] from L0 to L235 using L238 
L0:     iload_1 
L1:     lookupswitch 
            3 : L130 
            5 : L44 
            15 : L170 
            16 : L84 
            default : L208 

L44:    aload_2 
L45:    invokeinterface [45] 0 
L50:    astore 4 
L52:    aload_2 
L53:    invokestatic [9] 
L56:    astore 5 
L58:    aload_2 
L59:    invokeinterface [46] 0 
L64:    istore 6 
L66:    aload_0 
L67:    getfield [32] 
L70:    aload 4 
L72:    aload 5 
L74:    iload 6 
L76:    invokeinterface [47] 0 
L81:    goto L235 
L84:    aload_2 
L85:    invokestatic [10] 
L88:    astore 4 
L90:    aload_2 
L91:    invokestatic [11] 
L94:    astore 5 
L96:    aload_2 
L97:    invokestatic [12] 
L100:   astore 6 
L102:   aload_2 
L103:   invokeinterface [46] 0 
L108:   istore 7 
L110:   aload_0 
L111:   getfield [32] 
L114:   aload 4 
L116:   aload 5 
L118:   aload 6 
L120:   iload 7 
L122:   invokeinterface [48] 0 
L127:   goto L235 
L130:   aload_2 
L131:   invokeinterface [45] 0 
L136:   astore 4 
L138:   aload_2 
L139:   invokestatic [9] 
L142:   astore 5 
L144:   aload_2 
L145:   invokeinterface [46] 0 
L150:   istore 6 
L152:   aload_0 
L153:   getfield [32] 
L156:   aload 4 
L158:   aload 5 
L160:   iload 6 
L162:   invokeinterface [49] 0 
L167:   goto L235 
L170:   aload_2 
L171:   invokestatic [10] 
L174:   astore 4 
L176:   aload_2 
L177:   invokestatic [13] 
L180:   astore 5 
L182:   aload_2 
L183:   invokeinterface [46] 0 
L188:   istore 6 
L190:   aload_0 
L191:   getfield [32] 
L194:   aload 4 
L196:   aload 5 
L198:   iload 6 
L200:   invokeinterface [50] 0 
L205:   goto L235 
L208:   new [51] 
L211:   dup 
L212:   new [52] 
L215:   dup 
L216:   invokespecial [41] 
L219:   ldc [16] 
L221:   invokevirtual [33] 
L224:   iload_1 
L225:   invokevirtual [34] 
L228:   invokevirtual [35] 
L231:   invokespecial [42] 
L234:   athrow 
L235:   goto L280 
L238:   astore 4 
L240:   new [51] 
L243:   dup 
L244:   new [52] 
L247:   dup 
L248:   invokespecial [41] 
L251:   ldc [18] 
L253:   invokevirtual [33] 
L256:   iload_1 
L257:   invokevirtual [34] 
L260:   ldc [19] 
L262:   invokevirtual [33] 
L265:   aload 4 
L267:   invokevirtual [36] 
L270:   invokevirtual [33] 
L273:   invokevirtual [35] 
L276:   invokespecial [42] 
L279:   athrow 
L280:   return 
L281:   nop 
L282:   nop 
L283:   nop 
L284:   
    .end code 
.end method 

.method static [231] : [232] 
    .attribute [222] .code stack 1 locals 0 
L0:     ldc [20] 
L2:     invokestatic [21] 
L5:     putstatic [40] 
L8:     iconst_0 
L9:     putstatic [39] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [53] 
.const [3] = String [54] 
.const [4] = Method [55] [56] 
.const [5] = String [57] 
.const [6] = String [58] 
.const [7] = Field [59] [60] 
.const [8] = Field [61] [62] 
.const [9] = Method [63] [64] 
.const [10] = Method [65] [66] 
.const [11] = Method [67] [68] 
.const [12] = Method [69] [70] 
.const [13] = Method [71] [72] 
.const [14] = Class [73] 
.const [15] = Class [74] 
.const [16] = String [75] 
.const [17] = Class [76] 
.const [18] = String [77] 
.const [19] = String [78] 
.const [20] = String [79] 
.const [21] = Method [80] [81] 
.const [22] = Class [82] 
.const [23] = Class [83] 
.const [24] = Class [84] 
.const [25] = Class [85] 
.const [26] = Class [86] 
.const [27] = Class [87] 
.const [28] = Class [88] 
.const [29] = Class [89] 
.const [30] = Class [90] 
.const [31] = Class [91] 
.const [32] = Field [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Method [102] [103] 
.const [38] = Method [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Field [108] [109] 
.const [41] = Method [110] [111] 
.const [42] = Method [112] [113] 
.const [43] = Class [114] 
.const [44] = Field [115] [116] 
.const [45] = InterfaceMethod [117] [118] 
.const [46] = InterfaceMethod [119] [120] 
.const [47] = InterfaceMethod [121] [122] 
.const [48] = InterfaceMethod [123] [124] 
.const [49] = InterfaceMethod [125] [126] 
.const [50] = InterfaceMethod [127] [128] 
.const [51] = Class [129] 
.const [52] = Class [130] 
.const [53] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [54] = Utf8 '7114efbf-e1b7-4c0f-a8ef-4e4718806d54' 
.const [55] = Class [131] 
.const [56] = NameAndType [132] [133] 
.const [57] = Utf8 '45c3e4f9-004e-561f-92cf-4451d9da24ab' 
.const [58] = Utf8 'asi.navigation.ncfs.NCFSProvider' 
.const [59] = Class [134] 
.const [60] = NameAndType [135] [136] 
.const [61] = Class [137] 
.const [62] = NameAndType [138] [139] 
.const [63] = Class [140] 
.const [64] = NameAndType [141] [142] 
.const [65] = Class [143] 
.const [66] = NameAndType [144] [145] 
.const [67] = Class [146] 
.const [68] = NameAndType [147] [148] 
.const [69] = Class [149] 
.const [70] = NameAndType [150] [151] 
.const [71] = Class [152] 
.const [72] = NameAndType [153] [154] 
.const [73] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [74] = Utf8 java/lang/StringBuffer 
.const [75] = Utf8 'Invalid Method Id ' 
.const [76] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [77] = Utf8 'Deserialization failed: method=' 
.const [78] = Utf8 ', error=' 
.const [79] = Utf8 'STUB.asi.navigation.ncfs.NCFSProvider' 
.const [80] = Class [155] 
.const [81] = NameAndType [156] [157] 
.const [82] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyService 
.const [83] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [84] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [85] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sBoundingBoxSerializer 
.const [86] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply 
.const [87] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sTileInfoSerializer 
.const [88] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sEdgeSerializer 
.const [89] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sRestrictionSerializer 
.const [90] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLGIEventSerializer 
.const [91] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [92] = Class [158] 
.const [93] = NameAndType [159] [160] 
.const [94] = Class [161] 
.const [95] = NameAndType [162] [163] 
.const [96] = Class [164] 
.const [97] = NameAndType [165] [166] 
.const [98] = Class [167] 
.const [99] = NameAndType [168] [169] 
.const [100] = Class [170] 
.const [101] = NameAndType [171] [172] 
.const [102] = Class [173] 
.const [103] = NameAndType [174] [175] 
.const [104] = Class [176] 
.const [105] = NameAndType [177] [178] 
.const [106] = Class [179] 
.const [107] = NameAndType [180] [181] 
.const [108] = Class [182] 
.const [109] = NameAndType [183] [184] 
.const [110] = Class [185] 
.const [111] = NameAndType [186] [187] 
.const [112] = Class [188] 
.const [113] = NameAndType [189] [190] 
.const [114] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [115] = Class [191] 
.const [116] = NameAndType [192] [193] 
.const [117] = Class [194] 
.const [118] = NameAndType [195] [196] 
.const [119] = Class [197] 
.const [120] = NameAndType [198] [199] 
.const [121] = Class [200] 
.const [122] = NameAndType [201] [202] 
.const [123] = Class [203] 
.const [124] = NameAndType [204] [205] 
.const [125] = Class [206] 
.const [126] = NameAndType [207] [208] 
.const [127] = Class [209] 
.const [128] = NameAndType [210] [211] 
.const [129] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyService 
.const [132] = Utf8 nextDynamicHandle 
.const [133] = Utf8 ()I 
.const [134] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyService 
.const [135] = Utf8 dynamicHandle 
.const [136] = Utf8 I 
.const [137] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyService 
.const [138] = Utf8 context 
.const [139] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [140] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sBoundingBoxSerializer 
.const [141] = Utf8 getOptionalsBoundingBox 
.const [142] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox; 
.const [143] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sTileInfoSerializer 
.const [144] = Utf8 getOptionalsTileInfoVarArray 
.const [145] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/ncfs/sTileInfo; 
.const [146] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sEdgeSerializer 
.const [147] = Utf8 getOptionalsEdgeVarArray 
.const [148] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/ncfs/sEdge; 
.const [149] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sRestrictionSerializer 
.const [150] = Utf8 getOptionalsRestrictionVarArray 
.const [151] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/ncfs/sRestriction; 
.const [152] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLGIEventSerializer 
.const [153] = Utf8 getOptionalsLGIEventVarArray 
.const [154] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent; 
.const [155] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [156] = Utf8 getContext 
.const [157] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [158] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyService 
.const [159] = Utf8 p_NCFSProviderReply 
.const [160] = Utf8 Lde/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply; 
.const [161] = Utf8 java/lang/StringBuffer 
.const [162] = Utf8 append 
.const [163] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [164] = Utf8 java/lang/StringBuffer 
.const [165] = Utf8 append 
.const [166] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [167] = Utf8 java/lang/StringBuffer 
.const [168] = Utf8 toString 
.const [169] = Utf8 ()Ljava/lang/String; 
.const [170] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [171] = Utf8 getMessage 
.const [172] = Utf8 ()Ljava/lang/String; 
.const [173] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [176] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [179] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyService 
.const [180] = Utf8 dynamicHandle 
.const [181] = Utf8 I 
.const [182] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyService 
.const [183] = Utf8 context 
.const [184] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [185] = Utf8 java/lang/StringBuffer 
.const [186] = Utf8 <init> 
.const [187] = Utf8 ()V 
.const [188] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (Ljava/lang/String;)V 
.const [191] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyService 
.const [192] = Utf8 p_NCFSProviderReply 
.const [193] = Utf8 Lde/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply; 
.const [194] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [195] = Utf8 getOptionalInt32VarArray 
.const [196] = Utf8 ()[I 
.const [197] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [198] = Utf8 getEnum 
.const [199] = Utf8 ()I 
.const [200] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply 
.const [201] = Utf8 updateVZOTileIndexes 
.const [202] = Utf8 ([ILde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox;I)V 
.const [203] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply 
.const [204] = Utf8 updateVZORestrictions 
.const [205] = Utf8 ([Lde/esolutions/fw/comm/asi/navigation/ncfs/sTileInfo;[Lde/esolutions/fw/comm/asi/navigation/ncfs/sEdge;[Lde/esolutions/fw/comm/asi/navigation/ncfs/sRestriction;I)V 
.const [206] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply 
.const [207] = Utf8 updateLGITileIndexes 
.const [208] = Utf8 ([ILde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox;I)V 
.const [209] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply 
.const [210] = Utf8 updateLGIEvents 
.const [211] = Utf8 ([Lde/esolutions/fw/comm/asi/navigation/ncfs/sTileInfo;[Lde/esolutions/fw/comm/asi/navigation/ncfs/sLGIEvent;I)V 
.const [212] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/NCFSProviderReplyService 
.const [213] = Class [212] 
.const [214] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [215] = Class [214] 
.const [216] = Utf8 context 
.const [217] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [218] = Utf8 dynamicHandle 
.const [219] = Utf8 I 
.const [220] = Utf8 p_NCFSProviderReply 
.const [221] = Utf8 Lde/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply; 
.const [222] = Utf8 Code 
.const [223] = Utf8 <init> 
.const [224] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/ncfs/NCFSProviderReply;)V 
.const [225] = Utf8 nextDynamicHandle 
.const [226] = Utf8 ()I 
.const [227] = Utf8 getCallContext 
.const [228] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [229] = Utf8 handleCallMethod 
.const [230] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [231] = Utf8 <clinit> 
.const [232] = Utf8 ()V 
.end class 
