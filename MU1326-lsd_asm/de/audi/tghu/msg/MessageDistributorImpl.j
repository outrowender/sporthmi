.version 50 0 
.class public final super [151] 
.super [153] 
.implements [155] 
.field private final [156] [157] 
.field private final [158] [159] 
.field private volatile [160] [161] 

.method public [163] : [164] 
    .attribute [162] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     new [28] 
L8:     dup 
L9:     invokespecial [26] 
L12:    putfield [29] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [30] 
L20:    aload_0 
L21:    aload_0 
L22:    getfield [20] 
L25:    ldc [3] 
L27:    invokeinterface [31] 0 
L32:    putfield [32] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [162] .code stack 6 locals 3 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [22] 
L13:    pop 
L14:    aload_0 
L15:    getfield [19] 
L18:    invokeinterface [33] 0 
L23:    astore_2 
L24:    aconst_null 
L25:    astore_3 
L26:    aload_2 
L27:    invokeinterface [34] 0 
L32:    ifeq L89 
        .catch [9] from L35 to L65 using L68 
L35:    aload_2 
L36:    invokeinterface [35] 0 
L41:    checkcast [6] 
L44:    astore_3 
L45:    aload_0 
L46:    getfield [21] 
L49:    ldc [7] 
L51:    ldc [8] 
L53:    aload_3 
L54:    invokevirtual [23] 
L57:    pop 
L58:    aload_3 
L59:    iload_1 
L60:    invokeinterface [36] 0 
L65:    goto L26 
L68:    astore 4 
L70:    aload_0 
L71:    getfield [21] 
L74:    sipush 10000 
L77:    ldc [10] 
L79:    iload_1 
L80:    i2l 
L81:    aload 4 
L83:    invokevirtual [24] 
L86:    goto L26 
L89:    return 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method synchronized [167] : [168] 
    .attribute [162] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [4] 
L6:     ldc [11] 
L8:     aload_1 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_1 
L14:    ifnonnull L18 
L17:    return 
L18:    new [28] 
L21:    dup 
L22:    aload_0 
L23:    getfield [19] 
L26:    invokespecial [27] 
L29:    astore_2 
L30:    aload_2 
L31:    aload_1 
L32:    invokeinterface [37] 0 
L37:    pop 
L38:    aload_0 
L39:    aload_2 
L40:    putfield [29] 
L43:    return 
L44:    
    .end code 
.end method 

.method synchronized [169] : [170] 
    .attribute [162] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [4] 
