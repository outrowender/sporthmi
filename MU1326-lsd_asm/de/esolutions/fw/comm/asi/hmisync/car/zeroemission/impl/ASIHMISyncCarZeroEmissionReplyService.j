.version 50 0 
.class public super [211] 
.super [213] 
.field private static final [214] [215] 
.field private static [216] [217] 
.field private [218] [219] 

.method public [221] : [222] 
    .attribute [220] .code stack 7 locals 0 
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

.method private static synchronized [223] : [224] 
    .attribute [220] .code stack 2 locals 1 
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

.method public [225] : [226] 
    .attribute [220] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [220] .code stack 4 locals 2 
        .catch [14] from L0 to L255 using L258 
L0:     iload_1 
L1:     tableswitch 6 
            L40 
            L198 
            L104 
            L72 
            L168 
            L136 
            default : L228 

L40:    aload_2 
L41:    invokeinterface [38] 0 
L46:    astore 4 
L48:    aload_2 
L49:    invokeinterface [39] 0 
L54:    istore 5 
L56:    aload_0 
L57:    getfield [25] 
L60:    aload 4 
L62:    iload 5 
L64:    invokeinterface [40] 0 
L69:    goto L255 
L72:    aload_2 
L73:    invokeinterface [41] 0 
L78:    astore 4 
L80:    aload_2 
L81:    invokeinterface [39] 0 
L86:    istore 5 
L88:    aload_0 
L89:    getfield [25] 
L92:    aload 4 
L94:    iload 5 
L96:    invokeinterface [42] 0 
L101:   goto L255 
L104:   aload_2 
L105:   invokeinterface [41] 0 
L110:   astore 4 
L112:   aload_2 
L113:   invokeinterface [39] 0 
L118:   istore 5 
L120:   aload_0 
L121:   getfield [25] 
L124:   aload 4 
L126:   iload 5 
L128:   invokeinterface [43] 0 
L133:   goto L255 
L136:   aload_2 
L137:   invokeinterface [44] 0 
L142:   istore 4 
L144:   aload_2 
L145:   invokeinterface [39] 0 
L150:   istore 5 
L152:   aload_0 
L153:   getfield [25] 
L156:   iload 4 
L158:   iload 5 
L160:   invokeinterface [45] 0 
L165:   goto L255 
L168:   aload_2 
L169:   invokestatic [9] 
L172:   astore 4 
L174:   aload_2 
L175:   invokeinterface [39] 0 
L180:   istore 5 
L182:   aload_0 
L183:   getfield [25] 
L186:   aload 4 
L188:   iload 5 
L190:   invokeinterface [46] 0 
L195:   goto L255 
L198:   aload_2 
L199:   invokestatic [10] 
L202:   astore 4 
L204:   aload_2 
L205:   invokeinterface [39] 0 
L210:   istore 5 
L212:   aload_0 
L213:   getfield [25] 
L216:   aload 4 
L218:   iload 5 
L220:   invokeinterface [47] 0 
L225:   goto L255 
L228:   new [48] 
L231:   dup 
L232:   new [49] 
L235:   dup 
L236:   invokespecial [34] 
L239:   ldc [13] 
L241:   invokevirtual [26] 
L244:   iload_1 
L245:   invokevirtual [27] 
L248:   invokevirtual [28] 
L251:   invokespecial [35] 
L254:   athrow 
L255:   goto L300 
L258:   astore 4 
L260:   new [48] 
L263:   dup 
L264:   new [49] 
L267:   dup 
L268:   invokespecial [34] 
L271:   ldc [15] 
L273:   invokevirtual [26] 
L276:   iload_1 
L277:   invokevirtual [27] 
L280:   ldc [16] 
L282:   invokevirtual [26] 
L285:   aload 4 
L287:   invokevirtual [29] 
L290:   invokevirtual [26] 
L293:   invokevirtual [28] 
L296:   invokespecial [35] 
L299:   athrow 
L300:   return 
L301:   nop 
L302:   nop 
L303:   nop 
L304:   
    .end code 
.end method 

