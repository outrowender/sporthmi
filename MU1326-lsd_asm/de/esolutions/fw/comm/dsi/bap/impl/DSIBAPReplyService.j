.version 50 0 
.class public super [203] 
.super [205] 
.field private static final [206] [207] 
.field private static [208] [209] 
.field private [210] [211] 

.method public [213] : [214] 
    .attribute [212] .code stack 7 locals 0 
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

.method private static synchronized [215] : [216] 
    .attribute [212] .code stack 2 locals 1 
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

.method public [217] : [218] 
    .attribute [212] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [212] .code stack 6 locals 5 
        .catch [12] from L0 to L469 using L472 
L0:     iload_1 
L1:     tableswitch 0 
            L326 
            L368 
            L96 
            L442 
            L442 
            L442 
            L442 
            L128 
            L232 
            L284 
            L190 
            L442 
            L442 
            L442 
            L442 
            L442 
            L442 
            L442 
            L442 
            L410 
            default : L442 

L96:    aload_2 
L97:    invokeinterface [35] 0 
L102:   istore 4 
L104:   aload_2 
L105:   invokeinterface [35] 0 
L110:   istore 5 
L112:   aload_0 
L113:   getfield [22] 
L116:   iload 4 
L118:   iload 5 
L120:   invokeinterface [36] 0 
L125:   goto L469 
L128:   aload_2 
L129:   invokeinterface [35] 0 
L134:   istore 4 
L136:   aload_2 
L137:   invokeinterface [35] 0 
L142:   istore 5 
L144:   aload_2 
L145:   invokeinterface [35] 0 
L150:   istore 6 
L152:   aload_2 
L153:   invokeinterface [35] 0 
L158:   istore 7 
L160:   aload_2 
L161:   invokeinterface [35] 0 
L166:   istore 8 
L168:   aload_0 
L169:   getfield [22] 
L172:   iload 4 
L174:   iload 5 
L176:   iload 6 
L178:   iload 7 
L180:   iload 8 
L182:   invokeinterface [37] 0 
L187:   goto L469 
L190:   aload_2 
L191:   invokeinterface [35] 0 
L196:   istore 4 
L198:   aload_2 
L199:   invokeinterface [35] 0 
L204:   istore 5 
L206:   aload_2 
L207:   invokeinterface [35] 0 
L212:   istore 6 
L214:   aload_0 
L215:   getfield [22] 
L218:   iload 4 
L220:   iload 5 
L222:   iload 6 
L224:   invokeinterface [38] 0 
L229:   goto L469 
L232:   aload_2 
L233:   invokeinterface [35] 0 
L238:   istore 4 
L240:   aload_2 
L241:   invokeinterface [35] 0 
L246:   istore 5 
L248:   aload_2 
L249:   invokeinterface [35] 0 
L254:   istore 6 
L256:   aload_2 
L257:   invokeinterface [39] 0 
L262:   astore 7 
L264:   aload_0 
L265:   getfield [22] 
L268:   iload 4 
L270:   iload 5 
L272:   iload 6 
L274:   aload 7 
L276:   invokeinterface [40] 0 
L281:   goto L469 
L284:   aload_2 
L285:   invokeinterface [35] 0 
L290:   istore 4 
L292:   aload_2 
L293:   invokeinterface [35] 0 
L298:   istore 5 
L300:   aload_2 
L301:   invokeinterface [35] 0 
L306:   istore 6 
L308:   aload_0 
L309:   getfield [22] 
L312:   iload 4 
L314:   iload 5 
L316:   iload 6 
L318:   invokeinterface [41] 0 
L323:   goto L469 
L326:   aload_2 
L327:   invokeinterface [35] 0 
L332:   istore 4 
L334:   aload_2 
L335:   invokeinterface [35] 0 
L340:   istore 5 
L342:   aload_2 
L343:   invokeinterface [35] 0 
L348:   istore 6 
L350:   aload_0 
L351:   getfield [22] 
L354:   iload 4 
L356:   iload 5 
L358:   iload 6 
L360:   invokeinterface [42] 0 
L365:   goto L469 
L368:   aload_2 
L369:   invokeinterface [35] 0 
L374:   istore 4 
L376:   aload_2 
L377:   invokeinterface [43] 0 
L382:   astore 5 
L384:   aload_2 
L385:   invokeinterface [35] 0 
L390:   istore 6 
L392:   aload_0 
L393:   getfield [22] 
L396:   iload 4 
L398:   aload 5 
L400:   iload 6 
L402:   invokeinterface [44] 0 
L407:   goto L469 
L410:   aload_2 
L411:   invokeinterface [43] 0 
L416:   astore 4 
L418:   aload_2 
L419:   invokeinterface [43] 0 
L424:   astore 5 
L426:   aload_0 
L427:   getfield [22] 
L430:   aload 4 
L432:   aload 5 
L434:   invokeinterface [45] 0 
L439:   goto L469 
L442:   new [46] 
L445:   dup 
L446:   new [47] 
L449:   dup 
L450:   invokespecial [31] 
L453:   ldc [11] 
L455:   invokevirtual [23] 
L458:   iload_1 
L459:   invokevirtual [24] 
L462:   invokevirtual [25] 
L465:   invokespecial [32] 
L468:   athrow 
L469:   goto L514 
L472:   astore 4 
L474:   new [46] 
L477:   dup 
L478:   new [47] 
L481:   dup 
L482:   invokespecial [31] 
L485:   ldc [13] 
L487:   invokevirtual [23] 
L490:   iload_1 
L491:   invokevirtual [24] 
L494:   ldc [14] 
L496:   invokevirtual [23] 
L499:   aload 4 
L501:   invokevirtual [26] 
L504:   invokevirtual [23] 
L507:   invokevirtual [25] 
L510:   invokespecial [32] 
L513:   athrow 
L514:   return 
L515:   nop 
L516:   
    .end code 
