.version 50 0 
.class public super [129] 
.super [131] 
.field public static final [132] [133] 
.field public static final [134] [135] 
.field public static final [136] [137] 
.field public static final [138] [139] 
.field public static final [140] [141] 
.field public static final [142] [143] 
.field private [144] [145] 
.field private [146] [147] 
.field private [148] [149] 

.method private [151] : [152] 
    .attribute [150] .code stack 2 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            10 : L60 
            20 : L63 
            21 : L66 
            30 : L69 
            40 : L72 
            60 : L75 
            default : L78 

L60:    ldc [2] 
L62:    areturn 
L63:    ldc [3] 
L65:    areturn 
L66:    ldc [4] 
L68:    areturn 
L69:    ldc [5] 
L71:    areturn 
L72:    ldc [6] 
L74:    areturn 
L75:    ldc [7] 
L77:    areturn 
L78:    new [31] 
L81:    dup 
L82:    invokespecial [27] 
L85:    ldc [9] 
L87:    invokevirtual [19] 
L90:    iload_1 
L91:    invokevirtual [20] 
L94:    invokevirtual [21] 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [150] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [32] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [33] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [34] 
L19:    aload_0 
L20:    iload_1 
L21:    putfield [33] 
L24:    aload_0 
L25:    aload_0 
L26:    aload_0 
L27:    getfield [23] 
L30:    invokespecial [29] 
L33:    putfield [34] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [32] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [33] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [34] 
L19:    aload_0 
L20:    iload_1 
L21:    putfield [33] 
L24:    aload_0 
L25:    aload_2 
L26:    putfield [32] 
L29:    aload_0 
L30:    aload_2 
L31:    invokevirtual [25] 
L34:    putfield [34] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [32] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [33] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [34] 
L19:    aload_0 
L20:    iload_1 
L21:    putfield [33] 
L24:    aload_0 
L25:    aload_2 
L26:    putfield [34] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [32] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [33] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [34] 
L19:    aload_0 
L20:    aload_1 
L21:    putfield [32] 
L24:    aload_0 
L25:    aload_1 
L26:    invokevirtual [25] 
L29:    putfield [34] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public interface [161] : [162] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [163] : [164] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [165] : [166] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [150] .code stack 2 locals 1 
L0:     ldc [10] 
L2:     astore_1 
L3:     aload_0 
L4:     getfield [22] 
L7:     ifnull L55 
L10:    new [31] 
L13:    dup 
L14:    invokespecial [27] 
L17:    aload_1 
L18:    invokevirtual [19] 
L21:    ldc [11] 
L23:    invokevirtual [19] 
L26:    aload_0 
L27:    getfield [22] 
L30:    invokespecial [30] 
L33:    invokevirtual [26] 
L36:    ldc [12] 
L38:    invokevirtual [19] 
L41:    aload_0 
L42:    getfield [22] 
L45:    invokevirtual [25] 
L48:    invokevirtual [19] 
L51:    invokevirtual [21] 
L54:    astore_1 
L55:    aload_0 
L56:    getfield [23] 
L59:    iconst_m1 
L60:    if_icmpeq L95 
L63:    new [31] 
L66:    dup 
L67:    invokespecial [27] 
L70:    aload_1 
L71:    invokevirtual [19] 
L74:    ldc [13] 
L76:    invokevirtual [19] 
L79:    aload_0 
L80:    getfield [23] 
L83:    invokevirtual [20] 
L86:    ldc [14] 
L88:    invokevirtual [19] 
L91:    invokevirtual [21] 
L94:    astore_1 
L95:    aload_0 
L96:    getfield [24] 
L99:    ifnull L129 
L102:   new [31] 
L105:   dup 
L106:   invokespecial [27] 
L109:   aload_1 
L110:   invokevirtual [19] 
L113:   ldc [15] 
L115:   invokevirtual [19] 
L118:   aload_0 
L119:   getfield [24] 
L122:   invokevirtual [19] 
L125:   invokevirtual [21] 
L128:   astore_1 
L129:   aload_1 
L130:   areturn 
L131:   nop 
L132:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [35] 
.const [3] = String [36] 
.const [4] = String [37] 
.const [5] = String [38] 
.const [6] = String [39] 
.const [7] = String [40] 
.const [8] = Class [41] 
.const [9] = String [42] 
.const [10] = String [43] 
.const [11] = String [44] 
.const [12] = String [45] 
.const [13] = String [46] 
.const [14] = String [47] 
.const [15] = String [48] 
.const [16] = Class [49] 
.const [17] = Class [50] 
.const [18] = Class [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Field [58] [59] 
.const [23] = Field [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Method [64] [65] 
.const [26] = Method [66] [67] 
.const [27] = Method [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = Method [72] [73] 
.const [30] = Method [74] [75] 
.const [31] = Class [76] 
.const [32] = Field [77] [78] 
.const [33] = Field [79] [80] 
.const [34] = Field [81] [82] 
.const [35] = Utf8 'Error in operation' 
.const [36] = Utf8 'Error in sending operation download' 
.const [37] = Utf8 'Error in sending operation status' 
.const [38] = Utf8 'send request failed' 
.const [39] = Utf8 'received unexpected or invalid data' 
.const [40] = Utf8 'Exit or Init Message received, Transfer canceled ' 
.const [41] = Utf8 java/lang/StringBuffer 
.const [42] = Utf8 'no error message found for errorcode : ' 
.const [43] = Utf8 'FileTransferError: ' 
.const [44] = Utf8 'Exception: ' 
.const [45] = Utf8 ', ' 
.const [46] = Utf8 'ErrorCode: ' 
.const [47] = Utf8 ' ' 
.const [48] = Utf8 'ErrorMessage: ' 
.const [49] = Utf8 de/esolutions/fw/util/tracing/filetransfer/FileTransferError 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 java/lang/Exception 
.const [52] = Class [83] 
.const [53] = NameAndType [84] [85] 
.const [54] = Class [86] 
.const [55] = NameAndType [87] [88] 
.const [56] = Class [89] 
.const [57] = NameAndType [90] [91] 
.const [58] = Class [92] 
.const [59] = NameAndType [93] [94] 
.const [60] = Class [95] 
.const [61] = NameAndType [96] [97] 
.const [62] = Class [98] 
.const [63] = NameAndType [99] [100] 
.const [64] = Class [101] 
.const [65] = NameAndType [102] [103] 
.const [66] = Class [104] 
.const [67] = NameAndType [105] [106] 
.const [68] = Class [107] 
.const [69] = NameAndType [108] [109] 
.const [70] = Class [110] 
.const [71] = NameAndType [111] [112] 
.const [72] = Class [113] 
.const [73] = NameAndType [114] [115] 
.const [74] = Class [116] 
.const [75] = NameAndType [117] [118] 
.const [76] = Utf8 java/lang/StringBuffer 
.const [77] = Class [119] 
.const [78] = NameAndType [120] [121] 
.const [79] = Class [122] 
.const [80] = NameAndType [123] [124] 
.const [81] = Class [125] 
.const [82] = NameAndType [126] [127] 
.const [83] = Utf8 java/lang/StringBuffer 
.const [84] = Utf8 append 
.const [85] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [86] = Utf8 java/lang/StringBuffer 
.const [87] = Utf8 append 
.const [88] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Utf8 toString 
.const [91] = Utf8 ()Ljava/lang/String; 
.const [92] = Utf8 de/esolutions/fw/util/tracing/filetransfer/FileTransferError 
.const [93] = Utf8 exception 
.const [94] = Utf8 Ljava/lang/Exception; 
.const [95] = Utf8 de/esolutions/fw/util/tracing/filetransfer/FileTransferError 
.const [96] = Utf8 errorCode 
.const [97] = Utf8 B 
.const [98] = Utf8 de/esolutions/fw/util/tracing/filetransfer/FileTransferError 
.const [99] = Utf8 errorMessage 
.const [100] = Utf8 Ljava/lang/String; 
.const [101] = Utf8 java/lang/Exception 
.const [102] = Utf8 getMessage 
.const [103] = Utf8 ()Ljava/lang/String; 
.const [104] = Utf8 java/lang/StringBuffer 
.const [105] = Utf8 append 
.const [106] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 java/lang/Object 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/esolutions/fw/util/tracing/filetransfer/FileTransferError 
.const [114] = Utf8 getErrorMessage 
.const [115] = Utf8 (B)Ljava/lang/String; 
.const [116] = Utf8 java/lang/Object 
.const [117] = Utf8 getClass 
.const [118] = Utf8 ()Ljava/lang/Class; 
.const [119] = Utf8 de/esolutions/fw/util/tracing/filetransfer/FileTransferError 
.const [120] = Utf8 exception 
.const [121] = Utf8 Ljava/lang/Exception; 
.const [122] = Utf8 de/esolutions/fw/util/tracing/filetransfer/FileTransferError 
.const [123] = Utf8 errorCode 
.const [124] = Utf8 B 
.const [125] = Utf8 de/esolutions/fw/util/tracing/filetransfer/FileTransferError 
.const [126] = Utf8 errorMessage 
.const [127] = Utf8 Ljava/lang/String; 
.const [128] = Utf8 de/esolutions/fw/util/tracing/filetransfer/FileTransferError 
.const [129] = Class [128] 
.const [130] = Utf8 java/lang/Object 
.const [131] = Class [130] 
.const [132] = Utf8 ERROR_IN_OPERATION 
.const [133] = Utf8 B 
.const [134] = Utf8 ERROR_SENDING_OPERATION_DOWNLOAD 
.const [135] = Utf8 B 
.const [136] = Utf8 ERROR_SENDING_OPERATION_STATUS 
.const [137] = Utf8 B 
.const [138] = Utf8 ERROR_SEND_REQUEST_FAILED 
.const [139] = Utf8 B 
.const [140] = Utf8 ERROR_RECEIVED_INVALID_DATA 
.const [141] = Utf8 B 
.const [142] = Utf8 ERROR_SESSION_END_DETECTED 
.const [143] = Utf8 B 
.const [144] = Utf8 exception 
.const [145] = Utf8 Ljava/lang/Exception; 
.const [146] = Utf8 errorCode 
.const [147] = Utf8 B 
.const [148] = Utf8 errorMessage 
.const [149] = Utf8 Ljava/lang/String; 
.const [150] = Utf8 Code 
.const [151] = Utf8 getErrorMessage 
.const [152] = Utf8 (B)Ljava/lang/String; 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (B)V 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (BLjava/lang/Exception;)V 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (BLjava/lang/String;)V 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Ljava/lang/Exception;)V 
.const [161] = Utf8 getException 
.const [162] = Utf8 ()Ljava/lang/Exception; 
.const [163] = Utf8 getErrorCode 
.const [164] = Utf8 ()B 
.const [165] = Utf8 getErrorMessage 
.const [166] = Utf8 ()Ljava/lang/String; 
.const [167] = Utf8 toString 
.const [168] = Utf8 ()Ljava/lang/String; 
.end class 
