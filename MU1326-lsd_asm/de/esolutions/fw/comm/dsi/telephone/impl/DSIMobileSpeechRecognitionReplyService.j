.version 50 0 
.class public super [191] 
.super [193] 
.field private static final [194] [195] 
.field private static [196] [197] 
.field private [198] [199] 

.method public [201] : [202] 
    .attribute [200] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [33] 
L4:     dup 
L5:     ldc [3] 
L7:     invokestatic [4] 
L10:    ldc [5] 
L12:    ldc [6] 
L14:    invokespecial [27] 
L17:    invokespecial [28] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [34] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static synchronized [203] : [204] 
    .attribute [200] .code stack 2 locals 1 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     iadd 
L5:     dup 
L6:     putstatic [29] 
L9:     istore_0 
L10:    iload_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [200] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [200] .code stack 4 locals 3 
        .catch [12] from L0 to L321 using L324 
L0:     iload_1 
L1:     tableswitch 0 
            L220 
            L294 
            L294 
            L294 
            L294 
            L176 
            L294 
            L294 
            L294 
            L112 
            L80 
            L262 
            L294 
            L294 
            L198 
            L144 
            default : L294 

L80:    aload_2 
L81:    invokeinterface [35] 0 
L86:    istore 4 
L88:    aload_2 
L89:    invokeinterface [35] 0 
L94:    istore 5 
L96:    aload_0 
L97:    getfield [22] 
L100:   iload 4 
L102:   iload 5 
L104:   invokeinterface [36] 0 
L109:   goto L321 
L112:   aload_2 
L113:   invokeinterface [35] 0 
L118:   istore 4 
L120:   aload_2 
L121:   invokeinterface [35] 0 
L126:   istore 5 
L128:   aload_0 
L129:   getfield [22] 
L132:   iload 4 
L134:   iload 5 
L136:   invokeinterface [37] 0 
L141:   goto L321 
L144:   aload_2 
L145:   invokeinterface [35] 0 
L150:   istore 4 
L152:   aload_2 
L153:   invokeinterface [35] 0 
L158:   istore 5 
L160:   aload_0 
L161:   getfield [22] 
L164:   iload 4 
L166:   iload 5 
L168:   invokeinterface [38] 0 
L173:   goto L321 
L176:   aload_2 
L177:   invokeinterface [35] 0 
L182:   istore 4 
L184:   aload_0 
L185:   getfield [22] 
L188:   iload 4 
L190:   invokeinterface [39] 0 
L195:   goto L321 
L198:   aload_2 
L199:   invokeinterface [35] 0 
L204:   istore 4 
L206:   aload_0 
L207:   getfield [22] 
L210:   iload 4 
L212:   invokeinterface [40] 0 
L217:   goto L321 
L220:   aload_2 
L221:   invokeinterface [35] 0 
L226:   istore 4 
L228:   aload_2 
L229:   invokeinterface [41] 0 
L234:   astore 5 
L236:   aload_2 
L237:   invokeinterface [35] 0 
L242:   istore 6 
L244:   aload_0 
L245:   getfield [22] 
L248:   iload 4 
L250:   aload 5 
L252:   iload 6 
L254:   invokeinterface [42] 0 
L259:   goto L321 
L262:   aload_2 
L263:   invokeinterface [41] 0 
L268:   astore 4 
L270:   aload_2 
L271:   invokeinterface [41] 0 
L276:   astore 5 
L278:   aload_0 
L279:   getfield [22] 
L282:   aload 4 
L284:   aload 5 
L286:   invokeinterface [43] 0 
L291:   goto L321 
L294:   new [44] 
L297:   dup 
L298:   new [45] 
L301:   dup 
L302:   invokespecial [31] 
L305:   ldc [11] 
L307:   invokevirtual [23] 
L310:   iload_1 
L311:   invokevirtual [24] 
L314:   invokevirtual [25] 
L317:   invokespecial [32] 
L320:   athrow 
L321:   goto L366 
L324:   astore 4 
L326:   new [44] 
L329:   dup 
L330:   new [45] 
L333:   dup 
L334:   invokespecial [31] 
L337:   ldc [13] 
L339:   invokevirtual [23] 
L342:   iload_1 
L343:   invokevirtual [24] 
L346:   ldc [14] 
L348:   invokevirtual [23] 
L351:   aload 4 
L353:   invokevirtual [26] 
L356:   invokevirtual [23] 
L359:   invokevirtual [25] 
L362:   invokespecial [32] 
L365:   athrow 
L366:   return 
L367:   nop 
L368:   
    .end code 
