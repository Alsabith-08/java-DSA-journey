
// https://leetcode.com/problems/asteroid-collision/description/
// Approach : Stack
// Time Complexity : O(n)

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollisions_735 {
    public static void main(String[] args) {
      
        int[] asteriods = {5, 2, -3 ,-4};

        int[] result = remainingAsteriod(asteriods);

        System.out.println(Arrays.toString(result));
    }
    static int[] remainingAsteriod(int[] asteroids) {

                Stack<Integer> stack = new Stack<>();

                for (int asteroid : asteroids) {

                    boolean destroyed = false;

                   // check stack have element , stack top is positive and asteroid is negative 
                    while (!stack.isEmpty()
                            && stack.peek() > 0
                            && asteroid < 0) {

                        int top = stack.peek();

                       // stack asteroid is smaller 
                        if (top < -asteroid) {
                            stack.pop();
                        }
                           // both are same
                        else if (top == -asteroid) {
                            stack.pop();
                            destroyed = true;
                            break;
                        }
                           // current asteroid is survived
                        else {
                            destroyed = true;
                            break;
                        }
                    }
                     // add all survived asteroid
                    if (!destroyed) {
                        stack.push(asteroid);
                    }
                }
                 // convert stack into array
                int[] result = new int[stack.size()];

                for (int i = 0; i < stack.size(); i++) {
                    result[i] = stack.get(i);
                }

                return result;
            }
        }



