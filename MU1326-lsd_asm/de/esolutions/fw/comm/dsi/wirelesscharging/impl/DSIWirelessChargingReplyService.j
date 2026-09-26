.version 50 0 
.class public super [173] 
.super [175] 
.field private static final [176] [177] 
.field private static [178] [179] 
.field private [180] [181] 

.method public [183] : [184] 
    .attribute [182] .code stack 7 locals 0 
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

.method private static synchronized [185] : [186] 
    .attribute [182] .code stack 2 locals 1 
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

.method public [187] : [188] 
    .attribute [182] .code stack 1 locals 0 
L0:     getstatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [182] .code stack 4 locals 3 
        .catch [12] from L0 to L209 using L212 
L0:     iload_1 
L1:     lookupswitch 
            0 : L108 
            8 : L76 
            9 : L44 
            10 : L150 
            default : L182 

L44:    aload_2 
L45:    invokeinterface [35] 0 
L50:    istore 4 
L52:    aload_2 
L53:    invokeinterface [35] 0 
L58:    istore 5 
L60:    aload_0 
L61:    getfield [22] 
L64:    iload 4 
L66:    iload 5 
L68:    invokeinterface [36] 0 
L73:    goto L209 
L76:    aload_2 
L77:    invokeinterface [35] 0 
L82:    istore 4 
L84:    aload_2 
L85:    invokeinterface [35] 0 
L90:    istore 5 
L92:    aload_0 
L93:    getfield [22] 
L96:    iload 4 
L98:    iload 5 
L100:   invokeinterface [37] 0 
L105:   goto L209 
L108:   aload_2 
L109:   invokeinterface [35] 0 
L114:   istore 4 
L116:   aload_2 
L117:   invokeinterface [38] 0 
L122:   astore 5 
L124:   aload_2 
L125:   invokeinterface [35] 0 
L130:   istore 6 
L132:   aload_0 
L133:   getfield [22] 
L136:   iload 4 
L138:   aload 5 
L140:   iload 6 
L142:   invokeinterface [39] 0 
L147:   goto L209 
L150:   aload_2 
L151:   invokeinterface [38] 0 
L156:   astore 4 
L158:   aload_2 
L159:   invokeinterface [38] 0 
L164:   astore 5 
L166:   aload_0 
L167:   getfield [22] 
L170:   aload 4 
L172:   aload 5 
L174:   invokeinterface [40] 0 
L179:   goto L209 
L182:   new [41] 
L185:   dup 
L186:   new [42] 
L189:   dup 
L190:   invokespecial [31] 
L193:   ldc [11] 
L195:   invokevirtual [23] 
L198:   iload_1 
L199:   invokevirtual [24] 
L202:   invokevirtual [25] 
L205:   invokespecial [32] 
L208:   athrow 
L209:   goto L254 
L212:   astore 4 
L214:   new [41] 
L217:   dup 
L218:   new [42] 
L221:   dup 
L222:   invokespecial [31] 
L225:   ldc [13] 
L227:   invokevirtual [23] 
L230:   iload_1 
L231:   invokevirtual [24] 
L234:   ldc [14] 
L236:   invokevirtual [23] 
L239:   aload 4 
L241:   invokevirtual [26] 
L244:   invokevirtual [23] 
L247:   invokevirtual [25] 
L250:   invokespecial [32] 
L253:   athrow 
L254:   return 
L255:   nop 
L256:   
    .end code 
.end method 

