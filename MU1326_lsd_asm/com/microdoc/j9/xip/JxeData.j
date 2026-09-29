.version 50 0 
.class public final super [60] 
.super [62] 
.field private final [63] [64] 
.field private final [65] [66] 
.field private final [67] [68] 

.method public [70] : [71] 
    .attribute [69] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [10] 
L9:     aload_0 
L10:    lload_2 
L11:    putfield [11] 
L14:    aload_0 
L15:    iload 4 
L17:    putfield [12] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [72] : [73] 
    .attribute [69] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [74] : [75] 
    .attribute [69] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [76] : [77] 
    .attribute [69] .code stack 6 locals 0 
L0:     lconst_0 
L1:     aload_0 
L2:     getfield [6] 
L5:     ldc_w [1] 
L8:     lrem 
L9:     lcmp 
L10:    ifne L18 
L13:    aload_0 
L14:    getfield [6] 
L17:    freturn 
L18:    aload_0 
L19:    getfield [6] 
L22:    ldc_w [1] 
L25:    ladd 
L26:    aload_0 
L27:    getfield [6] 
L30:    ldc_w [1] 
L33:    lrem 
L34:    lsub 
L35:    freturn 
L36:    
    .end code 
.end method 

.method public interface [78] : [79] 
    .attribute [69] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [80] : [81] 
    .attribute [69] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     ifeq L25 
L7:     new [13] 
L10:    dup 
L11:    aload_0 
L12:    getfield [6] 
L15:    aload_0 
L16:    getfield [7] 
L19:    invokespecial [9] 
L22:    goto L26 
L25:    aconst_null 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Field [18] [19] 
.const [6] = Field [20] [21] 
.const [7] = Field [22] [23] 
.const [8] = Method [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Field [28] [29] 
.const [11] = Field [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Class [34] 
.const [14] = Int 134217728 
.const [15] = Utf8 com/microdoc/j9/xip/JxeData 
.const [16] = Utf8 java/lang/Object 
.const [17] = Utf8 com/microdoc/j9/xip/JxeDataUnloader 
.const [18] = Class [35] 
.const [19] = NameAndType [36] [37] 
.const [20] = Class [38] 
.const [21] = NameAndType [39] [40] 
.const [22] = Class [41] 
.const [23] = NameAndType [42] [43] 
.const [24] = Class [44] 
.const [25] = NameAndType [45] [46] 
.const [26] = Class [47] 
.const [27] = NameAndType [48] [49] 
.const [28] = Class [50] 
.const [29] = NameAndType [51] [52] 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Class [56] 
.const [33] = NameAndType [57] [58] 
.const [34] = Utf8 com/microdoc/j9/xip/JxeDataUnloader 
.const [35] = Utf8 com/microdoc/j9/xip/JxeData 
.const [36] = Utf8 fJxe 
.const [37] = Utf8 Lcom/ibm/oti/vm/Jxe; 
.const [38] = Utf8 com/microdoc/j9/xip/JxeData 
.const [39] = Utf8 fPointer 
.const [40] = Utf8 J 
.const [41] = Utf8 com/microdoc/j9/xip/JxeData 
.const [42] = Utf8 fAllocated 
.const [43] = Utf8 Z 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ()V 
.const [47] = Utf8 com/microdoc/j9/xip/JxeDataUnloader 
.const [48] = Utf8 <init> 
.const [49] = Utf8 (JZ)V 
.const [50] = Utf8 com/microdoc/j9/xip/JxeData 
.const [51] = Utf8 fJxe 
.const [52] = Utf8 Lcom/ibm/oti/vm/Jxe; 
.const [53] = Utf8 com/microdoc/j9/xip/JxeData 
.const [54] = Utf8 fPointer 
.const [55] = Utf8 J 
.const [56] = Utf8 com/microdoc/j9/xip/JxeData 
.const [57] = Utf8 fAllocated 
.const [58] = Utf8 Z 
.const [59] = Utf8 com/microdoc/j9/xip/JxeData 
.const [60] = Class [59] 
.const [61] = Utf8 java/lang/Object 
.const [62] = Class [61] 
.const [63] = Utf8 fPointer 
.const [64] = Utf8 J 
.const [65] = Utf8 fAllocated 
.const [66] = Utf8 Z 
.const [67] = Utf8 fJxe 
.const [68] = Utf8 Lcom/ibm/oti/vm/Jxe; 
.const [69] = Utf8 Code 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Lcom/ibm/oti/vm/Jxe;JZ)V 
.const [72] = Utf8 isAllocated 
.const [73] = Utf8 ()Z 
.const [74] = Utf8 getPointer 
.const [75] = Utf8 ()J 
.const [76] = Utf8 getPointerAligned 
.const [77] = Utf8 ()J 
.const [78] = Utf8 getJxe 
.const [79] = Utf8 ()Lcom/ibm/oti/vm/Jxe; 
.const [80] = Utf8 unloader 
.const [81] = Utf8 ()Lcom/microdoc/j9/xip/JxeDataUnloader; 
.end class 
