.version 50 0 
.class public super [199] 
.super [201] 
.field private static final [202] [203] 
.field private static [204] [205] 
.field private [206] [207] 

.method public [209] : [210] 
    .attribute [208] .code stack 7 locals 0 
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

.method private static synchronized [211] : [212] 
    .attribute [208] .code stack 2 locals 1 
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

.method public [213] : [214] 
    .attribute [208] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [208] .code stack 4 locals 3 
        .catch [14] from L0 to L297 using L300 
L0:     iload_1 
L1:     tableswitch 0 
            L196 
            L270 
            L270 
            L270 
            L270 
            L144 
            L270 
            L72 
            L270 
            L270 
            L270 
            L166 
            L104 
            L238 
            default : L270 

L72:    aload_2 
L73:    invokeinterface [38] 0 
L78:    istore 4 
L80:    aload_2 
L81:    invokeinterface [38] 0 
L86:    istore 5 
L88:    aload_0 
L89:    getfield [25] 
L92:    iload 4 
L94:    iload 5 
L96:    invokeinterface [39] 0 
L101:   goto L297 
L104:   aload_2 
L105:   invokestatic [9] 
L108:   astore 4 
L110:   aload_2 
L111:   invokeinterface [38] 0 
L116:   istore 5 
L118:   aload_2 
L119:   invokeinterface [38] 0 
L124:   istore 6 
L126:   aload_0 
L127:   getfield [25] 
L130:   aload 4 
L132:   iload 5 
L134:   iload 6 
L136:   invokeinterface [40] 0 
L141:   goto L297 
L144:   aload_2 
L145:   invokeinterface [38] 0 
L150:   istore 4 
L152:   aload_0 
L153:   getfield [25] 
L156:   iload 4 
L158:   invokeinterface [41] 0 
L163:   goto L297 
L166:   aload_2 
L167:   invokestatic [10] 
L170:   astore 4 
L172:   aload_2 
L173:   invokeinterface [38] 0 
L178:   istore 5 
L180:   aload_0 
L181:   getfield [25] 
L184:   aload 4 
L186:   iload 5 
L188:   invokeinterface [42] 0 
L193:   goto L297 
L196:   aload_2 
L197:   invokeinterface [38] 0 
L202:   istore 4 
L204:   aload_2 
L205:   invokeinterface [43] 0 
L210:   astore 5 
L212:   aload_2 
L213:   invokeinterface [38] 0 
L218:   istore 6 
L220:   aload_0 
L221:   getfield [25] 
L224:   iload 4 
L226:   aload 5 
L228:   iload 6 
L230:   invokeinterface [44] 0 
L235:   goto L297 
L238:   aload_2 
L239:   invokeinterface [43] 0 
L244:   astore 4 
L246:   aload_2 
L247:   invokeinterface [43] 0 
L252:   astore 5 
L254:   aload_0 
L255:   getfield [25] 
L258:   aload 4 
L260:   aload 5 
L262:   invokeinterface [45] 0 
L267:   goto L297 
L270:   new [46] 
L273:   dup 
L274:   new [47] 
L277:   dup 
L278:   invokespecial [34] 
L281:   ldc [13] 
L283:   invokevirtual [26] 
L286:   iload_1 
L287:   invokevirtual [27] 
L290:   invokevirtual [28] 
L293:   invokespecial [35] 
L296:   athrow 
L297:   goto L342 
L300:   astore 4 
L302:   new [46] 
L305:   dup 
L306:   new [47] 
L309:   dup 
L310:   invokespecial [34] 
L313:   ldc [15] 
L315:   invokevirtual [26] 
L318:   iload_1 
L319:   invokevirtual [27] 
L322:   ldc [16] 
L324:   invokevirtual [26] 
L327:   aload 4 
L329:   invokevirtual [29] 
L332:   invokevirtual [26] 
L335:   invokevirtual [28] 
L338:   invokespecial [35] 
L341:   athrow 
L342:   return 
L343:   nop 
L344:   
    .end code 
.end method 

