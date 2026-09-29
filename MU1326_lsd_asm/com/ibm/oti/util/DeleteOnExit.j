.version 50 0 
.class public super [79] 
.super [81] 
.field private static [82] [83] 

.method static [85] : [86] 
    .attribute [84] .code stack 2 locals 0 
L0:     new [18] 
L3:     dup 
L4:     invokespecial [14] 
L7:     putstatic [15] 
L10:    invokestatic [7] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public annotation [87] : [88] 
    .attribute [84] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [89] : [90] 
    .attribute [84] .code stack 2 locals 0 
L0:     getstatic [5] 
L3:     aload_0 
L4:     invokevirtual [10] 
L7:     return 
L8:     
    .end code 
.end method 

.method public static [91] : [92] 
    .attribute [84] .code stack 3 locals 2 
L0:     getstatic [5] 
L3:     invokevirtual [11] 
L6:     iconst_1 
L7:     isub 
L8:     istore_0 
L9:     goto L38 
L12:    getstatic [5] 
L15:    iload_0 
L16:    invokevirtual [12] 
L19:    checkcast [8] 
L22:    astore_1 
L23:    new [19] 
L26:    dup 
L27:    aload_1 
L28:    invokespecial [17] 
L31:    invokevirtual [13] 
L34:    pop 
L35:    iinc 0 -1 
L38:    iload_0 
L39:    ifge L12 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = Field [23] [24] 
.const [6] = Class [25] 
.const [7] = Method [26] [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Method [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Field [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Class [46] 
.const [19] = Class [47] 
.const [20] = Utf8 com/ibm/oti/util/DeleteOnExit 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 java/util/Vector 
.const [23] = Class [48] 
.const [24] = NameAndType [49] [50] 
.const [25] = Utf8 com/ibm/oti/vm/VM 
.const [26] = Class [51] 
.const [27] = NameAndType [52] [53] 
.const [28] = Utf8 java/lang/String 
.const [29] = Utf8 java/io/File 
.const [30] = Class [54] 
.const [31] = NameAndType [55] [56] 
.const [32] = Class [57] 
.const [33] = NameAndType [58] [59] 
.const [34] = Class [60] 
.const [35] = NameAndType [61] [62] 
.const [36] = Class [63] 
.const [37] = NameAndType [64] [65] 
.const [38] = Class [66] 
.const [39] = NameAndType [67] [68] 
.const [40] = Class [69] 
.const [41] = NameAndType [70] [71] 
.const [42] = Class [72] 
.const [43] = NameAndType [73] [74] 
.const [44] = Class [75] 
.const [45] = NameAndType [76] [77] 
.const [46] = Utf8 java/util/Vector 
.const [47] = Utf8 java/io/File 
.const [48] = Utf8 com/ibm/oti/util/DeleteOnExit 
.const [49] = Utf8 deleteList 
.const [50] = Utf8 Ljava/util/Vector; 
.const [51] = Utf8 com/ibm/oti/vm/VM 
.const [52] = Utf8 deleteOnExit 
.const [53] = Utf8 ()V 
.const [54] = Utf8 java/util/Vector 
.const [55] = Utf8 addElement 
.const [56] = Utf8 (Ljava/lang/Object;)V 
.const [57] = Utf8 java/util/Vector 
.const [58] = Utf8 size 
.const [59] = Utf8 ()I 
.const [60] = Utf8 java/util/Vector 
.const [61] = Utf8 elementAt 
.const [62] = Utf8 (I)Ljava/lang/Object; 
.const [63] = Utf8 java/io/File 
.const [64] = Utf8 delete 
.const [65] = Utf8 ()Z 
.const [66] = Utf8 java/util/Vector 
.const [67] = Utf8 <init> 
.const [68] = Utf8 ()V 
.const [69] = Utf8 com/ibm/oti/util/DeleteOnExit 
.const [70] = Utf8 deleteList 
.const [71] = Utf8 Ljava/util/Vector; 
.const [72] = Utf8 java/lang/Object 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 java/io/File 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (Ljava/lang/String;)V 
.const [78] = Utf8 com/ibm/oti/util/DeleteOnExit 
.const [79] = Class [78] 
.const [80] = Utf8 java/lang/Object 
.const [81] = Class [80] 
.const [82] = Utf8 deleteList 
.const [83] = Utf8 Ljava/util/Vector; 
.const [84] = Utf8 Code 
.const [85] = Utf8 <clinit> 
.const [86] = Utf8 ()V 
.const [87] = Utf8 <init> 
.const [88] = Utf8 ()V 
.const [89] = Utf8 addFile 
.const [90] = Utf8 (Ljava/lang/String;)V 
.const [91] = Utf8 deleteOnExit 
.const [92] = Utf8 ()V 
.end class 
