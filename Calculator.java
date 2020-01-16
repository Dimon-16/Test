
public class Calculator {
    private static boolean resultRims = false;
    // метод проверяет данные на предмет принадлежности строки к числу, возвращает
    //строку arabic - для арабских цифр, rims - для принадлежности к римским цифрам
    public static String isNumber(String text) throws NotCorrectFormulaException{

        try {
            if(RimsNumber.isNumber(text))
                return "rims";
            else {
                int a = Integer.parseInt(text);
                return "arabic";}
        }
        catch (Exception exc) {
            throw new NotCorrectFormulaException("Введены некоректные числовые данные!");//return false;
        }
    }
    //Метод производит арифметические операции над двумя числами и возвращает результат
    public static String result(String[] array) throws NotCorrectFormulaException{
        int result;
        int a = numberFor(array[0]);
        int b = numberFor(array[2]);
        switch(array[1]){
            case ("+"):
                result = a + b;
                break;
            case ("-"):
                result = a - b;
                break;
            case ("/"):
                result =  a / b;
                break;
            case ("*"):
                result = a * b;
                break;
            default:
                throw new NotCorrectFormulaException("Возможные арифметические действия только: +, -, /, *!");
        }
        if(!resultRims)
            return Integer.toString(result);
        else
            return RimsNumber.getRimsResult(result);
    }
    //Метод преобразует римские цифры в арабские и проверяет диапазон чисел, определенных условиями задачи
    private static int numberFor (String s) throws NotCorrectFormulaException{
        int a;
        if(RimsNumber.isNumber(s)){
            a = RimsNumber.getArabicNumber(s);
            resultRims = true;
        }
        else
            a = Integer.parseInt(s);
        if(a < 11 && a > 0)
            return a;
        else
            throw new NotCorrectFormulaException("Введите число из промежутка [1..10]");
    }
}
