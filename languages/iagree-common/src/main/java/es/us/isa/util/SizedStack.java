package es.us.isa.util;
import java.util.Stack;

public class SizedStack<T> extends Stack<T> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int maxSize;

    public SizedStack(int size) {
        super();
        this.maxSize = size;
    }

	@Override
    public Object push(Object object) {
        //If the stack is too big, remove elements until it's the right size.
        while (this.size() > maxSize) {
            this.remove(0);
        }
        return super.push((T) object);
    }
}