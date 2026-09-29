.version 50 0 
.class public final super [139] 
.super [141] 
.implements [143] 
.field private final [144] [145] 

.method public [147] : [148] 
    .attribute [146] .code stack 4 locals 4 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_1 
L5:     invokeinterface [26] 0 
L10:    ifeq L23 
L13:    new [27] 
L16:    dup 
L17:    ldc [3] 
L19:    invokespecial [23] 
L22:    athrow 
L23:    new [28] 
L26:    dup 
L27:    aload_1 
L28:    invokeinterface [29] 0 
L33:    invokespecial [24] 
L36:    astore_2 
L37:    aload_1 
L38:    invokeinterface [30] 0 
L43:    astore_3 
L44:    aload_3 
L45:    invokeinterface [31] 0 
L50:    ifeq L152 
L53:    aload_3 
L54:    invokeinterface [32] 0 
L59:    astore 4 
L61:    aload 4 
L63:    instanceof [5] 
L66:    ifne L97 
L69:    new [27] 
L72:    dup 
L73:    new [33] 
L76:    dup 
L77:    invokespecial [25] 
L80:    ldc [7] 
L82:    invokevirtual [18] 
L85:    aload 4 
L87:    invokevirtual [19] 
L90:    invokevirtual [20] 
L93:    invokespecial [23] 
L96:    athrow 
L97:    aload 4 
L99:    checkcast [5] 
L102:   astore 5 
L104:   aload 5 
L106:   invokestatic [8] 
L109:   ifeq L140 
L112:   new [27] 
L115:   dup 
L116:   new [33] 
L119:   dup 
L120:   invokespecial [25] 
L123:   ldc [9] 
L125:   invokevirtual [18] 
L128:   aload 5 
L130:   invokevirtual [18] 
L133:   invokevirtual [20] 
L136:   invokespecial [23] 
L139:   athrow 
L140:   aload_2 
L141:   aload 5 
L143:   invokeinterface [34] 0 
L148:   pop 
L149:   goto L44 
L152:   aload_0 
L153:   aload_2 
L154:   invokeinterface [30] 0 
L159:   putfield [35] 
L162:   return 
L163:   nop 
L164:   
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [146] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_1 
L5:     invokestatic [8] 
L8:     ifeq L21 
L11:    new [27] 
L14:    dup 
L15:    ldc [10] 
L17:    invokespecial [23] 
L20:    athrow 
L21:    aload_0 
L22:    iconst_1 
L23:    anewarray [5] 
L26:    dup 
L27:    iconst_0 
L28:    aload_1 
L29:    aastore 
L30:    invokestatic [11] 
L33:    invokeinterface [30] 0 
L38:    putfield [35] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [146] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_1 
L5:     invokestatic [8] 
L8:     ifne L18 
L11:    aload_2 
L12:    invokestatic [8] 
L15:    ifeq L28 
L18:    new [27] 
L21:    dup 
L22:    ldc [10] 
L24:    invokespecial [23] 
L27:    athrow 
L28:    aload_0 
L29:    iconst_2 
L30:    anewarray [5] 
L33:    dup 
L34:    iconst_0 
L35:    aload_1 
L36:    aastore 
L37:    dup 
L38:    iconst_1 
L39:    aload_2 
L40:    aastore 
L41:    invokestatic [11] 
L44:    invokeinterface [30] 0 
L49:    putfield [35] 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [146] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokeinterface [31] 0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [146] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokeinterface [32] 0 
L9:     checkcast [5] 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [36] 
.const [3] = String [37] 
.const [4] = Class [38] 
.const [5] = Class [39] 
.const [6] = Class [40] 
.const [7] = String [41] 
.const [8] = Method [42] [43] 
.const [9] = String [44] 
.const [10] = String [45] 
.const [11] = Method [46] [47] 
.const [12] = Class [48] 
.const [13] = Class [49] 
.const [14] = Class [50] 
.const [15] = Class [51] 
.const [16] = Class [52] 
.const [17] = Class [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Field [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = InterfaceMethod [70] [71] 
.const [27] = Class [72] 
.const [28] = Class [73] 
.const [29] = InterfaceMethod [74] [75] 
.const [30] = InterfaceMethod [76] [77] 
.const [31] = InterfaceMethod [78] [79] 
.const [32] = InterfaceMethod [80] [81] 
.const [33] = Class [82] 
.const [34] = InterfaceMethod [83] [84] 
.const [35] = Field [85] [86] 
.const [36] = Utf8 java/lang/IllegalArgumentException 
.const [37] = Utf8 'List of tasks is empty.' 
.const [38] = Utf8 java/util/ArrayList 
.const [39] = Utf8 java/lang/String 
.const [40] = Utf8 java/lang/StringBuffer 
.const [41] = Utf8 'List element is not a string: ' 
.const [42] = Class [87] 
.const [43] = NameAndType [88] [89] 
.const [44] = Utf8 'List element is null or the empty string: ' 
.const [45] = Utf8 'Argument is null or empty.' 
.const [46] = Class [90] 
.const [47] = NameAndType [91] [92] 
.const [48] = Utf8 de/audi/app/messaging/core/readout/Readable 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 java/util/List 
.const [51] = Utf8 java/util/Iterator 
.const [52] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [53] = Utf8 java/util/Arrays 
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
.const [72] = Utf8 java/lang/IllegalArgumentException 
.const [73] = Utf8 java/util/ArrayList 
.const [74] = Class [120] 
.const [75] = NameAndType [121] [122] 
.const [76] = Class [123] 
.const [77] = NameAndType [124] [125] 
.const [78] = Class [126] 
.const [79] = NameAndType [127] [128] 
.const [80] = Class [129] 
.const [81] = NameAndType [130] [131] 
.const [82] = Utf8 java/lang/StringBuffer 
.const [83] = Class [132] 
.const [84] = NameAndType [133] [134] 
.const [85] = Class [135] 
.const [86] = NameAndType [136] [137] 
.const [87] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [88] = Utf8 isNullOrEmpty 
.const [89] = Utf8 (Ljava/lang/String;)Z 
.const [90] = Utf8 java/util/Arrays 
.const [91] = Utf8 asList 
.const [92] = Utf8 ([Ljava/lang/Object;)Ljava/util/List; 
.const [93] = Utf8 java/lang/StringBuffer 
.const [94] = Utf8 append 
.const [95] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [96] = Utf8 java/lang/StringBuffer 
.const [97] = Utf8 append 
.const [98] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [99] = Utf8 java/lang/StringBuffer 
.const [100] = Utf8 toString 
.const [101] = Utf8 ()Ljava/lang/String; 
.const [102] = Utf8 de/audi/app/messaging/core/readout/Readable 
.const [103] = Utf8 speakTaskIterator 
.const [104] = Utf8 Ljava/util/Iterator; 
.const [105] = Utf8 java/lang/Object 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 java/lang/IllegalArgumentException 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Ljava/lang/String;)V 
.const [111] = Utf8 java/util/ArrayList 
.const [112] = Utf8 <init> 
.const [113] = Utf8 (I)V 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 java/util/List 
.const [118] = Utf8 isEmpty 
.const [119] = Utf8 ()Z 
.const [120] = Utf8 java/util/List 
.const [121] = Utf8 size 
.const [122] = Utf8 ()I 
.const [123] = Utf8 java/util/List 
.const [124] = Utf8 iterator 
.const [125] = Utf8 ()Ljava/util/Iterator; 
.const [126] = Utf8 java/util/Iterator 
.const [127] = Utf8 hasNext 
.const [128] = Utf8 ()Z 
.const [129] = Utf8 java/util/Iterator 
.const [130] = Utf8 next 
.const [131] = Utf8 ()Ljava/lang/Object; 
.const [132] = Utf8 java/util/List 
.const [133] = Utf8 add 
.const [134] = Utf8 (Ljava/lang/Object;)Z 
.const [135] = Utf8 de/audi/app/messaging/core/readout/Readable 
.const [136] = Utf8 speakTaskIterator 
.const [137] = Utf8 Ljava/util/Iterator; 
.const [138] = Utf8 de/audi/app/messaging/core/readout/Readable 
.const [139] = Class [138] 
.const [140] = Utf8 java/lang/Object 
.const [141] = Class [140] 
.const [142] = Utf8 de/audi/app/messaging/core/readout/IReadable 
.const [143] = Class [142] 
.const [144] = Utf8 speakTaskIterator 
.const [145] = Utf8 Ljava/util/Iterator; 
.const [146] = Utf8 Code 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Ljava/util/List;)V 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Ljava/lang/String;)V 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [153] = Utf8 hasNextSpeakTask 
.const [154] = Utf8 ()Z 
.const [155] = Utf8 nextSpeakTask 
.const [156] = Utf8 ()Ljava/lang/String; 
.end class 
