function ff(arg)
    integer ff, arg
    print *, 'INSIDE FUNCTION'
    arg = 13
    ff = 666 + arg
end
program xfunc
    implicit none
    integer i1, vv
    integer func2
    i1 = 3
    vv = ff(i1)
    print *, 'FUNCTION VALUE', i1, 'V: ', vv
end

