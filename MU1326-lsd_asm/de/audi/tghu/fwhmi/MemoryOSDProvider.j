.version 50 0 
.class public super [70] 
.super [72] 
.implements [74] 

.method public annotation [76] : [77] 
    .attribute [75] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [78] : [79] 
    .attribute [75] .code stack 1 locals 0 
L0:     ldc [2] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [80] : [81] 
    .attribute [75] .code stack 8 locals 0 
L0:     iconst_2 
L1:     anewarray [3] 
L4:     dup 
L5:     iconst_0 
L6:     new [18] 
L9:     dup 
L10:    invokespecial [17] 
L13:    ldc [5] 
L15:    invokevirtual [11] 
L18:    invokestatic [6] 
L21:    invokevirtual [12] 
L24:    ldc_w [1] 
L27:    ldiv 
L28:    invokevirtual [13] 
L31:    ldc [7] 
L33:    invokevirtual [11] 
L36:    invokevirtual [14] 
L39:    aastore 
L40:    dup 
L41:    iconst_1 
L42:    new [18] 
L45:    dup 
L46:    invokespecial [17] 
L49:    ldc [8] 
L51:    invokevirtual [11] 
L54:    invokestatic [6] 
L57:    invokevirtual [15] 
L60:    ldc_w [1] 
L63:    ldiv 
L64:    invokevirtual [13] 
L67:    ldc [7] 
L69:    invokevirtual [11] 
L72:    invokevirtual [14] 
L75:    aastore 
L76:    areturn 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public enum [82] : [83] 
    .attribute [75] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = String [23] 
.const [6] = Method [24] [25] 
.const [7] = String [26] 
.const [8] = String [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Class [44] 
.const [19] = Int 262144 
.const [20] = Utf8 'available Java Heap' 
.const [21] = Utf8 java/lang/String 
.const [22] = Utf8 java/lang/StringBuffer 
.const [23] = Utf8 'TotalMemory: ' 
.const [24] = Class [45] 
.const [25] = NameAndType [46] [47] 
.const [26] = Utf8 ' kiB' 
.const [27] = Utf8 'FreeMemory: ' 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 java/lang/Runtime 
.const [30] = Class [48] 
.const [31] = NameAndType [49] [50] 
.const [32] = Class [51] 
.const [33] = NameAndType [52] [53] 
.const [34] = Class [54] 
.const [35] = NameAndType [55] [56] 
.const [36] = Class [57] 
.const [37] = NameAndType [58] [59] 
.const [38] = Class [60] 
.const [39] = NameAndType [61] [62] 
.const [40] = Class [63] 
.const [41] = NameAndType [64] [65] 
.const [42] = Class [66] 
.const [43] = NameAndType [67] [68] 
.const [44] = Utf8 java/lang/StringBuffer 
.const [45] = Utf8 java/lang/Runtime 
.const [46] = Utf8 getRuntime 
.const [47] = Utf8 ()Ljava/lang/Runtime; 
.const [48] = Utf8 java/lang/StringBuffer 
.const [49] = Utf8 append 
.const [50] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [51] = Utf8 java/lang/Runtime 
.const [52] = Utf8 totalMemory 
.const [53] = Utf8 ()J 
.const [54] = Utf8 java/lang/StringBuffer 
.const [55] = Utf8 append 
.const [56] = Utf8 (J)Ljava/lang/StringBuffer; 
.const [57] = Utf8 java/lang/StringBuffer 
.const [58] = Utf8 toString 
.const [59] = Utf8 ()Ljava/lang/String; 
.const [60] = Utf8 java/lang/Runtime 
.const [61] = Utf8 freeMemory 
.const [62] = Utf8 ()J 
.const [63] = Utf8 java/lang/Object 
.const [64] = Utf8 <init> 
.const [65] = Utf8 ()V 
.const [66] = Utf8 java/lang/StringBuffer 
.const [67] = Utf8 <init> 
.const [68] = Utf8 ()V 
.const [69] = Utf8 de/audi/tghu/fwhmi/MemoryOSDProvider 
.const [70] = Class [69] 
.const [71] = Utf8 java/lang/Object 
.const [72] = Class [71] 
.const [73] = Utf8 de/audi/atip/testsupport/IOSDDataProvider 
.const [74] = Class [73] 
.const [75] = Utf8 Code 
.const [76] = Utf8 <init> 
.const [77] = Utf8 ()V 
.const [78] = Utf8 getName 
.const [79] = Utf8 ()Ljava/lang/String; 
.const [80] = Utf8 getData 
.const [81] = Utf8 ()[Ljava/lang/String; 
.const [82] = Utf8 setTestSupport 
.const [83] = Utf8 (Lde/audi/atip/testsupport/ITestSupportSession;)V 
.end class 
