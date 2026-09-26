.version 50 0 
.class public super [128] 
.super [130] 
.implements [132] 
.field private final [133] [134] 
.field private final [135] [136] 
.field private final [137] [138] 
.field private [139] [140] 
.field private [141] [142] 

.method public [144] : [145] 
    .attribute [143] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     iload_1 
L5:     ifge L35 
L8:     new [26] 
L11:    dup 
L12:    new [27] 
L15:    dup 
L16:    invokespecial [24] 
L19:    ldc [4] 
L21:    invokevirtual [15] 
L24:    iload_1 
L25:    invokevirtual [16] 
L28:    invokevirtual [17] 
L31:    invokespecial [25] 
L34:    athrow 
L35:    iload_2 
L36:    ifgt L66 
L39:    new [26] 
L42:    dup 
L43:    new [27] 
L46:    dup 
L47:    invokespecial [24] 
L50:    ldc [5] 
L52:    invokevirtual [15] 
L55:    iload_2 
L56:    invokevirtual [16] 
L59:    invokevirtual [17] 
L62:    invokespecial [25] 
L65:    athrow 
L66:    iload_2 
L67:    ldc [6] 
L69:    iload_1 
L70:    isub 
L71:    if_icmplt L133 
L74:    new [26] 
L77:    dup 
L78:    new [27] 
L81:    dup 
L82:    invokespecial [24] 
L85:    ldc [7] 
L87:    invokevirtual [15] 
L90:    iload_1 
L91:    invokevirtual [16] 
L94:    ldc [8] 
L96:    invokevirtual [15] 
L99:    iload_1 
L100:   invokevirtual [16] 
L103:   ldc [9] 
L105:   invokevirtual [15] 
L108:   iload_1 
L109:   i2l 
L110:   iload_2 
L111:   i2l 
L112:   ladd 
L113:   invokevirtual [18] 
L116:   ldc [10] 
L118:   invokevirtual [15] 
L121:   ldc [6] 
L123:   invokevirtual [16] 
L126:   invokevirtual [17] 
L129:   invokespecial [25] 
L132:   athrow 
L133:   aload_0 
L134:   iload_1 
L135:   putfield [28] 
L138:   aload_0 
L139:   iload_2 
L140:   putfield [29] 
L143:   aload_0 
L144:   iload_1 
L145:   iload_2 
L146:   iadd 
L147:   putfield [30] 
L150:   aload_0 
L151:   iload_1 
L152:   putfield [31] 
L155:   aload_0 
L156:   iconst_0 
L157:   putfield [32] 
L160:   return 
L161:   nop 
L162:   nop 
L163:   nop 
L164:   
    .end code 
.end method 

.method public synchronized [146] : [147] 
    .attribute [143] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [20] 
L4:     iconst_2 
L5:     idiv 
L6:     istore_2 
L7:     iload_1 
L8:     ifle L16 
L11:    iload_1 
L12:    iload_2 
L13:    if_icmple L52 
L16:    new [26] 
L19:    dup 
L20:    new [27] 
L23:    dup 
L24:    invokespecial [24] 
L27:    ldc [11] 
L29:    invokevirtual [15] 
L32:    iload_1 
L33:    invokevirtual [16] 
L36:    ldc [12] 
L38:    invokevirtual [15] 
L41:    iload_2 
L42:    invokevirtual [16] 
L45:    invokevirtual [17] 
L48:    invokespecial [25] 
L51:    athrow 
L52:    aload_0 
L53:    iload_1 
L54:    putfield [32] 
L57:    aload_0 
L58:    getfield [22] 
L61:    aload_0 
L62:    getfield [21] 
L65:    iload_1 
L66:    isub 
L67:    if_icmple L78 
L70:    aload_0 
L71:    aload_0 
L72:    getfield [19] 
L75:    putfield [31] 
L78:    aload_0 
L79:    getfield [22] 
L82:    istore_3 
L83:    aload_0 
L84:    dup 
L85:    getfield [22] 
L88:    iload_1 
L89:    iadd 
L90:    putfield [31] 
L93:    iload_3 
L94:    areturn 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [148] : [149] 
    .attribute [143] .code stack 2 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [19] 
L5:     if_icmplt L20 
L8:     iload_1 
L9:     aload_0 
L10:    getfield [21] 
L13:    if_icmpge L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [150] : [151] 
    .attribute [143] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [33] 
