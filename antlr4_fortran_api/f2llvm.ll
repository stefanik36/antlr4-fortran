; ModuleID = 'TEST'
source_filename = "TEST"

@0 = private unnamed_addr constant [16 x i8] c"Result fib(13):\00"
@1 = private unnamed_addr constant [17 x i8] c"%s          %d \0A\00"

define i32 @fib(i32) {
entry_fib:
  %fibVar = alloca i32
  %n = alloca i32
  store i32 %0, i32* %n
  %1 = load i32, i32* %n
  %2 = icmp eq i32 %1, 0
  br i1 %2, label %4, label %5

end_block:                                        ; preds = %9, %8, %4
  %3 = load i32, i32* %fibVar
  ret i32 %3

; <label>:4:                                      ; preds = %entry_fib
  store i32 0, i32* %fibVar
  br label %end_block

; <label>:5:                                      ; preds = %entry_fib
  %6 = load i32, i32* %n
  %7 = icmp eq i32 %6, 1
  br i1 %7, label %8, label %9

; <label>:8:                                      ; preds = %5
  store i32 1, i32* %fibVar
  br label %end_block

; <label>:9:                                      ; preds = %5
  %10 = load i32, i32* %n
  %"0-" = sub i32 %10, 1
  %11 = call i32 @fib(i32 %"0-")
  %12 = load i32, i32* %n
  %"0-1" = sub i32 %12, 2
  %13 = call i32 @fib(i32 %"0-1")
  %"0+" = add i32 %13, %11
  store i32 %"0+", i32* %fibVar
  br label %end_block
}

define i32 @main() {
entry_main:
  %result = alloca i32
  %0 = call i32 @fib(i32 13)
  store i32 %0, i32* %result
  %1 = load i32, i32* %result
  %2 = call i32 (...) @printf([17 x i8]* @1, [16 x i8]* @0, i32 %1)
  ret i32 0
}

declare i32 @printf(...)
