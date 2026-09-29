.version 50 0 
.class public super [197] 
.super [199] 
.field private static final [200] [201] 
.field private static [202] [203] 
.field private [204] [205] 

.method public [207] : [208] 
    .attribute [206] .code stack 7 locals 0 
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

.method private static synchronized [209] : [210] 
    .attribute [206] .code stack 2 locals 1 
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

.method public [211] : [212] 
    .attribute [206] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [206] .code stack 4 locals 3 
        .catch [12] from L0 to L355 using L358 
L0:     iload_1 
L1:     tableswitch 0 
            L254 
            L328 
            L328 
            L328 
            L328 
            L328 
            L328 
            L328 
            L178 
            L232 
            L92 
            L328 
            L328 
            L328 
            L328 
            L146 
            L200 
            L114 
            L296 
            default : L328 

L92:    aload_2 
L93:    invokeinterface [35] 0 
L98:    istore 4 
L100:   aload_0 
L101:   getfield [22] 
L104:   iload 4 
L106:   invokeinterface [36] 0 
L111:   goto L355 
L114:   aload_2 
L115:   invokeinterface [35] 0 
L120:   istore 4 
L122:   aload_2 
L123:   invokeinterface [35] 0 
L128:   istore 5 
L130:   aload_0 
L131:   getfield [22] 
L134:   iload 4 
L136:   iload 5 
L138:   invokeinterface [37] 0 
L143:   goto L355 
L146:   aload_2 
L147:   invokeinterface [35] 0 
L152:   istore 4 
L154:   aload_2 
L155:   invokeinterface [35] 0 
L160:   istore 5 
L162:   aload_0 
L163:   getfield [22] 
L166:   iload 4 
L168:   iload 5 
L170:   invokeinterface [38] 0 
L175:   goto L355 
L178:   aload_2 
L179:   invokeinterface [35] 0 
L184:   istore 4 
L186:   aload_0 
L187:   getfield [22] 
L190:   iload 4 
L192:   invokeinterface [39] 0 
L197:   goto L355 
L200:   aload_2 
L201:   invokeinterface [35] 0 
L206:   istore 4 
L208:   aload_2 
L209:   invokeinterface [35] 0 
L214:   istore 5 
L216:   aload_0 
L217:   getfield [22] 
L220:   iload 4 
L222:   iload 5 
L224:   invokeinterface [40] 0 
L229:   goto L355 
L232:   aload_2 
L233:   invokeinterface [35] 0 
L238:   istore 4 
L240:   aload_0 
L241:   getfield [22] 
L244:   iload 4 
L246:   invokeinterface [41] 0 
L251:   goto L355 
L254:   aload_2 
L255:   invokeinterface [35] 0 
L260:   istore 4 
L262:   aload_2 
L263:   invokeinterface [42] 0 
L268:   astore 5 
L270:   aload_2 
L271:   invokeinterface [35] 0 
L276:   istore 6 
L278:   aload_0 
L279:   getfield [22] 
L282:   iload 4 
L284:   aload 5 
L286:   iload 6 
L288:   invokeinterface [43] 0 
L293:   goto L355 
L296:   aload_2 
L297:   invokeinterface [42] 0 
L302:   astore 4 
L304:   aload_2 
L305:   invokeinterface [42] 0 
L310:   astore 5 
L312:   aload_0 
L313:   getfield [22] 
L316:   aload 4 
L318:   aload 5 
L320:   invokeinterface [44] 0 
L325:   goto L355 
L328:   new [45] 
L331:   dup 
L332:   new [46] 
L335:   dup 
L336:   invokespecial [31] 
L339:   ldc [11] 
L341:   invokevirtual [23] 
L344:   iload_1 
L345:   invokevirtual [24] 
L348:   invokevirtual [25] 
L351:   invokespecial [32] 
L354:   athrow 
L355:   goto L400 
L358:   astore 4 
L360:   new [45] 
L363:   dup 
L364:   new [46] 
L367:   dup 
L368:   invokespecial [31] 
L371:   ldc [13] 
L373:   invokevirtual [23] 
L376:   iload_1 
L377:   invokevirtual [24] 
L380:   ldc [14] 
L382:   invokevirtual [23] 
L385:   aload 4 
L387:   invokevirtual [26] 
L390:   invokevirtual [23] 
L393:   invokevirtual [25] 
L396:   invokespecial [32] 
L399:   athrow 
L400:   return 
L401:   nop 
L402:   nop 
L403:   nop 
L404:   
    .end code 
.end method 

