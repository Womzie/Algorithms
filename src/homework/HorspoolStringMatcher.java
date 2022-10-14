package homework;

public class HorspoolStringMatcher {
    String key;
    int len;

    public HorspoolStringMatcher(String s) {
        key = s;
        len = s.length();
    }

    public int getShift(char m) {
        int tempShift = 0;
        int flag = 0;
        for (int i = 0; i < len-1; i++) {
            if(key.charAt(i) == m){
                flag = 1;
                tempShift = len - i - 1;
            }
        }
        if(flag > 0){
            return tempShift;
        }
        return len;

    }

    public int match(String s) {
        int i = len -1;
        int loc = -1;
        while(i < s.length()){
            // checks last char of key vs its comparitor
            if(s.charAt(i) == key.charAt(len-1)){
                // then go back through and check for every part of key
                int flag = 0;
                for (int j = 1; j < len-1; j++) {

                    if(s.charAt(i - j) != key.charAt(len - 1 - j)){
                        flag = getShift(s.charAt(i - j));
                        break;
                    }
                    if(j == len-2){
                        loc = i - j - 1;
                        return loc;
                    }
                }
                i += flag;


            }
            else{
                i += getShift(s.charAt(i));
            }

        }

        return loc;
    }
}
