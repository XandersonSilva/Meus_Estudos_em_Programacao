package xanderson.edu.taskBoard.Service;

public class CoutUtil {
    private int count = 0;
    
    public CoutUtil(){}

    public CoutUtil(int initial){
        this.count = initial;
    }

    public int couter(){
        return this.count ++;
    }
    
    public int getCount() {
        return count;
    }
    

}
