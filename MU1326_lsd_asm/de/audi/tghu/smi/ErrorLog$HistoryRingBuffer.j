.version 50 0 
.class public super [151] 
.super [153] 
.field private [154] [155] 
.field private [156] [157] 
.field private [158] [159] 
.field private [160] [161] 
.field private [162] [163] 
.field private final synthetic [164] [165] 

.method public [167] : [168] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     aload_0 
L6:     invokespecial [22] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [26] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [27] 
L19:    aload_0 
L20:    iconst_0 
L21:    putfield [28] 
L24:    aload_0 
L25:    iload_2 
L26:    newarray int 
L28:    putfield [29] 
L31:    aload_0 
L32:    iload_2 
L33:    newarray long 
L35:    putfield [30] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [166] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     arraylength 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [171] : [172] 
    .attribute [166] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [166] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifne L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [166] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     aload_0 
L5:     getfield [15] 
L8:     iload_1 
L9:     iastore 
L10:    aload_0 
L11:    getfield [17] 
L14:    aload_0 
L15:    getfield [15] 
L18:    aload_0 
L19:    getfield [12] 
L22:    invokestatic [2] 
L25:    invokeinterface [31] 0 
L30:    lastore 
L31:    aload_0 
L32:    getfield [13] 
L35:    aload_0 
L36:    invokevirtual [18] 
L39:    if_icmpne L65 
L42:    aload_0 
L43:    dup 
L44:    getfield [14] 
L47:    iconst_1 
L48:    iadd 
L49:    putfield [27] 
L52:    aload_0 
L53:    dup 
L54:    getfield [15] 
L57:    iconst_1 
L58:    iadd 
L59:    putfield [28] 
L62:    goto L85 
L65:    aload_0 
L66:    dup 
L67:    getfield [15] 
L70:    iconst_1 
L71:    iadd 
L72:    putfield [28] 
L75:    aload_0 
L76:    dup 
L77:    getfield [13] 
L80:    iconst_1 
L81:    iadd 
L82:    putfield [26] 
L85:    aload_0 
L86:    aload_0 
L87:    getfield [14] 
L90:    aload_0 
L91:    invokevirtual [18] 
L94:    irem 
L95:    putfield [27] 
L98:    aload_0 
L99:    aload_0 
L100:   getfield [15] 
L103:   aload_0 
L104:   invokevirtual [18] 
L107:   irem 
L108:   putfield [28] 
L111:   return 
L112:   
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [166] .code stack 4 locals 1 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [13] 
L5:     if_icmpge L27 
L8:     aload_0 
L9:     getfield [14] 
L12:    iload_1 
L13:    iadd 
L14:    aload_0 
L15:    invokevirtual [18] 
L18:    irem 
L19:    istore_2 
L20:    aload_0 
L21:    getfield [16] 
L24:    iload_2 
L25:    iaload 
L26:    areturn 
L27:    new [32] 
L30:    dup 
L31:    new [33] 
L34:    dup 
L35:    invokespecial [23] 
L38:    ldc [5] 
L40:    invokevirtual [19] 
L43:    aload_0 
L44:    getfield [13] 
L47:    invokevirtual [20] 
L50:    ldc [6] 
L52:    invokevirtual [19] 
L55:    iload_1 
L56:    invokevirtual [20] 
L59:    ldc [7] 
L61:    invokevirtual [19] 
L64:    invokevirtual [21] 
L67:    invokespecial [24] 
L70:    athrow 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [166] .code stack 4 locals 1 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [13] 
L5:     if_icmpge L27 
L8:     aload_0 
L9:     getfield [14] 
L12:    iload_1 
L13:    iadd 
L14:    aload_0 
L15:    invokevirtual [18] 
L18:    irem 
L19:    istore_2 
L20:    aload_0 
L21:    getfield [17] 
L24:    iload_2 
L25:    laload 
L26:    freturn 
L27:    new [32] 
L30:    dup 
L31:    new [33] 
L34:    dup 
L35:    invokespecial [23] 
L38:    ldc [5] 
L40:    invokevirtual [19] 
L43:    aload_0 
L44:    getfield [13] 
L47:    invokevirtual [20] 
L50:    ldc [6] 
L52:    invokevirtual [19] 
L55:    iload_1 
L56:    invokevirtual [20] 
L59:    ldc [7] 
L61:    invokevirtual [19] 
L64:    invokevirtual [21] 
L67:    invokespecial [24] 
L70:    athrow 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [34] [35] 
.const [3] = Class [36] 
.const [4] = Class [37] 
.const [5] = String [38] 
.const [6] = String [39] 
.const [7] = String [40] 
.const [8] = Class [41] 
.const [9] = Class [42] 
.const [10] = Class [43] 
.const [11] = Class [44] 
.const [12] = Field [45] [46] 
.const [13] = Field [47] [48] 
.const [14] = Field [49] [50] 
.const [15] = Field [51] [52] 
.const [16] = Field [53] [54] 
.const [17] = Field [55] [56] 
.const [18] = Method [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Field [71] [72] 
.const [26] = Field [73] [74] 
.const [27] = Field [75] [76] 
.const [28] = Field [77] [78] 
.const [29] = Field [79] [80] 
.const [30] = Field [81] [82] 
.const [31] = InterfaceMethod [83] [84] 
.const [32] = Class [85] 
.const [33] = Class [86] 
.const [34] = Class [87] 
.const [35] = NameAndType [88] [89] 
.const [36] = Utf8 java/lang/IndexOutOfBoundsException 
.const [37] = Utf8 java/lang/StringBuffer 
.const [38] = Utf8 'Index out of bounds (size=' 
.const [39] = Utf8 ', index=' 
.const [40] = Utf8 ')' 
.const [41] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [42] = Utf8 java/lang/Object 
.const [43] = Utf8 de/audi/tghu/smi/ErrorLog 
.const [44] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [45] = Class [90] 
.const [46] = NameAndType [91] [92] 
.const [47] = Class [93] 
.const [48] = NameAndType [94] [95] 
.const [49] = Class [96] 
.const [50] = NameAndType [97] [98] 
.const [51] = Class [99] 
.const [52] = NameAndType [100] [101] 
.const [53] = Class [102] 
.const [54] = NameAndType [103] [104] 
.const [55] = Class [105] 
.const [56] = NameAndType [106] [107] 
.const [57] = Class [108] 
.const [58] = NameAndType [109] [110] 
.const [59] = Class [111] 
.const [60] = NameAndType [112] [113] 
.const [61] = Class [114] 
.const [62] = NameAndType [115] [116] 
.const [63] = Class [117] 
.const [64] = NameAndType [118] [119] 
.const [65] = Class [120] 
.const [66] = NameAndType [121] [122] 
.const [67] = Class [123] 
.const [68] = NameAndType [124] [125] 
.const [69] = Class [126] 
.const [70] = NameAndType [127] [128] 
.const [71] = Class [129] 
.const [72] = NameAndType [130] [131] 
.const [73] = Class [132] 
.const [74] = NameAndType [133] [134] 
.const [75] = Class [135] 
.const [76] = NameAndType [136] [137] 
.const [77] = Class [138] 
.const [78] = NameAndType [139] [140] 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Class [147] 
.const [84] = NameAndType [148] [149] 
.const [85] = Utf8 java/lang/IndexOutOfBoundsException 
.const [86] = Utf8 java/lang/StringBuffer 
.const [87] = Utf8 de/audi/tghu/smi/ErrorLog 
.const [88] = Utf8 access$000 
.const [89] = Utf8 (Lde/audi/tghu/smi/ErrorLog;)Lde/audi/atip/base/IFrameworkAccess; 
.const [90] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [91] = Utf8 this$0 
.const [92] = Utf8 Lde/audi/tghu/smi/ErrorLog; 
.const [93] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [94] = Utf8 size 
.const [95] = Utf8 I 
.const [96] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [97] = Utf8 startIdx 
.const [98] = Utf8 I 
.const [99] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [100] = Utf8 endIdx 
.const [101] = Utf8 I 
.const [102] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [103] = Utf8 buffer 
.const [104] = Utf8 [I 
.const [105] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [106] = Utf8 timestamps 
.const [107] = Utf8 [J 
.const [108] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [109] = Utf8 getCapacity 
.const [110] = Utf8 ()I 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 append 
.const [113] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Utf8 append 
.const [116] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [117] = Utf8 java/lang/StringBuffer 
.const [118] = Utf8 toString 
.const [119] = Utf8 ()Ljava/lang/String; 
.const [120] = Utf8 java/lang/Object 
.const [121] = Utf8 <init> 
.const [122] = Utf8 ()V 
.const [123] = Utf8 java/lang/StringBuffer 
.const [124] = Utf8 <init> 
.const [125] = Utf8 ()V 
.const [126] = Utf8 java/lang/IndexOutOfBoundsException 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Ljava/lang/String;)V 
.const [129] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [130] = Utf8 this$0 
.const [131] = Utf8 Lde/audi/tghu/smi/ErrorLog; 
.const [132] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [133] = Utf8 size 
.const [134] = Utf8 I 
.const [135] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [136] = Utf8 startIdx 
.const [137] = Utf8 I 
.const [138] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [139] = Utf8 endIdx 
.const [140] = Utf8 I 
.const [141] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [142] = Utf8 buffer 
.const [143] = Utf8 [I 
.const [144] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [145] = Utf8 timestamps 
.const [146] = Utf8 [J 
.const [147] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [148] = Utf8 getMonotonicTime 
.const [149] = Utf8 ()J 
.const [150] = Utf8 de/audi/tghu/smi/ErrorLog$HistoryRingBuffer 
.const [151] = Class [150] 
.const [152] = Utf8 java/lang/Object 
.const [153] = Class [152] 
.const [154] = Utf8 buffer 
.const [155] = Utf8 [I 
.const [156] = Utf8 timestamps 
.const [157] = Utf8 [J 
.const [158] = Utf8 size 
.const [159] = Utf8 I 
.const [160] = Utf8 startIdx 
.const [161] = Utf8 I 
.const [162] = Utf8 endIdx 
.const [163] = Utf8 I 
.const [164] = Utf8 this$0 
.const [165] = Utf8 Lde/audi/tghu/smi/ErrorLog; 
.const [166] = Utf8 Code 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (Lde/audi/tghu/smi/ErrorLog;I)V 
.const [169] = Utf8 getCapacity 
.const [170] = Utf8 ()I 
.const [171] = Utf8 size 
.const [172] = Utf8 ()I 
.const [173] = Utf8 isEmpty 
.const [174] = Utf8 ()Z 
.const [175] = Utf8 put 
.const [176] = Utf8 (I)V 
.const [177] = Utf8 get 
.const [178] = Utf8 (I)I 
.const [179] = Utf8 getTimestamp 
.const [180] = Utf8 (I)J 
.end class 