.method static [215] : [216] 
    .attribute [206] .code stack 1 locals 0 
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
.const [2] = Class [47] 
.const [3] = String [48] 
.const [4] = Method [49] [50] 
.const [5] = String [51] 
.const [6] = String [52] 
.const [7] = Field [53] [54] 
.const [8] = Field [55] [56] 
.const [9] = Class [57] 
.const [10] = Class [58] 
.const [11] = String [59] 
.const [12] = Class [60] 
.const [13] = String [61] 
.const [14] = String [62] 
.const [15] = String [63] 
.const [16] = Method [64] [65] 
.const [17] = Class [66] 
.const [18] = Class [67] 
.const [19] = Class [68] 
.const [20] = Class [69] 
.const [21] = Class [70] 
.const [22] = Field [71] [72] 
.const [23] = Method [73] [74] 
.const [24] = Method [75] [76] 
.const [25] = Method [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Field [85] [86] 
.const [30] = Field [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Class [93] 
.const [34] = Field [94] [95] 
.const [35] = InterfaceMethod [96] [97] 
.const [36] = InterfaceMethod [98] [99] 
.const [37] = InterfaceMethod [100] [101] 
.const [38] = InterfaceMethod [102] [103] 
.const [39] = InterfaceMethod [104] [105] 
.const [40] = InterfaceMethod [106] [107] 
.const [41] = InterfaceMethod [108] [109] 
.const [42] = InterfaceMethod [110] [111] 
.const [43] = InterfaceMethod [112] [113] 
.const [44] = InterfaceMethod [114] [115] 
.const [45] = Class [116] 
.const [46] = Class [117] 
.const [47] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [48] = Utf8 '5b093971-6a32-577c-b8c2-67ff28ae7835' 
.const [49] = Class [118] 
.const [50] = NameAndType [119] [120] 
.const [51] = Utf8 b2203730-012f-5a3b-a9d9-4e3b6fc01483 
.const [52] = Utf8 'dsi.sse.DSISSE' 
.const [53] = Class [121] 
.const [54] = NameAndType [122] [123] 
.const [55] = Class [124] 
.const [56] = NameAndType [125] [126] 
.const [57] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [58] = Utf8 java/lang/StringBuffer 
.const [59] = Utf8 'Invalid Method Id ' 
.const [60] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [61] = Utf8 'Deserialization failed: method=' 
.const [62] = Utf8 ', error=' 
.const [63] = Utf8 'STUB.dsi.sse.DSISSE' 
.const [64] = Class [127] 
.const [65] = NameAndType [128] [129] 
.const [66] = Utf8 de/esolutions/fw/comm/dsi/sse/impl/DSISSEReplyService 
.const [67] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [68] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [69] = Utf8 de/esolutions/fw/comm/dsi/sse/DSISSEReply 
.const [70] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [71] = Class [130] 
.const [72] = NameAndType [131] [132] 
.const [73] = Class [133] 
.const [74] = NameAndType [134] [135] 
.const [75] = Class [136] 
.const [76] = NameAndType [137] [138] 
.const [77] = Class [139] 
.const [78] = NameAndType [140] [141] 
.const [79] = Class [142] 
.const [80] = NameAndType [143] [144] 
.const [81] = Class [145] 
.const [82] = NameAndType [146] [147] 
.const [83] = Class [148] 
.const [84] = NameAndType [149] [150] 
.const [85] = Class [151] 
.const [86] = NameAndType [152] [153] 
.const [87] = Class [154] 
.const [88] = NameAndType [155] [156] 
.const [89] = Class [157] 
.const [90] = NameAndType [158] [159] 
.const [91] = Class [160] 
.const [92] = NameAndType [161] [162] 
.const [93] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [94] = Class [163] 
.const [95] = NameAndType [164] [165] 
.const [96] = Class [166] 
.const [97] = NameAndType [167] [168] 
.const [98] = Class [169] 
.const [99] = NameAndType [170] [171] 
.const [100] = Class [172] 
.const [101] = NameAndType [173] [174] 
.const [102] = Class [175] 
.const [103] = NameAndType [176] [177] 
.const [104] = Class [178] 
.const [105] = NameAndType [179] [180] 
.const [106] = Class [181] 
.const [107] = NameAndType [182] [183] 
.const [108] = Class [184] 
.const [109] = NameAndType [185] [186] 
.const [110] = Class [187] 
.const [111] = NameAndType [188] [189] 
.const [112] = Class [190] 
.const [113] = NameAndType [191] [192] 
.const [114] = Class [193] 
.const [115] = NameAndType [194] [195] 
.const [116] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [117] = Utf8 java/lang/StringBuffer 
.const [118] = Utf8 de/esolutions/fw/comm/dsi/sse/impl/DSISSEReplyService 
.const [119] = Utf8 nextDynamicHandle 
.const [120] = Utf8 ()I 
.const [121] = Utf8 de/esolutions/fw/comm/dsi/sse/impl/DSISSEReplyService 
.const [122] = Utf8 dynamicHandle 
.const [123] = Utf8 I 
.const [124] = Utf8 de/esolutions/fw/comm/dsi/sse/impl/DSISSEReplyService 
.const [125] = Utf8 context 
.const [126] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [127] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [128] = Utf8 getContext 
.const [129] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [130] = Utf8 de/esolutions/fw/comm/dsi/sse/impl/DSISSEReplyService 
.const [131] = Utf8 p_DSISSEReply 
.const [132] = Utf8 Lde/esolutions/fw/comm/dsi/sse/DSISSEReply; 
.const [133] = Utf8 java/lang/StringBuffer 
.const [134] = Utf8 append 
.const [135] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 append 
.const [138] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [139] = Utf8 java/lang/StringBuffer 
.const [140] = Utf8 toString 
.const [141] = Utf8 ()Ljava/lang/String; 
.const [142] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [143] = Utf8 getMessage 
.const [144] = Utf8 ()Ljava/lang/String; 
.const [145] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [148] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [151] = Utf8 de/esolutions/fw/comm/dsi/sse/impl/DSISSEReplyService 
.const [152] = Utf8 dynamicHandle 
.const [153] = Utf8 I 
.const [154] = Utf8 de/esolutions/fw/comm/dsi/sse/impl/DSISSEReplyService 
.const [155] = Utf8 context 
.const [156] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [157] = Utf8 java/lang/StringBuffer 
.const [158] = Utf8 <init> 
.const [159] = Utf8 ()V 
.const [160] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Ljava/lang/String;)V 
.const [163] = Utf8 de/esolutions/fw/comm/dsi/sse/impl/DSISSEReplyService 
.const [164] = Utf8 p_DSISSEReply 
.const [165] = Utf8 Lde/esolutions/fw/comm/dsi/sse/DSISSEReply; 
.const [166] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [167] = Utf8 getInt32 
.const [168] = Utf8 ()I 
.const [169] = Utf8 de/esolutions/fw/comm/dsi/sse/DSISSEReply 
.const [170] = Utf8 responseSetMode 
.const [171] = Utf8 (I)V 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/sse/DSISSEReply 
.const [173] = Utf8 updateMode 
.const [174] = Utf8 (II)V 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/sse/DSISSEReply 
.const [176] = Utf8 updateMicGainLevel 
.const [177] = Utf8 (II)V 
.const [178] = Utf8 de/esolutions/fw/comm/dsi/sse/DSISSEReply 
.const [179] = Utf8 responseSetMicGainLevel 
.const [180] = Utf8 (I)V 
.const [181] = Utf8 de/esolutions/fw/comm/dsi/sse/DSISSEReply 
.const [182] = Utf8 updateMicMuteState 
.const [183] = Utf8 (II)V 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/sse/DSISSEReply 
.const [185] = Utf8 responseSetMicMuteState 
.const [186] = Utf8 (I)V 
.const [187] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [188] = Utf8 getOptionalString 
.const [189] = Utf8 ()Ljava/lang/String; 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/sse/DSISSEReply 
.const [191] = Utf8 asyncException 
.const [192] = Utf8 (ILjava/lang/String;I)V 
.const [193] = Utf8 de/esolutions/fw/comm/dsi/sse/DSISSEReply 
.const [194] = Utf8 yyIndication 
.const [195] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [196] = Utf8 de/esolutions/fw/comm/dsi/sse/impl/DSISSEReplyService 
.const [197] = Class [196] 
.const [198] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [199] = Class [198] 
.const [200] = Utf8 context 
.const [201] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [202] = Utf8 dynamicHandle 
.const [203] = Utf8 I 
.const [204] = Utf8 p_DSISSEReply 
.const [205] = Utf8 Lde/esolutions/fw/comm/dsi/sse/DSISSEReply; 
.const [206] = Utf8 Code 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (Lde/esolutions/fw/comm/dsi/sse/DSISSEReply;)V 
.const [209] = Utf8 nextDynamicHandle 
.const [210] = Utf8 ()I 
.const [211] = Utf8 getCallContext 
.const [212] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [213] = Utf8 handleCallMethod 
.const [214] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [215] = Utf8 <clinit> 
.const [216] = Utf8 ()V 
.end class 
