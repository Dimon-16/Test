import java.io.*;

public class TestForJM {
    public static void main(String[] args){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String formula = reader.readLine();
            reader.close();
            formula = formula.trim();
            String[] components = formula.split(" +");
            //Для смотрящих:
            //Не стал мудрить, и делать вид, что запись может иметь вид 3/8 без пробелов.
            //В примерах явно эти пробелы есть, принял это как необходимое условие, при решении задачи.
            if(components.length != 3)
                throw new NotCorrectFormulaException("Вы не корректно ввели формулу для вычислений!");
            //Проверка на однородность записи выражения(только римские, или только арабские цифры
            if(Calculator.isNumber(components[0]).equals(Calculator.isNumber(components[2])))
                System.out.println(Calculator.result(components));
            else
                throw new NotCorrectFormulaException("Используйте только арабские или только римские цифры!");

        }
        catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
}