.method static [229] : [230] 
    .attribute [220] .code stack 1 locals 0 
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
.const [2] = Class [50] 
.const [3] = String [51] 
.const [4] = Method [52] [53] 
.const [5] = String [54] 
.const [6] = String [55] 
.const [7] = Field [56] [57] 
.const [8] = Field [58] [59] 
.const [9] = Method [60] [61] 
.const [10] = Method [62] [63] 
.const [11] = Class [64] 
.const [12] = Class [65] 
.const [13] = String [66] 
.const [14] = Class [67] 
.const [15] = String [68] 
.const [16] = String [69] 
.const [17] = String [70] 
.const [18] = Method [71] [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Class [77] 
.const [24] = Class [78] 
.const [25] = Field [79] [80] 
.const [26] = Method [81] [82] 
.const [27] = Method [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Field [93] [94] 
.const [33] = Field [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Method [99] [100] 
.const [36] = Class [101] 
.const [37] = Field [102] [103] 
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
.const [51] = Utf8 '83464154-9032-473d-b4c8-2dac866dcb2a' 
.const [52] = Class [126] 
.const [53] = NameAndType [127] [128] 
.const [54] = Utf8 '49028b78-c4f4-5526-896b-c466f65870bd' 
.const [55] = Utf8 'asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission' 
.const [56] = Class [129] 
.const [57] = NameAndType [130] [131] 
.const [58] = Class [132] 
.const [59] = NameAndType [133] [134] 
.const [60] = Class [135] 
.const [61] = NameAndType [136] [137] 
.const [62] = Class [138] 
.const [63] = NameAndType [139] [140] 
.const [64] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [65] = Utf8 java/lang/StringBuffer 
.const [66] = Utf8 'Invalid Method Id ' 
.const [67] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [68] = Utf8 'Deserialization failed: method=' 
.const [69] = Utf8 ', error=' 
.const [70] = Utf8 'STUB.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission' 
.const [71] = Class [141] 
.const [72] = NameAndType [142] [143] 
.const [73] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionReplyService 
.const [74] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [75] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [76] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply 
.const [77] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ZeroEmissionEntrySerializer 
.const [78] = Utf8 de/esolutions/fw/comm/core/CallContext 
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
.const [99] = Class [174] 
.const [100] = NameAndType [175] [176] 
.const [101] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
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
.const [126] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionReplyService 
.const [127] = Utf8 nextDynamicHandle 
.const [128] = Utf8 ()I 
.const [129] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionReplyService 
.const [130] = Utf8 dynamicHandle 
.const [131] = Utf8 I 
.const [132] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionReplyService 
.const [133] = Utf8 context 
.const [134] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [135] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ZeroEmissionEntrySerializer 
.const [136] = Utf8 getOptionalZeroEmissionEntryVarArray 
.const [137] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/ZeroEmissionEntry; 
.const [138] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ZeroEmissionEntrySerializer 
.const [139] = Utf8 getOptionalZeroEmissionEntry 
.const [140] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/ZeroEmissionEntry; 
.const [141] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [142] = Utf8 getContext 
.const [143] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [144] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionReplyService 
.const [145] = Utf8 p_ASIHMISyncCarZeroEmissionReply 
.const [146] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply; 
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
.const [165] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionReplyService 
.const [166] = Utf8 dynamicHandle 
.const [167] = Utf8 I 
.const [168] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionReplyService 
.const [169] = Utf8 context 
.const [170] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [171] = Utf8 java/lang/StringBuffer 
.const [172] = Utf8 <init> 
.const [173] = Utf8 ()V 
.const [174] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Ljava/lang/String;)V 
.const [177] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionReplyService 
.const [178] = Utf8 p_ASIHMISyncCarZeroEmissionReply 
.const [179] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply; 
.const [180] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [181] = Utf8 getOptionalString 
.const [182] = Utf8 ()Ljava/lang/String; 
.const [183] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [184] = Utf8 getBool 
.const [185] = Utf8 ()Z 
.const [186] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply 
.const [187] = Utf8 updateASIVersion 
.const [188] = Utf8 (Ljava/lang/String;Z)V 
.const [189] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [190] = Utf8 getOptionalInt16VarArray 
.const [191] = Utf8 ()[S 
.const [192] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply 
.const [193] = Utf8 updateRequestIDs 
.const [194] = Utf8 ([SZ)V 
.const [195] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply 
.const [196] = Utf8 updateReplyIDs 
.const [197] = Utf8 ([SZ)V 
.const [198] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [199] = Utf8 getInt32 
.const [200] = Utf8 ()I 
.const [201] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply 
.const [202] = Utf8 updateZEVisibilityState 
.const [203] = Utf8 (IZ)V 
.const [204] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply 
.const [205] = Utf8 updateZeroEmissionValues 
.const [206] = Utf8 ([Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/ZeroEmissionEntry;Z)V 
.const [207] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply 
.const [208] = Utf8 updateCurrentZeroEmissionValue 
.const [209] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/ZeroEmissionEntry;Z)V 
.const [210] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionReplyService 
.const [211] = Class [210] 
.const [212] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [213] = Class [212] 
.const [214] = Utf8 context 
.const [215] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [216] = Utf8 dynamicHandle 
.const [217] = Utf8 I 
.const [218] = Utf8 p_ASIHMISyncCarZeroEmissionReply 
.const [219] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply; 
.const [220] = Utf8 Code 
.const [221] = Utf8 <init> 
.const [222] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionReply;)V 
.const [223] = Utf8 nextDynamicHandle 
.const [224] = Utf8 ()I 
.const [225] = Utf8 getCallContext 
.const [226] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [227] = Utf8 handleCallMethod 
.const [228] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [229] = Utf8 <clinit> 
.const [230] = Utf8 ()V 
.end class 
