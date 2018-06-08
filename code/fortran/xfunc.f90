function func(arg)
    integer arg
    integer func
    func = arg
end
program xfunc
    implicit none
    integer i1
    integer func2
    i1 = 3
    print *, 'sum of the square and cube of', i1, ' is', func(i1)
end
