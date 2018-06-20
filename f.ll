@0 = private unnamed_addr constant [21 x i8] c"wejscie do p\C4\99tli do\00"
@1 = private unnamed_addr constant [4 x i8] c"%s\0A\00"
@2 = private unnamed_addr constant [3 x i8] c"DO\00"
@3 = private unnamed_addr constant [26 x i8] c"KOLUMNA ZYGMUNTA JUZ STOI\00"
@4 = private unnamed_addr constant [32 x i8] c"%s          %d           %d %s\0A\00"
@5 = private unnamed_addr constant [6 x i8] c"DO_xD\00"
@6 = private unnamed_addr constant [4 x i8] c"%s\0A\00"
@7 = private unnamed_addr constant [6 x i8] c"DO_xD\00"
@8 = private unnamed_addr constant [17 x i8] c"%s          %d \0A\00"

define i32 @main() {
entry_main:
  %i = alloca i32
  %i2 = alloca i32
  %i3 = alloca i32
  %0 = call i32 (...) @printf([4 x i8]* @1, [21 x i8]* @0)
  store i32 0, i32* %i
  br label %loop

loop:                                             ; preds = %end_loop3, %entry_main
  %1 = load i32, i32* %i
  %2 = add i32 %1, 1
  store i32 %2, i32* %i
  %3 = icmp slt i32 %2, 10
  br i1 %3, label %body_loop, label %end_loop

body_loop:                                        ; preds = %loop
  %4 = load i32, i32* %i
  %5 = call i32 (...) @printf([32 x i8]* @4, [3 x i8]* @2, i32 %4, i32 1, [26 x i8]* @3)
  store i32 0, i32* %i2
  br label %loop1

end_loop:                                         ; preds = %loop
  ret i32 0

loop1:                                            ; preds = %end_loop6, %body_loop
  %6 = load i32, i32* %i2
  %7 = add i32 %6, 1
  store i32 %7, i32* %i2
  %8 = icmp slt i32 %7, 10
  br i1 %8, label %body_loop2, label %end_loop3

body_loop2:                                       ; preds = %loop1
  %9 = call i32 (...) @printf([4 x i8]* @6, [6 x i8]* @5)
  store i32 0, i32* %i3
  br label %loop4

end_loop3:                                        ; preds = %loop1
  br label %loop

loop4:                                            ; preds = %body_loop5, %body_loop2
  %10 = load i32, i32* %i3
  %11 = add i32 %10, 1
  store i32 %11, i32* %i3
  %12 = icmp slt i32 %11, 10
  br i1 %12, label %body_loop5, label %end_loop6

body_loop5:                                       ; preds = %loop4
  %13 = load i32, i32* %i3
  %14 = call i32 (...) @printf([17 x i8]* @8, [6 x i8]* @7, i32 %13)
  br label %loop4

end_loop6:                                        ; preds = %loop4
  br label %loop1
}

declare i32 @printf(...)