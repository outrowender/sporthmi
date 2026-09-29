.version 50 0 
.class public super [181] 
.super [183] 
.field private static final [184] [185] 
.field private static [186] [187] 
.field private [188] [189] 

.method public [191] : [192] 
    .attribute [190] .code stack 7 locals 0 
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

.method private static synchronized [193] : [194] 
    .attribute [190] .code stack 2 locals 1 
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

.method public [195] : [196] 
    .attribute [190] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [190] .code stack 5 locals 4 
        .catch [13] from L0 to L215 using L218 
L0:     iload_1 
L1:     lookupswitch 
            0 : L114 
            5 : L92 
            7 : L44 
            13 : L156 
            default : L188 

L44:    aload_2 
L45:    invokeinterface [37] 0 
L50:    istore 4 
L52:    aload_2 
L53:    invokeinterface [37] 0 
L58:    istore 5 
L60:    aload_2 
L61:    invokestatic [9] 
L64:    astore 6 
L66:    aload_2 
L67:    invokestatic [9] 
L70:    astore 7 
L72:    aload_0 
L73:    getfield [24] 
L76:    iload 4 
L78:    iload 5 
L80:    aload 6 
L82:    aload 7 
L84:    invokeinterface [38] 0 
L89:    goto L215 
L92:    aload_2 
L93:    invokeinterface [37] 0 
L98:    istore 4 
L100:   aload_0 
L101:   getfield [24] 
L104:   iload 4 
L106:   invokeinterface [39] 0 
L111:   goto L215 
L114:   aload_2 
L115:   invokeinterface [37] 0 
L120:   istore 4 
L122:   aload_2 
L123:   invokeinterface [40] 0 
L128:   astore 5 
L130:   aload_2 
L131:   invokeinterface [37] 0 
L136:   istore 6 
L138:   aload_0 
L139:   getfield [24] 
L142:   iload 4 
L144:   aload 5 
L146:   iload 6 
L148:   invokeinterface [41] 0 
L153:   goto L215 
L156:   aload_2 
L157:   invokeinterface [40] 0 
L162:   astore 4 
L164:   aload_2 
L165:   invokeinterface [40] 0 
L170:   astore 5 
L172:   aload_0 
L173:   getfield [24] 
L176:   aload 4 
L178:   aload 5 
L180:   invokeinterface [42] 0 
L185:   goto L215 
L188:   new [43] 
L191:   dup 
L192:   new [44] 
L195:   dup 
L196:   invokespecial [33] 
L199:   ldc [12] 
L201:   invokevirtual [25] 
L204:   iload_1 
L205:   invokevirtual [26] 
L208:   invokevirtual [27] 
L211:   invokespecial [34] 
L214:   athrow 
L215:   goto L260 
L218:   astore 4 
L220:   new [43] 
L223:   dup 
L224:   new [44] 
L227:   dup 
L228:   invokespecial [33] 
L231:   ldc [14] 
L233:   invokevirtual [25] 
L236:   iload_1 
L237:   invokevirtual [26] 
L240:   ldc [15] 
L242:   invokevirtual [25] 
L245:   aload 4 
L247:   invokevirtual [28] 
L250:   invokevirtual [25] 
L253:   invokevirtual [27] 
L256:   invokespecial [34] 
L259:   athrow 
L260:   return 
L261:   nop 
L262:   nop 
L263:   nop 
L264:   
    .end code 
.end method 

