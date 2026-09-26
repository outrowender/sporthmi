.version 50 0 
.class public final super [64] 
.super [66] 
.implements [68] 
.field private [69] [70] 
.field private [71] [72] 

.method public [74] : [75] 
    .attribute [73] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_0 
L5:     lconst_0 
L6:     putfield [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [76] : [77] 
    .attribute [73] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private synchronized [78] : [79] 
    .attribute [73] .code stack 9 locals 2 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokestatic [2] 
L7:     lcmp 
L8:     ifeq L23 
L11:    aload_0 
L12:    invokestatic [2] 
L15:    putfield [13] 
L18:    aload_0 
L19:    lconst_0 
L20:    putfield [12] 
L23:    aload_0 
L24:    getfield [8] 
L27:    ldc2_w [15] 
L30:    ladd 
L31:    ldc_w [1] 
L34:    lmul 
L35:    lstore_1 
L36:    aload_0 
L37:    getfield [7] 
L40:    lconst_1 
L41:    ladd 
L42:    ldc_w [1] 
L45:    lcmp 
L46:    iflt L57 
L49:    new [14] 
L52:    dup 
L53:    invokespecial [11] 
L56:    athrow 
L57:    lload_1 
L58:    aload_0 
L59:    dup 
L60:    getfield [7] 
L63:    dup2_x1 
L64:    lconst_1 
L65:    ladd 
L66:    putfield [12] 
L69:    ladd 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [18] [19] 
.const [3] = Class [20] 
.const [4] = Class [21] 
.const [5] = Class [22] 
.const [6] = Class [23] 
.const [7] = Field [24] [25] 
.const [8] = Field [26] [27] 
.const [9] = Method [28] [29] 
.const [10] = Method [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Field [34] [35] 
.const [13] = Field [36] [37] 
.const [14] = Class [38] 
.const [15] = Long 12219292800000L 
.const [17] = Int 270991360 
.const [18] = Class [39] 
.const [19] = NameAndType [40] [41] 
.const [20] = Utf8 org/apache/commons/id/uuid/clock/OverClockedException 
.const [21] = Utf8 org/apache/commons/id/uuid/clock/SystemClockImpl 
.const [22] = Utf8 java/lang/Object 
.const [23] = Utf8 java/lang/System 
.const [24] = Class [42] 
.const [25] = NameAndType [43] [44] 
.const [26] = Class [45] 
.const [27] = NameAndType [46] [47] 
.const [28] = Class [48] 
.const [29] = NameAndType [49] [50] 
.const [30] = Class [51] 
.const [31] = NameAndType [52] [53] 
.const [32] = Class [54] 
.const [33] = NameAndType [55] [56] 
.const [34] = Class [57] 
.const [35] = NameAndType [58] [59] 
.const [36] = Class [60] 
.const [37] = NameAndType [61] [62] 
.const [38] = Utf8 org/apache/commons/id/uuid/clock/OverClockedException 
.const [39] = Utf8 java/lang/System 
.const [40] = Utf8 currentTimeMillis 
.const [41] = Utf8 ()J 
.const [42] = Utf8 org/apache/commons/id/uuid/clock/SystemClockImpl 
.const [43] = Utf8 generatedThisMilli 
.const [44] = Utf8 J 
.const [45] = Utf8 org/apache/commons/id/uuid/clock/SystemClockImpl 
.const [46] = Utf8 currentTimeMillis 
.const [47] = Utf8 J 
.const [48] = Utf8 java/lang/Object 
.const [49] = Utf8 <init> 
.const [50] = Utf8 ()V 
.const [51] = Utf8 org/apache/commons/id/uuid/clock/SystemClockImpl 
.const [52] = Utf8 getTimeSynchronized 
.const [53] = Utf8 ()J 
.const [54] = Utf8 org/apache/commons/id/uuid/clock/OverClockedException 
.const [55] = Utf8 <init> 
.const [56] = Utf8 ()V 
.const [57] = Utf8 org/apache/commons/id/uuid/clock/SystemClockImpl 
.const [58] = Utf8 generatedThisMilli 
.const [59] = Utf8 J 
.const [60] = Utf8 org/apache/commons/id/uuid/clock/SystemClockImpl 
.const [61] = Utf8 currentTimeMillis 
.const [62] = Utf8 J 
.const [63] = Utf8 org/apache/commons/id/uuid/clock/SystemClockImpl 
.const [64] = Class [63] 
.const [65] = Utf8 java/lang/Object 
.const [66] = Class [65] 
.const [67] = Utf8 org/apache/commons/id/uuid/clock/Clock 
.const [68] = Class [67] 
.const [69] = Utf8 generatedThisMilli 
.const [70] = Utf8 J 
.const [71] = Utf8 currentTimeMillis 
.const [72] = Utf8 J 
.const [73] = Utf8 Code 
.const [74] = Utf8 <init> 
.const [75] = Utf8 ()V 
.const [76] = Utf8 getUUIDTime 
.const [77] = Utf8 ()J 
.const [78] = Utf8 getTimeSynchronized 
.const [79] = Utf8 ()J 
.end class 
