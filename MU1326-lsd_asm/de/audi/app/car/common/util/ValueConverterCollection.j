.version 50 0 
.class public super [11] 
.super [13] 
.field public static final [14] [15] 

.method public annotation [17] : [18] 
    .attribute [16] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [3] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [19] : [20] 
    .attribute [16] .code stack 1 locals 1 
L0:     iload_0 
L1:     lookupswitch 
            1 : L28 
            2 : L33 
            default : L38 

L28:    iconst_0 
L29:    istore_1 
L30:    goto L40 
L33:    iconst_1 
L34:    istore_1 
L35:    goto L40 
L38:    iconst_m1 
L39:    istore_1 
L40:    iload_1 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method protected [21] : [22] 
    .attribute [16] .code stack 1 locals 1 
L0:     iload_1 
L1:     lookupswitch 
            0 : L28 
            1 : L33 
            default : L38 

L28:    iconst_1 
L29:    istore_2 
L30:    goto L40 
L33:    iconst_2 
L34:    istore_2 
L35:    goto L40 
L38:    iconst_m1 
L39:    istore_2 
L40:    iload_2 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [4] 
.const [3] = Method [5] [6] 
.const [4] = Utf8 java/lang/Object 
.const [5] = Class [7] 
.const [6] = NameAndType [8] [9] 
.const [7] = Utf8 java/lang/Object 
.const [8] = Utf8 <init> 
.const [9] = Utf8 ()V 
.const [10] = Utf8 de/audi/app/car/common/util/ValueConverterCollection 
.const [11] = Class [10] 
.const [12] = Utf8 java/lang/Object 
.const [13] = Class [12] 
.const [14] = Utf8 INVALID 
.const [15] = Utf8 I 
.const [16] = Utf8 Code 
.const [17] = Utf8 <init> 
.const [18] = Utf8 ()V 
.const [19] = Utf8 convertTemperatureUnitHMI2DSI 
.const [20] = Utf8 (I)I 
.const [21] = Utf8 convertTemperatureUnitDSI2HMI 
.const [22] = Utf8 (I)I 
.end class 
