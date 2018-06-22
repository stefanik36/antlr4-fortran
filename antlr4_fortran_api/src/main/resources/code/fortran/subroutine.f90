subroutine sub(arg, arg2)
    integer arg, arg2
    print *, 'Subroutine sub', arg, arg2
end
function f(arg, n)
    integer arg, f, n, i
    print *, 'Funkcja f'
    f = 0
    do i=0, 3
        print *, 'do', i, n
    end do
    f = f + arg
end
program xfunc
    implicit none
    integer z
    z = 0
    print *, 'MAIN', z
    call sub(2,f(12, 3))
end
