.version 50 0 
.class public super [123] 
.super [125] 
.field final [126] [127] 
.field final [128] [129] 
.field final [130] [131] 
.field final [132] [133] 
.field final [134] [135] 

.method public [137] : [138] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [24] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [25] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [26] 
L19:    aload_0 
L20:    iload 4 
L22:    putfield [27] 
L25:    aload_0 
L26:    iload 5 
L28:    putfield [28] 
L31:    return 
L32:    
    .end code 
.end method 

.method public interface [139] : [140] 
    .attribute [136] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [141] : [142] 
    .attribute [136] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [143] : [144] 
    .attribute [136] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [145] : [146] 
    .attribute [136] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [147] : [148] 
    .attribute [136] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [136] .code stack 2 locals 1 
L0:     new [29] 
L3:     dup 
L4:     invokespecial [23] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [3] 
L11:    invokevirtual [18] 
L14:    pop 
L15:    aload_1 
L16:    ldc [4] 
L18:    invokevirtual [18] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [13] 
L27:    invokevirtual [19] 
L30:    pop 
L31:    aload_1 
L32:    ldc [5] 
L34:    invokevirtual [18] 
L37:    pop 
L38:    aload_1 
L39:    ldc [6] 
L41:    invokevirtual [18] 
L44:    pop 
L45:    aload_1 
L46:    aload_0 
L47:    getfield [14] 
L50:    invokevirtual [19] 
L53:    pop 
L54:    aload_1 
L55:    ldc [5] 
L57:    invokevirtual [18] 
L60:    pop 
L61:    aload_1 
L62:    ldc [7] 
L64:    invokevirtual [18] 
L67:    pop 
L68:    aload_1 
L69:    aload_0 
L70:    getfield [15] 
L73:    invokevirtual [19] 
L76:    pop 
L77:    aload_1 
L78:    ldc [5] 
L80:    invokevirtual [18] 
L83:    pop 
L84:    aload_1 
L85:    ldc [8] 
L87:    invokevirtual [18] 
L90:    pop 
L91:    aload_1 
L92:    aload_0 
L93:    getfield [16] 
L96:    invokevirtual [19] 
L99:    pop 
L100:   aload_1 
L101:   ldc [5] 
L103:   invokevirtual [18] 
L106:   pop 
L107:   aload_1 
L108:   ldc [9] 
L110:   invokevirtual [18] 
L113:   pop 
L114:   aload_1 
L115:   aload_0 
L116:   getfield [17] 
L119:   invokevirtual [20] 
L122:   pop 
L123:   aload_1 
L124:   ldc [10] 
L126:   invokevirtual [18] 
L129:   pop 
L130:   aload_1 
L131:   invokevirtual [21] 
L134:   areturn 
L135:   nop 
L136:   
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [136] .code stack 3 locals 6 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifeq L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    istore_1 
L13:    aload_0 
L14:    getfield [14] 
L17:    ifeq L24 
L20:    iconst_1 
L21:    goto L25 
L24:    iconst_0 
L25:    istore_2 
L26:    aload_0 
L27:    getfield [15] 
L30:    ifeq L37 
L33:    iconst_1 
L34:    goto L38 
L37:    iconst_0 
L38:    istore_3 
L39:    aload_0 
L40:    getfield [16] 
L43:    ifeq L50 
L46:    iconst_1 
L47:    goto L51 
L50:    iconst_0 
L51:    istore 4 
L53:    iconst_1 
L54:    istore 6 
L56:    bipush 31 
L58:    iload 6 
L60:    iload_1 
L61:    iadd 
L62:    iload_2 
L63:    iadd 
L64:    iload_3 
L65:    iadd 
L66:    iload 4 
L68:    iadd 
L69:    aload_0 
L70:    getfield [17] 
L73:    iadd 
L74:    imul 
L75:    istore 6 
L77:    iload 6 
L79:    areturn 
L80:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [136] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [11] 
L4:     ifeq L73 
L7:     aload_1 
L8:     checkcast [11] 
L11:    astore_2 
L12:    aload_2 
L13:    getfield [13] 
L16:    aload_0 
L17:    getfield [13] 
L20:    if_icmpne L71 
L23:    aload_2 
L24:    getfield [14] 
L27:    aload_0 
L28:    getfield [14] 
L31:    if_icmpne L71 
L34:    aload_2 
L35:    getfield [15] 
L38:    aload_0 
L39:    getfield [15] 
L42:    if_icmpne L71 
L45:    aload_2 
L46:    getfield [16] 
L49:    aload_0 
L50:    getfield [16] 
L53:    if_icmpne L71 
L56:    aload_2 
L57:    getfield [17] 
L60:    aload_0 
L61:    getfield [17] 
L64:    if_icmpne L71 
L67:    iconst_1 
L68:    goto L72 
L71:    iconst_0 
L72:    areturn 
L73:    iconst_0 
L74:    areturn 
L75:    nop 
L76:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = String [31] 
.const [4] = String [32] 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = String [36] 
.const [9] = String [37] 
.const [10] = String [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Field [41] [42] 
.const [14] = Field [43] [44] 
.const [15] = Field [45] [46] 
.const [16] = Field [47] [48] 
.const [17] = Field [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Field [63] [64] 
.const [25] = Field [65] [66] 
.const [26] = Field [67] [68] 
.const [27] = Field [69] [70] 
.const [28] = Field [71] [72] 
.const [29] = Class [73] 
.const [30] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [31] = Utf8 TelBapFSGSetupStruct( 
.const [32] = Utf8 'internalSimcardReaderAvailable=' 
.const [33] = Utf8 ', ' 
.const [34] = Utf8 'cableConnectionToMobilePossible=' 
.const [35] = Utf8 'hfpConnectionToMobilePossible=' 
.const [36] = Utf8 'rsapConnectionToMobilePossible=' 
.const [37] = Utf8 'mobileConnectionType=' 
.const [38] = Utf8 ')' 
.const [39] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [40] = Utf8 java/lang/Object 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [74] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [75] = Utf8 internalSimcardReaderAvailable 
.const [76] = Utf8 Z 
.const [77] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [78] = Utf8 cableConnectionToMobilePossible 
.const [79] = Utf8 Z 
.const [80] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [81] = Utf8 hfpConnectionToMobilePossible 
.const [82] = Utf8 Z 
.const [83] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [84] = Utf8 rsapConnectionToMobilePossible 
.const [85] = Utf8 Z 
.const [86] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [87] = Utf8 mobileConnectionType 
.const [88] = Utf8 I 
.const [89] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [90] = Utf8 append 
.const [91] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [92] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [93] = Utf8 append 
.const [94] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [95] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [96] = Utf8 append 
.const [97] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [98] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [99] = Utf8 toString 
.const [100] = Utf8 ()Ljava/lang/String; 
.const [101] = Utf8 java/lang/Object 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [108] = Utf8 internalSimcardReaderAvailable 
.const [109] = Utf8 Z 
.const [110] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [111] = Utf8 cableConnectionToMobilePossible 
.const [112] = Utf8 Z 
.const [113] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [114] = Utf8 hfpConnectionToMobilePossible 
.const [115] = Utf8 Z 
.const [116] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [117] = Utf8 rsapConnectionToMobilePossible 
.const [118] = Utf8 Z 
.const [119] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [120] = Utf8 mobileConnectionType 
.const [121] = Utf8 I 
.const [122] = Utf8 de/audi/app/phone/core/bap/TelBapFSGSetupStruct 
.const [123] = Class [122] 
.const [124] = Utf8 java/lang/Object 
.const [125] = Class [124] 
.const [126] = Utf8 internalSimcardReaderAvailable 
.const [127] = Utf8 Z 
.const [128] = Utf8 cableConnectionToMobilePossible 
.const [129] = Utf8 Z 
.const [130] = Utf8 hfpConnectionToMobilePossible 
.const [131] = Utf8 Z 
.const [132] = Utf8 rsapConnectionToMobilePossible 
.const [133] = Utf8 Z 
.const [134] = Utf8 mobileConnectionType 
.const [135] = Utf8 I 
.const [136] = Utf8 Code 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (ZZZZI)V 
.const [139] = Utf8 isInternalSimcardReaderAvailable 
.const [140] = Utf8 ()Z 
.const [141] = Utf8 isCableConnectionToMobilePossible 
.const [142] = Utf8 ()Z 
.const [143] = Utf8 isHfpConnectionToMobilePossible 
.const [144] = Utf8 ()Z 
.const [145] = Utf8 isRsapConnectionToMobilePossible 
.const [146] = Utf8 ()Z 
.const [147] = Utf8 getMobileConnectionType 
.const [148] = Utf8 ()I 
.const [149] = Utf8 toString 
.const [150] = Utf8 ()Ljava/lang/String; 
.const [151] = Utf8 hashCode 
.const [152] = Utf8 ()I 
.const [153] = Utf8 equals 
.const [154] = Utf8 (Ljava/lang/Object;)Z 
.end class 
