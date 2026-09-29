.version 50 0 
.class public super [173] 
.super [175] 
.field protected [176] [177] 
.field protected [178] [179] 
.field protected [180] [181] 

.method public [183] : [184] 
    .attribute [182] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [33] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [34] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [35] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [182] .code stack 2 locals 0 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [31] 
L7:     ldc [3] 
L9:     invokevirtual [23] 
L12:    aload_0 
L13:    getfield [20] 
L16:    invokeinterface [37] 0 
L21:    invokevirtual [24] 
L24:    ldc [4] 
L26:    invokevirtual [23] 
L29:    aload_0 
L30:    getfield [22] 
L33:    invokevirtual [25] 
L36:    ldc [5] 
L38:    invokevirtual [23] 
L41:    invokevirtual [26] 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [182] .code stack 7 locals 2 
L0:     getstatic [6] 
L3:     iconst_1 
L4:     ldc [7] 
L6:     aload_0 
L7:     getfield [20] 
L10:    invokeinterface [37] 0 
L15:    new [38] 
L18:    dup 
L19:    aload_0 
L20:    getfield [22] 
L23:    invokespecial [32] 
L26:    invokevirtual [27] 
L29:    pop 
L30:    aload_0 
L31:    getfield [21] 
L34:    invokeinterface [39] 0 
L39:    astore_1 
L40:    aload_1 
L41:    invokeinterface [40] 0 
L46:    ifeq L98 
L49:    aload_1 
L50:    invokeinterface [41] 0 
L55:    checkcast [9] 
L58:    astore_2 
L59:    getstatic [6] 
L62:    iconst_1 
L63:    ldc [10] 
L65:    aload_2 
L66:    invokevirtual [28] 
L69:    pop 
L70:    aload_2 
L71:    aload_0 
L72:    getfield [20] 
L75:    aload_0 
L76:    getfield [22] 
L79:    invokeinterface [42] 0 
L84:    getstatic [6] 
L87:    iconst_1 
L88:    ldc [11] 
L90:    aload_2 
L91:    invokevirtual [28] 
L94:    pop 
L95:    goto L40 
L98:    getstatic [6] 
L101:   iconst_1 
L102:   ldc [12] 
L104:   invokevirtual [29] 
L107:   pop 
L108:   return 
L109:   nop 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [43] 
.const [3] = String [44] 
.const [4] = String [45] 
.const [5] = String [46] 
.const [6] = Field [47] [48] 
.const [7] = String [49] 
.const [8] = Class [50] 
.const [9] = Class [51] 
.const [10] = String [52] 
.const [11] = String [53] 
.const [12] = String [54] 
.const [13] = Class [55] 
.const [14] = Class [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Class [60] 
.const [19] = Class [61] 
.const [20] = Field [62] [63] 
.const [21] = Field [64] [65] 
.const [22] = Field [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = Field [92] [93] 
.const [36] = Class [94] 
.const [37] = InterfaceMethod [95] [96] 
.const [38] = Class [97] 
.const [39] = InterfaceMethod [98] [99] 
.const [40] = InterfaceMethod [100] [101] 
.const [41] = InterfaceMethod [102] [103] 
.const [42] = InterfaceMethod [104] [105] 
.const [43] = Utf8 java/lang/StringBuffer 
.const [44] = Utf8 '[ServiceListener:service=' 
.const [45] = Utf8 ',stubCount=' 
.const [46] = Utf8 ']' 
.const [47] = Class [106] 
.const [48] = NameAndType [107] [108] 
.const [49] = Utf8 '{ ServiceListenerNotification: service=%1 stubCount=%2' 
.const [50] = Utf8 java/lang/Integer 
.const [51] = Utf8 de/esolutions/fw/comm/core/IServiceListener 
.const [52] = Utf8 ' + Callback Service Listener %1' 
.const [53] = Utf8 ' - Callback Service Listener %1' 
.const [54] = Utf8 '} ServiceListenerNotification' 
.const [55] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerNotification 
.const [56] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [57] = Utf8 de/esolutions/fw/comm/core/IService 
.const [58] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [59] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [60] = Utf8 java/util/List 
.const [61] = Utf8 java/util/ListIterator 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Class [112] 
.const [65] = NameAndType [113] [114] 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Class [145] 
.const [87] = NameAndType [146] [147] 
.const [88] = Class [148] 
.const [89] = NameAndType [149] [150] 
.const [90] = Class [151] 
.const [91] = NameAndType [152] [153] 
.const [92] = Class [154] 
.const [93] = NameAndType [155] [156] 
.const [94] = Utf8 java/lang/StringBuffer 
.const [95] = Class [157] 
.const [96] = NameAndType [158] [159] 
.const [97] = Utf8 java/lang/Integer 
.const [98] = Class [160] 
.const [99] = NameAndType [161] [162] 
.const [100] = Class [163] 
.const [101] = NameAndType [164] [165] 
.const [102] = Class [166] 
.const [103] = NameAndType [167] [168] 
.const [104] = Class [169] 
.const [105] = NameAndType [170] [171] 
.const [106] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [107] = Utf8 NOTIFICATION 
.const [108] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [109] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerNotification 
.const [110] = Utf8 service 
.const [111] = Utf8 Lde/esolutions/fw/comm/core/IService; 
.const [112] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerNotification 
.const [113] = Utf8 listeners 
.const [114] = Utf8 Ljava/util/List; 
.const [115] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerNotification 
.const [116] = Utf8 stubCount 
.const [117] = Utf8 I 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 append 
.const [123] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 append 
.const [126] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [127] = Utf8 java/lang/StringBuffer 
.const [128] = Utf8 toString 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [131] = Utf8 log 
.const [132] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [133] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [136] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [137] = Utf8 log 
.const [138] = Utf8 (SLjava/lang/String;)Z 
.const [139] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [140] = Utf8 <init> 
.const [141] = Utf8 ()V 
.const [142] = Utf8 java/lang/StringBuffer 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 java/lang/Integer 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (I)V 
.const [148] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerNotification 
.const [149] = Utf8 service 
.const [150] = Utf8 Lde/esolutions/fw/comm/core/IService; 
.const [151] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerNotification 
.const [152] = Utf8 listeners 
.const [153] = Utf8 Ljava/util/List; 
.const [154] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerNotification 
.const [155] = Utf8 stubCount 
.const [156] = Utf8 I 
.const [157] = Utf8 de/esolutions/fw/comm/core/IService 
.const [158] = Utf8 getInstanceID 
.const [159] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [160] = Utf8 java/util/List 
.const [161] = Utf8 listIterator 
.const [162] = Utf8 ()Ljava/util/ListIterator; 
.const [163] = Utf8 java/util/ListIterator 
.const [164] = Utf8 hasNext 
.const [165] = Utf8 ()Z 
.const [166] = Utf8 java/util/ListIterator 
.const [167] = Utf8 next 
.const [168] = Utf8 ()Ljava/lang/Object; 
.const [169] = Utf8 de/esolutions/fw/comm/core/IServiceListener 
.const [170] = Utf8 serviceStubCountChanged 
.const [171] = Utf8 (Lde/esolutions/fw/comm/core/IService;I)V 
.const [172] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerNotification 
.const [173] = Class [172] 
.const [174] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [175] = Class [174] 
.const [176] = Utf8 service 
.const [177] = Utf8 Lde/esolutions/fw/comm/core/IService; 
.const [178] = Utf8 listeners 
.const [179] = Utf8 Ljava/util/List; 
.const [180] = Utf8 stubCount 
.const [181] = Utf8 I 
.const [182] = Utf8 Code 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/esolutions/fw/comm/core/IService;Ljava/util/List;I)V 
.const [185] = Utf8 toString 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 performNotification 
.const [188] = Utf8 ()V 
.end class 
