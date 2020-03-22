public class BinaryExponentiation {

    long recursiveBinaryExponentiation(long base, long exponent){

        if(exponent == 0){
            return 1;
        }

        long result = recursiveBinaryExponentiation(base,exponent/2);
        if((exponent&1)==1){
            return result * result * base;
        }
        else {
            return result * result;
        }

    }


    long iterativeBinaryExponentiation(long base,long exponent){
        long result =1;
        while (exponent>0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }

}
