function ff(arg)
    integer arg
    print *, 'INSIDE FUNCTION'
    ff = 0
end
program xfunc
    implicit none
    integer i1
    character*(20) vv
    integer func2
    i1 = 3
    vv = ff(i1)
    print *, 'FUNCTION VALUE', i1, 'V: ', vv
end

