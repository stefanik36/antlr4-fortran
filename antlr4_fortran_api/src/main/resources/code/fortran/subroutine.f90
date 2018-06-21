subroutine sub(arg, arg2)
    integer arg, arg2
    print *, 'Subroutine sub', arg, arg2
end
function f(arg, n)
    integer arg, f, n
    print *, 'Funkcja f', n
    f = arg
end
program xfunc
    implicit none
    print *, 'MAIN', 12 + 11
    call sub(2,f(12, 3))
end