L6:     ldc [12] 
L8:     aload_1 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_1 
L14:    ifnonnull L18 
L17:    return 
L18:    new [28] 
L21:    dup 
L22:    aload_0 
L23:    getfield [19] 
L26:    invokespecial [27] 
L29:    astore_2 
L30:    aload_2 
L31:    aload_1 
L32:    invokeinterface [38] 0 
L37:    pop 
L38:    aload_0 
L39:    aload_2 
L40:    putfield [29] 
L43:    return 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [39] 
.const [3] = String [40] 
.const [4] = Int 1078071040 
.const [5] = String [41] 
.const [6] = Class [42] 
.const [7] = Int -2137614336 
.const [8] = String [43] 
.const [9] = Class [44] 
.const [10] = String [45] 
.const [11] = String [46] 
.const [12] = String [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Class [52] 
.const [18] = Class [53] 
.const [19] = Field [54] [55] 
.const [20] = Field [56] [57] 
.const [21] = Field [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Class [72] 
.const [29] = Field [73] [74] 
.const [30] = Field [75] [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = Field [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = InterfaceMethod [83] [84] 
.const [35] = InterfaceMethod [85] [86] 
.const [36] = InterfaceMethod [87] [88] 
.const [37] = InterfaceMethod [89] [90] 
.const [38] = InterfaceMethod [91] [92] 
.const [39] = Utf8 java/util/LinkedList 
.const [40] = Utf8 'Fw.Message.Main' 
.const [41] = Utf8 'MessageDistributorImpl.sendMessage(msgType=%1)' 
.const [42] = Utf8 de/audi/atip/msg/MsgListener 
.const [43] = Utf8 'MessageDistributorImpl.sendMessage: Send message to listener %1!' 
.const [44] = Utf8 java/lang/Exception 
.const [45] = Utf8 'MessageDistributorImpl.sendMessage; Message processing failed! (msgType=%1)' 
.const [46] = Utf8 'MessageDistributorImpl.addListener(listener=%1)' 
.const [47] = Utf8 'MessageDistributorImpl.removeListener(listener=%1)' 
.const [48] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [51] = Utf8 de/audi/atip/log/LogChannel 
.const [52] = Utf8 java/util/List 
.const [53] = Utf8 java/util/Iterator 
.const [54] = Class [93] 
.const [55] = NameAndType [94] [95] 
.const [56] = Class [96] 
.const [57] = NameAndType [97] [98] 
.const [58] = Class [99] 
.const [59] = NameAndType [100] [101] 
.const [60] = Class [102] 
.const [61] = NameAndType [103] [104] 
.const [62] = Class [105] 
.const [63] = NameAndType [106] [107] 
.const [64] = Class [108] 
.const [65] = NameAndType [109] [110] 
.const [66] = Class [111] 
.const [67] = NameAndType [112] [113] 
.const [68] = Class [114] 
.const [69] = NameAndType [115] [116] 
.const [70] = Class [117] 
.const [71] = NameAndType [118] [119] 
.const [72] = Utf8 java/util/LinkedList 
.const [73] = Class [120] 
.const [74] = NameAndType [121] [122] 
.const [75] = Class [123] 
.const [76] = NameAndType [124] [125] 
.const [77] = Class [126] 
.const [78] = NameAndType [127] [128] 
.const [79] = Class [129] 
.const [80] = NameAndType [130] [131] 
.const [81] = Class [132] 
.const [82] = NameAndType [133] [134] 
.const [83] = Class [135] 
.const [84] = NameAndType [136] [137] 
.const [85] = Class [138] 
.const [86] = NameAndType [139] [140] 
.const [87] = Class [141] 
.const [88] = NameAndType [142] [143] 
.const [89] = Class [144] 
.const [90] = NameAndType [145] [146] 
.const [91] = Class [147] 
.const [92] = NameAndType [148] [149] 
.const [93] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [94] = Utf8 listeners 
.const [95] = Utf8 Ljava/util/List; 
.const [96] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [97] = Utf8 framework 
.const [98] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [99] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [100] = Utf8 logChannel 
.const [101] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [102] = Utf8 de/audi/atip/log/LogChannel 
.const [103] = Utf8 log 
.const [104] = Utf8 (ILjava/lang/String;J)Z 
.const [105] = Utf8 de/audi/atip/log/LogChannel 
.const [106] = Utf8 log 
.const [107] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [108] = Utf8 de/audi/atip/log/LogChannel 
.const [109] = Utf8 log 
.const [110] = Utf8 (ILjava/lang/String;JLjava/lang/Throwable;)V 
.const [111] = Utf8 java/lang/Object 
.const [112] = Utf8 <init> 
.const [113] = Utf8 ()V 
.const [114] = Utf8 java/util/LinkedList 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 java/util/LinkedList 
.const [118] = Utf8 <init> 
.const [119] = Utf8 (Ljava/util/Collection;)V 
.const [120] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [121] = Utf8 listeners 
.const [122] = Utf8 Ljava/util/List; 
.const [123] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [124] = Utf8 framework 
.const [125] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [126] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [127] = Utf8 getLogChannel 
.const [128] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [129] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [130] = Utf8 logChannel 
.const [131] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [132] = Utf8 java/util/List 
.const [133] = Utf8 listIterator 
.const [134] = Utf8 ()Ljava/util/ListIterator; 
.const [135] = Utf8 java/util/Iterator 
.const [136] = Utf8 hasNext 
.const [137] = Utf8 ()Z 
.const [138] = Utf8 java/util/Iterator 
.const [139] = Utf8 next 
.const [140] = Utf8 ()Ljava/lang/Object; 
.const [141] = Utf8 de/audi/atip/msg/MsgListener 
.const [142] = Utf8 processMsg 
.const [143] = Utf8 (I)V 
.const [144] = Utf8 java/util/List 
.const [145] = Utf8 add 
.const [146] = Utf8 (Ljava/lang/Object;)Z 
.const [147] = Utf8 java/util/List 
.const [148] = Utf8 remove 
.const [149] = Utf8 (Ljava/lang/Object;)Z 
.const [150] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [151] = Class [150] 
.const [152] = Utf8 java/lang/Object 
.const [153] = Class [152] 
.const [154] = Utf8 de/audi/atip/msg/MsgDistributor 
.const [155] = Class [154] 
.const [156] = Utf8 framework 
.const [157] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [158] = Utf8 logChannel 
.const [159] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [160] = Utf8 listeners 
.const [161] = Utf8 Ljava/util/List; 
.const [162] = Utf8 Code 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [165] = Utf8 sendMessage 
.const [166] = Utf8 (I)V 
.const [167] = Utf8 addListener 
.const [168] = Utf8 (Lde/audi/atip/msg/MsgListener;)V 
.const [169] = Utf8 removeListener 
.const [170] = Utf8 (Lde/audi/atip/msg/MsgListener;)V 
.end class 
