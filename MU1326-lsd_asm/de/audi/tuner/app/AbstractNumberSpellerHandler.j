.version 50 0 
.class public super abstract [111] 
.super [113] 
.field private [114] [115] 

.method public [117] : [118] 
    .attribute [116] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     invokespecial [18] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected final [119] : [120] 
    .attribute [116] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [22] 
L4:     dup 
L5:     bipush 30 
L7:     invokespecial [19] 
L10:    putfield [23] 
L13:    aload_0 
L14:    getfield [9] 
L17:    iconst_0 
L18:    new [24] 
L21:    dup 
L22:    bipush 10 
L24:    invokespecial [20] 
L27:    invokevirtual [10] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [121] : [122] 
    .attribute [116] .code stack 3 locals 3 
L0:     iload_1 
L1:     bipush 10 
L3:     idiv 
L4:     istore_2 
L5:     iload_1 
L6:     bipush 10 
L8:     irem 
L9:     istore_3 
L10:    iload_2 
L11:    ifeq L73 
L14:    aload_0 
L15:    getfield [9] 
L18:    iload_2 
L19:    invokevirtual [11] 
L22:    checkcast [3] 
L25:    astore 4 
L27:    aload 4 
L29:    ifnonnull L53 
L32:    new [24] 
L35:    dup 
L36:    bipush 10 
L38:    invokespecial [20] 
L41:    astore 4 
L43:    aload_0 
L44:    getfield [9] 
L47:    iload_2 
L48:    aload 4 
L50:    invokevirtual [10] 
L53:    aload 4 
L55:    iload_3 
L56:    iconst_0 
L57:    invokevirtual [12] 
L60:    iload_2 
L61:    bipush 10 
L63:    irem 
L64:    istore_3 
L65:    iload_2 
L66:    bipush 10 
L68:    idiv 
L69:    istore_2 
L70:    goto L10 
L73:    aload_0 
L74:    getfield [9] 
L77:    iconst_0 
L78:    invokevirtual [11] 
L81:    checkcast [3] 
L84:    astore 4 
L86:    aload 4 
L88:    iload_3 
L89:    iconst_0 
L90:    invokevirtual [12] 
L93:    return 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method protected [123] : [124] 
    .attribute [116] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [9] 
L4:     iload_1 
L5:     invokevirtual [11] 
L8:     checkcast [3] 
L11:    astore_2 
L12:    aload_2 
L13:    ifnonnull L20 
L16:    iconst_0 
L17:    newarray int 
L19:    areturn 
L20:    aload_2 
L21:    invokevirtual [13] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [125] : [126] 
    .attribute [116] .code stack 3 locals 3 
L0:     aload_0 
L1:     iload_1 
L2:     invokevirtual [14] 
L5:     astore_2 
L6:     new [25] 
L9:     dup 
L10:    bipush 10 
L12:    invokespecial [21] 
L15:    astore_3 
L16:    iconst_0 
L17:    istore 4 
L19:    iload 4 
L21:    aload_2 
L22:    arraylength 
L23:    if_icmpge L44 
L26:    aload_3 
L27:    aload_2 
L28:    iload 4 
L30:    iaload 
L31:    invokestatic [5] 
L34:    invokevirtual [15] 
L37:    pop 
L38:    iinc 4 1 
L41:    goto L19 
L44:    aload_3 
L45:    invokevirtual [16] 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Class [27] 
.const [4] = Class [28] 
.const [5] = Method [29] [30] 
.const [6] = Class [31] 
.const [7] = Class [32] 
.const [8] = Class [33] 
.const [9] = Field [34] [35] 
.const [10] = Method [36] [37] 
.const [11] = Method [38] [39] 
.const [12] = Method [40] [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Class [60] 
.const [23] = Field [61] [62] 
.const [24] = Class [63] 
.const [25] = Class [64] 
.const [26] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [27] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [28] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [29] = Class [65] 
.const [30] = NameAndType [66] [67] 
.const [31] = Utf8 de/audi/tuner/app/AbstractNumberSpellerHandler 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 java/lang/String 
.const [34] = Class [68] 
.const [35] = NameAndType [69] [70] 
.const [36] = Class [71] 
.const [37] = NameAndType [72] [73] 
.const [38] = Class [74] 
.const [39] = NameAndType [75] [76] 
.const [40] = Class [77] 
.const [41] = NameAndType [78] [79] 
.const [42] = Class [80] 
.const [43] = NameAndType [81] [82] 
.const [44] = Class [83] 
.const [45] = NameAndType [84] [85] 
.const [46] = Class [86] 
.const [47] = NameAndType [87] [88] 
.const [48] = Class [89] 
.const [49] = NameAndType [90] [91] 
.const [50] = Class [92] 
.const [51] = NameAndType [93] [94] 
.const [52] = Class [95] 
.const [53] = NameAndType [96] [97] 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Class [104] 
.const [59] = NameAndType [105] [106] 
.const [60] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [64] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [65] = Utf8 java/lang/String 
.const [66] = Utf8 valueOf 
.const [67] = Utf8 (I)Ljava/lang/String; 
.const [68] = Utf8 de/audi/tuner/app/AbstractNumberSpellerHandler 
.const [69] = Utf8 validKeys 
.const [70] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [71] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [72] = Utf8 add 
.const [73] = Utf8 (ILjava/lang/Object;)V 
.const [74] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [75] = Utf8 get 
.const [76] = Utf8 (I)Ljava/lang/Object; 
.const [77] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [78] = Utf8 add 
.const [79] = Utf8 (II)V 
.const [80] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [81] = Utf8 getKeys 
.const [82] = Utf8 ()[I 
.const [83] = Utf8 de/audi/tuner/app/AbstractNumberSpellerHandler 
.const [84] = Utf8 getValidNextDigitsForPrefix 
.const [85] = Utf8 (I)[I 
.const [86] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [87] = Utf8 append 
.const [88] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [89] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [90] = Utf8 toString 
.const [91] = Utf8 ()Ljava/lang/String; 
.const [92] = Utf8 java/lang/Object 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/audi/tuner/app/AbstractNumberSpellerHandler 
.const [96] = Utf8 initMap 
.const [97] = Utf8 ()V 
.const [98] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (I)V 
.const [101] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (I)V 
.const [104] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (I)V 
.const [107] = Utf8 de/audi/tuner/app/AbstractNumberSpellerHandler 
.const [108] = Utf8 validKeys 
.const [109] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [110] = Utf8 de/audi/tuner/app/AbstractNumberSpellerHandler 
.const [111] = Class [110] 
.const [112] = Utf8 java/lang/Object 
.const [113] = Class [112] 
.const [114] = Utf8 validKeys 
.const [115] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [116] = Utf8 Code 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 initMap 
.const [120] = Utf8 ()V 
.const [121] = Utf8 addNumber 
.const [122] = Utf8 (I)V 
.const [123] = Utf8 getValidNextDigitsForPrefix 
.const [124] = Utf8 (I)[I 
.const [125] = Utf8 getValidNextDigitsForPrefixAsString 
.const [126] = Utf8 (I)Ljava/lang/String; 
.end class 
