.version 50 0 
.class public super [159] 
.super [161] 
.field private static final [162] [163] 
.field private [164] [165] 

.method public [167] : [168] 
    .attribute [166] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [33] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [27] 
L15:    invokespecial [28] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [34] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [166] .code stack 2 locals 0 
L0:     new [35] 
L3:     dup 
L4:     invokespecial [29] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [166] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [166] .code stack 4 locals 1 
        .catch [12] from L0 to L143 using L146 
L0:     iload_1 
L1:     lookupswitch 
            0 : L100 
            2 : L44 
            4 : L60 
            12 : L76 
            default : L116 

L44:    aload_0 
L45:    getfield [22] 
L48:    aload_3 
L49:    checkcast [6] 
L52:    invokeinterface [36] 0 
L57:    goto L143 
L60:    aload_0 
L61:    getfield [22] 
L64:    aload_3 
L65:    checkcast [6] 
L68:    invokeinterface [37] 0 
L73:    goto L143 
L76:    aload_2 
L77:    invokestatic [8] 
L80:    astore 4 
L82:    aload_0 
L83:    getfield [22] 
L86:    aload 4 
L88:    aload_3 
L89:    checkcast [6] 
L92:    invokeinterface [38] 0 
L97:    goto L143 
L100:   aload_0 
L101:   getfield [22] 
L104:   aload_3 
L105:   checkcast [6] 
L108:   invokeinterface [39] 0 
L113:   goto L143 
L116:   new [40] 
L119:   dup 
L120:   new [41] 
L123:   dup 
L124:   invokespecial [31] 
L127:   ldc [11] 
L129:   invokevirtual [23] 
L132:   iload_1 
L133:   invokevirtual [24] 
L136:   invokevirtual [25] 
L139:   invokespecial [32] 
L142:   athrow 
L143:   goto L188 
L146:   astore 4 
L148:   new [40] 
L151:   dup 
L152:   new [41] 
L155:   dup 
L156:   invokespecial [31] 
L159:   ldc [13] 
L161:   invokevirtual [23] 
L164:   iload_1 
L165:   invokevirtual [24] 
L168:   ldc [14] 
L170:   invokevirtual [23] 
L173:   aload 4 
L175:   invokevirtual [26] 
L178:   invokevirtual [23] 
L181:   invokevirtual [25] 
L184:   invokespecial [32] 
L187:   athrow 
L188:   return 
L189:   nop 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 

.method static [175] : [176] 
    .attribute [166] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [30] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [42] 