.method static [199] : [200] 
    .attribute [190] .code stack 1 locals 0 
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
.const [2] = Class [45] 
.const [3] = String [46] 
.const [4] = Method [47] [48] 
.const [5] = String [49] 
.const [6] = String [50] 
.const [7] = Field [51] [52] 
.const [8] = Field [53] [54] 
.const [9] = Method [55] [56] 
.const [10] = Class [57] 
.const [11] = Class [58] 
.const [12] = String [59] 
.const [13] = Class [60] 
.const [14] = String [61] 
.const [15] = String [62] 
.const [16] = String [63] 
.const [17] = Method [64] [65] 
.const [18] = Class [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Class [69] 
.const [22] = Class [70] 
.const [23] = Class [71] 
.const [24] = Field [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Field [86] [87] 
.const [32] = Field [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Class [94] 
.const [36] = Field [95] [96] 
.const [37] = InterfaceMethod [97] [98] 
.const [38] = InterfaceMethod [99] [100] 
.const [39] = InterfaceMethod [101] [102] 
.const [40] = InterfaceMethod [103] [104] 
.const [41] = InterfaceMethod [105] [106] 
.const [42] = InterfaceMethod [107] [108] 
.const [43] = Class [109] 
.const [44] = Class [110] 
.const [45] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [46] = Utf8 e7c2f9f0-c6df-58d5-8f32-a9625e4c6cd8 
.const [47] = Class [111] 
.const [48] = NameAndType [112] [113] 
.const [49] = Utf8 '1cd88207-dc63-5080-847c-7abf796ccece' 
.const [50] = Utf8 'dsi.picturehandling.DSIPictureHandling' 
.const [51] = Class [114] 
.const [52] = NameAndType [115] [116] 
.const [53] = Class [117] 
.const [54] = NameAndType [118] [119] 
.const [55] = Class [120] 
.const [56] = NameAndType [121] [122] 
.const [57] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [58] = Utf8 java/lang/StringBuffer 
.const [59] = Utf8 'Invalid Method Id ' 
.const [60] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [61] = Utf8 'Deserialization failed: method=' 
.const [62] = Utf8 ', error=' 
.const [63] = Utf8 'STUB.dsi.picturehandling.DSIPictureHandling' 
.const [64] = Class [123] 
.const [65] = NameAndType [124] [125] 
.const [66] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/impl/DSIPictureHandlingReplyService 
.const [67] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [68] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [69] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/DSIPictureHandlingReply 
.const [71] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [72] = Class [126] 
.const [73] = NameAndType [127] [128] 
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
.const [94] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [95] = Class [159] 
.const [96] = NameAndType [160] [161] 
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
.const [111] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/impl/DSIPictureHandlingReplyService 
.const [112] = Utf8 nextDynamicHandle 
.const [113] = Utf8 ()I 
.const [114] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/impl/DSIPictureHandlingReplyService 
.const [115] = Utf8 dynamicHandle 
.const [116] = Utf8 I 
.const [117] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/impl/DSIPictureHandlingReplyService 
.const [118] = Utf8 context 
.const [119] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [120] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [121] = Utf8 getOptionalResourceLocator 
.const [122] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/ResourceLocator; 
.const [123] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [124] = Utf8 getContext 
.const [125] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [126] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/impl/DSIPictureHandlingReplyService 
.const [127] = Utf8 p_DSIPictureHandlingReply 
.const [128] = Utf8 Lde/esolutions/fw/comm/dsi/picturehandling/DSIPictureHandlingReply; 
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
.const [144] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [147] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/impl/DSIPictureHandlingReplyService 
.const [148] = Utf8 dynamicHandle 
.const [149] = Utf8 I 
.const [150] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/impl/DSIPictureHandlingReplyService 
.const [151] = Utf8 context 
.const [152] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [153] = Utf8 java/lang/StringBuffer 
.const [154] = Utf8 <init> 
.const [155] = Utf8 ()V 
.const [156] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Ljava/lang/String;)V 
.const [159] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/impl/DSIPictureHandlingReplyService 
.const [160] = Utf8 p_DSIPictureHandlingReply 
.const [161] = Utf8 Lde/esolutions/fw/comm/dsi/picturehandling/DSIPictureHandlingReply; 
.const [162] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [163] = Utf8 getInt32 
.const [164] = Utf8 ()I 
.const [165] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/DSIPictureHandlingReply 
.const [166] = Utf8 indicatePicture 
.const [167] = Utf8 (IILorg/dsi/ifc/global/ResourceLocator;Lorg/dsi/ifc/global/ResourceLocator;)V 
.const [168] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/DSIPictureHandlingReply 
.const [169] = Utf8 finishPictureRequest 
.const [170] = Utf8 (I)V 
.const [171] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [172] = Utf8 getOptionalString 
.const [173] = Utf8 ()Ljava/lang/String; 
.const [174] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/DSIPictureHandlingReply 
.const [175] = Utf8 asyncException 
.const [176] = Utf8 (ILjava/lang/String;I)V 
.const [177] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/DSIPictureHandlingReply 
.const [178] = Utf8 yyIndication 
.const [179] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [180] = Utf8 de/esolutions/fw/comm/dsi/picturehandling/impl/DSIPictureHandlingReplyService 
.const [181] = Class [180] 
.const [182] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [183] = Class [182] 
.const [184] = Utf8 context 
.const [185] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [186] = Utf8 dynamicHandle 
.const [187] = Utf8 I 
.const [188] = Utf8 p_DSIPictureHandlingReply 
.const [189] = Utf8 Lde/esolutions/fw/comm/dsi/picturehandling/DSIPictureHandlingReply; 
.const [190] = Utf8 Code 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Lde/esolutions/fw/comm/dsi/picturehandling/DSIPictureHandlingReply;)V 
.const [193] = Utf8 nextDynamicHandle 
.const [194] = Utf8 ()I 
.const [195] = Utf8 getCallContext 
.const [196] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [197] = Utf8 handleCallMethod 
.const [198] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [199] = Utf8 <clinit> 
.const [200] = Utf8 ()V 
.end class 
