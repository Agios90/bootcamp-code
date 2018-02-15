package javaapplication17;


public class JavaApplication17 {

    public static int findLastL (StringBuilder s) {
        
        int lastL = 0;
        int i=0;
        do {
            if (s.toString().charAt(i) == 'l') {
                    lastL = i;
            }
            i++;
            
            } while (i<s.length());
        return lastL;
        
    }
    
    public static void main(String[] args) {
        
        StringBuilder buffer1 = new StringBuilder();
        StringBuilder buffer2 = new StringBuilder();
        StringBuilder buffer3 = new StringBuilder();
        String str1;
        String str2;
        String str3;
        
        buffer1.append("kalimera");
        buffer2.append("kalispera");
        buffer3.append("kalispera");
        
        buffer1.append("laloleasdfasdf");
        buffer2.append("10");
        buffer3.append(10);
        
        System.out.println("Last l in buffer1 is at: " + findLastL(buffer1));
        System.out.println("First l in buffer 1 is at " + buffer1.indexOf("l",0));
        
        System.out.println("Buffer 1: " + buffer1);
        System.out.println("Buffer 2: " + buffer2);
        System.out.println("Buffer 3: " + buffer3);
        
        System.out.println("Is buffer 2 equal to buffer 3? " + buffer2.toString().equals(buffer3.toString()));
        
        str1 = buffer1.toString();
        str2 = buffer2.toString();
        str3 = buffer3.toString();
        System.out.printf("Emfanisi kai twn 3 buffer: %s %s %s \n",buffer1,str2,str3);
    }
    
}
