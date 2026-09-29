.version 50 0 
.class public super [71] 
.super [73] 
.field private volatile [74] [75] 
.field private volatile [76] [77] 
.field private volatile [78] [79] 
.field private volatile [80] [81] 
.field private static final [82] [83] 
.field private static final [84] [85] 
.field private static final [86] [87] 
.field private static final [88] [89] 
.field private static final [90] [91] 
.field private static final [92] [93] 
.field private static final [94] [95] 
.field private static final [96] [97] 
.field private static final [98] [99] 
.field private static final [100] [101] 

.method protected [103] : [104] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [14] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [15] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [105] : [106] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [14] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [16] 
L10:    aload_0 
L11:    fload_3 
L12:    putfield [17] 
L15:    aload_0 
L16:    iload 4 
L18:    putfield [15] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [107] : [108] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     iconst_1 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [109] : [110] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    invokevirtual [12] 
L13:    ifeq L65 
L16:    aload_0 
L17:    getfield [11] 
L20:    fconst_0 
L21:    fcmpl 
L22:    ifne L27 
L25:    iconst_1 
L26:    areturn 
L27:    aload_0 
L28:    getfield [11] 
L31:    ldc [2] 
L33:    fcmpl 
L34:    ifne L39 
L37:    iconst_2 
L38:    areturn 
L39:    aload_0 
L40:    getfield [11] 
L43:    ldc [3] 
L45:    fcmpl 
L46:    ifne L51 
L49:    iconst_3 
L50:    areturn 
L51:    aload_0 
L52:    getfield [11] 
L55:    ldc [4] 
L57:    fcmpl 
L58:    ifne L63 
L61:    iconst_4 
L62:    areturn 
L63:    iconst_1 
L64:    areturn 
L65:    aload_0 
L66:    getfield [11] 
L69:    fconst_0 
L70:    fcmpl 
L71:    ifne L76 
L74:    iconst_1 
L75:    areturn 
L76:    aload_0 
L77:    getfield [11] 
L80:    ldc [3] 
L82:    fcmpl 
L83:    ifne L88 
L86:    iconst_2 
L87:    areturn 
L88:    aload_0 
L89:    getfield [11] 
L92:    ldc [4] 
L94:    fcmpl 
L95:    ifne L100 
L98:    iconst_3 
L99:    areturn 
L100:   aload_0 
L101:   getfield [11] 
L104:   ldc [5] 
L106:   fcmpl 
L107:   ifne L112 
L110:   iconst_4 
L111:   areturn 
L112:   iconst_1 
L113:   areturn 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method protected [111] : [112] 
    .attribute [102] .code stack 1 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L36 
            L49 
            L62 
            L77 
            L92 
            default : L107 

L36:    aload_0 
L37:    invokevirtual [12] 
L40:    ifeq L47 
L43:    fconst_0 
L44:    goto L48 
L47:    fconst_0 
L48:    areturn 
L49:    aload_0 
L50:    invokevirtual [12] 
L53:    ifeq L60 
L56:    fconst_0 
L57:    goto L61 
L60:    fconst_0 
L61:    areturn 
L62:    aload_0 
L63:    invokevirtual [12] 
L66:    ifeq L74 
L69:    ldc [2] 
L71:    goto L76 
L74:    ldc [3] 
L76:    areturn 
L77:    aload_0 
L78:    invokevirtual [12] 
L81:    ifeq L89 
L84:    ldc [3] 
L86:    goto L91 
L89:    ldc [4] 
L91:    areturn 
L92:    aload_0 
L93:    invokevirtual [12] 
L96:    ifeq L104 
L99:    ldc [4] 
L101:   goto L106 
L104:   ldc [5] 
L106:   areturn 
L107:   aload_0 
L108:   invokevirtual [12] 
L111:   ifeq L118 
L114:   fconst_0 
L115:   goto L119 
L118:   fconst_0 
L119:   areturn 
L120:   
    .end code 
.end method 

.method protected [113] : [114] 
    .attribute [102] .code stack 1 locals 0 
