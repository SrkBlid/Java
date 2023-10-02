data Racional = Racional Integer Integer deriving Show

crearRacional :: Integer -> Integer -> Racional
crearRacional numerador denominador
    | denominador == 0 = error "El denominador no puede ser 0."
    | otherwise = Racional numerador denominador

mostrarRacional :: Racional -> String
mostrarRacional (Racional num div) = show num++"/"++show div

sumarRacional :: Racional -> Racional -> Racional
sumarRacional (Racional a b) (Racional c d)
    | b == d = Racional (a+c) b
    | otherwise = Racional (d*a+b*c) (b*d)

multRacional :: Racional -> Racional -> Racional
multRacional (Racional a b) (Racional c d) = Racional (a*c) (b*d)

divRacional :: Racional -> Racional -> Racional
divRacional (Racional a b) (Racional c d) = Racional (a*d) (b*c)

instance Eq Racional where
    (Racional a b) == (Racional c d) = a*d == b*c