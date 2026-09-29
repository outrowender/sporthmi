.version 50 0 
.class public super [99] 
.super [101] 
.field private [102] [103] 
.field private [104] [105] 
.field private [106] [107] 

.method public [109] : [110] 
    .attribute [108] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     new [17] 
L8:     dup 
L9:     iconst_1 
L10:    invokespecial [16] 
L13:    putfield [18] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [111] : [112] 
    .attribute [108] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [19] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [113] : [114] 
    .attribute [108] .code stack 4 locals 4 
L0:     new [17] 
L3:     dup 
L4:     aload_1 
L5:     arraylength 
L6:     iconst_1 
L7:     iadd 
L8:     invokespecial [16] 
L11:    astore_2 
L12:    iconst_0 
L13:    istore_3 
L14:    iload_3 
L15:    aload_1 
L16:    arraylength 
L17:    if_icmpge L91 
L20:    aload_1 
L21:    iload_3 
L22:    aaload 
L23:    astore 4 
L25:    aload 4 
L27:    invokevirtual [9] 
L30:    ifeq L85 
L33:    aload_0 
L34:    getfield [7] 
L37:    aload 4 
L39:    getfield [10] 
L42:    l2i 
L43:    invokevirtual [11] 
L46:    checkcast [3] 
L49:    astore 5 
L51:    aload 5 
L53:    ifnull L70 
L56:    aload_0 
L57:    getfield [8] 
L60:    ifeq L70 
L63:    aload 4 
L65:    aload 5 
L67:    putfield [20] 
L70:    aload_2 
L71:    aload 4 
L73:    getfield [10] 
L76:    l2i 
L77:    aload 4 
L79:    getfield [12] 
L82:    invokevirtual [13] 
L85:    iinc 3 1 
L88:    goto L14 
L91:    aload_0 
L92:    getfield [7] 
L95:    aload_0 
L96:    getfield [14] 
L99:    invokevirtual [11] 
L102:   checkcast [3] 
L105:   astore_3 
L106:   aload_3 
L107:   ifnull L119 
L110:   aload_2 
L111:   aload_0 
L112:   getfield [14] 
L115:   aload_3 
L116:   invokevirtual [13] 
L119:   aload_0 
L120:   aload_2 
L121:   putfield [18] 
L124:   aload_1 
L125:   areturn 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public synchronized [115] : [116] 
    .attribute [108] .code stack 3 locals 1 
L0:     aload_1 
L1:     invokevirtual [9] 
L4:     ifeq L64 
L7:     aload_0 
L8:     getfield [7] 
L11:    aload_1 
L12:    getfield [10] 
L15:    l2i 
L16:    invokevirtual [11] 
L19:    checkcast [3] 
L22:    astore_2 
L23:    aload_2 
L24:    ifnull L39 
L27:    aload_0 
L28:    getfield [8] 
L31:    ifeq L39 
L34:    aload_1 
L35:    aload_2 
L36:    putfield [20] 
L39:    aload_0 
L40:    getfield [7] 
L43:    aload_1 
L44:    getfield [10] 
L47:    l2i 
L48:    aload_1 
L49:    getfield [12] 
L52:    invokevirtual [13] 
L55:    aload_0 
L56:    aload_1 
L57:    getfield [10] 
L60:    l2i 
L61:    putfield [21] 
L64:    aload_1 
L65:    areturn 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Class [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Field [27] [28] 
.const [8] = Field [29] [30] 
.const [9] = Method [31] [32] 
.const [10] = Field [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Field [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Field [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Class [47] 
.const [18] = Field [48] [49] 
.const [19] = Field [50] [51] 
.const [20] = Field [52] [53] 
.const [21] = Field [54] [55] 
.const [22] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [23] = Utf8 java/lang/String 
.const [24] = Utf8 de/audi/tuner/app/amfm/StationNameHistory 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [27] = Class [56] 
.const [28] = NameAndType [57] [58] 
.const [29] = Class [59] 
.const [30] = NameAndType [60] [61] 
.const [31] = Class [62] 
.const [32] = NameAndType [63] [64] 
.const [33] = Class [65] 
.const [34] = NameAndType [66] [67] 
.const [35] = Class [68] 
.const [36] = NameAndType [69] [70] 
.const [37] = Class [71] 
.const [38] = NameAndType [72] [73] 
.const [39] = Class [74] 
.const [40] = NameAndType [75] [76] 
.const [41] = Class [77] 
.const [42] = NameAndType [78] [79] 
.const [43] = Class [80] 
.const [44] = NameAndType [81] [82] 
.const [45] = Class [83] 
.const [46] = NameAndType [84] [85] 
.const [47] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Utf8 de/audi/tuner/app/amfm/StationNameHistory 
.const [57] = Utf8 nameHistory 
.const [58] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [59] = Utf8 de/audi/tuner/app/amfm/StationNameHistory 
.const [60] = Utf8 fixed 
.const [61] = Utf8 Z 
.const [62] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [63] = Utf8 isRds 
.const [64] = Utf8 ()Z 
.const [65] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [66] = Utf8 frequency 
.const [67] = Utf8 J 
.const [68] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [69] = Utf8 get 
.const [70] = Utf8 (I)Ljava/lang/Object; 
.const [71] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [72] = Utf8 name 
.const [73] = Utf8 Ljava/lang/String; 
.const [74] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [75] = Utf8 add 
.const [76] = Utf8 (ILjava/lang/Object;)V 
.const [77] = Utf8 de/audi/tuner/app/amfm/StationNameHistory 
.const [78] = Utf8 activeFrequency 
.const [79] = Utf8 I 
.const [80] = Utf8 java/lang/Object 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (I)V 
.const [86] = Utf8 de/audi/tuner/app/amfm/StationNameHistory 
.const [87] = Utf8 nameHistory 
.const [88] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [89] = Utf8 de/audi/tuner/app/amfm/StationNameHistory 
.const [90] = Utf8 fixed 
.const [91] = Utf8 Z 
.const [92] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [93] = Utf8 name 
.const [94] = Utf8 Ljava/lang/String; 
.const [95] = Utf8 de/audi/tuner/app/amfm/StationNameHistory 
.const [96] = Utf8 activeFrequency 
.const [97] = Utf8 I 
.const [98] = Utf8 de/audi/tuner/app/amfm/StationNameHistory 
.const [99] = Class [98] 
.const [100] = Utf8 java/lang/Object 
.const [101] = Class [100] 
.const [102] = Utf8 nameHistory 
.const [103] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [104] = Utf8 fixed 
.const [105] = Utf8 Z 
.const [106] = Utf8 activeFrequency 
.const [107] = Utf8 I 
.const [108] = Utf8 Code 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 setStationDisplayModeFixed 
.const [112] = Utf8 (Z)V 
.const [113] = Utf8 updateStationList 
.const [114] = Utf8 ([Lde/audi/tuner/app/amfm/AMFMStation;)[Lde/audi/tuner/app/amfm/AMFMStation; 
.const [115] = Utf8 updateActiveStation 
.const [116] = Utf8 (Lde/audi/tuner/app/amfm/AMFMStation;)Lde/audi/tuner/app/amfm/AMFMStation; 
.end class 
