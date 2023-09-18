--ALGEBRA CONCRETA
module StackList  where
import StackADT

instance Stack [] where
    empty xs = []  
    push xs x = (x:xs)
    
    pop (x:xs) = xs

    esVacia [] = True
    esVacia (x:xs) = False

    top (x:xs) = x