.const [3] = String [43] 
.const [4] = String [44] 
.const [5] = String [45] 
.const [6] = Class [46] 
.const [7] = Field [47] [48] 
.const [8] = Method [49] [50] 
.const [9] = Class [51] 
.const [10] = Class [52] 
.const [11] = String [53] 
.const [12] = Class [54] 
.const [13] = String [55] 
.const [14] = String [56] 
.const [15] = String [57] 
.const [16] = Method [58] [59] 
.const [17] = Class [60] 
.const [18] = Class [61] 
.const [19] = Class [62] 
.const [20] = Class [63] 
.const [21] = Class [64] 
.const [22] = Field [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Field [81] [82] 
.const [31] = Method [83] [84] 
.const [32] = Method [85] [86] 
.const [33] = Class [87] 
.const [34] = Field [88] [89] 
.const [35] = Class [90] 
.const [36] = InterfaceMethod [91] [92] 
.const [37] = InterfaceMethod [93] [94] 
.const [38] = InterfaceMethod [95] [96] 
.const [39] = InterfaceMethod [97] [98] 
.const [40] = Class [99] 
.const [41] = Class [100] 
.const [42] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [43] = Utf8 '1c1707c0-995c-4af9-98c2-afe3399d33b6' 
.const [44] = Utf8 '791334e8-3d42-5162-9439-61521595702c' 
.const [45] = Utf8 'asi.navigation.rdvdataprovider.RdvDataProvider' 
.const [46] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyProxy 
.const [47] = Class [101] 
.const [48] = NameAndType [102] [103] 
.const [49] = Class [104] 
.const [50] = NameAndType [105] [106] 
.const [51] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [52] = Utf8 java/lang/StringBuffer 
.const [53] = Utf8 'Invalid Method Id ' 
.const [54] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [55] = Utf8 'Deserialization failed: method=' 
.const [56] = Utf8 ', error=' 
.const [57] = Utf8 'STUB.asi.navigation.rdvdataprovider.RdvDataProvider' 
.const [58] = Class [107] 
.const [59] = NameAndType [108] [109] 
.const [60] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderService 
.const [61] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [62] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderS 
.const [63] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RouteProviderSettingSerializer 
.const [64] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Class [122] 
.const [74] = NameAndType [123] [124] 
.const [75] = Class [125] 
.const [76] = NameAndType [126] [127] 
.const [77] = Class [128] 
.const [78] = NameAndType [129] [130] 
.const [79] = Class [131] 
.const [80] = NameAndType [132] [133] 
.const [81] = Class [134] 
.const [82] = NameAndType [135] [136] 
.const [83] = Class [137] 
.const [84] = NameAndType [138] [139] 
.const [85] = Class [140] 
.const [86] = NameAndType [141] [142] 
.const [87] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [88] = Class [143] 
.const [89] = NameAndType [144] [145] 
.const [90] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyProxy 
.const [91] = Class [146] 
.const [92] = NameAndType [147] [148] 
.const [93] = Class [149] 
.const [94] = NameAndType [150] [151] 
.const [95] = Class [152] 
.const [96] = NameAndType [153] [154] 
.const [97] = Class [155] 
.const [98] = NameAndType [156] [157] 
.const [99] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderService 
.const [102] = Utf8 context 
.const [103] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [104] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RouteProviderSettingSerializer 
.const [105] = Utf8 getOptionalRouteProviderSetting 
.const [106] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RouteProviderSetting; 
.const [107] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [108] = Utf8 getContext 
.const [109] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [110] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderService 
.const [111] = Utf8 p_RdvDataProvider 
.const [112] = Utf8 Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderS; 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 append 
.const [115] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Utf8 append 
.const [118] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [119] = Utf8 java/lang/StringBuffer 
.const [120] = Utf8 toString 
.const [121] = Utf8 ()Ljava/lang/String; 
.const [122] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [123] = Utf8 getMessage 
.const [124] = Utf8 ()Ljava/lang/String; 
.const [125] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [128] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [131] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderReplyProxy 
.const [132] = Utf8 <init> 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderService 
.const [135] = Utf8 context 
.const [136] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (Ljava/lang/String;)V 
.const [143] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderService 
.const [144] = Utf8 p_RdvDataProvider 
.const [145] = Utf8 Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderS; 
.const [146] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderS 
.const [147] = Utf8 registerForDataUpdate 
.const [148] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply;)V 
.const [149] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderS 
.const [150] = Utf8 unregisterForDataUpdate 
.const [151] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply;)V 
.const [152] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderS 
.const [153] = Utf8 setRouteProviderSetting 
.const [154] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RouteProviderSetting;Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply;)V 
.const [155] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderS 
.const [156] = Utf8 getCurrentPosition 
.const [157] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderReply;)V 
.const [158] = Utf8 de/esolutions/fw/comm/asi/navigation/rdvdataprovider/impl/RdvDataProviderService 
.const [159] = Class [158] 
.const [160] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [161] = Class [160] 
.const [162] = Utf8 context 
.const [163] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [164] = Utf8 p_RdvDataProvider 
.const [165] = Utf8 Lde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderS; 
.const [166] = Utf8 Code 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (ILde/esolutions/fw/comm/asi/navigation/rdvdataprovider/RdvDataProviderS;)V 
.const [169] = Utf8 createReplyProxy 
.const [170] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [171] = Utf8 getCallContext 
.const [172] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [173] = Utf8 handleCallMethod 
.const [174] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [175] = Utf8 <clinit> 
.const [176] = Utf8 ()V 
.end class 
