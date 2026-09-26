.version 50 0 
.class public super [136] 
.super [138] 
.implements [140] 
.field private final [141] [142] 
.field private final [143] [144] 
.field private [145] [146] 

.method public [148] : [149] 
    .attribute [147] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [27] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [28] 
L14:    aload_0 
L15:    new [29] 
L18:    dup 
L19:    invokespecial [25] 
L22:    putfield [30] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [150] : [151] 
    .attribute [147] .code stack 6 locals 4 
L0:     aload_0 
L1:     getfield [17] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [19] 
L14:    pop 
L15:    iload_2 
L16:    iconst_1 
L17:    if_icmpeq L33 
L20:    aload_0 
L21:    getfield [17] 
L24:    ldc [3] 
L26:    ldc [5] 
L28:    invokevirtual [20] 
L31:    pop 
L32:    return 
L33:    aload_1 
L34:    ifnonnull L50 
L37:    aload_0 
L38:    getfield [17] 
L41:    ldc [3] 
L43:    ldc [6] 
L45:    invokevirtual [20] 
L48:    pop 
L49:    return 
L50:    aload_0 
L51:    getfield [18] 
L54:    dup 
L55:    astore_3 
L56:    monitorenter 
L57:    aload_0 
L58:    getfield [18] 
L61:    invokevirtual [21] 
L64:    astore 4 
L66:    aload 4 
L68:    invokeinterface [31] 0 
L73:    ifeq L119 
        .catch [8] from L76 to L96 using L99 
        .catch [0] from L57 to L126 using L129 
L76:    aload 4 
L78:    invokeinterface [32] 0 
L83:    checkcast [7] 
L86:    astore 5 
L88:    aload 5 
L90:    aload_1 
L91:    invokeinterface [33] 0 
L96:    goto L66 
L99:    astore 5 
L101:   aload_0 
L102:   getfield [17] 
L105:   sipush 10000 
L108:   ldc [9] 
L110:   aload 5 
L112:   invokevirtual [22] 
L115:   pop 
L116:   goto L66 
L119:   aload_0 
L120:   aload_1 
L121:   putfield [27] 
L124:   aload_3 
L125:   monitorexit 
L126:   goto L136 
        .catch [0] from L129 to L133 using L129 
L129:   astore 6 
L131:   aload_3 
L132:   monitorexit 
L133:   aload 6 
L135:   athrow 
L136:   return 
L137:   nop 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 

.method public [152] : [153] 
    .attribute [147] .code stack 4 locals 0 
L0:     iconst_1 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     iconst_4 
L6:     iastore 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [154] : [155] 
    .attribute [147] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [18] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
L7:     aload_1 
L8:     ifnonnull L19 
L11:    new [34] 
L14:    dup 
L15:    invokespecial [26] 
L18:    athrow 
L19:    aload_0 
L20:    getfield [18] 
L23:    aload_1 
L24:    invokevirtual [23] 
L27:    pop 
L28:    aload_0 
L29:    getfield [16] 
L32:    ifnull L63 
        .catch [8] from L35 to L45 using L48 
        .catch [0] from L7 to L65 using L68 
L35:    aload_1 
L36:    aload_0 
L37:    getfield [16] 
L40:    invokeinterface [33] 0 
L45:    goto L63 
L48:    astore_3 
L49:    aload_0 
L50:    getfield [17] 
L53:    sipush 10000 
L56:    ldc [11] 
L58:    aload_3 
L59:    invokevirtual [22] 
L62:    pop 
L63:    aload_2 
L64:    monitorexit 
L65:    goto L75 
        .catch [0] from L68 to L72 using L68 
L68:    astore 4 
L70:    aload_2 
L71:    monitorexit 
L72:    aload 4 
L74:    athrow 
L75:    return 
L76:    
    .end code 
.end method 

.method public enum [156] : [157] 
    .attribute [147] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Int 1078071040 
