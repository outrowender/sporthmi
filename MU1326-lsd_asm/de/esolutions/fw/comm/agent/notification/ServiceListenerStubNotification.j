.version 50 0 
.class public super [171] 
.super [173] 
.field protected [174] [175] 
.field protected [176] [177] 
.field protected [178] [179] 

.method public [181] : [182] 
    .attribute [180] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [32] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [33] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [34] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [180] .code stack 2 locals 0 
L0:     new [35] 
L3:     dup 
L4:     invokespecial [30] 
L7:     ldc [3] 
L9:     invokevirtual [22] 
L12:    aload_0 
L13:    getfield [19] 
L16:    invokevirtual [23] 
L19:    ldc [4] 
L21:    invokevirtual [22] 
L24:    aload_0 
L25:    getfield [21] 
L28:    invokevirtual [24] 
L31:    ldc [5] 
L33:    invokevirtual [22] 
L36:    invokevirtual [25] 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [180] .code stack 7 locals 2 
L0:     getstatic [6] 
L3:     iconst_1 
L4:     ldc [7] 
L6:     aload_0 
L7:     getfield [19] 
L10:    new [36] 
L13:    dup 
L14:    aload_0 
L15:    getfield [21] 
L18:    invokespecial [31] 
L21:    invokevirtual [26] 
L24:    pop 
L25:    aload_0 
L26:    getfield [20] 
L29:    invokeinterface [37] 0 
L34:    astore_1 
L35:    aload_1 
L36:    invokeinterface [38] 0 
L41:    ifeq L109 
L44:    aload_1 
L45:    invokeinterface [39] 0 
L50:    checkcast [9] 
L53:    astore_2 
L54:    getstatic [6] 
L57:    iconst_1 
L58:    ldc [10] 
L60:    aload_2 
L61:    invokevirtual [27] 
L64:    pop 
L65:    aload_0 
L66:    getfield [21] 
L69:    ifeq L85 
L72:    aload_2 
L73:    aload_0 
L74:    getfield [19] 
L77:    invokeinterface [40] 0 
L82:    goto L95 
L85:    aload_2 
L86:    aload_0 
L87:    getfield [19] 
L90:    invokeinterface [41] 0 
L95:    getstatic [6] 
L98:    iconst_1 
L99:    ldc [11] 
L101:   aload_2 
L102:   invokevirtual [27] 
L105:   pop 
L106:   goto L35 
L109:   getstatic [6] 
L112:   iconst_1 
L113:   ldc [12] 
L115:   invokevirtual [28] 
L118:   pop 
L119:   return 
L120:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [42] 
.const [3] = String [43] 
.const [4] = String [44] 
.const [5] = String [45] 
.const [6] = Field [46] [47] 
.const [7] = String [48] 
.const [8] = Class [49] 
.const [9] = Class [50] 
.const [10] = String [51] 
.const [11] = String [52] 
.const [12] = String [53] 
.const [13] = Class [54] 
.const [14] = Class [55] 
.const [15] = Class [56] 
.const [16] = Class [57] 
.const [17] = Class [58] 
.const [18] = Class [59] 
.const [19] = Field [60] [61] 
.const [20] = Field [62] [63] 
.const [21] = Field [64] [65] 
.const [22] = Method [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Field [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = Class [92] 
.const [36] = Class [93] 
.const [37] = InterfaceMethod [94] [95] 
.const [38] = InterfaceMethod [96] [97] 
.const [39] = InterfaceMethod [98] [99] 
.const [40] = InterfaceMethod [100] [101] 
.const [41] = InterfaceMethod [102] [103] 
.const [42] = Utf8 java/lang/StringBuffer 
.const [43] = Utf8 '[ServiceListenerStub:stub=' 
.const [44] = Utf8 ',attached=' 
.const [45] = Utf8 ']' 
.const [46] = Class [104] 
.const [47] = NameAndType [105] [106] 
.const [48] = Utf8 '{ ServiceListenerStubNotification: stub=%1 attached=%2' 
.const [49] = Utf8 java/lang/Boolean 
.const [50] = Utf8 de/esolutions/fw/comm/core/IServiceListener 
.const [51] = Utf8 ' + Callback Service Listener %1' 
.const [52] = Utf8 ' - Callback Service Listener %1' 
.const [53] = Utf8 '} ServiceListenerStubNotification' 
.const [54] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerStubNotification 
.const [55] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [56] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [57] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [58] = Utf8 java/util/List 
.const [59] = Utf8 java/util/ListIterator 
.const [60] = Class [107] 
.const [61] = NameAndType [108] [109] 
.const [62] = Class [110] 
.const [63] = NameAndType [111] [112] 
.const [64] = Class [113] 
.const [65] = NameAndType [114] [115] 
.const [66] = Class [116] 
.const [67] = NameAndType [117] [118] 
.const [68] = Class [119] 
.const [69] = NameAndType [120] [121] 
.const [70] = Class [122] 
.const [71] = NameAndType [123] [124] 
.const [72] = Class [125] 
.const [73] = NameAndType [126] [127] 
.const [74] = Class [128] 
.const [75] = NameAndType [129] [130] 
.const [76] = Class [131] 
.const [77] = NameAndType [132] [133] 
.const [78] = Class [134] 
.const [79] = NameAndType [135] [136] 
.const [80] = Class [137] 
.const [81] = NameAndType [138] [139] 
.const [82] = Class [140] 
.const [83] = NameAndType [141] [142] 
.const [84] = Class [143] 
.const [85] = NameAndType [144] [145] 
.const [86] = Class [146] 
.const [87] = NameAndType [147] [148] 
.const [88] = Class [149] 
.const [89] = NameAndType [150] [151] 
.const [90] = Class [152] 
.const [91] = NameAndType [153] [154] 
.const [92] = Utf8 java/lang/StringBuffer 
.const [93] = Utf8 java/lang/Boolean 
.const [94] = Class [155] 
.const [95] = NameAndType [156] [157] 
.const [96] = Class [158] 
.const [97] = NameAndType [159] [160] 
.const [98] = Class [161] 
.const [99] = NameAndType [162] [163] 
.const [100] = Class [164] 
.const [101] = NameAndType [165] [166] 
.const [102] = Class [167] 
.const [103] = NameAndType [168] [169] 
.const [104] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [105] = Utf8 NOTIFICATION 
.const [106] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [107] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerStubNotification 
.const [108] = Utf8 stub 
.const [109] = Utf8 Lde/esolutions/fw/comm/core/IStub; 
.const [110] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerStubNotification 
.const [111] = Utf8 listeners 
.const [112] = Utf8 Ljava/util/List; 
.const [113] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerStubNotification 
.const [114] = Utf8 attached 
.const [115] = Utf8 Z 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Utf8 append 
.const [118] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [119] = Utf8 java/lang/StringBuffer 
.const [120] = Utf8 append 
.const [121] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [122] = Utf8 java/lang/StringBuffer 
.const [123] = Utf8 append 
.const [124] = Utf8 (Z)Ljava/lang/StringBuffer; 
.const [125] = Utf8 java/lang/StringBuffer 
.const [126] = Utf8 toString 
.const [127] = Utf8 ()Ljava/lang/String; 
.const [128] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [129] = Utf8 log 
.const [130] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [131] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [132] = Utf8 log 
.const [133] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [134] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [135] = Utf8 log 
.const [136] = Utf8 (SLjava/lang/String;)Z 
.const [137] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 java/lang/StringBuffer 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 java/lang/Boolean 
.const [144] = Utf8 <init> 
.const [145] = Utf8 (Z)V 
.const [146] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerStubNotification 
.const [147] = Utf8 stub 
.const [148] = Utf8 Lde/esolutions/fw/comm/core/IStub; 
.const [149] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerStubNotification 
.const [150] = Utf8 listeners 
.const [151] = Utf8 Ljava/util/List; 
.const [152] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerStubNotification 
.const [153] = Utf8 attached 
.const [154] = Utf8 Z 
.const [155] = Utf8 java/util/List 
.const [156] = Utf8 listIterator 
.const [157] = Utf8 ()Ljava/util/ListIterator; 
.const [158] = Utf8 java/util/ListIterator 
.const [159] = Utf8 hasNext 
.const [160] = Utf8 ()Z 
.const [161] = Utf8 java/util/ListIterator 
.const [162] = Utf8 next 
.const [163] = Utf8 ()Ljava/lang/Object; 
.const [164] = Utf8 de/esolutions/fw/comm/core/IServiceListener 
.const [165] = Utf8 serviceStubAttached 
.const [166] = Utf8 (Lde/esolutions/fw/comm/core/IStub;)V 
.const [167] = Utf8 de/esolutions/fw/comm/core/IServiceListener 
.const [168] = Utf8 serviceStubDetached 
.const [169] = Utf8 (Lde/esolutions/fw/comm/core/IStub;)V 
.const [170] = Utf8 de/esolutions/fw/comm/agent/notification/ServiceListenerStubNotification 
.const [171] = Class [170] 
.const [172] = Utf8 de/esolutions/fw/comm/agent/notification/AbstractNotification 
.const [173] = Class [172] 
.const [174] = Utf8 stub 
.const [175] = Utf8 Lde/esolutions/fw/comm/core/IStub; 
.const [176] = Utf8 listeners 
.const [177] = Utf8 Ljava/util/List; 
.const [178] = Utf8 attached 
.const [179] = Utf8 Z 
.const [180] = Utf8 Code 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (Lde/esolutions/fw/comm/core/IStub;Ljava/util/List;Z)V 
.const [183] = Utf8 toString 
.const [184] = Utf8 ()Ljava/lang/String; 
.const [185] = Utf8 performNotification 
.const [186] = Utf8 ()V 
.end class 
