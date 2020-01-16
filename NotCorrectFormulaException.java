//Класс является исключением, определяющим все варианты отступлений от условия задачи, или особенностей
//кода. Описание причины вызова исключения представленно в поле string
public class NotCorrectFormulaException extends Exception{
  public NotCorrectFormulaException(String string){
      super(string);
  }
}
