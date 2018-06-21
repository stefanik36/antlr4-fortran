; ModuleID = 'TEST'
source_filename = "TEST"

@0 = private unnamed_addr constant [15 x i8] c"Subroutine sub\00"
@1 = private unnamed_addr constant [30 x i8] c"%s          %d           %d \0A\00"
@2 = private unnamed_addr constant [10 x i8] c"Funkcja f\00"
@3 = private unnamed_addr constant [17 x i8] c"%s          %d \0A\00"
@4 = private unnamed_addr constant [5 x i8] c"MAIN\00"
@5 = private unnamed_addr constant [4 x i8] c"%s\0A\00"

define void @sub(i32, i32) {
entry_sub:
  %arg = alloca i32
  store i32 %0, i32* %arg
  %arg2 = alloca i32
  store i32 %1, i32* %arg2
  %2 = load i32, i32* %arg
  %3 = load i32, i32* %arg2
  %4 = call i32 (...) @printf([30 x i8]* @1, [15 x i8]* @0, i32 %2, i32 %3)
  ret void
}

declare i32 @printf(...)

define i32 @f(i32, i32) {
entry_f:
  %arg = alloca i32
  store i32 %0, i32* %arg
  %fVar = alloca i32
  %n = alloca i32
  store i32 %1, i32* %n
  %2 = load i32, i32* %n
  %3 = call i32 (...) @printf([17 x i8]* @3, [10 x i8]* @2, i32 %2)
  %4 = load i32, i32* %arg
  store i32 %4, i32* %fVar
  %5 = load i32, i32* %fVar
  ret i32 %5
}

define i32 @main() {
entry_main:
  %0 = call i32 (...) @printf([4 x i8]* @5, [5 x i8]* @4)
  %1 = call i32 @f(i32 12, i32 3)
  call void @sub(i32 2, i32 %1)
  ret i32 0
}
