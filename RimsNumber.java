public class RimsNumber {
    private static final  String[] r_num = {"C", "XC", "L", "XL", "X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
    private static final int[] num = {100, 90, 50, 40, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    //Проверка, является ли строка представлением числа в римском счислении
    public static boolean isNumber(String s){
        boolean isnum = false;
        for(int i = 0; i < r_num.length; i++){
            if(s.equals(r_num[i])){
                isnum = true;
                break;}
            else
                isnum = false;}
        return isnum;
    }
    //Получение арабского числа из строки, если она является числом в римском счислении.
    //Метод вернет число, если оно в пределах [1..10], и таковым является.
    //В противном случае, кинет исключение
    public static int getArabicNumber(String s) throws NotCorrectFormulaException{
        int result = 0;
        for(int i = 0; i < r_num.length; i++){
            if(s.equals(r_num[i])){
                result = num[i];
                break;}
        }
        if(result < 11 && result > 0)
            return result;
        else
            throw new NotCorrectFormulaException("Строка не является римским числом, или не представляет число из промежутка [1..10]");
    }
    //Метод для преобразования числа к строковой записи этого числа римскими цифрами.
    //Метод не учитывает значения имеющие отрицательный характер, т.к. нуля в римском счислении нет,
    //а корректность записи отрицательных чисел не проверялась.
    public static String getRimsResult(int a) throws NotCorrectFormulaException{
        StringBuilder result = new StringBuilder();
        if(!(a > 0))
            throw new NotCorrectFormulaException("Значение меньше, либо равно нуля.");
        while(a / 100 > 0){
            a = a - 100;
            result.append("C");
        }
        while(a / 90 > 0){
            a = a - 90;
            result.append("XC");
        }
        while(a / 50 > 0){
            a = a - 50;
            result.append("L");
        }
        while(a / 40 > 0){
            a = a - 40;
            result.append("XL");
        }
        while(a / 10 > 0){
            a = a - 10;
            result.append("X");
        }
        for(int i = 5; i < num.length; i++){
            if(num[i] == a){
                result.append(r_num[i]);
                break;}
        }

        return result.toString();}

}