L0:     iload_1 
L1:     ifeq L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [115] : [116] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected interface [117] : [118] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 16448 
.const [3] = Int 41024 
.const [4] = Int 8257 
.const [5] = Int 28737 
.const [6] = Class [18] 
.const [7] = Class [19] 
.const [8] = Field [20] [21] 
.const [9] = Field [22] [23] 
.const [10] = Field [24] [25] 
.const [11] = Field [26] [27] 
.const [12] = Method [28] [29] 
.const [13] = Method [30] [31] 
.const [14] = Field [32] [33] 
.const [15] = Field [34] [35] 
.const [16] = Field [36] [37] 
.const [17] = Field [38] [39] 
.const [18] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [19] = Utf8 java/lang/Object 
.const [20] = Class [40] 
.const [21] = NameAndType [41] [42] 
.const [22] = Class [43] 
.const [23] = NameAndType [44] [45] 
.const [24] = Class [46] 
.const [25] = NameAndType [47] [48] 
.const [26] = Class [49] 
.const [27] = NameAndType [50] [51] 
.const [28] = Class [52] 
.const [29] = NameAndType [53] [54] 
.const [30] = Class [55] 
.const [31] = NameAndType [56] [57] 
.const [32] = Class [58] 
.const [33] = NameAndType [59] [60] 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [41] = Utf8 state 
.const [42] = Utf8 Z 
.const [43] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [44] = Utf8 unit 
.const [45] = Utf8 I 
.const [46] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [47] = Utf8 valueState 
.const [48] = Utf8 I 
.const [49] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [50] = Utf8 value 
.const [51] = Utf8 F 
.const [52] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [53] = Utf8 unitIsMPH 
.const [54] = Utf8 ()Z 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 <init> 
.const [57] = Utf8 ()V 
.const [58] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [59] = Utf8 state 
.const [60] = Utf8 Z 
.const [61] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [62] = Utf8 unit 
.const [63] = Utf8 I 
.const [64] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [65] = Utf8 valueState 
.const [66] = Utf8 I 
.const [67] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [68] = Utf8 value 
.const [69] = Utf8 F 
.const [70] = Utf8 de/audi/app/car/core/driveassist/SpeedWarningCameraHandler 
.const [71] = Class [70] 
.const [72] = Utf8 java/lang/Object 
.const [73] = Class [72] 
.const [74] = Utf8 state 
.const [75] = Utf8 Z 
.const [76] = Utf8 valueState 
.const [77] = Utf8 I 
.const [78] = Utf8 value 
.const [79] = Utf8 F 
.const [80] = Utf8 unit 
.const [81] = Utf8 I 
.const [82] = Utf8 KMH_STEP_OFF 
.const [83] = Utf8 F 
.const [84] = Utf8 KMH_STEP_1 
.const [85] = Utf8 F 
.const [86] = Utf8 KMH_STEP_2 
.const [87] = Utf8 F 
.const [88] = Utf8 KMH_STEP_3 
.const [89] = Utf8 F 
.const [90] = Utf8 KMH_STEP_4 
.const [91] = Utf8 F 
.const [92] = Utf8 MPH_STEP_OFF 
.const [93] = Utf8 F 
.const [94] = Utf8 MPH_STEP_1 
.const [95] = Utf8 F 
.const [96] = Utf8 MPH_STEP_2 
.const [97] = Utf8 F 
.const [98] = Utf8 MPH_STEP_3 
.const [99] = Utf8 F 
.const [100] = Utf8 MPH_STEP_4 
.const [101] = Utf8 F 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 setCurrentValues 
.const [106] = Utf8 (ZIFI)V 
.const [107] = Utf8 unitIsMPH 
.const [108] = Utf8 ()Z 
.const [109] = Utf8 getStep 
.const [110] = Utf8 ()I 
.const [111] = Utf8 getValueForStep 
.const [112] = Utf8 (I)F 
.const [113] = Utf8 getStateForStep 
.const [114] = Utf8 (I)Z 
.const [115] = Utf8 getValueStateForStep 
.const [116] = Utf8 (I)I 
.const [117] = Utf8 getUnit 
.const [118] = Utf8 ()I 
.end class 
