.version 50 0 
.class public super [175] 
.super [177] 
.field protected [178] [179] 
.field protected [180] [181] 
.field protected [182] [183] 

.method public [185] : [186] 
    .attribute [184] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [35] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [36] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [37] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [184] .code stack 3 locals 0 
L0:     new [38] 
L3:     dup 
L4:     invokespecial [33] 
L7:     ldc [3] 
L9:     invokevirtual [25] 
L12:    aload_0 
L13:    getfield [22] 
L16:    invokevirtual [26] 
L19:    invokevirtual [27] 
L22:    ldc [4] 
L24:    invokevirtual [25] 
L27:    getstatic [5] 
L30:    aload_0 
L31:    getfield [24] 
L34:    aaload 
L35:    invokevirtual [25] 
L38:    ldc [6] 
L40:    invokevirtual [25] 
L43:    invokevirtual [28] 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [184] .code stack 7 locals 2 
L0:     getstatic [7] 
L3:     iconst_1 
L4:     ldc [8] 
L6:     getstatic [5] 
L9:     aload_0 
L10:    getfield [24] 
L13:    aaload 
L14:    new [39] 
L17:    dup 
L18:    aload_0 
L19:    getfield [22] 
L22:    invokevirtual [26] 
L25:    invokespecial [34] 
L28:    aload_0 
L29:    getfield [22] 
L32:    invokevirtual [29] 
L35:    invokevirtual [30] 
L38:    pop 
L39:    aload_0 
L40:    getfield [23] 
L43:    invokeinterface [40] 0 
L48:    astore_1 
L49:    aload_1 
L50:    invokeinterface [41] 0 
L55:    ifeq L107 
L58:    aload_1 
L59:    invokeinterface [42] 0 
L64:    checkcast [10] 
L67:    astore_2 
L68:    getstatic [7] 
L71:    iconst_1 
L72:    ldc [11] 
L74:    aload_2 
L75:    invokevirtual [31] 
L78:    pop 
L79:    aload_2 
L80:    aload_0 
L81:    getfield [22] 
L84:    aload_0 
L85:    getfield [24] 
L88:    invokeinterface [43] 0 
L93:    getstatic [7] 
L96:    iconst_1 
L97:    ldc [12] 
L99:    aload_2 
L100:   invokevirtual [31] 
L103:   pop 
L104:   goto L49 
L107:   getstatic [7] 
L110:   iconst_1 
L111:   ldc [13] 
L113:   getstatic [5] 
L116:   aload_0 
L117:   getfield [24] 
L120:   aaload 
L121:   new [39] 
L124:   dup 
L125:   aload_0 
L126:   getfield [22] 
L129:   invokevirtual [26] 
L132:   invokespecial [34] 
L135:   aload_0 
L136:   getfield [22] 
L139:   invokevirtual [29] 
L142:   invokevirtual [30] 
L145:   pop 
L146:   return 
L147:   nop 
L148:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [44] 
.const [3] = String [45] 
.const [4] = String [46] 
.const [5] = Field [47] [48] 
.const [6] = String [49] 
.const [7] = Field [50] [51] 
.const [8] = String [52] 
.const [9] = Class [53] 
.const [10] = Class [54] 
.const [11] = String [55] 
.const [12] = String [56] 
.const [13] = String [57] 
.const [14] = Class [58] 
.const [15] = Class [59] 
.const [16] = Class [60] 
.const [17] = Class [61] 
.const [18] = Class [62] 
.const [19] = Class [63] 
.const [20] = Class [64] 
.const [21] = Class [65] 
.const [22] = Field [66] [67] 
.const [23] = Field [68] [69] 
.const [24] = Field [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Method [88] [89] 
.const [34] = Method [90] [91] 
.const [35] = Field [92] [93] 
.const [36] = Field [94] [95] 
.const [37] = Field [96] [97] 
.const [38] = Class [98] 
.const [39] = Class [99] 
.const [40] = InterfaceMethod [100] [101] 
.const [41] = InterfaceMethod [102] [103] 
.const [42] = InterfaceMethod [104] [105] 
.const [43] = InterfaceMethod [106] [107] 
.const [44] = Utf8 java/lang/StringBuffer 
.const [45] = Utf8 '[ProxyListener:proxyId=' 
.const [46] = Utf8 ',state=' 
.const [47] = Class [108] 
.const [48] = NameAndType [109] [110] 
.const [49] = Utf8 ']' 
.const [50] = Class [111] 
.const [51] = NameAndType [112] [113] 
.const [52] = Utf8 '{ ProxyListenerNotification: state=%1 proxy=#%2:%3' 
.const [53] = Utf8 java/lang/Integer 
.const [54] = Utf8 de/esolutions/fw/comm/core/IProxyListener 
.const [55] = Utf8 '  + Callback Proxy Listener %1' 
.const [56] = Utf8 '  - Callback Proxy Listener %1' 
.const [57] = Utf8 '} ProxyListenerNotification: state=%1 proxy=#%2:%3' 
.const [58] = Utf8 de/esolutions/fw/comm/agent/notification/ProxyListenerNotification 
.const [59] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [60] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [61] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [62] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [63] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [64] = Utf8 java/util/List 
.const [65] = Utf8 java/util/ListIterator 
.const [66] = Class [114] 
.const [67] = NameAndType [115] [116] 
.const [68] = Class [117] 
.const [69] = NameAndType [118] [119] 
.const [70] = Class [120] 
.const [71] = NameAndType [121] [122] 
.const [72] = Class [123] 
.const [73] = NameAndType [124] [125] 
.const [74] = Class [126] 
.const [75] = NameAndType [127] [128] 
.const [76] = Class [129] 
.const [77] = NameAndType [130] [131] 
.const [78] = Class [132] 
.const [79] = NameAndType [133] [134] 
.const [80] = Class [135] 
.const [81] = NameAndType [136] [137] 
.const [82] = Class [138] 
.const [83] = NameAndType [139] [140] 
.const [84] = Class [141] 
.const [85] = NameAndType [142] [143] 
.const [86] = Class [144] 
.const [87] = NameAndType [145] [146] 
.const [88] = Class [147] 
.const [89] = NameAndType [148] [149] 
.const [90] = Class [150] 
.const [91] = NameAndType [151] [152] 
.const [92] = Class [153] 
.const [93] = NameAndType [154] [155] 
.const [94] = Class [156] 
.const [95] = NameAndType [157] [158] 
.const [96] = Class [159] 
.const [97] = NameAndType [160] [161] 
.const [98] = Utf8 java/lang/StringBuffer 
.const [99] = Utf8 java/lang/Integer 
.const [100] = Class [162] 
.const [101] = NameAndType [163] [164] 
.const [102] = Class [165] 
.const [103] = NameAndType [166] [167] 
.const [104] = Class [168] 
.const [105] = NameAndType [169] [170] 
.const [106] = Class [171] 
.const [107] = NameAndType [172] [173] 
.const [108] = Utf8 de/esolutions/fw/comm/core/Lifecycle 
.const [109] = Utf8 lifecycleNames 
.const [110] = Utf8 [Ljava/lang/String; 
.const [111] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [112] = Utf8 NOTIFICATION 
.const [113] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [114] = Utf8 de/esolutions/fw/comm/agent/notification/ProxyListenerNotification 
.const [115] = Utf8 proxy 
.const [116] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [117] = Utf8 de/esolutions/fw/comm/agent/notification/ProxyListenerNotification 
.const [118] = Utf8 listeners 
.const [119] = Utf8 Ljava/util/List; 
.const [120] = Utf8 de/esolutions/fw/comm/agent/notification/ProxyListenerNotification 
.const [121] = Utf8 state 
.const [122] = Utf8 I 
.const [123] = Utf8 java/lang/StringBuffer 
.const [124] = Utf8 append 
.const [125] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [126] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [127] = Utf8 getProxyID 
.const [128] = Utf8 ()S 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 append 
.const [131] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 toString 
.const [134] = Utf8 ()Ljava/lang/String; 
.const [135] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [136] = Utf8 getInstanceID 
.const [137] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [138] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [139] = Utf8 log 
.const [140] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [141] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [142] = Utf8 log 
.const [143] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [144] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 java/lang/StringBuffer 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 java/lang/Integer 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (I)V 
.const [153] = Utf8 de/esolutions/fw/comm/agent/notification/ProxyListenerNotification 
.const [154] = Utf8 proxy 
.const [155] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [156] = Utf8 de/esolutions/fw/comm/agent/notification/ProxyListenerNotification 
.const [157] = Utf8 listeners 
.const [158] = Utf8 Ljava/util/List; 
.const [159] = Utf8 de/esolutions/fw/comm/agent/notification/ProxyListenerNotification 
.const [160] = Utf8 state 
.const [161] = Utf8 I 
.const [162] = Utf8 java/util/List 
.const [163] = Utf8 listIterator 
.const [164] = Utf8 ()Ljava/util/ListIterator; 
.const [165] = Utf8 java/util/ListIterator 
.const [166] = Utf8 hasNext 
.const [167] = Utf8 ()Z 
.const [168] = Utf8 java/util/ListIterator 
.const [169] = Utf8 next 
.const [170] = Utf8 ()Ljava/lang/Object; 
.const [171] = Utf8 de/esolutions/fw/comm/core/IProxyListener 
.const [172] = Utf8 proxyStateChanged 
.const [173] = Utf8 (Lde/esolutions/fw/comm/core/Proxy;I)V 
.const [174] = Utf8 de/esolutions/fw/comm/agent/notification/ProxyListenerNotification 
.const [175] = Class [174] 
.const [176] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [177] = Class [176] 
.const [178] = Utf8 proxy 
.const [179] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [180] = Utf8 listeners 
.const [181] = Utf8 Ljava/util/List; 
.const [182] = Utf8 state 
.const [183] = Utf8 I 
.const [184] = Utf8 Code 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (Lde/esolutions/fw/comm/core/Proxy;Ljava/util/List;I)V 
.const [187] = Utf8 toString 
.const [188] = Utf8 ()Ljava/lang/String; 
.const [189] = Utf8 performNotification 
.const [190] = Utf8 ()V 
.end class 
