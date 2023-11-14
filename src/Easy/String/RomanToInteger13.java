package String;

/**
 * Runtime
 * 4 ms
 * Beats
 * 94.12%
 *
 * Memory
 * 43 MB
 * Beats
 * 34.94%
 *
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class RomanToInteger13 {
    public int romanToInt(String s) {
        int index = 0;
        int len = s.length();
        int value = 0;

        while (index < len){
            switch (s.charAt(index++)){
                case 'I':
                    if (index == len) return value += 1;
                    if (s.charAt(index) == 'V') {
                        value += 4;
                        index++;
                    }else if (s.charAt(index) == 'X') {
                        value += 9;
                        index++;
                    }else {
                        value += 1;
                    }
                    break;
                case 'V':
                    value += 5;
                    break;
                case 'X':
                    if (index == len) return value += 10;
                    if (s.charAt(index) == 'L') {
                        value += 40;
                        index++;
                    }else if (s.charAt(index) == 'C') {
                        value += 90;
                        index++;
                    }else {
                        value += 10;
                    }
                    break;
                case 'L':
                    value += 50;
                    break;
                case 'C':
                    if (index == len) return value += 100;
                    if (s.charAt(index) == 'D') {
                        value += 400;
                        index++;
                    }else if (s.charAt(index) == 'M') {
                        value += 900;
                        index++;
                    }else {
                        value += 100;
                    }
                    break;
                case 'D':
                    value += 500;
                    break;
                case 'M':
                    value += 1000;
                    break;
                default:
            }
        }
        return value;
    }
}
