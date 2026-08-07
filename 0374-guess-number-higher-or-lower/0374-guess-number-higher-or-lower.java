/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left=1;
        int right=n;
        
        while(left <= right){
            int mid=left+(right-left)/2;
            if(guess(mid) == 0){ // your guess is equal to the number I picked (i.e. num == pick)
                return mid;
            }
            else if(guess(mid) == 1){ // Your guess is lower than the number I picked (i.e. num < pick)
                left=mid+1;;
            }
            else{ // Your guess is higher than the number I picked (i.e. num > pick)
                right=mid-1;
            }
        }
        return 0;
    }
}