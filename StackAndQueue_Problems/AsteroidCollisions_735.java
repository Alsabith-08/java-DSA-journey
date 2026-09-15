package LeetCodeEx.StackAndQueue;
import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/description/
// Approach : Stack
// Time Complexity : O(n)

/*
   We are given an array asteroids of integers representing asteroids in a row.
   The indices of the asteroid in the array represent their relative position in space.

   For each asteroid, the absolute value represents its size, and the sign represents
   its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

   Find out the state of the asteroids after all collisions. If two asteroids meet,
   the smaller one will explode. If both are the same size, both will explode.
   Two asteroids moving in the same direction will never meet.
   */
public class AsteroidCollisions_735 {
    public static void main(String[] args) {
        int[] asteriods = {8,-8};

        int[] result = remainingAsteriod(asteriods);

        System.out.println(Arrays.toString(result));
    }
    static int[] remainingAsteriod(int[] asteroids) {

                Stack<Integer> stack = new Stack<>();

                for (int asteroid : asteroids) {

                    boolean destroyed = false;

                    while (!stack.isEmpty()
                            && stack.peek() > 0
                            && asteroid < 0) {

                        int top = stack.peek();

                        if (top < -asteroid) {
                            stack.pop();
                        }
                        else if (top == -asteroid) {
                            stack.pop();
                            destroyed = true;
                            break;
                        }
                        else {
                            destroyed = true;
                            break;
                        }
                    }

                    if (!destroyed) {
                        stack.push(asteroid);
                    }
                }

                int[] result = new int[stack.size()];

                for (int i = 0; i < stack.size(); i++) {
                    result[i] = stack.get(i);
                }

                return result;
            }
        }