.method static [191] : [192] 
    .attribute [182] .code stack 1 locals 0 
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
.const [2] = Class [43] 
.const [3] = String [44] 
.const [4] = Method [45] [46] 
.const [5] = String [47] 
.const [6] = String [48] 
.const [7] = Field [49] [50] 
.const [8] = Field [51] [52] 
.const [9] = Class [53] 
.const [10] = Class [54] 
.const [11] = String [55] 
.const [12] = Class [56] 
.const [13] = String [57] 
.const [14] = String [58] 
.const [15] = String [59] 
.const [16] = Method [60] [61] 
.const [17] = Class [62] 
.const [18] = Class [63] 
.const [19] = Class [64] 
.const [20] = Class [65] 
.const [21] = Class [66] 
.const [22] = Field [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Field [81] [82] 
.const [30] = Field [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Method [87] [88] 
.const [33] = Class [89] 
.const [34] = Field [90] [91] 
.const [35] = InterfaceMethod [92] [93] 
.const [36] = InterfaceMethod [94] [95] 
.const [37] = InterfaceMethod [96] [97] 
.const [38] = InterfaceMethod [98] [99] 
.const [39] = InterfaceMethod [100] [101] 
.const [40] = InterfaceMethod [102] [103] 
.const [41] = Class [104] 
.const [42] = Class [105] 
.const [43] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [44] = Utf8 a48e6ab6-c735-5b71-aa35-583b9ab06e12 
.const [45] = Class [106] 
.const [46] = NameAndType [107] [108] 
.const [47] = Utf8 ed994bd0-c68b-5fe2-9542-a5fa78f087a8 
.const [48] = Utf8 'dsi.wirelesscharging.DSIWirelessCharging' 
.const [49] = Class [109] 
.const [50] = NameAndType [110] [111] 
.const [51] = Class [112] 
.const [52] = NameAndType [113] [114] 
.const [53] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [54] = Utf8 java/lang/StringBuffer 
.const [55] = Utf8 'Invalid Method Id ' 
.const [56] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [57] = Utf8 'Deserialization failed: method=' 
.const [58] = Utf8 ', error=' 
.const [59] = Utf8 'STUB.dsi.wirelesscharging.DSIWirelessCharging' 
.const [60] = Class [115] 
.const [61] = NameAndType [116] [117] 
.const [62] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/impl/DSIWirelessChargingReplyService 
.const [63] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [64] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [65] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/DSIWirelessChargingReply 
.const [66] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [67] = Class [118] 
.const [68] = NameAndType [119] [120] 
.const [69] = Class [121] 
.const [70] = NameAndType [122] [123] 
.const [71] = Class [124] 
.const [72] = NameAndType [125] [126] 
.const [73] = Class [127] 
.const [74] = NameAndType [128] [129] 
.const [75] = Class [130] 
.const [76] = NameAndType [131] [132] 
.const [77] = Class [133] 
.const [78] = NameAndType [134] [135] 
.const [79] = Class [136] 
.const [80] = NameAndType [137] [138] 
.const [81] = Class [139] 
.const [82] = NameAndType [140] [141] 
.const [83] = Class [142] 
.const [84] = NameAndType [143] [144] 
.const [85] = Class [145] 
.const [86] = NameAndType [146] [147] 
.const [87] = Class [148] 
.const [88] = NameAndType [149] [150] 
.const [89] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [90] = Class [151] 
.const [91] = NameAndType [152] [153] 
.const [92] = Class [154] 
.const [93] = NameAndType [155] [156] 
.const [94] = Class [157] 
.const [95] = NameAndType [158] [159] 
.const [96] = Class [160] 
.const [97] = NameAndType [161] [162] 
.const [98] = Class [163] 
.const [99] = NameAndType [164] [165] 
.const [100] = Class [166] 
.const [101] = NameAndType [167] [168] 
.const [102] = Class [169] 
.const [103] = NameAndType [170] [171] 
.const [104] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [105] = Utf8 java/lang/StringBuffer 
.const [106] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/impl/DSIWirelessChargingReplyService 
.const [107] = Utf8 nextDynamicHandle 
.const [108] = Utf8 ()I 
.const [109] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/impl/DSIWirelessChargingReplyService 
.const [110] = Utf8 dynamicHandle 
.const [111] = Utf8 I 
.const [112] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/impl/DSIWirelessChargingReplyService 
.const [113] = Utf8 context 
.const [114] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [115] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [116] = Utf8 getContext 
.const [117] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [118] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/impl/DSIWirelessChargingReplyService 
.const [119] = Utf8 p_DSIWirelessChargingReply 
.const [120] = Utf8 Lde/esolutions/fw/comm/dsi/wirelesscharging/DSIWirelessChargingReply; 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 append 
.const [123] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 append 
.const [126] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [127] = Utf8 java/lang/StringBuffer 
.const [128] = Utf8 toString 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [131] = Utf8 getMessage 
.const [132] = Utf8 ()Ljava/lang/String; 
.const [133] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [136] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [139] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/impl/DSIWirelessChargingReplyService 
.const [140] = Utf8 dynamicHandle 
.const [141] = Utf8 I 
.const [142] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/impl/DSIWirelessChargingReplyService 
.const [143] = Utf8 context 
.const [144] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [145] = Utf8 java/lang/StringBuffer 
.const [146] = Utf8 <init> 
.const [147] = Utf8 ()V 
.const [148] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Ljava/lang/String;)V 
.const [151] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/impl/DSIWirelessChargingReplyService 
.const [152] = Utf8 p_DSIWirelessChargingReply 
.const [153] = Utf8 Lde/esolutions/fw/comm/dsi/wirelesscharging/DSIWirelessChargingReply; 
.const [154] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [155] = Utf8 getInt32 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/DSIWirelessChargingReply 
.const [158] = Utf8 updateChargingInfo 
.const [159] = Utf8 (II)V 
.const [160] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/DSIWirelessChargingReply 
.const [161] = Utf8 updateBatteryLevel 
.const [162] = Utf8 (II)V 
.const [163] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [164] = Utf8 getOptionalString 
.const [165] = Utf8 ()Ljava/lang/String; 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/DSIWirelessChargingReply 
.const [167] = Utf8 asyncException 
.const [168] = Utf8 (ILjava/lang/String;I)V 
.const [169] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/DSIWirelessChargingReply 
.const [170] = Utf8 yyIndication 
.const [171] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/wirelesscharging/impl/DSIWirelessChargingReplyService 
.const [173] = Class [172] 
.const [174] = Utf8 de/esolutions/fw/comm/core/AbstractReplyService 
.const [175] = Class [174] 
.const [176] = Utf8 context 
.const [177] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [178] = Utf8 dynamicHandle 
.const [179] = Utf8 I 
.const [180] = Utf8 p_DSIWirelessChargingReply 
.const [181] = Utf8 Lde/esolutions/fw/comm/dsi/wirelesscharging/DSIWirelessChargingReply; 
.const [182] = Utf8 Code 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/esolutions/fw/comm/dsi/wirelesscharging/DSIWirelessChargingReply;)V 
.const [185] = Utf8 nextDynamicHandle 
.const [186] = Utf8 ()I 
.const [187] = Utf8 getCallContext 
.const [188] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [189] = Utf8 handleCallMethod 
.const [190] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [191] = Utf8 <clinit> 
.const [192] = Utf8 ()V 
.end class 
