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
        .catch [12] from L0 to L311 using L314 
L0:     iload_1 
L1:     tableswitch 0 
            L210 
            L284 
            L284 
            L284 
            L284 
            L284 
            L284 
            L284 
            L284 
            L284 
            L92 
            L124 
            L252 
            L284 
            L156 
            L284 
            L284 
            L284 
            L178 
            default : L284 

L92:    aload_2 
L93:    invokeinterface [35] 0 
L98:    istore 4 
L100:   aload_2 
L101:   invokeinterface [36] 0 
L106:   istore 5 
L108:   aload_0 
L109:   getfield [22] 
L112:   iload 4 
L114:   iload 5 
L116:   invokeinterface [37] 0 
L121:   goto L311 
L124:   aload_2 
L125:   invokeinterface [35] 0 
L130:   istore 4 
L132:   aload_2 
L133:   invokeinterface [36] 0 
L138:   istore 5 
L140:   aload_0 
L141:   getfield [22] 
L144:   iload 4 
L146:   iload 5 
L148:   invokeinterface [38] 0 
L153:   goto L311 
L156:   aload_2 
L157:   invokeinterface [36] 0 
L162:   istore 4 
L164:   aload_0 
L165:   getfield [22] 
L168:   iload 4 
L170:   invokeinterface [39] 0 
L175:   goto L311 
L178:   aload_2 
L179:   invokeinterface [36] 0 
L184:   istore 4 
L186:   aload_2 
L187:   invokeinterface [36] 0 
L192:   istore 5 
L194:   aload_0 
L195:   getfield [22] 
L198:   iload 4 
L200:   iload 5 
L202:   invokeinterface [40] 0 
L207:   goto L311 
L210:   aload_2 
L211:   invokeinterface [36] 0 
L216:   istore 4 
L218:   aload_2 
L219:   invokeinterface [41] 0 
L224:   astore 5 
L226:   aload_2 
L227:   invokeinterface [36] 0 
L232:   istore 6 
L234:   aload_0 
L235:   getfield [22] 
L238:   iload 4 
L240:   aload 5 
L242:   iload 6 
L244:   invokeinterface [42] 0 
L249:   goto L311 
L252:   aload_2 
L253:   invokeinterface [41] 0 
L258:   astore 4 
L260:   aload_2 
L261:   invokeinterface [41] 0 
L266:   astore 5 
L268:   aload_0 
L269:   getfield [22] 
L272:   aload 4 
L274:   aload 5 
L276:   invokeinterface [43] 0 
L281:   goto L311 
L284:   new [44] 
L287:   dup 
L288:   new [45] 
L291:   dup 
L292:   invokespecial [31] 
L295:   ldc [11] 
L297:   invokevirtual [23] 
L300:   iload_1 
L301:   invokevirtual [24] 
L304:   invokevirtual [25] 
L307:   invokespecial [32] 
L310:   athrow 
L311:   goto L356 
L314:   astore 4 
L316:   new [44] 
L319:   dup 
L320:   new [45] 
L323:   dup 
L324:   invokespecial [31] 
L327:   ldc [13] 
L329:   invokevirtual [23] 
L332:   iload_1 
L333:   invokevirtual [24] 
L336:   ldc [14] 
L338:   invokevirtual [23] 
L341:   aload 4 
L343:   invokevirtual [26] 
L346:   invokevirtual [23] 
L349:   invokevirtual [25] 
L352:   invokespecial [32] 
L355:   athrow 
L356:   return 
L357:   nop 
L358:   nop 
L359:   nop 
L360:   
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
.const [47] = Utf8 '413ce613-0a9a-54f6-93e9-bcc0513a92b5' 
.const [48] = Class [115] 
.const [49] = NameAndType [116] [117] 
.const [50] = Utf8 '7df44811-d014-5086-868d-506d5ebff276' 
.const [51] = Utf8 'dsi.komoview.DSIKOMOView' 
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
.const [62] = Utf8 'STUB.dsi.komoview.DSIKOMOView' 
.const [63] = Class [124] 
.const [64] = NameAndType [125] [126] 
.const [65] = Utf8 de/esolutions/fw/comm/dsi/komoview/impl/DSIKOMOViewReplyService 
.const [66] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [67] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [68] = Utf8 de/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply 
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
.const [115] = Utf8 de/esolutions/fw/comm/dsi/komoview/impl/DSIKOMOViewReplyService 
.const [116] = Utf8 nextDynamicHandle 
.const [117] = Utf8 ()I 
.const [118] = Utf8 de/esolutions/fw/comm/dsi/komoview/impl/DSIKOMOViewReplyService 
.const [119] = Utf8 dynamicHandle 
.const [120] = Utf8 I 
.const [121] = Utf8 de/esolutions/fw/comm/dsi/komoview/impl/DSIKOMOViewReplyService 
.const [122] = Utf8 context 
.const [123] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [124] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [125] = Utf8 getContext 
.const [126] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [127] = Utf8 de/esolutions/fw/comm/dsi/komoview/impl/DSIKOMOViewReplyService 
.const [128] = Utf8 p_DSIKOMOViewReply 
.const [129] = Utf8 Lde/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply; 
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
.const [148] = Utf8 de/esolutions/fw/comm/dsi/komoview/impl/DSIKOMOViewReplyService 
.const [149] = Utf8 dynamicHandle 
.const [150] = Utf8 I 
.const [151] = Utf8 de/esolutions/fw/comm/dsi/komoview/impl/DSIKOMOViewReplyService 
.const [152] = Utf8 context 
.const [153] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [158] = Utf8 <init> 
.const [159] = Utf8 (Ljava/lang/String;)V 
.const [160] = Utf8 de/esolutions/fw/comm/dsi/komoview/impl/DSIKOMOViewReplyService 
.const [161] = Utf8 p_DSIKOMOViewReply 
.const [162] = Utf8 Lde/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply; 
.const [163] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [164] = Utf8 getBool 
.const [165] = Utf8 ()Z 
.const [166] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [167] = Utf8 getInt32 
.const [168] = Utf8 ()I 
.const [169] = Utf8 de/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply 
.const [170] = Utf8 updateKomoViewEnabled 
.const [171] = Utf8 (ZI)V 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply 
.const [173] = Utf8 updateVisibility 
.const [174] = Utf8 (ZI)V 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply 
.const [176] = Utf8 komoViewResult 
.const [177] = Utf8 (I)V 
.const [178] = Utf8 de/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply 
.const [179] = Utf8 updateCurrentKomoViewType 
.const [180] = Utf8 (II)V 
.const [181] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [182] = Utf8 getOptionalString 
.const [183] = Utf8 ()Ljava/lang/String; 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply 
.const [185] = Utf8 asyncException 
.const [186] = Utf8 (ILjava/lang/String;I)V 
.const [187] = Utf8 de/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply 
.const [188] = Utf8 yyIndication 
.const [189] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/komoview/impl/DSIKOMOViewReplyService 
.const [191] = Class [190] 
.const [192] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [193] = Class [192] 
.const [194] = Utf8 context 
.const [195] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [196] = Utf8 dynamicHandle 
.const [197] = Utf8 I 
.const [198] = Utf8 p_DSIKOMOViewReply 
.const [199] = Utf8 Lde/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply; 
.const [200] = Utf8 Code 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Lde/esolutions/fw/comm/dsi/komoview/DSIKOMOViewReply;)V 
.const [203] = Utf8 nextDynamicHandle 
.const [204] = Utf8 ()I 
.const [205] = Utf8 getCallContext 
.const [206] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [207] = Utf8 handleCallMethod 
.const [208] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [209] = Utf8 <clinit> 
.const [210] = Utf8 ()V 
.end class 
