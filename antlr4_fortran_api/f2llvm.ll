; ModuleID = 'TEST'
source_filename = "TEST"

@0 = private unnamed_addr constant [16 x i8] c"INSIDE FUNCTION\00"
@1 = private unnamed_addr constant [30 x i8] c"%s          %d           %d \0A\00"
@2 = private unnamed_addr constant [5 x i8] c"MAIN\00"
@3 = private unnamed_addr constant [4 x i8] c"%s\0A\00"

define void @ff(i32, i32) {
entry_ff:
  %arg = alloca i32
  store i32 %0, i32* %arg
  %arg2 = alloca i32
  store i32 %1, i32* %arg2
  %2 = load i32, i32* %arg
  %3 = load i32, i32* %arg2
  %4 = call i32 (...) @printf([30 x i8]* @1, [16 x i8]* @0, i32 %2, i32 %3)
  ret void
}

declare i32 @printf(...)

define i32 @main() {
entry_main:
  %0 = call i32 (...) @printf([4 x i8]* @3, [5 x i8]* @2)
  call void @ff(i32 2, i32 1)
  ret i32 0
}