.end method 

.method static [221] : [222] 
    .attribute [212] .code stack 1 locals 0 
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
.const [2] = Class [48] 
.const [3] = String [49] 
.const [4] = Method [50] [51] 
.const [5] = String [52] 
.const [6] = String [53] 
.const [7] = Field [54] [55] 
.const [8] = Field [56] [57] 
.const [9] = Class [58] 
.const [10] = Class [59] 
.const [11] = String [60] 
.const [12] = Class [61] 
.const [13] = String [62] 
.const [14] = String [63] 
.const [15] = String [64] 
.const [16] = Method [65] [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = Class [69] 
.const [20] = Class [70] 
.const [21] = Class [71] 
.const [22] = Field [72] [73] 
.const [23] = Method [74] [75] 
.const [24] = Method [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Method [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Field [86] [87] 
.const [30] = Field [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Class [94] 
.const [34] = Field [95] [96] 
.const [35] = InterfaceMethod [97] [98] 
.const [36] = InterfaceMethod [99] [100] 
.const [37] = InterfaceMethod [101] [102] 
.const [38] = InterfaceMethod [103] [104] 
.const [39] = InterfaceMethod [105] [106] 
.const [40] = InterfaceMethod [107] [108] 
.const [41] = InterfaceMethod [109] [110] 
.const [42] = InterfaceMethod [111] [112] 
.const [43] = InterfaceMethod [113] [114] 
.const [44] = InterfaceMethod [115] [116] 
.const [45] = InterfaceMethod [117] [118] 
.const [46] = Class [119] 
.const [47] = Class [120] 
.const [48] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [49] = Utf8 '187b8dba-bafe-54d9-bd32-ccc4dc6d16c7' 
.const [50] = Class [121] 
.const [51] = NameAndType [122] [123] 
.const [52] = Utf8 e99f0395-02b6-5a98-9d51-8714b5fcad80 
.const [53] = Utf8 'dsi.bap.DSIBAP' 
.const [54] = Class [124] 
.const [55] = NameAndType [125] [126] 
.const [56] = Class [127] 
.const [57] = NameAndType [128] [129] 
.const [58] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [59] = Utf8 java/lang/StringBuffer 
.const [60] = Utf8 'Invalid Method Id ' 
.const [61] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [62] = Utf8 'Deserialization failed: method=' 
.const [63] = Utf8 ', error=' 
.const [64] = Utf8 'STUB.dsi.bap.DSIBAP' 
.const [65] = Class [130] 
.const [66] = NameAndType [131] [132] 
.const [67] = Utf8 de/esolutions/fw/comm/dsi/bap/impl/DSIBAPReplyService 
.const [68] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [69] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/bap/DSIBAPReply 
.const [71] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [72] = Class [133] 
.const [73] = NameAndType [134] [135] 
.const [74] = Class [136] 
.const [75] = NameAndType [137] [138] 
.const [76] = Class [139] 
.const [77] = NameAndType [140] [141] 
.const [78] = Class [142] 
.const [79] = NameAndType [143] [144] 
.const [80] = Class [145] 
.const [81] = NameAndType [146] [147] 
.const [82] = Class [148] 
.const [83] = NameAndType [149] [150] 
.const [84] = Class [151] 
.const [85] = NameAndType [152] [153] 
.const [86] = Class [154] 
.const [87] = NameAndType [155] [156] 
.const [88] = Class [157] 
.const [89] = NameAndType [158] [159] 
.const [90] = Class [160] 
.const [91] = NameAndType [161] [162] 
.const [92] = Class [163] 
.const [93] = NameAndType [164] [165] 
.const [94] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
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
.const [107] = Class [184] 
.const [108] = NameAndType [185] [186] 
.const [109] = Class [187] 
.const [110] = NameAndType [188] [189] 
.const [111] = Class [190] 
.const [112] = NameAndType [191] [192] 
.const [113] = Class [193] 
.const [114] = NameAndType [194] [195] 
.const [115] = Class [196] 
.const [116] = NameAndType [197] [198] 
.const [117] = Class [199] 
.const [118] = NameAndType [200] [201] 
.const [119] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [120] = Utf8 java/lang/StringBuffer 
.const [121] = Utf8 de/esolutions/fw/comm/dsi/bap/impl/DSIBAPReplyService 
.const [122] = Utf8 nextDynamicHandle 
.const [123] = Utf8 ()I 
.const [124] = Utf8 de/esolutions/fw/comm/dsi/bap/impl/DSIBAPReplyService 
.const [125] = Utf8 dynamicHandle 
.const [126] = Utf8 I 
.const [127] = Utf8 de/esolutions/fw/comm/dsi/bap/impl/DSIBAPReplyService 
.const [128] = Utf8 context 
.const [129] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [130] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [131] = Utf8 getContext 
.const [132] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [133] = Utf8 de/esolutions/fw/comm/dsi/bap/impl/DSIBAPReplyService 
.const [134] = Utf8 p_DSIBAPReply 
.const [135] = Utf8 Lde/esolutions/fw/comm/dsi/bap/DSIBAPReply; 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 append 
.const [138] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [139] = Utf8 java/lang/StringBuffer 
.const [140] = Utf8 append 
.const [141] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [142] = Utf8 java/lang/StringBuffer 
.const [143] = Utf8 toString 
.const [144] = Utf8 ()Ljava/lang/String; 
.const [145] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [146] = Utf8 getMessage 
.const [147] = Utf8 ()Ljava/lang/String; 
.const [148] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [151] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [154] = Utf8 de/esolutions/fw/comm/dsi/bap/impl/DSIBAPReplyService 
.const [155] = Utf8 dynamicHandle 
.const [156] = Utf8 I 
.const [157] = Utf8 de/esolutions/fw/comm/dsi/bap/impl/DSIBAPReplyService 
.const [158] = Utf8 context 
.const [159] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [160] = Utf8 java/lang/StringBuffer 
.const [161] = Utf8 <init> 
.const [162] = Utf8 ()V 
.const [163] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [164] = Utf8 <init> 
.const [165] = Utf8 (Ljava/lang/String;)V 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/bap/impl/DSIBAPReplyService 
.const [167] = Utf8 p_DSIBAPReply 
.const [168] = Utf8 Lde/esolutions/fw/comm/dsi/bap/DSIBAPReply; 
.const [169] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [170] = Utf8 getInt32 
.const [171] = Utf8 ()I 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/bap/DSIBAPReply 
.const [173] = Utf8 bapStateStatus 
.const [174] = Utf8 (II)V 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/bap/DSIBAPReply 
.const [176] = Utf8 indication 
.const [177] = Utf8 (IIIII)V 
.const [178] = Utf8 de/esolutions/fw/comm/dsi/bap/DSIBAPReply 
.const [179] = Utf8 indicationVoid 
.const [180] = Utf8 (III)V 
.const [181] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [182] = Utf8 getOptionalInt8VarArray 
.const [183] = Utf8 ()[B 
.const [184] = Utf8 de/esolutions/fw/comm/dsi/bap/DSIBAPReply 
.const [185] = Utf8 indicationByteSequence 
.const [186] = Utf8 (III[B)V 
.const [187] = Utf8 de/esolutions/fw/comm/dsi/bap/DSIBAPReply 
.const [188] = Utf8 indicationError 
.const [189] = Utf8 (III)V 
.const [190] = Utf8 de/esolutions/fw/comm/dsi/bap/DSIBAPReply 
.const [191] = Utf8 acknowledge 
.const [192] = Utf8 (III)V 
.const [193] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [194] = Utf8 getOptionalString 
.const [195] = Utf8 ()Ljava/lang/String; 
.const [196] = Utf8 de/esolutions/fw/comm/dsi/bap/DSIBAPReply 
.const [197] = Utf8 asyncException 
.const [198] = Utf8 (ILjava/lang/String;I)V 
.const [199] = Utf8 de/esolutions/fw/comm/dsi/bap/DSIBAPReply 
.const [200] = Utf8 yyIndication 
.const [201] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [202] = Utf8 de/esolutions/fw/comm/dsi/bap/impl/DSIBAPReplyService 
.const [203] = Class [202] 
.const [204] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [205] = Class [204] 
.const [206] = Utf8 context 
.const [207] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [208] = Utf8 dynamicHandle 
.const [209] = Utf8 I 
.const [210] = Utf8 p_DSIBAPReply 
.const [211] = Utf8 Lde/esolutions/fw/comm/dsi/bap/DSIBAPReply; 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (Lde/esolutions/fw/comm/dsi/bap/DSIBAPReply;)V 
.const [215] = Utf8 nextDynamicHandle 
.const [216] = Utf8 ()I 
.const [217] = Utf8 getCallContext 
.const [218] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [219] = Utf8 handleCallMethod 
.const [220] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [221] = Utf8 <clinit> 
.const [222] = Utf8 ()V 
.end class 
