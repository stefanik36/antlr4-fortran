program doLoop
    implicit none
    integer i, i2, i3
    print *, 'wejscie do pętli do'
    do i = 0, 10, 1
        print *, 'DO', i, 1, 'KOLUMNA ZYGMUNTA JUZ STOI'
        do i2 = 0, 10, 1
            print *, 'DO_xD'
            do i3 = 0, 10, 1
                print *, 'DO_xD',i3
            end do
        end do
    end do
end
