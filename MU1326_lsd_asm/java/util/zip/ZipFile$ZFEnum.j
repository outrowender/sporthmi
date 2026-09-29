.version 50 0 
.class super [107] 
.super [109] 
.implements [111] 
.field private [112] [113] 
.field private [114] [115] 
.field final synthetic [116] [117] 

.method [119] : [120] 
    .attribute [118] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [20] 
L9:     aload_0 
L10:    aload_0 
L11:    aload_1 
L12:    getfield [12] 
L15:    invokespecial [16] 
L18:    putfield [21] 
L21:    aload_0 
L22:    aload_0 
L23:    aload_1 
L24:    getfield [12] 
L27:    aload_0 
L28:    getfield [13] 
L31:    invokespecial [17] 
L34:    putfield [22] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private native [121] : [122] 
    .attribute [118] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private native [123] : [124] 
    .attribute [118] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [118] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     invokestatic [5] 
L7:     dup 
L8:     astore_1 
L9:     monitorenter 
        .catch [0] from L10 to L39 using L42 
L10:    aload_0 
L11:    getfield [11] 
L14:    getfield [12] 
L17:    ldc2_w [25] 
L20:    lcmp 
L21:    ifne L37 
L24:    new [23] 
L27:    dup 
L28:    ldc [7] 
L30:    invokestatic [9] 
L33:    invokespecial [18] 
L36:    athrow 
L37:    aload_1 
L38:    monitorexit 
L39:    goto L45 
        .catch [0] from L42 to L44 using L42 
L42:    aload_1 
L43:    monitorexit 
L44:    athrow 
L45:    aload_0 
L46:    getfield [14] 
L49:    ifnull L54 
L52:    iconst_1 
L53:    areturn 
L54:    iconst_0 
L55:    areturn 
L56:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [118] .code stack 6 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifnonnull L15 
L7:     new [24] 
L10:    dup 
L11:    invokespecial [19] 
L14:    athrow 
L15:    aload_0 
L16:    getfield [14] 
L19:    astore_1 
L20:    aload_0 
L21:    getfield [11] 
L24:    invokestatic [5] 
L27:    dup 
L28:    astore_2 
L29:    monitorenter 
        .catch [0] from L30 to L78 using L81 
L30:    aload_0 
L31:    getfield [11] 
L34:    getfield [12] 
L37:    ldc2_w [25] 
L40:    lcmp 
L41:    ifne L57 
L44:    new [23] 
L47:    dup 
L48:    ldc [7] 
L50:    invokestatic [9] 
L53:    invokespecial [18] 
L56:    athrow 
L57:    aload_0 
L58:    aload_0 
L59:    aload_0 
L60:    getfield [11] 
L63:    getfield [12] 
L66:    aload_0 
L67:    getfield [13] 
L70:    invokespecial [17] 
L73:    putfield [22] 
L76:    aload_2 
L77:    monitorexit 
L78:    goto L84 
        .catch [0] from L81 to L83 using L81 
L81:    aload_2 
L82:    monitorexit 
L83:    athrow 
L84:    aload_1 
L85:    areturn 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Class [28] 
.const [4] = Class [29] 
.const [5] = Method [30] [31] 
.const [6] = Class [32] 
.const [7] = String [33] 
.const [8] = Class [34] 
.const [9] = Method [35] [36] 
.const [10] = Class [37] 
.const [11] = Field [38] [39] 
.const [12] = Field [40] [41] 
.const [13] = Field [42] [43] 
.const [14] = Field [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Field [56] [57] 
.const [21] = Field [58] [59] 
.const [22] = Field [60] [61] 
.const [23] = Class [62] 
.const [24] = Class [63] 
.const [25] = Long -1L 
.const [27] = Utf8 java/util/zip/ZipFile$ZFEnum 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 java/util/zip/ZipFile 
.const [30] = Class [64] 
.const [31] = NameAndType [65] [66] 
.const [32] = Utf8 java/lang/IllegalStateException 
.const [33] = Utf8 K00b7 
.const [34] = Utf8 com/ibm/oti/util/Msg 
.const [35] = Class [67] 
.const [36] = NameAndType [68] [69] 
.const [37] = Utf8 java/util/NoSuchElementException 
.const [38] = Class [70] 
.const [39] = NameAndType [71] [72] 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Utf8 java/lang/IllegalStateException 
.const [63] = Utf8 java/util/NoSuchElementException 
.const [64] = Utf8 java/util/zip/ZipFile 
.const [65] = Utf8 access$0 
.const [66] = Utf8 (Ljava/util/zip/ZipFile;)Ljava/lang/Object; 
.const [67] = Utf8 com/ibm/oti/util/Msg 
.const [68] = Utf8 getString 
.const [69] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [70] = Utf8 java/util/zip/ZipFile$ZFEnum 
.const [71] = Utf8 this$0 
.const [72] = Utf8 Ljava/util/zip/ZipFile; 
.const [73] = Utf8 java/util/zip/ZipFile 
.const [74] = Utf8 descriptor 
.const [75] = Utf8 J 
.const [76] = Utf8 java/util/zip/ZipFile$ZFEnum 
.const [77] = Utf8 nextEntryPointer 
.const [78] = Utf8 J 
.const [79] = Utf8 java/util/zip/ZipFile$ZFEnum 
.const [80] = Utf8 current 
.const [81] = Utf8 Ljava/util/zip/ZipEntry; 
.const [82] = Utf8 java/lang/Object 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ()V 
.const [85] = Utf8 java/util/zip/ZipFile$ZFEnum 
.const [86] = Utf8 resetZip 
.const [87] = Utf8 (J)J 
.const [88] = Utf8 java/util/zip/ZipFile$ZFEnum 
.const [89] = Utf8 getNextEntry 
.const [90] = Utf8 (JJ)Ljava/util/zip/ZipEntry; 
.const [91] = Utf8 java/lang/IllegalStateException 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Ljava/lang/String;)V 
.const [94] = Utf8 java/util/NoSuchElementException 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 java/util/zip/ZipFile$ZFEnum 
.const [98] = Utf8 this$0 
.const [99] = Utf8 Ljava/util/zip/ZipFile; 
.const [100] = Utf8 java/util/zip/ZipFile$ZFEnum 
.const [101] = Utf8 nextEntryPointer 
.const [102] = Utf8 J 
.const [103] = Utf8 java/util/zip/ZipFile$ZFEnum 
.const [104] = Utf8 current 
.const [105] = Utf8 Ljava/util/zip/ZipEntry; 
.const [106] = Utf8 java/util/zip/ZipFile$ZFEnum 
.const [107] = Class [106] 
.const [108] = Utf8 java/lang/Object 
.const [109] = Class [108] 
.const [110] = Utf8 java/util/Enumeration 
.const [111] = Class [110] 
.const [112] = Utf8 nextEntryPointer 
.const [113] = Utf8 J 
.const [114] = Utf8 current 
.const [115] = Utf8 Ljava/util/zip/ZipEntry; 
.const [116] = Utf8 this$0 
.const [117] = Utf8 Ljava/util/zip/ZipFile; 
.const [118] = Utf8 Code 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Ljava/util/zip/ZipFile;)V 
.const [121] = Utf8 resetZip 
.const [122] = Utf8 (J)J 
.const [123] = Utf8 getNextEntry 
.const [124] = Utf8 (JJ)Ljava/util/zip/ZipEntry; 
.const [125] = Utf8 hasMoreElements 
.const [126] = Utf8 ()Z 
.const [127] = Utf8 nextElement 
.const [128] = Utf8 ()Ljava/lang/Object; 
.end class 
