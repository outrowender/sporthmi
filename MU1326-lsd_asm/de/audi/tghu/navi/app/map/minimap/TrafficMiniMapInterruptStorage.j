.version 50 0 
.class public super [143] 
.super [145] 
.field private [146] [147] 
.field private [148] [149] 

.method public [151] : [152] 
    .attribute [150] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [32] 
L9:     aload_0 
L10:    new [33] 
L13:    dup 
L14:    invokespecial [29] 
L17:    putfield [34] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [150] .code stack 7 locals 5 
L0:     iconst_0 
L1:     anewarray [3] 
L4:     astore_2 
L5:     aconst_null 
L6:     aload_1 
L7:     if_acmpeq L186 
L10:    aconst_null 
L11:    astore_3 
L12:    aconst_null 
L13:    astore 4 
L15:    new [35] 
L18:    dup 
L19:    invokespecial [30] 
L22:    astore 5 
L24:    iconst_0 
L25:    istore 6 
L27:    iload 6 
L29:    aload_1 
L30:    arraylength 
L31:    if_icmpge L170 
L34:    aload_0 
L35:    getfield [16] 
L38:    ldc [5] 
L40:    ldc [6] 
L42:    iconst_1 
L43:    iload 6 
L45:    iadd 
L46:    i2l 
L47:    aload_1 
L48:    arraylength 
L49:    i2l 
L50:    invokevirtual [18] 
L53:    pop 
L54:    aload_1 
L55:    iload 6 
L57:    aaload 
L58:    astore_3 
L59:    aconst_null 
L60:    aload_3 
L61:    if_acmpne L82 
L64:    aload_0 
L65:    getfield [16] 
L68:    ldc [7] 
L70:    ldc [8] 
L72:    iload 6 
L74:    i2l 
L75:    invokevirtual [19] 
L78:    pop 
L79:    goto L164 
L82:    new [36] 
L85:    dup 
L86:    aload_3 
L87:    invokevirtual [20] 
L90:    invokespecial [31] 
L93:    astore 4 
L95:    aload_0 
L96:    getfield [17] 
L99:    aload 4 
L101:   invokevirtual [21] 
L104:   ifeq L124 
L107:   aload_0 
L108:   getfield [16] 
L111:   ldc [5] 
L113:   ldc [10] 
L115:   aload 4 
L117:   invokevirtual [22] 
L120:   pop 
L121:   goto L164 
L124:   aload_0 
L125:   getfield [16] 
L128:   ldc [5] 
L130:   ldc [11] 
L132:   aload 4 
L134:   aload_0 
L135:   getfield [17] 
L138:   invokevirtual [23] 
L141:   i2l 
L142:   invokevirtual [24] 
L145:   pop 
L146:   aload_0 
L147:   getfield [17] 
L150:   aload 4 
L152:   aconst_null 
L153:   invokevirtual [25] 
L156:   pop 
L157:   aload 5 
L159:   aload_3 
L160:   invokevirtual [26] 
L163:   pop 
L164:   iinc 6 1 
L167:   goto L27 
L170:   aload 5 
L172:   iconst_0 
L173:   anewarray [3] 
L176:   invokevirtual [27] 
L179:   checkcast [12] 
L182:   checkcast [12] 
L185:   astore_2 
L186:   aload_2 
L187:   areturn 
L188:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [37] 
.const [3] = Class [38] 
.const [4] = Class [39] 
.const [5] = Int 1078071040 
.const [6] = String [40] 
.const [7] = Int -1601830656 
.const [8] = String [41] 
.const [9] = Class [42] 
.const [10] = String [43] 
.const [11] = String [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Field [49] [50] 
.const [17] = Field [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Method [79] [80] 
.const [32] = Field [81] [82] 
.const [33] = Class [83] 
.const [34] = Field [84] [85] 
.const [35] = Class [86] 
.const [36] = Class [87] 
.const [37] = Utf8 java/util/HashMap 
.const [38] = Utf8 org/dsi/ifc/asiatrafficinfomenu/Interrupt 
.const [39] = Utf8 java/util/ArrayList 
.const [40] = Utf8 'TrafficMiniMapInterruptStorage#getNewInterrupts %1 of %2' 
.const [41] = Utf8 'TrafficMiniMapInterruptStorage#getNewInterrupts interrupts[%1] nulled! -> continue' 
.const [42] = Utf8 java/lang/Integer 
.const [43] = Utf8 'TrafficMiniMapInterruptStorage#getNewInterrupts %1 is already in cache.' 
.const [44] = Utf8 'TrafficMiniMapInterruptStorage#getNewInterrupts adding id=%1 to cache (size was %2 before).' 
.const [45] = Utf8 [Lorg/dsi/ifc/asiatrafficinfomenu/Interrupt; 
.const [46] = Utf8 de/audi/tghu/navi/app/map/minimap/TrafficMiniMapInterruptStorage 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Class [124] 
.const [74] = NameAndType [125] [126] 
.const [75] = Class [127] 
.const [76] = NameAndType [128] [129] 
.const [77] = Class [130] 
.const [78] = NameAndType [131] [132] 
.const [79] = Class [133] 
.const [80] = NameAndType [134] [135] 
.const [81] = Class [136] 
.const [82] = NameAndType [137] [138] 
.const [83] = Utf8 java/util/HashMap 
.const [84] = Class [139] 
.const [85] = NameAndType [140] [141] 
.const [86] = Utf8 java/util/ArrayList 
.const [87] = Utf8 java/lang/Integer 
.const [88] = Utf8 de/audi/tghu/navi/app/map/minimap/TrafficMiniMapInterruptStorage 
.const [89] = Utf8 logger 
.const [90] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [91] = Utf8 de/audi/tghu/navi/app/map/minimap/TrafficMiniMapInterruptStorage 
.const [92] = Utf8 storage 
.const [93] = Utf8 Ljava/util/HashMap; 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;JJ)Z 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;J)Z 
.const [100] = Utf8 org/dsi/ifc/asiatrafficinfomenu/Interrupt 
.const [101] = Utf8 getInterruptId 
.const [102] = Utf8 ()I 
.const [103] = Utf8 java/util/HashMap 
.const [104] = Utf8 containsKey 
.const [105] = Utf8 (Ljava/lang/Object;)Z 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [109] = Utf8 java/util/HashMap 
.const [110] = Utf8 size 
.const [111] = Utf8 ()I 
.const [112] = Utf8 de/audi/atip/log/LogChannel 
.const [113] = Utf8 log 
.const [114] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [115] = Utf8 java/util/HashMap 
.const [116] = Utf8 put 
.const [117] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [118] = Utf8 java/util/ArrayList 
.const [119] = Utf8 add 
.const [120] = Utf8 (Ljava/lang/Object;)Z 
.const [121] = Utf8 java/util/ArrayList 
.const [122] = Utf8 toArray 
.const [123] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [124] = Utf8 java/lang/Object 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 java/util/HashMap 
.const [128] = Utf8 <init> 
.const [129] = Utf8 ()V 
.const [130] = Utf8 java/util/ArrayList 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 java/lang/Integer 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (I)V 
.const [136] = Utf8 de/audi/tghu/navi/app/map/minimap/TrafficMiniMapInterruptStorage 
.const [137] = Utf8 logger 
.const [138] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [139] = Utf8 de/audi/tghu/navi/app/map/minimap/TrafficMiniMapInterruptStorage 
.const [140] = Utf8 storage 
.const [141] = Utf8 Ljava/util/HashMap; 
.const [142] = Utf8 de/audi/tghu/navi/app/map/minimap/TrafficMiniMapInterruptStorage 
.const [143] = Class [142] 
.const [144] = Utf8 java/lang/Object 
.const [145] = Class [144] 
.const [146] = Utf8 storage 
.const [147] = Utf8 Ljava/util/HashMap; 
.const [148] = Utf8 logger 
.const [149] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [150] = Utf8 Code 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [153] = Utf8 getNewInterrupts 
.const [154] = Utf8 ([Lorg/dsi/ifc/asiatrafficinfomenu/Interrupt;)[Lorg/dsi/ifc/asiatrafficinfomenu/Interrupt; 
.end class 