.end method 

.method static [209] : [210] 
    .attribute [200] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [30] 
L8:     iconst_0 
L9:     putstatic [29] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = String [47] 
.const [4] = Method [48] [49] 
.const [5] = String [50] 
.const [6] = String [51] 
.const [7] = Field [52] [53] 
.const [8] = Field [54] [55] 
.const [9] = Class [56] 
.const [10] = Class [57] 
.const [11] = String [58] 
.const [12] = Class [59] 
.const [13] = String [60] 
.const [14] = String [61] 
.const [15] = String [62] 
.const [16] = Method [63] [64] 
.const [17] = Class [65] 
.const [18] = Class [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Class [69] 
.const [22] = Field [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Field [84] [85] 
.const [30] = Field [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Class [92] 
.const [34] = Field [93] [94] 
.const [35] = InterfaceMethod [95] [96] 
.const [36] = InterfaceMethod [97] [98] 
.const [37] = InterfaceMethod [99] [100] 
.const [38] = InterfaceMethod [101] [102] 
.const [39] = InterfaceMethod [103] [104] 
.const [40] = InterfaceMethod [105] [106] 
.const [41] = InterfaceMethod [107] [108] 
.const [42] = InterfaceMethod [109] [110] 
.const [43] = InterfaceMethod [111] [112] 
.const [44] = Class [113] 
.const [45] = Class [114] 
.const [46] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [47] = Utf8 f14d948b-082d-5317-8e8d-ff2c2d47774f 
.const [48] = Class [115] 
.const [49] = NameAndType [116] [117] 
.const [50] = Utf8 '5f606b95-6f71-5c15-a794-a18890d22182' 
.const [51] = Utf8 'dsi.telephone.DSIMobileSpeechRecognition' 
.const [52] = Class [118] 
.const [53] = NameAndType [119] [120] 
.const [54] = Class [121] 
.const [55] = NameAndType [122] [123] 
.const [56] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [57] = Utf8 java/lang/StringBuffer 
.const [58] = Utf8 'Invalid Method Id ' 
.const [59] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [60] = Utf8 'Deserialization failed: method=' 
.const [61] = Utf8 ', error=' 
.const [62] = Utf8 'STUB.dsi.telephone.DSIMobileSpeechRecognition' 
.const [63] = Class [124] 
.const [64] = NameAndType [125] [126] 
.const [65] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSIMobileSpeechRecognitionReplyService 
.const [66] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [67] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [68] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply 
.const [69] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [70] = Class [127] 
.const [71] = NameAndType [128] [129] 
.const [72] = Class [130] 
.const [73] = NameAndType [131] [132] 
.const [74] = Class [133] 
.const [75] = NameAndType [134] [135] 
.const [76] = Class [136] 
.const [77] = NameAndType [137] [138] 
.const [78] = Class [139] 
.const [79] = NameAndType [140] [141] 
.const [80] = Class [142] 
.const [81] = NameAndType [143] [144] 
.const [82] = Class [145] 
.const [83] = NameAndType [146] [147] 
.const [84] = Class [148] 
.const [85] = NameAndType [149] [150] 
.const [86] = Class [151] 
.const [87] = NameAndType [152] [153] 
.const [88] = Class [154] 
.const [89] = NameAndType [155] [156] 
.const [90] = Class [157] 
.const [91] = NameAndType [158] [159] 
.const [92] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [93] = Class [160] 
.const [94] = NameAndType [161] [162] 
.const [95] = Class [163] 
.const [96] = NameAndType [164] [165] 
.const [97] = Class [166] 
.const [98] = NameAndType [167] [168] 
.const [99] = Class [169] 
.const [100] = NameAndType [170] [171] 
.const [101] = Class [172] 
.const [102] = NameAndType [173] [174] 
.const [103] = Class [175] 
.const [104] = NameAndType [176] [177] 
.const [105] = Class [178] 
.const [106] = NameAndType [179] [180] 
.const [107] = Class [181] 
.const [108] = NameAndType [182] [183] 
.const [109] = Class [184] 
.const [110] = NameAndType [185] [186] 
.const [111] = Class [187] 
.const [112] = NameAndType [188] [189] 
.const [113] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSIMobileSpeechRecognitionReplyService 
.const [116] = Utf8 nextDynamicHandle 
.const [117] = Utf8 ()I 
.const [118] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSIMobileSpeechRecognitionReplyService 
.const [119] = Utf8 dynamicHandle 
.const [120] = Utf8 I 
.const [121] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSIMobileSpeechRecognitionReplyService 
.const [122] = Utf8 context 
.const [123] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [124] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [125] = Utf8 getContext 
.const [126] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [127] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSIMobileSpeechRecognitionReplyService 
.const [128] = Utf8 p_DSIMobileSpeechRecognitionReply 
.const [129] = Utf8 Lde/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply; 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Utf8 append 
.const [132] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [133] = Utf8 java/lang/StringBuffer 
.const [134] = Utf8 append 
.const [135] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 toString 
.const [138] = Utf8 ()Ljava/lang/String; 
.const [139] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [140] = Utf8 getMessage 
.const [141] = Utf8 ()Ljava/lang/String; 
.const [142] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [145] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [148] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSIMobileSpeechRecognitionReplyService 
.const [149] = Utf8 dynamicHandle 
.const [150] = Utf8 I 
.const [151] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSIMobileSpeechRecognitionReplyService 
.const [152] = Utf8 context 
.const [153] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [158] = Utf8 <init> 
.const [159] = Utf8 (Ljava/lang/String;)V 
.const [160] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSIMobileSpeechRecognitionReplyService 
.const [161] = Utf8 p_DSIMobileSpeechRecognitionReply 
.const [162] = Utf8 Lde/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply; 
.const [163] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [164] = Utf8 getInt32 
.const [165] = Utf8 ()I 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply 
.const [167] = Utf8 updateSpeechRecognitionAvailable 
.const [168] = Utf8 (II)V 
.const [169] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply 
.const [170] = Utf8 updateSpeechRecognitionActive 
.const [171] = Utf8 (II)V 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply 
.const [173] = Utf8 updateSpeechRecognitionType 
.const [174] = Utf8 (II)V 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply 
.const [176] = Utf8 responseStartSpeechRecognition 
.const [177] = Utf8 (I)V 
.const [178] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply 
.const [179] = Utf8 responseStopSpeechRecognition 
.const [180] = Utf8 (I)V 
.const [181] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [182] = Utf8 getOptionalString 
.const [183] = Utf8 ()Ljava/lang/String; 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply 
.const [185] = Utf8 asyncException 
.const [186] = Utf8 (ILjava/lang/String;I)V 
.const [187] = Utf8 de/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply 
.const [188] = Utf8 yyIndication 
.const [189] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/telephone/impl/DSIMobileSpeechRecognitionReplyService 
.const [191] = Class [190] 
.const [192] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [193] = Class [192] 
.const [194] = Utf8 context 
.const [195] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [196] = Utf8 dynamicHandle 
.const [197] = Utf8 I 
.const [198] = Utf8 p_DSIMobileSpeechRecognitionReply 
.const [199] = Utf8 Lde/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply; 
.const [200] = Utf8 Code 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Lde/esolutions/fw/comm/dsi/telephone/DSIMobileSpeechRecognitionReply;)V 
.const [203] = Utf8 nextDynamicHandle 
.const [204] = Utf8 ()I 
.const [205] = Utf8 getCallContext 
.const [206] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [207] = Utf8 handleCallMethod 
.const [208] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [209] = Utf8 <clinit> 
.const [210] = Utf8 ()V 
.end class 