.method static [217] : [218] 
    .attribute [208] .code stack 1 locals 0 
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
.const [2] = Class [48] 
.const [3] = String [49] 
.const [4] = Method [50] [51] 
.const [5] = String [52] 
.const [6] = String [53] 
.const [7] = Field [54] [55] 
.const [8] = Field [56] [57] 
.const [9] = Method [58] [59] 
.const [10] = Method [60] [61] 
.const [11] = Class [62] 
.const [12] = Class [63] 
.const [13] = String [64] 
.const [14] = Class [65] 
.const [15] = String [66] 
.const [16] = String [67] 
.const [17] = String [68] 
.const [18] = Method [69] [70] 
.const [19] = Class [71] 
.const [20] = Class [72] 
.const [21] = Class [73] 
.const [22] = Class [74] 
.const [23] = Class [75] 
.const [24] = Class [76] 
.const [25] = Field [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Field [91] [92] 
.const [33] = Field [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Method [97] [98] 
.const [36] = Class [99] 
.const [37] = Field [100] [101] 
.const [38] = InterfaceMethod [102] [103] 
.const [39] = InterfaceMethod [104] [105] 
.const [40] = InterfaceMethod [106] [107] 
.const [41] = InterfaceMethod [108] [109] 
.const [42] = InterfaceMethod [110] [111] 
.const [43] = InterfaceMethod [112] [113] 
.const [44] = InterfaceMethod [114] [115] 
.const [45] = InterfaceMethod [116] [117] 
.const [46] = Class [118] 
.const [47] = Class [119] 
.const [48] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [49] = Utf8 '9e6ce532-4a34-5e70-9afe-46d5debc1126' 
.const [50] = Class [120] 
.const [51] = NameAndType [121] [122] 
.const [52] = Utf8 '5c1eb755-beb0-51c7-b069-79b0037789b9' 
.const [53] = Utf8 'dsi.travelguide.DSITravelGuide' 
.const [54] = Class [123] 
.const [55] = NameAndType [124] [125] 
.const [56] = Class [126] 
.const [57] = NameAndType [127] [128] 
.const [58] = Class [129] 
.const [59] = NameAndType [130] [131] 
.const [60] = Class [132] 
.const [61] = NameAndType [133] [134] 
.const [62] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Utf8 'Invalid Method Id ' 
.const [65] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [66] = Utf8 'Deserialization failed: method=' 
.const [67] = Utf8 ', error=' 
.const [68] = Utf8 'STUB.dsi.travelguide.DSITravelGuide' 
.const [69] = Class [135] 
.const [70] = NameAndType [136] [137] 
.const [71] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/DSITravelGuideReplyService 
.const [72] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [73] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [74] = Utf8 de/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply 
.const [75] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/TravelGuideMemoryListElementSerializer 
.const [76] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [77] = Class [138] 
.const [78] = NameAndType [139] [140] 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Class [147] 
.const [84] = NameAndType [148] [149] 
.const [85] = Class [150] 
.const [86] = NameAndType [151] [152] 
.const [87] = Class [153] 
.const [88] = NameAndType [154] [155] 
.const [89] = Class [156] 
.const [90] = NameAndType [157] [158] 
.const [91] = Class [159] 
.const [92] = NameAndType [160] [161] 
.const [93] = Class [162] 
.const [94] = NameAndType [163] [164] 
.const [95] = Class [165] 
.const [96] = NameAndType [166] [167] 
.const [97] = Class [168] 
.const [98] = NameAndType [169] [170] 
.const [99] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [100] = Class [171] 
.const [101] = NameAndType [172] [173] 
.const [102] = Class [174] 
.const [103] = NameAndType [175] [176] 
.const [104] = Class [177] 
.const [105] = NameAndType [178] [179] 
.const [106] = Class [180] 
.const [107] = NameAndType [181] [182] 
.const [108] = Class [183] 
.const [109] = NameAndType [184] [185] 
.const [110] = Class [186] 
.const [111] = NameAndType [187] [188] 
.const [112] = Class [189] 
.const [113] = NameAndType [190] [191] 
.const [114] = Class [192] 
.const [115] = NameAndType [193] [194] 
.const [116] = Class [195] 
.const [117] = NameAndType [196] [197] 
.const [118] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [119] = Utf8 java/lang/StringBuffer 
.const [120] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/DSITravelGuideReplyService 
.const [121] = Utf8 nextDynamicHandle 
.const [122] = Utf8 ()I 
.const [123] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/DSITravelGuideReplyService 
.const [124] = Utf8 dynamicHandle 
.const [125] = Utf8 I 
.const [126] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/DSITravelGuideReplyService 
.const [127] = Utf8 context 
.const [128] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [129] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/TravelGuideMemoryListElementSerializer 
.const [130] = Utf8 getOptionalTravelGuideMemoryListElement 
.const [131] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/travelguide/TravelGuideMemoryListElement; 
.const [132] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/TravelGuideMemoryListElementSerializer 
.const [133] = Utf8 getOptionalTravelGuideMemoryListElementVarArray 
.const [134] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/travelguide/TravelGuideMemoryListElement; 
.const [135] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [136] = Utf8 getContext 
.const [137] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [138] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/DSITravelGuideReplyService 
.const [139] = Utf8 p_DSITravelGuideReply 
.const [140] = Utf8 Lde/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply; 
.const [141] = Utf8 java/lang/StringBuffer 
.const [142] = Utf8 append 
.const [143] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [144] = Utf8 java/lang/StringBuffer 
.const [145] = Utf8 append 
.const [146] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [147] = Utf8 java/lang/StringBuffer 
.const [148] = Utf8 toString 
.const [149] = Utf8 ()Ljava/lang/String; 
.const [150] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [151] = Utf8 getMessage 
.const [152] = Utf8 ()Ljava/lang/String; 
.const [153] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [154] = Utf8 <init> 
.const [155] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [156] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [159] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/DSITravelGuideReplyService 
.const [160] = Utf8 dynamicHandle 
.const [161] = Utf8 I 
.const [162] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/DSITravelGuideReplyService 
.const [163] = Utf8 context 
.const [164] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [165] = Utf8 java/lang/StringBuffer 
.const [166] = Utf8 <init> 
.const [167] = Utf8 ()V 
.const [168] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Ljava/lang/String;)V 
.const [171] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/DSITravelGuideReplyService 
.const [172] = Utf8 p_DSITravelGuideReply 
.const [173] = Utf8 Lde/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply; 
.const [174] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [175] = Utf8 getInt32 
.const [176] = Utf8 ()I 
.const [177] = Utf8 de/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply 
.const [178] = Utf8 importTravelGuideResult 
.const [179] = Utf8 (II)V 
.const [180] = Utf8 de/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply 
.const [181] = Utf8 updateTravelGuideMemoryListElement 
.const [182] = Utf8 (Lorg/dsi/ifc/travelguide/TravelGuideMemoryListElement;II)V 
.const [183] = Utf8 de/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply 
.const [184] = Utf8 deleteTravelGuideResult 
.const [185] = Utf8 (I)V 
.const [186] = Utf8 de/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply 
.const [187] = Utf8 updateTravelGuideMemoryList 
.const [188] = Utf8 ([Lorg/dsi/ifc/travelguide/TravelGuideMemoryListElement;I)V 
.const [189] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [190] = Utf8 getOptionalString 
.const [191] = Utf8 ()Ljava/lang/String; 
.const [192] = Utf8 de/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply 
.const [193] = Utf8 asyncException 
.const [194] = Utf8 (ILjava/lang/String;I)V 
.const [195] = Utf8 de/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply 
.const [196] = Utf8 yyIndication 
.const [197] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [198] = Utf8 de/esolutions/fw/comm/dsi/travelguide/impl/DSITravelGuideReplyService 
.const [199] = Class [198] 
.const [200] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [201] = Class [200] 
.const [202] = Utf8 context 
.const [203] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [204] = Utf8 dynamicHandle 
.const [205] = Utf8 I 
.const [206] = Utf8 p_DSITravelGuideReply 
.const [207] = Utf8 Lde/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply; 
.const [208] = Utf8 Code 
.const [209] = Utf8 <init> 
.const [210] = Utf8 (Lde/esolutions/fw/comm/dsi/travelguide/DSITravelGuideReply;)V 
.const [211] = Utf8 nextDynamicHandle 
.const [212] = Utf8 ()I 
.const [213] = Utf8 getCallContext 
.const [214] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [215] = Utf8 handleCallMethod 
.const [216] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [217] = Utf8 <clinit> 
.const [218] = Utf8 ()V 
.end class 