.const [4] = String [36] 
.const [5] = String [37] 
.const [6] = String [38] 
.const [7] = Class [39] 
.const [8] = Class [40] 
.const [9] = String [41] 
.const [10] = Class [42] 
.const [11] = String [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Field [48] [49] 
.const [17] = Field [50] [51] 
.const [18] = Field [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Field [70] [71] 
.const [28] = Field [72] [73] 
.const [29] = Class [74] 
.const [30] = Field [75] [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = InterfaceMethod [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = Class [83] 
.const [35] = Utf8 java/util/ArrayList 
.const [36] = Utf8 'NaviDSICarKombiListener#updateBCViewOptions( %1, %2 )' 
.const [37] = Utf8 'NaviDSICarKombiListener#updateBCViewOptions() - update is invalid' 
.const [38] = Utf8 'NaviDSICarKombiListener#updateBCViewOptions() - options are null' 
.const [39] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiObserver 
.const [40] = Utf8 java/lang/Exception 
.const [41] = Utf8 'NaviDSICarKombiListener#updateBCViewOptions() - observer failed' 
.const [42] = Utf8 java/lang/IllegalArgumentException 
.const [43] = Utf8 'NaviDSICarKombiListener#registerListener() - observer failed' 
.const [44] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviDSICarKombiListener 
.const [45] = Utf8 de/audi/tghu/navi/app/car/kombi/AbstractNaviDSICarKombiListner 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 java/util/Iterator 
.const [48] = Class [84] 
.const [49] = NameAndType [85] [86] 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Class [90] 
.const [53] = NameAndType [91] [92] 
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
.const [72] = Class [120] 
.const [73] = NameAndType [121] [122] 
.const [74] = Utf8 java/util/ArrayList 
.const [75] = Class [123] 
.const [76] = NameAndType [124] [125] 
.const [77] = Class [126] 
.const [78] = NameAndType [127] [128] 
.const [79] = Class [129] 
.const [80] = NameAndType [130] [131] 
.const [81] = Class [132] 
.const [82] = NameAndType [133] [134] 
.const [83] = Utf8 java/lang/IllegalArgumentException 
.const [84] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviDSICarKombiListener 
.const [85] = Utf8 lastBCViewOptions 
.const [86] = Utf8 Lorg/dsi/ifc/carkombi/BCViewOptions; 
.const [87] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviDSICarKombiListener 
.const [88] = Utf8 logChannel 
.const [89] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [90] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviDSICarKombiListener 
.const [91] = Utf8 observersList 
.const [92] = Utf8 Ljava/util/ArrayList; 
.const [93] = Utf8 de/audi/atip/log/LogChannel 
.const [94] = Utf8 log 
.const [95] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [96] = Utf8 de/audi/atip/log/LogChannel 
.const [97] = Utf8 log 
.const [98] = Utf8 (ILjava/lang/String;)Z 
.const [99] = Utf8 java/util/ArrayList 
.const [100] = Utf8 iterator 
.const [101] = Utf8 ()Ljava/util/Iterator; 
.const [102] = Utf8 de/audi/atip/log/LogChannel 
.const [103] = Utf8 log 
.const [104] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [105] = Utf8 java/util/ArrayList 
.const [106] = Utf8 add 
.const [107] = Utf8 (Ljava/lang/Object;)Z 
.const [108] = Utf8 de/audi/tghu/navi/app/car/kombi/AbstractNaviDSICarKombiListner 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 java/util/ArrayList 
.const [112] = Utf8 <init> 
.const [113] = Utf8 ()V 
.const [114] = Utf8 java/lang/IllegalArgumentException 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviDSICarKombiListener 
.const [118] = Utf8 lastBCViewOptions 
.const [119] = Utf8 Lorg/dsi/ifc/carkombi/BCViewOptions; 
.const [120] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviDSICarKombiListener 
.const [121] = Utf8 logChannel 
.const [122] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [123] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviDSICarKombiListener 
.const [124] = Utf8 observersList 
.const [125] = Utf8 Ljava/util/ArrayList; 
.const [126] = Utf8 java/util/Iterator 
.const [127] = Utf8 hasNext 
.const [128] = Utf8 ()Z 
.const [129] = Utf8 java/util/Iterator 
.const [130] = Utf8 next 
.const [131] = Utf8 ()Ljava/lang/Object; 
.const [132] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiObserver 
.const [133] = Utf8 updateBCViewOptions 
.const [134] = Utf8 (Lorg/dsi/ifc/carkombi/BCViewOptions;)V 
.const [135] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviDSICarKombiListener 
.const [136] = Class [135] 
.const [137] = Utf8 de/audi/tghu/navi/app/car/kombi/AbstractNaviDSICarKombiListner 
.const [138] = Class [137] 
.const [139] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiEventsProvider 
.const [140] = Class [139] 
.const [141] = Utf8 logChannel 
.const [142] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [143] = Utf8 observersList 
.const [144] = Utf8 Ljava/util/ArrayList; 
.const [145] = Utf8 lastBCViewOptions 
.const [146] = Utf8 Lorg/dsi/ifc/carkombi/BCViewOptions; 
.const [147] = Utf8 Code 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [150] = Utf8 updateBCViewOptions 
.const [151] = Utf8 (Lorg/dsi/ifc/carkombi/BCViewOptions;I)V 
.const [152] = Utf8 getAutoNotifications 
.const [153] = Utf8 ()[I 
.const [154] = Utf8 registerListener 
.const [155] = Utf8 (Lde/audi/tghu/navi/app/car/kombi/ICarKombiObserver;)V 
.const [156] = Utf8 unregisterListener 
.const [157] = Utf8 (Lde/audi/tghu/navi/app/car/kombi/ICarKombiObserver;)V 
.end class 
