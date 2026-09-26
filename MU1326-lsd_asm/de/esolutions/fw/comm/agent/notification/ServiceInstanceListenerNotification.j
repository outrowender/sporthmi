.version 50 0 
.class public super [201] 
.super [203] 
.field protected [204] [205] 
.field protected [206] [207] 
.field protected [208] [209] 
.field protected [210] [211] 

.method public [213] : [214] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [37] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [38] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [39] 
L19:    aload_0 
L20:    iload 4 
L22:    putfield [40] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [212] .code stack 2 locals 0 
L0:     new [41] 
L3:     dup 
L4:     invokespecial [34] 
L7:     ldc [3] 
L9:     invokevirtual [25] 
L12:    aload_0 
L13:    getfield [21] 
L16:    invokevirtual [26] 
L19:    ldc [4] 
L21:    invokevirtual [25] 
L24:    aload_0 
L25:    getfield [23] 
L28:    invokevirtual [27] 
L31:    ldc [5] 
L33:    invokevirtual [25] 
L36:    aload_0 
L37:    getfield [24] 
L40:    invokevirtual [28] 
L43:    ldc [6] 
L45:    invokevirtual [25] 
L48:    invokevirtual [29] 
L51:    areturn 
L52:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [212] .code stack 8 locals 2 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     ldc [8] 
L6:     aload_0 
L7:     getfield [21] 
L10:    new [42] 
L13:    dup 
L14:    aload_0 
L15:    getfield [23] 
L18:    invokespecial [35] 
L21:    new [43] 
L24:    dup 
L25:    aload_0 
L26:    getfield [24] 
L29:    invokespecial [36] 
L32:    invokevirtual [30] 
L35:    pop 
L36:    aload_0 
L37:    getfield [22] 
L40:    invokeinterface [44] 0 
L45:    astore_1 
L46:    aload_1 
L47:    invokeinterface [45] 0 
L52:    ifeq L128 
L55:    aload_1 
L56:    invokeinterface [46] 0 
L61:    checkcast [11] 
L64:    astore_2 
L65:    getstatic [7] 
L68:    iconst_1 
L69:    ldc [12] 
L71:    aload_2 
L72:    invokevirtual [31] 
L75:    pop 
L76:    aload_0 
L77:    getfield [23] 
L80:    ifeq L100 
L83:    aload_2 
L84:    aload_0 
L85:    getfield [21] 
L88:    aload_0 
L89:    getfield [24] 
L92:    invokeinterface [47] 0 
L97:    goto L114 
L100:   aload_2 
L101:   aload_0 
L102:   getfield [21] 
L105:   aload_0 
L106:   getfield [24] 
L109:   invokeinterface [48] 0 
L114:   getstatic [7] 
L117:   iconst_1 
L118:   ldc [13] 
L120:   aload_2 
L121:   invokevirtual [31] 
L124:   pop 
L125:   goto L46 
L128:   getstatic [7] 
L131:   iconst_1 
L132:   ldc [14] 
L134:   invokevirtual [32] 
L137:   pop 
L138:   return 
L139:   nop 
L140:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [49] 
.const [3] = String [50] 
.const [4] = String [51] 
.const [5] = String [52] 
.const [6] = String [53] 
.const [7] = Field [54] [55] 
.const [8] = String [56] 
.const [9] = Class [57] 
.const [10] = Class [58] 
.const [11] = Class [59] 
.const [12] = String [60] 
.const [13] = String [61] 
.const [14] = String [62] 
.const [15] = Class [63] 
.const [16] = Class [64] 
.const [17] = Class [65] 
.const [18] = Class [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Field [69] [70] 
.const [22] = Field [71] [72] 
.const [23] = Field [73] [74] 
.const [24] = Field [75] [76] 
.const [25] = Method [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Method [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Field [101] [102] 
.const [38] = Field [103] [104] 
.const [39] = Field [105] [106] 
.const [40] = Field [107] [108] 
.const [41] = Class [109] 
.const [42] = Class [110] 
.const [43] = Class [111] 
.const [44] = InterfaceMethod [112] [113] 
.const [45] = InterfaceMethod [114] [115] 
.const [46] = InterfaceMethod [116] [117] 
.const [47] = InterfaceMethod [118] [119] 
.const [48] = InterfaceMethod [120] [121] 
.const [49] = Utf8 java/lang/StringBuffer 
.const [50] = Utf8 '[ServiceInstanceListener:service=' 
.const [51] = Utf8 ',doRegister=' 
.const [52] = Utf8 ',agentID=' 
.const [53] = Utf8 ']' 
.const [54] = Class [122] 
.const [55] = NameAndType [123] [124] 
.const [56] = Utf8 '{ ServiceInstanceListenerNotification instanceID=%1 doRegister=%2 agentID=%3' 
.const [57] = Utf8 java/lang/Boolean 
.const [58] = Utf8 java/lang/Short 
.const [59] = Utf8 de/esolutions/fw/comm/core/IServiceInstanceListener 
.const [60] = Utf8 ' + Callback Service Instance Listener %1' 
.const [61] = Utf8 ' - Callback Service Instance Listener %1' 
.const [62] = Utf8 '} ServiceInstanceListenerNotification' 
.const [63] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceInstanceListenerNotification 
.const [64] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [65] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [66] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [67] = Utf8 java/util/List 
.const [68] = Utf8 java/util/ListIterator 
.const [69] = Class [125] 
.const [70] = NameAndType [126] [127] 
.const [71] = Class [128] 
.const [72] = NameAndType [129] [130] 
.const [73] = Class [131] 
.const [74] = NameAndType [132] [133] 
.const [75] = Class [134] 
.const [76] = NameAndType [135] [136] 
.const [77] = Class [137] 
.const [78] = NameAndType [138] [139] 
.const [79] = Class [140] 
.const [80] = NameAndType [141] [142] 
.const [81] = Class [143] 
.const [82] = NameAndType [144] [145] 
.const [83] = Class [146] 
.const [84] = NameAndType [147] [148] 
.const [85] = Class [149] 
.const [86] = NameAndType [150] [151] 
.const [87] = Class [152] 
.const [88] = NameAndType [153] [154] 
.const [89] = Class [155] 
.const [90] = NameAndType [156] [157] 
.const [91] = Class [158] 
.const [92] = NameAndType [159] [160] 
.const [93] = Class [161] 
.const [94] = NameAndType [162] [163] 
.const [95] = Class [164] 
.const [96] = NameAndType [165] [166] 
.const [97] = Class [167] 
.const [98] = NameAndType [168] [169] 
.const [99] = Class [170] 
.const [100] = NameAndType [171] [172] 
.const [101] = Class [173] 
.const [102] = NameAndType [174] [175] 
.const [103] = Class [176] 
.const [104] = NameAndType [177] [178] 
.const [105] = Class [179] 
.const [106] = NameAndType [180] [181] 
.const [107] = Class [182] 
.const [108] = NameAndType [183] [184] 
.const [109] = Utf8 java/lang/StringBuffer 
.const [110] = Utf8 java/lang/Boolean 
.const [111] = Utf8 java/lang/Short 
.const [112] = Class [185] 
.const [113] = NameAndType [186] [187] 
.const [114] = Class [188] 
.const [115] = NameAndType [189] [190] 
.const [116] = Class [191] 
.const [117] = NameAndType [192] [193] 
.const [118] = Class [194] 
.const [119] = NameAndType [195] [196] 
.const [120] = Class [197] 
.const [121] = NameAndType [198] [199] 
.const [122] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [123] = Utf8 NOTIFICATION 
.const [124] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [125] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceInstanceListenerNotification 
.const [126] = Utf8 instanceID 
.const [127] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [128] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceInstanceListenerNotification 
.const [129] = Utf8 listeners 
.const [130] = Utf8 Ljava/util/List; 
.const [131] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceInstanceListenerNotification 
.const [132] = Utf8 doRegister 
.const [133] = Utf8 Z 
.const [134] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceInstanceListenerNotification 
.const [135] = Utf8 agentID 
.const [136] = Utf8 S 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 append 
.const [139] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [140] = Utf8 java/lang/StringBuffer 
.const [141] = Utf8 append 
.const [142] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [143] = Utf8 java/lang/StringBuffer 
.const [144] = Utf8 append 
.const [145] = Utf8 (Z)Ljava/lang/StringBuffer; 
.const [146] = Utf8 java/lang/StringBuffer 
.const [147] = Utf8 append 
.const [148] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [149] = Utf8 java/lang/StringBuffer 
.const [150] = Utf8 toString 
.const [151] = Utf8 ()Ljava/lang/String; 
.const [152] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [153] = Utf8 log 
.const [154] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [155] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [156] = Utf8 log 
.const [157] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [158] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [159] = Utf8 log 
.const [160] = Utf8 (SLjava/lang/String;)Z 
.const [161] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [162] = Utf8 <init> 
.const [163] = Utf8 ()V 
.const [164] = Utf8 java/lang/StringBuffer 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 java/lang/Boolean 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Z)V 
.const [170] = Utf8 java/lang/Short 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (S)V 
.const [173] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceInstanceListenerNotification 
.const [174] = Utf8 instanceID 
.const [175] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [176] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceInstanceListenerNotification 
.const [177] = Utf8 listeners 
.const [178] = Utf8 Ljava/util/List; 
.const [179] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceInstanceListenerNotification 
.const [180] = Utf8 doRegister 
.const [181] = Utf8 Z 
.const [182] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceInstanceListenerNotification 
.const [183] = Utf8 agentID 
.const [184] = Utf8 S 
.const [185] = Utf8 java/util/List 
.const [186] = Utf8 listIterator 
.const [187] = Utf8 ()Ljava/util/ListIterator; 
.const [188] = Utf8 java/util/ListIterator 
.const [189] = Utf8 hasNext 
.const [190] = Utf8 ()Z 
.const [191] = Utf8 java/util/ListIterator 
.const [192] = Utf8 next 
.const [193] = Utf8 ()Ljava/lang/Object; 
.const [194] = Utf8 de/esolutions/fw/comm/core/IServiceInstanceListener 
.const [195] = Utf8 serviceRegistered 
.const [196] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;S)V 
.const [197] = Utf8 de/esolutions/fw/comm/core/IServiceInstanceListener 
.const [198] = Utf8 serviceUnregistered 
.const [199] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;S)V 
.const [200] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceInstanceListenerNotification 
.const [201] = Class [200] 
.const [202] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [203] = Class [202] 
.const [204] = Utf8 instanceID 
.const [205] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [206] = Utf8 listeners 
.const [207] = Utf8 Ljava/util/List; 
.const [208] = Utf8 doRegister 
.const [209] = Utf8 Z 
.const [210] = Utf8 agentID 
.const [211] = Utf8 S 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Ljava/util/List;ZS)V 
.const [215] = Utf8 toString 
.const [216] = Utf8 ()Ljava/lang/String; 
.const [217] = Utf8 performNotification 
.const [218] = Utf8 ()V 
.end class 
