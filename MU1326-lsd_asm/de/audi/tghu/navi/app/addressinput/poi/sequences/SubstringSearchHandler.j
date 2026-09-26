.version 50 0 
.class public super [125] 
.super [127] 
.implements [129] 
.field private final [130] [131] 
.field private [132] [133] 
.field private final [134] [135] 

.method public [137] : [138] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     aload_2 
L6:     putfield [28] 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [17] 
L14:    putfield [29] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [139] : [140] 
    .attribute [136] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [19] 
L7:     ifeq L23 
L10:    aload_0 
L11:    getfield [18] 
L14:    ldc [2] 
L16:    ldc [3] 
L18:    aload_1 
L19:    invokevirtual [20] 
L22:    pop 
L23:    aload_0 
L24:    iconst_0 
L25:    putfield [30] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public synchronized [141] : [142] 
    .attribute [136] .code stack 5 locals 3 
L0:     aload_1 
L1:     invokevirtual [22] 
L4:     istore_2 
L5:     aload_0 
L6:     getfield [18] 
L9:     ldc [4] 
L11:    ldc [5] 
L13:    iload_2 
L14:    i2l 
L15:    invokevirtual [23] 
L18:    pop 
L19:    iload_2 
L20:    ifne L36 
L23:    aload_0 
L24:    getfield [18] 
L27:    ldc [4] 
L29:    ldc [6] 
L31:    invokevirtual [24] 
L34:    pop 
L35:    return 
L36:    iload_2 
L37:    iconst_1 
L38:    if_icmpne L59 
L41:    aload_0 
L42:    getfield [18] 
L45:    ldc [4] 
L47:    ldc [7] 
L49:    invokevirtual [24] 
L52:    pop 
L53:    aload_0 
L54:    iconst_0 
L55:    putfield [30] 
L58:    return 
L59:    aload_1 
L60:    invokevirtual [25] 
L63:    istore_3 
L64:    aload_1 
L65:    invokevirtual [26] 
L68:    istore 4 
L70:    iload_2 
L71:    iconst_2 
L72:    if_icmpne L101 
L75:    iload 4 
L77:    ifne L101 
L80:    iload_3 
L81:    ifne L101 
L84:    aload_0 
L85:    getfield [18] 
L88:    ldc [4] 
L90:    ldc [8] 
L92:    invokevirtual [24] 
L95:    pop 
L96:    aload_0 
L97:    iconst_1 
L98:    putfield [30] 
L101:   aload_0 
L102:   getfield [21] 
L105:   ifne L121 
L108:   aload_0 
L109:   getfield [18] 
L112:   ldc [4] 
L114:   ldc [9] 
L116:   invokevirtual [24] 
L119:   pop 
L120:   return 
L121:   iload_2 
L122:   iconst_3 
L123:   if_icmpne L131 
L126:   aload_0 
L127:   iconst_0 
L128:   putfield [30] 
L131:   aload_0 
L132:   getfield [16] 
L135:   ifnull L148 
L138:   aload_0 
L139:   getfield [16] 
L142:   aload_1 
L143:   invokeinterface [31] 0 
L148:   return 
L149:   nop 
L150:   nop 
L151:   nop 
L152:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 14808325 
.const [3] = String [32] 
.const [4] = Int -2137614336 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = String [36] 
.const [9] = String [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Class [42] 
.const [15] = Class [43] 
.const [16] = Field [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Field [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Field [54] [55] 
.const [22] = Method [56] [57] 
.const [23] = Method [58] [59] 
.const [24] = Method [60] [61] 
.const [25] = Method [62] [63] 
.const [26] = Method [64] [65] 
.const [27] = Method [66] [67] 
.const [28] = Field [68] [69] 
.const [29] = Field [70] [71] 
.const [30] = Field [72] [73] 
.const [31] = InterfaceMethod [74] [75] 
.const [32] = Utf8 'SubstringSearchHandler#stopSearch(%1)' 
.const [33] = Utf8 'SubstringSearchHandler#updatePoiSubstringSearchStatus() - status=%1' 
.const [34] = Utf8 'SubstringSearchHandler#updatePoiSubstringSearchStatus() - status is invalid.' 
.const [35] = Utf8 'SubstringSearchHandler#updatePoiSubstringSearchStatus() - The search has been canceled.' 
.const [36] = Utf8 'SubstringSearchHandler#updatePoiSubstringSearchStatus() - search is starting.' 
.const [37] = Utf8 'SubstringSearchHandler#updatePoiSubstringSearchStatus() - update was received but no search was started.' 
.const [38] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/SubstringSearchHandler 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [41] = Utf8 de/audi/atip/log/LogChannel 
.const [42] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [43] = Utf8 de/audi/tghu/navi/app/addressinput/poi/models/ISubstringSearchModelAccess 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Class [82] 
.const [49] = NameAndType [83] [84] 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Class [97] 
.const [59] = NameAndType [98] [99] 
.const [60] = Class [100] 
.const [61] = NameAndType [101] [102] 
.const [62] = Class [103] 
.const [63] = NameAndType [104] [105] 
.const [64] = Class [106] 
.const [65] = NameAndType [107] [108] 
.const [66] = Class [109] 
.const [67] = NameAndType [110] [111] 
.const [68] = Class [112] 
.const [69] = NameAndType [113] [114] 
.const [70] = Class [115] 
.const [71] = NameAndType [116] [117] 
.const [72] = Class [118] 
.const [73] = NameAndType [119] [120] 
.const [74] = Class [121] 
.const [75] = NameAndType [122] [123] 
.const [76] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/SubstringSearchHandler 
.const [77] = Utf8 modelAccess 
.const [78] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/models/ISubstringSearchModelAccess; 
.const [79] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [80] = Utf8 getPOILogChannel 
.const [81] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [82] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/SubstringSearchHandler 
.const [83] = Utf8 logChannel 
.const [84] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [85] = Utf8 de/audi/atip/log/LogChannel 
.const [86] = Utf8 isDebug2 
.const [87] = Utf8 ()Z 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 log 
.const [90] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [91] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/SubstringSearchHandler 
.const [92] = Utf8 substringSearchStarted 
.const [93] = Utf8 Z 
.const [94] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [95] = Utf8 getStatus 
.const [96] = Utf8 ()I 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;J)Z 
.const [100] = Utf8 de/audi/atip/log/LogChannel 
.const [101] = Utf8 log 
.const [102] = Utf8 (ILjava/lang/String;)Z 
.const [103] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [104] = Utf8 getNumberOfAvailableItems 
.const [105] = Utf8 ()I 
.const [106] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [107] = Utf8 getDistance 
.const [108] = Utf8 ()I 
.const [109] = Utf8 java/lang/Object 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/SubstringSearchHandler 
.const [113] = Utf8 modelAccess 
.const [114] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/models/ISubstringSearchModelAccess; 
.const [115] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/SubstringSearchHandler 
.const [116] = Utf8 logChannel 
.const [117] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [118] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/SubstringSearchHandler 
.const [119] = Utf8 substringSearchStarted 
.const [120] = Utf8 Z 
.const [121] = Utf8 de/audi/tghu/navi/app/addressinput/poi/models/ISubstringSearchModelAccess 
.const [122] = Utf8 onUpdateSearchStatus 
.const [123] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)V 
.const [124] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/SubstringSearchHandler 
.const [125] = Class [124] 
.const [126] = Utf8 java/lang/Object 
.const [127] = Class [126] 
.const [128] = Utf8 de/audi/tghu/navi/app/addressinput/poi/IPoiSubstringSearchListener 
.const [129] = Class [128] 
.const [130] = Utf8 modelAccess 
.const [131] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/models/ISubstringSearchModelAccess; 
.const [132] = Utf8 substringSearchStarted 
.const [133] = Utf8 Z 
.const [134] = Utf8 logChannel 
.const [135] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [136] = Utf8 Code 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/addressinput/poi/models/ISubstringSearchModelAccess;)V 
.const [139] = Utf8 stopSearch 
.const [140] = Utf8 (Ljava/lang/String;)V 
.const [141] = Utf8 updatePoiSubstringSearchStatus 
.const [142] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)V 
.end class 
