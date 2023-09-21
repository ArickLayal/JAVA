public class ReverseString {
    public static void main(String[] args) {
        String original = "Hello, World!";
        
        // Call the recursive reverseString method
        String reversed = reverseString(original);
        
        // Print the reversed string
        System.out.println(reversed);
    }
    
    public static String reverseString(String str) {
        // Base case: if the string is empty or has only one character, return it as is
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }
        
        // Reverse the substring from the second character to the end and append the first character
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