.const [3] = Class [34] 
.const [4] = String [35] 
.const [5] = String [36] 
.const [6] = Int -129 
.const [7] = String [37] 
.const [8] = String [38] 
.const [9] = String [39] 
.const [10] = String [40] 
.const [11] = String [41] 
.const [12] = String [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Field [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Class [67] 
.const [27] = Class [68] 
.const [28] = Field [69] [70] 
.const [29] = Field [71] [72] 
.const [30] = Field [73] [74] 
.const [31] = Field [75] [76] 
.const [32] = Field [77] [78] 
.const [33] = Utf8 java/lang/IllegalArgumentException 
.const [34] = Utf8 java/lang/StringBuffer 
.const [35] = Utf8 'Range start must be positive. But rangeBoundaryStart = ' 
.const [36] = Utf8 'Range size must be greater than 0. But rangeBoundarySize = ' 
.const [37] = Utf8 'Range end must be lesser than Integer.MAX_VALUE. But rangeBoundaryStart (=' 
.const [38] = Utf8 ') + rangeBoundarySize (=' 
.const [39] = Utf8 ') = ' 
.const [40] = Utf8 ' is greater than ' 
.const [41] = Utf8 'Illegal argument for range= ' 
.const [42] = Utf8 ', It must be greater 0 and lesser than ' 
.const [43] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [44] = Utf8 java/lang/Object 
.const [45] = Class [79] 
.const [46] = NameAndType [80] [81] 
.const [47] = Class [82] 
.const [48] = NameAndType [83] [84] 
.const [49] = Class [85] 
.const [50] = NameAndType [86] [87] 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Utf8 java/lang/IllegalArgumentException 
.const [68] = Utf8 java/lang/StringBuffer 
.const [69] = Class [112] 
.const [70] = NameAndType [113] [114] 
.const [71] = Class [115] 
.const [72] = NameAndType [116] [117] 
.const [73] = Class [118] 
.const [74] = NameAndType [119] [120] 
.const [75] = Class [121] 
.const [76] = NameAndType [122] [123] 
.const [77] = Class [124] 
.const [78] = NameAndType [125] [126] 
.const [79] = Utf8 java/lang/StringBuffer 
.const [80] = Utf8 append 
.const [81] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [82] = Utf8 java/lang/StringBuffer 
.const [83] = Utf8 append 
.const [84] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [85] = Utf8 java/lang/StringBuffer 
.const [86] = Utf8 toString 
.const [87] = Utf8 ()Ljava/lang/String; 
.const [88] = Utf8 java/lang/StringBuffer 
.const [89] = Utf8 append 
.const [90] = Utf8 (J)Ljava/lang/StringBuffer; 
.const [91] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [92] = Utf8 rangeBoundaryStart 
.const [93] = Utf8 I 
.const [94] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [95] = Utf8 rangeBoundarySize 
.const [96] = Utf8 I 
.const [97] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [98] = Utf8 rangeBoundaryEnd 
.const [99] = Utf8 I 
.const [100] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [101] = Utf8 firstUnusedNumber 
.const [102] = Utf8 I 
.const [103] = Utf8 java/lang/Object 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 java/lang/StringBuffer 
.const [107] = Utf8 <init> 
.const [108] = Utf8 ()V 
.const [109] = Utf8 java/lang/IllegalArgumentException 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (Ljava/lang/String;)V 
.const [112] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [113] = Utf8 rangeBoundaryStart 
.const [114] = Utf8 I 
.const [115] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [116] = Utf8 rangeBoundarySize 
.const [117] = Utf8 I 
.const [118] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [119] = Utf8 rangeBoundaryEnd 
.const [120] = Utf8 I 
.const [121] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [122] = Utf8 firstUnusedNumber 
.const [123] = Utf8 I 
.const [124] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [125] = Utf8 lastRangeSize 
.const [126] = Utf8 I 
.const [127] = Utf8 de/audi/tghu/online/app/remotehmi/util/RangeCounter 
.const [128] = Class [127] 
.const [129] = Utf8 java/lang/Object 
.const [130] = Class [129] 
.const [131] = Utf8 de/audi/remotehmi/ui/mib2/grid/IRangeCounter 
.const [132] = Class [131] 
.const [133] = Utf8 rangeBoundaryStart 
.const [134] = Utf8 I 
.const [135] = Utf8 rangeBoundaryEnd 
.const [136] = Utf8 I 
.const [137] = Utf8 rangeBoundarySize 
.const [138] = Utf8 I 
.const [139] = Utf8 firstUnusedNumber 
.const [140] = Utf8 I 
.const [141] = Utf8 lastRangeSize 
.const [142] = Utf8 I 
.const [143] = Utf8 Code 
.const [144] = Utf8 <init> 
.const [145] = Utf8 (II)V 
.const [146] = Utf8 getNext 
.const [147] = Utf8 (I)I 
.const [148] = Utf8 isInsideRangeBoundary 
.const [149] = Utf8 (I)Z 
.const [150] = Utf8 getRangeBoundaryStart 
.const [151] = Utf8 ()I 
.end class 
